package com.lxj.xpopup.util;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.BasePopupView;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyboardUtils {
    public static int a;
    private static final SparseArray<ViewTreeObserver.OnGlobalLayoutListener> b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f17535c = 0;

    private static class SoftInputReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Context f17536s;

        public SoftInputReceiver(Context context) {
            super(new Handler());
            this.f17536s = context;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i2, Bundle bundle) {
            super.onReceiveResult(i2, bundle);
            if (i2 == 1 || i2 == 3) {
                KeyboardUtils.a(this.f17536s);
            }
            this.f17536s = null;
        }
    }

    static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Window f17537s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int[] f17538t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ b f17539u;

        a(Window window, int[] iArr, b bVar) {
            this.f17537s = window;
            this.f17538t = iArr;
            this.f17539u = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int iB = KeyboardUtils.b(this.f17537s);
            if (this.f17538t[0] != iB) {
                this.f17539u.a(iB);
                this.f17538t[0] = iB;
            }
        }
    }

    public interface b {
        void a(int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        String str = "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom);
        int iAbs = Math.abs(decorView.getBottom() - rect.bottom);
        if (iAbs > com.lxj.xpopup.util.b.b() + com.lxj.xpopup.util.b.c()) {
            return iAbs - f17535c;
        }
        f17535c = iAbs;
        return 0;
    }

    public static void c(@NonNull Window window) {
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            View decorView = window.getDecorView();
            View viewFindViewWithTag = decorView.findViewWithTag("keyboardTagView");
            if (viewFindViewWithTag == null) {
                viewFindViewWithTag = new EditText(window.getContext());
                viewFindViewWithTag.setTag("keyboardTagView");
                ((ViewGroup) decorView).addView(viewFindViewWithTag, 0, 0);
            }
            currentFocus = viewFindViewWithTag;
            currentFocus.requestFocus();
        }
        a(currentFocus);
    }

    public static void a(Window window, BasePopupView basePopupView, b bVar) {
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
        a aVar = new a(window, new int[]{b(window)}, bVar);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        b.append(basePopupView.getId(), aVar);
    }

    public static void a(Window window, BasePopupView basePopupView) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        View viewFindViewById = window.findViewById(R.id.content);
        if (viewFindViewById == null || (onGlobalLayoutListener = b.get(basePopupView.getId())) == null) {
            return;
        }
        viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        b.remove(basePopupView.getId());
    }

    public static void b(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0, new SoftInputReceiver(view.getContext()));
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void a(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
