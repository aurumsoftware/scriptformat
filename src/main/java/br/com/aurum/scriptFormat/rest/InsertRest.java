package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.Insert;

@RestController
public class InsertRest {
	
	@RequestMapping(value="/insert")
	public @ResponseBody String getInsert(@RequestParam String query, @RequestParam String table, @RequestParam String column, @RequestParam String value, @RequestParam Integer number) {
		Insert insert = new Insert().withQuery(query).withTable(table).withColumn(column).havingValue(value).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(insert);
	}

}
