package br.com.aurum.scriptFormat.rest;

import br.com.aurum.scriptFormat.enums.ValidacoesFirebird;
import br.com.aurum.scriptFormat.enums.ValidacoesOracle;
import br.com.aurum.scriptFormat.enums.ValidacoesSQL;
import br.com.aurum.scriptFormat.helper.Replacer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.model.AddColumn;

@RestController
public class AddColumnRest {
	
	@RequestMapping(value="/addColumn")
	public @ResponseBody String getAddColumn(@RequestParam String query, @RequestParam String table, @RequestParam String column) {
		AddColumn addColumn = new AddColumn().withQuery(query).withTable(table).withColumn(column);
		Replacer replacer = new Replacer();
		
		addColumn.setFirebird(String.format(ValidacoesFirebird.ADD_COLUMN.getValor(), table, column,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		
		addColumn.setSqlServer(String.format(ValidacoesSQL.ADD_COLUMN.getValor(), table, column,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
						
		addColumn.setOracle(String.format(ValidacoesOracle.ADD_COLUMN.getValor(), table, column,
				replacer.replaceQueryToOracle(query.toUpperCase())));
		
		return new Gson().toJson(addColumn);
	}

}
