package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static IKsAdSDK YZ;

    @Nullable
    public static <T> T a(String str, Object... objArr) {
        try {
            T t2 = (T) YZ.dM(str, objArr);
            if (t2 != null) {
                return t2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        YZ = iKsAdSDK;
    }

    public static String aP(String str) {
        return (String) a("TRANSFORM_API_HOST", str);
    }

    public static IKsAdSDK tv() {
        return YZ;
    }

    public static boolean tw() {
        Boolean bool = (Boolean) a("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int tx() {
        Integer num = (Integer) a("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
