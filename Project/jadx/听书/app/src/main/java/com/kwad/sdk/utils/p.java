package com.kwad.sdk.utils;

import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class p {
    public static long aYX;
    public static long sLaunchTime;

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName()).append(FileUtils.FILE_EXTENSION_SEPARATOR).append(stackTraceElement.getMethodName());
        return sb.toString();
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }

    public static void setInitStartTime(long j) {
        aYX = j;
    }

    public static long PP() {
        return aYX - sLaunchTime;
    }
}
