package br.com.aurum.scriptFormat.model;

public class DropConstraint extends Query {
	
	private String query;
	
	private String table;
	
	private String name;
	
	private String type;
	
	private String comment;
	
	public DropConstraint() {}
	
	public DropConstraint withQuery(String query) {
		setQuery(query);
		return this;
	}

	public DropConstraint havingTable(String table) {
		setTable(table);
		return this;
	}
	
	public DropConstraint withName(String name) {
		setName(name);
		return this;
	}
	
	public DropConstraint withType(String type) {
		setType(type);
		return this;
	}
	
	public DropConstraint withComment(Integer number) {
		String text = "-- " + number + " Exclusão da constraint " + getName() + " na tabela " + getTable();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
