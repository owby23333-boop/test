package com.ss.android.downloadlib.ox;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private static Handler mb = new Handler(Looper.getMainLooper());

    public static boolean b(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    public static long h(com.ss.android.downloadad.api.mb.ox oxVar) {
        return oxVar == null ? m.ag : com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }

    public static boolean hj(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    private static int lz(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(@NonNull final com.ss.android.downloadad.api.mb.ox oxVar, final int i2) {
        if (i2 <= 0) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.u.2
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 1;
                if (!jb.b(oxVar.h())) {
                    u.ox(oxVar, i2 - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!oxVar.up()) {
                        i3 = 2;
                    }
                    jSONObject.putOpt(EventConstants.ExtraJson.KEY_DEEPLINK_SOURCE, Integer.valueOf(i3));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_SUCCESS_2, jSONObject, oxVar);
            }
        }, lz(oxVar) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long ww(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optLong("app_link_check_timeout", 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_check_count", 10);
    }

    public static void mb(final com.ss.android.downloadad.api.mb.ox oxVar, @NonNull final ww wwVar) {
        boolean zIsAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!zIsAppForeground && Build.VERSION.SDK_INT >= 29) {
            jb.ox();
        }
        boolean zIsAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        boolean z2 = !zIsAppForeground && zIsAppForeground2;
        if (oxVar != null) {
            oxVar.je(z2);
        }
        wwVar.mb(z2);
        if (oxVar == null) {
            return;
        }
        ox(oxVar, x(oxVar));
        if (zIsAppForeground2) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.ox.u.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.ox.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zB = jb.b(oxVar.h());
                        long jH = u.h(oxVar);
                        if (!zB || jH >= System.currentTimeMillis() - jCurrentTimeMillis) {
                            long jWw = u.ww(oxVar);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > jWw) {
                                AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_DELAY_TIMEOUT, oxVar);
                                return;
                            }
                            oxVar.je(true);
                            AdEventHandler.mb().mb(EventConstants.UnityLabel.DEEPLINK_DELAY_INVOKE, oxVar);
                            wwVar.mb(true);
                            com.ss.android.downloadad.api.mb.ox oxVar2 = oxVar;
                            u.ox(oxVar2, u.x(oxVar2));
                        }
                    }
                });
            }
        });
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_install_switch") == 1;
    }

    public static boolean mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        return com.ss.android.downloadlib.utils.hj.mb(oxVar).optInt("app_link_opt_switch") == 1;
    }
}
