package br.com.aurum.scriptFormat.model;

public class Insert extends Query {
	
	private String query;
	
	private String table;
	
	private String column;
	
	private String value;
	
	private String comment;
	
	public Insert() {}
	
	public Insert withTable(String table) {
		setTable(table);
		return this;
	}
	
	public Insert withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public Insert havingValue(String value) {
		setValue(value);
		return this;
	}
	
	public Insert withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public Insert withComment(Integer number) {
		String text = "-- " + number + " Inserção do registro " + getValue() + " na tabela " + getTable();
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
