package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static Context aV(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        if (!applicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new a(context);
        }
        return context.getApplicationContext();
    }

    static class a extends Application {
        private final Context atW;

        a(Context context) {
            this.atW = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.atW.getApplicationInfo();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.atW;
        }
    }
}
