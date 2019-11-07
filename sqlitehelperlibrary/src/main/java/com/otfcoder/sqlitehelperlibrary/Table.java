package com.otfcoder.sqlitehelperlibrary;

import java.util.HashMap;

public class Table {

    String tableName = "";
    HashMap<String, String> fieldList = new HashMap<>();
    public String whereClause = "";
    public String[] whereArgs = new String[] {};

    public Table(String tableName, HashMap<String, String> fieldList) {
        this.tableName = tableName;
        if (fieldList != null)
            this.fieldList = fieldList;
    }
}