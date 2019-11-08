package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.CreateTable;
import br.com.aurum.scriptFormat.model.Insert;

@RestController
public class CreateTableRest {
	
	@RequestMapping(value="/createTable")
	public @ResponseBody String getCreateTable(@RequestParam String query, @RequestParam String table, @RequestParam(defaultValue="1") Integer number) {
		CreateTable createTable =new CreateTable().withQuery(query).havingTable(table).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(createTable);
	}

}
