package com.amgcyo.cuttadon.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ActivityLifecycleCallbacksImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        activity.getIntent().removeExtra("isInitToolbar");
        try {
            ((BaseTitleBarActivity) activity).removeViewImmediate();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull final Activity activity) {
        try {
            BaseTitleBarActivity baseTitleBarActivity = (BaseTitleBarActivity) activity;
            if (baseTitleBarActivity.isNeedNightModel) {
                baseTitleBarActivity.setChipioAppNightModel();
            } else {
                baseTitleBarActivity.removeViewImmediate();
            }
        } catch (Exception unused) {
        }
        if (activity.getIntent().getBooleanExtra("isInitToolbar", false)) {
            return;
        }
        activity.getIntent().putExtra("isInitToolbar", true);
        if (activity.findViewById(R.id.toolbar) != null) {
            if (activity instanceof AppCompatActivity) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                appCompatActivity.setSupportActionBar((Toolbar) activity.findViewById(R.id.toolbar));
                appCompatActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
            } else if (Build.VERSION.SDK_INT >= 21) {
                activity.setActionBar((android.widget.Toolbar) activity.findViewById(R.id.toolbar));
                activity.getActionBar().setDisplayShowTitleEnabled(false);
            }
        }
        View viewFindViewById = activity.findViewById(R.id.toolbar_back);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.app.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    activity.onBackPressed();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }
}
