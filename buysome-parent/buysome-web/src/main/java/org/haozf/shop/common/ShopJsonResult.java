package org.haozf.shop.common;

import java.util.List;

import org.haozf.mybatis.common.JsonResult;
import org.haozf.mybatis.model.Shop;

public class ShopJsonResult extends JsonResult{
    
    public List<Shop> shops;

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
