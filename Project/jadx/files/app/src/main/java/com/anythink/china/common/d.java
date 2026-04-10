package com.anythink.china.common;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.anythink.china.activity.TransparentActivity;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.Random;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final String a = "android.permission.READ_PHONE_STATE";
    public static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";

    public interface a {
        void a();
    }

    private static void a(Context context, a aVar, String... strArr) {
        if (context == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        int iNextInt = new Random().nextInt(Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        if (aVar != null) {
            TransparentActivity.f6353e.put(Integer.valueOf(iNextInt), aVar);
        }
        Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(TransparentActivity.b, iNextInt);
        intent.putExtra(TransparentActivity.f6352d, strArr);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public static boolean a(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
