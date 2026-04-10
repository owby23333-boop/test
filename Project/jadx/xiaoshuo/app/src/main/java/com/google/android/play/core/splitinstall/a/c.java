package com.google.android.play.core.splitinstall.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.google.android.a.a implements a {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void a(String str, int i, Bundle bundle, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeInt(i);
        com.google.android.a.c.a(parcelA, bundle);
        com.google.android.a.c.a(parcelA, dVar);
        a(4, parcelA);
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void b(String str, List<Bundle> list, Bundle bundle, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeTypedList(list);
        com.google.android.a.c.a(parcelA, bundle);
        com.google.android.a.c.a(parcelA, dVar);
        a(7, parcelA);
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void c(String str, List<Bundle> list, Bundle bundle, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeTypedList(list);
        com.google.android.a.c.a(parcelA, bundle);
        com.google.android.a.c.a(parcelA, dVar);
        a(8, parcelA);
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void a(String str, int i, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeInt(i);
        com.google.android.a.c.a(parcelA, dVar);
        a(5, parcelA);
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void a(String str, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        com.google.android.a.c.a(parcelA, dVar);
        a(6, parcelA);
    }

    @Override // com.google.android.play.core.splitinstall.a.a
    public final void a(String str, List<Bundle> list, Bundle bundle, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeTypedList(list);
        com.google.android.a.c.a(parcelA, bundle);
        com.google.android.a.c.a(parcelA, dVar);
        a(2, parcelA);
    }
}
