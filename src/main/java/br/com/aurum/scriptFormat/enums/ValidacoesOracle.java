package br.com.aurum.scriptFormat.enums;

public enum ValidacoesOracle {
	INSERT_INTO("declare\n chkSeq pls_integer;\n begin\n" + 
			"     select count(*) into chkSeq from %s where %s = '%s';\n" + 
			"     if chkSeq = 0 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	CREATE_TABLE("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from USER_TAB_COLS where TABLE_NAME = '%s';\n" + 
			"     if chkSeq = 0 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	ADD_COLUMN("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from USER_TAB_COLS where TABLE_NAME = '%s' and COLUMN_NAME = '%s';\n" + 
			"     if chkSeq = 0 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	ADD_FOREIGN_KEY("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from user_constraints where CONSTRAINT_NAME = '%s';\n" + 
			"     if chkSeq = 0 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	DROP_TABLE("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from USER_TAB_COLS where TABLE_NAME = '%s';\n" + 
			"     if chkSeq = 1 then\n" + 
			"       execute immediate\n" + 
			"           DROP TABLE %s;\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	DROP_COLUMN("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from USER_TAB_COLS where TABLE_NAME = '%s' and COLUMN_NAME = '%s';\n" + 
			"     if chkSeq = 1 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	DROP_CONSTRAINT("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from user_constraints where CONSTRAINT_NAME = '%s';\n" + 
			"     if chkSeq = 1 then\n" + 
			"       execute immediate\n" + 
			"       '%s';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;"),
	
	ADD_PRIMARY_KEY("declare\n" + 
			"     chkSeq pls_integer;\n" + 
			"begin\n" + 
			"     select count(*) into chkSeq from user_constraints where CONSTRAINT_NAME = '%s';\n" + 
			"     if chkSeq = 0 then\n" + 
			"       execute immediate\n" + 
			"       'ALTER TABLE %s ADD CONSTRAINT %s PRIMARY KEY (%s)';\n" + 
			"     end if;\n" + 
			"end;\n" + 
			"/\n" + 
			"commit work;");
	
	
	private String valor;

	ValidacoesOracle(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
