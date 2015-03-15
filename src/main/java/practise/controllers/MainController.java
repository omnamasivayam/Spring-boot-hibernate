package practise.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public ModelAndView index() {
	  ModelAndView modelAndView = new ModelAndView("login");
	//  ModelAndView modelAndView = new ModelAndView("welcome");
	  //modelAndView.addObject("msg", "hello world");
	  return modelAndView;
  }
  
  
  @RequestMapping("/checkLogin")
  @ResponseBody
  public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String psswd) {
	  
	  if(name.equals("admin") && psswd.equals("password"))
		  name = "Adminstrator";
		    
	  ModelAndView modelAndView = new ModelAndView("Welcome");
	  modelAndView.addObject("name", name);
	  return modelAndView;
  }

}
