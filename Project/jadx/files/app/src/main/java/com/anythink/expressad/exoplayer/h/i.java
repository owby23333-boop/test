package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.aa;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends com.anythink.expressad.exoplayer.h.f<e> implements x.b {
    private static final int a = 0;
    private static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9321c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9322d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9323e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9324f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9325g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<e> f9326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<e> f9327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e f9328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<r, e> f9329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<d> f9330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f9331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ae.b f9332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.h f9333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private aa f9335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9337s;

    private static final class a extends com.anythink.expressad.exoplayer.h.a {
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f9339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f9340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.ae[] f9341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Object[] f9342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final HashMap<Object, Integer> f9343h;

        public a(Collection<e> collection, int i2, int i3, aa aaVar, boolean z2) {
            super(z2, aaVar);
            this.b = i2;
            this.f9338c = i3;
            int size = collection.size();
            this.f9339d = new int[size];
            this.f9340e = new int[size];
            this.f9341f = new com.anythink.expressad.exoplayer.ae[size];
            this.f9342g = new Object[size];
            this.f9343h = new HashMap<>();
            int i4 = 0;
            for (e eVar : collection) {
                this.f9341f[i4] = eVar.f9348c;
                this.f9339d[i4] = eVar.f9351f;
                this.f9340e[i4] = eVar.f9350e;
                Object[] objArr = this.f9342g;
                objArr[i4] = eVar.b;
                this.f9343h.put(objArr[i4], Integer.valueOf(i4));
                i4++;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int a(int i2) {
            return com.anythink.expressad.exoplayer.k.af.a(this.f9339d, i2 + 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(int i2) {
            return com.anythink.expressad.exoplayer.k.af.a(this.f9340e, i2 + 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final com.anythink.expressad.exoplayer.ae c(int i2) {
            return this.f9341f[i2];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int d(int i2) {
            return this.f9339d[i2];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int e(int i2) {
            return this.f9340e[i2];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final Object f(int i2) {
            return this.f9342g[i2];
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(Object obj) {
            Integer num = this.f9343h.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.f9338c;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.b;
        }
    }

    private static final class b extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Object f9344c = new Object();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ae.a f9345d = new ae.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final c f9346e = new c(0);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f9347f;

        public b() {
            this(f9346e, null);
        }

        public final b a(com.anythink.expressad.exoplayer.ae aeVar) {
            return new b(aeVar, (this.f9347f != null || aeVar.c() <= 0) ? this.f9347f : aeVar.a(0, f9345d, true).b);
        }

        public final com.anythink.expressad.exoplayer.ae d() {
            return this.b;
        }

        private b(com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
            super(aeVar);
            this.f9347f = obj;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i2, ae.a aVar, boolean z2) {
            this.b.a(i2, aVar, z2);
            if (com.anythink.expressad.exoplayer.k.af.a(aVar.b, this.f9347f)) {
                aVar.b = f9344c;
            }
            return aVar;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(Object obj) {
            com.anythink.expressad.exoplayer.ae aeVar = this.b;
            if (f9344c.equals(obj)) {
                obj = this.f9347f;
            }
            return aeVar.a(obj);
        }
    }

    private static final class c extends com.anythink.expressad.exoplayer.ae {
        private c() {
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int a(Object obj) {
            return obj == null ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final ae.b a(int i2, ae.b bVar, boolean z2, long j2) {
            return bVar.a(null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, false, true, j2 > 0 ? com.anythink.expressad.exoplayer.b.b : 0L, com.anythink.expressad.exoplayer.b.b, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return 1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return 1;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i2, ae.a aVar, boolean z2) {
            return aVar.a(null, null, com.anythink.expressad.exoplayer.b.b, 0L);
        }
    }

    private static final class d {
        public final Handler a;
        public final Runnable b;

        public d(Runnable runnable) {
            this.b = runnable;
            this.a = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        }

        private void a() {
            this.a.post(this.b);
        }
    }

    private static final class f<T> {
        public final int a;
        public final T b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final d f9355c;

        public f(int i2, T t2, @Nullable Runnable runnable) {
            this.a = i2;
            this.f9355c = runnable != null ? new d(runnable) : null;
            this.b = t2;
        }
    }

    public i() {
        this(false, (aa) new aa.a());
    }

    private s b(int i2) {
        return this.f9326h.get(i2).a;
    }

    private void c(int i2) {
        e eVarRemove = this.f9327i.remove(i2);
        b bVar = eVarRemove.f9348c;
        a(i2, -1, -bVar.b(), -bVar.c());
        eVarRemove.f9353h = true;
        if (eVarRemove.f9354i.isEmpty()) {
            a(eVarRemove);
        }
    }

    private int d() {
        return this.f9326h.size();
    }

    private void e() {
        this.f9334p = false;
        List listEmptyList = this.f9330l.isEmpty() ? Collections.emptyList() : new ArrayList(this.f9330l);
        this.f9330l.clear();
        a(new a(this.f9327i, this.f9336r, this.f9337s, this.f9335q, this.f9331m), (Object) null);
        if (listEmptyList.isEmpty()) {
            return;
        }
        this.f9333o.a((x.b) this).a(6).a(listEmptyList).i();
    }

    private void f() {
        for (int size = this.f9327i.size() - 1; size >= 0; size--) {
            c(size);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ int a(e eVar, int i2) {
        return i2 + eVar.f9350e;
    }

    private i(boolean z2) {
        this(z2, new aa.a());
    }

    private void b(int i2, Collection<e> collection) {
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            a(i2, it.next());
            i2++;
        }
    }

    private int d(int i2) {
        e eVar = this.f9328j;
        eVar.f9351f = i2;
        int iBinarySearch = Collections.binarySearch(this.f9327i, eVar);
        if (iBinarySearch < 0) {
            return (-iBinarySearch) - 2;
        }
        while (iBinarySearch < this.f9327i.size() - 1) {
            int i3 = iBinarySearch + 1;
            if (this.f9327i.get(i3).f9351f != i2) {
                break;
            }
            iBinarySearch = i3;
        }
        return iBinarySearch;
    }

    private i(boolean z2, aa aaVar) {
        this(z2, aaVar, new s[0]);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    @Nullable
    protected final /* synthetic */ s.a a(e eVar, s.a aVar) {
        e eVar2 = eVar;
        for (int i2 = 0; i2 < eVar2.f9354i.size(); i2++) {
            if (eVar2.f9354i.get(i2).b.f9419d == aVar.f9419d) {
                return aVar.a(aVar.a + eVar2.f9351f);
            }
        }
        return null;
    }

    private i(s... sVarArr) {
        this(sVarArr, (byte) 0);
    }

    private void b(e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar != null) {
            b bVar = eVar.f9348c;
            if (bVar.d() == aeVar) {
                return;
            }
            int iB = aeVar.b() - bVar.b();
            int iC = aeVar.c() - bVar.c();
            if (iB != 0 || iC != 0) {
                a(eVar.f9349d + 1, 0, iB, iC);
            }
            eVar.f9348c = bVar.a(aeVar);
            if (!eVar.f9352g && !aeVar.a()) {
                aeVar.a(0, this.f9332n, false);
                ae.b bVar2 = this.f9332n;
                long j2 = bVar2.f8480j + bVar2.f8478h;
                for (int i2 = 0; i2 < eVar.f9354i.size(); i2++) {
                    l lVar = eVar.f9354i.get(i2);
                    lVar.d(j2);
                    lVar.f();
                }
                eVar.f9352g = true;
            }
            a((d) null);
            return;
        }
        throw new IllegalArgumentException();
    }

    private i(s[] sVarArr, byte b2) {
        this(false, new aa.a(), sVarArr);
    }

    static final class e implements Comparable<e> {
        public final s a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9351f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f9352g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f9353h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f9348c = new b();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<l> f9354i = new ArrayList();
        public final Object b = new Object();

        public e(s sVar) {
            this.a = sVar;
        }

        public final void a(int i2, int i3, int i4) {
            this.f9349d = i2;
            this.f9350e = i3;
            this.f9351f = i4;
            this.f9352g = false;
            this.f9353h = false;
            this.f9354i.clear();
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(@NonNull e eVar) {
            return this.f9351f - eVar.f9351f;
        }

        private int a(@NonNull e eVar) {
            return this.f9351f - eVar.f9351f;
        }
    }

    private i(boolean z2, aa aaVar, s... sVarArr) {
        for (s sVar : sVarArr) {
            com.anythink.expressad.exoplayer.k.a.a(sVar);
        }
        this.f9335q = aaVar.a() > 0 ? aaVar.d() : aaVar;
        this.f9329k = new IdentityHashMap();
        this.f9326h = new ArrayList();
        this.f9327i = new ArrayList();
        this.f9330l = new ArrayList();
        this.f9328j = new e(null);
        this.f9331m = z2;
        this.f9332n = new ae.b();
        a(this.f9326h.size(), Arrays.asList(sVarArr), (Runnable) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(e eVar, s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        e eVar2 = eVar;
        if (eVar2 != null) {
            b bVar = eVar2.f9348c;
            if (bVar.d() != aeVar) {
                int iB = aeVar.b() - bVar.b();
                int iC = aeVar.c() - bVar.c();
                if (iB != 0 || iC != 0) {
                    a(eVar2.f9349d + 1, 0, iB, iC);
                }
                eVar2.f9348c = bVar.a(aeVar);
                if (!eVar2.f9352g && !aeVar.a()) {
                    aeVar.a(0, this.f9332n, false);
                    ae.b bVar2 = this.f9332n;
                    long j2 = bVar2.f8480j + bVar2.f8478h;
                    for (int i2 = 0; i2 < eVar2.f9354i.size(); i2++) {
                        l lVar = eVar2.f9354i.get(i2);
                        lVar.d(j2);
                        lVar.f();
                    }
                    eVar2.f9352g = true;
                }
                a((d) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private void c() {
        this.f9326h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(4).a((Object) null).i();
        }
    }

    private void b(int i2, int i3) {
        int iMin = Math.min(i2, i3);
        int iMax = Math.max(i2, i3);
        int iB = this.f9327i.get(iMin).f9350e;
        int iC = this.f9327i.get(iMin).f9351f;
        List<e> list = this.f9327i;
        list.add(i3, list.remove(i2));
        while (iMin <= iMax) {
            e eVar = this.f9327i.get(iMin);
            eVar.f9350e = iB;
            eVar.f9351f = iC;
            iB += eVar.f9348c.b();
            iC += eVar.f9348c.c();
            iMin++;
        }
    }

    private void a(s sVar) {
        a(this.f9326h.size(), sVar, (Runnable) null);
    }

    private void a(s sVar, @Nullable Runnable runnable) {
        a(this.f9326h.size(), sVar, runnable);
    }

    private void a(int i2, s sVar) {
        a(i2, sVar, (Runnable) null);
    }

    private void a(int i2, s sVar, @Nullable Runnable runnable) {
        com.anythink.expressad.exoplayer.k.a.a(sVar);
        e eVar = new e(sVar);
        this.f9326h.add(i2, eVar);
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(0).a(new f(i2, eVar, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(Collection<s> collection) {
        a(this.f9326h.size(), collection, (Runnable) null);
    }

    private void a(Collection<s> collection, @Nullable Runnable runnable) {
        a(this.f9326h.size(), collection, runnable);
    }

    private void a(int i2, Collection<s> collection) {
        a(i2, collection, (Runnable) null);
    }

    private void a(int i2, Collection<s> collection, @Nullable Runnable runnable) {
        Iterator<s> it = collection.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.exoplayer.k.a.a(it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<s> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new e(it2.next()));
        }
        this.f9326h.addAll(i2, arrayList);
        if (this.f9333o != null && !collection.isEmpty()) {
            this.f9333o.a((x.b) this).a(1).a(new f(i2, arrayList, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i2, @Nullable Runnable runnable) {
        this.f9326h.remove(i2);
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(2).a(new f(i2, null, runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(int i2, int i3, @Nullable Runnable runnable) {
        if (i2 == i3) {
            return;
        }
        List<e> list = this.f9326h;
        list.add(i3, list.remove(i2));
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(3).a(new f(i2, Integer.valueOf(i3), runnable)).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private void a(@Nullable Runnable runnable) {
        this.f9326h.clear();
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(4).a(runnable != null ? new d(runnable) : null).i();
        } else if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        super.a(hVar, z2);
        this.f9333o = hVar;
        if (this.f9326h.isEmpty()) {
            e();
            return;
        }
        this.f9335q = this.f9335q.a(0, this.f9326h.size());
        b(0, this.f9326h);
        a((d) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        int i2;
        int i3 = aVar.a;
        e eVar = this.f9328j;
        eVar.f9351f = i3;
        int iBinarySearch = Collections.binarySearch(this.f9327i, eVar);
        if (iBinarySearch < 0) {
            i2 = (-iBinarySearch) - 2;
        } else {
            while (iBinarySearch < this.f9327i.size() - 1) {
                int i4 = iBinarySearch + 1;
                if (this.f9327i.get(i4).f9351f != i3) {
                    break;
                }
                iBinarySearch = i4;
            }
            i2 = iBinarySearch;
        }
        e eVar2 = this.f9327i.get(i2);
        l lVar = new l(eVar2.a, aVar.a(aVar.a - eVar2.f9351f), bVar);
        this.f9329k.put(lVar, eVar2);
        eVar2.f9354i.add(lVar);
        if (eVar2.f9352g) {
            lVar.f();
        }
        return lVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        e eVarRemove = this.f9329k.remove(rVar);
        ((l) rVar).g();
        eVarRemove.f9354i.remove(rVar);
        if (eVarRemove.f9354i.isEmpty() && eVarRemove.f9353h) {
            a(eVarRemove);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f9327i.clear();
        this.f9333o = null;
        this.f9335q = this.f9335q.d();
        this.f9336r = 0;
        this.f9337s = 0;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static s.a a2(e eVar, s.a aVar) {
        for (int i2 = 0; i2 < eVar.f9354i.size(); i2++) {
            if (eVar.f9354i.get(i2).b.f9419d == aVar.f9419d) {
                return aVar.a(aVar.a + eVar.f9351f);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static int a2(e eVar, int i2) {
        return i2 + eVar.f9350e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.exoplayer.x.b
    public final void a(int i2, Object obj) {
        switch (i2) {
            case 0:
                f fVar = (f) obj;
                this.f9335q = this.f9335q.a(fVar.a, 1);
                a(fVar.a, (e) fVar.b);
                a(fVar.f9355c);
                return;
            case 1:
                f fVar2 = (f) obj;
                this.f9335q = this.f9335q.a(fVar2.a, ((Collection) fVar2.b).size());
                b(fVar2.a, (Collection<e>) fVar2.b);
                a(fVar2.f9355c);
                return;
            case 2:
                f fVar3 = (f) obj;
                this.f9335q = this.f9335q.c(fVar3.a);
                c(fVar3.a);
                a(fVar3.f9355c);
                return;
            case 3:
                f fVar4 = (f) obj;
                this.f9335q = this.f9335q.c(fVar4.a);
                this.f9335q = this.f9335q.a(((Integer) fVar4.b).intValue(), 1);
                int i3 = fVar4.a;
                int iIntValue = ((Integer) fVar4.b).intValue();
                int iMin = Math.min(i3, iIntValue);
                int iMax = Math.max(i3, iIntValue);
                int iB = this.f9327i.get(iMin).f9350e;
                int iC = this.f9327i.get(iMin).f9351f;
                List<e> list = this.f9327i;
                list.add(iIntValue, list.remove(i3));
                while (iMin <= iMax) {
                    e eVar = this.f9327i.get(iMin);
                    eVar.f9350e = iB;
                    eVar.f9351f = iC;
                    iB += eVar.f9348c.b();
                    iC += eVar.f9348c.c();
                    iMin++;
                }
                a(fVar4.f9355c);
                return;
            case 4:
                for (int size = this.f9327i.size() - 1; size >= 0; size--) {
                    c(size);
                }
                a((d) obj);
                return;
            case 5:
                e();
                return;
            case 6:
                List list2 = (List) obj;
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    d dVar = (d) list2.get(i4);
                    dVar.a.post(dVar.b);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    private void a(@Nullable d dVar) {
        if (!this.f9334p) {
            this.f9333o.a((x.b) this).a(5).i();
            this.f9334p = true;
        }
        if (dVar != null) {
            this.f9330l.add(dVar);
        }
    }

    private void a(int i2, e eVar) {
        if (i2 > 0) {
            e eVar2 = this.f9327i.get(i2 - 1);
            eVar.a(i2, eVar2.f9350e + eVar2.f9348c.b(), eVar2.f9351f + eVar2.f9348c.c());
        } else {
            eVar.a(i2, 0, 0);
        }
        a(i2, 1, eVar.f9348c.b(), eVar.f9348c.c());
        this.f9327i.add(i2, eVar);
        a(eVar, eVar.a);
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f9336r += i4;
        this.f9337s += i5;
        while (i2 < this.f9327i.size()) {
            this.f9327i.get(i2).f9349d += i3;
            this.f9327i.get(i2).f9350e += i4;
            this.f9327i.get(i2).f9351f += i5;
            i2++;
        }
    }

    private void a(int i2) {
        this.f9326h.remove(i2);
        com.anythink.expressad.exoplayer.h hVar = this.f9333o;
        if (hVar != null) {
            hVar.a((x.b) this).a(2).a(new f(i2, null, null)).i();
        }
    }

    private void a(int i2, int i3) {
        if (i2 != i3) {
            List<e> list = this.f9326h;
            list.add(i3, list.remove(i2));
            com.anythink.expressad.exoplayer.h hVar = this.f9333o;
            if (hVar != null) {
                hVar.a((x.b) this).a(3).a(new f(i2, Integer.valueOf(i3), null)).i();
            }
        }
    }

    private void a(e eVar, com.anythink.expressad.exoplayer.ae aeVar) {
        if (eVar != null) {
            b bVar = eVar.f9348c;
            if (bVar.d() != aeVar) {
                int iB = aeVar.b() - bVar.b();
                int iC = aeVar.c() - bVar.c();
                if (iB != 0 || iC != 0) {
                    a(eVar.f9349d + 1, 0, iB, iC);
                }
                eVar.f9348c = bVar.a(aeVar);
                if (!eVar.f9352g && !aeVar.a()) {
                    aeVar.a(0, this.f9332n, false);
                    ae.b bVar2 = this.f9332n;
                    long j2 = bVar2.f8480j + bVar2.f8478h;
                    for (int i2 = 0; i2 < eVar.f9354i.size(); i2++) {
                        l lVar = eVar.f9354i.get(i2);
                        lVar.d(j2);
                        lVar.f();
                    }
                    eVar.f9352g = true;
                }
                a((d) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
