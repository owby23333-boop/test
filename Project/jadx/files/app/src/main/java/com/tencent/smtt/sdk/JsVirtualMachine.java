package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class JsVirtualMachine {
    private final Context a;
    private final IX5JsVirtualMachine b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet<WeakReference<a>> f18837c;

    private static class a implements IX5JsContext {
        private WebView a;

        public a(Context context) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.a = new WebView(context);
                this.a.getSettings().setJavaScriptEnabled(true);
            } else {
                String str = "in system core, JsContext can just in mainLooper, current looper is " + Looper.myLooper();
            }
        }

        public void a() {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.onPause();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.addJavascriptInterface(obj, str);
            this.a.loadUrl(com.anythink.core.common.res.d.a);
        }

        public void b() {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.onResume();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.clearHistory();
            this.a.clearCache(true);
            this.a.loadUrl(com.anythink.core.common.res.d.a);
            this.a.freeMemory();
            this.a.pauseTimers();
            this.a.destroy();
            this.a = null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final android.webkit.ValueCallback<String> valueCallback, URL url) {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(str2);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            WebView webView = this.a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<IX5JsValue> valueCallback, URL url) {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.2
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str2) {
                    valueCallback.onReceiveValue(null);
                }
            });
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i2) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            WebView webView = this.a;
            if (webView == null) {
                return;
            }
            webView.removeJavascriptInterface(str);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i2, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.f18837c = new HashSet<>();
        this.a = context;
        this.b = X5JsCore.a(context, looper);
    }

    protected IX5JsContext a() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.createJsContext();
        }
        a aVar = new a(this.a);
        this.f18837c.add(new WeakReference<>(aVar));
        return aVar;
    }

    public void destroy() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        for (WeakReference<a> weakReference : this.f18837c) {
            if (weakReference.get() != null) {
                weakReference.get().destroy();
            }
        }
    }

    public Looper getLooper() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        return iX5JsVirtualMachine != null ? iX5JsVirtualMachine.getLooper() : Looper.myLooper();
    }

    public boolean isFallback() {
        return this.b == null;
    }

    public void onPause() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        for (WeakReference<a> weakReference : this.f18837c) {
            if (weakReference.get() != null) {
                weakReference.get().a();
            }
        }
    }

    public void onResume() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        for (WeakReference<a> weakReference : this.f18837c) {
            if (weakReference.get() != null) {
                weakReference.get().b();
            }
        }
    }
}
