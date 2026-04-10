package com.taobao.accs.init;

import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ Launcher_Login b;

    e(Launcher_Login launcher_Login, HashMap map) {
        this.b = launcher_Login;
        this.a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iIntValue;
        String str;
        String str2 = null;
        try {
            iIntValue = ((Integer) this.a.get("envIndex")).intValue();
            str = (String) this.a.get("onlineAppKey");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (iIntValue == 1) {
                str2 = (String) this.a.get("preAppKey");
            } else {
                str2 = (iIntValue == 2) | (iIntValue == 3) ? (String) this.a.get("dailyAppkey") : str;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
            try {
                ALog.e("Launcher_Login", "login get param error", th, new Object[0]);
            } catch (Throwable th3) {
                ALog.e("Launcher_Login", "login", th3, new Object[0]);
                return;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            ALog.e("Launcher_Login", "login get appkey null", new Object[0]);
        }
        Launcher_InitAccs.mForceBindUser = true;
        Launcher_InitAccs.mUserId = (String) this.a.get("userId");
        Launcher_InitAccs.mSid = (String) this.a.get("sid");
        ACCSClient.getAccsClient().bindApp((String) this.a.get(Constants.KEY_TTID), Launcher_InitAccs.mAppReceiver);
    }
}
