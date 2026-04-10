package com.google.android.play.core.splitcompat;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class SplitCompatApplication extends Application {
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.install(this);
    }
}
