package com.duokan.reader.ui.store;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public interface StoreLoading {

    public enum LoadingStyle {
        NORMAL,
        COMIC,
        CIRCLE
    }

    View a();

    void hide();

    void show();
}
