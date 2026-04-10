package com.ss.android.download.api.mb;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.lz;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements lz {
    private gm mb;

    @Override // com.ss.android.download.api.config.lz
    public void mb(@NonNull Activity activity, @NonNull String[] strArr, gm gmVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mb = gmVar;
            activity.requestPermissions(strArr, 1);
        } else if (gmVar != null) {
            gmVar.mb();
        }
    }

    @Override // com.ss.android.download.api.config.lz
    public boolean mb(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.lz
    public void mb(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        gm gmVar;
        if (iArr.length <= 0 || (gmVar = this.mb) == null) {
            return;
        }
        if (iArr[0] == -1) {
            gmVar.mb(strArr[0]);
        } else if (iArr[0] == 0) {
            gmVar.mb();
        }
    }
}
