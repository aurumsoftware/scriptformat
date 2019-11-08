package br.com.aurum.scriptFormat.helper;

import br.com.aurum.scriptFormat.constants.Firebird;
import br.com.aurum.scriptFormat.constants.Oracle;
import br.com.aurum.scriptFormat.constants.SqlServer;

public class Replacer {

    public String replaceQueryToOracle(String query){
        query = query.replaceAll("INTEGER", Oracle.INTEGER.getValue());
        query = query.replaceAll("SMALLDATETIME", Oracle.SMALLDATETIME.getValue());
        query = query.replaceAll("DATE", Oracle.DATE.getValue());
        query = query.replaceAll("BLOB", Oracle.BLOB.getValue());
        query = query.replaceAll("TEXT", Oracle.TEXT.getValue());
        return query;
    }

    public String replaceQueryToFirebird(String query){
        query = query.replaceAll("TIMESTAMP", Firebird.TIMESTAMP.getValue());
        query = query.replaceAll("DATE", Firebird.DATE.getValue());
        query = query.replaceAll("INTEGER", Firebird.INTEGER.getValue());
        query = query.replaceAll("TEXT", Firebird.TEXT.getValue());
        query = query.replaceAll("CLOB", Firebird.CLOB.getValue());
        return query;
    }

    public String replaceQueryToSqlServer(String query){
        query = query.replaceAll("NUMBER", SqlServer.NUMBER.getValue());
        query = query.replaceAll("SMALLDATETIME", SqlServer.TIMESTAMP.getValue());
        query = query.replaceAll("BLOB", SqlServer.BLOB.getValue());
        query = query.replaceAll("CLOB", SqlServer.CLOB.getValue());

        return query;
    }

}
