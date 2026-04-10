package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: UMInnerManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f2287a;
    private static Method b;

    static {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            if (cls != null) {
                f2287a = cls;
                Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", Context.class);
                if (declaredMethod != null) {
                    b = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE != 1) {
            Class<?> cls = f2287a;
            if (cls == null || (method = b) == null) {
                return;
            }
            try {
                method.invoke(cls, context);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        UMConfigureInternation.sendInternal(context);
    }
}
