package org.haozf.goods.common;

import java.util.List;

import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.model.Goods;

public class GoodsJsonResult extends JsonResult{
    
    public List<Goods> goods;

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}


}
