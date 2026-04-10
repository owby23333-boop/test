package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: com.anythink.expressad.exoplayer.g.b.i.1
        private static i a(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ i[] newArray(int i2) {
            return new i[i2];
        }

        private static i[] a(int i2) {
            return new i[i2];
        }
    };
    public static final String a = "----";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9112d;

    public i(String str, String str2, String str3) {
        super(a);
        this.b = str;
        this.f9111c = str2;
        this.f9112d = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (af.a((Object) this.f9111c, (Object) iVar.f9111c) && af.a((Object) this.b, (Object) iVar.b) && af.a((Object) this.f9112d, (Object) iVar.f9112d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f9111c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9112d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.f9110g + ": domain=" + this.b + ", description=" + this.f9111c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f9110g);
        parcel.writeString(this.b);
        parcel.writeString(this.f9112d);
    }

    i(Parcel parcel) {
        super(a);
        this.b = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.f9111c = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
        this.f9112d = (String) com.anythink.expressad.exoplayer.k.a.a(parcel.readString());
    }
}
