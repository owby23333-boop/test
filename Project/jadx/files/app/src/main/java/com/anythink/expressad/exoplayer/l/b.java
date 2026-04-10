package com.anythink.expressad.exoplayer.l;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import com.umeng.message.proguard.ad;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.anythink.expressad.exoplayer.l.b.1
        private static b a(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] a() {
            return new b[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ b[] newArray(int i2) {
            return new b[0];
        }
    };
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f9935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9936e;

    private b(int i2, int i3, int i4, byte[] bArr) {
        this.a = i2;
        this.b = i3;
        this.f9934c = i4;
        this.f9935d = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b && this.f9934c == bVar.f9934c && Arrays.equals(this.f9935d, bVar.f9935d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9936e == 0) {
            this.f9936e = ((((((this.a + 527) * 31) + this.b) * 31) + this.f9934c) * 31) + Arrays.hashCode(this.f9935d);
        }
        return this.f9936e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f9934c);
        sb.append(", ");
        sb.append(this.f9935d != null);
        sb.append(ad.f20406s);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f9934c);
        af.a(parcel, this.f9935d != null);
        byte[] bArr = this.f9935d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    b(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.f9934c = parcel.readInt();
        this.f9935d = af.a(parcel) ? parcel.createByteArray() : null;
    }
}
