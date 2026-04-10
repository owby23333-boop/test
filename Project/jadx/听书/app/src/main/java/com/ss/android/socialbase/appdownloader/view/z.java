package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.gc.a;
import com.ss.android.socialbase.downloader.downloader.dl;
import com.ss.android.socialbase.downloader.g.gc;

/* JADX INFO: loaded from: classes4.dex */
public class z extends Fragment {
    public void z() {
        try {
            try {
                try {
                    startActivityForResult(m(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(g(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(a(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(dl(), 1000);
        }
    }

    public Intent g() {
        Context contextGc = gc();
        if (contextGc == null) {
            return null;
        }
        String packageName = contextGc.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(gc.dl)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                return intent2;
            }
            lowerCase.contains("meizu");
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextGc.getPackageName()));
    }

    private Context gc() {
        Context contextXl = dl.xl();
        return (contextXl != null || getActivity() == null || getActivity().isFinishing()) ? contextXl : getActivity().getApplicationContext();
    }

    public Intent dl() {
        Context contextGc = gc();
        if (contextGc == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextGc.getPackageName()));
    }

    private Intent m() {
        Context contextGc = gc();
        if (contextGc == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextGc.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextGc.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent a() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (a.z()) {
            a.z(true);
        } else {
            a.z(false);
        }
    }
}
