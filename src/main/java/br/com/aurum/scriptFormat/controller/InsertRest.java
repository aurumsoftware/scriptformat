package br.com.aurum.scriptFormat.controller;

import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class InsertRest {
	
	@RequestMapping(value="/insert")
	public @ResponseBody String getInsert() {
		Gson gson = new Gson();
		return gson.toJson("INSERT INTO XXXXX VALUES XXXXXX");
	}

}
