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

	@RequestMapping(value="/insert")
	public @ResponseBody String getInsert(@RequestParam String query, @RequestParam String table, @RequestParam String column,
										  @RequestParam String value, @RequestParam Integer number) {
		Insert insert = new Insert().withQuery(query).withTable(table).withColumn(column).havingValue(value).withComment(number);
		
		Replacer replacer = new Replacer();
		insert.setSqlServer(String.format(ValidacoesFirebird.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToSqlServer(query.toUpperCase())));
		insert.setFirebird(String.format(ValidacoesSQL.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToFirebird(query.toUpperCase())));
		insert.setOracle(String.format(ValidacoesOracle.INSERT_INTO.getValor(), table, column, value,
				replacer.replaceQueryToOracle(query.toUpperCase())));
		Gson gson = new Gson();
		return gson.toJson(insert);
	}

}
