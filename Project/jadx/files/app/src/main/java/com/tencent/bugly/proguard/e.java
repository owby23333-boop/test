package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static HashMap<String, byte[]> f18759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f18760i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected g f18761g = new g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18762j = 0;

    public e() {
        this.f18761g.a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final <T> void a(String str, T t2) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
        }
        super.a(str, t2);
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.f18761g.a = (short) 3;
    }

    public final void c(String str) {
        this.f18761g.f18769f = str;
    }

    public final void c() {
        this.f18761g.f18767d = 1;
    }

    public final void b(String str) {
        this.f18761g.f18768e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final byte[] a() {
        g gVar = this.f18761g;
        if (gVar.a == 2) {
            if (!gVar.f18768e.equals("")) {
                if (this.f18761g.f18769f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f18768e == null) {
                gVar.f18768e = "";
            }
            g gVar2 = this.f18761g;
            if (gVar2.f18769f == null) {
                gVar2.f18769f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f18753c);
        if (this.f18761g.a == 2) {
            lVar.a((Map) this.a, 0);
        } else {
            lVar.a((Map) ((d) this).f18756e, 0);
        }
        this.f18761g.f18770g = n.a(lVar.a);
        l lVar2 = new l(0);
        lVar2.a(this.f18753c);
        this.f18761g.a(lVar2);
        byte[] bArrA = n.a(lVar2.a);
        int length = bArrA.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.f18753c);
                this.f18761g.a(kVar);
                if (this.f18761g.a == 3) {
                    k kVar2 = new k(this.f18761g.f18770g);
                    kVar2.a(this.f18753c);
                    if (f18759h == null) {
                        HashMap<String, byte[]> map = new HashMap<>();
                        f18759h = map;
                        map.put("", new byte[0]);
                    }
                    ((d) this).f18756e = kVar2.a((Map) f18759h, 0, false);
                    return;
                }
                k kVar3 = new k(this.f18761g.f18770g);
                kVar3.a(this.f18753c);
                if (f18760i == null) {
                    f18760i = new HashMap<>();
                    HashMap<String, byte[]> map2 = new HashMap<>();
                    map2.put("", new byte[0]);
                    f18760i.put("", map2);
                }
                this.a = kVar3.a((Map) f18760i, 0, false);
                this.b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
