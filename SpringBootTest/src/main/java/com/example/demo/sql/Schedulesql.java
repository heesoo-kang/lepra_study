package com.example.demo.sql;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class Schedulesql {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getAllScheduleList(String year, String month,String account, Model model ){

		int monthchk =  Integer.parseInt(month);
		
		if(monthchk < 10) {
			month= "0"+month;
		}
		System.out.println("monthchk :"+month);
		String yearmonth = year+"-"+month+"%";
		
		System.out.println("getAllScheduleList year:"+year);
		System.out.println("getAllScheduleList month:"+month);
		System.out.println("getAllScheduleList userid:"+ account);

    	List<Map<String, Object>> schedulelist = jdbcTemplate.queryForList("select schedule,date from schedule where date like ? and account= ?;",yearmonth,account);
	
		
		System.out.println("schedulelist sql:"+schedulelist);
		model.addAttribute("schedulelist",schedulelist);	
	}
	public void getuserScheduleList(String year, String month,String username, Model model){

		int monthchk =  Integer.parseInt(month);
		
		if(monthchk < 10) {
			month= "0"+month;
		}
		System.out.println("monthchk :"+month);
		String yearmonth = year+"-"+month+"%";
		
		System.out.println("input year:"+year);
		System.out.println("input month:"+month);
		System.out.println("input user name : "+username);

    	List<Map<String, Object>> schedulelist = jdbcTemplate.queryForList("select a.schedule,a.date from schedule as  a INNER JOIN user as b On a.account = b.account where date like ? and b.name= ?;",yearmonth,username);
	
		
		System.out.println("get user ScheduleList sql: "+schedulelist);
		model.addAttribute("schedulelist",schedulelist);	
	}
	
	public List<Map<String, Object>> searchuserScheduleList(String year, String month,String account){	
		int monthchk =  Integer.parseInt(month);
		
		if(monthchk < 10) {
			month= "0"+month;
		}
		System.out.println("monthchk :"+month);
		String yearmonth = year+"-"+month+"%";
		
		System.out.println("searchuserScheduleList year:"+year);
		System.out.println("searchuserScheduleList month:"+month);
		System.out.println("searchuserScheduleList user account : "+account);

    	//List<Map<String, Object>> searchschedulelist = jdbcTemplate.queryForList("select a.schedule,a.date from schedule as  a INNER JOIN user as b On a.userid = b.account where date like ? and b.name= ?;",yearmonth,username);
		List<Map<String, Object>> searchschedulelist = jdbcTemplate.queryForList("select schedule,date from schedule  where date like ? and account= ?;",yearmonth,account);
		
		System.out.println("get user searchschedulelist sql: "+searchschedulelist);

		System.out.println("searchschedulelist:sql "+ searchschedulelist);
		return searchschedulelist;
	}
	
	public int insertSchedule(String account, String schedule,String year,String month,String day,String writter) {
		int monthchk =  Integer.parseInt(month);
		if(monthchk < 10) {
			month= "0"+month;
		}
		
		int daychk =  Integer.parseInt(day);
		if(daychk < 10) {
			day= "0"+day;
		}
		String date = year+month+day;
		int insertSchedule;
		insertSchedule = jdbcTemplate.update("INSERT INTO schedule (account,schedule, date, writter) VALUES (?, ?, ?, ?)",account,schedule,date,writter);
		
		return insertSchedule;
	}

}
