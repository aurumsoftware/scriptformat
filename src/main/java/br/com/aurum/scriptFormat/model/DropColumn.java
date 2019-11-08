package br.com.aurum.scriptFormat.model;

public class DropColumn extends Query {
	
	private String query;
	
	private String table;
	
	private String column;
	
	private String comment;
	
	public DropColumn() {}
	
	public DropColumn havingTable(String table) {
		setTable(table);
		return this;
	}
	
	public DropColumn withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public DropColumn withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public DropColumn withComment(Integer number) {
		String text = "-- " + number + " Exclusão da coluna " + getColumn() + " na tabela " + getTable();
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

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
