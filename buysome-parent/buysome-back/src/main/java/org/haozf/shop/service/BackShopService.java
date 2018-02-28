package org.haozf.shop.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.coobird.thumbnailator.Thumbnails;

import org.haozf.mybatis.mapper.AdminMapper;
import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;
import org.haozf.mybatis.model.ShopExample.Criteria;
import org.haozf.mybatis.service.ShopService;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BackShopService extends ShopService{

	@Autowired
    SecurityManager<Realm> securityManager;
	
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	
	@Value("${shop.shopCover.path}")
	String shopCoverPath;
	
	@Value("${shop.shopCover.url}")
	String shopCoverUrl;
	
	@Value("${shop.qrcode.path}")
	String qrcodePath;
	
	@Value("${shop.qrcode.url}")
	String qrcodeUrl;
	
	public Shop getShop(int id){
		Shop shop = shopMapper.selectByPrimaryKey(id);
		shop.setShopcover(shopCoverUrl + shop.getShopcover());
		shop.setQrcode(qrcodeUrl + shop.getQrcode());
        return shop;
    }
	
	
	/**
	 * 店铺列表
	 */
	public List<Shop> listShop(Shop shop) {
		
		Realm subject = securityManager.getSubject();
        Admin sAdmin = (Admin)subject.getMember();
        
        ShopExample example = new ShopExample();
        example.setOrderByClause("addtime desc");
        
        //超级管理员显示所有  
        //管理员查询当前管理员和用户
        //用户查询用户
        if(sAdmin.getRoleid()==0){
            example.or().andIsdeleteEqualTo(0);
        }else if (sAdmin.getRoleid()==1) {
            example.or().andAdminidEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
        }else{
        	example.or().andAdminidEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
        }
        
        List<Shop> shops = shopMapper.selectByExample(example);
		
		return shops;
	}
	
	/**
	 * 通过店主获取店铺
	 * @param adminid
	 * @return
	 */
	public Shop getShopByAdmin(int adminid){
		ShopExample example = new ShopExample();
		example.or().andAdminidEqualTo(adminid);
		List<Shop> shops = shopMapper.selectByExample(example);
		if(shops.size()==1){
			return shops.get(0);
		}else if(shops.size()==0){
			return null;
		}else{
			throw new RuntimeException("用户店铺数量异常");
		}
	}
	
	/**
	 * 通过店铺名称获取店铺
	 * @param name
	 * @return
	 */
	public Shop getShopByName(Shop shop){
		ShopExample example = new ShopExample();
		
		Criteria or = example.or();
		or.andNameEqualTo(shop.getName());
		
		if(shop.getId()!=null){
		    or.andIdNotEqualTo(shop.getId());
		}
		
		List<Shop> shops = shopMapper.selectByExample(example);
		if(shops.size()==1){
			return shops.get(0);
		}else if(shops.size()==0){
			return null;
		}else{
			throw new RuntimeException("用户店铺数量异常");
		}
	}
	
	/**
	 * 开通店铺
	 */
	public int addShop(Shop shop){
		
		//后台验证
		if(shop.getName()==null||"".equals(shop.getName().trim())) throw new RuntimeException("请输入店铺名称");
		if(shop.getShopcover()==null||"".equals(shop.getShopcover().trim())) throw new RuntimeException("请输入店铺封面");
		if(shop.getDescription()==null||"".equals(shop.getDescription().trim())) throw new RuntimeException("请输入店铺描述");
		if(shop.getLocation()==null||"".equals(shop.getLocation().trim())) throw new RuntimeException("请输入店铺位置");
		if(shop.getLon()==null||shop.getLat()==null) throw new RuntimeException("请输入店铺位置");
		if(shop.getAdminid()==null) throw new RuntimeException("店主为空");
		
		//判断用户是否开店
		Shop shopByAdmin = getShopByAdmin(shop.getAdminid());
		if(shopByAdmin != null){
			throw new RuntimeException("用户已开通店铺");
		}
		
		//判断店铺名称是否存在
		Shop shopByName = getShopByName(shop);
		if(shopByName != null){
			throw new RuntimeException("店铺名称已存在");
		}
		
		shop.setAddtime(new Date());
        super.addShop(shop);
        
        updateAdminShopid(shop.getAdminid(), shop.getId());
        
        return shop.getId();
    }
	
	/**
	 * 更新管理员的店铺
	 * @param adminid
	 * @param shopid
	 */
	public void updateAdminShopid(int adminid,int shopid){
		Admin admin = adminMapper.selectByPrimaryKey(adminid);
		admin.setShopid(shopid);
		adminMapper.updateByPrimaryKey(admin);
	}
	
	/**
	 * 添加店铺封面
	 * @param file
	 * @return
	 */
	public String addShopCover(MultipartFile file){
		if (file!=null&&!file.isEmpty()) {  
        	return shopCover(file);
        }
		return null;
	}
	
	/**
	 * 处理店铺封面
	 * @param file
	 * @return
	 */
	public String shopCover(MultipartFile file){
		String diskfileName = Calendar.getInstance().getTimeInMillis() + new Random().nextInt(10000) + ".jpg";
		
        File f = new File(shopCoverPath);
        if (!f.exists())
            f.mkdirs();
        
        String picPath = shopCoverPath + diskfileName;
        
		try {
			// 转存文件
			file.transferTo(new File(picPath));

			//图片进行压缩
			Thumbnails.of(picPath)   
				        .size(800, 600)  
				        .toFile(picPath);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return diskfileName;
	}
	
	/**
	 * 添加二维码
	 * @param file
	 * @return
	 */
	public String addQrcode(MultipartFile file){
		if (file!=null&&!file.isEmpty()) {  
        	return qrcode(file);
        }
		return null;
	}
	
	/**
	 * 处理二维码
	 * @param file
	 * @return
	 */
	public String qrcode(MultipartFile file){
		String diskfileName = Calendar.getInstance().getTimeInMillis() + new Random().nextInt(10000) + ".jpg";
		
        File f = new File(qrcodePath);
        if (!f.exists())
            f.mkdirs();
        
        String picPath = qrcodePath + diskfileName;
        
		try {
			// 转存文件
			file.transferTo(new File(picPath));

			//图片进行压缩
			Thumbnails.of(picPath)   
				        .size(800, 600)  
				        .toFile(picPath);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return diskfileName;
	}
	
	/**
	 * 删除店铺
	 * @param shop
	 */
	public void deleteShop(Shop shop){
        shop = super.getShop(shop.getId());
        if(shop == null) return;
        
        //店铺下有商品不能删除店铺
        List<Goods> shopGoods = getShopGoods(shop.getId());
        if(shopGoods.size()>0) throw new RuntimeException("店铺下有商品不能删除");
        
        //删除更新字段
        shop.setIsdelete(1);
        super.updateShop(shop);
    }
	
	/**
	 * 获取店铺下的商品
	 * @param shopid
	 * @return 
	 */
	public List<Goods> getShopGoods(int shopid){
		GoodsExample example = new GoodsExample();
		example.or().andShopidEqualTo(shopid);
		return goodsMapper.selectByExample(example);
	}
	
	
	/**
	 * 上架下架商品
	 * @param shop
	 */
	public void statusShop(Shop shop){
		shop = super.getShop(shop.getId());
        if(shop == null) return;
        if(shop.getStatus()==0){
        	shop.setStatus(1);
        }else {
        	shop.setStatus(0);
        }
        super.updateShop(shop);
    }
	
	/**
	 * 店铺修改
	 */
	public int updateShop(Shop shop){
	    
	    Shop tshop = super.getShop(shop.getId());
	    
	    //后台验证
        if(shop.getName()!=null&&!"".equals(shop.getName().trim())) tshop.setName(shop.getName());
        if(shop.getQrcode()!=null&&!"".equals(shop.getQrcode().trim())){
            File f = new File(qrcodePath + tshop.getQrcode());
            f.deleteOnExit();
            tshop.setQrcode(shop.getQrcode());
        } 
        if(shop.getShopcover()!=null&&!"".equals(shop.getShopcover().trim())){
            File f = new File(shopCoverPath+tshop.getShopcover());
            f.deleteOnExit();
            tshop.setShopcover(shop.getShopcover());
        } 
        if(shop.getDescription()!=null&&!"".equals(shop.getDescription().trim())) tshop.setDescription(shop.getDescription());
        if(shop.getLocation()!=null&&!"".equals(shop.getLocation().trim())) tshop.setLocation(shop.getLocation());
        if(shop.getLon()!=null&&!"".equals(shop.getLon().trim())) tshop.setLon(shop.getLon());
        if(shop.getLat()!=null&&!"".equals(shop.getLat().trim())) tshop.setLat(shop.getLat());
	    
	    //判断店铺名称是否存在
        Shop shopByName = getShopByName(shop);
        if(shopByName != null){
            throw new RuntimeException("店铺名称已存在");
        }
	    
        return super.updateShop(tshop);
    }
	
	public long total(){
	    
	    Realm subject = securityManager.getSubject();
        Admin sAdmin = (Admin)subject.getMember();
	    
    	ShopExample example = new ShopExample();
    	
    	if(sAdmin.getRoleid()==0){
            example.or().andIsdeleteEqualTo(0);
        }else if (sAdmin.getRoleid()==1) {
            example.or().andAdminidEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
        }else{
            example.or().andAdminidEqualTo(sAdmin.getId()).andIsdeleteEqualTo(0);
        }
    	
    	return shopMapper.countByExample(example);
    }
}
