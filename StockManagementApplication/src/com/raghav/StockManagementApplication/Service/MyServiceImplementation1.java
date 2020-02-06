package com.raghav.StockManagementApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raghav.StockManagementApplication.Model.OrderDTO;
import com.raghav.StockManagementApplication.Model.ProductDTO;
import com.raghav.StockManagementApplication.Model.UserDTO;
import com.raghav.StockManagementApplication.dao.MyDAO;

@Component
public class MyServiceImplementation1 implements MyService{
	
	@Autowired
	MyDAO mdao;

	@Override
	public void addProduct(ProductDTO dto) {
		mdao.addProduct(dto);
		
	}

	@Override
	public List<ProductDTO> searchProduct(String product) {
		List<ProductDTO> plist =mdao.searchProduct(product);
		return plist;
	}

	@Override
	public boolean register(UserDTO dto) {
		return mdao.register(dto);
	}

	@Override
	public UserDTO login(UserDTO dto) {
		return mdao.login(dto);
	}

	@Override
	public List<ProductDTO> listOfProduct() {
		List<ProductDTO> plist = mdao.listOfProduct();
		return plist;
	}

	@Override
	public ProductDTO modify(int id) {
		return mdao.modify(id);
	}

	@Override
	public boolean modifyProduct(String name, String category, String company, Double price, int quantity) {
		return mdao.modifyProduct(name, category, company, price, quantity);
	}

	@Override
	public boolean deleteProduct(int id) {
		return mdao.deleteProduct(id);
	}

	@Override
	public ProductDTO addToCart(ProductDTO pdto) {
		ProductDTO pdto2 = mdao.addToCart(pdto);
		return pdto2;
	}

	@Override
	public ProductDTO cart(int id) {
		ProductDTO pdto = mdao.cart(id);
		return pdto;
	}

}
