package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    static class a extends Application {
        private final Context Zf;

        a(Context context) {
            this.Zf = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.Zf;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.Zf.getApplicationInfo();
        }
    }

    public static Context aw(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : !applicationContext.getClassLoader().equals(context.getClassLoader()) ? new a(context) : context.getApplicationContext();
    }
}
