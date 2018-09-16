package com.wargod.domain.dto;

import com.wargod.constant.SeckillStatEnum;
import com.wargod.domain.vo.OrderInfoVo;

/**
 * ��װ��ɱִ�к�Ľṹ
 */
public class SeckillExcution {

    private long seckillId;

    // ��ɱִ�нṹ
    private int state;

    // ״̬��ʾ
    private String stateInfo;

    private OrderInfoVo orderInfoVo;

    //��ɱ�ɹ�����������Ϣ

    public SeckillExcution(long seckillId, SeckillStatEnum statEnum,  OrderInfoVo orderInfoVo) {

        this.seckillId = seckillId;

        this.state = statEnum.getState();

        this.stateInfo = statEnum.getStateInfo();

        this.orderInfoVo = orderInfoVo;

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
