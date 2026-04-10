package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.taobao.agoo.TaobaoBaseIntentService;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ae;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
abstract class UmengBaseIntentService extends TaobaoBaseIntentService {
    protected static final String a = "UmengIntentService";

    UmengBaseIntentService() {
    }

    protected void a(Context context, UMessage uMessage) {
    }

    @Override // org.android.agoo.control.BaseIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected void onError(Context context, String str) {
        UPLog.e(a, "onError()[" + str + "]");
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected final void onMessage(Context context, Intent intent) {
        try {
            UPLog.i(a, "--->>> onMessage");
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            String stringExtra2 = intent.getStringExtra("id");
            String stringExtra3 = intent.getStringExtra("task_id");
            JSONObject jSONObject = new JSONObject(stringExtra);
            jSONObject.put("agoo_msg_id", stringExtra2);
            jSONObject.put("agoo_task_id", stringExtra3);
            UMessage uMessage = new UMessage(jSONObject);
            UPLog.i(a, "message:[" + jSONObject.toString() + "]");
            UTrack.getInstance().trackMsgArrival(uMessage);
            ae.a(context).a(uMessage.message_id, uMessage.task_id, uMessage.display_type);
            a(context, uMessage);
        } catch (Throwable th) {
            UPLog.e(a, "error:" + th.getMessage());
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected void onRegistered(Context context, String str) {
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService
    protected void onUnregistered(Context context, String str) {
    }
}
