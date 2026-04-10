package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class na {
    private static final AtomicLong m = new AtomicLong(1000);
    private static z pf;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private lk f294a;
    private lk dl;
    private long e;
    private long fo = -1;
    private final gb g;
    private String gc;
    private int gz;
    private String i;
    private long kb;
    private volatile boolean uy;
    private zz v;
    private int wp;
    private final bv z;

    na(gb gbVar, bv bvVar) {
        this.g = gbVar;
        this.z = bvVar;
    }

    public String z() {
        return this.gc;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    synchronized android.os.Bundle z(long r5, long r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bytedance.embedapplog.bv r0 = r4.z     // Catch: java.lang.Throwable -> L51
            boolean r0 = r0.m()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L4e
            boolean r0 = r4.dl()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L4e
            long r0 = r4.e     // Catch: java.lang.Throwable -> L51
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L4e
            long r0 = r5 - r0
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 <= 0) goto L4e
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Throwable -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = "session_no"
            int r0 = r4.wp     // Catch: java.lang.Throwable -> L51
            r7.putInt(r8, r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = "send_times"
            int r0 = r4.gz     // Catch: java.lang.Throwable -> L51
            int r0 = r0 + 1
            r4.gz = r0     // Catch: java.lang.Throwable -> L51
            r7.putInt(r8, r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = "current_duration"
            long r0 = r4.e     // Catch: java.lang.Throwable -> L51
            long r0 = r5 - r0
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            r7.putLong(r8, r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = "session_start_time"
            long r0 = r4.fo     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = com.bytedance.embedapplog.sd.g(r0)     // Catch: java.lang.Throwable -> L51
            r7.putString(r8, r0)     // Catch: java.lang.Throwable -> L51
            r4.e = r5     // Catch: java.lang.Throwable -> L51
            goto L4f
        L4e:
            r7 = 0
        L4f:
            monitor-exit(r4)
            return r7
        L51:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.na.z(long, long):android.os.Bundle");
    }

    public boolean g() {
        return this.uy;
    }

    boolean dl() {
        return g() && this.kb == 0;
    }

    private synchronized void z(sd sdVar, ArrayList<sd> arrayList, boolean z2) {
        long j = sdVar instanceof z ? -1L : sdVar.g;
        this.gc = UUID.randomUUID().toString();
        m.set(1000L);
        this.fo = j;
        this.uy = z2;
        this.kb = 0L;
        this.e = 0L;
        if (cb.g) {
            cb.z("startSession, " + this.gc + ", hadUi:" + z2 + " data:" + sdVar, null);
        }
        if (z2) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.i)) {
                this.i = this.z.dl();
                this.wp = this.z.a();
            }
            if (!string.equals(this.i)) {
                this.i = string;
                this.wp = 1;
            } else {
                this.wp++;
            }
            this.z.z(string, this.wp);
            this.gz = 0;
            this.e = sdVar.g;
        }
        if (j != -1) {
            zz zzVar = new zz(false);
            zzVar.f299a = this.gc;
            zzVar.dl = a();
            zzVar.g = this.fo;
            zzVar.v = this.uy ? false : true;
            zzVar.i = this.g.dl();
            zzVar.wp = this.g.g();
            zzVar.m = com.bytedance.embedapplog.z.kb();
            zzVar.e = com.bytedance.embedapplog.z.uy();
            if (this.z.iq()) {
                zzVar.gz = com.bytedance.embedapplog.z.gc();
            }
            arrayList.add(zzVar);
            this.v = zzVar;
            if (cb.g) {
                cb.z("gen launch, " + zzVar.f299a + ", hadUi:" + z2, null);
            }
        }
    }

    public static boolean z(sd sdVar) {
        if (sdVar instanceof lk) {
            return ((lk) sdVar).uy();
        }
        return false;
    }

    boolean z(sd sdVar, ArrayList<sd> arrayList) {
        boolean z2 = sdVar instanceof lk;
        boolean z3 = z(sdVar);
        boolean z4 = true;
        if (this.fo == -1) {
            z(sdVar, arrayList, z(sdVar));
        } else if (!this.uy && z3) {
            z(sdVar, arrayList, true);
        } else if (this.kb == 0 || sdVar.g <= this.kb + this.z.io()) {
            if (this.fo > sdVar.g + 7200000) {
                z(sdVar, arrayList, z3);
            } else {
                z4 = false;
            }
        } else if (!o.g() && o.z()) {
            z(sdVar, arrayList, z3);
        }
        if (z2) {
            lk lkVar = (lk) sdVar;
            if (lkVar.uy()) {
                this.kb = 0L;
                arrayList.add(sdVar);
                if (TextUtils.isEmpty(lkVar.i)) {
                    if (this.f294a != null && (lkVar.g - this.f294a.g) - this.f294a.wp < 500) {
                        lkVar.i = this.f294a.v;
                    } else if (this.dl != null && (lkVar.g - this.dl.g) - this.dl.wp < 500) {
                        lkVar.i = this.dl.v;
                    }
                }
            } else {
                Bundle bundleZ = z(sdVar.g, 0L);
                if (bundleZ != null) {
                    com.bytedance.embedapplog.z.z("play_session", bundleZ);
                }
                this.kb = lkVar.g;
                arrayList.add(sdVar);
                if (lkVar.kb()) {
                    this.dl = lkVar;
                } else {
                    this.f294a = lkVar;
                    this.dl = null;
                }
            }
        } else if (!(sdVar instanceof z)) {
            arrayList.add(sdVar);
        }
        g(sdVar);
        return z4;
    }

    public void g(sd sdVar) {
        if (sdVar != null) {
            if (this.z.iq()) {
                sdVar.gz = com.bytedance.embedapplog.z.gc();
            }
            sdVar.m = com.bytedance.embedapplog.z.kb();
            sdVar.e = com.bytedance.embedapplog.z.uy();
            sdVar.f299a = this.gc;
            sdVar.dl = a();
        }
    }

    public static long a() {
        return m.incrementAndGet();
    }

    static class z extends u {
        private z() {
        }
    }

    static z gc() {
        if (pf == null) {
            pf = new z();
        }
        pf.g = System.currentTimeMillis();
        return pf;
    }
}
