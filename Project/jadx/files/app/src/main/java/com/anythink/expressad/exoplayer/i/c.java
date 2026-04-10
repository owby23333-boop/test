package com.anythink.expressad.exoplayer.i;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.i.a;
import com.anythink.expressad.exoplayer.i.f;
import com.anythink.expressad.exoplayer.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.anythink.expressad.exoplayer.i.e {
    private static final float a = 0.98f;
    private static final int[] b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9515c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final f.a f9516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference<C0198c> f9517e;

    private static final class a {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f9518c;

        public a(int i2, int i3, @Nullable String str) {
            this.a = i2;
            this.b = i3;
            this.f9518c = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && TextUtils.equals(this.f9518c, aVar.f9518c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i2 = ((this.a * 31) + this.b) * 31;
            String str = this.f9518c;
            return i2 + (str != null ? str.hashCode() : 0);
        }
    }

    private static final class b implements Comparable<b> {
        private final C0198c a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9519c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9520d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f9521e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f9523g;

        public b(m mVar, C0198c c0198c, int i2) {
            this.a = c0198c;
            this.b = c.a(i2, false) ? 1 : 0;
            this.f9519c = c.a(mVar, c0198c.b) ? 1 : 0;
            this.f9520d = (mVar.f10008z & 1) == 0 ? 0 : 1;
            this.f9521e = mVar.f10003u;
            this.f9522f = mVar.f10004v;
            this.f9523g = mVar.f9986d;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compareTo(b bVar) {
            int iA;
            int i2 = this.b;
            int i3 = bVar.b;
            if (i2 != i3) {
                return c.a(i2, i3);
            }
            int i4 = this.f9519c;
            int i5 = bVar.f9519c;
            if (i4 != i5) {
                return c.a(i4, i5);
            }
            int i6 = this.f9520d;
            int i7 = bVar.f9520d;
            if (i6 != i7) {
                return c.a(i6, i7);
            }
            if (this.a.f9534m) {
                return c.a(bVar.f9523g, this.f9523g);
            }
            int i8 = i2 != 1 ? -1 : 1;
            int i9 = this.f9521e;
            int i10 = bVar.f9521e;
            if (i9 != i10) {
                iA = c.a(i9, i10);
            } else {
                int i11 = this.f9522f;
                int i12 = bVar.f9522f;
                iA = i11 != i12 ? c.a(i11, i12) : c.a(this.f9523g, bVar.f9523g);
            }
            return i8 * iA;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.b == bVar.b && this.f9519c == bVar.f9519c && this.f9520d == bVar.f9520d && this.f9521e == bVar.f9521e && this.f9522f == bVar.f9522f && this.f9523g == bVar.f9523g) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.b * 31) + this.f9519c) * 31) + this.f9520d) * 31) + this.f9521e) * 31) + this.f9522f) * 31) + this.f9523g;
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.i.c$c, reason: collision with other inner class name */
    public static final class C0198c implements Parcelable {

        @Nullable
        public final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f9524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f9526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f9528g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f9529h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f9530i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f9531j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f9532k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f9533l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f9534m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f9535n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f9536o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f9537p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f9538q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final SparseArray<Map<af, e>> f9539r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final SparseBooleanArray f9540s;
        public static final C0198c a = new C0198c();
        public static final Parcelable.Creator<C0198c> CREATOR = new Parcelable.Creator<C0198c>() { // from class: com.anythink.expressad.exoplayer.i.c.c.1
            private static C0198c a(Parcel parcel) {
                return new C0198c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ C0198c createFromParcel(Parcel parcel) {
                return new C0198c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ C0198c[] newArray(int i2) {
                return new C0198c[i2];
            }

            private static C0198c[] a(int i2) {
                return new C0198c[i2];
            }
        };

        private C0198c() {
            this(new SparseArray(), new SparseBooleanArray(), null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0107 A[LOOP:0: B:57:0x00b0->B:74:0x0107, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x010d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x00ad A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean equals(@androidx.annotation.Nullable java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.C0198c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = (((((((((((((((((((((((((((this.f9525d ? 1 : 0) * 31) + this.f9526e) * 31) + (this.f9534m ? 1 : 0)) * 31) + (this.f9535n ? 1 : 0)) * 31) + (this.f9536o ? 1 : 0)) * 31) + this.f9527f) * 31) + this.f9528g) * 31) + (this.f9530i ? 1 : 0)) * 31) + (this.f9537p ? 1 : 0)) * 31) + (this.f9533l ? 1 : 0)) * 31) + this.f9531j) * 31) + this.f9532k) * 31) + this.f9529h) * 31) + this.f9538q) * 31;
            String str = this.b;
            int iHashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f9524c;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            SparseArray<Map<af, e>> sparseArray = this.f9539r;
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = sparseArray.keyAt(i3);
                Map<af, e> mapValueAt = sparseArray.valueAt(i3);
                int size2 = mapValueAt.size();
                parcel.writeInt(iKeyAt);
                parcel.writeInt(size2);
                for (Map.Entry<af, e> entry : mapValueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
            parcel.writeSparseBooleanArray(this.f9540s);
            parcel.writeString(this.b);
            parcel.writeString(this.f9524c);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9525d);
            parcel.writeInt(this.f9526e);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9534m);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9535n);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9536o);
            parcel.writeInt(this.f9527f);
            parcel.writeInt(this.f9528g);
            parcel.writeInt(this.f9529h);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9530i);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9537p);
            parcel.writeInt(this.f9531j);
            parcel.writeInt(this.f9532k);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.f9533l);
            parcel.writeInt(this.f9538q);
        }

        C0198c(SparseArray<Map<af, e>> sparseArray, SparseBooleanArray sparseBooleanArray, @Nullable String str, @Nullable String str2, boolean z2, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, int i5, boolean z6, boolean z7, int i6, int i7, boolean z8, int i8) {
            this.f9539r = sparseArray;
            this.f9540s = sparseBooleanArray;
            this.b = com.anythink.expressad.exoplayer.k.af.b(str);
            this.f9524c = com.anythink.expressad.exoplayer.k.af.b(str2);
            this.f9525d = z2;
            this.f9526e = i2;
            this.f9534m = z3;
            this.f9535n = z4;
            this.f9536o = z5;
            this.f9527f = i3;
            this.f9528g = i4;
            this.f9529h = i5;
            this.f9530i = z6;
            this.f9537p = z7;
            this.f9531j = i6;
            this.f9532k = i7;
            this.f9533l = z8;
            this.f9538q = i8;
        }

        public final boolean a(int i2) {
            return this.f9540s.get(i2);
        }

        @Nullable
        public final e b(int i2, af afVar) {
            Map<af, e> map = this.f9539r.get(i2);
            if (map != null) {
                return map.get(afVar);
            }
            return null;
        }

        public final boolean a(int i2, af afVar) {
            Map<af, e> map = this.f9539r.get(i2);
            return map != null && map.containsKey(afVar);
        }

        private d a() {
            return new d(this, (byte) 0);
        }

        private static SparseArray<Map<af, e>> a(Parcel parcel) {
            int i2 = parcel.readInt();
            SparseArray<Map<af, e>> sparseArray = new SparseArray<>(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = parcel.readInt();
                int i5 = parcel.readInt();
                HashMap map = new HashMap(i5);
                for (int i6 = 0; i6 < i5; i6++) {
                    map.put((af) parcel.readParcelable(af.class.getClassLoader()), (e) parcel.readParcelable(e.class.getClassLoader()));
                }
                sparseArray.put(i4, map);
            }
            return sparseArray;
        }

        private static void a(Parcel parcel, SparseArray<Map<af, e>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int iKeyAt = sparseArray.keyAt(i2);
                Map<af, e> mapValueAt = sparseArray.valueAt(i2);
                int size2 = mapValueAt.size();
                parcel.writeInt(iKeyAt);
                parcel.writeInt(size2);
                for (Map.Entry<af, e> entry : mapValueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        C0198c(Parcel parcel) {
            this.f9539r = a(parcel);
            this.f9540s = parcel.readSparseBooleanArray();
            this.b = parcel.readString();
            this.f9524c = parcel.readString();
            this.f9525d = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9526e = parcel.readInt();
            this.f9534m = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9535n = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9536o = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9527f = parcel.readInt();
            this.f9528g = parcel.readInt();
            this.f9529h = parcel.readInt();
            this.f9530i = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9537p = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9531j = parcel.readInt();
            this.f9532k = parcel.readInt();
            this.f9533l = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f9538q = parcel.readInt();
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0064 A[LOOP:0: B:6:0x000d->B:23:0x0064, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0067 A[EDGE_INSN: B:28:0x0067->B:24:0x0067 BREAK  A[LOOP:0: B:6:0x000d->B:23:0x0064], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean a(android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> r9, android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> r10) {
            /*
                int r0 = r9.size()
                int r1 = r10.size()
                r2 = 0
                if (r1 == r0) goto Lc
                return r2
            Lc:
                r1 = 0
            Ld:
                r3 = 1
                if (r1 >= r0) goto L68
                int r4 = r9.keyAt(r1)
                int r4 = r10.indexOfKey(r4)
                if (r4 < 0) goto L67
                java.lang.Object r5 = r9.valueAt(r1)
                java.util.Map r5 = (java.util.Map) r5
                java.lang.Object r4 = r10.valueAt(r4)
                java.util.Map r4 = (java.util.Map) r4
                int r6 = r5.size()
                int r7 = r4.size()
                if (r7 == r6) goto L32
            L30:
                r3 = 0
                goto L61
            L32:
                java.util.Set r5 = r5.entrySet()
                java.util.Iterator r5 = r5.iterator()
            L3a:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L61
                java.lang.Object r6 = r5.next()
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                java.lang.Object r7 = r6.getKey()
                com.anythink.expressad.exoplayer.h.af r7 = (com.anythink.expressad.exoplayer.h.af) r7
                boolean r8 = r4.containsKey(r7)
                if (r8 == 0) goto L30
                java.lang.Object r6 = r6.getValue()
                java.lang.Object r7 = r4.get(r7)
                boolean r6 = com.anythink.expressad.exoplayer.k.af.a(r6, r7)
                if (r6 != 0) goto L3a
                goto L30
            L61:
                if (r3 != 0) goto L64
                goto L67
            L64:
                int r1 = r1 + 1
                goto Ld
            L67:
                return r2
            L68:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.C0198c.a(android.util.SparseArray, android.util.SparseArray):boolean");
        }

        private static boolean a(Map<af, e> map, Map<af, e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry<af, e> entry : map.entrySet()) {
                af key = entry.getKey();
                if (!map2.containsKey(key) || !com.anythink.expressad.exoplayer.k.af.a(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class d {
        private final SparseArray<Map<af, e>> a;
        private final SparseBooleanArray b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f9541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f9542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9543e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9544f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9545g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9546h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f9547i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f9548j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f9549k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f9550l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f9551m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f9552n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f9553o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f9554p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f9555q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f9556r;

        /* synthetic */ d(C0198c c0198c, byte b) {
            this(c0198c);
        }

        private d a(String str) {
            this.f9541c = str;
            return this;
        }

        private d b(String str) {
            this.f9542d = str;
            return this;
        }

        private d c(int i2) {
            this.f9544f = i2;
            return this;
        }

        private d d(boolean z2) {
            this.f9547i = z2;
            return this;
        }

        private d e(boolean z2) {
            this.f9551m = z2;
            return this;
        }

        private d f(boolean z2) {
            this.f9552n = z2;
            return this;
        }

        public d() {
            this(C0198c.a);
        }

        private d a(boolean z2) {
            this.f9543e = z2;
            return this;
        }

        private d b(boolean z2) {
            this.f9545g = z2;
            return this;
        }

        private d c(boolean z2) {
            this.f9546h = z2;
            return this;
        }

        private d d() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        private d e() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private d(C0198c c0198c) {
            this.a = a((SparseArray<Map<af, e>>) c0198c.f9539r);
            this.b = c0198c.f9540s.clone();
            this.f9541c = c0198c.b;
            this.f9542d = c0198c.f9524c;
            this.f9543e = c0198c.f9525d;
            this.f9544f = c0198c.f9526e;
            this.f9545g = c0198c.f9534m;
            this.f9546h = c0198c.f9535n;
            this.f9547i = c0198c.f9536o;
            this.f9548j = c0198c.f9527f;
            this.f9549k = c0198c.f9528g;
            this.f9550l = c0198c.f9529h;
            this.f9551m = c0198c.f9530i;
            this.f9552n = c0198c.f9537p;
            this.f9553o = c0198c.f9531j;
            this.f9554p = c0198c.f9532k;
            this.f9555q = c0198c.f9533l;
            this.f9556r = c0198c.f9538q;
        }

        private d a(int i2, int i3) {
            this.f9548j = i2;
            this.f9549k = i3;
            return this;
        }

        private d c() {
            return a(1279, 719);
        }

        private d d(int i2) {
            this.f9550l = i2;
            return this;
        }

        public final d b(int i2) {
            if (this.f9556r != i2) {
                this.f9556r = i2;
            }
            return this;
        }

        private d a(Context context, boolean z2) {
            Point pointA = com.anythink.expressad.exoplayer.k.af.a(context);
            return a(pointA.x, pointA.y, z2);
        }

        public final C0198c b() {
            return new C0198c(this.a, this.b, this.f9541c, this.f9542d, this.f9543e, this.f9544f, this.f9545g, this.f9546h, this.f9547i, this.f9548j, this.f9549k, this.f9550l, this.f9551m, this.f9552n, this.f9553o, this.f9554p, this.f9555q, this.f9556r);
        }

        private d a(int i2, int i3, boolean z2) {
            this.f9553o = i2;
            this.f9554p = i3;
            this.f9555q = z2;
            return this;
        }

        public final d a(int i2, boolean z2) {
            if (this.b.get(i2) == z2) {
                return this;
            }
            if (z2) {
                this.b.put(i2, true);
            } else {
                this.b.delete(i2);
            }
            return this;
        }

        public final d a(int i2, af afVar, e eVar) {
            Map<af, e> map = this.a.get(i2);
            if (map == null) {
                map = new HashMap<>();
                this.a.put(i2, map);
            }
            if (map.containsKey(afVar) && com.anythink.expressad.exoplayer.k.af.a(map.get(afVar), eVar)) {
                return this;
            }
            map.put(afVar, eVar);
            return this;
        }

        public final d a(int i2, af afVar) {
            Map<af, e> map = this.a.get(i2);
            if (map != null && map.containsKey(afVar)) {
                map.remove(afVar);
                if (map.isEmpty()) {
                    this.a.remove(i2);
                }
            }
            return this;
        }

        public final d a(int i2) {
            Map<af, e> map = this.a.get(i2);
            if (map != null && !map.isEmpty()) {
                this.a.remove(i2);
            }
            return this;
        }

        public final d a() {
            if (this.a.size() == 0) {
                return this;
            }
            this.a.clear();
            return this;
        }

        private static SparseArray<Map<af, e>> a(SparseArray<Map<af, e>> sparseArray) {
            SparseArray<Map<af, e>> sparseArray2 = new SparseArray<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
            }
            return sparseArray2;
        }
    }

    public c() {
        this((f.a) null);
    }

    static /* synthetic */ int a(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    private void a(C0198c c0198c) {
        com.anythink.expressad.exoplayer.k.a.a(c0198c);
        if (this.f9517e.getAndSet(c0198c).equals(c0198c)) {
            return;
        }
        b();
    }

    protected static boolean a(int i2, boolean z2) {
        int i3 = i2 & 7;
        if (i3 != 4) {
            return z2 && i3 == 3;
        }
        return true;
    }

    private static int b(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    @Deprecated
    private void b(int i2, boolean z2) {
        a(d().a(i2, z2));
    }

    private static int c(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    private C0198c c() {
        return this.f9517e.get();
    }

    private d d() {
        return new d(c(), (byte) 0);
    }

    @Deprecated
    private void e() {
        a(d().a());
    }

    private c(com.anythink.expressad.exoplayer.j.d dVar) {
        this(new a.C0197a(dVar));
    }

    @Nullable
    @Deprecated
    private e b(int i2, af afVar) {
        return c().b(i2, afVar);
    }

    @Deprecated
    private void c(int i2, af afVar) {
        a(d().a(i2, afVar));
    }

    private c(@Nullable f.a aVar) {
        this.f9516d = aVar;
        this.f9517e = new AtomicReference<>(C0198c.a);
    }

    @Deprecated
    private void b(int i2) {
        a(d().a(i2));
    }

    @Deprecated
    private void c(int i2) {
        a(d().b(i2));
    }

    private void a(d dVar) {
        C0198c c0198cB = dVar.b();
        com.anythink.expressad.exoplayer.k.a.a(c0198cB);
        if (this.f9517e.getAndSet(c0198cB).equals(c0198cB)) {
            return;
        }
        b();
    }

    @Nullable
    private static f b(af afVar, int[][] iArr, int i2, C0198c c0198c, f.a aVar) {
        List<Integer> list;
        int i3;
        int i4;
        int i5;
        String str;
        int[] iArrA;
        int i6;
        int i7;
        HashSet hashSet;
        List<Integer> list2;
        int i8;
        int i9;
        int i10;
        int i11 = c0198c.f9536o ? 24 : 16;
        boolean z2 = c0198c.f9535n && (i2 & i11) != 0;
        for (int i12 = 0; i12 < afVar.b; i12++) {
            ae aeVarA = afVar.a(i12);
            int[] iArr2 = iArr[i12];
            int i13 = c0198c.f9527f;
            int i14 = c0198c.f9528g;
            int i15 = c0198c.f9529h;
            int i16 = c0198c.f9531j;
            int i17 = c0198c.f9532k;
            boolean z3 = c0198c.f9533l;
            if (aeVarA.a < 2) {
                iArrA = b;
            } else {
                List<Integer> listA = a(aeVarA, i16, i17, z3);
                if (listA.size() < 2) {
                    iArrA = b;
                } else {
                    if (z2) {
                        list = listA;
                        i3 = i15;
                        i4 = i14;
                        i5 = i13;
                        str = null;
                    } else {
                        HashSet hashSet2 = new HashSet();
                        String str2 = null;
                        int i18 = 0;
                        int i19 = 0;
                        while (i19 < listA.size()) {
                            String str3 = aeVarA.a(listA.get(i19).intValue()).f9990h;
                            if (hashSet2.add(str3)) {
                                i6 = i18;
                                i7 = i19;
                                hashSet = hashSet2;
                                list2 = listA;
                                i8 = i15;
                                i9 = i14;
                                i10 = i13;
                                int iA = a(aeVarA, iArr2, i11, str3, i13, i14, i8, list2);
                                if (iA > i6) {
                                    i18 = iA;
                                    str2 = str3;
                                }
                                i19 = i7 + 1;
                                hashSet2 = hashSet;
                                listA = list2;
                                i15 = i8;
                                i14 = i9;
                                i13 = i10;
                            } else {
                                i6 = i18;
                                i7 = i19;
                                hashSet = hashSet2;
                                list2 = listA;
                                i8 = i15;
                                i9 = i14;
                                i10 = i13;
                            }
                            i18 = i6;
                            i19 = i7 + 1;
                            hashSet2 = hashSet;
                            listA = list2;
                            i15 = i8;
                            i14 = i9;
                            i13 = i10;
                        }
                        list = listA;
                        i3 = i15;
                        i4 = i14;
                        i5 = i13;
                        str = str2;
                    }
                    b(aeVarA, iArr2, i11, str, i5, i4, i3, list);
                    iArrA = list.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(list);
                }
            }
            if (iArrA.length > 0) {
                return ((f.a) com.anythink.expressad.exoplayer.k.a.a(aVar)).a(aeVarA, iArrA);
            }
        }
        return null;
    }

    @Nullable
    private static f c(af afVar, int[][] iArr, C0198c c0198c) {
        ae aeVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < afVar.b) {
            ae aeVarA = afVar.a(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            int i6 = i3;
            ae aeVar2 = aeVar;
            for (int i7 = 0; i7 < aeVarA.a; i7++) {
                if (a(iArr2[i7], c0198c.f9537p)) {
                    int i8 = (aeVarA.a(i7).f10008z & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i7], false)) {
                        i8 += 1000;
                    }
                    if (i8 > i5) {
                        i6 = i7;
                        aeVar2 = aeVarA;
                        i5 = i8;
                    }
                }
            }
            i2++;
            aeVar = aeVar2;
            i3 = i6;
            i4 = i5;
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i3);
    }

    public static final class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.i.c.e.1
            private static e a(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ e[] newArray(int i2) {
                return new e[i2];
            }

            private static e[] a(int i2) {
                return new e[i2];
            }
        };
        public final int a;
        public final int[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9557c;

        private e(int i2, int... iArr) {
            this.a = i2;
            this.b = Arrays.copyOf(iArr, iArr.length);
            this.f9557c = iArr.length;
            Arrays.sort(this.b);
        }

        private boolean a(int i2) {
            for (int i3 : this.b) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e.class == obj.getClass()) {
                e eVar = (e) obj;
                if (this.a == eVar.a && Arrays.equals(this.b, eVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + Arrays.hashCode(this.b);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b.length);
            parcel.writeIntArray(this.b);
        }

        e(Parcel parcel) {
            this.a = parcel.readInt();
            this.f9557c = parcel.readByte();
            this.b = new int[this.f9557c];
            parcel.readIntArray(this.b);
        }
    }

    @Deprecated
    private boolean a(int i2) {
        return c().a(i2);
    }

    @Deprecated
    private void a(int i2, af afVar, e eVar) {
        a(d().a(i2, afVar, eVar));
    }

    @Deprecated
    private boolean a(int i2, af afVar) {
        return c().a(i2, afVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012c  */
    @Override // com.anythink.expressad.exoplayer.i.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final android.util.Pair<com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[]> a(com.anythink.expressad.exoplayer.i.e.a r34, int[][][] r35, int[] r36) {
        /*
            Method dump skipped, instruction units count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.i.e$a, int[][][], int[]):android.util.Pair");
    }

    private static void b(ae aeVar, int[] iArr, int i2, @Nullable String str, int i3, int i4, int i5, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!a(aeVar.a(iIntValue), str, iArr[iIntValue], i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008f A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.i.f b(com.anythink.expressad.exoplayer.h.af r16, int[][] r17, com.anythink.expressad.exoplayer.i.c.C0198c r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = 0
            r6 = 0
            r7 = 0
        La:
            int r8 = r0.b
            if (r4 >= r8) goto L99
            com.anythink.expressad.exoplayer.h.ae r8 = r0.a(r4)
            r9 = r17[r4]
            r10 = r7
            r7 = r6
            r6 = r5
            r5 = 0
        L18:
            int r11 = r8.a
            if (r5 >= r11) goto L92
            r11 = r9[r5]
            boolean r12 = r1.f9537p
            boolean r11 = a(r11, r12)
            if (r11 == 0) goto L8f
            com.anythink.expressad.exoplayer.m r11 = r8.a(r5)
            int r12 = r11.f10008z
            int r13 = r1.f9526e
            r13 = r13 ^ (-1)
            r12 = r12 & r13
            r13 = r12 & 1
            if (r13 == 0) goto L37
            r13 = 1
            goto L38
        L37:
            r13 = 0
        L38:
            r12 = r12 & 2
            if (r12 == 0) goto L3e
            r12 = 1
            goto L3f
        L3e:
            r12 = 0
        L3f:
            java.lang.String r15 = r1.f9524c
            boolean r15 = a(r11, r15)
            if (r15 != 0) goto L74
            boolean r14 = r1.f9525d
            if (r14 == 0) goto L62
            java.lang.String r14 = r11.A
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L5e
            java.lang.String r14 = "und"
            boolean r14 = a(r11, r14)
            if (r14 == 0) goto L5c
            goto L5e
        L5c:
            r14 = 0
            goto L5f
        L5e:
            r14 = 1
        L5f:
            if (r14 == 0) goto L62
            goto L74
        L62:
            if (r13 == 0) goto L66
            r14 = 3
            goto L80
        L66:
            if (r12 == 0) goto L8f
            java.lang.String r12 = r1.b
            boolean r11 = a(r11, r12)
            if (r11 == 0) goto L72
            r14 = 2
            goto L80
        L72:
            r14 = 1
            goto L80
        L74:
            if (r13 == 0) goto L79
            r11 = 8
            goto L7e
        L79:
            if (r12 != 0) goto L7d
            r11 = 6
            goto L7e
        L7d:
            r11 = 4
        L7e:
            int r14 = r11 + r15
        L80:
            r11 = r9[r5]
            boolean r11 = a(r11, r3)
            if (r11 == 0) goto L8a
            int r14 = r14 + 1000
        L8a:
            if (r14 <= r10) goto L8f
            r7 = r5
            r6 = r8
            r10 = r14
        L8f:
            int r5 = r5 + 1
            goto L18
        L92:
            int r4 = r4 + 1
            r5 = r6
            r6 = r7
            r7 = r10
            goto La
        L99:
            if (r5 != 0) goto L9c
            return r2
        L9c:
            com.anythink.expressad.exoplayer.i.d r0 = new com.anythink.expressad.exoplayer.i.d
            r0.<init>(r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.b(com.anythink.expressad.exoplayer.h.af, int[][], com.anythink.expressad.exoplayer.i.c$c):com.anythink.expressad.exoplayer.i.f");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4 A[LOOP:1: B:22:0x003f->B:51:0x00f4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.expressad.exoplayer.i.f[] a(com.anythink.expressad.exoplayer.i.e.a r34, int[][][] r35, int[] r36, com.anythink.expressad.exoplayer.i.c.C0198c r37) {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.i.e$a, int[][][], int[], com.anythink.expressad.exoplayer.i.c$c):com.anythink.expressad.exoplayer.i.f[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ff A[LOOP:0: B:16:0x0022->B:46:0x00ff, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f1 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.af r26, int[][] r27, int r28, com.anythink.expressad.exoplayer.i.c.C0198c r29, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.i.f.a r30) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.h.af, int[][], int, com.anythink.expressad.exoplayer.i.c$c, com.anythink.expressad.exoplayer.i.f$a):com.anythink.expressad.exoplayer.i.f");
    }

    private static int[] a(ae aeVar, int[] iArr, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, boolean z3) {
        String str;
        int iA;
        if (aeVar.a < 2) {
            return b;
        }
        List<Integer> listA = a(aeVar, i6, i7, z3);
        if (listA.size() < 2) {
            return b;
        }
        if (z2) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < listA.size(); i9++) {
                String str3 = aeVar.a(listA.get(i9).intValue()).f9990h;
                if (hashSet.add(str3) && (iA = a(aeVar, iArr, i2, str3, i3, i4, i5, listA)) > i8) {
                    i8 = iA;
                    str2 = str3;
                }
            }
            str = str2;
        }
        b(aeVar, iArr, i2, str, i3, i4, i5, listA);
        return listA.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(listA);
    }

    private static int a(ae aeVar, int[] iArr, int i2, @Nullable String str, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int iIntValue = list.get(i7).intValue();
            if (a(aeVar.a(iIntValue), str, iArr[iIntValue], i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    private static boolean a(m mVar, @Nullable String str, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        return a(i2, false) && (i2 & i3) != 0 && (str == null || com.anythink.expressad.exoplayer.k.af.a((Object) mVar.f9990h, (Object) str)) && (((i7 = mVar.f9995m) == -1 || i7 <= i4) && (((i8 = mVar.f9996n) == -1 || i8 <= i5) && ((i9 = mVar.f9986d) == -1 || i9 <= i6)));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.af r18, int[][] r19, com.anythink.expressad.exoplayer.i.c.C0198c r20) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.h.af, int[][], com.anythink.expressad.exoplayer.i.c$c):com.anythink.expressad.exoplayer.i.f");
    }

    @Nullable
    private static f a(af afVar, int[][] iArr, C0198c c0198c, @Nullable f.a aVar) {
        int[] iArr2;
        int iA;
        b bVar = null;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i2 < afVar.b) {
            ae aeVarA = afVar.a(i2);
            int[] iArr3 = iArr[i2];
            int i5 = i4;
            b bVar2 = bVar;
            int i6 = i3;
            for (int i7 = 0; i7 < aeVarA.a; i7++) {
                if (a(iArr3[i7], c0198c.f9537p)) {
                    b bVar3 = new b(aeVarA.a(i7), c0198c, iArr3[i7]);
                    if (bVar2 == null || bVar3.compareTo(bVar2) > 0) {
                        i6 = i2;
                        i5 = i7;
                        bVar2 = bVar3;
                    }
                }
            }
            i2++;
            i3 = i6;
            bVar = bVar2;
            i4 = i5;
        }
        if (i3 == -1) {
            return null;
        }
        ae aeVarA2 = afVar.a(i3);
        if (!c0198c.f9534m && aVar != null) {
            int[] iArr4 = iArr[i3];
            boolean z2 = c0198c.f9535n;
            HashSet hashSet = new HashSet();
            a aVar2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < aeVarA2.a; i9++) {
                m mVarA = aeVarA2.a(i9);
                a aVar3 = new a(mVarA.f10003u, mVarA.f10004v, z2 ? null : mVarA.f9990h);
                if (hashSet.add(aVar3) && (iA = a(aeVarA2, iArr4, aVar3)) > i8) {
                    i8 = iA;
                    aVar2 = aVar3;
                }
            }
            if (i8 > 1) {
                iArr2 = new int[i8];
                int i10 = 0;
                for (int i11 = 0; i11 < aeVarA2.a; i11++) {
                    if (a(aeVarA2.a(i11), iArr4[i11], (a) com.anythink.expressad.exoplayer.k.a.a(aVar2))) {
                        iArr2[i10] = i11;
                        i10++;
                    }
                }
            } else {
                iArr2 = b;
            }
            if (iArr2.length > 0) {
                return aVar.a(aeVarA2, iArr2);
            }
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVarA2, i4);
    }

    private static int[] a(ae aeVar, int[] iArr, boolean z2) {
        int iA;
        HashSet hashSet = new HashSet();
        a aVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < aeVar.a; i3++) {
            m mVarA = aeVar.a(i3);
            a aVar2 = new a(mVarA.f10003u, mVarA.f10004v, z2 ? null : mVarA.f9990h);
            if (hashSet.add(aVar2) && (iA = a(aeVar, iArr, aVar2)) > i2) {
                i2 = iA;
                aVar = aVar2;
            }
        }
        if (i2 > 1) {
            int[] iArr2 = new int[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < aeVar.a; i5++) {
                if (a(aeVar.a(i5), iArr[i5], (a) com.anythink.expressad.exoplayer.k.a.a(aVar))) {
                    iArr2[i4] = i5;
                    i4++;
                }
            }
            return iArr2;
        }
        return b;
    }

    private static int a(ae aeVar, int[] iArr, a aVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < aeVar.a; i3++) {
            if (a(aeVar.a(i3), iArr[i3], aVar)) {
                i2++;
            }
        }
        return i2;
    }

    private static boolean a(m mVar, int i2, a aVar) {
        String str;
        return a(i2, false) && mVar.f10003u == aVar.a && mVar.f10004v == aVar.b && ((str = aVar.f9518c) == null || TextUtils.equals(str, mVar.f9990h));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.anythink.expressad.exoplayer.i.e.a r15, int[][][] r16, com.anythink.expressad.exoplayer.aa[] r17, com.anythink.expressad.exoplayer.i.f[] r18, int r19) {
        /*
            r0 = r15
            r1 = r19
            if (r1 != 0) goto L6
            return
        L6:
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        Lb:
            int r7 = r15.a()
            r8 = 1
            if (r4 >= r7) goto L5b
            int r7 = r15.a(r4)
            r9 = r18[r4]
            if (r7 == r8) goto L1d
            r10 = 2
            if (r7 != r10) goto L58
        L1d:
            if (r9 == 0) goto L58
            r10 = r16[r4]
            com.anythink.expressad.exoplayer.h.af r11 = r15.b(r4)
            if (r9 != 0) goto L29
        L27:
            r9 = 0
            goto L4a
        L29:
            com.anythink.expressad.exoplayer.h.ae r12 = r9.f()
            int r11 = r11.a(r12)
            r12 = 0
        L32:
            int r13 = r9.g()
            if (r12 >= r13) goto L49
            r13 = r10[r11]
            int r14 = r9.b(r12)
            r13 = r13[r14]
            r14 = 32
            r13 = r13 & r14
            if (r13 == r14) goto L46
            goto L27
        L46:
            int r12 = r12 + 1
            goto L32
        L49:
            r9 = 1
        L4a:
            if (r9 == 0) goto L58
            if (r7 != r8) goto L53
            if (r6 == r2) goto L51
            goto L55
        L51:
            r6 = r4
            goto L58
        L53:
            if (r5 == r2) goto L57
        L55:
            r0 = 0
            goto L5c
        L57:
            r5 = r4
        L58:
            int r4 = r4 + 1
            goto Lb
        L5b:
            r0 = 1
        L5c:
            if (r6 == r2) goto L61
            if (r5 == r2) goto L61
            r3 = 1
        L61:
            r0 = r0 & r3
            if (r0 == 0) goto L6d
            com.anythink.expressad.exoplayer.aa r0 = new com.anythink.expressad.exoplayer.aa
            r0.<init>(r1)
            r17[r6] = r0
            r17[r5] = r0
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(com.anythink.expressad.exoplayer.i.e$a, int[][][], com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[], int):void");
    }

    private static boolean a(int[][] iArr, af afVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int iA = afVar.a(fVar.f());
        for (int i2 = 0; i2 < fVar.g(); i2++) {
            if ((iArr[iA][fVar.b(i2)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(m mVar) {
        return TextUtils.isEmpty(mVar.A) || a(mVar, com.anythink.expressad.exoplayer.b.ar);
    }

    protected static boolean a(m mVar, @Nullable String str) {
        return str != null && TextUtils.equals(str, com.anythink.expressad.exoplayer.k.af.b(mVar.A));
    }

    private static List<Integer> a(ae aeVar, int i2, int i3, boolean z2) {
        int i4;
        ArrayList arrayList = new ArrayList(aeVar.a);
        for (int i5 = 0; i5 < aeVar.a; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < aeVar.a; i7++) {
                m mVarA = aeVar.a(i7);
                int i8 = mVarA.f9995m;
                if (i8 > 0 && (i4 = mVarA.f9996n) > 0) {
                    Point pointA = a(z2, i2, i3, i8, i4);
                    int i9 = mVarA.f9995m;
                    int i10 = mVarA.f9996n;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (pointA.x * a)) && i10 >= ((int) (pointA.y * a)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iA = aeVar.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (iA == -1 || iA > i6) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L10
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            goto Ld
        Lc:
            r3 = 0
        Ld:
            if (r1 == r3) goto L10
            goto L13
        L10:
            r2 = r5
            r5 = r4
            r4 = r2
        L13:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L23
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.anythink.expressad.exoplayer.k.af.a(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L23:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.anythink.expressad.exoplayer.k.af.a(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.c.a(boolean, int, int, int, int):android.graphics.Point");
    }
}
