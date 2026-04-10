package com.duokan.reader.services;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class ShelfBookItem extends ShelfBaseItem {
    public static final int A = 5;
    public static final Parcelable.Creator<ShelfBookItem> CREATOR = new a();
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 4;
    public ShelfBookId c;
    public String d;
    public float e;
    public float f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public long q;

    public class a implements Parcelable.Creator<ShelfBookItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShelfBookItem createFromParcel(Parcel parcel) {
            return new ShelfBookItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShelfBookItem[] newArray(int i) {
            return new ShelfBookItem[i];
        }
    }

    @Override // com.duokan.reader.services.ShelfBaseItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.duokan.reader.services.ShelfBaseItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.c, 0);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.j);
        parcel.writeString(this.i);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeLong(this.q);
    }

    @TargetApi(23)
    public ShelfBookItem(Parcel parcel) {
        super(parcel);
        this.m = 0;
        this.c = (ShelfBookId) parcel.readParcelable(ShelfBookId.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
        this.f = parcel.readFloat();
        this.g = parcel.readInt();
        this.h = parcel.readString();
        this.j = parcel.readString();
        this.i = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readLong();
    }

    public ShelfBookItem(String str, ShelfBookId shelfBookId, String str2, float f, float f2, int i, String str3, String str4, String str5, String str6, long j, int i2, int i3, float f3, int i4, int i5, long j2) {
        this.f5225a = str;
        this.c = shelfBookId;
        this.d = str2;
        this.e = f;
        this.f = f2;
        this.g = i;
        this.h = str3;
        this.j = str4;
        this.i = str5;
        this.k = str6;
        this.f5226b = j;
        this.l = i2;
        this.m = i3;
        this.n = f3;
        this.o = i4;
        this.p = i5;
        this.q = j2;
    }

    public ShelfBookItem(ShelfBookItem shelfBookItem) {
        this.m = 0;
        this.f5225a = shelfBookItem.f5225a;
        this.c = shelfBookItem.c;
        this.e = shelfBookItem.e;
        this.f = shelfBookItem.f;
        this.g = shelfBookItem.g;
        this.h = shelfBookItem.h;
        this.j = shelfBookItem.j;
        this.i = shelfBookItem.i;
        this.k = shelfBookItem.k;
        this.f5226b = shelfBookItem.f5226b;
        this.l = shelfBookItem.l;
        this.m = shelfBookItem.m;
        this.n = shelfBookItem.n;
        this.o = shelfBookItem.o;
        this.p = shelfBookItem.p;
        this.q = shelfBookItem.q;
    }
}
