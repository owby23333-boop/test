package com.bytedance.pangle.e;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.a;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a.z {
    private final ZeusPluginInstallListener z;

    public g(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.z = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.a
    public void z(String str, int i, String str2) throws RemoteException {
        ZeusPluginInstallListener zeusPluginInstallListener = this.z;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
