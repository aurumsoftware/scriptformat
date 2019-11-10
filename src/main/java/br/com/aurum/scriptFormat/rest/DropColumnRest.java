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
import br.com.aurum.scriptFormat.model.DropColumn;

@RestController
public class DropColumnRest {
	
	@RequestMapping(value="/dropColumn")
	public @ResponseBody String getDropColumn(@RequestParam String query, @RequestParam String table, @RequestParam String column) {
		DropColumn dropColumn = new DropColumn().withQuery(query).havingTable(table).withColumn(column);
		
		Replacer replacer = new Replacer();
		
		dropColumn.setFirebird(String.format(ValidacoesFirebird.DROP_COLUMN.getValor(), 
				table, column, replacer.replaceQueryToFirebird(query.toUpperCase())));
		
		dropColumn.setSqlServer(String.format(ValidacoesSQL.DROP_COLUMN.getValor(), 
				table, column, replacer.replaceQueryToSqlServer(query.toUpperCase())));
		
		dropColumn.setOracle(String.format(ValidacoesOracle.DROP_COLUMN.getValor(), 
				table, column, replacer.replaceQueryToOracle(query.toUpperCase())));
		
		return new Gson().toJson(dropColumn);
	}
}
