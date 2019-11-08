package br.com.aurum.scriptFormat.constants;

public enum SqlServer {
    NUMBER("INTEGER"),
    TIMESTAMP("SMALLDATETIME"),
    BLOB("TEXT"),
    CLOB("IMAGE");

    private String value;

    SqlServer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
