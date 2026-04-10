package com.anythink.expressad.videocommon.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12189c = "UnitCacheCtroller";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.videocommon.d.b f12192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, com.anythink.expressad.videocommon.d.b> f12193g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ExecutorService f12197k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f12199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.anythink.expressad.videocommon.e.d f12200n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f12202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.anythink.expressad.d.c f12203q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.anythink.expressad.foundation.d.c> f12190d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12191e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f f12194h = new f() { // from class: com.anythink.expressad.videocommon.b.n.1
        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j2, int i2) {
            if (i2 == 5 || i2 == 4) {
                n.a(n.this);
                n.this.a();
            }
            if (i2 == 2) {
                n.a(n.this);
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, c>> f12195i = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f12198l = com.anythink.expressad.d.a.b.P;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f12201o = 2;
    com.anythink.expressad.d.c a = null;
    com.anythink.expressad.d.c b = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f12196j = com.anythink.core.common.b.n.a().g();

    public n(List<com.anythink.expressad.foundation.d.c> list, ExecutorService executorService, String str, int i2) {
        this.f12202p = 1;
        List<com.anythink.expressad.foundation.d.c> list2 = this.f12190d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f12197k = executorService;
        this.f12199m = str;
        this.f12202p = i2;
        b(this.f12190d);
    }

    static /* synthetic */ boolean a(n nVar) {
        nVar.f12191e = true;
        return true;
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    while (i2 < this.f12195i.size()) {
                        Map<String, c> map = this.f12195i.get(i2);
                        Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            c value = it.next().getValue();
                            if (value != null) {
                                if (jCurrentTimeMillis - value.c() > this.f12198l * 1000 && value.k() == 1) {
                                    value.j();
                                    value.a(this.f12201o);
                                    this.f12195i.remove(map);
                                    i2--;
                                }
                                if (value.k() != 1 && value.k() != 5 && value.k() != 0) {
                                    this.f12195i.remove(map);
                                    i2--;
                                }
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i2 = 0;
                    while (i2 < this.f12195i.size()) {
                        Map<String, c> map = this.f12195i.get(i2);
                        Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            c value = it.next().getValue();
                            if (value != null && value.n() != null && value.b() && value.d()) {
                                value.o();
                                this.f12195i.remove(map);
                                i2--;
                            }
                        }
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                com.anythink.expressad.foundation.h.o.d(f12189c, "cleanDisplayTask ERROR");
            }
        }
    }

    private static boolean g() {
        return true;
    }

    private int h() {
        try {
            if (this.a != null) {
                return this.a.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void d() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    for (Map<String, c> map : this.f12195i) {
                        if (map == null) {
                            return;
                        }
                        Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            c value = it.next().getValue();
                            if (value != null) {
                                value.o();
                            }
                        }
                    }
                    this.f12195i.clear();
                }
            } catch (Throwable unused) {
                com.anythink.expressad.foundation.h.o.d(f12189c, "campaignDownLoadTaskList clean failed");
            }
        }
        List<com.anythink.expressad.foundation.d.c> list = this.f12190d;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f12190d.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.util.List<com.anythink.expressad.foundation.d.c> r13) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.b(java.util.List):void");
    }

    private static synchronized String c(c cVar) {
        if (cVar == null) {
            return "";
        }
        String strS = cVar.n().S();
        try {
            if (cVar.k() == 5) {
                String strE = cVar.e();
                if (!w.a(strE)) {
                    if (new File(strE).exists()) {
                        strS = strE;
                    }
                }
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f12189c, th.getMessage(), th);
        }
        return strS;
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.f12192f = bVar;
    }

    public final void a(String str, com.anythink.expressad.videocommon.d.b bVar) {
        if (this.f12193g == null) {
            this.f12193g = new ConcurrentHashMap<>();
        }
        this.f12193g.put(str, bVar);
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        List<com.anythink.expressad.foundation.d.c> list2 = this.f12190d;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.f12190d);
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        List<com.anythink.expressad.foundation.d.c> list = this.f12190d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        b(this.f12190d);
    }

    public final void c() {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    for (Map<String, c> map : this.f12195i) {
                        if (map != null) {
                            Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                c value = it.next().getValue();
                                if (value != null && value.k() == 1) {
                                    com.anythink.expressad.foundation.h.o.b(f12189c, "暂停所有下载");
                                    value.j();
                                    this.f12195i.remove(map);
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0226 A[Catch: all -> 0x0260, Exception -> 0x0262, TryCatch #1 {Exception -> 0x0262, blocks: (B:5:0x000e, B:6:0x0013, B:8:0x001b, B:9:0x002b, B:11:0x0031, B:13:0x003f, B:16:0x0047, B:17:0x0050, B:19:0x0056, B:22:0x0060, B:24:0x006a, B:26:0x0074, B:28:0x0082, B:32:0x0094, B:35:0x00a9, B:40:0x00b7, B:38:0x00b1, B:41:0x00d7, B:43:0x00e3, B:45:0x00e9, B:46:0x00f1, B:48:0x00fa, B:50:0x0102, B:52:0x0108, B:53:0x0110, B:55:0x0116, B:57:0x011c, B:58:0x0128, B:60:0x012e, B:61:0x013a, B:63:0x0144, B:64:0x0150, B:66:0x016e, B:68:0x0174, B:70:0x018b, B:71:0x0197, B:73:0x019d, B:74:0x01a9, B:78:0x01b3, B:80:0x01be, B:82:0x01cc, B:91:0x01eb, B:93:0x01f1, B:94:0x01f9, B:96:0x01fd, B:98:0x0207, B:100:0x020d, B:101:0x0226, B:103:0x0230, B:105:0x0236, B:106:0x023a, B:107:0x0249), top: B:119:0x000e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0150 A[Catch: all -> 0x0260, Exception -> 0x0262, TryCatch #1 {Exception -> 0x0262, blocks: (B:5:0x000e, B:6:0x0013, B:8:0x001b, B:9:0x002b, B:11:0x0031, B:13:0x003f, B:16:0x0047, B:17:0x0050, B:19:0x0056, B:22:0x0060, B:24:0x006a, B:26:0x0074, B:28:0x0082, B:32:0x0094, B:35:0x00a9, B:40:0x00b7, B:38:0x00b1, B:41:0x00d7, B:43:0x00e3, B:45:0x00e9, B:46:0x00f1, B:48:0x00fa, B:50:0x0102, B:52:0x0108, B:53:0x0110, B:55:0x0116, B:57:0x011c, B:58:0x0128, B:60:0x012e, B:61:0x013a, B:63:0x0144, B:64:0x0150, B:66:0x016e, B:68:0x0174, B:70:0x018b, B:71:0x0197, B:73:0x019d, B:74:0x01a9, B:78:0x01b3, B:80:0x01be, B:82:0x01cc, B:91:0x01eb, B:93:0x01f1, B:94:0x01f9, B:96:0x01fd, B:98:0x0207, B:100:0x020d, B:101:0x0226, B:103:0x0230, B:105:0x0236, B:106:0x023a, B:107:0x0249), top: B:119:0x000e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.expressad.videocommon.b.c> a(boolean r22, java.util.List<com.anythink.expressad.foundation.d.c> r23) {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.a(boolean, java.util.List):java.util.List");
    }

    private int d(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (cVar.w() == 298) {
                if (this.b == null) {
                    com.anythink.expressad.d.b.a();
                    this.b = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.f12199m);
                }
                return this.b.f();
            }
            if (cVar.w() == 42) {
                return h();
            }
            if (this.f12200n == null) {
                this.f12200n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f12199m, false);
            }
            return this.f12200n.v();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f12189c, th.getMessage(), th);
            return 100;
        }
    }

    public n(com.anythink.expressad.foundation.d.c cVar, ExecutorService executorService, String str, int i2) {
        this.f12202p = 1;
        List<com.anythink.expressad.foundation.d.c> list = this.f12190d;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        this.f12197k = executorService;
        this.f12199m = str;
        this.f12202p = i2;
        b(this.f12190d);
    }

    private static boolean c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        try {
            return cVar.J() == 2;
        } catch (Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return -1;
        }
        if (cVar.ao() != -1) {
            int iAo = cVar.ao();
            com.anythink.expressad.foundation.h.o.a(f12189c, "ready_rate(campaign): ".concat(String.valueOf(iAo)));
            return iAo;
        }
        int iD = d(cVar);
        com.anythink.expressad.foundation.h.o.a(f12189c, "ready_rate(reward_unit_setting): ".concat(String.valueOf(iD)));
        return iD;
    }

    private static boolean b(c cVar, int i2) {
        return a(cVar, i2);
    }

    private static boolean b(String str, com.anythink.expressad.foundation.d.c cVar) {
        if (!cVar.H() && !TextUtils.isEmpty(str)) {
            if (cVar.av() == 1 && !c(cVar)) {
                return true;
            }
            if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
                com.anythink.expressad.foundation.h.o.b(f12189c, "Is not check endCard download status : ".concat(String.valueOf(str)));
                return true;
            }
            if (w.b(i.a().c(str))) {
                com.anythink.expressad.foundation.h.o.b(f12189c, "endcard zip 下载完成 return true endcardUrl:".concat(String.valueOf(str)));
                return true;
            }
            if (w.b(j.a.a.b(str))) {
                com.anythink.expressad.foundation.h.o.b(f12189c, "endcard url 源码 下载完成 return true endcardUrl:".concat(String.valueOf(str)));
                return true;
            }
            com.anythink.expressad.foundation.h.o.b(f12189c, "checkEndcardZipOrSourceDownLoad endcardUrl return false endcardUrl:".concat(String.valueOf(str)));
            return false;
        }
        com.anythink.expressad.foundation.h.o.b(f12189c, "Campaign is Mraid, do not need download endcardurl or Campaign load timeout");
        return true;
    }

    private static boolean b(com.anythink.expressad.foundation.d.c cVar, String str) {
        com.anythink.expressad.foundation.h.o.a(f12189c, "check template ".concat(String.valueOf(str)));
        if (cVar.j()) {
            return true;
        }
        if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(1)) {
            com.anythink.expressad.foundation.h.o.b(f12189c, "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && cVar.av() == 0) {
            com.anythink.expressad.foundation.h.o.a(f12189c, "check template 下载情况：" + i.a().c(str));
            if (i.a().c(str) == null) {
                return false;
            }
        }
        return true;
    }

    public final c a(int i2, boolean z2) {
        long j2;
        boolean z3 = z2;
        com.anythink.expressad.foundation.h.o.a(f12189c, "isReady unitID " + this.f12199m + " ad_type " + this.f12202p);
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i3 = 0;
                while (i3 < this.f12195i.size()) {
                    Map<String, c> map = this.f12195i.get(i3);
                    Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        c value = it.next().getValue();
                        if (value != null && value.n() != null) {
                            com.anythink.expressad.foundation.d.c cVarN = value.n();
                            if ((z3 && !cVarN.A()) || (!z3 && cVarN.A())) {
                                com.anythink.expressad.foundation.h.o.b(f12189c, "UnitCache isReady ==== isBidCampaign = " + z3 + " campaign.isBidCampaign() = " + cVarN.A());
                                j2 = jCurrentTimeMillis;
                            } else {
                                String strI = cVarN.I();
                                String strS = cVarN.S();
                                String strE = "";
                                if (cVarN != null && cVarN.M() != null) {
                                    strE = cVarN.M().e();
                                }
                                cVarN.M();
                                if (this.f12202p == 94 || i2 == 287) {
                                    if (!TextUtils.isEmpty(strE) && !strE.contains(com.anythink.expressad.foundation.d.c.f10153d) && !b(cVarN, strE)) {
                                        com.anythink.expressad.foundation.h.o.b(f12189c, "UnitCache isReady ====  templateZipDownload check false continue");
                                    } else if (b(strI, cVarN)) {
                                        if (value.b()) {
                                            value.o();
                                            com.anythink.expressad.foundation.h.o.b(f12189c, "isready endcard下载完 但是offer展示过 continue");
                                        } else {
                                            if (w.a(strS)) {
                                                com.anythink.expressad.foundation.h.o.b(f12189c, "endcard为基准 endcard和图片下载完成 videourl为空不用下载 return task");
                                                return value;
                                            }
                                            if (a(value, b(cVarN))) {
                                                com.anythink.expressad.foundation.h.o.b(f12189c, "endcard为基准 endcard 图片 和 videourl 下载完成 return task");
                                                return value;
                                            }
                                        }
                                    }
                                    j2 = jCurrentTimeMillis;
                                }
                                boolean zIsEmpty = TextUtils.isEmpty(value.m());
                                int iK = value.k();
                                com.anythink.expressad.foundation.h.o.a(f12189c, "isready unit state:".concat(String.valueOf(iK)));
                                if (this.f12202p == 298 && a(value, b(cVarN))) {
                                    return value;
                                }
                                if (iK == 5) {
                                    if (value.b()) {
                                        value.o();
                                        this.f12195i.remove(map);
                                        i3--;
                                        com.anythink.expressad.foundation.h.o.b(f12189c, "isready state == DownLoadConstant.DOWNLOAD_DONE 但是offer展示过 continue");
                                        z3 = z2;
                                    } else if (!zIsEmpty) {
                                        value.l();
                                        if (this.f12202p == 95) {
                                            com.anythink.expressad.foundation.h.o.b(f12189c, "isready ==========done but isEffectivePath:" + zIsEmpty + " is feed" + this.f12202p);
                                            return value;
                                        }
                                        com.anythink.expressad.foundation.h.o.b(f12189c, "isready !isEffectivePath continue");
                                        j2 = jCurrentTimeMillis;
                                    } else {
                                        if (a(strI, cVarN)) {
                                            com.anythink.expressad.foundation.h.o.b(f12189c, "isready videourl为基准 state＝done endcard 图片 和 videourl 下载完成 return task");
                                            return value;
                                        }
                                        com.anythink.expressad.foundation.h.o.b(f12189c, "isready done but continue");
                                        return null;
                                    }
                                } else {
                                    long jC = value.c();
                                    if (value.k() == 1) {
                                        j2 = jCurrentTimeMillis;
                                        if (jCurrentTimeMillis - jC > this.f12198l * 1000) {
                                            value.j();
                                            this.f12195i.remove(map);
                                            i3--;
                                            if (this.f12202p == 1 || this.f12202p == 94) {
                                                com.anythink.expressad.foundation.h.o.b(f12189c, "isready download !timeout continue");
                                            }
                                        }
                                    } else {
                                        j2 = jCurrentTimeMillis;
                                    }
                                    if (this.f12202p == 95) {
                                        if (value.b()) {
                                            value.o();
                                            this.f12195i.remove(map);
                                            i3--;
                                        } else {
                                            com.anythink.expressad.foundation.h.o.b(f12189c, "==========isready ad_type is :" + this.f12202p);
                                            return value;
                                        }
                                    } else if (iK == 4 || iK == 2) {
                                        this.f12195i.remove(map);
                                        i3--;
                                        com.anythink.expressad.foundation.h.o.b(f12189c, "isready stop continue");
                                    } else if (iK == 1) {
                                        if (value.b()) {
                                            com.anythink.expressad.foundation.h.o.b(f12189c, "isready run 已经被展示过 continue");
                                        } else {
                                            if (!com.anythink.expressad.a.f7972p && a(value, b(cVarN)) && a(strI, cVarN)) {
                                                com.anythink.expressad.foundation.h.o.b(f12189c, "isready  IS_DOWANLOAD_FINSH_PLAY is :" + com.anythink.expressad.a.f7972p);
                                                return value;
                                            }
                                            return this.f12202p != 94 ? value : value;
                                        }
                                    } else if ((this.f12202p != 94 || this.f12202p == 287) && a(value, b(cVarN)) && a(strI, cVarN)) {
                                    }
                                }
                            }
                        } else {
                            j2 = jCurrentTimeMillis;
                            com.anythink.expressad.foundation.h.o.b(f12189c, "UnitCache isReady ==== task 或者 campaign为空 continue");
                        }
                        z3 = z2;
                        jCurrentTimeMillis = j2;
                    }
                    i3++;
                    z3 = z2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public final c b(int i2, boolean z2) {
        try {
            return a(i2, z2);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f12189c, th.getMessage(), th);
            return null;
        }
    }

    private static synchronized String b(c cVar) {
        return c(cVar);
    }

    public final void b() {
        int iK;
        try {
            if (this.f12195i != null) {
                synchronized (this.f12195i) {
                    for (Map<String, c> map : this.f12195i) {
                        if (map != null) {
                            Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                c value = it.next().getValue();
                                if (value != null && (iK = value.k()) != 1 && iK != 5) {
                                    if (com.anythink.expressad.foundation.h.k.a() != 9 && this.f12201o == 2) {
                                        return;
                                    }
                                    if (iK == 2 || iK == 0) {
                                        value.h();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        try {
            synchronized (this.f12195i) {
                if (!TextUtils.isEmpty(str) && this.f12195i != null && this.f12195i.size() > 0) {
                    for (Map<String, c> map : this.f12195i) {
                        if (map != null) {
                            for (Map.Entry<String, c> entry : map.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.f12195i.remove(map);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static boolean a(c cVar, int i2) {
        long jP = cVar.p();
        long jF = cVar.f();
        if (TextUtils.isEmpty(cVar.a())) {
            com.anythink.expressad.foundation.h.o.a(f12189c, "checkVideoDownload video done return true");
            return true;
        }
        if (i2 == 0) {
            if (cVar.n() == null || TextUtils.isEmpty(cVar.n().S())) {
                return false;
            }
            a(cVar);
            return true;
        }
        if (jF <= 0 || jP * 100 < jF * ((long) i2)) {
            return false;
        }
        a(cVar);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0011 A[Catch: all -> 0x000b, TRY_ENTER, TryCatch #0 {, blocks: (B:6:0x0006, B:13:0x0011, B:15:0x0019, B:17:0x0021), top: B:22:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void a(com.anythink.expressad.videocommon.b.c r4) {
        /*
            java.lang.Class<com.anythink.expressad.videocommon.b.n> r0 = com.anythink.expressad.videocommon.b.n.class
            monitor-enter(r0)
            r1 = 0
            if (r4 == 0) goto Ld
            com.anythink.expressad.foundation.d.c r1 = r4.n()     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r4 = move-exception
            goto L2a
        Ld:
            if (r1 != 0) goto L11
            monitor-exit(r0)
            return
        L11:
            int r2 = r1.w()     // Catch: java.lang.Throwable -> Lb
            r3 = 94
            if (r2 == r3) goto L21
            int r1 = r1.w()     // Catch: java.lang.Throwable -> Lb
            r2 = 287(0x11f, float:4.02E-43)
            if (r1 != r2) goto L28
        L21:
            java.lang.String r1 = c(r4)     // Catch: java.lang.Throwable -> Lb
            r4.a(r1)     // Catch: java.lang.Throwable -> Lb
        L28:
            monitor-exit(r0)
            return
        L2a:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.a(com.anythink.expressad.videocommon.b.c):void");
    }

    private static boolean a(String str, com.anythink.expressad.foundation.d.c cVar) {
        try {
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f12189c, th.getMessage(), th);
        }
        if (cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(2)) {
            com.anythink.expressad.foundation.h.o.b(f12189c, "Is not check endCard download status : ".concat(String.valueOf(str)));
            return true;
        }
        if (cVar.j() && !t.f(str)) {
            return true;
        }
        if (w.a(str)) {
            com.anythink.expressad.foundation.h.o.b(f12189c, "checkEndcardDownload endcardUrl is null return true");
            return true;
        }
        if (b(str, cVar)) {
            com.anythink.expressad.foundation.h.o.b(f12189c, "checkEndcardDownload endcardUrl done return true");
            return true;
        }
        com.anythink.expressad.foundation.h.o.b(f12189c, "checkEndcardDownload endcardUrl return false");
        return false;
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, String str) {
        if (!TextUtils.isEmpty(cVar.ar())) {
            return true;
        }
        com.anythink.expressad.foundation.h.o.a(f12189c, "check template pre load ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        boolean zD = l.a().d(this.f12199m + "_" + cVar.Z() + "_" + str);
        com.anythink.expressad.foundation.h.o.a(f12189c, "check template 预加载情况：".concat(String.valueOf(zD)));
        return zD;
    }

    public final c a(String str) {
        CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList = this.f12195i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                for (Map<String, c> map : this.f12195i) {
                    if (map != null && map.containsKey(str)) {
                        return map.get(str);
                    }
                }
            } catch (Throwable unused) {
                com.anythink.expressad.foundation.h.o.d(f12189c, "failed to get campaignTast by cid");
            }
            return null;
        }
    }

    private static boolean a(CopyOnWriteArrayList<Map<String, c>> copyOnWriteArrayList) {
        try {
            for (Map<String, c> map : copyOnWriteArrayList) {
                if (map != null) {
                    Iterator<Map.Entry<String, c>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue().k() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc A[Catch: all -> 0x01c1, TryCatch #0 {, blocks: (B:5:0x000a, B:7:0x0013, B:8:0x0015, B:9:0x001b, B:11:0x0021, B:13:0x0029, B:14:0x0031, B:16:0x0037, B:18:0x0045, B:20:0x004b, B:22:0x0051, B:23:0x0053, B:25:0x006b, B:27:0x006f, B:28:0x0077, B:29:0x007b, B:31:0x0088, B:33:0x008c, B:36:0x0091, B:38:0x0095, B:40:0x0099, B:41:0x00ac, B:43:0x00b0, B:45:0x00b8, B:47:0x00bc, B:49:0x00c0, B:50:0x00d3, B:52:0x00d7, B:65:0x010b, B:67:0x0110, B:69:0x0116, B:71:0x0146, B:73:0x014a, B:75:0x0150, B:77:0x0154, B:78:0x015d, B:80:0x0161, B:82:0x0169, B:85:0x0179, B:93:0x018b, B:95:0x018f, B:97:0x019a, B:99:0x019e, B:101:0x01a4, B:102:0x01a9, B:104:0x01ad, B:106:0x01b3, B:109:0x01ba, B:108:0x01b7, B:54:0x00e0, B:56:0x00e4, B:60:0x00f9, B:61:0x00ff, B:63:0x0103, B:110:0x01bf), top: B:116:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.n.a():void");
    }
}
