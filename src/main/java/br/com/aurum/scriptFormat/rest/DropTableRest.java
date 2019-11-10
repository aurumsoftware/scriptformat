package br.com.aurum.scriptFormat.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.aurum.scriptFormat.enums.ValidacoesFirebird;
import br.com.aurum.scriptFormat.enums.ValidacoesOracle;
import br.com.aurum.scriptFormat.enums.ValidacoesSQL;
import br.com.aurum.scriptFormat.model.DropTable;

@RestController
public class DropTableRest {
	
	@RequestMapping(value="/dropTable")
	public @ResponseBody String getDropTable(@RequestParam String table) {
		DropTable dropTable = new DropTable().havingTable(table);
		
		dropTable.setFirebird(String.format(ValidacoesFirebird.DROP_TABLE.getValor(), table, table));
		dropTable.setSqlServer(String.format(ValidacoesSQL.DROP_TABLE.getValor(), table, table));
		dropTable.setOracle(String.format(ValidacoesOracle.DROP_TABLE.getValor(), table, table));
		
		return new Gson().toJson(dropTable);
	}
}
