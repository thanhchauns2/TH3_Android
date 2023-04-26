package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class HouseDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "houses";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_AREA = "area";
    private static final String COLUMN_RENT_PRICE = "rent_price";
    private static final String COLUMN_ELECTRICITY_PRICE = "electricity_price";
    private static final String COLUMN_WATER_PRICE = "water_price";
    private static final String COLUMN_AREA_CODE = "area_code";

    public HouseDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_AREA + " REAL, " +
                COLUMN_RENT_PRICE + " REAL, " +
                COLUMN_ELECTRICITY_PRICE + " REAL, " +
                COLUMN_WATER_PRICE + " REAL, " +
                COLUMN_AREA_CODE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addHouse(House house) {
        SQLiteDatabase db = getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_NAME +
                " (" + COLUMN_AREA + ", " +
                COLUMN_RENT_PRICE + ", " +
                COLUMN_ELECTRICITY_PRICE + ", " +
                COLUMN_WATER_PRICE + ", " +
                COLUMN_AREA_CODE + ")" +
                " VALUES (" +
                house.getArea() + ", " +
                house.getRentPrice() + ", " +
                house.getElectricityPrice() + ", " +
                house.getWaterPrice() + ", " +
                "'" + house.getAreaCode() + "'" +
                ")";
        db.execSQL(insertQuery);
        db.close();
    }

    public void deleteHouse(House house) {
        SQLiteDatabase db = getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TABLE_NAME +
                " WHERE " + COLUMN_ID + " = " + house.getId();
        db.execSQL(deleteQuery);
        db.close();
    }

    public List<House> getAllHouses() {
        List<House> houses = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                double area = cursor.getDouble(cursor.getColumnIndex(COLUMN_AREA));
                double rentPrice = cursor.getDouble(cursor.getColumnIndex(COLUMN_RENT_PRICE));
                double electricityPrice = cursor.getDouble(cursor.getColumnIndex(COLUMN_ELECTRICITY_PRICE));
                double waterPrice = cursor.getDouble(cursor.getColumnIndex(COLUMN_WATER_PRICE));
                String areaCode = cursor.getString(cursor.getColumnIndex(COLUMN_AREA_CODE));
                House house = new House(id, area, rentPrice, electricityPrice, waterPrice, areaCode);
                houses.add(house);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return houses;
    }
}
