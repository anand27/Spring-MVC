package com.xebia.myapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.xebia.myapp.domain.Person;
import com.xebia.myapp.service.PersonService;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes(value="user")
public class LoginController {
	
	@Autowired
	PersonService personService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/signIn", method = RequestMethod.POST)
    public String signIntoApplication(@RequestParam String username, @RequestParam String password, Model model) {
		
		Person person = personService.getPerson(1350);
		
		if(null !=person){
			model.addAttribute("user", person);
			model.addAttribute("dummy", "i am dummy"); // will i be available in controllers ahead of me ? NO.
			return "home";
		}
		
		 return "redirect:/index.jsp";
    }
	
	
	@RequestMapping(value="/signOut", method = RequestMethod.GET)
    public String signOutOfApplication(SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		System.out.println();
		
		return "redirect:/index.jsp";
    }
	
	/////////////////////////////////////////////////////////////////////////
	//		w/o   /*@SessionAttributes(value="user")*/
	/////////////////////////////////////////////////////////////////////////
	
	/*@SessionAttributes(value="user")*/
	
	/*@RequestMapping(value="/signIn", method = RequestMethod.POST)
    public String signIntoApplication(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
		
		Person person = personService.getPerson(1350);
		
		if(null !=person){
			session.setAttribute("user", person);
			model.addAttribute("user", person);
			model.addAttribute("dummy", "i am dummy"); // will i be available in controllers ahead of me ? NO.
			return "home";
		}
		
		 return "redirect:/index.jsp";
    }
	
	
	@RequestMapping(value="/signOut", method = RequestMethod.GET)
    public String signOutOfApplication(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/index.jsp";
    }*/
	
	/////////////////////////////////////////////////////////////////////////
	// if you use session.invalidate() with @SessionAttribute enabled
	// then session will be destroyed and immediately recreated
	// furthermore all the mopdel values will be put in the session and 
	// passed to the landing page
	// so if the landing page is a *.jsp mention this :
	// <%@ page session="false" %>
	/////////////////////////////////////////////////////////////////////////
}

	
	
