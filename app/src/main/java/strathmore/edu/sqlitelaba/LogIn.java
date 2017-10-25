package strathmore.edu.sqlitelaba;

/**
 * Created by Jeremy on 24/10/2017.
 */

public class LogIn {
    int _id;
    String _username;
    String _password;

    public LogIn(){}

    public LogIn(int id, String _username, String _password){

        this._id =id;
        this._username = _username;
        this._password = _password;

    }
    //constructors
    public LogIn(String _username, String _password) {
        this._username = _username;
        this._password = _password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
