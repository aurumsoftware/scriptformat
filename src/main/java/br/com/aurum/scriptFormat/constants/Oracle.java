package br.com.aurum.scriptFormat.constants;

public enum Oracle {
    INTEGER("NUMBER(8)"),
    SMALLDATETIME("TIMESTAMP"),
    DATE("TIMESTAMP"),
    BLOB("CLOB"),
    TEXT("CLOB"),
    ASPASSIMPLES("''");

    private String value;

    Oracle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

