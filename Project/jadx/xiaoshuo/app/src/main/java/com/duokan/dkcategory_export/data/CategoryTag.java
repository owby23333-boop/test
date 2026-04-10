package com.duokan.dkcategory_export.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes13.dex */
public class CategoryTag implements Parcelable {
    public static final Parcelable.Creator<CategoryTag> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3346b;
    public Integer c;

    public class a implements Parcelable.Creator<CategoryTag> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CategoryTag createFromParcel(Parcel parcel) {
            return new CategoryTag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CategoryTag[] newArray(int i) {
            return new CategoryTag[i];
        }
    }

    public CategoryTag(String str, String str2) {
        this.f3345a = str;
        this.f3346b = str2;
    }

    public String a() {
        return this.f3346b;
    }

    public String b() {
        return this.f3345a;
    }

    public int c() {
        return this.c.intValue();
    }

    public void d(Parcel parcel) {
        this.f3345a = parcel.readString();
        this.f3346b = parcel.readString();
        this.c = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3345a);
        parcel.writeString(this.f3346b);
        parcel.writeValue(this.c);
    }

    public CategoryTag(String str, String str2, Integer num) {
        this(str, str2);
        this.c = num;
    }

    public CategoryTag(Parcel parcel) {
        this.f3345a = parcel.readString();
        this.f3346b = parcel.readString();
        this.c = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
