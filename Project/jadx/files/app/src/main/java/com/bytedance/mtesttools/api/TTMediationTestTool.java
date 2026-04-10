package com.bytedance.mtesttools.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.mtesttools.act.TestToolMainActivity;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class TTMediationTestTool {
    private static ImageCallBack a = null;
    private static String b = "";

    public interface ImageCallBack {
        void loadImage(ImageView imageView, String str);
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(b) && context != null) {
            try {
                b = context.getPackageName();
            } catch (Throwable unused) {
            }
        }
        return b;
    }

    public static void launchTestTools(Context context, ImageCallBack imageCallBack) {
        a = imageCallBack;
        Intent intent = new Intent(context, (Class<?>) TestToolMainActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public static void showImage(ImageView imageView, String str) {
        if (a == null || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        a.loadImage(imageView, str);
    }
}
