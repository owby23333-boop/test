package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor anE = com.kwad.framework.filedownloader.f.b.bA("ConnectionBlock");
    private final boolean anA;
    private final ArrayList<c> anB;
    private e anC;
    private boolean anD;
    private boolean anF;
    private boolean anG;
    private boolean anH;
    private final AtomicBoolean anI;
    private volatile boolean anJ;
    private volatile Exception anK;
    private String anL;
    private long anM;
    private long anN;
    private long anO;
    private long anP;
    private final com.kwad.framework.filedownloader.b.a ano;
    private final d anr;
    private final int ans;
    private final com.kwad.framework.filedownloader.d.c ant;
    private final com.kwad.framework.filedownloader.d.b anu;
    private final boolean anv;
    private final boolean anw;
    private final y anx;
    private boolean any;
    int anz;
    private volatile boolean nf;

    /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.ans = 5;
        this.anB = new ArrayList<>(5);
        this.anM = 0L;
        this.anN = 0L;
        this.anO = 0L;
        this.anP = 0L;
        this.anI = new AtomicBoolean(true);
        this.nf = false;
        this.any = false;
        this.ant = cVar;
        this.anu = bVar;
        this.anv = z;
        this.anw = z2;
        this.ano = b.yc().ye();
        this.anA = b.yc().yg();
        this.anx = yVar;
        this.anz = i3;
        this.anr = new d(cVar, i3, i, i2);
    }

    public final void pause() {
        this.nf = true;
        e eVar = this.anC;
        if (eVar != null) {
            eVar.pause();
        }
        for (c cVar : (ArrayList) this.anB.clone()) {
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    public final void ym() {
        if (this.ant.zc() > 1) {
            List<com.kwad.framework.filedownloader.d.a> listBE = this.ano.bE(this.ant.getId());
            if (this.ant.zc() == listBE.size()) {
                this.ant.Z(com.kwad.framework.filedownloader.d.a.s(listBE));
            } else {
                this.ant.Z(0L);
                this.ano.bF(this.ant.getId());
            }
        }
        this.anr.yv();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
    
        if (r9 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
    
        r9.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fd, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.c("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (com.kwad.framework.filedownloader.f.d.apD == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        com.kwad.framework.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.ant.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
    
        r19.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r19.nf == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
    
        if (r19.anJ == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        r19.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (r19.nf == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
    
        r19.ant.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
    
        if (r9 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
    
        r9.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
    
        r19.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
    
        if (r19.nf == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
    
        if (r19.anJ == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
    
        r19.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
    
        yq();
        r14 = r19.ant.getTotal();
        a(r14, r19.ant.yr());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
    
        if (yn() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
    
        if (r19.anF == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
    
        r10 = r19.ant.zc();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
    
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.b.yc().a(r19.ant.getId(), r19.ant.getUrl(), r19.ant.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
    
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
    
        if (r10 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if (r19.nf == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        r19.ant.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
    
        if (r9 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
    
        r9.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
    
        r19.anr.yu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
    
        if (r19.nf == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
    
        if (r19.anJ == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
    
        r19.anr.yz();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bc, code lost:
    
        if (r10 != 1) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
    
        r19.anD = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        if (r11 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
    
        a(r8.ya(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
    
        if (r9 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
    
        r9.xS();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
    
        r19.anr.yx();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
    
        if (r19.anF == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dd, code lost:
    
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e1, code lost:
    
        d(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e6, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025c A[Catch: all -> 0x0217, TryCatch #25 {all -> 0x0217, blocks: (B:46:0x00cf, B:95:0x01d4, B:97:0x01dd, B:98:0x01e1, B:154:0x0256, B:156:0x025c, B:159:0x0264, B:125:0x021a), top: B:205:0x0256 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026f A[Catch: all -> 0x028f, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[Catch: all -> 0x028f, SYNTHETIC, TRY_LEAVE, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    private boolean yn() {
        return (!this.anF || this.ant.zc() > 1) && this.anG && this.anA && !this.anH;
    }

    private com.kwad.framework.filedownloader.download.a r(List<com.kwad.framework.filedownloader.d.a> list) {
        long jYZ;
        long j;
        int iZc = this.ant.zc();
        String strYr = this.ant.yr();
        String targetFilePath = this.ant.getTargetFilePath();
        boolean z = iZc > 1;
        if ((!z || this.anA) && com.kwad.framework.filedownloader.f.f.b(this.ant.getId(), this.ant)) {
            if (!this.anA) {
                jYZ = new File(strYr).length();
            } else if (z) {
                if (iZc == list.size()) {
                    jYZ = com.kwad.framework.filedownloader.d.a.s(list);
                }
                j = 0;
            } else {
                jYZ = this.ant.yZ();
            }
            j = jYZ;
        } else {
            j = 0;
        }
        this.ant.Z(j);
        boolean z2 = j > 0;
        this.anF = z2;
        if (!z2) {
            this.ano.bF(this.ant.getId());
            com.kwad.framework.filedownloader.f.f.C(targetFilePath, strYr);
        }
        return new com.kwad.framework.filedownloader.download.a(0L, j, 0L, this.ant.getTotal() - j);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) throws FileDownloadHttpException, RetryDirectly {
        int id = this.ant.getId();
        int responseCode = bVar.getResponseCode();
        this.anG = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String strZa = this.ant.za();
        String strA = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode == 412 || !(strZa == null || strZa.equals(strA) || (!z && !this.anG)) || ((responseCode == 201 && connectTask.xY()) || (responseCode == 416 && this.ant.yZ() > 0))) {
            if (this.anF) {
                com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), strZa, strA, Integer.valueOf(responseCode));
            }
            this.ano.bF(this.ant.getId());
            com.kwad.framework.filedownloader.f.f.C(this.ant.getTargetFilePath(), this.ant.yr());
            this.anF = false;
            if (strZa != null && strZa.equals(strA)) {
                com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strZa, strA, Integer.valueOf(responseCode), Integer.valueOf(id));
                strA = null;
            }
            this.ant.Z(0L);
            this.ant.ab(0L);
            this.ant.bx(strA);
            this.ant.zd();
            this.ano.a(id, this.ant.za(), this.ant.yZ(), this.ant.getTotal(), this.ant.zc());
            throw new RetryDirectly();
        }
        this.anL = connectTask.xZ();
        if (this.anG || z) {
            long jB = com.kwad.framework.filedownloader.f.f.b(id, bVar);
            String strA2 = this.ant.wF() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.ant.getUrl()) : null;
            boolean z2 = jB == -1;
            this.anH = z2;
            this.anr.a(this.anF && this.anG, !z2 ? this.ant.yZ() + jB : jB, strA, strA2);
            return;
        }
        throw new FileDownloadHttpException(responseCode, map, bVar.xR());
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) throws Throwable {
        if (!this.anG) {
            this.ant.Z(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.anj, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).bP(this.ant.getId()).bO(-1).bi(this.anw).d(bVar).c(aVar).bv(this.ant.yr());
        this.ant.bW(1);
        this.ano.t(this.ant.getId(), 1);
        this.anC = aVar2.yG();
        if (this.nf) {
            this.ant.d((byte) -2);
            this.anC.pause();
        } else {
            this.anC.run();
        }
    }

    private void a(int i, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        b(list, this.ant.getTotal());
    }

    private void d(long j, int i) {
        long j2 = j / ((long) i);
        int id = this.ant.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j3);
            aVar.X(j3);
            aVar.Y(j4);
            arrayList.add(aVar);
            this.ano.a(aVar);
            j3 += j2;
            i2++;
        }
        this.ant.bW(i);
        this.ano.t(id, i);
        b(arrayList, j);
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j) {
        long jYW;
        int id = this.ant.getId();
        String strZa = this.ant.za();
        String url = this.anL;
        if (url == null) {
            url = this.ant.getUrl();
        }
        String strYr = this.ant.yr();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.anF;
        long jYV = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.yW() == 0) {
                jYW = j - aVar.yV();
            } else {
                jYW = (aVar.yW() - aVar.yV()) + 1;
            }
            long j2 = jYW;
            jYV += aVar.yV() - aVar.getStartOffset();
            if (j2 == 0) {
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
            } else {
                c cVarYt = new c.a().bM(id).i(Integer.valueOf(aVar.getIndex())).a(this).bs(url).bt(z ? strZa : null).c(this.anu).bg(this.anw).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.yV(), aVar.yW(), j2)).bu(strYr).yt();
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.anB.add(cVarYt);
            }
        }
        if (jYV != this.ant.yZ()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.ant.yZ()), Long.valueOf(jYV));
            this.ant.Z(jYV);
        }
        ArrayList arrayList = new ArrayList(this.anB.size());
        for (c cVar : this.anB) {
            if (this.nf) {
                cVar.pause();
            } else {
                arrayList.add(Executors.callable(cVar));
            }
        }
        if (this.nf) {
            this.ant.d((byte) -2);
            return;
        }
        List<Future> listInvokeAll = anE.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            for (Future future : listInvokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(long j, String str) {
        com.kwad.framework.filedownloader.e.a aVarBJ = null;
        if (j != -1) {
            try {
                aVarBJ = com.kwad.framework.filedownloader.f.f.bJ(this.ant.yr());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes < j2) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
                if (!com.kwad.framework.filedownloader.f.e.zB().apJ) {
                    aVarBJ.setLength(j);
                }
            } finally {
                if (0 != 0) {
                    aVarBJ.close();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.nf) {
            return;
        }
        this.anr.onProgress(j);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.ant.getId()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.anY;
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.ant.getTotal()));
        }
        if (!this.anD) {
            synchronized (this.anB) {
                this.anB.remove(cVar);
            }
        } else {
            if (j == 0 || j2 == this.ant.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.ant.getTotal()), Integer.valueOf(this.ant.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.anD && code == 416 && !this.any) {
                com.kwad.framework.filedownloader.f.f.C(this.ant.getTargetFilePath(), this.ant.yr());
                this.any = true;
                return true;
            }
        }
        return this.anz > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.anJ = true;
        this.anK = exc;
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.ant.getId()));
            }
        } else {
            for (c cVar : (ArrayList) this.anB.clone()) {
                if (cVar != null) {
                    cVar.xy();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.nf) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.ant.getId()));
            }
        } else {
            int i = this.anz;
            int i2 = i - 1;
            this.anz = i2;
            if (i < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.ant.getId()));
            }
            this.anr.a(exc, this.anz, j);
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void yo() {
        this.ano.b(this.ant.getId(), this.ant.yZ());
    }

    private void yp() {
        if (this.anw && !com.kwad.framework.filedownloader.f.f.bH(g.b)) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.ant.getId()), g.b));
        }
        if (this.anw && com.kwad.framework.filedownloader.f.f.zG()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void yq() throws RetryDirectly, DiscardSafely {
        int id = this.ant.getId();
        if (this.ant.wF()) {
            String targetFilePath = this.ant.getTargetFilePath();
            int iB = com.kwad.framework.filedownloader.f.f.B(this.ant.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.anv, false)) {
                this.ano.bG(id);
                this.ano.bF(id);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c cVarBD = this.ano.bD(iB);
            if (cVarBD != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id, cVarBD, this.anx, false)) {
                    this.ano.bG(id);
                    this.ano.bF(id);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> listBE = this.ano.bE(iB);
                this.ano.bG(iB);
                this.ano.bF(iB);
                com.kwad.framework.filedownloader.f.f.bL(this.ant.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(iB, cVarBD)) {
                    this.ant.Z(cVarBD.yZ());
                    this.ant.ab(cVarBD.getTotal());
                    this.ant.bx(cVarBD.za());
                    this.ant.bW(cVarBD.zc());
                    this.ano.b(this.ant);
                    if (listBE != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : listBE) {
                            aVar.setId(id);
                            this.ano.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id, this.ant.yZ(), this.ant.yr(), targetFilePath, this.anx)) {
                this.ano.bG(id);
                this.ano.bF(id);
                throw new DiscardSafely();
            }
        }
    }

    public final int getId() {
        return this.ant.getId();
    }

    public final boolean isAlive() {
        return this.anI.get() || this.anr.isAlive();
    }

    public final String yr() {
        return this.ant.yr();
    }

    class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    public static class a {
        private Integer anQ;
        private Integer anR;
        private Boolean anS;
        private Boolean anT;
        private Integer anU;
        private com.kwad.framework.filedownloader.d.b ana;
        private com.kwad.framework.filedownloader.d.c ant;
        private y anx;

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.ant = cVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.ana = bVar;
            return this;
        }

        public final a a(y yVar) {
            this.anx = yVar;
            return this;
        }

        public final a f(Integer num) {
            this.anQ = num;
            return this;
        }

        public final a g(Integer num) {
            this.anR = num;
            return this;
        }

        public final a a(Boolean bool) {
            this.anS = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.anT = bool;
            return this;
        }

        public final a h(Integer num) {
            this.anU = num;
            return this;
        }

        public final DownloadLaunchRunnable ys() {
            if (this.ant == null || this.anx == null || this.anQ == null || this.anR == null || this.anS == null || this.anT == null || this.anU == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.ant, this.ana, this.anx, this.anQ.intValue(), this.anR.intValue(), this.anS.booleanValue(), this.anT.booleanValue(), this.anU.intValue(), (byte) 0);
        }
    }
}
