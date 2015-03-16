package practise.controllers;

import java.util.Map;

import practise.models.Project;
import practise.models.ProjectDao;
import practise.models.User;
import practise.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * A class to test the interaction with MySQL database using the UserDao class.
 *
 * @author practise
 */
@Controller
public class UserController {

  @Autowired
  public UserDao _userDao;
  
  @Autowired
  public ProjectDao _ProjectDao;
  
  @RequestMapping(value="/employee.do", method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute User user, BindingResult result, @RequestParam("name2") String name,@RequestParam String action, @RequestParam Map<String, Object> map){
		System.out.println("name is " + name);
		 ModelAndView modelAndView = new ModelAndView("employee");
		User userResult = new User();
		
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			_userDao.save(user);
			//projectResult = project;
			break;
		case "edit":
			userResult = _userDao.findById(user.getId());
			userResult.setName(user.getName());
			userResult.setDesignation(user.getDesignation());
			userResult.setProject(user.getProject());
			_userDao.save(userResult);
			break;
		case "delete":
			_userDao.delete(user.getId());
			break;

		}
		Object a = _ProjectDao.findAll();
		Object emps = _userDao.findAll();
		modelAndView.addObject("b", emps);
		modelAndView.addObject("a", a);
		modelAndView.addObject("value", "select a project and submit");
		modelAndView.addObject("name" , name);
		/*for(User s :  _userDao.findAll()){
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getProject());
			System.out.println(s.getDesignation());	
		}*/
		System.out.println( _userDao.findAll());
		System.out.println("ended here");
		return modelAndView;
	}
  
  
  
  @RequestMapping(value="/employee", method=RequestMethod.GET)
  public ModelAndView doActions(@ModelAttribute User user, @RequestParam Map<String, Object> map){
		//System.out.println("value is " + project.getProjectname());
		 ModelAndView modelAndView = new ModelAndView("employee");
		// User userResult = new User();
		 Object a = _ProjectDao.findAll();
		 Object emps = _userDao.findAll();
		 modelAndView.addObject("b", emps);
		 modelAndView.addObject("a", a);
		 modelAndView.addObject("result", "Currently no members");
		 return modelAndView;
	}
  
  
	@RequestMapping("/kt")
	  @ResponseBody
	  public ModelAndView index() {
		//  ModelAndView modelAndView = new ModelAndView("login");
		  ModelAndView modelAndView = new ModelAndView("KT");
		  //modelAndView.addObject("msg", "hello world");
		  Object a = _ProjectDao.findAll();
		  Object emps = _userDao.findAll();
		  modelAndView.addObject("bbb", emps);
		  modelAndView.addObject("aaa", a);
		  for(Project s :  _ProjectDao.findAll()){
				System.out.println(s.getProjectid());
				System.out.println(s.getProjectname());
				System.out.println(s.getLocation());
				System.out.println(s.getClient());	
			}
		  return modelAndView;
	  }
  
} // class UserController
