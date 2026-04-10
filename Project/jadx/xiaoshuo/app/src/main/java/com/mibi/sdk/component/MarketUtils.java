package com.mibi.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.reader.domain.payment.a;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.widget.AlertDialog;

/* JADX INFO: loaded from: classes13.dex */
public class MarketUtils {
    private static final String BROWSER_MARKET_HOST = "http://app.mi.com";
    private static final String MI_MARKET_HOST = "market://details";
    private static final String TAG = "MarketUtils";

    public interface InstallPromptListener {
        void onCancel();

        void onConfirm();
    }

    public static boolean isAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean openDetailInMarket(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (isAppInstalled(context, "com.xiaomi.market")) {
                intent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).appendQueryParameter("back", a.c).build());
                intent.setPackage("com.xiaomi.market");
            } else {
                Uri uri = Uri.parse(BROWSER_MARKET_HOST);
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(uri.buildUpon().appendQueryParameter("id", str).build());
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                MibiLog.e(TAG, "Utils openDetailInMarket exception ", e);
            }
        }
        return false;
    }

    public static AlertDialog showInstallPrompt(final Context context, String str, final String str2, final InstallPromptListener installPromptListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.mibi.sdk.component.MarketUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MarketUtils.openDetailInMarket(context, str2);
                InstallPromptListener installPromptListener2 = installPromptListener;
                if (installPromptListener2 != null) {
                    installPromptListener2.onConfirm();
                }
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.mibi.sdk.component.MarketUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                InstallPromptListener installPromptListener2 = installPromptListener;
                if (installPromptListener2 != null) {
                    installPromptListener2.onCancel();
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        return alertDialogCreate;
    }
}
