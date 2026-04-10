package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bf implements Runnable {
    final Handler a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f18657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<ba> f18659f = new LinkedList();
    long b = 5000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f18660g = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f18656c = true;

    bf(Handler handler, String str) {
        this.a = handler;
        this.f18658e = str;
    }

    private Thread e() {
        return this.a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.f18656c && SystemClock.uptimeMillis() >= this.f18657d + this.b;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f18657d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f18659f) {
            arrayList = new ArrayList(this.f18659f.size());
            for (int i2 = 0; i2 < this.f18659f.size(); i2++) {
                ba baVar = this.f18659f.get(i2);
                if (!baVar.f18644e && jCurrentTimeMillis - baVar.b < 200000) {
                    arrayList.add(baVar);
                    baVar.f18644e = true;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long jNanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e2) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e2.getMessage());
            sb.append("\n");
            al.a(e2);
        }
        long jNanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.f18643d = jNanoTime2 - jNanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.a = name;
        synchronized (this.f18659f) {
            while (this.f18659f.size() >= 32) {
                this.f18659f.remove(0);
            }
            this.f18659f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18656c = true;
        this.b = this.f18660g;
    }
}
