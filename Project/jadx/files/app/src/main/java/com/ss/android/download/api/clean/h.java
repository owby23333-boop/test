package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class h extends b implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: com.ss.android.download.api.clean.h.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i2) {
            return new h[i2];
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17927h;
    private String ko;
    private String mb;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f17928u;

    public h() {
        this.ko = "clean_file";
    }

    @Override // com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String mb() {
        return this.ko;
    }

    @Override // com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mb);
        parcel.writeString(this.f17927h);
        parcel.writeInt(this.f17928u ? 1 : 0);
        parcel.writeString(this.ko);
    }

    h(Parcel parcel) {
        this.ko = "clean_file";
        this.mb = parcel.readString();
        this.f17927h = parcel.readString();
        this.f17928u = parcel.readInt() == 1;
        this.ko = parcel.readString();
    }
}
