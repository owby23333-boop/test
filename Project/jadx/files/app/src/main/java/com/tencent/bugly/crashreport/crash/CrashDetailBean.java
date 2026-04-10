package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i2) {
            return new CrashDetailBean[i2];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;
    public long a;
    public String aa;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f18434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f18435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f18440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f18441o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f18442p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f18443q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f18444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f18445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18446t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18447u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f18448v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f18449w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f18450x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public byte[] f18451y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map<String, String> f18452z;

    public CrashDetailBean() {
        this.a = -1L;
        this.b = 0;
        this.f18429c = UUID.randomUUID().toString();
        this.f18430d = false;
        this.f18431e = "";
        this.f18432f = "";
        this.f18433g = "";
        this.f18434h = null;
        this.f18435i = null;
        this.f18436j = false;
        this.f18437k = false;
        this.f18438l = 0;
        this.f18439m = "";
        this.f18440n = "";
        this.f18441o = "";
        this.f18442p = "";
        this.f18443q = "";
        this.f18444r = -1L;
        this.f18445s = null;
        this.f18446t = 0;
        this.f18447u = "";
        this.f18448v = "";
        this.f18449w = null;
        this.f18450x = null;
        this.f18451y = null;
        this.f18452z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j2 = this.f18444r - crashDetailBean2.f18444r;
        if (j2 <= 0) {
            return j2 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f18429c);
        parcel.writeByte(this.f18430d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f18431e);
        parcel.writeString(this.f18432f);
        parcel.writeString(this.f18433g);
        parcel.writeByte(this.f18436j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18437k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f18438l);
        parcel.writeString(this.f18439m);
        parcel.writeString(this.f18440n);
        parcel.writeString(this.f18441o);
        parcel.writeString(this.f18442p);
        parcel.writeString(this.f18443q);
        parcel.writeLong(this.f18444r);
        parcel.writeString(this.f18445s);
        parcel.writeInt(this.f18446t);
        parcel.writeString(this.f18447u);
        parcel.writeString(this.f18448v);
        parcel.writeString(this.f18449w);
        ap.b(parcel, this.f18452z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f18434h);
        ap.a(parcel, this.f18435i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f18451y);
        parcel.writeString(this.Z);
        parcel.writeString(this.aa);
        parcel.writeString(this.f18450x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }

    public CrashDetailBean(Parcel parcel) {
        this.a = -1L;
        this.b = 0;
        this.f18429c = UUID.randomUUID().toString();
        this.f18430d = false;
        this.f18431e = "";
        this.f18432f = "";
        this.f18433g = "";
        this.f18434h = null;
        this.f18435i = null;
        this.f18436j = false;
        this.f18437k = false;
        this.f18438l = 0;
        this.f18439m = "";
        this.f18440n = "";
        this.f18441o = "";
        this.f18442p = "";
        this.f18443q = "";
        this.f18444r = -1L;
        this.f18445s = null;
        this.f18446t = 0;
        this.f18447u = "";
        this.f18448v = "";
        this.f18449w = null;
        this.f18450x = null;
        this.f18451y = null;
        this.f18452z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.b = parcel.readInt();
        this.f18429c = parcel.readString();
        this.f18430d = parcel.readByte() == 1;
        this.f18431e = parcel.readString();
        this.f18432f = parcel.readString();
        this.f18433g = parcel.readString();
        this.f18436j = parcel.readByte() == 1;
        this.f18437k = parcel.readByte() == 1;
        this.f18438l = parcel.readInt();
        this.f18439m = parcel.readString();
        this.f18440n = parcel.readString();
        this.f18441o = parcel.readString();
        this.f18442p = parcel.readString();
        this.f18443q = parcel.readString();
        this.f18444r = parcel.readLong();
        this.f18445s = parcel.readString();
        this.f18446t = parcel.readInt();
        this.f18447u = parcel.readString();
        this.f18448v = parcel.readString();
        this.f18449w = parcel.readString();
        this.f18452z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f18434h = ap.a(parcel);
        this.f18435i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f18451y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.f18450x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }
}
