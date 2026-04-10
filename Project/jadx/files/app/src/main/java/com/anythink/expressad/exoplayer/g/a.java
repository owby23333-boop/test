package com.anythink.expressad.exoplayer.g;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.g.a.1
        private static a a(Parcel parcel) {
            return new a(parcel);
        }

        private static a[] a() {
            return new a[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i2) {
            return new a[0];
        }
    };
    private final InterfaceC0191a[] a;

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0191a extends Parcelable {
    }

    public a(InterfaceC0191a... interfaceC0191aArr) {
        this.a = interfaceC0191aArr;
    }

    public final int a() {
        return this.a.length;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((a) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a.length);
        for (InterfaceC0191a interfaceC0191a : this.a) {
            parcel.writeParcelable(interfaceC0191a, 0);
        }
    }

    public final InterfaceC0191a a(int i2) {
        return this.a[i2];
    }

    public a(List<? extends InterfaceC0191a> list) {
        this.a = new InterfaceC0191a[list.size()];
        list.toArray(this.a);
    }

    a(Parcel parcel) {
        this.a = new InterfaceC0191a[parcel.readInt()];
        int i2 = 0;
        while (true) {
            InterfaceC0191a[] interfaceC0191aArr = this.a;
            if (i2 >= interfaceC0191aArr.length) {
                return;
            }
            interfaceC0191aArr[i2] = (InterfaceC0191a) parcel.readParcelable(InterfaceC0191a.class.getClassLoader());
            i2++;
        }
    }
}
