package com.anythink.expressad.exoplayer.g.a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements a.InterfaceC0191a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.a.a.1
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
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f9075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9076g;

    public a(String str, String str2, long j2, long j3, byte[] bArr, long j4) {
        this.a = str;
        this.b = str2;
        this.f9072c = j2;
        this.f9074e = j3;
        this.f9075f = bArr;
        this.f9073d = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f9073d == aVar.f9073d && this.f9072c == aVar.f9072c && this.f9074e == aVar.f9074e && af.a((Object) this.a, (Object) aVar.a) && af.a((Object) this.b, (Object) aVar.b) && Arrays.equals(this.f9075f, aVar.f9075f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9076g == 0) {
            String str = this.a;
            int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j2 = this.f9073d;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f9072c;
            int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f9074e;
            this.f9076g = ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f9075f);
        }
        return this.f9076g;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.f9074e + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.f9073d);
        parcel.writeLong(this.f9072c);
        parcel.writeLong(this.f9074e);
        parcel.writeByteArray(this.f9075f);
    }

    a(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.f9073d = parcel.readLong();
        this.f9072c = parcel.readLong();
        this.f9074e = parcel.readLong();
        this.f9075f = parcel.createByteArray();
    }
}
