package com.kwad.components.core.t;

import android.R;
import android.app.Activity;
import android.view.Window;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static boolean tc() {
        return true;
    }

    public static void a(Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) {
        if (tc()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static void b(Activity activity, int i, boolean z) {
        int i2;
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (bb.Rl()) {
                a(activity, true);
            } else if (bb.Rm()) {
                l.b(activity, true);
            }
            i2 = 9472;
        } else {
            i2 = LogType.UNEXP_ANR;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    private static boolean a(Activity activity, boolean z) {
        try {
            int iIntValue = ((Integer) z.ar("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            z.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
