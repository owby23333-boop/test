package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
final class bv implements Parcelable.Creator<bu> {
    bv() {
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bu createFromParcel(Parcel parcel) {
        return new bu(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bu[] newArray(int i2) {
        return new bu[i2];
    }
}
