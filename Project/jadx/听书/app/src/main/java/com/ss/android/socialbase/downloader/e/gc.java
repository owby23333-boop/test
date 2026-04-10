package com.ss.android.socialbase.downloader.e;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements Parcelable, Comparable {
    public static final Parcelable.Creator<gc> CREATOR = new Parcelable.Creator<gc>() { // from class: com.ss.android.socialbase.downloader.e.gc.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public gc createFromParcel(Parcel parcel) {
            return new gc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public gc[] newArray(int i) {
            return new gc[i];
        }
    };
    private final String g;
    private final String z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public gc(String str, String str2) {
        this.z = str;
        this.g = str2;
    }

    protected gc(Parcel parcel) {
        this.z = parcel.readString();
        this.g = parcel.readString();
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.z);
        parcel.writeString(this.g);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof gc)) {
            return 1;
        }
        gc gcVar = (gc) obj;
        if (TextUtils.equals(this.z, gcVar.z())) {
            return 0;
        }
        String str = this.z;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(gcVar.z());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            gc gcVar = (gc) obj;
            if (TextUtils.equals(this.z, gcVar.z) && TextUtils.equals(this.g, gcVar.g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.z;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.g;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.z + "', value='" + this.g + "'}";
    }
}
