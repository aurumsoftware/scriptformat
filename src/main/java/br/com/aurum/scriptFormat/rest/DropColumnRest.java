package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.DropColumn;
import br.com.aurum.scriptFormat.model.DropTable;

@RestController
public class DropColumnRest {
	
	@RequestMapping(value="/dropColumn")
	public @ResponseBody String getDropColumn(@RequestParam String query, @RequestParam String table, @RequestParam String column, @RequestParam(defaultValue="1") Integer number) {
		DropColumn dropColumn = new DropColumn().withQuery(query).havingTable(table).withColumn(column).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(dropColumn);
	}
}
