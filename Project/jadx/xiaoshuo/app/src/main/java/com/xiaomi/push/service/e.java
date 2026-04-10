package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<a> f8298a = new CopyOnWriteArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8299a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f1028a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1029a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1030a;

        public a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f1029a = str;
            this.f1028a = j;
            this.f8299a = i;
            this.f1030a = actionArr;
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m612a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ay.m761a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        f8298a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = f8298a.size() - 1; size >= 0; size--) {
            a aVar = f8298a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f1028a > 5000) {
                f8298a.remove(aVar);
            }
        }
        if (f8298a.size() > 10) {
            f8298a.remove(0);
        }
    }
}
