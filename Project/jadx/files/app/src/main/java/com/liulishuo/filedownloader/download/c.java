package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.h0.c;
import com.liulishuo.filedownloader.services.i;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: CustomComponentHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private com.liulishuo.filedownloader.services.c a;
    private c.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c.b f17132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c.e f17133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.liulishuo.filedownloader.e0.a f17134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c.d f17135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private i f17136g;

    /* JADX INFO: compiled from: CustomComponentHolder.java */
    private static final class a {
        private static final c a = new c();
    }

    private c.a f() {
        c.a aVar = this.b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.b == null) {
                this.b = h().a();
            }
        }
        return this.b;
    }

    private c.b g() {
        c.b bVar = this.f17132c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f17132c == null) {
                this.f17132c = h().b();
            }
        }
        return this.f17132c;
    }

    private com.liulishuo.filedownloader.services.c h() {
        com.liulishuo.filedownloader.services.c cVar = this.a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new com.liulishuo.filedownloader.services.c();
            }
        }
        return this.a;
    }

    public static c i() {
        return a.a;
    }

    private c.e j() {
        c.e eVar = this.f17133d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f17133d == null) {
                this.f17133d = h().f();
            }
        }
        return this.f17133d;
    }

    public com.liulishuo.filedownloader.d0.b a(String str) throws IOException {
        return g().a(str);
    }

    public i b() {
        i iVar = this.f17136g;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f17136g == null) {
                this.f17136g = h().d();
            }
        }
        return this.f17136g;
    }

    public c.d c() {
        c.d dVar = this.f17135f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f17135f == null) {
                this.f17135f = h().e();
            }
        }
        return this.f17135f;
    }

    public int d() {
        return h().g();
    }

    public boolean e() {
        return j().a();
    }

    public com.liulishuo.filedownloader.g0.a a(File file) throws IOException {
        return j().a(file);
    }

    public com.liulishuo.filedownloader.e0.a a() {
        com.liulishuo.filedownloader.e0.a aVar = this.f17134e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f17134e == null) {
                this.f17134e = h().c();
                a(this.f17134e.a());
            }
        }
        return this.f17134e;
    }

    public int a(int i2, String str, String str2, long j2) {
        return f().a(i2, str, str2, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:83:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.liulishuo.filedownloader.e0.a.InterfaceC0484a r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.c.a(com.liulishuo.filedownloader.e0.a$a):void");
    }
}
