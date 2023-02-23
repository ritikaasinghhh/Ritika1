package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeRepo;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo edao;

		@RequestMapping("/")
		public String home()
		{
			return "home.jsp";
		}
		
		@RequestMapping("/addEmployee")
		public String addEmployee(Employee employee)
		{
			edao.save(employee);
			return "home.jsp";
		}
		
		@RequestMapping("/getEmployee")
		public ModelAndView getEmployee(@RequestParam int eid)
		{
			ModelAndView mv=new ModelAndView("display.jsp");
			Employee employee= edao.findById(eid).orElse(null);
			mv.addObject(employee);
			return mv;
		}
		
		@RequestMapping("/delEmployee")
		public String delEmployee(@RequestParam int eid)
		{
			edao.deleteById(eid);
			return "home.jsp";
		}
		
		@RequestMapping("/upEmployee")
		public String upEmployee(@RequestParam int eid, String ename)
		{
			Employee employee= edao.findById(eid).orElse(null);
			employee.setEname(ename);
			edao.save(employee);
			return "home.jsp";
		}
		
}
