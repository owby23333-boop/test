package com.bytedance.sdk.openadsdk.core.pf;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    private static volatile long g;
    private static volatile boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f1292a;
    private final Queue<z> dl = new LinkedList();

    protected abstract long dl();

    protected abstract int g();

    protected g() {
    }

    private synchronized boolean g(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iG = g();
        long jDl = dl();
        if (this.dl.size() > 0 && this.dl.size() >= iG) {
            long jAbs = Math.abs(jCurrentTimeMillis - this.dl.peek().z);
            if (jAbs <= jDl) {
                g(jDl - jAbs);
                return true;
            }
            this.dl.poll();
            this.dl.offer(new z(jCurrentTimeMillis, str));
        } else {
            this.dl.offer(new z(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean z(String str) {
        if (g(str)) {
            z(true);
            z(g);
        } else {
            z(false);
        }
        return z;
    }

    private void z(long j) {
        if (this.f1292a == null) {
            this.f1292a = new Handler(Looper.getMainLooper());
        }
        this.f1292a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pf.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.z(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(boolean z2) {
        z = z2;
    }

    public boolean a() {
        return z;
    }

    private synchronized void g(long j) {
        g = j;
    }

    public synchronized String gc() {
        String str;
        HashMap map = new HashMap();
        for (z zVar : this.dl) {
            if (map.containsKey(zVar.g)) {
                map.put(zVar.g, Integer.valueOf(((Integer) map.get(zVar.g)).intValue() + 1));
            } else {
                map.put(zVar.g, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    private static class z {
        private final String g;
        private final long z;

        private z(long j, String str) {
            this.z = j;
            this.g = str;
        }
    }
}
