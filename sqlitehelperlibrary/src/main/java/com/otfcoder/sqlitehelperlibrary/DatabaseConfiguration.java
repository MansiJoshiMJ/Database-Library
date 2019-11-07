package com.otfcoder.sqlitehelperlibrary;

import android.content.Context;

import java.util.ArrayList;

public class DatabaseConfiguration {

    String DATABASE_NAME = "DemoDb";
    int DATABASE_VERSION = 1;
    Context CONTEXT;

    ArrayList<Table> TABLELIST = new ArrayList<>();

    public DatabaseConfiguration(Context context, String databaseName, int databaseVersion) {
        this.CONTEXT = context;
        this.DATABASE_NAME = databaseName;
        this.DATABASE_VERSION = databaseVersion;
    }

    public void createTables(ArrayList<Table> tableList) {
        this.TABLELIST = tableList;
    }
}
