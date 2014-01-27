package com.usc.mylab.helpers;

/**
 * Created by kanchanapratharasappan on 11/28/13.
 */
public class Contact {

    //private variables
    int _id;
    String _name;
    String _phone_number;
    String _email_id;
    String _other_details;
    String date;
    byte[] image;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String _phone_number,String _email_id,String _other_details,String date,byte[] image){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this._email_id = _email_id;
        this._other_details = _other_details;
        this.date = date;
        this.image = image;
    }

    // constructor
    public Contact(String name, String _phone_number, String _email_id, String _other_details,String date,byte[] image){
        this._name = name;
        this._phone_number = _phone_number;
        this._email_id = _email_id;
        this._other_details = _other_details;
        this.date = date;
        this.image = image;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    public String get_email_id() {
        return _email_id;
    }

    public void set_email_id(String _email_id) {
        this._email_id = _email_id;
    }

    public String get_other_details() {
        return _other_details;
    }

    public void set_other_details(String _other_details) {
        this._other_details = _other_details;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}