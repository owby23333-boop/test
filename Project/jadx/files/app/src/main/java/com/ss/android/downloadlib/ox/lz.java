package com.ss.android.downloadlib.ox;

import android.os.Build;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class lz {
    public static boolean mb(@NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        return com.ss.android.socialbase.appdownloader.u.hj.hj() && Build.VERSION.SDK_INT < 29 && com.ss.android.downloadlib.addownload.x.jb() != null && com.ss.android.downloadlib.addownload.x.jb().mb() && com.ss.android.downloadlib.utils.hj.mb(mbVar).optInt("invoke_app_form_background_switch") == 1 && mbVar.e();
    }
}
