package com.ust.Mail_simulation.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.Mail_simulation.Dao.MyDAO;
import com.ust.Mail_simulation.Model.EmailDTO;
import com.ust.Mail_simulation.Model.UserDTO;

@Component
public class MyServiceImplementation  implements MyService{
	
	@Autowired
	MyDAO mdao;
	

	@Override
	public boolean register(UserDTO dto) {
		
		return mdao.register(dto);
	}

	@Override
	public UserDTO login(UserDTO dto) {
		
		return mdao.login(dto);
	}

	@Override
	public boolean composeEmail() {
		return mdao.composeEmail();
	}

	@Override
	public List<EmailDTO> sent() {
		List<EmailDTO> elist = mdao.sent();
		return elist;
	}

	@Override
	public List<EmailDTO> draft() {
		List<EmailDTO> elist = mdao.draft();
		return elist;
	}

	@Override
	public List<EmailDTO> inbox() {
		List<EmailDTO> elist = mdao.inbox();
		return elist;
	}

	@Override
	public boolean forgetPassword2(String password1, String password2) {
		return  mdao.forgetPassword2(password1, password2);
	}

	@Override
	public boolean forgotPassword(String email, String question, String answer) {
		return mdao.forgotPassword(email, question, answer);
		
	}

	@Override
	public boolean changePassword(String oldpass, String npass1, String npass2) {
		return mdao.changePassword(oldpass, npass1, npass2);
	}

	@Override
	public boolean deleteMail(int id) {
		return mdao.deleteMail(id);
	}

	@Override
	public List<EmailDTO> deletedMail() {
		List<EmailDTO> elist = mdao.deletedMail();
		return elist;
	}

	@Override
	public EmailDTO draftm(int id) {
		EmailDTO elist = mdao.draftm(id);
		return elist;
	}

	@Override
	public EmailDTO showSent(int id) {
		EmailDTO elist = mdao.showSent(id);
		return elist;
	}

	@Override
	public EmailDTO showInbox(int id) {
		EmailDTO elist = mdao.showInbox(id);
		return elist;
	}

	@Override
	public boolean composeDraft(String to, String message, String subject) {
		// TODO Auto-generated method stub
		return mdao.composeDraft(to, message, subject);
	}
	


	

}
