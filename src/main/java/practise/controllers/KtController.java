package practise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import practise.models.Project;
import practise.models.ProjectDao;
import practise.models.UserDao;

@Controller
public class KtController {

	  @Autowired
	  public UserDao _userDao;
	  
	  @Autowired
	  public ProjectDao _ProjectDao;	
	

}
