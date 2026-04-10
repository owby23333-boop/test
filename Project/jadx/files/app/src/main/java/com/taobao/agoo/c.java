package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class c implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI;
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            ALog.e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            return intent.getStringExtra("extras");
        } catch (Throwable th) {
            ALog.e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
