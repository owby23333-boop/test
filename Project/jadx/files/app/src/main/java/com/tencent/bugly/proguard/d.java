package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class d extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f18756e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f18758g = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    k f18757f = new k();

    private void c(String str, Object obj) {
        this.f18758g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f18756e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t2) {
        if (this.f18756e == null) {
            super.a(str, t2);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t2 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t2 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f18753c);
        lVar.a(t2, 0);
        this.f18756e.put(str, n.a(lVar.a));
    }

    public final <T> T b(String str, T t2) throws b {
        HashMap<String, byte[]> map = this.f18756e;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f18758g.containsKey(str)) {
                return (T) this.f18758g.get(str);
            }
            try {
                this.f18757f.a(this.f18756e.get(str));
                this.f18757f.a(this.f18753c);
                T t3 = (T) this.f18757f.a((Object) t2, 0, true);
                if (t3 != null) {
                    c(str, t3);
                }
                return t3;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
        if (!this.a.containsKey(str)) {
            return null;
        }
        if (this.f18758g.containsKey(str)) {
            return (T) this.f18758g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f18757f.a(value);
            this.f18757f.a(this.f18753c);
            T t4 = (T) this.f18757f.a((Object) t2, 0, true);
            c(str, t4);
            return t4;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f18756e != null) {
            l lVar = new l(0);
            lVar.a(this.f18753c);
            lVar.a((Map) this.f18756e, 0);
            return n.a(lVar.a);
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f18757f.a(bArr);
            this.f18757f.a(this.f18753c);
            HashMap map = new HashMap(1);
            map.put("", new byte[0]);
            this.f18756e = this.f18757f.a((Map) map, 0, false);
        }
    }
}
