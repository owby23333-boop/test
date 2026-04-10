package com.duokan.reader.services;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.yuewen.o94;

/* JADX INFO: loaded from: classes4.dex */
public class LoginAccountInfo implements Parcelable {
    public static final Parcelable.Creator<LoginAccountInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o94 f5223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5224b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;

    public class a implements Parcelable.Creator<LoginAccountInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginAccountInfo createFromParcel(Parcel parcel) {
            o94 o94Var = new o94();
            o94Var.f15234a = parcel.readString();
            o94Var.f15235b = parcel.readString();
            o94Var.c = parcel.readString();
            return new LoginAccountInfo(o94Var, parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LoginAccountInfo[] newArray(int i) {
            return new LoginAccountInfo[i];
        }
    }

    public LoginAccountInfo() {
        this(new o94(), "", 0, "", "", "", "", 0L, 0L, 0L, 0L);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("userId", this.f5223a.f15234a);
        bundle.putString("iconUrl", this.f5223a.c);
        bundle.putString("accountUuid", this.f5224b);
        bundle.putInt("accountType", this.c);
        bundle.putString("accountLoginName", this.d);
        bundle.putString("accountAliasName", this.e);
        bundle.putString("token", this.f);
        bundle.putString("signature", this.g);
        bundle.putLong("totalReadTime", this.h);
        bundle.putLong("totalCompletedBooks", this.i);
        bundle.putLong("totalBook", this.j);
        bundle.putLong("noteCount", this.k);
        return bundle;
    }

    public boolean b() {
        return TextUtils.isEmpty(this.f5224b) || TextUtils.isEmpty(this.f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5224b.equals(((LoginAccountInfo) obj).f5224b);
    }

    public int hashCode() {
        return this.f5224b.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5223a.f15234a);
        parcel.writeString(this.f5223a.f15235b);
        parcel.writeString(this.f5223a.c);
        parcel.writeString(this.f5224b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
    }

    public LoginAccountInfo(o94 o94Var, String str, int i, String str2, String str3, String str4, String str5, long j, long j2, long j3, long j4) {
        this.f5223a = o94Var;
        this.f5224b = str;
        this.c = i;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = j;
        this.i = j2;
        this.j = j3;
        this.k = j4;
    }

    public LoginAccountInfo(Bundle bundle) {
        o94 o94Var = new o94();
        this.f5223a = o94Var;
        o94Var.f15234a = bundle.getString("userId");
        o94Var.c = bundle.getString("iconUrl");
        o94Var.f15235b = bundle.getString("nickName");
        this.f5224b = bundle.getString("accountUuid");
        this.c = bundle.getInt("accountType");
        this.d = bundle.getString("accountLoginName");
        this.e = bundle.getString("accountAliasName");
        this.f = bundle.getString("token");
        this.g = bundle.getString("signature");
        this.h = bundle.getLong("totalReadTime");
        this.i = bundle.getLong("totalCompletedBooks");
        this.j = bundle.getLong("totalBook");
        this.k = bundle.getLong("noteCount");
    }
}
