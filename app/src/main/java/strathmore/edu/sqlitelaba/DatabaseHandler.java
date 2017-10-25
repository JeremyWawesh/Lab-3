package strathmore.edu.sqlitelaba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 19/10/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //All Static variables
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "contactsManager";

    //Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    //variables for contacts
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    //LogIn table name
    private static final String TABLE_LOGIN = "login";
    //variables for login
    private static final String LOG_ID = "id";
    private static final String LOG_NAME = "username";
    private static final String LOG_PASS = "password";

    //SigUp table name
    private static final String TABLE_SIGNUP = "signup";
    //variables for Signup
    private static final String SIG_ID = "id";
    private static final String SIG_FIRSTNAME = "first_name";
    private static final String SIG_LASTNAME = "last_name";
    private static final String SIG_PHONENUMBER = "phone_number";
    private static final String SIG_PASSWORD = "password";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //Creating Tables

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT" + ")";
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "(" + LOG_ID + " INTEGER PRIMARY KEY," + LOG_NAME + " TEXT," + LOG_PASS + " TEXT" + ")";
        String CREATE_SIGNUP_TABLE = "CREATE TABLE " + TABLE_SIGNUP + "(" + SIG_ID + " INTEGER PRIMARY KEY," + SIG_FIRSTNAME + " TEXT," + SIG_LASTNAME + " TEXT," + SIG_PHONENUMBER + " TEXT," + SIG_PASSWORD + " TEXT" + ")";
        Log.e("errr", CREATE_CONTACTS_TABLE);
        Log.e("errr", CREATE_LOGIN_TABLE);
        Log.e("errr", CREATE_SIGNUP_TABLE);
        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_SIGNUP_TABLE);
    }

    //Upgrading database

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIGNUP);

        // Create database
        onCreate(db);
    }

    //Adding new contact
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.get_name());//Contact Name
        values.put(KEY_PH_NO, contact.get_phone_number());//Contact Phone Number

        //Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); //Closing database connection

    }

    //Adding LogIn
    public void addLogIn(LogIn logIn) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LOG_NAME, logIn.get_username());//Log in Phone Number
        values.put(LOG_PASS, logIn.get_password());//Log in password

        //Inserting Row
        db.insert(TABLE_LOGIN, null, values);
        db.close(); //Closing database connection

    }

    //Adding Sign up
    public void addSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SIG_FIRSTNAME, signup.getFirst_name());//SignUp Phone Number
        values.put(SIG_LASTNAME, signup.getLast_name());//SignUp id;
        values.put(SIG_PHONENUMBER, signup.get_phone_number());//SignUp id;
        values.put(SIG_PASSWORD, signup.get_password());//SignUp password;

        //Inserting Row
        db.insert(TABLE_SIGNUP, null, values);
        db.close(); //Closing database connection

    }

    //Getting single contact
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        //return contact
        return contact;


    }

    public LogIn getLogIn(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOGIN, new String[]{LOG_ID, LOG_NAME, LOG_PASS}, LOG_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        LogIn login = new LogIn(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        //return contact
        return login;


    }

    public Signup getSignUp(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SIGNUP, new String[]{SIG_ID, SIG_FIRSTNAME, SIG_LASTNAME, SIG_LASTNAME, SIG_PHONENUMBER, SIG_PASSWORD}, SIG_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Signup signup = new Signup(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        //return contact
        return signup;


    }

    //Getting All Contacts
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        //Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));
                //Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        //return conent list
        return contactList;
    }

    //Getting All LogIn
    public List<LogIn> getAllLogIn() {
        List<LogIn> logInList = new ArrayList<LogIn>();
        //Select All Query
        String selectQuery = "SELECT  *FROM " + TABLE_LOGIN + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                LogIn logIn = new LogIn();
                logIn.set_id(Integer.parseInt(cursor.getString(0)));
                logIn.set_username(cursor.getString(1));
                logIn.set_password(cursor.getString(2));

                //Adding contact to list
                logInList.add(logIn);
            } while (cursor.moveToNext());
        }
        //return content list
        return logInList;
    }

    //Getting All SignUp
    public List<Signup> getAllSignup() {
        List<Signup> signupList = new ArrayList<Signup>();
        //Select All Query
        String selectQuery = "SELECT  *FROM " + TABLE_SIGNUP + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Signup signup = new Signup();
                signup.set_id(Integer.parseInt(cursor.getString(0)));
                signup.setFirst_name(cursor.getString(1));
                signup.setLast_name(cursor.getString(2));
                signup.set_phone_number(cursor.getString(3));
                signup.set_password(cursor.getString(4));

                //Adding contact to list
                signupList.add(signup);
            } while (cursor.moveToNext());
        }
        //return signup list
        return signupList;
    }

    //Getting Contacts Count
    public int getContactCount() {
        String countQuery = "SELECT *FROM " + TABLE_CONTACTS + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }

    // Getting Log In
    public int getLogInCount() {
        String countQuery = "SELECT *FROM " + TABLE_LOGIN + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }

    //Getting Sign Up
    public int getSignUpCount() {
        String countQuery = "SELECT *FROM " + TABLE_SIGNUP + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }

    //Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.get_name());
        values.put(KEY_PH_NO, contact.get_phone_number());

        //updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " =?", new String[]{String.valueOf(contact.get_id())});
    }

    //Updating single LogIn
    public int updateLogIn(LogIn logIn) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LOG_NAME, logIn.get_username());
        values.put(LOG_PASS, logIn.get_password());

        //updating row
        return db.update(TABLE_LOGIN, values, LOG_ID + " =?", new String[]{String.valueOf(logIn.get_id())});
    }

    //Updating single SignUp
    public int updateSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SIG_FIRSTNAME, signup.getFirst_name());
        values.put(SIG_LASTNAME, signup.getLast_name());
        values.put(SIG_PHONENUMBER, signup.get_phone_number());
        values.put(SIG_PASSWORD, signup.get_password());

        //updating row
        return db.update(TABLE_SIGNUP, values, SIG_ID + " =?", new String[]{String.valueOf(signup.get_id())});
    }

    //Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "= ?", new String[]{String.valueOf(contact.get_id())});
        db.close();
    }

    //Deleting single LogIn
    public void deleteLogIn(LogIn logIn) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOGIN, LOG_ID + "= ?", new String[]{String.valueOf(logIn.get_id())});
        db.close();
    }

    //Deleting single SignUp
    public void deleteSignUp(Signup signup) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SIGNUP, SIG_ID + "= ?", new String[]{String.valueOf(signup.get_id())});
        db.close();
    }
}
