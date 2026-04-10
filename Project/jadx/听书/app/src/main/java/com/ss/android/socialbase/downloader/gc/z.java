package com.ss.android.socialbase.downloader.gc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class z extends Exception implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new Parcelable.Creator<z>() { // from class: com.ss.android.socialbase.downloader.gc.z.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i) {
            return new z[i];
        }
    };
    private String dl;
    private String g;
    private int z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public z() {
        this.dl = "";
    }

    public z(int i, String str) {
        super("[d-ex]:".concat(String.valueOf(str)));
        this.dl = "";
        this.g = "[d-ex]:".concat(String.valueOf(str));
        this.z = i;
    }

    public void z(String str) {
        this.g = str;
    }

    public z(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.pf.m.uy(th));
    }

    protected z(Parcel parcel) {
        this.dl = "";
        z(parcel);
    }

    public void z(Parcel parcel) {
        this.z = parcel.readInt();
        this.g = parcel.readString();
        this.dl = parcel.readString();
    }

    public int z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public void g(String str) {
        this.dl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.z);
        parcel.writeString(this.g);
        parcel.writeString(this.dl);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.z + ", errorMsg='" + this.g + "'}";
    }
}
