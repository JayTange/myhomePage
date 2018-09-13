package com.wargod.domain.vo;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsVo {
    private Integer gid;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date goodsSeckillBegintime;

    private Date goodsSeckillEndtime;

    private String goodsDetail;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Date getGoodsSeckillBegintime() {
        return goodsSeckillBegintime;
    }

    public void setGoodsSeckillBegintime(Date goodsSeckillBegintime) {
        this.goodsSeckillBegintime = goodsSeckillBegintime;
    }

    public Date getGoodsSeckillEndtime() {
        return goodsSeckillEndtime;
    }

    public void setGoodsSeckillEndtime(Date goodsSeckillEndtime) {
        this.goodsSeckillEndtime = goodsSeckillEndtime;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "gid=" + gid +
                ", goodsName='" + goodsName + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsStock=" + goodsStock +
                ", goodsSeckillBegintime=" + goodsSeckillBegintime +
                ", goodsSeckillEndtime=" + goodsSeckillEndtime +
                ", goodsDetail='" + goodsDetail + '\'' +
                '}';
    }
}