package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements a.c, x, x.a, x.b {
    private t alD;
    private final a alE;
    private volatile long alG;
    private final s.b alI;
    private final s.a alJ;
    private long alK;
    private long alL;
    private int alM;
    private boolean alN;
    private boolean alO;
    private String alP;
    private final Object alz;
    private volatile byte alF = 0;
    private Throwable alH = null;
    private boolean alQ = false;

    interface a {
        void setFileName(String str);

        com.kwad.framework.filedownloader.d.b xe();

        a.InterfaceC0370a xf();

        ArrayList<Object> xg();
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.u(wJ(), messageSnapshot.wJ())) {
            if (!com.kwad.framework.filedownloader.f.d.apD) {
                return false;
            }
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.alF), Byte.valueOf(wJ()), Integer.valueOf(getId()));
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte bWJ = wJ();
        byte bWJ2 = messageSnapshot.wJ();
        if (-2 == bWJ && com.kwad.framework.filedownloader.d.d.bZ(bWJ2)) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (!com.kwad.framework.filedownloader.d.d.v(bWJ, bWJ2)) {
            if (!com.kwad.framework.filedownloader.f.d.apD) {
                return false;
            }
            com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.alF), Byte.valueOf(wJ()), Integer.valueOf(getId()));
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.alE.xf().wR())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.alE.xf().wR().wF() || messageSnapshot.wJ() != -4 || wJ() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    private void b(byte b) {
        this.alF = b;
        this.alG = System.currentTimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t xh() {
        return this.alD;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot g(Throwable th) {
        b((byte) -1);
        this.alH = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), xj(), th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a aVarWR = this.alE.xf().wR();
        byte bWJ = messageSnapshot.wJ();
        b(bWJ);
        this.alN = messageSnapshot.wP();
        if (bWJ == -4) {
            this.alI.reset();
            int iBs = h.xp().bs(aVarWR.getId());
            if (iBs + ((iBs > 1 || !aVarWR.wF()) ? 0 : h.xp().bs(com.kwad.framework.filedownloader.f.f.B(aVarWR.getUrl(), aVarWR.getTargetFilePath()))) <= 1) {
                byte bBx = n.xA().bx(aVarWR.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(aVarWR.getId()), Integer.valueOf(bBx));
                if (com.kwad.framework.filedownloader.d.d.bZ(bBx)) {
                    b((byte) 1);
                    this.alL = messageSnapshot.yO();
                    long jYQ = messageSnapshot.yQ();
                    this.alK = jYQ;
                    this.alI.start(jYQ);
                    this.alD.f(((MessageSnapshot.a) messageSnapshot).yS());
                    return;
                }
            }
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (bWJ == -3) {
            this.alQ = messageSnapshot.yP();
            this.alK = messageSnapshot.yO();
            this.alL = messageSnapshot.yO();
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (bWJ == -1) {
            this.alH = messageSnapshot.yR();
            this.alK = messageSnapshot.yQ();
            h.xp().a(this.alE.xf(), messageSnapshot);
            return;
        }
        if (bWJ == 1) {
            this.alK = messageSnapshot.yQ();
            this.alL = messageSnapshot.yO();
            this.alD.f(messageSnapshot);
            return;
        }
        if (bWJ == 2) {
            this.alL = messageSnapshot.yO();
            this.alO = messageSnapshot.yE();
            this.alP = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (aVarWR.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", aVarWR.getFilename(), fileName);
                }
                this.alE.setFileName(fileName);
            }
            this.alI.start(this.alK);
            this.alD.h(messageSnapshot);
            return;
        }
        if (bWJ == 3) {
            this.alK = messageSnapshot.yQ();
            this.alI.U(messageSnapshot.yQ());
            this.alD.i(messageSnapshot);
        } else if (bWJ != 5) {
            if (bWJ != 6) {
                return;
            }
            this.alD.g(messageSnapshot);
        } else {
            this.alK = messageSnapshot.yQ();
            this.alH = messageSnapshot.yR();
            this.alM = messageSnapshot.wN();
            this.alI.reset();
            this.alD.k(messageSnapshot);
        }
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(wJ()));
        }
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void xa() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(wJ()));
        }
        this.alI.end(this.alK);
        if (this.alE.xg() != null) {
            ArrayList arrayList = (ArrayList) this.alE.xg().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.xI().xM().e(this.alE.xf());
    }

    d(a aVar, Object obj) {
        this.alz = obj;
        this.alE = aVar;
        b bVar = new b();
        this.alI = bVar;
        this.alJ = bVar;
        this.alD = new k(aVar.xf(), this);
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void xi() {
        synchronized (this.alz) {
            boolean z = true;
            if (this.alF != 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
                return;
            }
            b((byte) 10);
            a.InterfaceC0370a interfaceC0370aXf = this.alE.xf();
            com.kwad.framework.filedownloader.a aVarWR = interfaceC0370aXf.wR();
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", aVarWR.getUrl(), aVarWR.getPath(), aVarWR.wG(), aVarWR.getTag());
            }
            try {
                prepare();
            } catch (Throwable th) {
                h.xp().b(interfaceC0370aXf);
                h.xp().a(interfaceC0370aXf, g(th));
                z = false;
            }
            if (z) {
                q.xG().a(this);
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.bY(wJ())) {
            if (!com.kwad.framework.filedownloader.f.d.apD) {
                return false;
            }
            com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(wJ()), Integer.valueOf(this.alE.xf().wR().getId()));
            return false;
        }
        b((byte) -2);
        a.InterfaceC0370a interfaceC0370aXf = this.alE.xf();
        com.kwad.framework.filedownloader.a aVarWR = interfaceC0370aXf.wR();
        q.xG().b(this);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.xI();
        if (!r.xK()) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(aVarWR.getId()));
            }
        } else {
            n.xA().bw(aVarWR.getId());
        }
        h.xp().b(interfaceC0370aXf);
        h.xp().a(interfaceC0370aXf, com.kwad.framework.filedownloader.message.f.e(aVarWR));
        r.xI().xM().e(interfaceC0370aXf);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte wJ() {
        return this.alF;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.alG;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.alH = null;
        this.alP = null;
        this.alO = false;
        this.alM = 0;
        this.alQ = false;
        this.alN = false;
        this.alK = 0L;
        this.alL = 0L;
        this.alI.reset();
        if (com.kwad.framework.filedownloader.d.d.bY(this.alF)) {
            this.alD.xy();
            this.alD = new k(this.alE.xf(), this);
        } else {
            this.alD.b(this.alE.xf(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.alJ.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long xj() {
        return this.alK;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.alL;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable wL() {
        return this.alH;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int wN() {
        return this.alM;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean wP() {
        return this.alN;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
        }
        b((byte) 0);
    }

    private void prepare() throws IOException {
        File file;
        com.kwad.framework.filedownloader.a aVarWR = this.alE.xf().wR();
        if (aVarWR.getPath() == null) {
            aVarWR.bk(com.kwad.framework.filedownloader.f.f.bB(aVarWR.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", aVarWR.getPath());
            }
        }
        if (aVarWR.wF()) {
            file = new File(aVarWR.getPath());
        } else {
            String strBF = com.kwad.framework.filedownloader.f.f.bF(aVarWR.getPath());
            if (strBF == null) {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.c("the provided mPath[%s] is invalid, can't find its directory", aVarWR.getPath()));
            }
            file = new File(strBF);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.c("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    private int getId() {
        return this.alE.xf().wR().getId();
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.alF != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
            return;
        }
        a.InterfaceC0370a interfaceC0370aXf = this.alE.xf();
        com.kwad.framework.filedownloader.a aVarWR = interfaceC0370aXf.wR();
        v vVarXM = r.xI().xM();
        try {
            if (vVarXM.f(interfaceC0370aXf)) {
                return;
            }
            synchronized (this.alz) {
                if (this.alF != 10) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.alF));
                    return;
                }
                b((byte) 11);
                h.xp().b(interfaceC0370aXf);
                if (com.kwad.framework.filedownloader.f.c.a(aVarWR.getId(), aVarWR.getTargetFilePath(), aVarWR.wK(), true)) {
                    return;
                }
                boolean zA = n.xA().a(aVarWR.getUrl(), aVarWR.getPath(), aVarWR.wF(), aVarWR.wD(), aVarWR.wE(), aVarWR.wM(), aVarWR.wK(), this.alE.xe(), aVarWR.wQ());
                if (this.alF == -2) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (zA) {
                        n.xA().bw(getId());
                        return;
                    }
                    return;
                }
                if (!zA) {
                    if (vVarXM.f(interfaceC0370aXf)) {
                        return;
                    }
                    MessageSnapshot messageSnapshotG = g(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.xp().a(interfaceC0370aXf)) {
                        vVarXM.e(interfaceC0370aXf);
                        h.xp().b(interfaceC0370aXf);
                    }
                    h.xp().a(interfaceC0370aXf, messageSnapshotG);
                    return;
                }
                vVarXM.e(interfaceC0370aXf);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.xp().a(interfaceC0370aXf, g(th));
        }
    }
}
