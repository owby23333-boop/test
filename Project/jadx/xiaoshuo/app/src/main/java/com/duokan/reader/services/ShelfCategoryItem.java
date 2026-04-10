package com.duokan.reader.services;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ShelfCategoryItem extends ShelfBaseItem {
    public static final Parcelable.Creator<ShelfCategoryItem> CREATOR = new a();
    public List<ShelfBookItem> c;

    public class a implements Parcelable.Creator<ShelfCategoryItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShelfCategoryItem createFromParcel(Parcel parcel) {
            return new ShelfCategoryItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ShelfCategoryItem[] newArray(int i) {
            return new ShelfCategoryItem[i];
        }
    }

    @Override // com.duokan.reader.services.ShelfBaseItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.duokan.reader.services.ShelfBaseItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedArray((ShelfBookItem[]) this.c.toArray(new ShelfBookItem[0]), i);
    }

    public ShelfCategoryItem(List<ShelfBookItem> list, String str, Long l) {
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
        linkedList.addAll(list);
        this.f5225a = str;
        this.f5226b = l.longValue();
    }

    public ShelfCategoryItem(Parcel parcel) {
        super(parcel);
        this.c = new LinkedList();
        try {
            for (ShelfBaseItem shelfBaseItem : (ShelfBaseItem[]) parcel.createTypedArray(ShelfBaseItem.CREATOR)) {
                this.c.add((ShelfBookItem) shelfBaseItem);
            }
        } catch (Exception unused) {
        }
    }
}
