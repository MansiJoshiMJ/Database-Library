package com.otfcoder.sqlitehelperlibrary;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

public class SQLiteHelper extends SQLiteOpenHelper {

    DatabaseConfiguration databaseConfig;

    public SQLiteHelper(DatabaseConfiguration databaseConfig) {
        super(databaseConfig.CONTEXT, databaseConfig.DATABASE_NAME, null, databaseConfig.DATABASE_VERSION);
        this.databaseConfig = databaseConfig;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            for (Table table: databaseConfig.TABLELIST) {
                String tableString = "CREATE TABLE IF NOT EXISTS " + table.tableName + "(";

                int length = table.fieldList.size();
                int counter = 1;
                for (Map.Entry<String, String> entry: table.fieldList.entrySet()) {
                    tableString += entry.getKey() + " " + entry.getValue();
                    if (counter < length)
                        tableString += ", ";
                    counter++;
                }

                tableString += ")";
                sqLiteDatabase.execSQL(tableString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long insertRecord(Table table) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (Map.Entry<String, String> entry: table.fieldList.entrySet()) {
            values.put(entry.getKey(), entry.getValue());
        }

        long newRowId = db.insert(table.tableName, null, values);
        db.close();

        return  newRowId;
    }

    public HashMap<String, String> getAllDataFromTable(Table table) {

        HashMap<String, String> dataList = new HashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table.tableName, null);

        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                for (Map.Entry<String, String> entry: table.fieldList.entrySet()) {
                    dataList.put(entry.getKey(), cursor.getString(cursor.getColumnIndex(entry.getValue())));
                }
            }
        }

        db.close();

        return dataList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
