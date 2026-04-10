package com.ss.android.download.api.clean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class hj extends ox implements Parcelable {
    public static final Parcelable.Creator<hj> CREATOR = new Parcelable.Creator<hj>() { // from class: com.ss.android.download.api.clean.hj.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public hj createFromParcel(Parcel parcel) {
            return new hj(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public hj[] newArray(int i2) {
            return new hj[i2];
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f17929h;

    public hj() {
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h
    public String mb() {
        return "clean_app_cache";
    }

    @Override // com.ss.android.download.api.clean.ox, com.ss.android.download.api.clean.u, com.ss.android.download.api.clean.h, com.ss.android.download.api.clean.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17929h);
    }

    hj(Parcel parcel) {
        this.f17929h = parcel.readString();
    }
}
