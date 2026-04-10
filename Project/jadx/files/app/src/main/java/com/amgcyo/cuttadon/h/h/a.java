package com.amgcyo.cuttadon.h.h;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amgcyo.cuttadon.activity.setting.MkAdBrowserActivity;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.service.MkDownloadApkService;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: compiled from: SelfAdOpenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context context, NewApiAd newApiAd) {
        if (context == null || newApiAd == null || TextUtils.isEmpty(newApiAd.getDown_url())) {
            return;
        }
        c.a(context, "OWNADCLICK", newApiAd, newApiAd.getLocation(), newApiAd.getOwnerType());
        int down_type = newApiAd.getDown_type();
        if (down_type == 1) {
            Intent intent = new Intent(context, (Class<?>) MkDownloadApkService.class);
            intent.putExtra("new_api_ad", newApiAd);
            context.startService(intent);
        } else {
            if (down_type == 2) {
                com.amgcyo.cuttadon.view.webview.b.startActivity(context, newApiAd.getDown_url());
                return;
            }
            if (down_type != 3) {
                return;
            }
            Intent intent2 = new Intent(context, (Class<?>) MkAdBrowserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("new_api_ad", newApiAd);
            intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent2.putExtras(bundle);
            context.startActivity(intent2);
        }
    }
}
