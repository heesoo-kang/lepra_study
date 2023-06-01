package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.ScheduleDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.sql.Schedulesql;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/schedule")
class ScheduleController {
	
	@Autowired
	Schedulesql scheduleRepository;


	@RequestMapping(value= {"/list"})
	public String schedule(String year, String month, Model model, HttpServletRequest request) {

		jakarta.servlet.http.HttpSession session = request.getSession();
	    String token_chk = request.getParameter("manage_token");
	    System.out.println("token_chk - schedule con" + "; "+ token_chk);
	    String loginid = (String) session.getAttribute("userid");
	    
	    LocalDate now = LocalDate.now();
	    year = String.valueOf(now.getYear());
	    month = String.valueOf(now.getMonthValue());
	    
	    String userid = (String) session.getAttribute("userid");
		String username = (String) session.getAttribute("username");
		
		if(	String.valueOf(session.getAttribute("manage_token")).equals(token_chk)) {
			
			System.out.println("goto schedule user ");
			
			System.out.println("schedule_screen - username: " +username );
			
			
			//System.out.println("searchusername - chk : "+searchname);
		    String search_username = request.getParameter("searchuser_name");
		    String search_useraccount = request.getParameter("searchuser_account");
			System.out.println("request.getParameter(searchuser_name) : "+ search_username);
			session.setAttribute("searchuser_name", search_username);
			session.setAttribute("search_useraccount", search_useraccount);

		
			if(search_username== null) {
				scheduleRepository.getAllScheduleList(year, month, userid, model);	
				System.out.println("get AllScheduleList: "+model.getAttribute("schedulelist"));
			}else {
				scheduleRepository.getuserScheduleList(year, month, search_username, model);
				System.out.println("get userScheduleList: "+model.getAttribute("schedulelist"));
			}
			
			UUID u = UUID.randomUUID(); // add Schedule token
			session.setAttribute("schedule_Token", u);
			return "schedule_screen";
			
		}else if(username != null){
					
			scheduleRepository.getuserScheduleList(year, month, username, model);
			System.out.println("get userScheduleList: "+model.getAttribute("schedulelist"));
			
			return "schedule_screen";
			
		}	else {
			return "redirect:/home";	
		}
	}
	
	@RequestMapping(value= {"/insert"}, method = RequestMethod.POST)
	public String insert_schedule(@RequestParam Map<String, Object> map,HttpServletRequest request) {
		jakarta.servlet.http.HttpSession session = request.getSession();
		String schedule_insert_token = (String) map.get("token");
		System.out.println("token chk: "+ schedule_insert_token);
	    System.out.println("session.getAttribute schedule_Token : "+ session.getAttribute("schedule_Token"));
	    System.out.println("equals?): "+ String.valueOf(session.getAttribute("schedule_Token")).equals(schedule_insert_token));
	 

		if( schedule_insert_token.equals(schedule_insert_token)) {
			
			String year = (String) map.get("year");
			String month = (String) map.get("month");
			String day = (String) map.get("day");
			String schedule = (String) map.get("schedule");
			String account = (String) map.get("useraccount");
			String writter =(String) map.get("writter");
			System.out.println("insert -account: "+account );
			scheduleRepository.insertSchedule(account, schedule,year,month,day, writter);
			
			return "redirect:/schedule/list";
			
		}else {
			
			return "redirect:/home";
		}
		
	}

	@RequestMapping(value = "/getSearchschedule", method=RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getSearchschedule(HttpServletRequest request,@RequestParam Map<String, Object> map){
		
		System.out.println("in getSearchschedule=========================---");
		jakarta.servlet.http.HttpSession session = request.getSession();

		String year = (String) map.get("year");
		String month = (String) map.get("month");
		String searchuser = (String) map.get("searchuser");
		
		System.out.println("searchuser:"+searchuser);
		if(searchuser==null) {
			searchuser = (String) session.getAttribute("userid");
		}
		System.out.println("iyear month searchuser "+year+" "+month+" "+searchuser);
	
		return scheduleRepository.searchuserScheduleList(year, month, searchuser);
	}
}
