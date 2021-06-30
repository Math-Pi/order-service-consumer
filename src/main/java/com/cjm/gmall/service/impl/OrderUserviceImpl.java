package com.cjm.gmall.service.impl;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.cjm.gmall.bean.UserAddress;
import com.cjm.gmall.service.OrderService;
import com.cjm.gmall.service.UserService;

/**
 * 1、将服务提供者注册到注册中心
 * 		1）导入dubbo依赖（2.6.2）、操作zookeeper的客户端依赖(curator)
 * 		2）配置服务提供者
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author 陈嘉名
 *
 */
@Service
public class OrderUserviceImpl implements OrderService{

	
	@Autowired
	private UserService userService;
	
	public void initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList= userService.getUserAddressList(userId);
		System.out.println(addressList);
		for(UserAddress userAddress:addressList) {
			System.out.println(userAddress.getUserAddress());
		}
	}

	
}
