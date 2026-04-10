package com.liulishuo.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* JADX INFO: compiled from: FetchDataTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private final g a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f17158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.liulishuo.filedownloader.d0.b f17159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f17161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f17162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f17163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f17164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f17165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.liulishuo.filedownloader.g0.a f17166l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f17167m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.liulishuo.filedownloader.e0.a f17168n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile long f17169o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile long f17170p;

    /* JADX INFO: compiled from: FetchDataTask.java */
    public static class b {
        d a;
        com.liulishuo.filedownloader.d0.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.liulishuo.filedownloader.download.b f17171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g f17172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f17173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Boolean f17174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Integer f17175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Integer f17176h;

        public b a(com.liulishuo.filedownloader.d0.b bVar) {
            this.b = bVar;
            return this;
        }

        public b b(int i2) {
            this.f17176h = Integer.valueOf(i2);
            return this;
        }

        public b a(com.liulishuo.filedownloader.download.b bVar) {
            this.f17171c = bVar;
            return this;
        }

        public b a(g gVar) {
            this.f17172d = gVar;
            return this;
        }

        public b a(String str) {
            this.f17173e = str;
            return this;
        }

        public b a(boolean z2) {
            this.f17174f = Boolean.valueOf(z2);
            return this;
        }

        public b a(d dVar) {
            this.a = dVar;
            return this;
        }

        public b a(int i2) {
            this.f17175g = Integer.valueOf(i2);
            return this;
        }

        public f a() throws IllegalArgumentException {
            com.liulishuo.filedownloader.d0.b bVar;
            com.liulishuo.filedownloader.download.b bVar2;
            Integer num;
            if (this.f17174f != null && (bVar = this.b) != null && (bVar2 = this.f17171c) != null && this.f17172d != null && this.f17173e != null && (num = this.f17176h) != null && this.f17175g != null) {
                return new f(bVar, bVar2, this.a, num.intValue(), this.f17175g.intValue(), this.f17174f.booleanValue(), this.f17172d, this.f17173e);
            }
            throw new IllegalArgumentException();
        }
    }

    private void c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.liulishuo.filedownloader.h0.f.a(this.f17165k - this.f17169o, jElapsedRealtime - this.f17170p)) {
            d();
            this.f17169o = this.f17165k;
            this.f17170p = jElapsedRealtime;
        }
    }

    private void d() {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f17166l.a();
            z2 = true;
        } catch (IOException e2) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z2 = false;
        }
        if (z2) {
            if (this.f17157c >= 0) {
                this.f17168n.a(this.b, this.f17157c, this.f17165k);
            } else {
                this.a.a();
            }
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.b), Integer.valueOf(this.f17157c), Long.valueOf(this.f17165k), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public void a() {
        this.f17167m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01f9, code lost:
    
        throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.f.b():void");
    }

    private f(com.liulishuo.filedownloader.d0.b bVar, com.liulishuo.filedownloader.download.b bVar2, d dVar, int i2, int i3, boolean z2, g gVar, String str) {
        this.f17169o = 0L;
        this.f17170p = 0L;
        this.a = gVar;
        this.f17164j = str;
        this.f17159e = bVar;
        this.f17160f = z2;
        this.f17158d = dVar;
        this.f17157c = i3;
        this.b = i2;
        this.f17168n = c.i().a();
        this.f17161g = bVar2.a;
        this.f17162h = bVar2.f17128c;
        this.f17165k = bVar2.b;
        this.f17163i = bVar2.f17129d;
    }
}
