package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class ShelfBaseItem implements Parcelable {
    public static final Parcelable.Creator<ShelfBaseItem> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5226b;

    public class a implements Parcelable.Creator<ShelfBaseItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShelfBaseItem createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            return ShelfBookItem.class.getName().equals(string) ? ShelfBookItem.CREATOR.createFromParcel(parcel) : ShelfCategoryItem.class.getName().equals(string) ? ShelfCategoryItem.CREATOR.createFromParcel(parcel) : new ShelfBaseItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShelfBaseItem[] newArray(int i) {
            return new ShelfBaseItem[i];
        }
    }

    public ShelfBaseItem() {
        this.f5226b = 0L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.f5225a);
        parcel.writeLong(this.f5226b);
    }

    public ShelfBaseItem(Parcel parcel) {
        this.f5226b = 0L;
        this.f5225a = parcel.readString();
        this.f5226b = parcel.readLong();
    }
}
