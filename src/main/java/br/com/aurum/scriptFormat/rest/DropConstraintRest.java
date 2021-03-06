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
import br.com.aurum.scriptFormat.model.DropConstraint;

@RestController
public class DropConstraintRest {
	
	@RequestMapping(value="/dropConstraint")
	public @ResponseBody String getDropConstraint(@RequestParam String query, @RequestParam String name) {
		DropConstraint dropConstraint = new DropConstraint().withQuery(query);
		
		Replacer replacer = new Replacer();
		
		dropConstraint.setFirebird(String.format(ValidacoesFirebird.DROP_CONSTRAINT.getValor(), name,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		dropConstraint.setSqlServer(String.format(ValidacoesSQL.DROP_CONSTRAINT.getValor(), name,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		dropConstraint.setOracle(String.format(ValidacoesOracle.DROP_CONSTRAINT.getValor(), name,
				replacer.replaceQueryToOracle(query.toUpperCase())));

		return new Gson().toJson(dropConstraint);
	}
}
