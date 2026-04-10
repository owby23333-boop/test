package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.g.b.e.1
        private static e a(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ e[] newArray(int i2) {
            return new e[i2];
        }

        private static e[] a(int i2) {
            return new e[i2];
        }
    };
    public static final String a = "COMM";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9090d;

    public e(String str, String str2, String str3) {
        super(a);
        this.b = str;
        this.f9089c = str2;
        this.f9090d = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (af.a((Object) this.f9089c, (Object) eVar.f9089c) && af.a((Object) this.b, (Object) eVar.b) && af.a((Object) this.f9090d, (Object) eVar.f9090d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f9089c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9090d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.f9110g + ": language=" + this.b + ", description=" + this.f9089c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9110g);
        parcel.writeString(this.b);
        parcel.writeString(this.f9090d);
    }

    e(Parcel parcel) {
        super(a);
        this.b = parcel.readString();
        this.f9089c = parcel.readString();
        this.f9090d = parcel.readString();
    }
}
