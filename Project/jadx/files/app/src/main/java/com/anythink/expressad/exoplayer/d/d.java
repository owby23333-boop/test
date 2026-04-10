package com.anythink.expressad.exoplayer.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.expressad.exoplayer.d.b;
import com.anythink.expressad.exoplayer.d.c;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.i;
import com.anythink.expressad.exoplayer.d.j;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(18)
public final class d<T extends i> implements b.c<T>, g<T> {
    public static final String a = "PRCustomData";
    public static final int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8793c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8794d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8795e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8796f = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8797h = "DefaultDrmSessionMgr";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile d<T>.c f8798g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final UUID f8799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final j<T> f8800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final n f8801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap<String, String> f8802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final c.a f8803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f8804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f8805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List<com.anythink.expressad.exoplayer.d.b<T>> f8806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List<com.anythink.expressad.exoplayer.d.b<T>> f8807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Looper f8808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte[] f8810t;

    @Deprecated
    public interface a extends com.anythink.expressad.exoplayer.d.c {
    }

    private class b implements j.f<T> {
        private b() {
        }

        @Override // com.anythink.expressad.exoplayer.d.j.f
        public final void a(byte[] bArr, int i2) {
            if (d.this.f8809s == 0) {
                d.this.f8798g.obtainMessage(i2, bArr).sendToTarget();
            }
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.anythink.expressad.exoplayer.d.b bVar : d.this.f8806p) {
                if (bVar.b(bArr)) {
                    bVar.a(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.d.d$d, reason: collision with other inner class name */
    public static final class C0186d extends Exception {
        /* synthetic */ C0186d(UUID uuid, byte b) {
            this(uuid);
        }

        private C0186d(UUID uuid) {
            super("Media does not support uuid: ".concat(String.valueOf(uuid)));
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this(uuid, jVar, nVar, map);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private static d<k> a(n nVar, HashMap<String, String> map) {
        return a(com.anythink.expressad.exoplayer.b.bk, nVar, map);
    }

    private byte[] b(String str) {
        return this.f8800j.b(str);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map) {
        this(uuid, (j) jVar, nVar, map, false, 3);
    }

    private static d<k> a(n nVar, String str) {
        HashMap map;
        if (TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new HashMap();
            map.put(a, str);
        }
        return a(com.anythink.expressad.exoplayer.b.bl, nVar, (HashMap<String, String>) map);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z2) {
        this(uuid, jVar, nVar, map, z2);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, boolean z2) {
        this(uuid, jVar, nVar, map, z2, 3);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z2, int i2) {
        this(uuid, jVar, nVar, map, z2, i2);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    @Deprecated
    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> map, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        d<k> dVarA = a(uuid, nVar, map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, boolean z2, int i2) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        com.anythink.expressad.exoplayer.k.a.a(jVar);
        com.anythink.expressad.exoplayer.k.a.a(!com.anythink.expressad.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f8799i = uuid;
        this.f8800j = jVar;
        this.f8801k = nVar;
        this.f8802l = map;
        this.f8803m = new c.a();
        this.f8804n = z2;
        this.f8805o = i2;
        byte b2 = 0;
        this.f8809s = 0;
        this.f8806p = new ArrayList();
        this.f8807q = new ArrayList();
        if (z2) {
            jVar.a("sessionSharing", "enable");
        }
        jVar.a(new b(this, b2));
    }

    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> map) {
        return new d<>(uuid, (j) l.a(uuid), nVar, map, false, 3);
    }

    public final void a(Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this.f8803m.a(handler, cVar);
    }

    private void a(com.anythink.expressad.exoplayer.d.c cVar) {
        this.f8803m.a(cVar);
    }

    private String a(String str) {
        return this.f8800j.a(str);
    }

    private void a(String str, String str2) {
        this.f8800j.a(str, str2);
    }

    private void a(String str, byte[] bArr) {
        this.f8800j.a(str, bArr);
    }

    private void a(int i2, byte[] bArr) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8806p.isEmpty());
        if (i2 == 1 || i2 == 3) {
            com.anythink.expressad.exoplayer.k.a.a(bArr);
        }
        this.f8809s = i2;
        this.f8810t = bArr;
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final boolean a(@NonNull com.anythink.expressad.exoplayer.d.e eVar) {
        if (this.f8810t != null) {
            return true;
        }
        if (a(eVar, this.f8799i, true) == null) {
            if (eVar.b != 1 || !eVar.a(0).a(com.anythink.expressad.exoplayer.b.bi)) {
                return false;
            }
            String str = "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f8799i;
        }
        String str2 = eVar.a;
        if (str2 == null || com.anythink.expressad.exoplayer.b.bd.equals(str2)) {
            return true;
        }
        return !(com.anythink.expressad.exoplayer.b.be.equals(str2) || com.anythink.expressad.exoplayer.b.bg.equals(str2) || com.anythink.expressad.exoplayer.b.bf.equals(str2)) || af.a >= 25;
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final f<T> a(Looper looper, com.anythink.expressad.exoplayer.d.e eVar) {
        e.a aVar;
        com.anythink.expressad.exoplayer.d.b<T> bVar;
        Looper looper2 = this.f8808r;
        byte b2 = 0;
        com.anythink.expressad.exoplayer.k.a.b(looper2 == null || looper2 == looper);
        if (this.f8806p.isEmpty()) {
            this.f8808r = looper;
            if (this.f8798g == null) {
                this.f8798g = new c(looper);
            }
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar2 = null;
        if (this.f8810t == null) {
            e.a aVarA = a(eVar, this.f8799i, false);
            if (aVarA == null) {
                C0186d c0186d = new C0186d(this.f8799i, b2);
                this.f8803m.a(c0186d);
                return new h(new f.a(c0186d));
            }
            aVar = aVarA;
        } else {
            aVar = null;
        }
        if (!this.f8804n) {
            if (!this.f8806p.isEmpty()) {
                bVar2 = this.f8806p.get(0);
            }
        } else {
            byte[] bArr = aVar != null ? aVar.f8813c : null;
            Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.f8806p.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.exoplayer.d.b<T> next = it.next();
                if (next.a(bArr)) {
                    bVar2 = next;
                    break;
                }
            }
        }
        if (bVar2 == null) {
            bVar = new com.anythink.expressad.exoplayer.d.b<>(this.f8799i, this.f8800j, this, aVar, this.f8809s, this.f8810t, this.f8802l, this.f8801k, looper, this.f8803m, this.f8805o);
            this.f8806p.add(bVar);
        } else {
            bVar = bVar2;
        }
        bVar.a();
        return bVar;
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final void a(f<T> fVar) {
        if (fVar instanceof h) {
            return;
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar = (com.anythink.expressad.exoplayer.d.b) fVar;
        if (bVar.b()) {
            this.f8806p.remove(bVar);
            if (this.f8807q.size() > 1 && this.f8807q.get(0) == bVar) {
                this.f8807q.get(1).c();
            }
            this.f8807q.remove(bVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(com.anythink.expressad.exoplayer.d.b<T> bVar) {
        this.f8807q.add(bVar);
        if (this.f8807q.size() == 1) {
            bVar.c();
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a() {
        Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.f8807q.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.f8807q.clear();
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(Exception exc) {
        Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.f8807q.iterator();
        while (it.hasNext()) {
            it.next().a(exc);
        }
        this.f8807q.clear();
    }

    private static e.a a(com.anythink.expressad.exoplayer.d.e eVar, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(eVar.b);
        int i2 = 0;
        while (true) {
            boolean z3 = true;
            if (i2 >= eVar.b) {
                break;
            }
            e.a aVarA = eVar.a(i2);
            if (!aVarA.a(uuid) && (!com.anythink.expressad.exoplayer.b.bj.equals(uuid) || !aVarA.a(com.anythink.expressad.exoplayer.b.bi))) {
                z3 = false;
            }
            if (z3 && (aVarA.f8813c != null || z2)) {
                arrayList.add(aVarA);
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid)) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                e.a aVar = (e.a) arrayList.get(i3);
                int iB = aVar.a() ? com.anythink.expressad.exoplayer.e.a.h.b(aVar.f8813c) : -1;
                if (af.a < 23 && iB == 0) {
                    return aVar;
                }
                if (af.a >= 23 && iB == 1) {
                    return aVar;
                }
            }
        }
        return (e.a) arrayList.get(0);
    }

    @Deprecated
    private static d<k> a(n nVar, HashMap<String, String> map, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        d<k> dVarA = a(com.anythink.expressad.exoplayer.b.bk, nVar, map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }

    @Deprecated
    private static d<k> a(n nVar, String str, Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        HashMap map;
        if (TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new HashMap();
            map.put(a, str);
        }
        d<k> dVarA = a(com.anythink.expressad.exoplayer.b.bl, nVar, (HashMap<String, String>) map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }
}
