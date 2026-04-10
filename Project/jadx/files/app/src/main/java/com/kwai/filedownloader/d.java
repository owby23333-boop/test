package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;
import com.kwai.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements a.c, x, x.a, x.b {
    private final Object aDP;
    private t aDT;
    private final a aDU;
    private volatile long aDW;
    private final s.b aDY;
    private final s.a aDZ;
    private long aEa;
    private long aEb;
    private int aEc;
    private boolean aEd;
    private boolean aEe;
    private String aEf;
    private volatile byte aDV = 0;
    private Throwable aDX = null;
    private boolean aEg = false;

    interface a {
        a.InterfaceC0461a GA();

        ArrayList<Object> GB();

        com.kwai.filedownloader.c.b Gz();

        void eU(String str);
    }

    d(a aVar, Object obj) {
        this.aDP = obj;
        this.aDU = aVar;
        b bVar = new b();
        this.aDY = bVar;
        this.aDZ = bVar;
        this.aDT = new k(aVar.GA(), this);
    }

    private void c(byte b) {
        this.aDV = b;
        this.aDW = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwai.filedownloader.a aVarGm = this.aDU.GA().Gm();
        byte bGe = messageSnapshot.Ge();
        c(bGe);
        this.aEd = messageSnapshot.Gk();
        if (bGe == -4) {
            this.aDY.reset();
            int iCs = h.GK().cs(aVarGm.getId());
            if (iCs + ((iCs > 1 || !aVarGm.Ga()) ? 0 : h.GK().cs(com.kwai.filedownloader.e.f.am(aVarGm.getUrl(), aVarGm.getTargetFilePath()))) <= 1) {
                byte bCx = n.GV().cx(aVarGm.getId());
                com.kwai.filedownloader.e.d.h(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(aVarGm.getId()), Integer.valueOf(bCx));
                if (com.kwai.filedownloader.c.d.cZ(bCx)) {
                    c((byte) 1);
                    this.aEb = messageSnapshot.Ie();
                    this.aEa = messageSnapshot.Ig();
                    this.aDY.start(this.aEa);
                    this.aDT.f(((MessageSnapshot.a) messageSnapshot).Ii());
                    return;
                }
            }
            h.GK().a(this.aDU.GA(), messageSnapshot);
            return;
        }
        if (bGe == -3) {
            this.aEg = messageSnapshot.If();
            this.aEa = messageSnapshot.Ie();
            this.aEb = messageSnapshot.Ie();
            h.GK().a(this.aDU.GA(), messageSnapshot);
            return;
        }
        if (bGe != -2) {
            if (bGe == -1) {
                this.aDX = messageSnapshot.Ih();
                this.aEa = messageSnapshot.Ig();
                h.GK().a(this.aDU.GA(), messageSnapshot);
                return;
            }
            if (bGe == 1) {
                this.aEa = messageSnapshot.Ig();
                this.aEb = messageSnapshot.Ie();
                this.aDT.f(messageSnapshot);
                return;
            }
            if (bGe == 2) {
                this.aEb = messageSnapshot.Ie();
                this.aEe = messageSnapshot.HU();
                this.aEf = messageSnapshot.getEtag();
                String fileName = messageSnapshot.getFileName();
                if (fileName != null) {
                    if (aVarGm.getFilename() != null) {
                        com.kwai.filedownloader.e.d.h(this, "already has mFilename[%s], but assign mFilename[%s] again", aVarGm.getFilename(), fileName);
                    }
                    this.aDU.eU(fileName);
                }
                this.aDY.start(this.aEa);
                this.aDT.h(messageSnapshot);
                return;
            }
            if (bGe == 3) {
                this.aEa = messageSnapshot.Ig();
                this.aDY.aj(messageSnapshot.Ig());
                this.aDT.i(messageSnapshot);
            } else if (bGe != 5) {
                if (bGe != 6) {
                    return;
                }
                this.aDT.g(messageSnapshot);
            } else {
                this.aEa = messageSnapshot.Ig();
                this.aDX = messageSnapshot.Ih();
                this.aEc = messageSnapshot.Gi();
                this.aDY.reset();
                this.aDT.k(messageSnapshot);
            }
        }
    }

    private int getId() {
        return this.aDU.GA().Gm().getId();
    }

    private void prepare() throws IOException {
        File file;
        com.kwai.filedownloader.a aVarGm = this.aDU.GA().Gm();
        if (aVarGm.getPath() == null) {
            aVarGm.eS(com.kwai.filedownloader.e.f.fi(aVarGm.getUrl()));
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "save Path is null to %s", aVarGm.getPath());
            }
        }
        if (aVarGm.Ga()) {
            file = new File(aVarGm.getPath());
        } else {
            String strFm = com.kwai.filedownloader.e.f.fm(aVarGm.getPath());
            if (strFm == null) {
                throw new InvalidParameterException(com.kwai.filedownloader.e.f.j("the provided mPath[%s] is invalid, can't find its directory", aVarGm.getPath()));
            }
            file = new File(strFm);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwai.filedownloader.e.f.j("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    @Override // com.kwai.filedownloader.x.a
    public final t GC() {
        return this.aDT;
    }

    @Override // com.kwai.filedownloader.x
    public final void GD() {
        boolean z2;
        synchronized (this.aDP) {
            if (this.aDV != 0) {
                com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.aDV));
                return;
            }
            c((byte) 10);
            a.InterfaceC0461a interfaceC0461aGA = this.aDU.GA();
            com.kwai.filedownloader.a aVarGm = interfaceC0461aGA.Gm();
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.i(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", aVarGm.getUrl(), aVarGm.getPath(), aVarGm.Gb(), aVarGm.getTag());
            }
            try {
                prepare();
                z2 = true;
            } catch (Throwable th) {
                h.GK().b(interfaceC0461aGA);
                h.GK().a(interfaceC0461aGA, l(th));
                z2 = false;
            }
            if (z2) {
                q.Hb().a(this);
            }
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.i(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwai.filedownloader.x
    public final long GE() {
        return this.aEa;
    }

    @Override // com.kwai.filedownloader.x
    public final byte Ge() {
        return this.aDV;
    }

    @Override // com.kwai.filedownloader.x
    public final Throwable Gg() {
        return this.aDX;
    }

    @Override // com.kwai.filedownloader.x
    public final int Gi() {
        return this.aEc;
    }

    @Override // com.kwai.filedownloader.x
    public final boolean Gk() {
        return this.aEd;
    }

    @Override // com.kwai.filedownloader.a.c
    public final void Gv() {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.i(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(Ge()));
        }
        this.aDY.end(this.aEa);
        if (this.aDU.GB() != null) {
            ArrayList arrayList = (ArrayList) this.aDU.GB().clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2);
            }
        }
        r.Hd().Hh().e(this.aDU.GA());
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.c.d.A(Ge(), messageSnapshot.Ge())) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aDV), Byte.valueOf(Ge()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte bGe = Ge();
        byte bGe2 = messageSnapshot.Ge();
        if (-2 == bGe && com.kwai.filedownloader.c.d.cZ(bGe2)) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (com.kwai.filedownloader.c.d.B(bGe, bGe2)) {
            e(messageSnapshot);
            return true;
        }
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.aDV), Byte.valueOf(Ge()), Integer.valueOf(getId()));
        }
        return false;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwai.filedownloader.c.d.f(this.aDU.GA().Gm())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwai.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.aDU.GA().Gm().Ga() || messageSnapshot.Ge() != -4 || Ge() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwai.filedownloader.x
    public final void free() {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.aDV));
        }
        c((byte) 0);
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        return this.aDZ.getSpeed();
    }

    @Override // com.kwai.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.aDW;
    }

    @Override // com.kwai.filedownloader.x
    public final long getTotalBytes() {
        return this.aEb;
    }

    @Override // com.kwai.filedownloader.x.a
    public final MessageSnapshot l(Throwable th) {
        c((byte) -1);
        this.aDX = th;
        return com.kwai.filedownloader.message.f.a(getId(), GE(), th);
    }

    @Override // com.kwai.filedownloader.a.c
    public final void onBegin() {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.i(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(Ge()));
        }
    }

    @Override // com.kwai.filedownloader.x
    public final boolean pause() {
        if (com.kwai.filedownloader.c.d.cY(Ge())) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(Ge()), Integer.valueOf(this.aDU.GA().Gm().getId()));
            }
            return false;
        }
        c((byte) -2);
        a.InterfaceC0461a interfaceC0461aGA = this.aDU.GA();
        com.kwai.filedownloader.a aVarGm = interfaceC0461aGA.Gm();
        q.Hb().b(this);
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.i(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.Hd();
        if (r.Hf()) {
            n.GV().cw(aVarGm.getId());
        } else if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(aVarGm.getId()));
        }
        h.GK().b(interfaceC0461aGA);
        h.GK().a(interfaceC0461aGA, com.kwai.filedownloader.message.f.e(aVarGm));
        r.Hd().Hh().e(interfaceC0461aGA);
        return true;
    }

    @Override // com.kwai.filedownloader.x
    public final void reset() {
        this.aDX = null;
        this.aEf = null;
        this.aEe = false;
        this.aEc = 0;
        this.aEg = false;
        this.aEd = false;
        this.aEa = 0L;
        this.aEb = 0L;
        this.aDY.reset();
        if (com.kwai.filedownloader.c.d.cY(this.aDV)) {
            this.aDT.GT();
            this.aDT = new k(this.aDU.GA(), this);
        } else {
            this.aDT.b(this.aDU.GA(), this);
        }
        c((byte) 0);
    }

    @Override // com.kwai.filedownloader.x.b
    public final void start() {
        if (this.aDV != 10) {
            com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aDV));
            return;
        }
        a.InterfaceC0461a interfaceC0461aGA = this.aDU.GA();
        com.kwai.filedownloader.a aVarGm = interfaceC0461aGA.Gm();
        v vVarHh = r.Hd().Hh();
        try {
            if (vVarHh.f(interfaceC0461aGA)) {
                return;
            }
            synchronized (this.aDP) {
                if (this.aDV != 10) {
                    com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.aDV));
                    return;
                }
                c((byte) 11);
                h.GK().b(interfaceC0461aGA);
                if (com.kwai.filedownloader.e.c.a(aVarGm.getId(), aVarGm.getTargetFilePath(), aVarGm.Gf(), true)) {
                    return;
                }
                boolean zA = n.GV().a(aVarGm.getUrl(), aVarGm.getPath(), aVarGm.Ga(), aVarGm.FY(), aVarGm.FZ(), aVarGm.Gh(), aVarGm.Gf(), this.aDU.Gz(), aVarGm.Gl());
                if (this.aDV == -2) {
                    com.kwai.filedownloader.e.d.h(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (zA) {
                        n.GV().cw(getId());
                        return;
                    }
                    return;
                }
                if (zA) {
                    vVarHh.e(interfaceC0461aGA);
                    return;
                }
                if (vVarHh.f(interfaceC0461aGA)) {
                    return;
                }
                MessageSnapshot messageSnapshotL = l(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                if (h.GK().a(interfaceC0461aGA)) {
                    vVarHh.e(interfaceC0461aGA);
                    h.GK().b(interfaceC0461aGA);
                }
                h.GK().a(interfaceC0461aGA, messageSnapshotL);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.GK().a(interfaceC0461aGA, l(th));
        }
    }
}
