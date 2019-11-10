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
import br.com.aurum.scriptFormat.model.Insert;

@RestController
public class InsertRest {

	@RequestMapping(value="/insertInto")
	public @ResponseBody String getInsert(@RequestParam String query, @RequestParam String table, @RequestParam String column, @RequestParam String value) {
		Insert insert = new Insert().withQuery(query).withTable(table).withColumn(column).havingValue(value);
		
		Replacer replacer = new Replacer();
		insert.setFirebird(String.format(ValidacoesFirebird.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		insert.setSqlServer(String.format(ValidacoesSQL.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		insert.setOracle(String.format(ValidacoesOracle.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToOracle(query.toUpperCase())));
		
		return new Gson().toJson(insert);
	}

}
