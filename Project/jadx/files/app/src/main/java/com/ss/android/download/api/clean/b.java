package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.download.api.clean.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };
    protected long b;
    boolean hj;
    private String mb;
    protected String ox;

    public b() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.ox);
        parcel.writeLong(this.b);
        parcel.writeString(this.mb);
        parcel.writeInt(this.hj ? 1 : 0);
    }

    b(Parcel parcel) {
        this.ox = parcel.readString();
        this.b = parcel.readLong();
        this.mb = parcel.readString();
        this.hj = parcel.readInt() == 1;
    }
}
