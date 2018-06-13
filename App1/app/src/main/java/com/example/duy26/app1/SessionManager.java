package com.example.duy26.app1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class SessionManager {
    private static final String TAG = SessionManager.class.getSimpleName();;
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "LoginAndregister";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static  final String  key_admin = "admin";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {


        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }


    public void  admin(boolean admin)
    {
        editor.putBoolean(key_admin, admin);
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }
    public  boolean admin(){
        return pref.getBoolean(key_admin,false);
    }
}
