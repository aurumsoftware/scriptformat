package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.AddPrimaryKey;

@RestController
public class AddPrimaryKeyRest {
	
	@RequestMapping(value="/addPrimaryKey")
	public @ResponseBody String getAddPrimaryKey(@RequestParam String name, @RequestParam String table, @RequestParam String column, @RequestParam(defaultValue="1") Integer number) {
		AddPrimaryKey addPrimaryKey = new AddPrimaryKey().withName(name).withTable(table).withColumn(column).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(addPrimaryKey);
	}

}
