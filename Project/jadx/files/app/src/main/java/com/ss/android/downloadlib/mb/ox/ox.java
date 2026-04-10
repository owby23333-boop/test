package com.ss.android.downloadlib.mb.ox;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements Parcelable {
    public static final Parcelable.Creator<ox> CREATOR = new Parcelable.Creator<ox>() { // from class: com.ss.android.downloadlib.mb.ox.ox.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public ox createFromParcel(Parcel parcel) {
            return new ox(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public ox[] newArray(int i2) {
            return new ox[i2];
        }
    };
    public String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18036h;
    public int hj;
    public int mb;
    public int ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18037u;

    public ox() {
        this.b = "";
        this.f18036h = "";
        this.f18037u = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ox.class == obj.getClass()) {
            ox oxVar = (ox) obj;
            if (this.mb == oxVar.mb && this.ox == oxVar.ox) {
                String str = this.b;
                if (str != null) {
                    return str.equals(oxVar.b);
                }
                if (oxVar.b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.mb * 31) + this.ox) * 31;
        String str = this.b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mb);
        parcel.writeInt(this.ox);
        parcel.writeString(this.b);
        parcel.writeString(this.f18036h);
        parcel.writeString(this.f18037u);
        parcel.writeInt(this.hj);
    }

    protected ox(Parcel parcel) {
        this.b = "";
        this.f18036h = "";
        this.f18037u = "";
        this.mb = parcel.readInt();
        this.ox = parcel.readInt();
        this.b = parcel.readString();
        this.f18036h = parcel.readString();
        this.f18037u = parcel.readString();
        this.hj = parcel.readInt();
    }
}
