package com.sntech.stat;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: renamed from: com.sntech.stat.do, reason: invalid class name */
/* JADX INFO: compiled from: SNC.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean f125do = false;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final String[] f126for;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static boolean f127if = false;

    static {
        Executors.newScheduledThreadPool(1);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).build();
        f126for = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET"};
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static synchronized void m144do(final Context context) {
        if (f125do && f127if) {
            return;
        }
        String[] strArr = f126for;
        int length = strArr.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = true;
                break;
            } else if (context.checkCallingOrSelfPermission(strArr[i2]) != 0) {
                break;
            } else {
                i2++;
            }
        }
        if (!z2) {
            new Handler().postDelayed(new Runnable() { // from class: com.sntech.stat.a
                @Override // java.lang.Runnable
                public final void run() {
                    Cdo.m145if(context);
                }
            }, 30000L);
        } else if (!f127if || !f125do) {
            f127if = true;
            f125do = true;
        }
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static /* synthetic */ void m145if(Context context) {
        if (f125do) {
            return;
        }
        f125do = true;
    }
}
