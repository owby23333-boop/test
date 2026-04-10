package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class X5JsCore {
    private static a a;
    private static a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f18983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f18984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f18985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f18986f;

    private enum a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE
    }

    static {
        a aVar = a.UNINITIALIZED;
        a = aVar;
        b = aVar;
        f18983c = aVar;
    }

    @Deprecated
    public X5JsCore(Context context) {
        Object objA;
        this.f18985e = null;
        this.f18986f = null;
        this.f18984d = context;
        if (canUseX5JsCore(context) && (objA = a("createX5JavaBridge", new Class[]{Context.class}, context)) != null) {
            this.f18985e = objA;
        } else {
            this.f18986f = new WebView(context);
            this.f18986f.getSettings().setJavaScriptEnabled(true);
        }
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        Object objA;
        if (!canUseX5JsCore(context) || (objA = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper)) == null) {
            return null;
        }
        return (IX5JsVirtualMachine) objA;
    }

    protected static Object a() {
        return a("currentContextData", new Class[0], new Object[0]);
    }

    private static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            w wVarA = w.a();
            if (wVarA != null && wVarA.b()) {
                return wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            String str2 = "X5Jscore#" + str + " - x5CoreEngine is null or is not x5core.";
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        if (a != a.UNINITIALIZED) {
            return a == a.AVAILABLE;
        }
        a = a.UNAVAILABLE;
        Object objA = a("canUseX5JsCore", new Class[]{Context.class}, context);
        if (objA == null || !(objA instanceof Boolean) || !((Boolean) objA).booleanValue()) {
            return false;
        }
        a("setJsValueFactory", new Class[]{Object.class}, JsValue.a());
        a = a.AVAILABLE;
        return true;
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        if (f18983c != a.UNINITIALIZED) {
            return f18983c == a.AVAILABLE;
        }
        f18983c = a.UNAVAILABLE;
        Object objA = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
        if (objA == null || !(objA instanceof Boolean) || !((Boolean) objA).booleanValue()) {
            return false;
        }
        f18983c = a.AVAILABLE;
        return true;
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        Object objA;
        if (b != a.UNINITIALIZED) {
            return b == a.AVAILABLE;
        }
        b = a.UNAVAILABLE;
        if (!canUseX5JsCore(context) || (objA = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context)) == null || !(objA instanceof Boolean) || !((Boolean) objA).booleanValue()) {
            return false;
        }
        b = a.AVAILABLE;
        return true;
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Object obj2 = this.f18985e;
        if (obj2 != null) {
            a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, obj2);
            return;
        }
        WebView webView = this.f18986f;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
            this.f18986f.loadUrl(com.anythink.core.common.res.d.a);
        }
    }

    @Deprecated
    public void destroy() {
        Object obj = this.f18985e;
        if (obj != null) {
            a("destroyX5JsCore", new Class[]{Object.class}, obj);
            this.f18985e = null;
            return;
        }
        WebView webView = this.f18986f;
        if (webView != null) {
            webView.clearHistory();
            this.f18986f.clearCache(true);
            this.f18986f.loadUrl(com.anythink.core.common.res.d.a);
            this.f18986f.freeMemory();
            this.f18986f.pauseTimers();
            this.f18986f.destroy();
            this.f18986f = null;
        }
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Object obj = this.f18985e;
        if (obj != null) {
            a("evaluateJavascript", new Class[]{String.class, android.webkit.ValueCallback.class, Object.class}, str, valueCallback, obj);
            return;
        }
        WebView webView = this.f18986f;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i2) {
        Object objA;
        if (this.f18985e == null || !canX5JsCoreUseNativeBuffer(this.f18984d) || (objA = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.f18985e, Integer.valueOf(i2))) == null || !(objA instanceof ByteBuffer)) {
            return null;
        }
        return (ByteBuffer) objA;
    }

    @Deprecated
    public int getNativeBufferId() {
        Object objA;
        if (this.f18985e == null || !canX5JsCoreUseNativeBuffer(this.f18984d) || (objA = a("getNativeBufferId", new Class[]{Object.class}, this.f18985e)) == null || !(objA instanceof Integer)) {
            return -1;
        }
        return ((Integer) objA).intValue();
    }

    @Deprecated
    public void pause() {
        Object obj = this.f18985e;
        if (obj != null) {
            a(com.anythink.expressad.foundation.d.c.cb, new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void pauseTimers() {
        Object obj = this.f18985e;
        if (obj != null) {
            a("pauseTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        Object obj = this.f18985e;
        if (obj != null) {
            a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, obj);
            return;
        }
        WebView webView = this.f18986f;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    @Deprecated
    public void resume() {
        Object obj = this.f18985e;
        if (obj != null) {
            a(com.anythink.expressad.foundation.d.c.cc, new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void resumeTimers() {
        Object obj = this.f18985e;
        if (obj != null) {
            a("resumeTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void setNativeBuffer(int i2, ByteBuffer byteBuffer) {
        if (this.f18985e == null || !canX5JsCoreUseNativeBuffer(this.f18984d)) {
            return;
        }
        a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.f18985e, Integer.valueOf(i2), byteBuffer);
    }
}
