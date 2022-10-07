package com.thread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ThreadController {
	
	@Autowired
	private ThreadServiceImpl threadService;
	
	@GetMapping("/threads")
	public String getThreads(Model model) {
		List<Thread> listThreads = threadService.getThread();
		model.addAttribute("listThreads", listThreads);
		return "threads";
	}

}
