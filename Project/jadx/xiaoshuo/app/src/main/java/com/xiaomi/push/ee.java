package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
public class ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ed f7905a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        ed edVar = f7905a;
        if (edVar != null) {
            return edVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
