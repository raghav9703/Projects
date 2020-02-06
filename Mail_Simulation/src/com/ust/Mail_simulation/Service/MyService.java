package com.ust.Mail_simulation.Service;

import java.util.List;

import com.ust.Mail_simulation.Model.EmailDTO;
import com.ust.Mail_simulation.Model.UserDTO;

public interface MyService {
	
	
	
	public boolean register(UserDTO dto);
	public UserDTO login(UserDTO dto);
	public boolean composeEmail();
	public List<EmailDTO> sent();
	public List<EmailDTO> draft();
	public List<EmailDTO> inbox();
	public boolean forgetPassword2(String password1, String password2);
	public boolean forgotPassword(String email,String question, String answer);
	public boolean changePassword(String oldpass,String npass1, String npass2);
	public boolean deleteMail(int id);
	public List<EmailDTO> deletedMail();
	public EmailDTO draftm(int id); 
	public EmailDTO showSent(int id); 
	public EmailDTO showInbox(int id); 
	public boolean composeDraft(String to, String message, String subject);
}
