package com.google.android.play.core.splitinstall.a;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b extends com.google.android.a.b implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder);
    }
}
