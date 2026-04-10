package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import java.util.Map;
import org.android.agoo.common.Config;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class h implements IAgooAppReceiver {
    final /* synthetic */ Context a;
    final /* synthetic */ Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IRegister f18362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f18363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f18364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.taobao.accs.b f18365f;

    h(Context context, Context context2, IRegister iRegister, String str, String str2, com.taobao.accs.b bVar) {
        this.a = context;
        this.b = context2;
        this.f18362c = iRegister;
        this.f18363d = str;
        this.f18364e = str2;
        this.f18365f = bVar;
    }

    @Override // com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return null;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.f18363d;
    }

    @Override // com.taobao.accs.IAppReceiver
    public String getService(String str) {
        return null;
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindApp(int i2) {
    }

    @Override // com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i2, String str) {
        try {
            ALog.i("TaobaoRegister", "onBindApp", "errorCode", Integer.valueOf(i2));
            if (i2 != 200) {
                if (this.f18362c != null) {
                    this.f18362c.onFailure(String.valueOf(i2), "accs bindapp error!");
                    return;
                }
                return;
            }
            if (TaobaoRegister.mRequestListener == null) {
                com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.a);
            }
            GlobalClientInfo.getInstance(this.b).registerListener("AgooDeviceCmd", TaobaoRegister.mRequestListener);
            if (com.taobao.agoo.a.b.b.b(this.a.getPackageName()) && !UtilityImpl.b(Constants.SP_CHANNEL_FILE_NAME, this.b)) {
                boolean unused2 = TaobaoRegister.isRegisterSuccess = true;
                l.a().b();
                ALog.i("TaobaoRegister", "agoo already Registered return ", new Object[0]);
                if (this.f18362c != null) {
                    this.f18362c.onSuccess(Config.f(this.a));
                    return;
                }
                return;
            }
            byte[] bArrA = com.taobao.agoo.a.a.c.a(this.a, this.f18363d, this.f18364e);
            if (bArrA == null) {
                if (this.f18362c != null) {
                    this.f18362c.onFailure("503.1", "req data null");
                    return;
                }
                return;
            }
            String strB = this.f18365f.b(this.a, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", bArrA, null));
            if (TextUtils.isEmpty(strB)) {
                if (this.f18362c != null) {
                    this.f18362c.onFailure("503.1", "accs channel disabled!");
                }
            } else if (this.f18362c != null) {
                TaobaoRegister.mRequestListener.a.put(strB, this.f18362c);
            }
        } catch (Throwable th) {
            ALog.e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i2) {
    }
}
