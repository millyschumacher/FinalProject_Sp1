package com.example.owner.moon_observation_logger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * MySQLiteHelper()
 * This class performs database actions such as creating a table
 * and upgrading to a current version if applicable
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    //Table name
    public static final String TABLE_COMMENTS = "comments";
    //Database name
    private static final String DATABASE_NAME = "commments.db";
    //This is the version number
    private static final int DATABASE_VERSION = 2;


    private static final String DATABASE_CREATE = String.format(
            "create table %s( %s integer primary key autoincrement, " +
                    "%s text not null+ COLUMN_RATING + \" text);",
            TABLE_COMMENTS);

    /**
     * MySQLiteHelper()
     * This method calls the MySQLiteOpenHelper() constructor
     * @param context
     */
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * The method executes the creation of a database
     * @param database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    /**
     * Upon an upgrade, this method performs the task of dropping the old table
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}
