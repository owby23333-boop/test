package com.bigkoo.dkconvenientbanner.holder;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface CBViewHolderCreator<T> {
    Holder createHolder(View view, int i);

    int getItemViewType(T t);

    int getLayoutId(int i);
}
