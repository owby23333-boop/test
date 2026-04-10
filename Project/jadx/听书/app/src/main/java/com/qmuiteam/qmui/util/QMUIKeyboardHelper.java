package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIKeyboardHelper {
    public static final int KEYBOARD_VISIBLE_THRESHOLD_DP = 100;
    public static final int SHOW_KEYBOARD_DELAY_TIME = 200;
    private static final String TAG = "QMUIKeyboardHelper";

    public interface KeyboardVisibilityEventListener {
        boolean onVisibilityChanged(boolean z, int i);
    }

    public static void showKeyboard(EditText editText, boolean z) {
        showKeyboard(editText, z ? 200 : 0);
    }

    public static void showKeyboard(final EditText editText, int i) {
        if (editText == null) {
            return;
        }
        if (!editText.requestFocus()) {
            Log.w(TAG, "showSoftInput() can not get focus");
        } else if (i > 0) {
            editText.postDelayed(new Runnable() { // from class: com.qmuiteam.qmui.util.QMUIKeyboardHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ((InputMethodManager) editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput(editText, 1);
                }
            }, i);
        } else {
            ((InputMethodManager) editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }

    public static boolean hideKeyboard(View view) {
        if (view == null) {
            return false;
        }
        return ((InputMethodManager) view.getContext().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public static void listenKeyBoardWithOffsetSelf(final View view, final boolean z) {
        ViewCompat.setWindowInsetsAnimationCallback(view, new WindowInsetsAnimationCompat.Callback(0) { // from class: com.qmuiteam.qmui.util.QMUIKeyboardHelper.2
            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
                int i = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                if (z) {
                    i -= windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).bottom;
                }
                QMUIViewHelper.getOrCreateOffsetHelper(view).setTopAndBottomOffset(-i);
                return windowInsetsCompat;
            }
        });
    }

    public static void listenKeyBoardWithOffsetSelfHalf(final View view, final boolean z) {
        ViewCompat.setWindowInsetsAnimationCallback(view, new WindowInsetsAnimationCompat.Callback(0) { // from class: com.qmuiteam.qmui.util.QMUIKeyboardHelper.3
            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
                int i = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                if (z) {
                    i -= windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).bottom;
                }
                QMUIViewHelper.getOrCreateOffsetHelper(view).setTopAndBottomOffset((-i) / 2);
                return windowInsetsCompat;
            }
        });
    }

    public static void setVisibilityEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        if (activity == null) {
            throw new NullPointerException("Parameter:activity must not be null");
        }
        if (keyboardVisibilityEventListener == null) {
            throw new NullPointerException("Parameter:listener must not be null");
        }
        final View activityRoot = QMUIViewHelper.getActivityRoot(activity);
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(activity, activityRoot, keyboardVisibilityEventListener) { // from class: com.qmuiteam.qmui.util.QMUIKeyboardHelper.4
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ View val$activityRoot;
            final /* synthetic */ KeyboardVisibilityEventListener val$listener;
            private final int visibleThreshold;
            private final Rect r = new Rect();
            private boolean wasOpened = false;

            {
                this.val$activity = activity;
                this.val$activityRoot = activityRoot;
                this.val$listener = keyboardVisibilityEventListener;
                this.visibleThreshold = Math.round(QMUIDisplayHelper.dp2px(activity, 100));
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                this.val$activityRoot.getWindowVisibleDisplayFrame(this.r);
                int height = this.val$activityRoot.getRootView().getHeight() - this.r.height();
                boolean z = height > this.visibleThreshold;
                if (z == this.wasOpened) {
                    return;
                }
                this.wasOpened = z;
                if (this.val$listener.onVisibilityChanged(z, height)) {
                    this.val$activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        activity.getApplication().registerActivityLifecycleCallbacks(new QMUIActivityLifecycleCallbacks(activity) { // from class: com.qmuiteam.qmui.util.QMUIKeyboardHelper.5
            @Override // com.qmuiteam.qmui.util.QMUIActivityLifecycleCallbacks
            protected void onTargetActivityDestroyed() {
                activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        });
    }

    public static boolean isKeyboardVisible(Activity activity) {
        Rect rect = new Rect();
        View activityRoot = QMUIViewHelper.getActivityRoot(activity);
        int iRound = Math.round(QMUIDisplayHelper.dp2px(activity, 100));
        activityRoot.getWindowVisibleDisplayFrame(rect);
        return activityRoot.getRootView().getHeight() - rect.height() > iRound;
    }
}
