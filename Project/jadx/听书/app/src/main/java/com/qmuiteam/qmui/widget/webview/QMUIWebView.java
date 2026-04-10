package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWebView extends WebView {
    private static final String TAG = "QMUIWebView";
    private static boolean sIsReflectionOccurError;
    private Object mAwContents;
    private Callback mCallback;
    private boolean mNeedDispatchSafeAreaInset;
    private List<OnScrollChangeListener> mOnScrollChangeListeners;
    private Rect mSafeAreaRectCache;
    private Method mSetDisplayCutoutSafeAreaMethod;
    private Object mWebContents;

    public interface Callback {
        void onSureNotSupportChangeCssEnv();
    }

    public interface OnScrollChangeListener {
        void onScrollChange(WebView webView, int i, int i2, int i3, int i4);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
    }

    protected int getExtraInsetBottom(float f) {
        return 0;
    }

    protected int getExtraInsetLeft(float f) {
        return 0;
    }

    protected int getExtraInsetRight(float f) {
        return 0;
    }

    protected int getExtraInsetTop(float f) {
        return 0;
    }

    public QMUIWebView(Context context) {
        super(context);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new ArrayList();
        init();
    }

    public QMUIWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new ArrayList();
        init();
    }

    public QMUIWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNeedDispatchSafeAreaInset = false;
        this.mOnScrollChangeListeners = new ArrayList();
        init();
    }

    private void init() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        QMUIWindowInsetHelper.handleWindowInsets(this, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout(), new QMUIWindowInsetHelper.InsetHandler() { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebView.1
            @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
            public void handleInset(View view, Insets insets) {
                if (QMUIWebView.this.mNeedDispatchSafeAreaInset) {
                    float density = QMUIDisplayHelper.getDensity(QMUIWebView.this.getContext());
                    QMUIWebView.this.setStyleDisplayCutoutSafeArea(new Rect((int) ((insets.left / density) + QMUIWebView.this.getExtraInsetLeft(density)), (int) ((insets.f59top / density) + QMUIWebView.this.getExtraInsetTop(density)), (int) ((insets.right / density) + QMUIWebView.this.getExtraInsetRight(density)), (int) ((insets.bottom / density) + QMUIWebView.this.getExtraInsetBottom(density))));
                }
            }
        }, true, false, false);
    }

    @Deprecated
    public void setCustomOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        addCustomOnScrollChangeListener(onScrollChangeListener);
    }

    public void addCustomOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        if (this.mOnScrollChangeListeners.contains(onScrollChangeListener)) {
            return;
        }
        this.mOnScrollChangeListeners.add(onScrollChangeListener);
    }

    public void removeOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListeners.remove(onScrollChangeListener);
    }

    public void removeAllOnScrollChangeListener() {
        this.mOnScrollChangeListeners.clear();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        Iterator<OnScrollChangeListener> it = this.mOnScrollChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollChange(this, i, i2, i3, i4);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null && !(webViewClient instanceof QMUIWebViewClient)) {
            throw new IllegalArgumentException("must use the instance of QMUIWebViewClient");
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setNeedDispatchSafeAreaInset(boolean z) {
        if (this.mNeedDispatchSafeAreaInset != z) {
            this.mNeedDispatchSafeAreaInset = z;
            if (ViewCompat.isAttachedToWindow(this)) {
                if (z) {
                    ViewCompat.requestApplyInsets(this);
                } else {
                    setStyleDisplayCutoutSafeArea(new Rect());
                }
            }
        }
    }

    public boolean isNeedDispatchSafeAreaInset() {
        return this.mNeedDispatchSafeAreaInset;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private void doNotSupportChangeCssEnv() {
        sIsReflectionOccurError = true;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSureNotSupportChangeCssEnv();
        }
    }

    boolean isNotSupportChangeCssEnv() {
        return sIsReflectionOccurError;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.mAwContents = null;
        this.mWebContents = null;
        this.mSetDisplayCutoutSafeAreaMethod = null;
        stopLoading();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyleDisplayCutoutSafeArea(Rect rect) {
        Rect rect2;
        if (sIsReflectionOccurError || rect == (rect2 = this.mSafeAreaRectCache)) {
            return;
        }
        if (rect2 == null) {
            this.mSafeAreaRectCache = new Rect(rect);
        } else {
            rect2.set(rect);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mAwContents == null || this.mWebContents == null || this.mSetDisplayCutoutSafeAreaMethod == null) {
            try {
                Field declaredField = WebView.class.getDeclaredField("mProvider");
                declaredField.setAccessible(true);
                Object awContentsFieldValueInProvider = getAwContentsFieldValueInProvider(declaredField.get(this));
                this.mAwContents = awContentsFieldValueInProvider;
                if (awContentsFieldValueInProvider == null) {
                    return;
                }
                Object webContentsFieldValueInAwContents = getWebContentsFieldValueInAwContents(awContentsFieldValueInProvider);
                this.mWebContents = webContentsFieldValueInAwContents;
                if (webContentsFieldValueInAwContents == null) {
                    return;
                }
                Method setDisplayCutoutSafeAreaMethodInWebContents = getSetDisplayCutoutSafeAreaMethodInWebContents(webContentsFieldValueInAwContents);
                this.mSetDisplayCutoutSafeAreaMethod = setDisplayCutoutSafeAreaMethodInWebContents;
                if (setDisplayCutoutSafeAreaMethodInWebContents == null) {
                    doNotSupportChangeCssEnv();
                    return;
                }
            } catch (Exception e) {
                doNotSupportChangeCssEnv();
                Log.i(TAG, "setStyleDisplayCutoutSafeArea error: " + e);
            }
        }
        try {
            this.mSetDisplayCutoutSafeAreaMethod.setAccessible(true);
            this.mSetDisplayCutoutSafeAreaMethod.invoke(this.mWebContents, rect);
        } catch (Exception e2) {
            sIsReflectionOccurError = true;
            Log.i(TAG, "setStyleDisplayCutoutSafeArea error: " + e2);
        }
        Log.i(TAG, "setDisplayCutoutSafeArea speed time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets(this);
    }

    private Object getAwContentsFieldValueInProvider(Object obj) throws IllegalAccessException, NoSuchFieldException {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mAwContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (NoSuchFieldException unused) {
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("AwContents")) {
                return obj2;
            }
        }
        return null;
    }

    private Object getWebContentsFieldValueInAwContents(Object obj) throws IllegalAccessException {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mWebContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (NoSuchFieldException unused) {
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("WebContentsImpl")) {
                return obj2;
            }
        }
        return null;
    }

    private Method getSetDisplayCutoutSafeAreaMethodInWebContents(Object obj) {
        try {
            return obj.getClass().getDeclaredMethod("setDisplayCutoutSafeArea", Rect.class);
        } catch (NoSuchMethodException unused) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.getReturnType() == Void.TYPE && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == Rect.class) {
                    return method;
                }
            }
            return null;
        }
    }
}
