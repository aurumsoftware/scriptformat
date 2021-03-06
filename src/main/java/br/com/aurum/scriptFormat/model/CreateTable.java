package br.com.aurum.scriptFormat.model;

public class CreateTable extends Query {
	
	private String query;

	private String table;
	
	private String comment;
	
	public CreateTable() {}
	
	public CreateTable havingTable(String table) {
		setTable(table);
		return this;
	}
	
	public CreateTable withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public CreateTable withComment(Integer number) {
		String text = "-- " + number + " Criação da tabela " + getTable();
		setComment(text);
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
