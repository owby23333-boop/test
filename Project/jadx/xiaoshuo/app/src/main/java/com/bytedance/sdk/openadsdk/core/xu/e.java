package com.bytedance.sdk.openadsdk.core.xu;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.lc;
import com.bytedance.sdk.openadsdk.core.lc.vn;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private static volatile boolean bf;
    private static volatile long d;
    private static volatile e e;
    private Handler ga;
    private final Queue<C0168e> tg = new LinkedList();
    private final vn vn = lc.bf();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.xu.e$e, reason: collision with other inner class name */
    public static class C0168e {
        private final String bf;
        private final long e;

        private C0168e(long j, String str) {
            this.e = j;
            this.bf = str;
        }
    }

    private e() {
    }

    private synchronized boolean bf(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iWl = this.vn.wl();
        long jCv = this.vn.cv();
        if (this.tg.size() <= 0 || this.tg.size() < iWl) {
            this.tg.offer(new C0168e(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.tg.peek().e);
            if (jAbs <= jCv) {
                bf(jCv - jAbs);
                return true;
            }
            this.tg.poll();
            this.tg.offer(new C0168e(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized String d() {
        String str;
        HashMap map = new HashMap();
        for (C0168e c0168e : this.tg) {
            if (map.containsKey(c0168e.bf)) {
                map.put(c0168e.bf, Integer.valueOf(((Integer) map.get(c0168e.bf)).intValue() + 1));
            } else {
                map.put(c0168e.bf, 1);
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

    public static e e() {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e();
                }
            }
        }
        return e;
    }

    public synchronized boolean e(String str) {
        if (bf(str)) {
            e(true);
            e(d);
        } else {
            e(false);
        }
        return bf;
    }

    private synchronized void e(long j) {
        if (this.ga == null) {
            this.ga = new Handler(Looper.getMainLooper());
        }
        this.ga.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xu.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.e(false);
            }
        }, j);
    }

    public synchronized boolean bf() {
        return bf;
    }

    private synchronized void bf(long j) {
        d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(boolean z) {
        bf = z;
    }
}
