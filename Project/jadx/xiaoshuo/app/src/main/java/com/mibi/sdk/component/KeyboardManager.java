package com.mibi.sdk.component;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes13.dex */
public class KeyboardManager {
    private View mDecoreView;
    private IKeyboardChangedListener mKeyboardChangedListener;

    public interface IKeyboardChangedListener {
        void onKeyboardStateChanged(boolean z, int i);
    }

    public class WindowLayoutChangedListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final Rect windowVisibleDisplayFrame;

        private WindowLayoutChangedListener() {
            this.windowVisibleDisplayFrame = new Rect();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            KeyboardManager.this.mDecoreView.getWindowVisibleDisplayFrame(this.windowVisibleDisplayFrame);
            if (this.windowVisibleDisplayFrame.bottom < KeyboardManager.this.mDecoreView.getHeight()) {
                KeyboardManager.this.mKeyboardChangedListener.onKeyboardStateChanged(true, KeyboardManager.this.mDecoreView.getHeight() - this.windowVisibleDisplayFrame.bottom);
            } else {
                KeyboardManager.this.mKeyboardChangedListener.onKeyboardStateChanged(false, 0);
            }
        }
    }

    private KeyboardManager(View view, IKeyboardChangedListener iKeyboardChangedListener) {
        this.mDecoreView = view;
        this.mKeyboardChangedListener = iKeyboardChangedListener;
        init();
    }

    public static KeyboardManager get(View view, IKeyboardChangedListener iKeyboardChangedListener) {
        return new KeyboardManager(view, iKeyboardChangedListener);
    }

    private void init() {
        this.mDecoreView.getViewTreeObserver().addOnGlobalLayoutListener(new WindowLayoutChangedListener());
    }

    public void release() {
        this.mDecoreView = null;
        this.mKeyboardChangedListener = null;
    }
}
