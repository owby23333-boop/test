package com.anythink.expressad.exoplayer.h;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class ae implements Parcelable {
    public static final Parcelable.Creator<ae> CREATOR = new Parcelable.Creator<ae>() { // from class: com.anythink.expressad.exoplayer.h.ae.1
        private static ae a(Parcel parcel) {
            return new ae(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ae createFromParcel(Parcel parcel) {
            return new ae(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ae[] newArray(int i2) {
            return new ae[i2];
        }

        private static ae[] a(int i2) {
            return new ae[i2];
        }
    };
    public final int a;
    private final com.anythink.expressad.exoplayer.m[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9237c;

    public ae(com.anythink.expressad.exoplayer.m... mVarArr) {
        com.anythink.expressad.exoplayer.k.a.b(true);
        this.b = mVarArr;
        this.a = 1;
    }

    public final com.anythink.expressad.exoplayer.m a(int i2) {
        return this.b[i2];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ae.class == obj.getClass()) {
            ae aeVar = (ae) obj;
            if (this.a == aeVar.a && Arrays.equals(this.b, aeVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9237c == 0) {
            this.f9237c = Arrays.hashCode(this.b) + 527;
        }
        return this.f9237c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        for (int i3 = 0; i3 < this.a; i3++) {
            parcel.writeParcelable(this.b[i3], 0);
        }
    }

    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int i2 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.m[] mVarArr = this.b;
            if (i2 >= mVarArr.length) {
                return -1;
            }
            if (mVar == mVarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    ae(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = new com.anythink.expressad.exoplayer.m[this.a];
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2] = (com.anythink.expressad.exoplayer.m) parcel.readParcelable(com.anythink.expressad.exoplayer.m.class.getClassLoader());
        }
    }
}
