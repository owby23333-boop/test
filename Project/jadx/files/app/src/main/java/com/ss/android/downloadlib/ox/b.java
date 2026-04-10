package com.ss.android.downloadlib.ox;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static void mb(final com.ss.android.downloadad.api.mb.ox oxVar, @NonNull final com.ss.android.downloadlib.guide.install.mb mbVar) {
        boolean zIsAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!zIsAppForeground && Build.VERSION.SDK_INT >= 29) {
            jb.ox();
        }
        boolean zIsAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        if (!zIsAppForeground && zIsAppForeground2 && oxVar != null) {
            oxVar.je(true);
        }
        mbVar.mb();
        Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + zIsAppForeground2);
        if (zIsAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.ox.b.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                Logger.d("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                if (jb.ox(oxVar)) {
                    return;
                }
                oxVar.nk(true);
                AdEventHandler.mb().mb(EventConstants.UnityLabel.INSTALL_DELAY_INVOKE, oxVar);
                mbVar.mb();
            }
        });
    }
}
