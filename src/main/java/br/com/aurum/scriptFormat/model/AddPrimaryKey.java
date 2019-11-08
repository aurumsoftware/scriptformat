package br.com.aurum.scriptFormat.model;

public class AddPrimaryKey {

	private String table;
	
	private String column;
	
	private String name;
	
	private String comment;
	
	public AddPrimaryKey() {}
	
	public AddPrimaryKey withTable(String table) {
		setTable(table);
		return this;
	}
	
	public AddPrimaryKey withColumn(String column) {
		setColumn(column);
		return this;
	}
	
	public AddPrimaryKey withName(String name) {
		setName(name);
		return this;
	}
	
	public AddPrimaryKey withComment(Integer number) {
		String text = "-- " + number + " Criação da Primary Key " + getName();
		setComment(text);
		return this;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
