package br.com.aurum.scriptFormat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {
	
	@RequestMapping(value="/teste")
	public @ResponseBody String teste() {
		return "OK";
	}

}
