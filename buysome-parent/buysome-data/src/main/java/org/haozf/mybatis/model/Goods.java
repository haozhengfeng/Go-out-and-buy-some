package org.haozf.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private Integer id;

    private String title;

    private String goodscover;

    private String description;

    private Integer categorycode;

    private Integer shopid;

    private Integer hasgoods;

    private Integer status;

    private Integer isdelete;

    private Date addtime;

    private Integer picnum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getGoodscover() {
        return goodscover;
    }

    public void setGoodscover(String goodscover) {
        this.goodscover = goodscover == null ? null : goodscover.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(Integer categorycode) {
        this.categorycode = categorycode;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getHasgoods() {
        return hasgoods;
    }

    public void setHasgoods(Integer hasgoods) {
        this.hasgoods = hasgoods;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getPicnum() {
        return picnum;
    }

    public void setPicnum(Integer picnum) {
        this.picnum = picnum;
    }
}