package com.ss.android.downloadlib.z.z;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.ss.android.downloadlib.z.z.g.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2022a;
    public String dl;
    public int g;
    public String gc;
    public String m;
    public int z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public g() {
        this.dl = "";
        this.gc = "";
        this.m = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.z);
        parcel.writeInt(this.g);
        parcel.writeString(this.dl);
        parcel.writeString(this.gc);
        parcel.writeString(this.m);
        parcel.writeInt(this.f2022a);
    }

    protected g(Parcel parcel) {
        this.dl = "";
        this.gc = "";
        this.m = "";
        this.z = parcel.readInt();
        this.g = parcel.readInt();
        this.dl = parcel.readString();
        this.gc = parcel.readString();
        this.m = parcel.readString();
        this.f2022a = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            if (this.z == gVar.z && this.g == gVar.g) {
                String str = this.dl;
                if (str != null) {
                    return str.equals(gVar.dl);
                }
                if (gVar.dl == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.z * 31) + this.g) * 31;
        String str = this.dl;
        return i + (str != null ? str.hashCode() : 0);
    }
}
