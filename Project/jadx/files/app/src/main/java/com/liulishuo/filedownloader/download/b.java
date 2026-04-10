package com.liulishuo.filedownloader.download;

import java.net.ProtocolException;

/* JADX INFO: compiled from: ConnectionProfile.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    final long a;
    final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f17128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f17129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f17130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17131f;

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.download.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConnectionProfile.java */
    public static class C0483b {
        public static b a() {
            return new b();
        }

        public static b b() {
            return new b(0L, 0L, 0L, 0L, true);
        }

        public static b a(long j2) {
            return new b(0L, 0L, -1L, j2);
        }

        public static b a(long j2, long j3, long j4) {
            return new b(j2, j3, -1L, j4);
        }

        public static b a(long j2, long j3, long j4, long j5) {
            return new b(j2, j3, j4, j5);
        }
    }

    public void a(com.liulishuo.filedownloader.d0.b bVar) throws ProtocolException {
        if (this.f17130e) {
            return;
        }
        if (this.f17131f && com.liulishuo.filedownloader.h0.e.a().f17212h) {
            bVar.a("HEAD");
        }
        bVar.addHeader("Range", this.f17128c == -1 ? com.liulishuo.filedownloader.h0.f.a("bytes=%d-", Long.valueOf(this.b)) : com.liulishuo.filedownloader.h0.f.a("bytes=%d-%d", Long.valueOf(this.b), Long.valueOf(this.f17128c)));
    }

    public String toString() {
        return com.liulishuo.filedownloader.h0.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.a), Long.valueOf(this.f17128c), Long.valueOf(this.b));
    }

    private b() {
        this.a = 0L;
        this.b = 0L;
        this.f17128c = 0L;
        this.f17129d = 0L;
        this.f17130e = false;
        this.f17131f = true;
    }

    private b(long j2, long j3, long j4, long j5) {
        this(j2, j3, j4, j5, false);
    }

    private b(long j2, long j3, long j4, long j5, boolean z2) {
        if ((j2 == 0 && j4 == 0) || !z2) {
            this.a = j2;
            this.b = j3;
            this.f17128c = j4;
            this.f17129d = j5;
            this.f17130e = z2;
            this.f17131f = false;
            return;
        }
        throw new IllegalArgumentException();
    }
}
