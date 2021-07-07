package com.avengors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/board")
	public void board() {}
	
	@GetMapping("/introduce")
	public void introduce() {}
	
	@GetMapping("/news")
	public void news() {}
	
	@GetMapping("oneword")
	public void oneword() {}
	
	@GetMapping("write")
	public void write() {}
	
}
