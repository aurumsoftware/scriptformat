package br.com.aurum.scriptFormat.rest;

import br.com.aurum.scriptFormat.enums.ValidacoesFirebird;
import br.com.aurum.scriptFormat.helper.Replacer;
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
		Replacer replacer = new Replacer();
		dropTable.setSqlServer(String.format(ValidacoesFirebird.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		dropTable.setFirebird(String.format(ValidacoesFirebird.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		dropTable.setOracle(String.format(ValidacoesFirebird.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToOracle(query.toUpperCase())));
		Gson gson = new Gson();
		return gson.toJson(dropTable);
	}
}
