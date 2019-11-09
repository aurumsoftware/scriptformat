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
import br.com.aurum.scriptFormat.model.CreateTable;

@RestController
public class CreateTableRest {
	
	@RequestMapping(value="/createTable")
	public @ResponseBody String getCreateTable(@RequestParam String query, @RequestParam String table, @RequestParam(defaultValue="1") Integer number) {
		CreateTable createTable = new CreateTable().withQuery(query).havingTable(table).withComment(number);
		
		Replacer replacer = new Replacer();
		
		createTable.setFirebird(String.format(ValidacoesFirebird.CREATE_TABLE.getValor(), table, 
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		
		createTable.setSqlServer(String.format(ValidacoesSQL.CREATE_TABLE.getValor(), table, 
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		
		createTable.setOracle(String.format(ValidacoesOracle.CREATE_TABLE.getValor(), table, 
				replacer.replaceQueryToOracle(query.toUpperCase())));
		
		
		Gson gson = new Gson();
		return gson.toJson(createTable);
	}

}
