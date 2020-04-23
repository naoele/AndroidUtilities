package com.naoele.androidutilities.Utils;

import android.app.Application;

class ApplicationUtility extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextUtility.onCreateApplication(getApplicationContext());
    }
}
