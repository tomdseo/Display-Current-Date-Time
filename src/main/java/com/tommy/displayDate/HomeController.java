package com.tommy.displayDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller //@Controller for JSP renders, @RestController for class returns
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat dayText = new SimpleDateFormat("EEEE");
		model.addAttribute("dayText", dayText.format(cal.getTime()));
		
		SimpleDateFormat day = new SimpleDateFormat("dd");
		model.addAttribute("day", day.format(cal.getTime()));
		
		SimpleDateFormat month = new SimpleDateFormat("MMMMM");
		model.addAttribute("month", month.format(cal.getTime()));
		
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		model.addAttribute("year", year.format(cal.getTime()));
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:a");
		model.addAttribute("timeOutput", sdf.format(cal.getTime()));
		return "time.jsp";
	}

}
