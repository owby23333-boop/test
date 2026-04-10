package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class b implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ a b;

    b(a aVar, Intent intent) {
        this.b = aVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent;
        Intent intent2 = null;
        try {
            if (this.a != null) {
                String msgByThirdPush = this.b.parseMsgByThirdPush(this.a);
                if (TextUtils.isEmpty(msgByThirdPush) || TextUtils.isEmpty(this.b.msgSource)) {
                    ALog.e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", this.b.msgSource);
                    intent = null;
                } else {
                    if (this.b.notifyManager == null) {
                        this.b.notifyManager = new NotifManager();
                    }
                    if (this.b.agooFactory == null) {
                        this.b.agooFactory = new AgooFactory();
                        this.b.agooFactory.init(this.b.context, this.b.notifyManager, null);
                    }
                    Bundle bundleMsgReceiverPreHandler = this.b.agooFactory.msgReceiverPreHandler(msgByThirdPush.getBytes("UTF-8"), this.b.msgSource, null, false);
                    String string = bundleMsgReceiverPreHandler.getString(AgooConstants.MESSAGE_BODY);
                    ALog.i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                    String encryptedMsg = AgooFactory.parseEncryptedMsg(string);
                    if (TextUtils.isEmpty(encryptedMsg)) {
                        ALog.e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                    } else {
                        bundleMsgReceiverPreHandler.putString(AgooConstants.MESSAGE_BODY, encryptedMsg);
                    }
                    intent = new Intent();
                    try {
                        intent.putExtras(bundleMsgReceiverPreHandler);
                        this.b.agooFactory.saveMsg(msgByThirdPush.getBytes("UTF-8"), "2");
                        this.b.reportClickNotifyMsg(intent);
                    } catch (Throwable th) {
                        intent2 = intent;
                        th = th;
                        try {
                            ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                            try {
                                this.b.onMessage(intent2);
                                return;
                            } catch (Throwable th2) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th2, new Object[0]);
                                return;
                            }
                        } catch (Throwable th3) {
                            try {
                                this.b.onMessage(intent2);
                            } catch (Throwable th4) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                            }
                            throw th3;
                        }
                    }
                }
            } else {
                intent = null;
            }
            try {
                this.b.onMessage(intent);
            } catch (Throwable th5) {
                ALog.e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
