package com.raghav.StockManagementApplication.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import com.raghav.StockManagementApplication.Model.OrderDTO;
import com.raghav.StockManagementApplication.Model.ProductDTO;
import com.raghav.StockManagementApplication.Model.UserDTO;

@Component
public class MyDAOImplementation1 implements MyDAO{
	
	@Autowired
	SessionFactory sf;
	@Autowired
	HttpSession hs;
	

	@Override
	public void addProduct(ProductDTO dto) {
		Session ss=sf.openSession();
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();
		
	}

	@Override
	public List<ProductDTO> searchProduct(String product) {
		Session ss=sf.openSession();
		Criteria cr = ss.createCriteria(ProductDTO.class);
		Criterion prdct =  Restrictions.ilike("pname", product,MatchMode.ANYWHERE);
		Criterion pcategory = Restrictions.ilike("pcategory", product, MatchMode.ANYWHERE);
		Criterion company =  Restrictions.ilike("company", product, MatchMode.ANYWHERE);
		Criterion or = Restrictions.disjunction().add(prdct).add(pcategory).add(company);
		cr.add(or);
		List<ProductDTO> plist = cr.list();
		ss.close();
		
		return plist;
		
	}

	@Override
	public boolean register(UserDTO dto) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", dto.getEmail()));
		UserDTO udto = (UserDTO) cr.uniqueResult();
		if (udto!= null) {
			return false;
			
		} else {
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
	}
	
	}

	@Override
	public UserDTO login(UserDTO dto) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", dto.getEmail()));
		cr.add(Restrictions.eq("password", dto.getPassword()));
		UserDTO udto =(UserDTO) cr.uniqueResult();
		ss.close();
		return udto;
	}

	@Override
	public List<ProductDTO> listOfProduct() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(ProductDTO.class);
		List<ProductDTO> plist = cr.list();
		return plist;
	}

	@Override
	public ProductDTO modify(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", id));
		ProductDTO pdto = (ProductDTO) cr.uniqueResult();
		return pdto;
	}

	@Override
	public boolean modifyProduct(String name, String category, String company, Double price, int quantity) {
		Session ss = sf.openSession();
		int id = (int) hs.getAttribute("pid");
		Criteria cr = ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", id));
		ProductDTO pdto = (ProductDTO) cr.uniqueResult();
		if(pdto != null) {
		pdto.setPname(name);
		pdto.setPcategory(category);
		pdto.setPrice(price);
		pdto.setCompany(company);
		pdto.setQuantity(quantity);
		ss.save(pdto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
		}
		else {
			ss.close();
			return false;
			
		}		
	}

	@Override
	public ProductDTO cart(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", id));
		ProductDTO pdto = (ProductDTO) cr.uniqueResult();
		
		return pdto;
	}

	@Override
	public boolean deleteProduct(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", id));
		ProductDTO pdto = (ProductDTO) cr.uniqueResult();
		if(pdto != null) {
			ss.delete(pdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
			}
			else {
				ss.close();
				return false;
				
			}
		
		
		
	}

	@Override
	public ProductDTO addToCart(ProductDTO pdto) {
		Session ss = sf.openSession();
		ProductDTO pdto2 = ss.load(ProductDTO.class, pdto.getPid());
		OrderDTO odto = new OrderDTO();
		 
		if ((pdto2.getQuantity()-pdto.getQuantity())>=0) {
		double totalPrice =pdto2.getPrice()*pdto.getQuantity();
		odto.setTotalPrice(totalPrice);
		Double gst = (totalPrice*0.18)+ totalPrice;
		odto.setTotalPriceWithGst(gst);
		pdto2.setQuantity(pdto2.getQuantity()-pdto.getQuantity());
		List<OrderDTO> olist =pdto2.getOrderlist();
		olist.add(odto);
		ss.saveOrUpdate(pdto2);
		ss.beginTransaction().commit();
		
		return pdto2;
		}
		else {
			return null;
		}
	}
	


}
