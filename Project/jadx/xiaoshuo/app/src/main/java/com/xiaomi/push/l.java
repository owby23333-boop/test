package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f8158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f876a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f8159b;

    public static Handler a() {
        if (f8159b == null) {
            synchronized (f876a) {
                if (f8159b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f8159b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f8159b;
    }

    private static Handler b() {
        if (f8158a == null) {
            synchronized (l.class) {
                if (f8158a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f8158a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f8158a;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return a(context, broadcastReceiver, intentFilter, (String) null, i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }
}
