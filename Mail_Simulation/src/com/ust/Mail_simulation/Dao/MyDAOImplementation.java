package com.ust.Mail_simulation.Dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.Mail_simulation.Model.EmailDTO;
import com.ust.Mail_simulation.Model.UserDTO;


@Component
public class MyDAOImplementation implements MyDAO{
	
	@Autowired
	SessionFactory sf;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpSession hs;


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
	public boolean composeEmail() {
		Session ss = sf.openSession();
		String to = req.getParameter("to");
		String message = req.getParameter("message");
		String subject = req.getParameter("subject");
		this.hs = req.getSession(false);
		String from = (String) hs.getAttribute("email");
		EmailDTO edto=null;
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", to));
		UserDTO udto = (UserDTO) cr.uniqueResult();
		
		if (udto != null) {
			edto=new EmailDTO();
			edto.setMessage(message);
			edto.setSubject(subject);
			edto.setSendto(to);
			edto.setSendby(from);
			edto.setStatus("success");
			
			Criteria cr1 = ss.createCriteria(UserDTO.class);
			cr1.add(Restrictions.eq("email",from));
			UserDTO udto1 = (UserDTO) cr1.uniqueResult();
			List<EmailDTO> elist =udto1.getElist();
			elist.add(edto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();	
			return true;
			
		} else {
			edto=new EmailDTO();
			edto.setMessage(message);
			edto.setSubject(subject);
			edto.setSendto(to);
			edto.setSendby(from);
			edto.setStatus("failed");
			
			Criteria cr1 = ss.createCriteria(UserDTO.class);
			cr1.add(Restrictions.eq("email", from));
			UserDTO udto1 = (UserDTO) cr1.uniqueResult();
			List<EmailDTO> elist =udto1.getElist();
			elist.add(edto);
			ss.saveOrUpdate(udto1);
			ss.beginTransaction().commit();
			ss.close();	
			return false;
		}
	}


	@Override
	public List<EmailDTO> sent() {
		Session ss = sf.openSession();
		String email =(String) hs.getAttribute("email");
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("status", "success"));
		cr.add(Restrictions.eq("sendby",email ));
		List<EmailDTO> elist= cr.list();
		ss.close();
		return elist ;
	}


	@Override
	public List<EmailDTO> draft() {
		Session ss = sf.openSession();
		String email =(String) hs.getAttribute("email");
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("sendby",email ));
		cr.add(Restrictions.eq("status", "failed"));
		List<EmailDTO> elist= cr.list();
		ss.close();
		return elist ;
	}


	@Override
	public List<EmailDTO> inbox() {
		Session ss = sf.openSession();
		String email =(String) hs.getAttribute("email");
		
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("sendto", email));
		List<EmailDTO> elist= cr.list();
		for (EmailDTO emailDTO : elist) {
			System.out.println(emailDTO.getSendby());
		}
		
		ss.close();
		return elist ;
	}



	@Override
	public boolean forgetPassword2(String password1, String password2) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserDTO.class);
		String email=(String) hs.getAttribute("email");
		cr.add(Restrictions.eq("email", email));
		UserDTO dto=(UserDTO) cr.uniqueResult();
		if(dto!=null) {
			if(password1.equals(password2)) {
				dto.setPassword(password2);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
				ss.close();
				return false;
			}
		}else {
			ss.close();
			return false;
		}
	}
	
	@Override
	public boolean forgotPassword(String email, String question, String answer) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("question", question));
		cr.add(Restrictions.eq("answer", answer));
		UserDTO dto=(UserDTO) cr.uniqueResult();
		if(dto!=null) {
				ss.close();
				return true;
			}else {
			ss.close();
			return false;
			}
   }


	@Override
	public boolean changePassword(String oldpass, String npass1, String npass2) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserDTO.class);
		String email=(String) hs.getAttribute("email");
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", oldpass));
		UserDTO dto=(UserDTO) cr.uniqueResult();
		if(dto!=null) {
			if(npass1.equals(npass2)) {
				dto.setPassword(npass2);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
				ss.close();
				return false;
			}
		}else {
			ss.close();
			return false;
		}
	}


	@Override
	public boolean deleteMail(int id) {
		Session ss = sf.openSession();
		Criteria cr=ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("eid", id));
		EmailDTO edto = (EmailDTO) cr.uniqueResult();
		if (edto != null ) {
			
				edto.setStatus("delete");
				ss.saveOrUpdate(edto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
							
		} else {
			ss.close();
			return false;

		}
			
	}


	@Override
	public List<EmailDTO> deletedMail() {
		Session ss = sf.openSession();
		String email=(String) hs.getAttribute("email");
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("sendby", email));
		cr.add(Restrictions.eq("status", "delete"));
		List<EmailDTO> elist= cr.list();
				
		ss.close();
		return elist ;
		
	}


	@Override
	public EmailDTO draftm(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("eid", id));
		EmailDTO elist = (EmailDTO) cr.uniqueResult();
		ss.close();
		return elist;
	}


	@Override
	public EmailDTO showSent(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("eid", id));
		EmailDTO elist = (EmailDTO) cr.uniqueResult();
		ss.close();
		return elist;
	}


	@Override
	public EmailDTO showInbox(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(EmailDTO.class);
		cr.add(Restrictions.eq("eid", id));
		EmailDTO elist = (EmailDTO) cr.uniqueResult();
		ss.close();
		return elist;
	}


	@Override
	public boolean composeDraft(String to, String message, String subject) {
		Session ss = sf.openSession();
		this.hs = req.getSession(false);
		
		
		//String from = (String) hs.getAttribute("email");
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", to));
		UserDTO udto = (UserDTO) cr.uniqueResult();
		
		if (udto != null) {
			Criteria crr = ss.createCriteria(EmailDTO.class);
			int id=(int) hs.getAttribute("eid");
			crr.add(Restrictions.eq("eid", id));
			EmailDTO edto = (EmailDTO) crr.uniqueResult();
			edto.setSendto(to);
			edto.setStatus("success");
			ss.saveOrUpdate(edto);
			ss.beginTransaction().commit();
			ss.close();	
			return true;
			
		} else {
			Criteria crr = ss.createCriteria(EmailDTO.class);
			int id=(int) hs.getAttribute("eid");
			crr.add(Restrictions.eq("eid", id));
			EmailDTO edto = (EmailDTO) crr.uniqueResult();
			edto.setSendto(to);
			edto.setStatus("failed");
			ss.saveOrUpdate(edto);
			ss.beginTransaction().commit();
			ss.close();	
			return false;
		}
	}
	}