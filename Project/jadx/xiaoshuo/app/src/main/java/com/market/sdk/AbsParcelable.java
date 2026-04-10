package com.market.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsParcelable implements Parcelable {
    protected int version;

    public AbsParcelable() {
        this.version = 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
    }

    public AbsParcelable(Parcel parcel) {
        this.version = 1;
        this.version = parcel.readInt();
    }
}
