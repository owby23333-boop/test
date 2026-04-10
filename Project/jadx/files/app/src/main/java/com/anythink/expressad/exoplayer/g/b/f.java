package com.anythink.expressad.exoplayer.g.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.anythink.expressad.exoplayer.g.b.f.1
        private static f a(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ f[] newArray(int i2) {
            return new f[i2];
        }

        private static f[] a(int i2) {
            return new f[i2];
        }
    };
    public static final String a = "GEOB";
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f9093e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super(a);
        this.b = str;
        this.f9091c = str2;
        this.f9092d = str3;
        this.f9093e = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (af.a((Object) this.b, (Object) fVar.b) && af.a((Object) this.f9091c, (Object) fVar.f9091c) && af.a((Object) this.f9092d, (Object) fVar.f9092d) && Arrays.equals(this.f9093e, fVar.f9093e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f9091c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9092d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f9093e);
    }

    @Override // com.anythink.expressad.exoplayer.g.b.h
    public final String toString() {
        return this.f9110g + ": mimeType=" + this.b + ", filename=" + this.f9091c + ", description=" + this.f9092d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.f9091c);
        parcel.writeString(this.f9092d);
        parcel.writeByteArray(this.f9093e);
    }

    f(Parcel parcel) {
        super(a);
        this.b = parcel.readString();
        this.f9091c = parcel.readString();
        this.f9092d = parcel.readString();
        this.f9093e = parcel.createByteArray();
    }
}
