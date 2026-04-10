package com.bytedance.pangle.e;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.a;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends ZeusPluginStateListener {
    private final int g;
    private final a z;

    public dl(a aVar, int i) {
        this.z = aVar;
        this.g = i;
    }

    public int z() {
        return this.g;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
            String strValueOf = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        strValueOf = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.z.z(str, i, strValueOf);
        }
    }
}
