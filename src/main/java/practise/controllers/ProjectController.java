package practise.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import practise.models.Project;
import practise.models.ProjectDao;
import practise.models.UserDao;

@Controller
public class ProjectController {

	 @Autowired
	  private ProjectDao _ProjectDao;

	 @Autowired
	  public UserDao _userDao;
	 
	@RequestMapping("/welcome")
	public ModelAndView setupForm(Map<String, Object> map){
		ModelAndView modelAndView = new ModelAndView("Welcome");
		Object a = _ProjectDao.findAll();
		Object emps = _userDao.findAll();
		modelAndView.addObject("b", emps);
		modelAndView.addObject("a", a);
		return modelAndView;
	}
	@RequestMapping(value="/project.do", method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Project project, BindingResult result, @RequestParam("name2") String name,@RequestParam String action, @RequestParam Map<String, Object> map){
		System.out.println("name is " + name);
		 ModelAndView modelAndView = new ModelAndView("Welcome");
		Project projectResult = new Project();
		
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			_ProjectDao.save(project);
			projectResult = project;
			break;
		case "edit":
			projectResult = _ProjectDao.findById(project.getProjectid());
			projectResult.setClient(project.getClient());
			projectResult.setLocation(project.getLocation());
			projectResult.setProjectname(project.getProjectname());
			_ProjectDao.save(projectResult);
			break;
		case "delete":
			_ProjectDao.delete(project.getProjectid());
			break;
		case "search":
			projectResult = _ProjectDao.findById(project.getProjectid());
			projectResult = projectResult!=null ? projectResult : new Project();
			break;
		}
		
		Object a = _ProjectDao.findAll();
		Object emps = _userDao.findAll();
		modelAndView.addObject("b", emps);
		modelAndView.addObject("a", a);
		modelAndView.addObject("value", "select a project and submit");
		modelAndView.addObject("name" , name);
		for(Project s :  _ProjectDao.findAll()){
			System.out.println(s.getProjectid());
			System.out.println(s.getProjectname());
			System.out.println(s.getLocation());
			System.out.println(s.getClient());	
		}
		System.out.println( _ProjectDao.findAll());
		System.out.println("ended here");
		return modelAndView;
	}
	
}
