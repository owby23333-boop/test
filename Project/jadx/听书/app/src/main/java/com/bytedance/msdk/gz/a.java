package com.bytedance.msdk.gz;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    public interface z {
    }

    public static void z(Context context, Intent intent, z zVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
