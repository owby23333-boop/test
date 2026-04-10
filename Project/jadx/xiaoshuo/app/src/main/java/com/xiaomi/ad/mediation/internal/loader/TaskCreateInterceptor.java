package com.xiaomi.ad.mediation.internal.loader;

import android.text.TextUtils;
import com.xiaomi.ad.common.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class TaskCreateInterceptor {
    public static String BYTEDANCE_DSP_NAME = "bytedance";
    public static boolean BYTEDANCE_INIT_STATE = false;
    public static String TENCENT_DSP_NAME = "tencent";
    public static boolean TENCENT_INIT_STATE = false;

    public static boolean getInitState(String str) {
        if (TextUtils.equals(str, BYTEDANCE_DSP_NAME)) {
            return BYTEDANCE_INIT_STATE;
        }
        if (TextUtils.equals(str, TENCENT_DSP_NAME)) {
            return TENCENT_INIT_STATE;
        }
        return false;
    }

    public static boolean isAllowCreateTask(String str) {
        return StringUtils.isNotEmpty(str);
    }

    public static void setBytedanceInitState(boolean z) {
        BYTEDANCE_INIT_STATE = z;
    }

    public static void setTencentInitState(boolean z) {
        TENCENT_INIT_STATE = z;
    }
}
