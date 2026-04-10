package com.taobao.accs.init;

import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class d implements IAppReceiver {
    d() {
    }

    @Override // com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return Launcher_InitAccs.SERVICES;
    }

    @Override // com.taobao.accs.IAppReceiver
    public String getService(String str) {
        return Launcher_InitAccs.SERVICES.get(str);
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindApp(int i2) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("Launcher_InitAccs", "onBindApp,  errorCode:" + i2, new Object[0]);
        }
        if (i2 == 200) {
            if (!TextUtils.isEmpty(Launcher_InitAccs.mUserId)) {
                try {
                    ACCSClient.getAccsClient().bindUser(Launcher_InitAccs.mUserId, Launcher_InitAccs.mForceBindUser);
                } catch (AccsException e2) {
                    ALog.e("Launcher_InitAccs", "bindUser", e2, new Object[0]);
                }
                Launcher_InitAccs.mForceBindUser = false;
                return;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("Launcher_InitAccs", "onBindApp,  bindUser userid :" + Launcher_InitAccs.mUserId, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i2) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("Launcher_InitAccs", "onBindUser, userId:" + str + " errorCode:" + i2, new Object[0]);
        }
        if (i2 == 300) {
            try {
                ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
            } catch (AccsException e2) {
                ALog.e("Launcher_InitAccs", "bindApp", e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onData,  userId:");
            sb.append(str);
            sb.append("dataId:");
            sb.append(str2);
            sb.append(" dataLen:");
            sb.append(bArr == null ? 0 : bArr.length);
            ALog.d("Launcher_InitAccs", sb.toString(), new Object[0]);
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i2) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("Launcher_InitAccs", "onSendData,  dataId:" + str + " errorCode:" + i2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i2) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("Launcher_InitAccs", "onUnbindApp,  errorCode:" + i2, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i2) {
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("Launcher_InitAccs", "onUnbindUser, errorCode:" + i2, new Object[0]);
        }
    }
}
