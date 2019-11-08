package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.DropConstraint;

@RestController
public class DropConstraintRest {
	
	@RequestMapping(value="/dropConstraint")
	public @ResponseBody String getDropConstraint(@RequestParam String query, @RequestParam String table, @RequestParam String name, @RequestParam String type, @RequestParam(defaultValue="1") Integer number) {
		DropConstraint dropConstraint = new DropConstraint().withQuery(query).havingTable(table).withName(name).withType(type).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(dropConstraint);
	}
}
