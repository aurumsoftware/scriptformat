package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import br.com.aurum.scriptFormat.model.DropTable;

@RestController
public class DropTableRest {
	
	@RequestMapping(value="/dropTable")
	public @ResponseBody String getDropTable(@RequestParam String query, @RequestParam String table, @RequestParam(defaultValue="1") Integer number) {
		DropTable dropTable =new DropTable().withQuery(query).havingTable(table).withComment(number);
		Gson gson = new Gson();
		return gson.toJson(dropTable);
	}
}
