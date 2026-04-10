package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.kuaishou.weapon.p0.g;
import java.util.List;

/* JADX INFO: compiled from: PermissionSettingPage.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {
    static Intent a(Context context, List<String> list) {
        if (list == null || list.isEmpty()) {
            return a(context);
        }
        if (!e.a(list)) {
            return a(context);
        }
        if (list.size() != 1) {
            return (list.size() == 3 && list.contains("android.permission.MANAGE_EXTERNAL_STORAGE") && list.contains(g.f16729i) && list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) ? e.c() ? e(context) : a(context) : a(context);
        }
        String str = list.get(0);
        return "android.permission.MANAGE_EXTERNAL_STORAGE".equals(str) ? e(context) : "android.permission.REQUEST_INSTALL_PACKAGES".equals(str) ? b(context) : "android.permission.SYSTEM_ALERT_WINDOW".equals(str) ? f(context) : "android.permission.ACCESS_NOTIFICATION_POLICY".equals(str) ? c(context) : "android.permission.WRITE_SETTINGS".equals(str) ? d(context) : a(context);
    }

    static Intent b(Context context) {
        Intent intent;
        if (e.f()) {
            intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !e.a(context, intent)) ? a(context) : intent;
    }

    static Intent c(Context context) {
        Intent intent;
        if (e.f()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent = null;
        }
        return (intent == null || !e.a(context, intent)) ? a(context) : intent;
    }

    static Intent d(Context context) {
        Intent intent;
        if (e.d()) {
            intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !e.a(context, intent)) ? a(context) : intent;
    }

    static Intent e(Context context) {
        Intent intent;
        if (e.c()) {
            intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !e.a(context, intent)) ? a(context) : intent;
    }

    static Intent f(Context context) {
        Intent intent;
        if (e.d()) {
            intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !e.a(context, intent)) ? a(context) : intent;
    }

    static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        return intent;
    }
}
