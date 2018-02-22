package org.haozf.goods.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.coobird.thumbnailator.Thumbnails;

import org.haozf.mybatis.mapper.GoodsPicMapper;
import org.haozf.mybatis.model.GoodsPic;
import org.haozf.mybatis.model.GoodsPicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BackGoodsPicService {
    
    @Autowired
    GoodsPicMapper goodsPicMapper;

    @Value("${goods.goods.path}")
    String goodsPath;
    
    @Value("${goods.goods.url}")
    String goodsUrl;
    
    public List<GoodsPic> getGoodsPics(int goodsid){
        GoodsPicExample example = new GoodsPicExample();
        example.or().andGoodsidEqualTo(goodsid);
        return goodsPicMapper.selectByExample(example);
    }
    
    /**
     * 添加商品图片
     * @param goodsPic
     * @return
     */
    public int addGoodsPic(GoodsPic goodsPic){
        goodsPic.setAddtime(new Date());
        goodsPic.setPicurl(goodsUrl + goodsPic.getPicpath());
        goodsPicMapper.insertSelective(goodsPic);
        return 0;
    }
    
    /**
     * 删除商品图片
     * @param id
     */
    public void deleteGoodsPic(int id){
        goodsPicMapper.deleteByPrimaryKey(id);
    }
    
    
    /**
     * 删除商品图片
     * @param id
     */
    public void deleteGoodsPicByGoods(int id){
        
        GoodsPicExample example = new GoodsPicExample();
        example.or().andGoodsidEqualTo(id);
        List<GoodsPic> goodsPics = goodsPicMapper.selectByExample(example);
        for(GoodsPic goodsPic : goodsPics){
            goodsPicMapper.deleteByPrimaryKey(goodsPic.getId());
        }
        
    }
    
    /**
     * 处理商品封面
     * @param file
     * @return
     */
    public String goodsCover(MultipartFile file){
        String diskfileName = Calendar.getInstance().getTimeInMillis() + new Random().nextInt(10000) + ".jpg";
        
        File f = new File(goodsPath);
        if (!f.exists())
            f.mkdirs();
        
        String picPath = goodsPath + diskfileName;
        
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

}
