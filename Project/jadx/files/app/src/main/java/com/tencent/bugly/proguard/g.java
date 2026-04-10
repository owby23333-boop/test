package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f18770g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f18772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f18773j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f18765m = !g.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static byte[] f18763k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static Map<String, String> f18764l = null;
    public short a = 0;
    public byte b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18766c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18767d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18768e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18769f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18771h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 1);
        lVar.a(this.b, 2);
        lVar.a(this.f18766c, 3);
        lVar.a(this.f18767d, 4);
        lVar.a(this.f18768e, 5);
        lVar.a(this.f18769f, 6);
        lVar.a(this.f18770g, 7);
        lVar.a(this.f18771h, 8);
        lVar.a((Map) this.f18772i, 9);
        lVar.a((Map) this.f18773j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f18765m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.a) && n.a(1, (int) gVar.b) && n.a(1, gVar.f18766c) && n.a(1, gVar.f18767d) && n.a((Object) 1, (Object) gVar.f18768e) && n.a((Object) 1, (Object) gVar.f18769f) && n.a((Object) 1, (Object) gVar.f18770g) && n.a(1, gVar.f18771h) && n.a((Object) 1, (Object) gVar.f18772i) && n.a((Object) 1, (Object) gVar.f18773j);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        try {
            this.a = kVar.a(this.a, 1, true);
            this.b = kVar.a(this.b, 2, true);
            this.f18766c = kVar.a(this.f18766c, 3, true);
            this.f18767d = kVar.a(this.f18767d, 4, true);
            this.f18768e = kVar.b(5, true);
            this.f18769f = kVar.b(6, true);
            if (f18763k == null) {
                f18763k = new byte[]{0};
            }
            this.f18770g = kVar.c(7, true);
            this.f18771h = kVar.a(this.f18771h, 8, true);
            if (f18764l == null) {
                HashMap map = new HashMap();
                f18764l = map;
                map.put("", "");
            }
            this.f18772i = (Map) kVar.a(f18764l, 9, true);
            if (f18764l == null) {
                HashMap map2 = new HashMap();
                f18764l = map2;
                map2.put("", "");
            }
            this.f18773j = (Map) kVar.a(f18764l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f18770g));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.a, "iVersion");
        iVar.a(this.b, "cPacketType");
        iVar.a(this.f18766c, "iMessageType");
        iVar.a(this.f18767d, "iRequestId");
        iVar.a(this.f18768e, "sServantName");
        iVar.a(this.f18769f, "sFuncName");
        iVar.a(this.f18770g, "sBuffer");
        iVar.a(this.f18771h, "iTimeout");
        iVar.a((Map) this.f18772i, "context");
        iVar.a((Map) this.f18773j, "status");
    }
}
