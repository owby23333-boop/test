package com.repack.bun.miitmdid.core;

import android.content.Context;
import androidx.annotation.Keep;
import com.repack.bun.supplier.IIdentifierListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p0.a;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class MdidSdkHelper {
    public static String TAG = "MdidSdkHelper";

    @Keep
    public static boolean _OuterIsOk = true;

    @Keep
    private String sdk_date = "2020011018";

    @Keep
    public static int InitSdk(Context context, boolean z2, IIdentifierListener iIdentifierListener) {
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener != null) {
                    iIdentifierListener.OnSupport(false, new a());
                }
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Constructor constructor = MdidSdk.class.getConstructor(Boolean.TYPE);
            if (constructor == null) {
                logd(z2, "not found MdidSdk Constructor");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Object objNewInstance = constructor.newInstance(Boolean.valueOf(z2));
            if (objNewInstance == null) {
                logd(z2, "Create MdidSdk Instance failed");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Method declaredMethod = MdidSdk.class.getDeclaredMethod("InitSdk", Context.class, IIdentifierListener.class);
            if (declaredMethod == null) {
                logd(z2, "not found MdidSdk InitSdk function");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            int iIntValue = ((Integer) declaredMethod.invoke(objNewInstance, context, iIdentifierListener)).intValue();
            logd(z2, "call and retvalue:" + iIntValue);
            return iIntValue;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            loge(z2, e2);
            logd(z2, "exception exit");
            return ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z2, String str) {
    }

    public static void loge(boolean z2, Exception exc) {
        if (z2) {
            exc.getClass().getSimpleName();
        }
    }
}
