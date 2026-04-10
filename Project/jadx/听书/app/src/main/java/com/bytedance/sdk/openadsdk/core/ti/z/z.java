package com.bytedance.sdk.openadsdk.core.ti.z;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static Boolean z;

    private static boolean z() {
        if (z == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$AdIsReadyStatus");
                z = Boolean.TRUE;
            } catch (Throwable unused) {
                z = Boolean.FALSE;
            }
        }
        return z.booleanValue();
    }

    public static Integer z(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        try {
            if (z()) {
                if (obj == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
                    return 1;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
                    return 2;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
                    return 3;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    return 4;
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return null;
    }
}
