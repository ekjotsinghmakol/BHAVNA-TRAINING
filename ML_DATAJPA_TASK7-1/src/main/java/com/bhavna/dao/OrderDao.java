package com.bhavna.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.entity.Order;

@Repository
public interface OrderDao extends CrudRepository<Order,Integer> {

}
