package com.duokan.free.tts.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes15.dex */
public enum TtsTone implements Parcelable {
    AI_Male("XiaoMi_M88"),
    AI_Female("XiaoMi");

    public static final Parcelable.Creator<TtsTone> CREATOR = new Parcelable.Creator<TtsTone>() { // from class: com.duokan.free.tts.data.TtsTone.a
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TtsTone createFromParcel(Parcel parcel) {
            return TtsTone.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TtsTone[] newArray(int i) {
            return new TtsTone[i];
        }
    };
    private final String mTone;

    TtsTone(String str) {
        this.mTone = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTone() {
        return this.mTone;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
