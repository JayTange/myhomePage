package com.wargod.domain.dto;

import com.wargod.constant.SeckillStatEnum;
import com.wargod.domain.vo.OrderInfoVo;


public class SeckillExcution {

    private long seckillId;

    private int state;

    private String stateInfo;

    private OrderInfoVo orderInfoVo;


    public SeckillExcution(long seckillId, SeckillStatEnum statEnum,  OrderInfoVo orderInfoVo) {

        this.seckillId = seckillId;

        this.state = statEnum.getState();

        this.stateInfo = statEnum.getStateInfo();

        this.orderInfoVo = orderInfoVo;

    }

    //秒杀失败

    public SeckillExcution(long seckillId, SeckillStatEnum statEnum) {

        this.seckillId = seckillId;

        this.state = statEnum.getState();

        this.stateInfo = statEnum.getStateInfo();

    }


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public OrderInfoVo getOrderInfoVo() {
        return orderInfoVo;
    }

    public void setOrderInfoVo(OrderInfoVo orderInfoVo) {
        this.orderInfoVo = orderInfoVo;
    }
}
