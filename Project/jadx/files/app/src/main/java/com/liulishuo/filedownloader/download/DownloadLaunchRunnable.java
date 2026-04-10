package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.download.d;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.y;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadLaunchRunnable implements Runnable, g {
    private static final ThreadPoolExecutor O = com.liulishuo.filedownloader.h0.b.a("ConnectionBlock");
    int A;
    private boolean B;
    private final boolean C;
    private final ArrayList<d> D;
    private d E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private final AtomicBoolean J;
    private volatile boolean K;
    private volatile boolean L;
    private volatile Exception M;
    private String N;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final e f17106s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final FileDownloadModel f17107t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final FileDownloadHeader f17108u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f17109v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f17110w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final com.liulishuo.filedownloader.e0.a f17111x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final y f17112y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17113z;

    class DiscardSafely extends Throwable {
        DiscardSafely(DownloadLaunchRunnable downloadLaunchRunnable) {
        }
    }

    class RetryDirectly extends Throwable {
        RetryDirectly(DownloadLaunchRunnable downloadLaunchRunnable) {
        }
    }

    public static class b {
        private FileDownloadModel a;
        private FileDownloadHeader b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private y f17114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f17115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f17116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Boolean f17117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Boolean f17118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Integer f17119h;

        public b a(FileDownloadModel fileDownloadModel) {
            this.a = fileDownloadModel;
            return this;
        }

        public b b(Boolean bool) {
            this.f17118g = bool;
            return this;
        }

        public b c(Integer num) {
            this.f17115d = num;
            return this;
        }

        public b a(FileDownloadHeader fileDownloadHeader) {
            this.b = fileDownloadHeader;
            return this;
        }

        public b b(Integer num) {
            this.f17119h = num;
            return this;
        }

        public b a(y yVar) {
            this.f17114c = yVar;
            return this;
        }

        public b a(Integer num) {
            this.f17116e = num;
            return this;
        }

        public b a(Boolean bool) {
            this.f17117f = bool;
            return this;
        }

        public DownloadLaunchRunnable a() {
            y yVar;
            Integer num;
            FileDownloadModel fileDownloadModel = this.a;
            if (fileDownloadModel != null && (yVar = this.f17114c) != null && (num = this.f17115d) != null && this.f17116e != null && this.f17117f != null && this.f17118g != null && this.f17119h != null) {
                return new DownloadLaunchRunnable(fileDownloadModel, this.b, yVar, num.intValue(), this.f17116e.intValue(), this.f17117f.booleanValue(), this.f17118g.booleanValue(), this.f17119h.intValue());
            }
            throw new IllegalArgumentException();
        }
    }

    private int a(long j2) {
        if (i()) {
            return this.G ? this.f17107t.a() : c.i().a(this.f17107t.e(), this.f17107t.p(), this.f17107t.f(), j2);
        }
        return 1;
    }

    private void b(long j2) throws Throwable {
        com.liulishuo.filedownloader.download.b bVarA;
        if (this.H) {
            bVarA = b.C0483b.a(this.f17107t.g(), this.f17107t.g(), j2 - this.f17107t.g());
        } else {
            this.f17107t.b(0L);
            bVarA = b.C0483b.a(j2);
        }
        d.b bVar = new d.b();
        bVar.a(this.f17107t.e());
        bVar.a((Integer) (-1));
        bVar.a(this);
        bVar.c(this.f17107t.p());
        bVar.a(this.f17107t.b());
        bVar.a(this.f17108u);
        bVar.a(this.f17110w);
        bVar.a(bVarA);
        bVar.b(this.f17107t.n());
        this.E = bVar.a();
        this.f17107t.a(1);
        this.f17111x.a(this.f17107t.e(), 1);
        if (!this.K) {
            this.E.run();
        } else {
            this.f17107t.a((byte) -2);
            this.E.b();
        }
    }

    private void g() throws DiscardSafely, RetryDirectly {
        int iE = this.f17107t.e();
        if (this.f17107t.s()) {
            String strI = this.f17107t.i();
            int iC = com.liulishuo.filedownloader.h0.f.c(this.f17107t.p(), strI);
            if (com.liulishuo.filedownloader.h0.c.a(iE, strI, this.f17109v, false)) {
                this.f17111x.remove(iE);
                this.f17111x.e(iE);
                throw new DiscardSafely(this);
            }
            FileDownloadModel fileDownloadModelD = this.f17111x.d(iC);
            if (fileDownloadModelD != null) {
                if (com.liulishuo.filedownloader.h0.c.a(iE, fileDownloadModelD, this.f17112y, false)) {
                    this.f17111x.remove(iE);
                    this.f17111x.e(iE);
                    throw new DiscardSafely(this);
                }
                List<com.liulishuo.filedownloader.model.a> listC = this.f17111x.c(iC);
                this.f17111x.remove(iC);
                this.f17111x.e(iC);
                com.liulishuo.filedownloader.h0.f.d(this.f17107t.i());
                if (com.liulishuo.filedownloader.h0.f.a(iC, fileDownloadModelD)) {
                    this.f17107t.b(fileDownloadModelD.g());
                    this.f17107t.c(fileDownloadModelD.o());
                    this.f17107t.a(fileDownloadModelD.b());
                    this.f17107t.a(fileDownloadModelD.a());
                    this.f17111x.update(this.f17107t);
                    if (listC != null) {
                        for (com.liulishuo.filedownloader.model.a aVar : listC) {
                            aVar.a(iE);
                            this.f17111x.a(aVar);
                        }
                    }
                    throw new RetryDirectly(this);
                }
            }
            if (com.liulishuo.filedownloader.h0.c.a(iE, this.f17107t.g(), this.f17107t.n(), strI, this.f17112y)) {
                this.f17111x.remove(iE);
                this.f17111x.e(iE);
                throw new DiscardSafely(this);
            }
        }
    }

    private void h() throws FileDownloadGiveUpRetryException {
        if (this.f17110w && !com.liulishuo.filedownloader.h0.f.a("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.h0.f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f17107t.e()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.f17110w && com.liulishuo.filedownloader.h0.f.e()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private boolean i() {
        return (!this.G || this.f17107t.a() > 1) && this.H && this.C && !this.I;
    }

    private void j() throws IllegalAccessException, FileDownloadSecurityException, IOException, RetryDirectly {
        com.liulishuo.filedownloader.d0.b bVarA = null;
        try {
            com.liulishuo.filedownloader.download.b bVarB = this.B ? b.C0483b.b() : b.C0483b.a();
            a.b bVar = new a.b();
            bVar.a(this.f17107t.e());
            bVar.b(this.f17107t.p());
            bVar.a(this.f17107t.b());
            bVar.a(this.f17108u);
            bVar.a(bVarB);
            com.liulishuo.filedownloader.download.a aVarA = bVar.a();
            bVarA = aVarA.a();
            a(aVarA.d(), aVarA, bVarA);
        } finally {
            if (bVarA != null) {
                bVarA.a();
            }
        }
    }

    @Override // com.liulishuo.filedownloader.download.g
    public boolean c(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int iF = ((FileDownloadHttpException) exc).f();
            if (this.F && iF == 416 && !this.f17113z) {
                com.liulishuo.filedownloader.h0.f.a(this.f17107t.i(), this.f17107t.n());
                this.f17113z = true;
                return true;
            }
        }
        return this.A > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    public boolean d() {
        return this.J.get() || this.f17106s.b();
    }

    public void e() {
        this.K = true;
        d dVar = this.E;
        if (dVar != null) {
            dVar.b();
        }
        for (d dVar2 : (ArrayList) this.D.clone()) {
            if (dVar2 != null) {
                dVar2.b();
            }
        }
    }

    public void f() {
        a(this.f17111x.c(this.f17107t.e()));
        this.f17106s.f();
    }

    @Override // com.liulishuo.filedownloader.download.g
    public void onProgress(long j2) {
        if (this.K) {
            return;
        }
        this.f17106s.a(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
    
        if (com.liulishuo.filedownloader.h0.d.a == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        com.liulishuo.filedownloader.h0.d.a(r11, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r11.f17107t.e()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00af, code lost:
    
        r11.f17106s.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b6, code lost:
    
        if (r11.K == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bb, code lost:
    
        if (r11.L == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
    
        r11.f17106s.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e0, code lost:
    
        if (r11.K == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e2, code lost:
    
        r11.f17107t.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        r11.f17106s.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
    
        if (r11.K == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f4, code lost:
    
        if (r11.L == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        r11.f17106s.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fe, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
    
        r5 = r11.f17107t.o();
        a(r5, r11.f17107t.n());
        r7 = a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0113, code lost:
    
        if (r7 <= 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
    
        if (r5 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011b, code lost:
    
        r11.f17106s.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
    
        if (r11.K == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0128, code lost:
    
        if (r11.L == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012c, code lost:
    
        r11.f17106s.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0133, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0138, code lost:
    
        if (r11.K == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013a, code lost:
    
        r11.f17107t.a((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013f, code lost:
    
        r11.f17106s.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0146, code lost:
    
        if (r11.K == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x014c, code lost:
    
        if (r11.L == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0150, code lost:
    
        r11.f17106s.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0157, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015a, code lost:
    
        if (r7 != 1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015c, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015e, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015f, code lost:
    
        r11.F = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0163, code lost:
    
        if (r11.F == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0165, code lost:
    
        b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0169, code lost:
    
        r11.f17106s.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0170, code lost:
    
        if (r11.G == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0172, code lost:
    
        a(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0176, code lost:
    
        a(r5, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018d, code lost:
    
        throw new java.lang.IllegalAccessException(com.liulishuo.filedownloader.h0.f.a("invalid connection count %d, the connection count must be larger than 0", java.lang.Integer.valueOf(r7)));
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c3 A[Catch: all -> 0x01f8, TryCatch #13 {all -> 0x01f8, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:11:0x0030, B:24:0x008d, B:26:0x0091, B:27:0x0096, B:29:0x009a, B:31:0x009e, B:42:0x00c6, B:44:0x00e2, B:55:0x0100, B:69:0x0136, B:71:0x013a, B:85:0x015f, B:87:0x0165, B:88:0x0169, B:90:0x0172, B:91:0x0176, B:92:0x017a, B:93:0x018d, B:94:0x018e, B:117:0x01bd, B:119:0x01c3, B:120:0x01c8), top: B:161:0x0003, inners: #15, #12, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    private DownloadLaunchRunnable(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, y yVar, int i2, int i3, boolean z2, boolean z3, int i4) {
        this.B = false;
        this.D = new ArrayList<>(5);
        this.J = new AtomicBoolean(true);
        this.K = false;
        this.f17113z = false;
        this.f17107t = fileDownloadModel;
        this.f17108u = fileDownloadHeader;
        this.f17109v = z2;
        this.f17110w = z3;
        this.f17111x = c.i().a();
        this.C = c.i().e();
        this.f17112y = yVar;
        this.A = i4;
        this.f17106s = new e(fileDownloadModel, i4, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(java.util.List<com.liulishuo.filedownloader.model.a> r11) {
        /*
            r10 = this;
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r10.f17107t
            int r0 = r0.a()
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r10.f17107t
            java.lang.String r1 = r1.n()
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = r10.f17107t
            java.lang.String r2 = r2.i()
            r3 = 0
            r4 = 1
            if (r0 <= r4) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            boolean r6 = r10.B
            r7 = 0
            if (r6 == 0) goto L21
        L1f:
            r5 = r7
            goto L58
        L21:
            if (r5 == 0) goto L28
            boolean r6 = r10.C
            if (r6 != 0) goto L28
            goto L1f
        L28:
            com.liulishuo.filedownloader.model.FileDownloadModel r6 = r10.f17107t
            int r6 = r6.e()
            com.liulishuo.filedownloader.model.FileDownloadModel r9 = r10.f17107t
            boolean r6 = com.liulishuo.filedownloader.h0.f.a(r6, r9)
            if (r6 == 0) goto L1f
            boolean r6 = r10.C
            if (r6 != 0) goto L44
            java.io.File r11 = new java.io.File
            r11.<init>(r1)
            long r5 = r11.length()
            goto L58
        L44:
            if (r5 == 0) goto L52
            int r5 = r11.size()
            if (r0 == r5) goto L4d
            goto L1f
        L4d:
            long r5 = com.liulishuo.filedownloader.model.a.a(r11)
            goto L58
        L52:
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r10.f17107t
            long r5 = r11.g()
        L58:
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r10.f17107t
            r11.b(r5)
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 <= 0) goto L62
            r3 = 1
        L62:
            r10.G = r3
            boolean r11 = r10.G
            if (r11 != 0) goto L76
            com.liulishuo.filedownloader.e0.a r11 = r10.f17111x
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r10.f17107t
            int r0 = r0.e()
            r11.e(r0)
            com.liulishuo.filedownloader.h0.f.a(r2, r1)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.DownloadLaunchRunnable.a(java.util.List):void");
    }

    public String c() {
        return this.f17107t.n();
    }

    private void a(Map<String, List<String>> map, com.liulishuo.filedownloader.download.a aVar, com.liulishuo.filedownloader.d0.b bVar) throws FileDownloadSecurityException, IOException, IllegalArgumentException, RetryDirectly {
        boolean z2;
        int iE = this.f17107t.e();
        int responseCode = bVar.getResponseCode();
        this.H = com.liulishuo.filedownloader.h0.f.c(responseCode, bVar);
        boolean z3 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        long jB = com.liulishuo.filedownloader.h0.f.b(bVar);
        String strB = this.f17107t.b();
        String strB2 = com.liulishuo.filedownloader.h0.f.b(iE, bVar);
        if (responseCode != 412 && ((strB == null || strB.equals(strB2) || !(z3 || this.H)) && !(responseCode == 201 && aVar.e()))) {
            if (responseCode == 416) {
                if (!this.H || jB < 0) {
                    if (this.f17107t.g() > 0) {
                        com.liulishuo.filedownloader.h0.d.e(this, "get 416, precondition failed and just retry", new Object[0]);
                    } else if (!this.B) {
                        this.B = true;
                        com.liulishuo.filedownloader.h0.d.e(this, "get 416, precondition failed and need to retry with discarding range", new Object[0]);
                    }
                    z2 = true;
                } else {
                    com.liulishuo.filedownloader.h0.d.e(this, "get 416 but the Content-Range is returned, no need to retry", new Object[0]);
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (this.G) {
                com.liulishuo.filedownloader.h0.d.e(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", Integer.valueOf(iE), strB, strB2, Integer.valueOf(responseCode));
            }
            this.f17111x.e(this.f17107t.e());
            com.liulishuo.filedownloader.h0.f.a(this.f17107t.i(), this.f17107t.n());
            this.G = false;
            if (strB != null && strB.equals(strB2)) {
                com.liulishuo.filedownloader.h0.d.e(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strB, strB2, Integer.valueOf(responseCode), Integer.valueOf(iE));
                strB2 = null;
            }
            this.f17107t.b(0L);
            this.f17107t.c(0L);
            this.f17107t.a(strB2);
            this.f17107t.t();
            this.f17111x.a(iE, this.f17107t.b(), this.f17107t.g(), this.f17107t.o(), this.f17107t.a());
            throw new RetryDirectly(this);
        }
        this.N = aVar.b();
        if (!this.H && !z3) {
            throw new FileDownloadHttpException(responseCode, map, bVar.c());
        }
        String strA = this.f17107t.s() ? com.liulishuo.filedownloader.h0.f.a(bVar, this.f17107t.p()) : null;
        this.I = jB == -1;
        this.f17106s.a(this.G && this.H, jB, strB2, strA);
    }

    @Override // com.liulishuo.filedownloader.download.g
    public void b(Exception exc) {
        this.L = true;
        this.M = exc;
        if (this.K) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f17107t.e()));
            }
        } else {
            for (d dVar : (ArrayList) this.D.clone()) {
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public int b() {
        return this.f17107t.e();
    }

    private void a(int i2, List<com.liulishuo.filedownloader.model.a> list) throws InterruptedException {
        if (i2 > 1 && list.size() == i2) {
            a(list, this.f17107t.o());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j2, int i2) throws InterruptedException {
        long j3 = j2 / ((long) i2);
        int iE = this.f17107t.e();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        int i3 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + (-1) ? -1L : (j4 + j3) - 1;
            com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
            aVar.a(iE);
            aVar.b(i3);
            aVar.c(j4);
            aVar.a(j4);
            aVar.b(j5);
            arrayList.add(aVar);
            this.f17111x.a(aVar);
            j4 += j3;
            i3++;
        }
        this.f17107t.a(i2);
        this.f17111x.a(iE, i2);
        a(arrayList, j2);
    }

    private void a(List<com.liulishuo.filedownloader.model.a> list, long j2) throws InterruptedException {
        long jB;
        int iE = this.f17107t.e();
        String strB = this.f17107t.b();
        String strP = this.N;
        if (strP == null) {
            strP = this.f17107t.p();
        }
        String strN = this.f17107t.n();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(iE), Long.valueOf(j2));
        }
        boolean z2 = this.G;
        long j3 = 0;
        long jA = 0;
        for (com.liulishuo.filedownloader.model.a aVar : list) {
            if (aVar.b() == -1) {
                jB = j2 - aVar.a();
            } else {
                jB = (aVar.b() - aVar.a()) + 1;
            }
            long j4 = jB;
            jA += aVar.a() - aVar.e();
            if (j4 == j3) {
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.c()), Integer.valueOf(aVar.d()));
                }
            } else {
                d.b bVar = new d.b();
                com.liulishuo.filedownloader.download.b bVarA = b.C0483b.a(aVar.e(), aVar.a(), aVar.b(), j4);
                bVar.a(iE);
                bVar.a(Integer.valueOf(aVar.d()));
                bVar.a(this);
                bVar.c(strP);
                bVar.a(z2 ? strB : null);
                bVar.a(this.f17108u);
                bVar.a(this.f17110w);
                bVar.a(bVarA);
                bVar.b(strN);
                d dVarA = bVar.a();
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "enable multiple connection: %s", aVar);
                }
                if (dVarA != null) {
                    this.D.add(dVarA);
                } else {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
            }
            j3 = 0;
        }
        if (jA != this.f17107t.g()) {
            com.liulishuo.filedownloader.h0.d.e(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f17107t.g()), Long.valueOf(jA));
            this.f17107t.b(jA);
        }
        ArrayList arrayList = new ArrayList(this.D.size());
        for (d dVar : this.D) {
            if (this.K) {
                dVar.b();
            } else {
                arrayList.add(Executors.callable(dVar));
            }
        }
        if (this.K) {
            this.f17107t.a((byte) -2);
            return;
        }
        List<Future> listInvokeAll = O.invokeAll(arrayList);
        if (com.liulishuo.filedownloader.h0.d.a) {
            for (Future future : listInvokeAll) {
                com.liulishuo.filedownloader.h0.d.a(this, "finish sub-task for [%d] %B %B", Integer.valueOf(iE), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(long j2, String str) throws IllegalAccessException, IOException {
        com.liulishuo.filedownloader.g0.a aVarC = null;
        if (j2 != -1) {
            try {
                aVarC = com.liulishuo.filedownloader.h0.f.c(this.f17107t.n());
                long length = new File(str).length();
                long j3 = j2 - length;
                long jI = com.liulishuo.filedownloader.h0.f.i(str);
                if (jI >= j3) {
                    if (!com.liulishuo.filedownloader.h0.e.a().f17210f) {
                        aVarC.setLength(j2);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(jI, j3, length);
                }
            } finally {
                if (0 != 0) {
                    aVarC.close();
                }
            }
        }
    }

    @Override // com.liulishuo.filedownloader.download.g
    public void a(d dVar, long j2, long j3) {
        if (this.K) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f17107t.e()));
                return;
            }
            return;
        }
        int i2 = dVar.f17144z;
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f17107t.o()));
        }
        if (!this.F) {
            synchronized (this.D) {
                this.D.remove(dVar);
            }
        } else {
            if (j2 == 0 || j3 == this.f17107t.o()) {
                return;
            }
            com.liulishuo.filedownloader.h0.d.b(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f17107t.o()), Integer.valueOf(this.f17107t.e()));
        }
    }

    @Override // com.liulishuo.filedownloader.download.g
    public void a(Exception exc) {
        if (this.K) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f17107t.e()));
            }
        } else {
            int i2 = this.A;
            this.A = i2 - 1;
            if (i2 < 0) {
                com.liulishuo.filedownloader.h0.d.b(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(this.A), Integer.valueOf(this.f17107t.e()));
            }
            this.f17106s.a(exc, this.A);
        }
    }

    @Override // com.liulishuo.filedownloader.download.g
    public void a() {
        this.f17111x.b(this.f17107t.e(), this.f17107t.g());
    }
}
