package com.kwai.filedownloader.services;

import android.text.TextUtils;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import com.kwai.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class g implements y {
    private final com.kwai.filedownloader.a.a aHH;
    private final h aHI;

    g() {
        com.kwai.filedownloader.download.b bVarHt = com.kwai.filedownloader.download.b.Ht();
        this.aHH = bVarHt.Hv();
        this.aHI = new h(bVarHt.Hw());
    }

    private boolean db(int i2) {
        return a(this.aHH.cD(i2));
    }

    public final void HZ() {
        this.aHH.clear();
    }

    public final void IH() {
        List<Integer> listIK = this.aHI.IK();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "pause all tasks %d", Integer.valueOf(listIK.size()));
        }
        Iterator<Integer> it = listIK.iterator();
        while (it.hasNext()) {
            cw(it.next().intValue());
        }
    }

    @Override // com.kwai.filedownloader.y
    public final boolean a(com.kwai.filedownloader.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean zDd = this.aHI.dd(cVar.getId());
        if (com.kwai.filedownloader.c.d.cY(cVar.Ge())) {
            if (!zDd) {
                return false;
            }
        } else if (!zDd) {
            com.kwai.filedownloader.e.d.e(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.Ge()));
            return false;
        }
        return true;
    }

    public final boolean ak(String str, String str2) {
        return db(com.kwai.filedownloader.e.f.am(str, str2));
    }

    public final synchronized void b(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) {
        com.kwai.filedownloader.c.c cVar;
        List<com.kwai.filedownloader.c.a> listCE;
        boolean z5 = true;
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z2));
        }
        int iK = com.kwai.filedownloader.e.f.k(str, str2, z2);
        com.kwai.filedownloader.c.c cVarCD = this.aHH.cD(iK);
        if (z2 || cVarCD != null) {
            cVar = cVarCD;
            listCE = null;
        } else {
            int iK2 = com.kwai.filedownloader.e.f.k(str, com.kwai.filedownloader.e.f.fm(str2), true);
            com.kwai.filedownloader.c.c cVarCD2 = this.aHH.cD(iK2);
            if (cVarCD2 == null || !str2.equals(cVarCD2.getTargetFilePath())) {
                listCE = null;
            } else {
                if (com.kwai.filedownloader.e.d.aHT) {
                    com.kwai.filedownloader.e.d.g(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(iK), Integer.valueOf(iK2));
                }
                listCE = this.aHH.cE(iK2);
            }
            cVar = cVarCD2;
        }
        if (com.kwai.filedownloader.e.c.a(iK, cVar, (y) this, true)) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "has already started download %d", Integer.valueOf(iK));
            }
            return;
        }
        String targetFilePath = cVar != null ? cVar.getTargetFilePath() : com.kwai.filedownloader.e.f.a(str2, z2, (String) null);
        if (com.kwai.filedownloader.e.c.a(iK, targetFilePath, z3, true)) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "has already completed downloading %d", Integer.valueOf(iK));
            }
            return;
        }
        if (com.kwai.filedownloader.e.c.a(iK, cVar != null ? cVar.Ip() : 0L, cVar != null ? cVar.HH() : com.kwai.filedownloader.e.f.fk(targetFilePath), targetFilePath, this)) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(iK), targetFilePath);
                if (cVar != null) {
                    this.aHH.cG(iK);
                    this.aHH.cF(iK);
                }
            }
            return;
        }
        if (cVar == null || !(cVar.Ge() == -2 || cVar.Ge() == -1 || cVar.Ge() == 1 || cVar.Ge() == 6 || cVar.Ge() == 2)) {
            if (cVar == null) {
                cVar = new com.kwai.filedownloader.c.c();
            }
            cVar.setUrl(str);
            cVar.g(str2, z2);
            cVar.setId(iK);
            cVar.ao(0L);
            cVar.aq(0L);
            cVar.e((byte) 1);
            cVar.cW(1);
        } else if (cVar.getId() != iK) {
            this.aHH.cG(cVar.getId());
            this.aHH.cF(cVar.getId());
            cVar.setId(iK);
            cVar.g(str2, z2);
            if (listCE != null) {
                for (com.kwai.filedownloader.c.a aVar : listCE) {
                    aVar.setId(iK);
                    this.aHH.a(aVar);
                }
            }
        } else if (TextUtils.equals(str, cVar.getUrl())) {
            z5 = false;
        } else {
            cVar.setUrl(str);
        }
        if (z5) {
            this.aHH.b(cVar);
        }
        this.aHI.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).a(Integer.valueOf(i3)).b(Integer.valueOf(i2)).b(Boolean.valueOf(z3)).c(Boolean.valueOf(z4)).c(Integer.valueOf(i4)).HI());
    }

    public final synchronized boolean cQ(int i2) {
        return this.aHI.cQ(i2);
    }

    public final long cS(int i2) {
        com.kwai.filedownloader.c.c cVarCD = this.aHH.cD(i2);
        if (cVarCD == null) {
            return 0L;
        }
        return cVarCD.getTotal();
    }

    public final boolean cw(int i2) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "request pause the task %d", Integer.valueOf(i2));
        }
        com.kwai.filedownloader.c.c cVarCD = this.aHH.cD(i2);
        if (cVarCD == null) {
            return false;
        }
        cVarCD.e((byte) -2);
        this.aHI.cancel(i2);
        return true;
    }

    public final byte cx(int i2) {
        com.kwai.filedownloader.c.c cVarCD = this.aHH.cD(i2);
        if (cVarCD == null) {
            return (byte) 0;
        }
        return cVarCD.Ge();
    }

    public final boolean cy(int i2) {
        if (i2 == 0) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        if (db(i2)) {
            com.kwai.filedownloader.e.d.h(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        this.aHH.cG(i2);
        this.aHH.cF(i2);
        return true;
    }

    public final long dc(int i2) {
        com.kwai.filedownloader.c.c cVarCD = this.aHH.cD(i2);
        if (cVarCD == null) {
            return 0L;
        }
        int iIr = cVarCD.Ir();
        if (iIr <= 1) {
            return cVarCD.Ip();
        }
        List<com.kwai.filedownloader.c.a> listCE = this.aHH.cE(i2);
        if (listCE == null || listCE.size() != iIr) {
            return 0L;
        }
        return com.kwai.filedownloader.c.a.J(listCE);
    }

    public final boolean isIdle() {
        return this.aHI.IJ() <= 0;
    }

    @Override // com.kwai.filedownloader.y
    public final int q(String str, int i2) {
        return this.aHI.q(str, i2);
    }
}
