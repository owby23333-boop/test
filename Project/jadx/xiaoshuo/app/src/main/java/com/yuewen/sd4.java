package com.yuewen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class sd4 {
    public abstract rd4 a(View view, ev0 ev0Var);

    public rd4 b(ViewGroup viewGroup, ev0 ev0Var) {
        return a(LayoutInflater.from(viewGroup.getContext()).inflate(c(), viewGroup, false), ev0Var);
    }

    @LayoutRes
    public abstract int c();
}
