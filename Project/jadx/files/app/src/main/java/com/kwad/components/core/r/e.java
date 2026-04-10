package com.kwad.components.core.r;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.r;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static void a(@NonNull Activity activity, int i2, boolean z2) {
        a(activity, 0, true, true);
    }

    public static void a(@NonNull Activity activity, int i2, boolean z2, boolean z3) {
        if (qe()) {
            b(activity, i2, z2);
            if (z3) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.b.kwai.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z2) {
        try {
            int iIntValue = ((Integer) r.X("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            r.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void b(@NonNull Activity activity, int i2, boolean z2) {
        Window window = activity.getWindow();
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 1280;
        if (i3 < 21) {
            if (i3 >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        if (z2 && i3 >= 23) {
            i4 = 9472;
            window.clearFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            window.addFlags(Integer.MIN_VALUE);
            if (ar.DN()) {
                a(activity, true);
            } else if (ar.DO()) {
                l.b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i4);
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean qe() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
