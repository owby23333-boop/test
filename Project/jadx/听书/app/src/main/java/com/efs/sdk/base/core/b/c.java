package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Handler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1533a;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f1581a.getLooper());
        this.f1533a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f1534a = new c(0);
    }

    public static c a() {
        return a.f1534a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 2) {
            Log.w("efs.cache", "disk listener not support command: " + message.what);
        } else {
            WorkThreadUtil.submit(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.b.a unused = a.b.f1531a;
        File fileF = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileF.exists()) {
            for (File file : com.efs.sdk.base.core.util.b.d(fileF)) {
                if (com.efs.sdk.base.core.b.a.a(file.getName())) {
                    com.efs.sdk.base.core.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.core.config.a.c cVarA = com.efs.sdk.base.core.config.a.c.a();
        String str = cVarA.d.f.containsKey("disk_bytes") ? cVarA.d.f.get("disk_bytes") : "4194304";
        long j = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long jC = com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z = jC < j;
        this.f1533a = z;
        if (!z) {
            Log.w("efs.cache", "Cache Limited! curr " + jC + "byte, max " + j + " byte.");
        }
        sendEmptyMessageDelayed(2, TTAdConstant.AD_MAX_EVENT_TIME);
    }
}
