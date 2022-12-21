package com.bhavna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Orders")
public class Order {
	@Id
	private Integer orderId;
	private String orderCategory;
	private String orderDate;
	private String deliveryDate;
	private String orderStatus;

	public Order() {
	}

	public Order(int orderId, String orderCategory, String orderDate, String deliveryDate, String orderStatus) {

		this.orderId = orderId;
		this.orderCategory = orderCategory;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
