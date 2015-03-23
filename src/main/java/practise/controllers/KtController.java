package practise.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import practise.models.KT;
import practise.models.KTDao;
import practise.models.Project;
import practise.models.ProjectDao;
import practise.models.UserDao;

@Controller
public class KtController {

	  @Autowired
	  public UserDao _userDao;
	  
	  @Autowired
	  public ProjectDao _ProjectDao;	
	  
	  @Autowired
	  public KTDao _KTDao;
	  
		@RequestMapping("/kt")
		  @ResponseBody
		  public ModelAndView transfer(@ModelAttribute KT kt, BindingResult result, @RequestParam Map<String, Object> map) {
			//  ModelAndView modelAndView = new ModelAndView("login");
			  ModelAndView modelAndView = new ModelAndView("KT");
			  //modelAndView.addObject("msg", "hello world");
			  
			  Object a = _ProjectDao.findAll();
			  Object emps = _userDao.findAll();
			  Object kts = _KTDao.findAll();
			  modelAndView.addObject("bbb", emps);
			  modelAndView.addObject("aaa", a);
			  modelAndView.addObject("kts", kts);
			  System.out.println("Goin to send list of KT objects");
			  for(KT ktObj :  _KTDao.findAll()){
				  
					System.out.println(ktObj.getTrainee());
					System.out.println(ktObj.getTrainer());
					System.out.println(ktObj.getStartDate());
					System.out.println(ktObj.getEndDate());	
					System.out.println(ktObj.getTopic());
					System.out.println(ktObj.getId());
				}
			  System.out.println("printed list of KT objects");
			  return modelAndView;
		  }
		
		@RequestMapping(value="/kt", method=RequestMethod.POST)
		  @ResponseBody
		  public ModelAndView transferPost(@ModelAttribute KT kt, BindingResult result, @RequestParam Map<String, Object> map) {
			//  ModelAndView modelAndView = new ModelAndView("login");
			  ModelAndView modelAndView = new ModelAndView("KT");
			  //modelAndView.addObject("msg", "hello world");
			//  map.get(key)
			  Object a = _ProjectDao.findAll();
			  Object emps = _userDao.findAll();
			  Object kts = _KTDao.findAll();
			  modelAndView.addObject("bbb", emps);
			  modelAndView.addObject("aaa", a);
			  modelAndView.addObject("kts", kts);
			  System.out.println("POST :Goin to send list of KT objects");
			  for(KT ktObj :  _KTDao.findAll()){
				  System.out.println("inside foreach loop");
					System.out.println(ktObj.getTrainee().getName());
					System.out.println(ktObj.getTrainer().getName());
					System.out.println(ktObj.getStartDate().getTime());
					System.out.println(ktObj.getEndDate().getTime());	
					System.out.println(ktObj.getTopic());
					System.out.println(ktObj.getId());
				}
			  System.out.println("POST : printed list of KT objects");
			  return modelAndView;
		  }

	

}
