package com.duokan.reader.common.cache;

import com.duokan.reader.common.cache.ListCache;
import com.duokan.reader.common.cache.f;
import com.duokan.reader.common.cache.h;
import com.yuewen.cb0;

/* JADX INFO: loaded from: classes2.dex */
public class g<TItem, TItemJson> implements ListCache.l<TItem, f.a<TItem>, f.b<TItem>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f4007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListCache.d<TItem, TItemJson> f4008b;

    public g(ListCache.d<TItem, TItemJson> dVar) {
        this(dVar, cb0.Q());
    }

    @Override // com.duokan.reader.common.cache.ListCache.l
    public void b(String str) {
        this.f4007a.m(str);
    }

    @Override // com.duokan.reader.common.cache.ListCache.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f<TItem> a(String str, f.b<TItem> bVar, int i) {
        boolean z;
        h.e[] eVarArrA = bVar != null ? bVar.a() : null;
        if (eVarArrA == null) {
            eVarArrA = new h.e[0];
        }
        ListCache.o[] oVarArrD = d();
        if (oVarArrD == null) {
            oVarArrD = new ListCache.o[0];
        }
        for (h.e eVar : eVarArrA) {
            if (!eVar.f4018a.equals(h.c.f4015a) && !eVar.f4018a.equalsIgnoreCase(h.c.d)) {
                int length = oVarArrD.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    if (eVar.f4018a.equals(oVarArrD[i2].f3993a)) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.f4007a.e(str, oVarArrD, eVarArrA);
        return new f<>(str, bVar, i, this.f4007a);
    }

    public final ListCache.o[] d() {
        ListCache.d<TItem, TItemJson> dVar = this.f4008b;
        if (dVar == null) {
            return null;
        }
        return dVar.h();
    }

    public g(ListCache.d<TItem, TItemJson> dVar, h hVar) {
        this.f4008b = dVar;
        this.f4007a = hVar;
    }
}
