package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class d implements Parcelable, Comparable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.ss.android.socialbase.downloader.model.d.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    private final String bf;
    private final String e;

    public d(String str, String str2) {
        this.e = str;
        this.bf = str2;
    }

    public String bf() {
        return this.bf;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof d)) {
            return 1;
        }
        d dVar = (d) obj;
        if (TextUtils.equals(this.e, dVar.e())) {
            return 0;
        }
        String str = this.e;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(dVar.e());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return TextUtils.equals(this.e, dVar.e) && TextUtils.equals(this.bf, dVar.bf);
    }

    public int hashCode() {
        String str = this.e;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bf;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.e + "', value='" + this.bf + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.bf);
    }

    public d(Parcel parcel) {
        this.e = parcel.readString();
        this.bf = parcel.readString();
    }
}
