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
import br.com.aurum.scriptFormat.model.AddForeignKey;

@RestController
public class AddForeignKeyRest {
	
	@RequestMapping(value="/addForeignKey")
	public @ResponseBody String getAddForeignKey(@RequestParam String query, @RequestParam String name) {
		AddForeignKey addForeignKey = new AddForeignKey().withQuery(query).withName(name);
		
		Replacer replacer = new Replacer();
		
		addForeignKey.setFirebird(String.format(ValidacoesFirebird.ADD_FOREIGN_KEY.getValor(), name, 
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		
		addForeignKey.setSqlServer(String.format(ValidacoesSQL.ADD_FOREIGN_KEY.getValor(), name, 
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		
		addForeignKey.setOracle(String.format(ValidacoesOracle.ADD_FOREIGN_KEY.getValor(), name, 
				replacer.replaceQueryToOracle(query.toUpperCase())));
	
		return new Gson().toJson(addForeignKey);
	}

}
