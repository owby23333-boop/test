package com.ss.android.download.api.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface je {
    void mb(int i2, @Nullable Context context, @Nullable DownloadModel downloadModel, String str, Drawable drawable, int i3);

    Dialog ox(@NonNull DownloadAlertDialogInfo downloadAlertDialogInfo);
}
