package com.bytedance.msdk.gz.a;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Function<SparseArray<Object>, Object> z;

    public static void z(Function<SparseArray<Object>, Object> function) {
        z = function;
    }

    public static String z() {
        Function<SparseArray<Object>, Object> function = z;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String g() {
        Function<SparseArray<Object>, Object> function = z;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    public static String dl() {
        Function<SparseArray<Object>, Object> function = z;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec).z(String.class).g());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }
}
