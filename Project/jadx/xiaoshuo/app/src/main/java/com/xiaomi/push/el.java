package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.util.Date;

/* JADX INFO: loaded from: classes8.dex */
class el implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ek f7921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ String f290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ Throwable f291a;

    public el(ek ekVar, String str, Throwable th) {
        this.f7921a = ekVar;
        this.f290a = str;
        this.f291a = th;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        ek.f287a.add(new Pair(String.format("%1$s %2$s %3$s ", ek.f286a.format(new Date()), this.f7921a.f7920b, this.f290a), this.f291a));
        if (ek.f287a.size() > 20000) {
            int size = (ek.f287a.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    if (ek.f287a.size() > 0) {
                        ek.f287a.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            ek.f287a.add(new Pair(String.format("%1$s %2$s %3$s ", ek.f286a.format(new Date()), this.f7921a.f7920b, "flush " + size + " lines logs."), null));
        }
        try {
            this.f7921a.m325a();
        } catch (Exception e) {
            Log.e(this.f7921a.f7920b, "", e);
        }
    }
}
