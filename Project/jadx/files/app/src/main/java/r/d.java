package r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: ChannelUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static String a(Context context, String str) {
        Bundle bundle;
        Object obj;
        String string;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(str)) != null && (string = obj.toString()) != null) {
                    return string.trim();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
