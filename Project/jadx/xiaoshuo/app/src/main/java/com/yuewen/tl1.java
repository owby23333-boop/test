package com.yuewen;

import android.content.Context;

/* JADX INFO: loaded from: classes15.dex */
public interface tl1 {
    default void a(Context context) {
    }

    default boolean b() {
        return true;
    }

    default void c(Context context) {
    }

    default boolean d(String str) {
        return false;
    }

    default String getCurrentUrl() {
        return getUrl();
    }

    default int getLoadingError() {
        return 0;
    }

    String getUrl();

    void loadUrl(String str);

    void requestDisallowInterceptTouchEvent(boolean z);
}
