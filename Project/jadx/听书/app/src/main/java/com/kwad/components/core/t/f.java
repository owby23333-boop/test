package com.kwad.components.core.t;

import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static boolean aH(String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName()).append(FileUtils.FILE_EXTENSION_SEPARATOR).append(stackTraceElement.getMethodName());
        return sb.toString();
    }
}
