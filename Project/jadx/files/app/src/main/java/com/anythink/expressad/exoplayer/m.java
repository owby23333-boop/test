package com.anythink.expressad.exoplayer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: com.anythink.expressad.exoplayer.m.1
        private static m a(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ m[] newArray(int i2) {
            return new m[i2];
        }

        private static m[] a(int i2) {
            return new m[i2];
        }
    };
    public static final int a = -1;
    public static final long b = Long.MAX_VALUE;

    @Nullable
    public final String A;
    public final int B;
    private int C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f9985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f9987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final com.anythink.expressad.exoplayer.g.a f9988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f9989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f9990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<byte[]> f9992j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final com.anythink.expressad.exoplayer.d.e f9993k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f9994l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9995m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f9996n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f9997o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f9998p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f9999q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f10000r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final byte[] f10001s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public final com.anythink.expressad.exoplayer.l.b f10002t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f10003u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10004v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f10005w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f10006x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f10007y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f10008z;

    private m(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, @Nullable byte[] bArr, int i7, @Nullable com.anythink.expressad.exoplayer.l.b bVar, int i8, int i9, int i10, int i11, int i12, int i13, @Nullable String str5, int i14, long j2, @Nullable List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar, @Nullable com.anythink.expressad.exoplayer.g.a aVar) {
        this.f9985c = str;
        this.f9989g = str2;
        this.f9990h = str3;
        this.f9987e = str4;
        this.f9986d = i2;
        this.f9991i = i3;
        this.f9995m = i4;
        this.f9996n = i5;
        this.f9997o = f2;
        int i15 = i6;
        this.f9998p = i15 == -1 ? 0 : i15;
        this.f9999q = f3 == -1.0f ? 1.0f : f3;
        this.f10001s = bArr;
        this.f10000r = i7;
        this.f10002t = bVar;
        this.f10003u = i8;
        this.f10004v = i9;
        this.f10005w = i10;
        int i16 = i11;
        this.f10006x = i16 == -1 ? 0 : i16;
        this.f10007y = i12 != -1 ? i12 : 0;
        this.f10008z = i13;
        this.A = str5;
        this.B = i14;
        this.f9994l = j2;
        this.f9992j = list == null ? Collections.emptyList() : list;
        this.f9993k = eVar;
        this.f9988f = aVar;
    }

    private static m a(@Nullable String str, @Nullable String str2, String str3, String str4, int i2, int i3, int i4, float f2, List<byte[]> list, int i5) {
        return new m(str, str2, str3, str4, i2, -1, i3, i4, f2, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i5, null, -1, Long.MAX_VALUE, list, null, null);
    }

    private static m b(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, -1, -1.0f, null, -1, null, eVar);
    }

    private static m c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, int i3, @Nullable String str5) {
        return new m(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f9986d == mVar.f9986d && this.f9991i == mVar.f9991i && this.f9995m == mVar.f9995m && this.f9996n == mVar.f9996n && this.f9997o == mVar.f9997o && this.f9998p == mVar.f9998p && this.f9999q == mVar.f9999q && this.f10000r == mVar.f10000r && this.f10003u == mVar.f10003u && this.f10004v == mVar.f10004v && this.f10005w == mVar.f10005w && this.f10006x == mVar.f10006x && this.f10007y == mVar.f10007y && this.f9994l == mVar.f9994l && this.f10008z == mVar.f10008z && af.a((Object) this.f9985c, (Object) mVar.f9985c) && af.a((Object) this.A, (Object) mVar.A) && this.B == mVar.B && af.a((Object) this.f9989g, (Object) mVar.f9989g) && af.a((Object) this.f9990h, (Object) mVar.f9990h) && af.a((Object) this.f9987e, (Object) mVar.f9987e) && af.a(this.f9993k, mVar.f9993k) && af.a(this.f9988f, mVar.f9988f) && af.a(this.f10002t, mVar.f10002t) && Arrays.equals(this.f10001s, mVar.f10001s) && b(mVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.C == 0) {
            String str = this.f9985c;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.f9989g;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f9990h;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9987e;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f9986d) * 31) + this.f9995m) * 31) + this.f9996n) * 31) + this.f10003u) * 31) + this.f10004v) * 31;
            String str5 = this.A;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.B) * 31;
            com.anythink.expressad.exoplayer.d.e eVar = this.f9993k;
            int iHashCode6 = (iHashCode5 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            com.anythink.expressad.exoplayer.g.a aVar = this.f9988f;
            this.C = iHashCode6 + (aVar != null ? aVar.hashCode() : 0);
        }
        return this.C;
    }

    public final String toString() {
        return "Format(" + this.f9985c + ", " + this.f9989g + ", " + this.f9990h + ", " + this.f9986d + ", " + this.A + ", [" + this.f9995m + ", " + this.f9996n + ", " + this.f9997o + "], [" + this.f10003u + ", " + this.f10004v + "])";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9985c);
        parcel.writeString(this.f9989g);
        parcel.writeString(this.f9990h);
        parcel.writeString(this.f9987e);
        parcel.writeInt(this.f9986d);
        parcel.writeInt(this.f9991i);
        parcel.writeInt(this.f9995m);
        parcel.writeInt(this.f9996n);
        parcel.writeFloat(this.f9997o);
        parcel.writeInt(this.f9998p);
        parcel.writeFloat(this.f9999q);
        af.a(parcel, this.f10001s != null);
        byte[] bArr = this.f10001s;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f10000r);
        parcel.writeParcelable(this.f10002t, i2);
        parcel.writeInt(this.f10003u);
        parcel.writeInt(this.f10004v);
        parcel.writeInt(this.f10005w);
        parcel.writeInt(this.f10006x);
        parcel.writeInt(this.f10007y);
        parcel.writeInt(this.f10008z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
        parcel.writeLong(this.f9994l);
        int size = this.f9992j.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.f9992j.get(i3));
        }
        parcel.writeParcelable(this.f9993k, 0);
        parcel.writeParcelable(this.f9988f, 0);
    }

    public static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, @Nullable com.anythink.expressad.exoplayer.l.b bVar, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return new m(str, null, str2, str3, i2, i3, i4, i5, f2, i6, f3, bArr, i7, bVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, eVar, null);
    }

    private static m b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, int i3, @Nullable String str5) {
        return new m(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static String c(m mVar) {
        if (mVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(mVar.f9985c);
        sb.append(", mimeType=");
        sb.append(mVar.f9990h);
        if (mVar.f9986d != -1) {
            sb.append(", bitrate=");
            sb.append(mVar.f9986d);
        }
        if (mVar.f9995m != -1 && mVar.f9996n != -1) {
            sb.append(", res=");
            sb.append(mVar.f9995m);
            sb.append("x");
            sb.append(mVar.f9996n);
        }
        if (mVar.f9997o != -1.0f) {
            sb.append(", fps=");
            sb.append(mVar.f9997o);
        }
        if (mVar.f10003u != -1) {
            sb.append(", channels=");
            sb.append(mVar.f10003u);
        }
        if (mVar.f10004v != -1) {
            sb.append(", sample_rate=");
            sb.append(mVar.f10004v);
        }
        if (mVar.A != null) {
            sb.append(", language=");
            sb.append(mVar.A);
        }
        return sb.toString();
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, int i3, int i4, List<byte[]> list, int i5, @Nullable String str5) {
        return new m(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, -1, -1, -1, i5, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    private m b(int i2) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, this.f9991i, this.f9995m, this.f9996n, this.f9997o, i2, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, this.f10008z, this.A, this.B, this.f9994l, this.f9992j, this.f9993k, this.f9988f);
    }

    public static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar, @Nullable String str4) {
        return a(str, str2, str3, i2, i3, i4, -1, list, eVar, str4);
    }

    public final boolean b(m mVar) {
        if (this.f9992j.size() != mVar.f9992j.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f9992j.size(); i2++) {
            if (!Arrays.equals(this.f9992j.get(i2), mVar.f9992j.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar, @Nullable String str4) {
        return a(str, str2, str3, i2, i3, i4, i5, list, eVar, str4, null);
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar, @Nullable String str4, @Nullable com.anythink.expressad.exoplayer.g.a aVar) {
        return new m(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, eVar, aVar);
    }

    private static m a(@Nullable String str, String str2, int i2, @Nullable String str3, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return a(str, str2, (String) null, -1, i2, str3, -1, eVar, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, @Nullable String str4, int i4, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return a(str, str2, str3, i2, i3, str4, i4, eVar, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, @Nullable String str4, @Nullable com.anythink.expressad.exoplayer.d.e eVar, long j2) {
        return a(str, str2, str3, i2, i3, str4, -1, eVar, j2, (List<byte[]>) Collections.emptyList());
    }

    public static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, @Nullable String str4, int i4, @Nullable com.anythink.expressad.exoplayer.d.e eVar, long j2, List<byte[]> list) {
        return new m(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, i4, j2, list, eVar, null);
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, List<byte[]> list, @Nullable String str4, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return new m(str, null, str2, str3, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, -1, Long.MAX_VALUE, list, eVar, null);
    }

    public static m a(@Nullable String str, @Nullable String str2) {
        return new m(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return new m(str, null, str2, str3, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, eVar, null);
    }

    public final m a(int i2) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, i2, this.f9995m, this.f9996n, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, this.f10008z, this.A, this.B, this.f9994l, this.f9992j, this.f9993k, this.f9988f);
    }

    public final m a(long j2) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, this.f9991i, this.f9995m, this.f9996n, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, this.f10008z, this.A, this.B, j2, this.f9992j, this.f9993k, this.f9988f);
    }

    private m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, @Nullable String str4) {
        return new m(str, this.f9989g, str2, str3, i2, this.f9991i, i3, i4, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, i5, str4, this.B, this.f9994l, this.f9992j, this.f9993k, this.f9988f);
    }

    public final m a(m mVar) {
        if (this == mVar) {
            return this;
        }
        String str = mVar.f9985c;
        String str2 = this.f9987e;
        if (str2 == null) {
            str2 = mVar.f9987e;
        }
        String str3 = str2;
        int i2 = this.f9986d;
        if (i2 == -1) {
            i2 = mVar.f9986d;
        }
        int i3 = i2;
        float f2 = this.f9997o;
        if (f2 == -1.0f) {
            f2 = mVar.f9997o;
        }
        float f3 = f2;
        int i4 = this.f10008z | mVar.f10008z;
        String str4 = this.A;
        if (str4 == null) {
            str4 = mVar.A;
        }
        return new m(str, this.f9989g, this.f9990h, str3, i3, this.f9991i, this.f9995m, this.f9996n, f3, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, i4, str4, this.B, this.f9994l, this.f9992j, com.anythink.expressad.exoplayer.d.e.a(mVar.f9993k, this.f9993k), this.f9988f);
    }

    m(Parcel parcel) {
        this.f9985c = parcel.readString();
        this.f9989g = parcel.readString();
        this.f9990h = parcel.readString();
        this.f9987e = parcel.readString();
        this.f9986d = parcel.readInt();
        this.f9991i = parcel.readInt();
        this.f9995m = parcel.readInt();
        this.f9996n = parcel.readInt();
        this.f9997o = parcel.readFloat();
        this.f9998p = parcel.readInt();
        this.f9999q = parcel.readFloat();
        this.f10001s = af.a(parcel) ? parcel.createByteArray() : null;
        this.f10000r = parcel.readInt();
        this.f10002t = (com.anythink.expressad.exoplayer.l.b) parcel.readParcelable(com.anythink.expressad.exoplayer.l.b.class.getClassLoader());
        this.f10003u = parcel.readInt();
        this.f10004v = parcel.readInt();
        this.f10005w = parcel.readInt();
        this.f10006x = parcel.readInt();
        this.f10007y = parcel.readInt();
        this.f10008z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.f9994l = parcel.readLong();
        int i2 = parcel.readInt();
        this.f9992j = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.f9992j.add(parcel.createByteArray());
        }
        this.f9993k = (com.anythink.expressad.exoplayer.d.e) parcel.readParcelable(com.anythink.expressad.exoplayer.d.e.class.getClassLoader());
        this.f9988f = (com.anythink.expressad.exoplayer.g.a) parcel.readParcelable(com.anythink.expressad.exoplayer.g.a.class.getClassLoader());
    }

    public final m a(int i2, int i3) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, this.f9991i, this.f9995m, this.f9996n, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, i2, i3, this.f10008z, this.A, this.B, this.f9994l, this.f9992j, this.f9993k, this.f9988f);
    }

    public final m a(@Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, this.f9991i, this.f9995m, this.f9996n, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, this.f10008z, this.A, this.B, this.f9994l, this.f9992j, eVar, this.f9988f);
    }

    public final m a(@Nullable com.anythink.expressad.exoplayer.g.a aVar) {
        return new m(this.f9985c, this.f9989g, this.f9990h, this.f9987e, this.f9986d, this.f9991i, this.f9995m, this.f9996n, this.f9997o, this.f9998p, this.f9999q, this.f10001s, this.f10000r, this.f10002t, this.f10003u, this.f10004v, this.f10005w, this.f10006x, this.f10007y, this.f10008z, this.A, this.B, this.f9994l, this.f9992j, this.f9993k, aVar);
    }

    public final int a() {
        int i2;
        int i3 = this.f9995m;
        if (i3 == -1 || (i2 = this.f9996n) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, @Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        return a(str, str2, str3, i2, i3, i4, i5, f2, list, -1, -1.0f, null, -1, null, eVar);
    }

    private static m a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, int i3, @Nullable String str5) {
        return new m(str, str2, str3, str4, i2, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    private static m a(@Nullable String str, String str2, int i2, @Nullable String str3) {
        return a(str, str2, (String) null, -1, i2, str3, -1, (com.anythink.expressad.exoplayer.d.e) null, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }
}
