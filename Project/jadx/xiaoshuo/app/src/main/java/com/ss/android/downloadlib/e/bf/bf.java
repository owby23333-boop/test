package com.ss.android.downloadlib.e.bf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class bf implements Parcelable {
    public static final Parcelable.Creator<bf> CREATOR = new Parcelable.Creator<bf>() { // from class: com.ss.android.downloadlib.e.bf.bf.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public bf createFromParcel(Parcel parcel) {
            return new bf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public bf[] newArray(int i) {
            return new bf[i];
        }
    };
    public int bf;
    public String d;
    public int e;
    public String ga;
    public int tg;
    public String vn;

    public bf() {
        this.d = "";
        this.ga = "";
        this.vn = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bf bfVar = (bf) obj;
            if (this.e == bfVar.e && this.bf == bfVar.bf) {
                String str = this.d;
                if (str != null) {
                    return str.equals(bfVar.d);
                }
                if (bfVar.d == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.e * 31) + this.bf) * 31;
        String str = this.d;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeInt(this.bf);
        parcel.writeString(this.d);
        parcel.writeString(this.ga);
        parcel.writeString(this.vn);
        parcel.writeInt(this.tg);
    }

    public bf(Parcel parcel) {
        this.d = "";
        this.ga = "";
        this.vn = "";
        this.e = parcel.readInt();
        this.bf = parcel.readInt();
        this.d = parcel.readString();
        this.ga = parcel.readString();
        this.vn = parcel.readString();
        this.tg = parcel.readInt();
    }
}
