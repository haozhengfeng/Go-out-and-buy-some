package org.haozf.goods.common;

import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.model.Goods;

public class GoodsJsonResult extends JsonResult{
    
    public Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

}
