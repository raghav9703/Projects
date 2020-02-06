package com.raghav.StockManagementApplication.Model;

import java.io.Serializable;
import java.util.List;

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
@Table(name="products_info")
public class ProductDTO implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int pid;
	private String pname;
	private String pcategory;
	
	private String company;
	private int quantity;
	private double price;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "Order_History_Info",joinColumns = @JoinColumn(name="pid"),inverseJoinColumns = @JoinColumn(name="orderid") )
	 private List<OrderDTO> orderlist ;
	 public List<OrderDTO> getOrderlist() {
			return orderlist;
		}
		public void setOrderlist(List<OrderDTO> orderlist) {
			this.orderlist = orderlist;
		}
	 
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
