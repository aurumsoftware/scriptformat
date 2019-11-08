package br.com.aurum.scriptFormat.helper;

import br.com.aurum.scriptFormat.constants.Firebird;
import br.com.aurum.scriptFormat.constants.Oracle;
import br.com.aurum.scriptFormat.constants.SqlServer;
import com.sun.org.apache.xpath.internal.operations.Or;

public class Replacer {

    public String replaceQueryToOracle(String query){
        query.replaceAll("INTEGER", Oracle.INTEGER.getValue());
        query.replaceAll("SMALLDATETIME", Oracle.SMALLDATETIME.getValue());
        query.replaceAll("DATE", Oracle.DATE.getValue());
        query.replaceAll("BLOB", Oracle.BLOB.getValue());
        query.replaceAll("TEXT", Oracle.TEXT.getValue());
        return query;
    }

    public String replaceQueryToFirebird(String query){
        query.replaceAll("TIMESTAMP", Firebird.TIMESTAMP.getValue());
        query.replaceAll("DATE", Firebird.DATE.getValue());
        query.replaceAll("INTEGER", Firebird.INTEGER.getValue());
        query.replaceAll("TEXT", Firebird.TEXT.getValue());
        query.replaceAll("CLOB", Firebird.CLOB.getValue());
        return query;
    }

    public String replaceQueryToSqlServer(String query){
        query.replaceAll("NUMBER", SqlServer.NUMBER.getValue());
        query.replaceAll("SMALLDATETIME", SqlServer.TIMESTAMP.getValue());
        query.replaceAll("BLOB", SqlServer.BLOB.getValue());
        query.replaceAll("CLOB", SqlServer.CLOB.getValue());

        return query;
    }

}
