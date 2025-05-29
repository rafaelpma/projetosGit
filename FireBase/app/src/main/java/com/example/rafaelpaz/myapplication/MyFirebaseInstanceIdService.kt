package com.example.rafaelpaz.myapplication

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {

    override fun onTokenRefresh()  {
        var refreshedToken = FirebaseInstanceId.getInstance().getToken()

        Log.i("INFO", "Refreshed token: " + refreshedToken);
        //sendRegistrationToServer(refreshedToken);

        // Get updated InstanceID token.
    }

}