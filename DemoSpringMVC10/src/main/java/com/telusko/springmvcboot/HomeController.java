package com.telusko.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.springmvcboot.model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
    @ModelAttribute	
   public void modelData(Model m)
   {
	  m.addAttribute("name","Aliens"); 
   }
    
   @RequestMapping("/") 
   public String home()
   {
	   return "index";
   }
   
   @GetMapping("getAliens")
   public String getAliens(Model m)
   {
	   List<Alien> aliens = Arrays.asList(new Alien(101,"Shubham"), new Alien(102,"Mandar"));
	   m.addAttribute("result",aliens);
	   return "showAliens";
   }
   
   @PostMapping (value="addAlien")
   public String addAlien(@ModelAttribute Alien a)
   {   
	   return "result";
   }
}
