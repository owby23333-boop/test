package com.anythink.expressad.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.anythink.expressad.exoplayer.g.c.d.1
        private static d a(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ d[] newArray(int i2) {
            return new d[i2];
        }

        private static d[] a(int i2) {
            return new d[i2];
        }
    };
    public final long a;
    public final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<a> f9126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f9127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f9128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f9129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9131m;

    public static final class a {
        public final int a;
        public final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9132c;

        /* synthetic */ a(int i2, long j2, long j3, byte b) {
            this(i2, j2, j3);
        }

        public static a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        private void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.f9132c);
        }

        private a(int i2, long j2, long j3) {
            this.a = i2;
            this.b = j2;
            this.f9132c = j3;
        }
    }

    /* synthetic */ d(Parcel parcel, byte b) {
        this(parcel);
    }

    static d a(s sVar, long j2, ac acVar) {
        List list;
        boolean z2;
        boolean z3;
        long j3;
        boolean z4;
        long j4;
        int i2;
        int iD;
        int iD2;
        boolean z5;
        List arrayList;
        long jH;
        boolean z6;
        long jH2 = sVar.h();
        boolean z7 = (sVar.d() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z7) {
            list = listEmptyList;
            z2 = false;
            z3 = false;
            j3 = com.anythink.expressad.exoplayer.b.b;
            z4 = false;
            j4 = com.anythink.expressad.exoplayer.b.b;
            i2 = 0;
            iD = 0;
            iD2 = 0;
            z5 = false;
        } else {
            int iD3 = sVar.d();
            boolean z8 = (iD3 & 128) != 0;
            boolean z9 = (iD3 & 64) != 0;
            boolean z10 = (iD3 & 32) != 0;
            boolean z11 = (iD3 & 16) != 0;
            long jA = (!z9 || z11) ? com.anythink.expressad.exoplayer.b.b : g.a(sVar, j2);
            if (z9) {
                arrayList = listEmptyList;
            } else {
                int iD4 = sVar.d();
                arrayList = new ArrayList(iD4);
                for (int i3 = 0; i3 < iD4; i3++) {
                    int iD5 = sVar.d();
                    long jA2 = !z11 ? g.a(sVar, j2) : com.anythink.expressad.exoplayer.b.b;
                    arrayList.add(new a(iD5, jA2, acVar.a(jA2), (byte) 0));
                }
            }
            if (z10) {
                long jD = sVar.d();
                z6 = (128 & jD) != 0;
                jH = ((((jD & 1) << 32) | sVar.h()) * 1000) / 90;
            } else {
                jH = com.anythink.expressad.exoplayer.b.b;
                z6 = false;
            }
            int iE = sVar.e();
            iD = sVar.d();
            iD2 = sVar.d();
            z2 = z8;
            z5 = z9;
            list = arrayList;
            boolean z12 = z6;
            i2 = iE;
            long j5 = jH;
            z3 = z11;
            j3 = jA;
            z4 = z12;
            j4 = j5;
        }
        return new d(jH2, z7, z2, z5, z3, j3, acVar.a(j3), list, z4, j4, i2, iD, iD2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9121c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9122d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9123e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f9124f);
        parcel.writeLong(this.f9125g);
        int size = this.f9126h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.f9126h.get(i3);
            parcel.writeInt(aVar.a);
            parcel.writeLong(aVar.b);
            parcel.writeLong(aVar.f9132c);
        }
        parcel.writeByte(this.f9127i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f9128j);
        parcel.writeInt(this.f9129k);
        parcel.writeInt(this.f9130l);
        parcel.writeInt(this.f9131m);
    }

    private d(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, List<a> list, boolean z6, long j5, int i2, int i3, int i4) {
        this.a = j2;
        this.b = z2;
        this.f9121c = z3;
        this.f9122d = z4;
        this.f9123e = z5;
        this.f9124f = j3;
        this.f9125g = j4;
        this.f9126h = Collections.unmodifiableList(list);
        this.f9127i = z6;
        this.f9128j = j5;
        this.f9129k = i2;
        this.f9130l = i3;
        this.f9131m = i4;
    }

    private d(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.f9121c = parcel.readByte() == 1;
        this.f9122d = parcel.readByte() == 1;
        this.f9123e = parcel.readByte() == 1;
        this.f9124f = parcel.readLong();
        this.f9125g = parcel.readLong();
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(a.a(parcel));
        }
        this.f9126h = Collections.unmodifiableList(arrayList);
        this.f9127i = parcel.readByte() == 1;
        this.f9128j = parcel.readLong();
        this.f9129k = parcel.readInt();
        this.f9130l = parcel.readInt();
        this.f9131m = parcel.readInt();
    }
}
