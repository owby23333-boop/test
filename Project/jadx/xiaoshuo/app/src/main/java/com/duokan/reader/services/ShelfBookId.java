package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ShelfBookId implements Parcelable {
    public static final Parcelable.Creator<ShelfBookId> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5228b;

    public class a implements Parcelable.Creator<ShelfBookId> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShelfBookId createFromParcel(Parcel parcel) {
            return new ShelfBookId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShelfBookId[] newArray(int i) {
            return new ShelfBookId[i];
        }
    }

    public ShelfBookId(String str, String str2) {
        this.f5227a = "-1";
        this.f5228b = "-1";
        this.f5227a = TextUtils.isEmpty(str) ? "-1" : str;
        this.f5228b = TextUtils.isEmpty(str2) ? "-1" : str2;
    }

    public static ShelfBookId f() {
        return new ShelfBookId("-1", "-1");
    }

    public String a() {
        return this.f5228b;
    }

    public String b() {
        return this.f5227a;
    }

    public String c() {
        return !TextUtils.equals(this.f5227a, "-1") ? this.f5227a : !TextUtils.equals(this.f5228b, "-1") ? this.f5228b : "-1";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean g(ShelfBookId shelfBookId) {
        return (!TextUtils.equals(this.f5227a, "-1") && TextUtils.equals(this.f5227a, shelfBookId.f5227a)) || (!TextUtils.equals(this.f5228b, "-1") && TextUtils.equals(this.f5228b, shelfBookId.f5228b));
    }

    public boolean h(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty("-1")) {
            return false;
        }
        return TextUtils.equals(this.f5227a, str) || TextUtils.equals(this.f5228b, str);
    }

    public boolean i() {
        return (TextUtils.equals(this.f5227a, "-1") && TextUtils.equals(this.f5228b, "-1")) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5227a);
        parcel.writeString(this.f5228b);
    }

    public ShelfBookId(Parcel parcel) {
        this.f5227a = "-1";
        this.f5228b = "-1";
        this.f5227a = parcel.readString();
        this.f5228b = parcel.readString();
    }
}
