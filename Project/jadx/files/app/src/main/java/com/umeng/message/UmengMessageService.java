package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import com.umeng.message.common.UPLog;
import com.umeng.message.service.UMJobIntentService;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UmengMessageService extends UMJobIntentService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f20275j = "UmengMessageService";

    @Override // com.umeng.message.service.UMJobIntentService, com.umeng.message.service.JobIntentService
    public void a(Intent intent) {
        try {
            onMessage(this, intent);
            UPLog.i(f20275j, "message:" + intent.getStringExtra(AgooConstants.MESSAGE_BODY));
        } catch (Throwable unused) {
        }
    }

    public abstract void onMessage(Context context, Intent intent);
}
