package com.umeng.message;

import android.content.Intent;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UmengNotifyClickActivity extends BaseNotifyClickActivity {
    private static final String a = "NotifyClickActivity";

    @Override // com.taobao.agoo.BaseNotifyClickActivity
    public void onMessage(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            UPLog.i(a, "msg:", stringExtra);
            String stringExtra2 = intent.getStringExtra("id");
            String stringExtra3 = intent.getStringExtra("task_id");
            JSONObject jSONObject = new JSONObject(stringExtra);
            jSONObject.put("agoo_msg_id", stringExtra2);
            jSONObject.put("agoo_task_id", stringExtra3);
            UTrack.getInstance().trackMfrPushMsgClick(new UMessage(jSONObject));
            UPLog.i(a, "source:", intent.getStringExtra(AgooConstants.MESSAGE_SOURCE));
        } catch (Throwable th) {
            UPLog.i(a, th);
        }
    }
}
