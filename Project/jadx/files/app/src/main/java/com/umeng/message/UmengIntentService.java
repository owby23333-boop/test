package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.service.UMJobIntentService;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public class UmengIntentService extends UmengBaseIntentService {
    @Override // com.umeng.message.UmengBaseIntentService
    protected final void a(Context context, UMessage uMessage) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.putExtra(AgooConstants.MESSAGE_BODY, uMessage.getRaw().toString());
            String pushIntentServiceClass = PushAgent.getInstance(context).getPushIntentServiceClass();
            if (TextUtils.isEmpty(pushIntentServiceClass)) {
                UPLog.i("UmengIntentService", "--->>> service default");
                intent.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
                intent.setClass(context, UmengMessageCallbackHandlerService.class);
                UMJobIntentService.enqueueWork(context, (Class<? extends UMJobIntentService>) UmengMessageCallbackHandlerService.class, intent);
            } else {
                UPLog.i("UmengIntentService", "--->>> service " + pushIntentServiceClass);
                intent.setClassName(context, pushIntentServiceClass);
                UMJobIntentService.enqueueWork(context, pushIntentServiceClass, intent);
            }
        } catch (Throwable th) {
            UPLog.i("UmengIntentService", "--->>> exception: " + th.getMessage());
        }
    }

    @Override // com.umeng.message.UmengBaseIntentService, org.android.agoo.control.BaseIntentService, android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }
}
