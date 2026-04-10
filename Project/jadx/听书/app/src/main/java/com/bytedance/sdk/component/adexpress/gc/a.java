package com.bytedance.sdk.component.adexpress.gc;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.z.uf;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private WeakReference<uf> z;

    public a(uf ufVar) {
        this.z = new WeakReference<>(ufVar);
    }

    public void z(uf ufVar) {
        this.z = new WeakReference<>(ufVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<uf> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().invokeMethod(str);
    }
}
