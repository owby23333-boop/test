package com.taobao.accs.net;

import android.content.Intent;
import anet.channel.ISessionListener;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class l implements ISessionListener {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    @Override // anet.channel.ISessionListener
    public void onConnectionChanged(Intent intent) {
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            ALog.e(this.a.d(), "onConnectionChanged", "currentHost", "https://" + this.a.f18206i.getInappHost(), "changeHost", stringExtra, CallMraidJS.b, Boolean.valueOf(booleanExtra));
            if (("https://" + this.a.f18206i.getInappHost()).equals(stringExtra)) {
                f.a(GlobalClientInfo.getContext()).a();
                int intExtra = intent.getIntExtra("errorCode", -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = booleanExtra ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, intExtra, stringExtra2);
                connectInfo.connected = booleanExtra;
                Iterator<AccsConnectStateListener> it = this.a.n().iterator();
                while (it.hasNext()) {
                    this.a.f18226r.post(new m(this, connectInfo, it.next()));
                }
            }
        }
    }
}
