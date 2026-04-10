package com.yuewen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes3.dex */
public class se2 {
    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    public static void c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        } else {
            Toast.makeText(context, rt2.r.S3, 0).show();
        }
    }
}
