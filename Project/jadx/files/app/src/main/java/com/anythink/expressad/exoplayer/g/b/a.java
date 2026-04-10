package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.b.a.1
        private static a a(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i2) {
            return new a[i2];
        }

        private static a[] a(int i2) {
            return new a[i2];
        }
    };
    public static final String a = "APIC";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f9079e;

    public a(String str, String str2, int i2, byte[] bArr) {
        super(a);
        this.b = str;
        this.f9077c = str2;
        this.f9078d = i2;
        this.f9079e = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f9078d == aVar.f9078d && af.a((Object) this.b, (Object) aVar.b) && af.a((Object) this.f9077c, (Object) aVar.f9077c) && Arrays.equals(this.f9079e, aVar.f9079e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.f9078d + 527) * 31;
        String str = this.b;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9077c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f9079e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.f9110g + ": mimeType=" + this.b + ", description=" + this.f9077c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.f9077c);
        parcel.writeInt(this.f9078d);
        parcel.writeByteArray(this.f9079e);
    }

    a(Parcel parcel) {
        super(a);
        this.b = parcel.readString();
        this.f9077c = parcel.readString();
        this.f9078d = parcel.readInt();
        this.f9079e = parcel.createByteArray();
    }
}
