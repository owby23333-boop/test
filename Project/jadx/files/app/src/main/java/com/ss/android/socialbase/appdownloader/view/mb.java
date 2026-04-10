package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.h.hj;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.taobao.accs.common.Constants;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public class mb extends Fragment {
    private Context h() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext != null || getActivity() == null || getActivity().isFinishing()) ? appContext : getActivity().getApplicationContext();
    }

    public static Intent hj() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Intent u() {
        Context contextH = h();
        if (contextH == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextH.getPackageName();
        intent.putExtra(Constants.KEY_PACKAGE, packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i2 = contextH.getApplicationInfo().uid;
        intent.putExtra("uid", i2);
        intent.putExtra("app_uid", i2);
        return intent;
    }

    public Intent b() {
        Context contextH = h();
        if (contextH == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextH.getPackageName()));
    }

    public void mb() {
        try {
            try {
                try {
                    startActivityForResult(u(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(ox(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(hj(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(b(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (hj.mb()) {
            hj.mb(true);
        } else {
            hj.mb(false);
        }
    }

    public Intent ox() {
        Context contextH = h();
        if (contextH == null) {
            return null;
        }
        String packageName = contextH.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(DownloadConstants.LOWER_OPPO)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU) && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextH.getPackageName()));
    }
}
