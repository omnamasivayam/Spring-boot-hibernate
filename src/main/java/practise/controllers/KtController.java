package practise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KtController {

	@RequestMapping("/kt")
	  @ResponseBody
	  public ModelAndView index() {
		//  ModelAndView modelAndView = new ModelAndView("login");
		  ModelAndView modelAndView = new ModelAndView("KT");
		  //modelAndView.addObject("msg", "hello world");
		  return modelAndView;
	  }
}
