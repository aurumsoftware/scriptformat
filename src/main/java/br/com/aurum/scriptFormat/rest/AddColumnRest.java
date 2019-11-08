package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.AddColumn;

@RestController
public class AddColumnRest {
	
	@RequestMapping(value="/addColumn")
	public @ResponseBody String getAddColumn(@RequestParam String query, @RequestParam String table, @RequestParam String column, @RequestParam(defaultValue="1") Integer number) {
		AddColumn addColumn = new AddColumn().withQuery(query).withTable(table).withColumn(column).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(addColumn);
	}

}
