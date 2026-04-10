package com.kwai.filedownloader;

import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.d;
import com.kwai.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwai.filedownloader.a, a.InterfaceC0461a, d.a {
    private ArrayList<Object> aDA;
    private String aDB;
    private String aDC;
    private boolean aDD;
    private com.kwai.filedownloader.c.b aDE;
    private i aDF;
    private Object aDG;
    private final x aDx;
    private final x.a aDy;
    private int aDz;
    private final String mUrl;
    private int aDH = 0;
    private boolean aDI = false;
    private boolean aDJ = false;
    private int aDK = 100;
    private int aDL = 10;
    private boolean aDM = false;
    volatile int aDN = 0;
    private boolean aDO = false;
    private final Object aDQ = new Object();
    private volatile boolean aDR = false;
    private final Object aDP = new Object();

    static final class a implements a.b {
        private final c aDS;

        private a(c cVar) {
            this.aDS = cVar;
            c.a(this.aDS, true);
        }

        /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        @Override // com.kwai.filedownloader.a.b
        public final int Gu() {
            int id = this.aDS.getId();
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.GK().c(this.aDS);
            return id;
        }
    }

    c(String str) {
        this.mUrl = str;
        d dVar = new d(this, this.aDP);
        this.aDx = dVar;
        this.aDy = dVar;
    }

    private boolean Gw() {
        return this.aDx.Ge() != 0;
    }

    private int Gx() {
        if (!Gw()) {
            if (!FX()) {
                Gp();
            }
            this.aDx.GD();
            return getId();
        }
        if (isRunning()) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
        }
        throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.aDx.toString());
    }

    private void Gy() {
        if (this.aDE == null) {
            synchronized (this.aDQ) {
                if (this.aDE == null) {
                    this.aDE = new com.kwai.filedownloader.c.b();
                }
            }
        }
    }

    static /* synthetic */ boolean a(c cVar, boolean z2) {
        cVar.aDO = true;
        return true;
    }

    @Override // com.kwai.filedownloader.a
    public final a.b FV() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwai.filedownloader.a
    public final boolean FW() {
        if (isRunning()) {
            com.kwai.filedownloader.e.d.h(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.aDN = 0;
        this.aDO = false;
        this.aDR = false;
        this.aDx.reset();
        return true;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean FX() {
        return this.aDN != 0;
    }

    @Override // com.kwai.filedownloader.a
    public final int FY() {
        return this.aDK;
    }

    @Override // com.kwai.filedownloader.a
    public final int FZ() {
        return this.aDL;
    }

    @Override // com.kwai.filedownloader.d.a
    public final a.InterfaceC0461a GA() {
        return this;
    }

    @Override // com.kwai.filedownloader.d.a
    public final ArrayList<Object> GB() {
        return this.aDA;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Ga() {
        return this.aDD;
    }

    @Override // com.kwai.filedownloader.a
    public final i Gb() {
        return this.aDF;
    }

    @Override // com.kwai.filedownloader.a
    public final long Gc() {
        return this.aDx.GE();
    }

    @Override // com.kwai.filedownloader.a
    public final long Gd() {
        return this.aDx.getTotalBytes();
    }

    @Override // com.kwai.filedownloader.a
    public final byte Ge() {
        return this.aDx.Ge();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gf() {
        return this.aDM;
    }

    @Override // com.kwai.filedownloader.a
    public final Throwable Gg() {
        return this.aDx.Gg();
    }

    @Override // com.kwai.filedownloader.a
    public final int Gh() {
        return this.aDH;
    }

    @Override // com.kwai.filedownloader.a
    public final int Gi() {
        return this.aDx.Gi();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gj() {
        return this.aDI;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gk() {
        return this.aDx.Gk();
    }

    @Override // com.kwai.filedownloader.a
    public final boolean Gl() {
        return this.aDJ;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final com.kwai.filedownloader.a Gm() {
        return this;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final x.a Gn() {
        return this.aDy;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final int Go() {
        return this.aDN;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final void Gp() {
        this.aDN = Gb() != null ? Gb().hashCode() : hashCode();
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final boolean Gq() {
        return this.aDR;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final void Gr() {
        this.aDR = true;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final void Gs() {
        Gx();
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final boolean Gt() {
        ArrayList<Object> arrayList = this.aDA;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwai.filedownloader.d.a
    public final com.kwai.filedownloader.c.b Gz() {
        return this.aDE;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a a(i iVar) {
        this.aDF = iVar;
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a ah(String str, String str2) {
        Gy();
        this.aDE.aj(str, str2);
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bJ(boolean z2) {
        this.aDM = true;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bK(boolean z2) {
        this.aDI = true;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a bL(boolean z2) {
        this.aDJ = z2;
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a cq(int i2) {
        this.aDH = 3;
        return this;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final boolean cr(int i2) {
        return getId() == i2;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a eS(String str) {
        return f(str, false);
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a eT(String str) {
        if (this.aDE == null) {
            synchronized (this.aDQ) {
                if (this.aDE == null) {
                    return this;
                }
            }
        }
        this.aDE.fd(str);
        return this;
    }

    @Override // com.kwai.filedownloader.d.a
    public final void eU(String str) {
        this.aDC = str;
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a f(String str, boolean z2) {
        this.aDB = str;
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "setPath %s", str);
        }
        this.aDD = z2;
        this.aDC = z2 ? null : new File(str).getName();
        return this;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final void free() {
        this.aDx.free();
        if (h.GK().a(this)) {
            this.aDR = false;
        }
    }

    @Override // com.kwai.filedownloader.a
    public final String getFilename() {
        return this.aDC;
    }

    @Override // com.kwai.filedownloader.a
    public final int getId() {
        int i2 = this.aDz;
        if (i2 != 0) {
            return i2;
        }
        if (TextUtils.isEmpty(this.aDB) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int iK = com.kwai.filedownloader.e.f.k(this.mUrl, this.aDB, this.aDD);
        this.aDz = iK;
        return iK;
    }

    @Override // com.kwai.filedownloader.a
    public final String getPath() {
        return this.aDB;
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.aDx.GE() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aDx.GE();
    }

    @Override // com.kwai.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.aDx.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.aDx.getTotalBytes();
    }

    @Override // com.kwai.filedownloader.a
    public final int getSpeed() {
        return this.aDx.getSpeed();
    }

    @Override // com.kwai.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.aDx.getStatusUpdateTime();
    }

    @Override // com.kwai.filedownloader.a
    public final Object getTag() {
        return this.aDG;
    }

    @Override // com.kwai.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwai.filedownloader.e.f.a(getPath(), Ga(), getFilename());
    }

    @Override // com.kwai.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwai.filedownloader.a.InterfaceC0461a
    public final boolean isOver() {
        return com.kwai.filedownloader.c.d.cY(Ge());
    }

    @Override // com.kwai.filedownloader.a
    public final boolean isRunning() {
        if (r.Hd().Hh().d(this)) {
            return true;
        }
        return com.kwai.filedownloader.c.d.cZ(Ge());
    }

    @Override // com.kwai.filedownloader.a
    public final com.kwai.filedownloader.a j(Object obj) {
        this.aDG = obj;
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwai.filedownloader.a
    public final boolean pause() {
        boolean zPause;
        synchronized (this.aDP) {
            zPause = this.aDx.pause();
        }
        return zPause;
    }

    @Override // com.kwai.filedownloader.a
    public final int start() {
        if (this.aDO) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return Gx();
    }

    public final String toString() {
        return com.kwai.filedownloader.e.f.j("%d@%s", Integer.valueOf(getId()), super.toString());
    }
}
