package br.com.aurum.scriptFormat.model;

public class DropTable {
	
	private String query;
	
	private String table;
	
	private String comment;
	
	public DropTable() {}
	
	public DropTable havingTable(String table) {
		setTable(table);
		return this;
	}
	
	public DropTable withQuery(String query) {
		setQuery(query);
		return this;
	}
	
	public DropTable withComment(Integer number) {
		String text = "-- " + number + " Exclusão da tabela " + getTable();
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
