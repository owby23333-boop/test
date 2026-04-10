package com.bytedance.pangle.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new Parcelable.Creator<z>() { // from class: com.bytedance.pangle.servermanager.z.1
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
    private final IBinder z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    z(Parcel parcel) {
        this.z = parcel.readStrongBinder();
    }

    z(IBinder iBinder) {
        this.z = iBinder;
    }

    public IBinder z() {
        return this.z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.z);
    }
}
