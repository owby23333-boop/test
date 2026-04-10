package com.bytedance.msdk.z.gc;

import android.content.Context;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static Object z(Context context) {
        Object obj;
        if (context != null) {
            try {
                if (context.getClass() == PluginActivityWrapper.class) {
                    obj = ((PluginActivityWrapper) context).mOriginActivity;
                } else {
                    obj = context.getClass() == PluginApplicationWrapper.class ? ((PluginApplicationWrapper) context).mOriginApplication : null;
                }
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }
}
