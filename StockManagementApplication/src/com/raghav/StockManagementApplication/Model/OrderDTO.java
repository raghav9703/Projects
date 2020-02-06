package com.raghav.StockManagementApplication.Model;

import java.io.Serializable;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_info")
public class OrderDTO implements Serializable{

	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int orderid;
	private double totalPrice;
	private double totalPriceWithGst;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Order_History_Info",joinColumns = @JoinColumn(name="orderid"),inverseJoinColumns = @JoinColumn(name="pid") )
	 private List<ProductDTO> productlist ;
	
	 
	public List<ProductDTO> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<ProductDTO> productlist) {
		this.productlist = productlist;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalPriceWithGst() {
		return totalPriceWithGst;
	}
	public void setTotalPriceWithGst(double totalPriceWithGst) {
		this.totalPriceWithGst = totalPriceWithGst;
	}
	
}
