package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.android.agoo.message.MessageReceiverService;

/* JADX INFO: loaded from: classes3.dex */
public final class UmengMessageIntentReceiverService extends MessageReceiverService {
    @Override // org.android.agoo.message.MessageReceiverService
    public String getIntentServiceClassName(Context context) {
        return UmengIntentService.class.getName();
    }

    @Override // org.android.agoo.message.MessageReceiverService, android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return super.onBind(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
