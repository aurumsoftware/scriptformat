package br.com.aurum.scriptFormat.enums;

public enum ValidacoesFirebird {
	INSERT_INTO("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) from %s WHERE %s = '%s' INTO :chk; \n" + 
			" if (chk = 0 ) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	CREATE_TABLE("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) from RDB$RELATIONS WHERE RDB$RELATION_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 0 ) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	ADD_COLUMN("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) FROM RDB$RELATION_FIELDS WHERE RDB$RELATION_NAME = '%s' AND RDB$FIELD_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 0 ) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	ADD_FOREIGN_KEY("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) FROM RDB$RELATION_CONSTRAINTS WHERE RDB$CONSTRAINT_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 0 ) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	DROP_TABLE("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) from RDB$RELATIONS WHERE RDB$RELATION_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 1) then\n" + 
			" begin\n" + 
			"    DROP TABLE %s\n" + 
			" end\n" + 
			"END"),
	DROP_COLUMN("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) FROM RDB$RELATION_FIELDS WHERE RDB$RELATION_NAME = '%s' AND RDB$FIELD_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 1) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	DROP_CONSTRAINT("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) FROM RDB$RELATION_CONSTRAINTS WHERE RDB$CONSTRAINT_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 1) then\n" + 
			" begin\n" + 
			"  	%s\n" + 
			" end\n" + 
			"END"),
	ADD_PRIMARY_KEY("execute block\n" + 
			"as\n" + 
			"declare chk int;\n" + 
			"BEGIN\n" + 
			" SELECT count(*) FROM RDB$RELATION_CONSTRAINTS WHERE RDB$CONSTRAINT_NAME = '%s' INTO :chk; \n" + 
			" if (chk = 0 ) then\n" + 
			" begin\n" + 
			"   'ALTER TABLE %s ADD CONSTRAINT %s PRIMARY KEY (%s)';\n" +  
			" end\n" + 
			"END");
	
	private String valor;

	ValidacoesFirebird(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
