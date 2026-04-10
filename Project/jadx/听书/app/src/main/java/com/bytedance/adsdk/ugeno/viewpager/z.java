package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Parcelable {
    private final Parcelable g;
    public static final z z = new z() { // from class: com.bytedance.adsdk.ugeno.viewpager.z.1
    };
    public static final Parcelable.Creator<z> CREATOR = new Parcelable.ClassLoaderCreator<z>() { // from class: com.bytedance.adsdk.ugeno.viewpager.z.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return z.z;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i) {
            return new z[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private z() {
        this.g = null;
    }

    protected z(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.g = parcelable == z ? null : parcelable;
    }

    protected z(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.g = parcelable == null ? z : parcelable;
    }

    public final Parcelable z() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.g, i);
    }
}
