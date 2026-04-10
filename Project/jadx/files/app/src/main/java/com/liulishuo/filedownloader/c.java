package com.liulishuo.filedownloader;

import android.text.TextUtils;
import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.d;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.liulishuo.filedownloader.a, a.b, d.a {
    private final x a;
    private final x.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<a.InterfaceC0481a> f17080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f17081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f17082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f17083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FileDownloadHeader f17085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i f17086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Object f17087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17088l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17089m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17090n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f17091o = 100;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f17092p = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17093q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    volatile int f17094r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17095s = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f17097u = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Object f17096t = new Object();

    /* JADX INFO: compiled from: DownloadTask.java */
    private static final class b implements a.c {
        private final c a;

        @Override // com.liulishuo.filedownloader.a.c
        public int a() {
            int id = this.a.getId();
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.b().b(this.a);
            return id;
        }

        private b(c cVar) {
            this.a = cVar;
            this.a.f17095s = true;
        }
    }

    c(String str) {
        this.f17081e = str;
        d dVar = new d(this, this.f17096t);
        this.a = dVar;
        this.b = dVar;
    }

    private int z() {
        if (!y()) {
            if (!f()) {
                s();
            }
            this.a.e();
            return getId();
        }
        if (x()) {
            throw new IllegalStateException(com.liulishuo.filedownloader.h0.f.a("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        }
        throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.a.toString());
    }

    @Override // com.liulishuo.filedownloader.a
    public com.liulishuo.filedownloader.a b(String str) {
        a(str, false);
        return this;
    }

    @Override // com.liulishuo.filedownloader.a
    public byte c() {
        return this.a.c();
    }

    @Override // com.liulishuo.filedownloader.a.b
    public int d() {
        return this.f17094r;
    }

    @Override // com.liulishuo.filedownloader.a
    public a.c e() {
        return new b();
    }

    @Override // com.liulishuo.filedownloader.a
    public boolean f() {
        return this.f17094r != 0;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public void free() {
        this.a.free();
        if (h.b().c(this)) {
            this.f17097u = false;
        }
    }

    @Override // com.liulishuo.filedownloader.a
    public int g() {
        return this.f17092p;
    }

    @Override // com.liulishuo.filedownloader.a
    public String getFilename() {
        return this.f17083g;
    }

    @Override // com.liulishuo.filedownloader.d.a
    public FileDownloadHeader getHeader() {
        return this.f17085i;
    }

    @Override // com.liulishuo.filedownloader.a
    public int getId() {
        int i2 = this.f17079c;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(this.f17082f) || TextUtils.isEmpty(this.f17081e)) {
            return 0;
        }
        int iA = com.liulishuo.filedownloader.h0.f.a(this.f17081e, this.f17082f, this.f17084h);
        this.f17079c = iA;
        return iA;
    }

    @Override // com.liulishuo.filedownloader.a
    public i getListener() {
        return this.f17086j;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public x.a getMessageHandler() {
        return this.b;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public com.liulishuo.filedownloader.a getOrigin() {
        return this;
    }

    @Override // com.liulishuo.filedownloader.a
    public String getPath() {
        return this.f17082f;
    }

    @Override // com.liulishuo.filedownloader.a
    public int getSmallFileSoFarBytes() {
        if (this.a.d() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.d();
    }

    @Override // com.liulishuo.filedownloader.a
    public int getSmallFileTotalBytes() {
        if (this.a.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.a.getTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.a
    public Object getTag() {
        return this.f17087k;
    }

    @Override // com.liulishuo.filedownloader.a
    public String getTargetFilePath() {
        return com.liulishuo.filedownloader.h0.f.a(getPath(), m(), getFilename());
    }

    @Override // com.liulishuo.filedownloader.a
    public String getUrl() {
        return this.f17081e;
    }

    @Override // com.liulishuo.filedownloader.a
    public boolean h() {
        return this.f17090n;
    }

    @Override // com.liulishuo.filedownloader.d.a
    public a.b i() {
        return this;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public boolean isOver() {
        return com.liulishuo.filedownloader.model.b.b(c());
    }

    @Override // com.liulishuo.filedownloader.a
    public int j() {
        return this.f17088l;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public Object k() {
        return this.f17096t;
    }

    @Override // com.liulishuo.filedownloader.a
    public int l() {
        return this.f17091o;
    }

    @Override // com.liulishuo.filedownloader.a
    public boolean m() {
        return this.f17084h;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public void n() {
        this.f17097u = true;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public void o() {
        z();
    }

    @Override // com.liulishuo.filedownloader.a
    public long p() {
        return this.a.d();
    }

    @Override // com.liulishuo.filedownloader.d.a
    public ArrayList<a.InterfaceC0481a> q() {
        return this.f17080d;
    }

    @Override // com.liulishuo.filedownloader.a
    public long r() {
        return this.a.getTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.a.b
    public void s() {
        this.f17094r = getListener() != null ? getListener().hashCode() : hashCode();
    }

    @Override // com.liulishuo.filedownloader.a
    public int start() {
        if (this.f17095s) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return z();
    }

    @Override // com.liulishuo.filedownloader.a.b
    public boolean t() {
        return this.f17097u;
    }

    public String toString() {
        return com.liulishuo.filedownloader.h0.f.a("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    @Override // com.liulishuo.filedownloader.a
    public boolean u() {
        return this.f17093q;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public boolean v() {
        ArrayList<a.InterfaceC0481a> arrayList = this.f17080d;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.liulishuo.filedownloader.a
    public boolean w() {
        return this.f17089m;
    }

    public boolean x() {
        if (q.d().a().b(this)) {
            return true;
        }
        return com.liulishuo.filedownloader.model.b.a(c());
    }

    public boolean y() {
        return this.a.c() != 0;
    }

    public com.liulishuo.filedownloader.a a(String str, boolean z2) {
        this.f17082f = str;
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "setPath %s", str);
        }
        this.f17084h = z2;
        if (z2) {
            this.f17083g = null;
        } else {
            this.f17083g = new File(str).getName();
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.a
    public Throwable b() {
        return this.a.b();
    }

    @Override // com.liulishuo.filedownloader.a
    public com.liulishuo.filedownloader.a a(i iVar) {
        this.f17086j = iVar;
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.liulishuo.filedownloader.a
    public com.liulishuo.filedownloader.a a(boolean z2) {
        this.f17093q = z2;
        return this;
    }

    @Override // com.liulishuo.filedownloader.a
    public int a() {
        return this.a.a();
    }

    @Override // com.liulishuo.filedownloader.d.a
    public void a(String str) {
        this.f17083g = str;
    }

    @Override // com.liulishuo.filedownloader.a.b
    public boolean a(int i2) {
        return getId() == i2;
    }
}
