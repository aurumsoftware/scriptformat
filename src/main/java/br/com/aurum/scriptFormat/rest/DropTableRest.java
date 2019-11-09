package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.enums.ValidacoesFirebird;
import br.com.aurum.scriptFormat.enums.ValidacoesOracle;
import br.com.aurum.scriptFormat.enums.ValidacoesSQL;
import br.com.aurum.scriptFormat.helper.Replacer;
import br.com.aurum.scriptFormat.model.DropTable;

@RestController
public class DropTableRest {
	
	@RequestMapping(value="/dropTable")
	public @ResponseBody String getDropTable(@RequestParam String query, @RequestParam String table, @RequestParam(defaultValue="1") Integer number) {
		DropTable dropTable =new DropTable().withQuery(query).havingTable(table).withComment(number);
		Replacer replacer = new Replacer();
		dropTable.setFirebird(String.format(ValidacoesFirebird.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		dropTable.setSqlServer(String.format(ValidacoesSQL.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		dropTable.setOracle(String.format(ValidacoesOracle.DROP_TABLE.getValor(), table,
				replacer.replaceQueryToOracle(query.toUpperCase())));
		Gson gson = new Gson();
		return gson.toJson(dropTable);
	}
}
