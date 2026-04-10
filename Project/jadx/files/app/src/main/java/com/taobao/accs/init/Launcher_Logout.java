package com.taobao.accs.init;

import android.app.Application;
import com.baidu.mobads.sdk.internal.au;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class Launcher_Logout implements Serializable {
    public void init(Application application, HashMap<String, Object> map) {
        ALog.i("Launcher_Logout", au.b, new Object[0]);
        Launcher_InitAccs.mUserId = null;
        Launcher_InitAccs.mSid = null;
        try {
            ACCSClient.getAccsClient().unbindUser();
        } catch (AccsException e2) {
            ALog.e("Launcher_Logout", e2.getMessage(), new Object[0]);
        }
    }
}
