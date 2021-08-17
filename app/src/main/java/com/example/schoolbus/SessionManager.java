package com.example.schoolbus;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManager (Context context){
        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void setLogin(int login){
        editor.putInt("KEY_LOGIN", login);
        editor.commit();
    }

    public int getLogin(){
        return sharedPreferences.getInt("KEY_LOGIN", 0);
    }

    public void setUsername(String username){
        editor.putString("KEY_USERNAME", username);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString("KEY_USERNAME", "");
    }

    public void setUserId(int userId){
        editor.putInt("KEY_USERID", userId);
        editor.commit();
    }

    public int getUserId(){
        return sharedPreferences.getInt("KEY_USERID", 0);
    }
}
