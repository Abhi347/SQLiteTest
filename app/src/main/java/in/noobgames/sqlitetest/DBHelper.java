package in.noobgames.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhishek on 25-01-2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "StudentTest.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_COURSE = "course";
    public static final String COLUMN_CONTACT = "contact";
    public static final String COLUMN_EMAIL = "email";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                    COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    COLUMN_COURSE + TEXT_TYPE + COMMA_SEP +
                    COLUMN_CONTACT + TEXT_TYPE + COMMA_SEP +
                    COLUMN_EMAIL + TEXT_TYPE +
                    " )";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Ignore
    }
}
