package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };
    public long a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f18398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f18401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f18405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f18406s;

    public UserInfoBean() {
        this.f18398k = 0L;
        this.f18399l = false;
        this.f18400m = "unknown";
        this.f18403p = -1;
        this.f18404q = -1;
        this.f18405r = null;
        this.f18406s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f18390c);
        parcel.writeString(this.f18391d);
        parcel.writeLong(this.f18392e);
        parcel.writeLong(this.f18393f);
        parcel.writeLong(this.f18394g);
        parcel.writeLong(this.f18395h);
        parcel.writeLong(this.f18396i);
        parcel.writeString(this.f18397j);
        parcel.writeLong(this.f18398k);
        parcel.writeByte(this.f18399l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f18400m);
        parcel.writeInt(this.f18403p);
        parcel.writeInt(this.f18404q);
        ap.b(parcel, this.f18405r);
        ap.b(parcel, this.f18406s);
        parcel.writeString(this.f18401n);
        parcel.writeInt(this.f18402o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f18398k = 0L;
        this.f18399l = false;
        this.f18400m = "unknown";
        this.f18403p = -1;
        this.f18404q = -1;
        this.f18405r = null;
        this.f18406s = null;
        this.b = parcel.readInt();
        this.f18390c = parcel.readString();
        this.f18391d = parcel.readString();
        this.f18392e = parcel.readLong();
        this.f18393f = parcel.readLong();
        this.f18394g = parcel.readLong();
        this.f18395h = parcel.readLong();
        this.f18396i = parcel.readLong();
        this.f18397j = parcel.readString();
        this.f18398k = parcel.readLong();
        this.f18399l = parcel.readByte() == 1;
        this.f18400m = parcel.readString();
        this.f18403p = parcel.readInt();
        this.f18404q = parcel.readInt();
        this.f18405r = ap.b(parcel);
        this.f18406s = ap.b(parcel);
        this.f18401n = parcel.readString();
        this.f18402o = parcel.readInt();
    }
}
