package com.sn.android;

import a0.g;
import android.content.Context;
import androidx.annotation.NonNull;
import com.anythink.expressad.video.module.a.a.m;
import com.sntech.net.DomainProvider;
import java.lang.Thread;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sn.android.if, reason: invalid class name */
/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cif implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static Cif f67for;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public Context f68do;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public Thread.UncaughtExceptionHandler f69if;

    public Cif(Context context) {
        this.f68do = context;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Cif m84do(Context context) {
        if (f67for == null) {
            synchronized (Cif.class) {
                if (f67for == null) {
                    f67for = new Cif(context);
                }
            }
        }
        return f67for;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        try {
            m85do(th);
        } catch (Exception e2) {
            String str = "handleException Error: " + e2;
            e2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f69if;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f69if.uncaughtException(thread, th);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void m85do(Throwable th) {
        if (this.f68do.getSharedPreferences("prefs_sn_android", 0).getBoolean("crash_handler_enabled", false)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception", e0.d.a(th));
                jSONObject.put("timestamp", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            StringBuilder sb = new StringBuilder();
            MediaType mediaType = g.a;
            sb.append(DomainProvider.baseUrl());
            sb.append("/er");
            String string = sb.toString();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("event", "APP_CRASHED");
                jSONObject2.put("event_extra", jSONObject);
                com.sntech.net.Cif.m103if(string, jSONObject2, false, new Cdo(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                Thread.sleep(m.ag);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }
}
