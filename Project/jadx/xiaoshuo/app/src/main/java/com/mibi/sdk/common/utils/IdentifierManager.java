package com.mibi.sdk.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"PrivateApi"})
public class IdentifierManager {
    private static String OAID = "";
    private static final String TAG = "IdentifierManager";
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProviderImpl = cls.newInstance();
            sGetOAID = sClass.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            MibiLog.e("IdentifierManager", "reflect exception!", e);
        }
    }

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(OAID)) {
            OAID = invokeMethod(context, sGetOAID);
        }
        return OAID;
    }

    private static String invokeMethod(Context context, Method method) {
        Object obj = sIdProviderImpl;
        if (obj == null || method == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            return objInvoke != null ? (String) objInvoke : "";
        } catch (Exception e) {
            MibiLog.e("IdentifierManager", "invoke exception!", e);
            return "";
        }
    }

    public static boolean isSupported() {
        return (sClass == null || sIdProviderImpl == null) ? false : true;
    }
}
