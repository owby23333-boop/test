package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0486a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2127a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0486a c0486a) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else {
            if (!d.b(c0486a.action)) {
                String str2 = !d.b(c0486a.f2127a) ? c0486a.f2127a + ".permission.MM_MESSAGE" : null;
                Intent intent = new Intent(c0486a.action);
                if (c0486a.bundle != null) {
                    intent.putExtras(c0486a.bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0486a.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0486a.b);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0486a.content, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
