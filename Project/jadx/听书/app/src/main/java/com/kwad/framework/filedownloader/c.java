package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0370a, d.a {
    private final x alh;
    private final x.a ali;
    private int alj;
    private ArrayList<Object> alk;
    private String all;
    private String alm;
    private boolean aln;
    private com.kwad.framework.filedownloader.d.b alo;
    private i alp;
    private Object alq;
    private final Object alz;
    private final String mUrl;
    private int alr = 0;
    private boolean als = false;
    private boolean alt = false;
    private int alu = 100;
    private int alv = 10;
    private boolean alw = false;
    volatile int alx = 0;
    private boolean aly = false;
    private final Object alA = new Object();
    private volatile boolean alB = false;

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final com.kwad.framework.filedownloader.a wR() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0370a xf() {
        return this;
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.aly = true;
        return true;
    }

    c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.alz = obj;
        d dVar = new d(this, obj);
        this.alh = dVar;
        this.ali = dVar;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bk(String str) {
        return c(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a c(String str, boolean z) {
        this.all = str;
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.aln = z;
        if (z) {
            this.alm = null;
        } else {
            this.alm = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.alp = iVar;
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a f(Object obj) {
        this.alq = obj;
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bd(boolean z) {
        this.alw = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bq(int i) {
        this.alr = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a u(String str, String str2) {
        xd();
        this.alo.y(str, str2);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bl(String str) {
        if (this.alo == null) {
            synchronized (this.alA) {
                if (this.alo == null) {
                    return this;
                }
            }
        }
        this.alo.bw(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a be(boolean z) {
        this.als = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a bf(boolean z) {
        this.alt = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b wA() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wB() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.alx = 0;
        this.aly = false;
        this.alB = false;
        this.alh.reset();
        return true;
    }

    private boolean xb() {
        return this.alh.wJ() != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.xI().xM().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.bZ(wJ());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wC() {
        return this.alx != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (this.aly) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return xc();
    }

    private int xc() {
        if (xb()) {
            if (isRunning()) {
                throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.alh.toString());
        }
        if (!wC()) {
            wU();
        }
        this.alh.xi();
        return getId();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean zPause;
        synchronized (this.alz) {
            zPause = this.alh.pause();
        }
        return zPause;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i = this.alj;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.all) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int iG = com.kwad.framework.filedownloader.f.f.g(this.mUrl, this.all, this.aln);
        this.alj = iG;
        return iG;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int wD() {
        return this.alu;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int wE() {
        return this.alv;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.all;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wF() {
        return this.aln;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.alm;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), wF(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i wG() {
        return this.alp;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.alh.xj() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.alh.xj();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long wH() {
        return this.alh.xj();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.alh.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.alh.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long wI() {
        return this.alh.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.alh.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte wJ() {
        return this.alh.wJ();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.alh.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wK() {
        return this.alw;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable wL() {
        return this.alh.wL();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.alq;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int wM() {
        return this.alr;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int wN() {
        return this.alh.wN();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wO() {
        return this.als;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wP() {
        return this.alh.wP();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean wQ() {
        return this.alt;
    }

    private void xd() {
        if (this.alo == null) {
            synchronized (this.alA) {
                if (this.alo == null) {
                    this.alo = new com.kwad.framework.filedownloader.d.b();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b xe() {
        return this.alo;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final void wW() {
        this.alB = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final void free() {
        this.alh.free();
        if (h.xp().a(this)) {
            this.alB = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final void wX() {
        xc();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final boolean wY() {
        ArrayList<Object> arrayList = this.alk;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final boolean wV() {
        return this.alB;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void setFileName(String str) {
        this.alm = str;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> xg() {
        return this.alk;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final x.a wS() {
        return this.ali;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final boolean br(int i) {
        return getId() == i;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.bY(wJ());
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final int wT() {
        return this.alx;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0370a
    public final void wU() {
        int iHashCode;
        if (wG() != null) {
            iHashCode = wG().hashCode();
        } else {
            iHashCode = hashCode();
        }
        this.alx = iHashCode;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    static final class a implements a.b {
        private final c alC;

        /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        private a(c cVar) {
            this.alC = cVar;
            c.a(cVar, true);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int wZ() {
            int id = this.alC.getId();
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.xp().c(this.alC);
            return id;
        }
    }
}
