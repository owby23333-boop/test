package com.yuewen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.SparseArray;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface fk1 extends ViewParent, ViewManager, Drawable.Callback, KeyEvent.Callback, AccessibilityEventSource {
    void addJavascriptInterface(Object obj, String str);

    void autofill(SparseArray<AutofillValue> sparseArray);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    void clearCache(boolean z);

    void clearFormData();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    void computeScroll();

    PrintDocumentAdapter createPrintDocumentAdapter(String str);

    void destroy();

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void documentHasImages(Message message);

    void findAllAsync(String str);

    View findFocus();

    void findNext(boolean z);

    void flingScroll(int i, int i2);

    CharSequence getAccessibilityClassName();

    AccessibilityNodeProvider getAccessibilityNodeProvider();

    int getContentHeight();

    Context getContext();

    Bitmap getFavicon();

    Handler getHandler();

    String getOriginalUrl();

    int getProgress();

    boolean getRendererPriorityWaivedWhenNotVisible();

    int getRendererRequestedPriority();

    String getTitle();

    String getUrl();

    @NonNull
    Looper getWebViewLooper();

    void goBack();

    void goBackOrForward(int i);

    void goForward();

    void invokeZoomPicker();

    boolean isPrivateBrowsingEnabled();

    boolean isVisibleToUserForAutofill(int i);

    void loadData(String str, @Nullable String str2, @Nullable String str3);

    void loadDataWithBaseURL(@Nullable String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    boolean onCheckIsTextEditor();

    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    boolean onDragEvent(DragEvent dragEvent);

    void onFinishTemporaryDetach();

    boolean onGenericMotionEvent(MotionEvent motionEvent);

    boolean onHoverEvent(MotionEvent motionEvent);

    @Override // android.view.KeyEvent.Callback
    boolean onKeyDown(int i, KeyEvent keyEvent);

    @Override // android.view.KeyEvent.Callback
    boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent);

    @Override // android.view.KeyEvent.Callback
    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onPause();

    void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i);

    void onProvideVirtualStructure(ViewStructure viewStructure);

    void onResume();

    void onStartTemporaryDetach();

    boolean onTouchEvent(MotionEvent motionEvent);

    boolean onTrackballEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    boolean pageDown(boolean z);

    boolean pageUp(boolean z);

    void pauseTimers();

    boolean performLongClick();

    void postUrl(String str, byte[] bArr);

    void reload();

    void removeJavascriptInterface(@NonNull String str);

    @Override // android.view.ViewParent
    boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z);

    boolean requestFocus();

    boolean requestFocus(int i, Rect rect);

    void requestFocusNodeHref(@Nullable Message message);

    void requestImageRef(Message message);

    void resumeTimers();

    void saveWebArchive(String str);

    void setBackgroundColor(int i);

    void setInitialScale(int i);

    void setLayerType(int i, Paint paint);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setOverScrollMode(int i);

    void setRendererPriorityPolicy(int i, boolean z);

    void setScrollBarStyle(int i);

    void stopLoading();

    void zoomBy(float f);

    boolean zoomIn();

    boolean zoomOut();
}
