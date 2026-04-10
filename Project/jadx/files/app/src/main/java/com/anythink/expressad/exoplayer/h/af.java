package com.anythink.expressad.exoplayer.h;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class af implements Parcelable {
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ae[] f9238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9239d;
    public static final af a = new af(new ae[0]);
    public static final Parcelable.Creator<af> CREATOR = new Parcelable.Creator<af>() { // from class: com.anythink.expressad.exoplayer.h.af.1
        private static af a(Parcel parcel) {
            return new af(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ af createFromParcel(Parcel parcel) {
            return new af(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ af[] newArray(int i2) {
            return new af[i2];
        }

        private static af[] a(int i2) {
            return new af[i2];
        }
    };

    public af(ae... aeVarArr) {
        this.f9238c = aeVarArr;
        this.b = aeVarArr.length;
    }

    public final ae a(int i2) {
        return this.f9238c[i2];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && af.class == obj.getClass()) {
            af afVar = (af) obj;
            if (this.b == afVar.b && Arrays.equals(this.f9238c, afVar.f9238c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9239d == 0) {
            this.f9239d = Arrays.hashCode(this.f9238c);
        }
        return this.f9239d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        for (int i3 = 0; i3 < this.b; i3++) {
            parcel.writeParcelable(this.f9238c[i3], 0);
        }
    }

    public final int a(ae aeVar) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.f9238c[i2] == aeVar) {
                return i2;
            }
        }
        return -1;
    }

    af(Parcel parcel) {
        this.b = parcel.readInt();
        this.f9238c = new ae[this.b];
        for (int i2 = 0; i2 < this.b; i2++) {
            this.f9238c[i2] = (ae) parcel.readParcelable(ae.class.getClassLoader());
        }
    }

    private boolean a() {
        return this.b == 0;
    }
}
