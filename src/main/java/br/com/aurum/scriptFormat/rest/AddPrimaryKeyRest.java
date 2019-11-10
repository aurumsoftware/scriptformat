package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.enums.ValidacoesFirebird;
import br.com.aurum.scriptFormat.enums.ValidacoesOracle;
import br.com.aurum.scriptFormat.enums.ValidacoesSQL;
import br.com.aurum.scriptFormat.model.AddPrimaryKey;

@RestController
public class AddPrimaryKeyRest {
	
	@RequestMapping(value="/addPrimaryKey")
	public @ResponseBody String getAddPrimaryKey(@RequestParam String name, @RequestParam String table, @RequestParam String column) {
		AddPrimaryKey addPrimaryKey = new AddPrimaryKey().withName(name).withTable(table).withColumn(column);;
		
		addPrimaryKey.setFirebird(String.format(ValidacoesFirebird.ADD_PRIMARY_KEY.getValor(), name, table, name, column));
		
		addPrimaryKey.setSqlServer(String.format(ValidacoesSQL.ADD_PRIMARY_KEY.getValor(), name, table, name, column));
		
		addPrimaryKey.setOracle(String.format(ValidacoesOracle.ADD_PRIMARY_KEY.getValor(), name, table, name, column));
		
		Gson gson = new Gson();
		return gson.toJson(addPrimaryKey);
	}

}
