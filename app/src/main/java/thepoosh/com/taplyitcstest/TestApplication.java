package thepoosh.com.taplyitcstest;

import android.app.Application;

import com.taplytics.sdk.Taplytics;

/**
 * Created by thepoosh on 07/03/16.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Taplytics.startTaplytics(this, "b3b2fc2c7bedfc8568d0295ed9dd44c497ac02a9");
    }
}
