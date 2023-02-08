package com.example.pushtest;

import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyfirebaseIDService";

    @Override
    public void onTokenRefresh(){
        String token = FirebaseInstanceID.getInstance().getToken();
        Log.e(TAG,token);

        sendPegistrationToServer(token);

    }

    private void sendPegistrationToServer(String token){

    }

}
