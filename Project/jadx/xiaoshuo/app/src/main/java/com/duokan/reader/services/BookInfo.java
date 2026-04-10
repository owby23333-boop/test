package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class BookInfo implements Parcelable {
    public static final Parcelable.Creator<BookInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5218b;
    public String c;
    public float d;
    public float e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public long k;
    public int l;

    public class a implements Parcelable.Creator<BookInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BookInfo createFromParcel(Parcel parcel) {
            return new BookInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BookInfo[] newArray(int i) {
            return new BookInfo[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5217a);
        parcel.writeString(this.f5218b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.i);
        parcel.writeString(this.h);
        parcel.writeString(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
    }

    public BookInfo(Parcel parcel) {
        this.f5217a = parcel.readString();
        this.f5218b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.i = parcel.readString();
        this.h = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readLong();
        this.l = parcel.readInt();
    }

    public BookInfo(String str, String str2, String str3, float f, float f2, int i, String str4, String str5, String str6, String str7, long j, int i2) {
        this.f5217a = str;
        this.f5218b = str2;
        this.c = str3;
        this.d = f;
        this.e = f2;
        this.f = i;
        this.g = str4;
        this.i = str5;
        this.h = str6;
        this.j = str7;
        this.k = j;
        this.l = i2;
    }

    public BookInfo(ShelfBookItem shelfBookItem) {
        this.f5217a = shelfBookItem.f5225a;
        this.f5218b = shelfBookItem.c.c();
        this.d = shelfBookItem.e;
        this.e = shelfBookItem.f;
        this.f = shelfBookItem.g;
        this.g = shelfBookItem.h;
        this.i = shelfBookItem.j;
        this.h = shelfBookItem.i;
        this.j = shelfBookItem.k;
        this.k = shelfBookItem.f5226b;
        this.l = shelfBookItem.l;
    }

    public BookInfo(BookInfo bookInfo) {
        this.f5217a = bookInfo.f5217a;
        this.f5218b = bookInfo.f5218b;
        this.d = bookInfo.d;
        this.e = bookInfo.e;
        this.f = bookInfo.f;
        this.g = bookInfo.g;
        this.i = bookInfo.i;
        this.h = bookInfo.h;
        this.j = bookInfo.j;
        this.k = bookInfo.k;
        this.l = bookInfo.l;
    }
}
