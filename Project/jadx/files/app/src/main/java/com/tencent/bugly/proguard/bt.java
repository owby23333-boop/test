package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bt extends m implements Cloneable {
    public boolean a = true;
    public boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18731c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18732d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18733e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bs f18734f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f18735g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18736h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18737i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18738j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18739k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18740l = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f18730o = !bt.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static bs f18728m = new bs();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static Map<String, String> f18729n = new HashMap();

    static {
        f18729n.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        lVar.a(this.f18731c, 2);
        String str = this.f18732d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f18733e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bs bsVar = this.f18734f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.f18735g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f18736h, 7);
        String str3 = this.f18737i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f18738j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f18739k, 10);
        lVar.a(this.f18740l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f18730o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        return n.a(this.a, btVar.a) && n.a(this.b, btVar.b) && n.a(this.f18731c, btVar.f18731c) && n.a(this.f18732d, btVar.f18732d) && n.a(this.f18733e, btVar.f18733e) && n.a(this.f18734f, btVar.f18734f) && n.a(this.f18735g, btVar.f18735g) && n.a(this.f18736h, btVar.f18736h) && n.a(this.f18737i, btVar.f18737i) && n.a(this.f18738j, btVar.f18738j) && n.a(this.f18739k, btVar.f18739k) && n.a(this.f18740l, btVar.f18740l);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        this.b = kVar.a(1, true);
        this.f18731c = kVar.a(2, true);
        this.f18732d = kVar.b(3, false);
        this.f18733e = kVar.b(4, false);
        this.f18734f = (bs) kVar.a((m) f18728m, 5, false);
        this.f18735g = (Map) kVar.a(f18729n, 6, false);
        this.f18736h = kVar.a(this.f18736h, 7, false);
        this.f18737i = kVar.b(8, false);
        this.f18738j = kVar.b(9, false);
        this.f18739k = kVar.a(this.f18739k, 10, false);
        this.f18740l = kVar.a(this.f18740l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "enable");
        iVar.a(this.b, "enableUserInfo");
        iVar.a(this.f18731c, "enableQuery");
        iVar.a(this.f18732d, "url");
        iVar.a(this.f18733e, "expUrl");
        iVar.a((m) this.f18734f, "security");
        iVar.a((Map) this.f18735g, "valueMap");
        iVar.a(this.f18736h, "strategylastUpdateTime");
        iVar.a(this.f18737i, "httpsUrl");
        iVar.a(this.f18738j, "httpsExpUrl");
        iVar.a(this.f18739k, "eventRecordCount");
        iVar.a(this.f18740l, "eventTimeInterval");
    }
}
