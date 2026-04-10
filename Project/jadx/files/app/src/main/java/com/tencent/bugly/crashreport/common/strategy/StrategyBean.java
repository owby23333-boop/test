package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };
    public static String a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f18408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f18420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f18421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f18422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f18423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f18424s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, String> f18425t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18426u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f18427v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f18428w;

    public StrategyBean() {
        this.f18409d = -1L;
        this.f18410e = -1L;
        this.f18411f = true;
        this.f18412g = true;
        this.f18413h = true;
        this.f18414i = true;
        this.f18415j = false;
        this.f18416k = true;
        this.f18417l = true;
        this.f18418m = true;
        this.f18419n = true;
        this.f18421p = 30000L;
        this.f18422q = a;
        this.f18423r = b;
        this.f18426u = 10;
        this.f18427v = 300000L;
        this.f18428w = -1L;
        this.f18410e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        f18408c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.f18424s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f18410e);
        parcel.writeByte(this.f18411f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18412g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18413h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f18422q);
        parcel.writeString(this.f18423r);
        parcel.writeString(this.f18424s);
        ap.b(parcel, this.f18425t);
        parcel.writeByte(this.f18414i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18415j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18418m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18419n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f18421p);
        parcel.writeByte(this.f18416k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f18417l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f18420o);
        parcel.writeInt(this.f18426u);
        parcel.writeLong(this.f18427v);
        parcel.writeLong(this.f18428w);
    }

    public StrategyBean(Parcel parcel) {
        this.f18409d = -1L;
        this.f18410e = -1L;
        boolean z2 = true;
        this.f18411f = true;
        this.f18412g = true;
        this.f18413h = true;
        this.f18414i = true;
        this.f18415j = false;
        this.f18416k = true;
        this.f18417l = true;
        this.f18418m = true;
        this.f18419n = true;
        this.f18421p = 30000L;
        this.f18422q = a;
        this.f18423r = b;
        this.f18426u = 10;
        this.f18427v = 300000L;
        this.f18428w = -1L;
        try {
            f18408c = "S(@L@L@)";
            this.f18410e = parcel.readLong();
            this.f18411f = parcel.readByte() == 1;
            this.f18412g = parcel.readByte() == 1;
            this.f18413h = parcel.readByte() == 1;
            this.f18422q = parcel.readString();
            this.f18423r = parcel.readString();
            this.f18424s = parcel.readString();
            this.f18425t = ap.b(parcel);
            this.f18414i = parcel.readByte() == 1;
            this.f18415j = parcel.readByte() == 1;
            this.f18418m = parcel.readByte() == 1;
            this.f18419n = parcel.readByte() == 1;
            this.f18421p = parcel.readLong();
            this.f18416k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z2 = false;
            }
            this.f18417l = z2;
            this.f18420o = parcel.readLong();
            this.f18426u = parcel.readInt();
            this.f18427v = parcel.readLong();
            this.f18428w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
