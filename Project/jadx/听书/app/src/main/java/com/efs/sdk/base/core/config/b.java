package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.efs.sdk.base.core.config.a f1554a;
    public Context b;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1555a = new b(0);
    }

    public final String b() {
        return this.f1554a.b(TKDownloadReason.KSAD_TK_NET, NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public final com.efs.sdk.base.core.config.a a() {
        try {
            String strA = a(this.b);
            if (!TextUtils.isEmpty(strA)) {
                this.f1554a.a(UMCrash.KEY_CALLBACK_SESSION_ID, strA);
            }
        } catch (Throwable th) {
            Log.d("efs.info.manager", "refreshSessionId caused error: " + th.getMessage());
        }
        return this.f1554a;
    }
}
