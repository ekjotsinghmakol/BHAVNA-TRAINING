package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.dao.OrderDao;
import com.bhavna.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao dao;

	@Override
	public List<Order> getOrder() {

		return (List<Order>) dao.findAll();
	}

	@Override
	public Optional<Order> getOrderById(int id) {

		return dao.findById(id);
	}

	@Override
	public Order addOrder(Order order) {

		return dao.save(order);
	}

	@Override
	public Order updateOrder(Order order) {

		return dao.save(order);
	}

	@Override
	public void deleteOrder(int id) {

		dao.deleteById(id);
	}

}
