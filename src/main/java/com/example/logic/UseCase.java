package com.example.logic;

public class UseCase {
    private DbSql dbSql;

    public UseCase(DbSql dbSql) {
        this.dbSql = dbSql;
    }

    public Studerende hentStamoplysninger(int stdnr) throws Exception {
        System.out.println(dbSql.hentStamoplysninger(stdnr));
        return dbSql.hentStamoplysninger(stdnr);
    }
}
