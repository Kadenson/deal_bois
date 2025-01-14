package com.andrew.dealbois.controllers;

<<<<<<< HEAD
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrew.dealbois.models.LoginUser;
import com.andrew.dealbois.models.Product;
import com.andrew.dealbois.models.User;
import com.andrew.dealbois.services.ProductService;
import com.andrew.dealbois.services.UserService;

@Controller
public class UserController {

		 @Autowired
		 private UserService userServ;
		 @Autowired
		 private ProductService productServ;
	    
	    @GetMapping("/register")
	    public String register(
	    		Model model
		) {
	       
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "register.jsp";
	    }
	    
	    @GetMapping("/")
	    public String mainPage(Model model) {
	    	List<Product> allProducts = productServ.getAllProducts();
			model.addAttribute("products", allProducts);
	        return "mainPage.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(
	    		@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result,
	            Model model, HttpSession session
	    ) {
	        
	  
	    	User registeredUser = userServ.register(newUser, result);
	        
	        if(result.hasErrors()) {
	          
	            model.addAttribute("newLogin", new LoginUser());
	            return "register.jsp";
	        }
	      
	        session.setAttribute("user_id", registeredUser.getId());
	        return "redirect:/dashboard";
	    }
	    
	    @GetMapping("login")
	    public String login(
	    		Model model
		) {
	       
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        List<Product> allProducts = productServ.getAllProducts();
			
			model.addAttribute("products", allProducts);
	        return "login.jsp";
	    }
	    
	    @PostMapping("/login")
	    public String login(
	    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, 
	            Model model, HttpSession session
	    ) {
	        
	     
	        User user = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login.jsp";
	        }
	     
	        session.setAttribute("user_id", user.getId());
	        
	        return "redirect:/dashboard";
	    }
	    
	    @GetMapping("/dashboard")
		public String dashboard(HttpSession session, Model model) {
		
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			
			Long user_id = (Long) session.getAttribute("user_id");
			User loggedUser = userServ.getOneUser(user_id);						
			model.addAttribute("user", loggedUser);
		
			return "dashboard.jsp";
		}
	    
	    @GetMapping("/users/{id}")
		public String myAccount(@PathVariable("id") Long id, Model model, HttpSession session) {
		
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			User oneUser = userServ.getOneUser(id);
			
			model.addAttribute("user", oneUser);
			return "myAccount.jsp";
		}
		
	    
	    @RequestMapping("/logout")
	      public String logout(HttpSession session ) {
	         session.invalidate();
	         return "redirect:/";
	      }

	      
	    
	    
	
}
>>>>>>> 835776f6271ef389c72133dba14b0327c4d1bdfc
