package br.com.aurum.scriptFormat.constants;

public enum Firebird {

    TIMESTAMP("TIMESTAMP"),
    DATE("TIMESTAMP"),
    INTEGER("INTEGER"),
    TEXT("BLOB"),
    CLOB("BLOB"),
    ASPASSIMPLES("''");

    private String value;

    Firebird(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
