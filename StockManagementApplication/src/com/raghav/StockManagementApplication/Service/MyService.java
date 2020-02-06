package com.raghav.StockManagementApplication.Service;

import java.util.List;

import com.raghav.StockManagementApplication.Model.OrderDTO;
import com.raghav.StockManagementApplication.Model.ProductDTO;
import com.raghav.StockManagementApplication.Model.UserDTO;

public interface MyService {
	public boolean register(UserDTO dto);
	public UserDTO login(UserDTO dto);
	void addProduct(ProductDTO dto);
	List<ProductDTO> searchProduct(String product);
	List<ProductDTO> listOfProduct();
	public ProductDTO modify(int id);
	public boolean modifyProduct(String name, String category, String company,Double price,int quantity);
	public boolean deleteProduct(int id);
	public ProductDTO addToCart(ProductDTO pdto);
	public ProductDTO cart(int id);
	
}
