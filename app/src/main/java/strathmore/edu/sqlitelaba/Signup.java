package strathmore.edu.sqlitelaba;

/**
 * Created by Jeremy on 24/10/2017.
 */

public class Signup {
    int _id;
    String first_name;
    String last_name;
    String _phone_number;
    String _password;

    public Signup() {
    }

    public Signup(int id, String first_name, String _phone_number, String last_name, String _password) {

        this._id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this._phone_number = _phone_number;
        this._password = _password;

    }

    //constructors
    public Signup(String first_name, String _phone_number, String last_name, String _password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this._phone_number = _phone_number;
        this._password = _password;
    }

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String get_phone_number() {
        return _phone_number;
    }
    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }
    public String get_password() {
        return _password;
    }
    public void set_password(String _password) {
        this._password = _password;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
