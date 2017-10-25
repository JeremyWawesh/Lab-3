package strathmore.edu.sqlitelaba;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        /**
         * CRUD Operations
         **/
        //Inserting details

        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivias", "94123812482"));
        db.addContact(new Contact("Tommy", "96372681287"));
        db.addContact(new Contact("Karthik", "95333333333"));

        db.addLogIn(new LogIn("Ravi", "910"));
        db.addLogIn(new LogIn("Srinivias", "941"));
        db.addLogIn(new LogIn("Tommy", "963"));
        db.addLogIn(new LogIn("Karthik", "953"));

        db.addSignUp(new Signup("Ravi", "Kamau", "9100000000", "910"));
        db.addSignUp(new Signup("Srinivias", "Okello", "94123812482", "941"));
        db.addSignUp(new Signup("Tommy", "Wambua", "96372681287", "963"));
        db.addSignUp(new Signup("Karthik", "Kirii", "95333333333", "953"));

        //Reading all details
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        Log.d("TABLE 1:", "Table Contacts Details");
        for (Contact cn : contacts) {
            String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone Number: " + cn.get_phone_number();
            Log.d("Contacts: ", log);

        }
        Log.d("Reading: ", "Reading all Login..");
        List<LogIn> logIn = db.getAllLogIn();

        Log.d("TABLE 1:", "Table Login Details");
        for (LogIn cn : logIn) {
            String log = "Id: " + cn.get_id() + " ,Username: " + cn.get_username() + " ,Password: " + cn.get_password();
            Log.d("LogIn: ", log);
        }


        Log.d("Reading: ", "Reading all sign up..");
        List<Signup>  signup = db.getAllSignup();

        Log.d("TABLE 1:", "Table Sign Up Details");
        for (Signup cn : signup) {
            String log = "Id: " + cn.get_id() + " ,First Name: " + cn.getFirst_name() + " ,Last Name: " + cn.getLast_name() + " ,Phone number: "
                    + cn.get_phone_number() + " ,Password: " + cn.get_password();
            Log.d("Signup: ", log);
        }




    }





}
