package com.kwad.components.core.r;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.kwad.sdk.utils.bk;
import com.taobao.accs.common.Constants;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements bk.a {
    private a PS;
    private BroadcastReceiver PT = new BroadcastReceiver() { // from class: com.kwad.components.core.r.f.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message messageObtainMessage = f.this.mHandler.obtainMessage(TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION);
            messageObtainMessage.obj = schemeSpecificPart;
            messageObtainMessage.sendToTarget();
        }
    };
    private Handler mHandler = new bk(this);
    private String targetPackage;

    public interface a {
        void hM();
    }

    public f(String str) {
        this.targetPackage = str;
    }

    public final void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        this.PS = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(Constants.KEY_PACKAGE);
        try {
            context.registerReceiver(this.PT, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        Object obj;
        a aVar;
        if (message.what != 242 || (obj = message.obj) == null || !obj.equals(this.targetPackage) || (aVar = this.PS) == null) {
            return;
        }
        aVar.hM();
    }

    public final void as(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this.PT);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        this.PS = null;
    }

    public final void ay(String str) {
        this.targetPackage = str;
    }
}
