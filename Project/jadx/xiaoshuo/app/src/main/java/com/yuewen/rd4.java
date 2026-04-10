package com.yuewen;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class rd4<T, CallBack> extends vi {
    public rd4(@NonNull View view, CallBack callback) {
        super(view);
        n(callback);
    }

    public abstract void m(T t, int i);

    public abstract void n(CallBack callback);
}
