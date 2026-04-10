package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bu implements Parcelable {
    public static final String a = "MD5";
    public static final Parcelable.Creator<bu> b = new bv();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f12962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f12963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12968i;

    /* synthetic */ bu(Parcel parcel, bv bvVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f12968i == 1);
    }

    public double b() {
        return this.f12963d;
    }

    public String c() {
        return cn.a().c(this.f12964e);
    }

    public String d() {
        return this.f12965f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f12966g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f12967h == 1);
    }

    public String toString() {
        return this.f12962c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f12965f);
        parcel.writeInt(this.f12968i);
        parcel.writeString(this.f12964e);
        parcel.writeDouble(this.f12963d);
        parcel.writeString(this.f12966g);
        parcel.writeInt(this.f12967h);
    }

    public bu(String str) {
        try {
            this.f12962c = new JSONObject(str);
            this.f12963d = this.f12962c.getDouble("version");
            this.f12964e = this.f12962c.getString("url");
            this.f12965f = this.f12962c.getString("sign");
            this.f12968i = 1;
            this.f12966g = "";
            this.f12967h = 0;
        } catch (JSONException unused) {
            this.f12968i = 0;
        }
        this.f12968i = c() == null ? 0 : 1;
    }

    public bu(bu buVar, String str, Boolean bool) {
        this.f12963d = buVar.b();
        this.f12964e = buVar.c();
        this.f12965f = buVar.d();
        this.f12968i = buVar.a().booleanValue() ? 1 : 0;
        this.f12966g = str;
        this.f12967h = bool.booleanValue() ? 1 : 0;
    }

    private bu(Parcel parcel) {
        this.f12965f = parcel.readString();
        this.f12968i = parcel.readInt();
        this.f12964e = parcel.readString();
        this.f12963d = parcel.readDouble();
        this.f12966g = parcel.readString();
        this.f12967h = parcel.readInt();
    }
}
