package br.com.aurum.scriptFormat.model;

public class CreateTable {
	
	private String query;
	
	private String table;
	
	public CreateTable() {}
	
	public CreateTable havingTable(String table) {
		setTable(table);
		return this;
	}
	
	public CreateTable withQuery(String query) {
		setQuery(query);
		return this;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}
