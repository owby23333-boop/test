package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes7.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f6785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6786b;

    public a(IBinder iBinder, String str) {
        this.f6785a = iBinder;
        this.f6786b = str;
    }

    public final Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f6786b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f6785a;
    }

    public final void a(int i, Parcel parcel) {
        try {
            this.f6785a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
