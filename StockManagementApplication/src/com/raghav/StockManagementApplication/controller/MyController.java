package com.raghav.StockManagementApplication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raghav.StockManagementApplication.Model.OrderDTO;
import com.raghav.StockManagementApplication.Model.ProductDTO;
import com.raghav.StockManagementApplication.Model.UserDTO;
import com.raghav.StockManagementApplication.Service.MyService;

@RequestMapping("/")
@Component
public class MyController {
	
	@Autowired
	MyService ms;
	@Autowired
	HttpSession hs;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/LogionForm",method = RequestMethod.POST )
	public ModelAndView loginUser(@ModelAttribute UserDTO dto ) {
		UserDTO udto = ms.login(dto);
		if (udto!= null ) {
			hs.setAttribute("email", dto.getEmail());
			return new ModelAndView("homePage", "udto", udto);
			
		} else {
			return new ModelAndView("login", "login", "Invalid email id or password");

		}
	}
	
	
	@RequestMapping("/registeration")
	public String registeration() {
		return "registeration";
	}
	
	@RequestMapping(value = "/RegisterationForm",method = RequestMethod.POST )
	public ModelAndView registerUser(@ModelAttribute UserDTO dto) {
		
		boolean b =  ms.register(dto);
		if (b) {
			return new ModelAndView("login", "success", "Register Successful");
		} else {
			return new ModelAndView("registeration", "fail", "Register failed");

		}
	}
	
	
	
	
	@RequestMapping("/addproduct")
	public ModelAndView showProductForm() {
		if (hs.getAttribute("email")!= null) {
		return new ModelAndView( "addProduct");
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
	}
	
	@RequestMapping(value="/AddProduct",method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute ProductDTO dto) {
		if (hs.getAttribute("email")!= null) {
			ms.addProduct(dto);
			
			return new ModelAndView("homePage","add","Product added successfully");
			
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
		
	}
		
	
		@RequestMapping("/SearchProduct")
		public ModelAndView SearchProduct(@RequestParam String product) {
			if (hs.getAttribute("email")!= null) {
				List<ProductDTO> plist = ms.searchProduct(product);
				return new ModelAndView("viewProduct","plist", plist);
			}
			else {
				return new ModelAndView("login","msg","Login First");
			}
			
		
	}
		
		@RequestMapping("/view")
		public ModelAndView update() {
			if (hs.getAttribute("email")!= null) {
				List<ProductDTO> plist = ms.listOfProduct();
				return new ModelAndView("update","plist",plist);
			}
			else {
				return new ModelAndView("login","msg","Login First");
			}
			
		}
		
		
		@RequestMapping("/modify")
		public ModelAndView modify(@RequestParam int id) {
			if (hs.getAttribute("email")!= null) {
				ProductDTO pdto = ms.modify(id);
				hs.setAttribute("pid", pdto.getPid());
				return new ModelAndView("modify","pdto",pdto) ;
			}
			else {
				return new ModelAndView("login","msg","Login First");
			}
			
		}
		
		@RequestMapping(value="/modifyProduct",method = RequestMethod.POST)
		public ModelAndView modifyProduct(@RequestParam String name, String category, String company,Double price,int quantity) {
		boolean b =ms.modifyProduct(name, category, company, price, quantity);
		if (hs.getAttribute("email")!= null) {
			if (b) {
				return new ModelAndView("homePage","update","Updated successfully");
				
				
			} else {
				return new ModelAndView("homePage","error","error occured");

			}
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
		
		}
		
		@RequestMapping("/delete")
		public ModelAndView delete(@RequestParam int id) {
			if (hs.getAttribute("email")!= null) {
				boolean b = ms.deleteProduct(id);
				if (b) {
					return new ModelAndView("homePage","delete","Deleted Successful");
					
					
				} else {
					return new ModelAndView("homePage","error","Error Occured");

				}
				
			}
			 else {
					return new ModelAndView("login", "msg", "login first");

				}
			
		}
		
		@RequestMapping("/logout")
		public ModelAndView logout() {
			
			if (hs.getAttribute("email")!= null) {
				hs.setAttribute("email", null);
				return new ModelAndView("login", "logout", "Logout successful");
				
			} else {
				return new ModelAndView("login", "msg", "login first");

			}
		}
		
		@RequestMapping("/cartPage")
		public ModelAndView cart(@RequestParam int id) {
			if (hs.getAttribute("email")!= null) {
				ProductDTO pdto = ms.cart(id);
				return new ModelAndView("cart", "pdto",pdto);
				
		} else {
			return new ModelAndView("login", "msg", "login first");

		}
		}
		
		@RequestMapping(value="/addToCart",method = RequestMethod.POST)
		public ModelAndView addToCart(@ModelAttribute ProductDTO pdto) {
			ProductDTO pdto2= ms.addToCart(pdto);
			List<OrderDTO> olist = pdto2.getOrderlist();
			if (pdto2!=null) {
				return new ModelAndView("showCart","pdto2",pdto2);
			} else {
				return new ModelAndView("homePage","cart2","out of stock");
			}
			
		}
		

}
