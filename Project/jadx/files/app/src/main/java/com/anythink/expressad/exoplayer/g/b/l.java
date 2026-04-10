package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: com.anythink.expressad.exoplayer.g.b.l.1
        private static l a(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ l[] newArray(int i2) {
            return new l[i2];
        }

        private static l[] a(int i2) {
            return new l[i2];
        }
    };
    public final String a;
    public final String b;

    public l(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f9110g.equals(lVar.f9110g) && af.a((Object) this.a, (Object) lVar.a) && af.a((Object) this.b, (Object) lVar.b)) {
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
        return this.f9110g + ": url=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9110g);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    l(Parcel parcel) {
        super(parcel.readString());
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
