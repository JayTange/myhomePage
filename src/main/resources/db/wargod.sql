CREATE DATABASE IF NOT EXISTS wargod default character set utf8 collate utf8_general_ci;

USE wargod;

-- 用户信息表
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
  uid INT AUTO_INCREMENT COMMENT '用户自增ID',
  user_name VARCHAR(100) NOT NULL COMMENT '用户名' ,
  user_password VARCHAR(100)  NOT NULL COMMENT '密码',
  phone_number VARCHAR(22) NOT NULL COMMENT '电话号码',
  created_time TIMESTAMP DEFAULT current_timestamp NOT NULL COMMENT '创建时间',
  modified_time TIMESTAMP DEFAULT current_timestamp NOT NULL COMMENT '修改时间',

  PRIMARY KEY (uid)
);

-- 商品表
DROP TABLE IF EXISTS t_goods;
CREATE TABLE t_goods(
  gid INT AUTO_INCREMENT COMMENT '商品ID',
  goods_name VARCHAR(16) DEFAULT NULL COMMENT '商品名称',
  goods_title VARCHAR(64) DEFAULT NULL COMMENT '商品标题',
  goods_img VARCHAR(64) DEFAULT NULL COMMENT '商品的图片',
  goods_detail TEXT DEFAULT NULL COMMENT '商品的详情介绍',
  goods_price DECIMAL(10,2) DEFAULT 0.00 COMMENT '商品单价',
  goods_stock INT DEFAULT 0 COMMENT '商品库存，-1表示没有限制',
  goods_seckill_begintime TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  goods_seckill_endtime TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  PRIMARY KEY (gid)
);

-- 订单信息表
DROP TABLE IF EXISTS t_order_info;
CREATE TABLE t_order_info (
  oid INT(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  order_num VARCHAR(50) not NULL COMMENT '订单号',
  user_id INT DEFAULT NULL COMMENT '用户ID',
  goods_id INT DEFAULT NULL COMMENT '商品ID',
  delivery_addr_id INT DEFAULT NULL COMMENT '收货地址ID',
  goods_name VARCHAR(16) NOT NULL COMMENT '商品名称',
  goods_count INT NOT NULL COMMENT '商品数量',
  goods_price DECIMAL(10,2) DEFAULT 0.00 COMMENT '商品单价',
  status INT DEFAULT 0 COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
  pay_time TIMESTAMP NOT NULL COMMENT '支付时间',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp,
  PRIMARY KEY (oid)
);