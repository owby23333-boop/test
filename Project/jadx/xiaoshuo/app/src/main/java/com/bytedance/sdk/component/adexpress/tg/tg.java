package com.bytedance.sdk.component.adexpress.tg;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.e.lc;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private WeakReference<lc> e;

    public tg(lc lcVar) {
        this.e = new WeakReference<>(lcVar);
    }

    public void e(lc lcVar) {
        this.e = new WeakReference<>(lcVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<lc> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().invokeMethod(str);
    }
}
