package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new Parcelable.Creator<k>() { // from class: com.anythink.expressad.exoplayer.g.b.k.1
        private static k a(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ k[] newArray(int i2) {
            return new k[i2];
        }

        private static k[] a(int i2) {
            return new k[i2];
        }
    };
    public final String a;
    public final String b;

    public k(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (this.f9110g.equals(kVar.f9110g) && af.a((Object) this.a, (Object) kVar.a) && af.a((Object) this.b, (Object) kVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f9110g.hashCode() + 527) * 31;
        String str = this.a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.f9110g + ": value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9110g);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    k(Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
