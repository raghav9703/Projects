package com.ust.Mail_simulation.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ust.Mail_simulation.Model.EmailDTO;
import com.ust.Mail_simulation.Model.UserDTO;
import com.ust.Mail_simulation.Service.MyService;

@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpSession hs;
	
	@RequestMapping("/registeration")
	public String registeration() {
		return"registeration";
	}
	
	@RequestMapping("/login")
	public String login() {
		return"login";
	}
	
	@RequestMapping("/forget")
	public String forget() {
		return"forget";
	}
	
	@RequestMapping(value = "/RegisterationForm",method = RequestMethod.POST )
	public ModelAndView registerUser(@ModelAttribute UserDTO dto) {
		
		boolean b =  ms.register(dto);
		if (b) {
			return new ModelAndView("login", "register", "Register Successful");
		} else {
			return new ModelAndView("registeration", "register", "Register failed");

		}
	}
	
	@RequestMapping(value = "/LogionForm",method = RequestMethod.POST )
	public ModelAndView loginUser(@ModelAttribute UserDTO dto ) {
		UserDTO udto = ms.login(dto);
		if (udto!= null ) {
			hs=req.getSession();
			
			hs.setAttribute("email", dto.getEmail());
			return new ModelAndView("homePage", "udto", udto);
			
		} else {
			return new ModelAndView("login", "login", "Invalid email id or password");

		}
	}
	
	@RequestMapping("/compose")
	public ModelAndView compose() {
		if(hs.getAttribute("email")!= null) {
			return new ModelAndView("compose");
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
		
	}
	
	
	@RequestMapping(value = "/composeEmail",method = RequestMethod.POST)
	public ModelAndView composeEmail() {
		if (hs.getAttribute("email")!= null) {
		boolean b = ms.composeEmail();
		if (b) {
			return new ModelAndView("homePage", "msg", "Email Send Successfully");
			
		} else {
			return new ModelAndView("homePage", "msg1", "Error saved to draft");

		}
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		
		if (hs.getAttribute("email")!= null) {
			hs.setAttribute("email", null);
			return new ModelAndView("login", "logout", "Logout successful");
			
		} else {
			return new ModelAndView("login", "logout", "login first");

		}
	}
	
	
	@RequestMapping("/inbox")
	public ModelAndView inbox() {			
		if (hs.getAttribute("email")!= null) {
			List<EmailDTO > elist = ms.inbox();
			return new ModelAndView("inbox", "elist", elist);
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
				
	}
	
	@RequestMapping("/draft")
	public ModelAndView draft() {
		if (hs.getAttribute("email")!= null) {
		List<EmailDTO > elist = ms.draft();
		return new ModelAndView("draft", "elist", elist);
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
	}
	
	@RequestMapping("/sent")
	public ModelAndView sent() {
		if (hs.getAttribute("email")!= null) {
		List<EmailDTO > elist = ms.sent();
		return new ModelAndView("sent", "elist", elist);
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
	}
	
	@RequestMapping(value = "/ForgetConfirm",method = RequestMethod.POST)
	public ModelAndView forgetPassword2(@RequestParam String password1,String password2) {
		  boolean b=ms.forgetPassword2(password1, password2);
		  if(b) {
		  return new ModelAndView("login","pass","Password Changed Successfully");
		  }else {
			  return new ModelAndView("forget2","pass","Invalid details or worng password");
		  }
		
	}
	
	@RequestMapping(value = "/ForgetPassword",method = RequestMethod.POST)
	public ModelAndView forgetPassword(@RequestParam String email, String question, String answer) {
		boolean b = ms.forgotPassword(email, question, answer);
		if(b) {
			hs.setAttribute("email", email);
			  return new ModelAndView("forget2");
			  }else {
				  return new ModelAndView("forget","forget","Invalid details...");
			  }
	}
	
	@RequestMapping("/change")
	public ModelAndView change() {
		if (hs.getAttribute("email")!= null) {
		return new ModelAndView("change");
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
	}
	
	@RequestMapping(value = "/changePassword",method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam String oldpass, String npass1, String npass2) {
		boolean b = ms.changePassword(oldpass, npass1, npass2);
		 if(b) {
			  return new ModelAndView("homePage","pass","Password Changed Successfully");
			  }else {
				  return new ModelAndView("change","pass","Invalid details or worng password");
			  }
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteMail(@RequestParam int id) {
		boolean b = ms.deleteMail(id);
		if (b) {
			return new ModelAndView("homePage","delete","Deleted successfully");
			
		} else {
			return new ModelAndView("homePage","delete1","Deletion failed");
		}
	}
	
	@RequestMapping("/deletem")
	public ModelAndView deleteMail() {
		if (hs.getAttribute("email")!= null) {
		List<EmailDTO > elist = ms.deletedMail();
		return new ModelAndView("delete", "elist", elist);
		}
		else {
			return new ModelAndView("login","msg","Login First");
		}
	
	}
	
	@RequestMapping("/draftm")
	public ModelAndView draftm(@RequestParam int id) {
		EmailDTO elist = ms.draftm( id);
		hs.setAttribute("eid", elist.getEid());
		return new ModelAndView("composedraft","elist",elist);
		
	}
	
	@RequestMapping("/hsent")
	public ModelAndView showSent(@RequestParam int id) {
		EmailDTO elist = ms.showSent(id);
		return new ModelAndView("showsent","elist",elist);
		
	} 
	
	@RequestMapping("/hinbox")
	public ModelAndView showInbox(@RequestParam int id) {
		EmailDTO elist = ms.showInbox(id);
		return new ModelAndView("showinbox","elist",elist);
		
	}
	
	@RequestMapping(value = "/composeDraft" ,method = RequestMethod.POST)
	public ModelAndView composeDraft(@RequestParam String to, String message, String subject) {
		hs=req.getSession(false);
		boolean b = ms.composeDraft(to, message, subject);
		if (b) {
			return new ModelAndView("homePage", "msg", "Email Send Successfully");
			
		} else {
			return new ModelAndView("homePage", "msg", "Error saved to draft");

		}
	
	
	}
	
	}
