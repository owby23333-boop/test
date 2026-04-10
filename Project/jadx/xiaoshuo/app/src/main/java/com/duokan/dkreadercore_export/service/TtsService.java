package com.duokan.dkreadercore_export.service;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.yuewen.xv1;

/* JADX INFO: loaded from: classes14.dex */
public interface TtsService<T extends Parcelable> extends IProvider {
    boolean E2();

    void w2(xv1 xv1Var, @NonNull T t, @NonNull String str);
}
