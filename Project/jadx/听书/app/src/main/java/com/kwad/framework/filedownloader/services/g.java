package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class g implements y {
    private final h aps = new h(com.kwad.framework.filedownloader.download.b.yc().yf());

    g() {
    }

    private static com.kwad.framework.filedownloader.b.a zr() {
        return com.kwad.framework.filedownloader.download.b.yc().ye();
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0179 A[Catch: all -> 0x01c2, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0033, B:12:0x0041, B:14:0x004b, B:16:0x004f, B:17:0x0063, B:21:0x0071, B:23:0x0077, B:25:0x007b, B:29:0x008c, B:31:0x0095, B:33:0x009e, B:35:0x00a2, B:40:0x00b5, B:43:0x00be, B:45:0x00c7, B:47:0x00d6, B:49:0x00da, B:51:0x00ec, B:55:0x00f6, B:57:0x00fd, B:59:0x0104, B:61:0x010a, B:63:0x0111, B:65:0x0117, B:67:0x011d, B:69:0x0133, B:70:0x0137, B:72:0x013d, B:81:0x0179, B:82:0x017c, B:73:0x014a, B:75:0x0154, B:77:0x015a, B:78:0x015f, B:44:0x00c3, B:30:0x0091), top: B:88:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void b(java.lang.String r20, java.lang.String r21, boolean r22, int r23, int r24, int r25, boolean r26, com.kwad.framework.filedownloader.d.b r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.services.g.b(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.kwad.framework.filedownloader.d.b, boolean):void");
    }

    public final boolean z(String str, String str2) {
        return cb(com.kwad.framework.filedownloader.f.f.B(str, str2));
    }

    private boolean cb(int i) {
        return a(zr().bD(i));
    }

    public final boolean bw(int i) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c cVarBD = zr().bD(i);
        if (cVarBD == null) {
            return false;
        }
        cVarBD.d((byte) -2);
        this.aps.cancel(i);
        return true;
    }

    public final void zs() {
        List<Integer> listZv = this.aps.zv();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(listZv.size()));
        }
        Iterator<Integer> it = listZv.iterator();
        while (it.hasNext()) {
            bw(it.next().intValue());
        }
    }

    public final long cc(int i) {
        com.kwad.framework.filedownloader.b.a aVarZr = zr();
        com.kwad.framework.filedownloader.d.c cVarBD = aVarZr.bD(i);
        if (cVarBD == null) {
            return 0L;
        }
        int iZc = cVarBD.zc();
        if (iZc <= 1) {
            return cVarBD.yZ();
        }
        List<com.kwad.framework.filedownloader.d.a> listBE = aVarZr.bE(i);
        if (listBE == null || listBE.size() != iZc) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.s(listBE);
    }

    public final long bS(int i) {
        com.kwad.framework.filedownloader.d.c cVarBD = zr().bD(i);
        if (cVarBD == null) {
            return 0L;
        }
        return cVarBD.getTotal();
    }

    public final byte bx(int i) {
        com.kwad.framework.filedownloader.d.c cVarBD = zr().bD(i);
        if (cVarBD == null) {
            return (byte) 0;
        }
        return cVarBD.wJ();
    }

    public final boolean isIdle() {
        return this.aps.zu() <= 0;
    }

    public final synchronized boolean bQ(int i) {
        return this.aps.bQ(i);
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean zCd = this.aps.cd(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.bY(cVar.wJ())) {
            if (!zCd) {
                return false;
            }
        } else if (!zCd) {
            com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.wJ()));
            return false;
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int o(String str, int i) {
        return this.aps.o(str, i);
    }

    public final boolean by(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (cb(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        com.kwad.framework.filedownloader.b.a aVarZr = zr();
        aVarZr.bG(i);
        aVarZr.bF(i);
        return true;
    }

    public final void yJ() {
        zr().clear();
    }
}
