package br.com.aurum.scriptFormat.constants;

public enum Oracle {
    INTEGER("NUMBER(8)"),
    DATE("DATE"),
    BLOB("CLOB"),
    TEXT("CLOB");

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

