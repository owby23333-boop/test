package com.xiaomi.phonenum.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class TraceId {
    public static String any() {
        return UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }
}
