package com.yuewen;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public interface td3 extends w01 {
    default void A8(String str, String str2, String str3, View view) {
        Fc(str, str2, str3);
    }

    void Fc(String str, String str2, String str3);

    default void j3(String str, String str2, String str3, View view, String str4) {
        A8(str, str2, str3, view);
    }

    default void j5() {
    }

    default void nc(String str, String str2, String str3, boolean z, Runnable runnable) {
    }
}
