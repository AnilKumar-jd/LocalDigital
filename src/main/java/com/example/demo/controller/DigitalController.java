package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Registration;
import com.example.demo.model.LogedUserDetail;
import com.example.demo.model.LoginDetail;
import com.example.demo.model.UserDeatils;
import com.example.demo.repository.RegistrationRepo;
import com.example.demo.service.DigitalService;


@Controller
public class DigitalController {
	
	@Autowired
	RegistrationRepo regRepo;
	
	@Autowired
	DigitalService digtalservice;
	
	
	
	 @RequestMapping("/")
	    public ModelAndView index() {
	    	ModelAndView modelAndView=new ModelAndView();
	    	modelAndView.setViewName("index");
	    	
	     return modelAndView;
	    }
	// get logi template...........
	    @RequestMapping(value = "/login",method = RequestMethod.GET)
	    public ModelAndView login() {
	    	ModelAndView modelAndView=new ModelAndView();
	    	modelAndView.addObject("userlogin", new UserDeatils());
	    	modelAndView.setViewName("logini");
	    return modelAndView;  
	    }
	    //login process after submitting login details...........................
	    @PostMapping("/login")
	    public ModelAndView loginprocess(ModelAndView modelAndView, @Valid UserDeatils logindetail,BindingResult bindingResult, HttpServletRequest request) {
	    	try {
	    	LogedUserDetail logUser=regRepo.findUserbyNameandPass(logindetail.getFirstName(), logindetail.getPassword());
	    			 if(logUser.getEmailId()!=null) 
	    			 { 
	    			  HttpSession session = request.getSession();
	    			  session.setAttribute("userName", logindetail.getFirstName());
	    			  session.setAttribute("userPassword", logindetail.getPassword());
	    		      System.out.println("*****************#######333"+" you have succesfully login");
	    		    	 modelAndView.setViewName("index");
	    			  }
	    			 else 
	    			  {
	    				    System.out.println("*&&&&&&&&&&&&&&&&&&&&&&"+"password is not maatch ");
	    		    		modelAndView.setViewName("inedx");
	    			  }
	    			 return modelAndView;
	    	}
	    	catch(Exception e)
	    	{
	    		modelAndView.setViewName("logini");
	    		 return modelAndView;
	    	}
	    }
	 
	    
	 // Return registration form template
		@RequestMapping(value="/register", method = RequestMethod.GET)
		public ModelAndView showRegistrationPage(){
			 ModelAndView modelAndView = new ModelAndView();
			    modelAndView.addObject("userDeatails", new Registration());
			    modelAndView.setViewName("register"); // resources/templates/register.html
			    return modelAndView;
		}
	 
	 // registrartion process after subitting data......................................
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Registration user, BindingResult bindingResult, HttpServletRequest request) {
			if (bindingResult.hasErrors()) { 
				modelAndView.setViewName("register");		
			}	 
			else { 
				// send an email to the registration email.......... to create poassword......	
				regRepo.save(user);
				System.out.println("*&&&&&&&&&&&&&&&&&&&&&&"+"successfully register");
				modelAndView.setViewName("index");
			}
				
			return modelAndView;
		}
		
	// to get all user..................................
	 @RequestMapping(value = "/dummy_fetch",method = RequestMethod.GET)
	    public ModelAndView getallUser(HttpServletRequest request) {
	    	ModelAndView modelAndView=new ModelAndView();
	    	List <Registration> alluser =digtalservice.getAllUser(request);
	    	modelAndView.addObject("alluserList", alluser);
	    	modelAndView.setViewName("alluser");
	    return modelAndView;  
	    }
	 
	 // logout the user................................
	 @RequestMapping(value = "/logout",method = RequestMethod.GET)
	    public ModelAndView logout(HttpServletRequest request) {
	    	ModelAndView modelAndView=new ModelAndView();
	    	request.getSession().invalidate();
	    	modelAndView.setViewName("index");
	    return modelAndView;  
	    }
	 
	 
	// invalidate the user session.................
		/*
		 * @PostMapping("/logout") public String logout(HttpServletRequest request) {
		 * request.getSession().invalidate(); return "index"; }
		 */
	// registration for new user..........................
			/*
			 * @PostMapping("/registration") public Registration
			 * registration(@Valid @RequestBody Registration reg) { return
			 * regRepo.save(reg); }
			 */
		// login api and create session for user login...................
		/*
		 * @GetMapping("/login") public LogedUserDetail login(@Valid @RequestBody
		 * LoginDetails login, HttpServletRequest request) { LogedUserDetail logUser=
		 * regRepo.findUserbyNameandPass(login.getFirstName(), login.getPassword());
		 * if(logUser.getEmailId()!=null) { HttpSession session = request.getSession();
		 * session.setAttribute("userName", login.getFirstName());
		 * session.setAttribute("userPassword", login.getPassword());
		 * 
		 * return logUser; } else return new LogedUserDetail(); }
		 */
		
			/*
			 * // dummy api to call after loign.................
			 * 
			 * @GetMapping("/dummy_fetch") public List < Registration >
			 * getAllUser(HttpServletRequest request) {
			 * 
			 * List <Registration> alluser =digtalservice.getAllUser(request); return
			 * alluser; }
			 */

}
