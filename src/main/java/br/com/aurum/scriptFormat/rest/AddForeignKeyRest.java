package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.AddForeignKey;

@RestController
public class AddForeignKeyRest {
	
	@RequestMapping(value="/addForeignKey")
	public @ResponseBody String getAddForeignKey(@RequestParam String query, @RequestParam String table, @RequestParam String column, 
			@RequestParam String name, @RequestParam String columnReferenced, @RequestParam String tableReferenced, @RequestParam String cascade, @RequestParam(defaultValue="1") Integer number) {
		AddForeignKey addForeignKey = new AddForeignKey().withQuery(query).withTable(table).withColumn(column).withName(name)
				.withColumnReferenced(columnReferenced).withTableReferenced(tableReferenced).withCascade(cascade).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(addForeignKey);
	}

}
