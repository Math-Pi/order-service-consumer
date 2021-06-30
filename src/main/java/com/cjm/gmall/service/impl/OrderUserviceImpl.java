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
 * 1���������ṩ��ע�ᵽע������
 * 		1������dubbo������2.6.2��������zookeeper�Ŀͻ�������(curator)
 * 		2�����÷����ṩ��
 * 2���÷���������ȥע�����Ķ��ķ����ṩ�ߵķ����ַ
 * @author �¼���
 *
 */
@Service
public class OrderUserviceImpl implements OrderService{

	
	@Autowired
	private UserService userService;
	
	public void initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("�û�id��"+userId);
		//1����ѯ�û����ջ���ַ
		List<UserAddress> addressList= userService.getUserAddressList(userId);
		System.out.println(addressList);
		for(UserAddress userAddress:addressList) {
			System.out.println(userAddress.getUserAddress());
		}
	}

	
}
