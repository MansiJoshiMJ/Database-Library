package com.otfcoder.sqlitehelperlibrary;

import java.util.HashMap;

public class Table {

    String tableName = "";
    HashMap<String, String> fieldList = new HashMap<>();

    public Table(String tableName, HashMap<String, String> fieldList) {
        this.tableName = tableName;
        if (fieldList != null)
            this.fieldList = fieldList;
    }
}
