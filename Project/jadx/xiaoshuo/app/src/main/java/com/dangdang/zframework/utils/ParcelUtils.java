package com.dangdang.zframework.utils;

import android.os.Parcel;

/* JADX INFO: loaded from: classes10.dex */
public class ParcelUtils {
    public static boolean readBooleanFromParcel(Parcel parcel) {
        return parcel.readInt() > 0;
    }

    public static void writeBooleanToParcel(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
