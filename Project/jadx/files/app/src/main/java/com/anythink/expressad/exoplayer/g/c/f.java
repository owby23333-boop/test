package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.anythink.expressad.exoplayer.g.c.b {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.anythink.expressad.exoplayer.g.c.f.1
        private static f a(Parcel parcel) {
            return new f(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ f createFromParcel(Parcel parcel) {
            return new f(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ f[] newArray(int i2) {
            return new f[i2];
        }

        private static f[] a(int i2) {
            return new f[i2];
        }
    };
    public final List<b> a;

    public static final class a {
        public final int a;
        public final long b;

        /* synthetic */ a(int i2, long j2, byte b) {
            this(i2, j2);
        }

        static /* synthetic */ a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        private static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        private void c(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }

        private a(int i2, long j2) {
            this.a = i2;
            this.b = j2;
        }

        static /* synthetic */ void a(a aVar, Parcel parcel) {
            parcel.writeInt(aVar.a);
            parcel.writeLong(aVar.b);
        }
    }

    public static final class b {
        public final long a;
        public final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f9134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f9135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<a> f9136f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f9137g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f9138h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f9139i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f9140j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f9141k;

        private b(long j2, boolean z2, boolean z3, boolean z4, List<a> list, long j3, boolean z5, long j4, int i2, int i3, int i4) {
            this.a = j2;
            this.b = z2;
            this.f9133c = z3;
            this.f9134d = z4;
            this.f9136f = Collections.unmodifiableList(list);
            this.f9135e = j3;
            this.f9137g = z5;
            this.f9138h = j4;
            this.f9139i = i2;
            this.f9140j = i3;
            this.f9141k = i4;
        }

        static /* synthetic */ b a(Parcel parcel) {
            return new b(parcel);
        }

        private static b b(s sVar) {
            ArrayList arrayList;
            long j2;
            boolean z2;
            boolean z3;
            int i2;
            int i3;
            int iD;
            long jH;
            long jH2 = sVar.h();
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = (sVar.d() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z6) {
                arrayList = arrayList2;
                j2 = com.anythink.expressad.exoplayer.b.b;
                z2 = false;
                z3 = false;
                i2 = 0;
                i3 = 0;
                iD = 0;
                jH = com.anythink.expressad.exoplayer.b.b;
            } else {
                int iD2 = sVar.d();
                boolean z7 = (iD2 & 128) != 0;
                z3 = (iD2 & 64) != 0;
                boolean z8 = (iD2 & 32) != 0;
                long jH3 = z3 ? sVar.h() : com.anythink.expressad.exoplayer.b.b;
                if (!z3) {
                    int iD3 = sVar.d();
                    ArrayList arrayList3 = new ArrayList(iD3);
                    for (int i4 = 0; i4 < iD3; i4++) {
                        arrayList3.add(new a(sVar.d(), sVar.h(), z4 ? (byte) 1 : (byte) 0));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long jD = sVar.d();
                    z5 = (128 & jD) != 0;
                    jH = ((((jD & 1) << 32) | sVar.h()) * 1000) / 90;
                } else {
                    jH = com.anythink.expressad.exoplayer.b.b;
                }
                int iE = sVar.e();
                int iD4 = sVar.d();
                iD = sVar.d();
                j2 = jH3;
                i2 = iE;
                i3 = iD4;
                arrayList = arrayList2;
                boolean z9 = z7;
                z2 = z5;
                z4 = z9;
            }
            return new b(jH2, z6, z4, z3, arrayList, j2, z2, jH, i2, i3, iD);
        }

        private static b c(Parcel parcel) {
            return new b(parcel);
        }

        static /* synthetic */ b a(s sVar) {
            ArrayList arrayList;
            long j2;
            boolean z2;
            boolean z3;
            int i2;
            int i3;
            int iD;
            long jH;
            long jH2 = sVar.h();
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = (sVar.d() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z6) {
                arrayList = arrayList2;
                j2 = com.anythink.expressad.exoplayer.b.b;
                z2 = false;
                z3 = false;
                i2 = 0;
                i3 = 0;
                iD = 0;
                jH = com.anythink.expressad.exoplayer.b.b;
            } else {
                int iD2 = sVar.d();
                boolean z7 = (iD2 & 128) != 0;
                z3 = (iD2 & 64) != 0;
                boolean z8 = (iD2 & 32) != 0;
                long jH3 = z3 ? sVar.h() : com.anythink.expressad.exoplayer.b.b;
                if (!z3) {
                    int iD3 = sVar.d();
                    ArrayList arrayList3 = new ArrayList(iD3);
                    for (int i4 = 0; i4 < iD3; i4++) {
                        arrayList3.add(new a(sVar.d(), sVar.h(), z4 ? (byte) 1 : (byte) 0));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long jD = sVar.d();
                    z5 = (128 & jD) != 0;
                    jH = ((((jD & 1) << 32) | sVar.h()) * 1000) / 90;
                } else {
                    jH = com.anythink.expressad.exoplayer.b.b;
                }
                int iE = sVar.e();
                int iD4 = sVar.d();
                iD = sVar.d();
                j2 = jH3;
                i2 = iE;
                i3 = iD4;
                arrayList = arrayList2;
                boolean z9 = z7;
                z2 = z5;
                z4 = z9;
            }
            return new b(jH2, z6, z4, z3, arrayList, j2, z2, jH, i2, i3, iD);
        }

        private b(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.f9133c = parcel.readByte() == 1;
            this.f9134d = parcel.readByte() == 1;
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(a.a(parcel));
            }
            this.f9136f = Collections.unmodifiableList(arrayList);
            this.f9135e = parcel.readLong();
            this.f9137g = parcel.readByte() == 1;
            this.f9138h = parcel.readLong();
            this.f9139i = parcel.readInt();
            this.f9140j = parcel.readInt();
            this.f9141k = parcel.readInt();
        }

        private void b(Parcel parcel) {
            parcel.writeLong(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f9133c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f9134d ? (byte) 1 : (byte) 0);
            int size = this.f9136f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                a.a(this.f9136f.get(i2), parcel);
            }
            parcel.writeLong(this.f9135e);
            parcel.writeByte(this.f9137g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f9138h);
            parcel.writeInt(this.f9139i);
            parcel.writeInt(this.f9140j);
            parcel.writeInt(this.f9141k);
        }

        private static /* synthetic */ void a(b bVar, Parcel parcel) {
            parcel.writeLong(bVar.a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f9133c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f9134d ? (byte) 1 : (byte) 0);
            int size = bVar.f9136f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                a.a(bVar.f9136f.get(i2), parcel);
            }
            parcel.writeLong(bVar.f9135e);
            parcel.writeByte(bVar.f9137g ? (byte) 1 : (byte) 0);
            parcel.writeLong(bVar.f9138h);
            parcel.writeInt(bVar.f9139i);
            parcel.writeInt(bVar.f9140j);
            parcel.writeInt(bVar.f9141k);
        }
    }

    /* synthetic */ f(Parcel parcel, byte b2) {
        this(parcel);
    }

    static f a(s sVar) {
        int iD = sVar.d();
        ArrayList arrayList = new ArrayList(iD);
        for (int i2 = 0; i2 < iD; i2++) {
            arrayList.add(b.a(sVar));
        }
        return new f(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int size = this.a.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.a.get(i3);
            parcel.writeLong(bVar.a);
            parcel.writeByte(bVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f9133c ? (byte) 1 : (byte) 0);
            parcel.writeByte(bVar.f9134d ? (byte) 1 : (byte) 0);
            int size2 = bVar.f9136f.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a.a(bVar.f9136f.get(i4), parcel);
            }
            parcel.writeLong(bVar.f9135e);
            parcel.writeByte(bVar.f9137g ? (byte) 1 : (byte) 0);
            parcel.writeLong(bVar.f9138h);
            parcel.writeInt(bVar.f9139i);
            parcel.writeInt(bVar.f9140j);
            parcel.writeInt(bVar.f9141k);
        }
    }

    private f(List<b> list) {
        this.a = Collections.unmodifiableList(list);
    }

    private f(Parcel parcel) {
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(b.a(parcel));
        }
        this.a = Collections.unmodifiableList(arrayList);
    }
}
