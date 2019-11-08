package br.com.aurum.scriptFormat.enums;

public enum ValidacoesFirebird {
	INSERT_INTO("");
	
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
