package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;

/* JADX INFO: compiled from: DownloadRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.liulishuo.filedownloader.download.a f17137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final g f17138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f17139u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f17140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f f17141w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f17142x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f17143y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final int f17144z;

    /* JADX INFO: compiled from: DownloadRunnable.java */
    public static class b {
        private final a.b a = new a.b();
        private g b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f17145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f17146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f17147e;

        public b a(g gVar) {
            this.b = gVar;
            return this;
        }

        public b b(String str) {
            this.f17145c = str;
            return this;
        }

        public b c(String str) {
            this.a.b(str);
            return this;
        }

        public b a(int i2) {
            this.a.a(i2);
            return this;
        }

        public b a(String str) {
            this.a.a(str);
            return this;
        }

        public b a(FileDownloadHeader fileDownloadHeader) {
            this.a.a(fileDownloadHeader);
            return this;
        }

        public b a(com.liulishuo.filedownloader.download.b bVar) {
            this.a.a(bVar);
            return this;
        }

        public b a(boolean z2) {
            this.f17146d = Boolean.valueOf(z2);
            return this;
        }

        public b a(Integer num) {
            this.f17147e = num;
            return this;
        }

        public d a() {
            if (this.b != null && this.f17145c != null && this.f17146d != null && this.f17147e != null) {
                com.liulishuo.filedownloader.download.a aVarA = this.a.a();
                return new d(aVarA.a, this.f17147e.intValue(), aVarA, this.b, this.f17146d.booleanValue(), this.f17145c);
            }
            throw new IllegalArgumentException(com.liulishuo.filedownloader.h0.f.a("%s %s %B", this.b, this.f17145c, this.f17146d));
        }
    }

    private long c() {
        com.liulishuo.filedownloader.e0.a aVarA = c.i().a();
        if (this.f17144z < 0) {
            FileDownloadModel fileDownloadModelD = aVarA.d(this.f17143y);
            if (fileDownloadModelD != null) {
                return fileDownloadModelD.g();
            }
            return 0L;
        }
        for (com.liulishuo.filedownloader.model.a aVar : aVarA.c(this.f17143y)) {
            if (aVar.d() == this.f17144z) {
                return aVar.a();
            }
        }
        return 0L;
    }

    public void a() {
        b();
    }

    public void b() {
        this.f17142x = true;
        f fVar = this.f17141w;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.run():void");
    }

    private d(int i2, int i3, com.liulishuo.filedownloader.download.a aVar, g gVar, boolean z2, String str) {
        this.f17143y = i2;
        this.f17144z = i3;
        this.f17142x = false;
        this.f17138t = gVar;
        this.f17139u = str;
        this.f17137s = aVar;
        this.f17140v = z2;
    }
}
