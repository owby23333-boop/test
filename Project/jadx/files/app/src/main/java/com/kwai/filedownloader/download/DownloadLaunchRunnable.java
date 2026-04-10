package com.kwai.filedownloader.download;

import com.kwad.sdk.crash.utils.h;
import com.kwai.filedownloader.download.c;
import com.kwai.filedownloader.download.e;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadHttpException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwai.filedownloader.y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor aFT = com.kwai.filedownloader.e.b.fh("ConnectionBlock");
    private final com.kwai.filedownloader.a.a aFD;
    private final d aFG;
    private final int aFH;
    private final com.kwai.filedownloader.c.c aFI;
    private final com.kwai.filedownloader.c.b aFJ;
    private final boolean aFK;
    private final boolean aFL;
    private final y aFM;
    private boolean aFN;
    int aFO;
    private final boolean aFP;
    private final ArrayList<c> aFQ;
    private e aFR;
    private boolean aFS;
    private boolean aFU;
    private boolean aFV;
    private boolean aFW;
    private final AtomicBoolean aFX;
    private volatile boolean aFY;
    private volatile Exception aFZ;
    private String aGa;
    private long aGb;
    private long aGc;
    private long aGd;
    private long aGe;
    private volatile boolean lf;

    class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    public static class a {
        private com.kwai.filedownloader.c.c aFI;
        private y aFM;
        private com.kwai.filedownloader.c.b aFp;
        private Integer aGf;
        private Integer aGg;
        private Boolean aGh;
        private Boolean aGi;
        private Integer aGj;

        public final DownloadLaunchRunnable HI() {
            y yVar;
            Integer num;
            com.kwai.filedownloader.c.c cVar = this.aFI;
            if (cVar == null || (yVar = this.aFM) == null || (num = this.aGf) == null || this.aGg == null || this.aGh == null || this.aGi == null || this.aGj == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(cVar, this.aFp, yVar, num.intValue(), this.aGg.intValue(), this.aGh.booleanValue(), this.aGi.booleanValue(), this.aGj.intValue(), (byte) 0);
        }

        public final a a(y yVar) {
            this.aFM = yVar;
            return this;
        }

        public final a a(Integer num) {
            this.aGf = num;
            return this;
        }

        public final a b(com.kwai.filedownloader.c.b bVar) {
            this.aFp = bVar;
            return this;
        }

        public final a b(Boolean bool) {
            this.aGh = bool;
            return this;
        }

        public final a b(Integer num) {
            this.aGg = num;
            return this;
        }

        public final a c(Boolean bool) {
            this.aGi = bool;
            return this;
        }

        public final a c(Integer num) {
            this.aGj = num;
            return this;
        }

        public final a e(com.kwai.filedownloader.c.c cVar) {
            this.aFI = cVar;
            return this;
        }
    }

    private DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i2, int i3, boolean z2, boolean z3, int i4) {
        this.aFH = 5;
        this.aFQ = new ArrayList<>(5);
        this.aGb = 0L;
        this.aGc = 0L;
        this.aGd = 0L;
        this.aGe = 0L;
        this.aFX = new AtomicBoolean(true);
        this.lf = false;
        this.aFN = false;
        this.aFI = cVar;
        this.aFJ = bVar;
        this.aFK = z2;
        this.aFL = z3;
        this.aFD = b.Ht().Hv();
        this.aFP = b.Ht().Hx();
        this.aFM = yVar;
        this.aFO = i4;
        this.aFG = new d(cVar, i4, i2, i3);
    }

    /* synthetic */ DownloadLaunchRunnable(com.kwai.filedownloader.c.c cVar, com.kwai.filedownloader.c.b bVar, y yVar, int i2, int i3, boolean z2, boolean z3, int i4, byte b) {
        this(cVar, bVar, yVar, i2, i3, z2, z3, i4);
    }

    private boolean HD() {
        return (!this.aFU || this.aFI.Ir() > 1) && this.aFV && this.aFP && !this.aFW;
    }

    private void HF() {
        if (this.aFL && !com.kwai.filedownloader.e.f.fo("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.aFI.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.aFL && com.kwai.filedownloader.e.f.IU()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void HG() throws DiscardSafely, RetryDirectly {
        int id = this.aFI.getId();
        if (this.aFI.Ga()) {
            String targetFilePath = this.aFI.getTargetFilePath();
            int iAm = com.kwai.filedownloader.e.f.am(this.aFI.getUrl(), targetFilePath);
            if (com.kwai.filedownloader.e.c.a(id, targetFilePath, this.aFK, false)) {
                this.aFD.cG(id);
                this.aFD.cF(id);
                throw new DiscardSafely();
            }
            com.kwai.filedownloader.c.c cVarCD = this.aFD.cD(iAm);
            if (cVarCD != null) {
                if (com.kwai.filedownloader.e.c.a(id, cVarCD, this.aFM, false)) {
                    this.aFD.cG(id);
                    this.aFD.cF(id);
                    throw new DiscardSafely();
                }
                List<com.kwai.filedownloader.c.a> listCE = this.aFD.cE(iAm);
                this.aFD.cG(iAm);
                this.aFD.cF(iAm);
                com.kwai.filedownloader.e.f.fs(this.aFI.getTargetFilePath());
                if (com.kwai.filedownloader.e.f.b(iAm, cVarCD)) {
                    this.aFI.ao(cVarCD.Ip());
                    this.aFI.aq(cVarCD.getTotal());
                    this.aFI.fe(cVarCD.Iq());
                    this.aFI.cW(cVarCD.Ir());
                    this.aFD.b(this.aFI);
                    if (listCE != null) {
                        for (com.kwai.filedownloader.c.a aVar : listCE) {
                            aVar.setId(id);
                            this.aFD.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwai.filedownloader.e.c.a(id, this.aFI.Ip(), this.aFI.HH(), targetFilePath, this.aFM)) {
                this.aFD.cG(id);
                this.aFD.cF(id);
                throw new DiscardSafely();
            }
        }
    }

    private com.kwai.filedownloader.download.a I(List<com.kwai.filedownloader.c.a> list) {
        long jIp;
        long j2;
        int iIr = this.aFI.Ir();
        String strHH = this.aFI.HH();
        String targetFilePath = this.aFI.getTargetFilePath();
        boolean z2 = iIr > 1;
        if ((!z2 || this.aFP) && com.kwai.filedownloader.e.f.b(this.aFI.getId(), this.aFI)) {
            if (!this.aFP) {
                jIp = new File(strHH).length();
            } else if (z2) {
                if (iIr == list.size()) {
                    jIp = com.kwai.filedownloader.c.a.J(list);
                }
                j2 = 0;
            } else {
                jIp = this.aFI.Ip();
            }
            j2 = jIp;
        } else {
            j2 = 0;
        }
        this.aFI.ao(j2);
        this.aFU = j2 > 0;
        if (!this.aFU) {
            this.aFD.cF(this.aFI.getId());
            com.kwai.filedownloader.e.f.an(targetFilePath, strHH);
        }
        return new com.kwai.filedownloader.download.a(0L, j2, 0L, this.aFI.getTotal() - j2);
    }

    private void a(int i2, List<com.kwai.filedownloader.c.a> list) {
        if (i2 <= 1 || list.size() != i2) {
            throw new IllegalArgumentException();
        }
        b(list, this.aFI.getTotal());
    }

    private void a(long j2, String str) {
        com.kwai.filedownloader.d.a aVarFq = null;
        if (j2 != -1) {
            try {
                aVarFq = com.kwai.filedownloader.e.f.fq(this.aFI.HH());
                long length = new File(str).length();
                long j3 = j2 - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes < j3) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j3, length);
                }
                if (!com.kwai.filedownloader.e.e.IP().aHZ) {
                    aVarFq.setLength(j2);
                }
            } finally {
                if (0 != 0) {
                    aVarFq.close();
                }
            }
        }
    }

    private void a(com.kwai.filedownloader.download.a aVar, com.kwai.filedownloader.kwai.b bVar) throws Throwable {
        if (!this.aFV) {
            this.aFI.ao(0L);
            aVar = new com.kwai.filedownloader.download.a(0L, 0L, aVar.aFy, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).cP(this.aFI.getId()).cO(-1).bO(this.aFL).d(bVar).c(aVar).fc(this.aFI.HH());
        this.aFI.cW(1);
        this.aFD.z(this.aFI.getId(), 1);
        this.aFR = aVar2.HW();
        if (!this.lf) {
            this.aFR.run();
        } else {
            this.aFI.e((byte) -2);
            this.aFR.pause();
        }
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwai.filedownloader.kwai.b bVar) throws FileDownloadHttpException, RetryDirectly {
        int id = this.aFI.getId();
        int responseCode = bVar.getResponseCode();
        this.aFV = responseCode == 206 || responseCode == 1;
        boolean z2 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String strIq = this.aFI.Iq();
        String strA = com.kwai.filedownloader.e.f.a(id, bVar);
        if (!(responseCode == 412 || !(strIq == null || strIq.equals(strA) || (!z2 && !this.aFV)) || ((responseCode == 201 && connectTask.Hp()) || (responseCode == 416 && this.aFI.Ip() > 0)))) {
            this.aGa = connectTask.Hq();
            if (!this.aFV && !z2) {
                throw new FileDownloadHttpException(responseCode, map, bVar.W());
            }
            long jB = com.kwai.filedownloader.e.f.b(id, bVar);
            String strA2 = this.aFI.Ga() ? com.kwai.filedownloader.e.f.a(bVar, this.aFI.getUrl()) : null;
            this.aFW = jB == -1;
            this.aFG.a(this.aFU && this.aFV, !this.aFW ? this.aFI.Ip() + jB : jB, strA, strA2);
            return;
        }
        if (this.aFU) {
            com.kwai.filedownloader.e.d.h(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), strIq, strA, Integer.valueOf(responseCode));
        }
        this.aFD.cF(this.aFI.getId());
        com.kwai.filedownloader.e.f.an(this.aFI.getTargetFilePath(), this.aFI.HH());
        this.aFU = false;
        if (strIq != null && strIq.equals(strA)) {
            com.kwai.filedownloader.e.d.h(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strIq, strA, Integer.valueOf(responseCode), Integer.valueOf(id));
            strA = null;
        }
        this.aFI.ao(0L);
        this.aFI.aq(0L);
        this.aFI.fe(strA);
        this.aFI.Is();
        this.aFD.a(id, this.aFI.Iq(), this.aFI.Ip(), this.aFI.getTotal(), this.aFI.Ir());
        throw new RetryDirectly();
    }

    private void b(List<com.kwai.filedownloader.c.a> list, long j2) {
        int id = this.aFI.getId();
        String strIq = this.aFI.Iq();
        String url = this.aGa;
        if (url == null) {
            url = this.aFI.getUrl();
        }
        String strHH = this.aFI.HH();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j2));
        }
        boolean z2 = this.aFU;
        long j3 = 0;
        long jIl = 0;
        for (com.kwai.filedownloader.c.a aVar : list) {
            long jIl2 = aVar.Im() == j3 ? j2 - aVar.Il() : (aVar.Im() - aVar.Il()) + 1;
            jIl += aVar.Il() - aVar.getStartOffset();
            if (jIl2 != j3) {
                c cVarHJ = new c.a().cM(id).d(Integer.valueOf(aVar.getIndex())).a(this).eZ(url).fa(z2 ? strIq : null).c(this.aFJ).bM(this.aFL).b(new com.kwai.filedownloader.download.a(aVar.getStartOffset(), aVar.Il(), aVar.Im(), jIl2)).fb(strHH).HJ();
                if (com.kwai.filedownloader.e.d.aHT) {
                    com.kwai.filedownloader.e.d.g(this, "enable multiple connection: %s", aVar);
                }
                this.aFQ.add(cVarHJ);
            } else if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
            j3 = 0;
        }
        if (jIl != this.aFI.Ip()) {
            com.kwai.filedownloader.e.d.h(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.aFI.Ip()), Long.valueOf(jIl));
            this.aFI.ao(jIl);
        }
        ArrayList arrayList = new ArrayList(this.aFQ.size());
        for (c cVar : this.aFQ) {
            if (this.lf) {
                cVar.pause();
            } else {
                arrayList.add(Executors.callable(cVar));
            }
        }
        if (this.lf) {
            this.aFI.e((byte) -2);
            return;
        }
        List<Future> listInvokeAll = aFT.invokeAll(arrayList);
        if (com.kwai.filedownloader.e.d.aHT) {
            for (Future future : listInvokeAll) {
                com.kwai.filedownloader.e.d.g(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void d(long j2, int i2) {
        long j3 = j2 / ((long) i2);
        int id = this.aFI.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + (-1) ? 0L : (j4 + j3) - 1;
            com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
            aVar.setId(id);
            aVar.setIndex(i3);
            aVar.setStartOffset(j4);
            aVar.am(j4);
            aVar.an(j5);
            arrayList.add(aVar);
            this.aFD.a(aVar);
            j4 += j3;
            i3++;
        }
        this.aFI.cW(i2);
        this.aFD.z(id, i2);
        b(arrayList, j2);
    }

    public final void HC() {
        if (this.aFI.Ir() > 1) {
            List<com.kwai.filedownloader.c.a> listCE = this.aFD.cE(this.aFI.getId());
            if (this.aFI.Ir() == listCE.size()) {
                this.aFI.ao(com.kwai.filedownloader.c.a.J(listCE));
            } else {
                this.aFI.ao(0L);
                this.aFD.cF(this.aFI.getId());
            }
        }
        this.aFG.HL();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void HE() {
        this.aFD.d(this.aFI.getId(), this.aFI.Ip());
    }

    public final String HH() {
        return this.aFI.HH();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(c cVar, long j2, long j3) {
        if (this.lf) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.aFI.getId()));
                return;
            }
            return;
        }
        int i2 = cVar == null ? -1 : cVar.aGn;
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.aFI.getTotal()));
        }
        if (!this.aFS) {
            synchronized (this.aFQ) {
                this.aFQ.remove(cVar);
            }
        } else {
            if (j2 == 0 || j3 == this.aFI.getTotal()) {
                return;
            }
            com.kwai.filedownloader.e.d.e(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.aFI.getTotal()), Integer.valueOf(this.aFI.getId()));
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final void a(Exception exc, long j2) {
        if (this.lf) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.aFI.getId()));
            }
        } else {
            int i2 = this.aFO;
            this.aFO = i2 - 1;
            if (i2 < 0) {
                com.kwai.filedownloader.e.d.e(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(this.aFO), Integer.valueOf(this.aFI.getId()));
            }
            this.aFG.a(exc, this.aFO, j2);
        }
    }

    @Override // com.kwai.filedownloader.download.f
    public final boolean c(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.aFS && code == 416 && !this.aFN) {
                com.kwai.filedownloader.e.f.an(this.aFI.getTargetFilePath(), this.aFI.HH());
                this.aFN = true;
                return true;
            }
        }
        return this.aFO > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwai.filedownloader.download.f
    public final void d(Exception exc) {
        this.aFY = true;
        this.aFZ = exc;
        if (this.lf) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.aFI.getId()));
            }
        } else {
            for (c cVar : (ArrayList) this.aFQ.clone()) {
                if (cVar != null) {
                    cVar.GT();
                }
            }
        }
    }

    public final int getId() {
        return this.aFI.getId();
    }

    public final boolean isAlive() {
        return this.aFX.get() || this.aFG.isAlive();
    }

    @Override // com.kwai.filedownloader.download.f
    public final void onProgress(long j2) {
        if (this.lf) {
            return;
        }
        this.aFG.onProgress(j2);
    }

    public final void pause() {
        this.lf = true;
        e eVar = this.aFR;
        if (eVar != null) {
            eVar.pause();
        }
        for (c cVar : (ArrayList) this.aFQ.clone()) {
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01eb, code lost:
    
        r2.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0201, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwai.filedownloader.e.f.j("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (com.kwai.filedownloader.e.d.aHT == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        com.kwai.filedownloader.e.d.g(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.aFI.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
    
        r19.aFG.HK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r19.lf == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
    
        if (r19.aFY == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        r19.aFG.HP();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (r19.lf == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
    
        r19.aFI.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
    
        if (r9 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
    
        r19.aFG.HK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
    
        if (r19.lf == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
    
        if (r19.aFY == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
    
        r19.aFG.HP();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
    
        HG();
        r14 = r19.aFI.getTotal();
        a(r14, r19.aFI.HH());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
    
        if (HD() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
    
        if (r19.aFU == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
    
        r10 = r19.aFI.Ir();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
    
        r17 = r14;
        r10 = com.kwai.filedownloader.download.b.Ht().a(r19.aFI.getId(), r19.aFI.getUrl(), r19.aFI.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
    
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
    
        if (r10 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if (r19.lf == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        r19.aFI.e((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
    
        if (r9 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
    
        r19.aFG.HK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
    
        if (r19.lf == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
    
        if (r19.aFY == false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
    
        r19.aFG.HP();
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
    
        r19.aFS = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c5, code lost:
    
        if (r19.aFS == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c7, code lost:
    
        a(r8.Hr(), r9);
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
    
        if (r9 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d2, code lost:
    
        r9.X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d6, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d7, code lost:
    
        r19.aFG.HN();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01de, code lost:
    
        if (r19.aFU == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e0, code lost:
    
        a(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e4, code lost:
    
        d(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e9, code lost:
    
        if (r2 == null) goto L164;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0257 A[Catch: all -> 0x026c, TRY_LEAVE, TryCatch #4 {all -> 0x026c, blocks: (B:47:0x0117, B:49:0x0122, B:62:0x0148, B:64:0x0160, B:66:0x0164, B:70:0x0192, B:72:0x0196, B:88:0x01c1, B:90:0x01c7, B:92:0x01d2, B:103:0x01f2, B:104:0x0201, B:67:0x016d, B:150:0x0251, B:152:0x0257, B:156:0x0263), top: B:193:0x0251 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0270 A[Catch: all -> 0x0290, TryCatch #22 {all -> 0x0290, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:100:0x01eb, B:126:0x0225, B:154:0x025e, B:158:0x0268, B:162:0x0270, B:163:0x0273, B:124:0x021e), top: B:204:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[Catch: all -> 0x0290, SYNTHETIC, TRY_LEAVE, TryCatch #22 {all -> 0x0290, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:100:0x01eb, B:126:0x0225, B:154:0x025e, B:158:0x0268, B:162:0x0270, B:163:0x0273, B:124:0x021e), top: B:204:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.DownloadLaunchRunnable.run():void");
    }
}
