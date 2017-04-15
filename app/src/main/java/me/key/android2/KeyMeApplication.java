package me.key.android2;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import io.fabric.sdk.android.Fabric;
import pl.tajchert.nammu.Nammu;
import timber.log.Timber;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Andy on 4/6/2017.
 */

public class KeyMeApplication extends Application {
    private static KeyMeApplication mInstance;

    public static synchronized KeyMeApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //disable crashlytics for debug builds
        Crashlytics crashlyticsKit = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build();
        Fabric.with(this, crashlyticsKit);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.plant(new CrashlyticsTree());
        Nammu.init(this);
    }
}
