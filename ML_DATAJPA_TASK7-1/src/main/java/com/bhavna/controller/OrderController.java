package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bhavna.entity.Order;
import com.bhavna.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/home")
	public String home() {
		return "Hello";
	}

	@RequestMapping("/display")
	public String display() {
		String message = "hllo";
		return message;
	}

	@GetMapping("/order")
	public List<Order> getOrder() {
		return this.orderService.getOrder();
	}

	@GetMapping("/orderget/{id}")
	public Optional< Order> getOrderById(@PathVariable int id) {
		return this.orderService.getOrderById(id);
	}

	@PostMapping("/orderadd")
	public Order addOrder(@RequestBody Order employee) {
		return this.orderService.addOrder(employee);
	}

	@PutMapping("/orderupdate")
	public Order updateOrder(@RequestBody Order employee) {
		return this.orderService.updateOrder(employee);
	}

	@DeleteMapping("/orderdelete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		try {
			this.orderService.deleteOrder(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}