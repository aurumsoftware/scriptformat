package br.com.aurum.scriptFormat.enums;

public enum ValidacoesSQL {
	INSERT_INTO("IF (SELECT COUNT(*) FROM where %s = '%s') = 0 BEGIN\n %s\n END\n GO"),
	CREATE_TABLE("IF (SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '%s') = 0\n BEGIN\n %s \n END\n GO"),
	ADD_COLUMN("IF (SELECT COUNT(*) COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '%s' AND COLUMN_NAME = '%s') = 0\n BEGIN\n %s \n END\n GO"),
	ADD_FOREIGN_KEY("IF (SELECT COUNT(*) FROM sysobjects WHERE name = '%s' and xtype = 'F') = 0\n BEGIN\n %s \n END\n GO"),
	DROP_TABLE("IF (SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'TESTE') = 1\n BEGIN\n DROP TABLE %s\n END\n GO"),
	DROP_COLUMN("IF (SELECT COUNT(*) COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '%s' AND COLUMN_NAME = '%s') = 1\n BEGIN\n ALTER TABLE %s DROP COLUMN %s;\n END\n GO"),
	DROP_CONSTRAINT("IF (SELECT COUNT(*) FROM sysobjects WHERE name = '%s' and xtype = 'C') = 1\n BEGIN\n %s\n END\n GO"),
	ADD_PRIMARY_KEY("IF (SELECT COUNT(*) FROM sysobjects WHERE name = '%s' and xtype = 'PK') = 0\n BEGIN\n ALTER TABLE %s ADD CONSTRAINT %s PRIMARY KEY (%s)\n END\n GO");
	
	private String valor;

	ValidacoesSQL(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    };
}