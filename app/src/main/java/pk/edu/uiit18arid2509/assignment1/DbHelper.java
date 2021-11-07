package pk.edu.uiit18arid2509.assignment1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String database_name = "MyDatabase";
    private static final String table_name = "signup";
    private static final String table_col_name = "signup";
    private static final int db_version = 1;
    SQLiteDatabase sqLiteDatabase;

    public DbHelper(Context context){
        super(context,database_name,null,db_version);
        sqLiteDatabase = this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + table_name+ "( user_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name VARCHAR,user_email VARCHAR, user_phone VARCHAR,user_password VARCHAR, user_country VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }
    public  long singup(String name,String email, String password, String phone,String country){
        // SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name",name);
        contentValues .put("user_email", email);
        contentValues.put("user_phone", phone);
        contentValues.put("user_password", password);

        contentValues.put("user_country", country);

        long user_data= sqLiteDatabase.insert(table_name,null,contentValues);
        return user_data;

    }
    public Cursor login(String email, String password){
        // SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor user_data = sqLiteDatabase.rawQuery("SELECT * FROM  " + table_name + " Where user_email='"+ email + "'"+ "AND user_password = '"+ password + "'",null );
        return user_data;
    }
}
