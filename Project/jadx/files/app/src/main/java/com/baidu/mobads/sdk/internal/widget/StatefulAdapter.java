package com.baidu.mobads.sdk.internal.widget;

import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface StatefulAdapter {
    void restoreState(@NonNull Parcelable parcelable);

    @NonNull
    Parcelable saveState();
}
