package strathmore.edu.sqlitelaba;

/**
 * Created by Jeremy on 19/10/2017.
 */

public class Contact {
    int _id;
    String _name;
    String _phone_number;

    public Contact(){}

    public Contact(int id, String name, String _phone_number){

        this._id =id;
        this._name = name;
        this._phone_number = _phone_number;

    }
    //constructors
    public Contact(String name, String _phone_number) {
        this._name = name;
        this._phone_number = _phone_number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }
}
