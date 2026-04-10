package com.google.android.play.core.splitinstall.a;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends com.google.android.a.b implements d {
    public e() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.a.b
    public final boolean a(int i, Parcel parcel) {
        switch (i) {
            case 2:
                c(parcel.readInt(), (Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int i2 = parcel.readInt();
                com.google.android.a.c.a(parcel, Bundle.CREATOR);
                a(i2);
                return true;
            case 4:
                a(parcel.readInt(), (Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                b(parcel.readInt(), (Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                c((Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                b((Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                a((Bundle) com.google.android.a.c.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                com.google.android.a.c.a(parcel, Bundle.CREATOR);
                b();
                return true;
            case 11:
                com.google.android.a.c.a(parcel, Bundle.CREATOR);
                a();
                return true;
            default:
                return false;
        }
    }
}
