package org.haozf.goods.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.coobird.thumbnailator.Thumbnails;

import org.haozf.mybatis.mapper.GoodsMapper;
import org.haozf.mybatis.mapper.ShopMapper;
import org.haozf.mybatis.model.Admin;
import org.haozf.mybatis.model.Goods;
import org.haozf.mybatis.model.GoodsExample;
import org.haozf.mybatis.model.Shop;
import org.haozf.mybatis.model.ShopExample;
import org.haozf.mybatis.service.GoodsService;
import org.haozf.security.manager.SecurityManager;
import org.haozf.security.model.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BackGoodsService extends GoodsService{
    
    @Autowired
    SecurityManager<Realm> securityManager;
    
    @Autowired
    GoodsMapper goodsMapper;
    
    @Autowired
    ShopMapper shopMapper;
    
    @Value("${goods.goodsCover.path}")
    String goodsCoverPath;
    
    @Value("${goods.goodsCover.url}")
    String goodsCoverUrl;
    
    public Goods getGoods(int id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        goods.setGoodscover(goodsCoverUrl + goods.getGoodscover());
        return goods;
    }
    
    public List<Goods> listGoods(Goods goods) {
        GoodsExample example = new GoodsExample();
        example.or().andIsdeleteEqualTo(0);
        List<Goods> goodss = goodsMapper.selectByExample(example);
        return goodss;
    }
    
    
    /**
     * 添加店铺封面
     * @param file
     * @return
     */
    public String addGoodsCover(MultipartFile file){
        if (file!=null&&!file.isEmpty()) {  
            return goodsCover(file);
        }
        return null;
    }
    
    /**
     * 处理商品封面
     * @param file
     * @return
     */
    public String goodsCover(MultipartFile file){
        String diskfileName = Calendar.getInstance().getTimeInMillis() + new Random().nextInt(10000) + ".jpg";
        
        File f = new File(goodsCoverPath);
        if (!f.exists())
            f.mkdirs();
        
        String picPath = goodsCoverPath + diskfileName;
        
        try {
            // 转存文件
            file.transferTo(new File(picPath));

            //图片进行压缩
            Thumbnails.of(picPath)   
                        .size(400, 300)  
                        .toFile(picPath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return diskfileName;
    }
    
    /**
     * 添加商品
     */
    public int addGoods(Goods goods){
        
        //后台验证
        if(goods.getTitle()==null||"".equals(goods.getTitle().trim())) throw new RuntimeException("请输入商品名称");
        if(goods.getGoodscover()==null||"".equals(goods.getGoodscover().trim())) throw new RuntimeException("请输入商品封面");
        if(goods.getDescription()==null||"".equals(goods.getDescription().trim())) throw new RuntimeException("请输入商品描述");
        if(goods.getHasgoods()==null) throw new RuntimeException("请选择是否有货");
        if(goods.getShopid()==null) throw new RuntimeException("店主为空");
        if(goods.getCategorycode()==null) throw new RuntimeException("请选择商品分类");
        
        //判断用户是否开店
        
        Admin admin = (Admin)securityManager.getSubject().getMember();
        if(admin.getShopid()==null) throw new RuntimeException("请开通店铺");
        
        Shop shopByAdmin = getShopByAdmin(admin.getId());
        if(shopByAdmin == null) throw new RuntimeException("请开通店铺");
        
        //获取店铺商品数量
        List<Goods> goodsShop = getGoodsShop(shopByAdmin.getId());
        if(goodsShop.size()>=shopByAdmin.getGoodsnum()) throw new RuntimeException("店铺商品已达上线");
        
        goods.setAddtime(new Date());
        super.addGoods(goods);
        
        return goods.getId();
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
     * 获取店铺商品
     * @return 
     */
    public List<Goods> getGoodsShop(int shopid){
        GoodsExample example = new GoodsExample();
        example.or().andShopidEqualTo(shopid).andIsdeleteEqualTo(0);
        return goodsMapper.selectByExample(example);
    }
    
    /**
	 * 删除商品
	 * @param shop
	 */
	public void deleteGoods(Goods goods){
		goods = super.getGoods(goods.getId());
        if(goods == null) return;
        
        //删除更新字段
        goods.setIsdelete(1);
        super.updateGoods(goods);
    }
	
	/**
	 * 上架下架商品
	 * @param shop
	 */
	public void statusGoods(Goods goods){
		goods = super.getGoods(goods.getId());
        if(goods == null) return;
        if(goods.getStatus()==0){
        	goods.setStatus(1);
        }else {
        	goods.setStatus(0);
        }
        super.updateGoods(goods);
    }
	
	public long total(){
    	GoodsExample example = new GoodsExample();
    	example.or().andIsdeleteEqualTo(0);
    	return goodsMapper.countByExample(example);
    }
	
	/**
     * 商品修改
     */
    public int updateGoods(Goods goods){
        
        Goods tgoods = super.getGoods(goods.getId());
        
        //后台验证
        if(goods.getTitle()!=null&&!"".equals(goods.getTitle().trim())) tgoods.setTitle(goods.getTitle());
        if(goods.getGoodscover()!=null&&!"".equals(goods.getGoodscover().trim())){
            File f = new File(goodsCoverPath + tgoods.getGoodscover());
            f.deleteOnExit();
            tgoods.setGoodscover(goods.getGoodscover());
        } 
        if(goods.getDescription()!=null&&!"".equals(goods.getDescription().trim())) tgoods.setDescription(goods.getDescription());
        
        return super.updateGoods(tgoods);
    }
}
