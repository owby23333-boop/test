package com.qmuiteam.qmui.util;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWindowInsetHelper {
    public static final InsetHandler consumeInsetWithPaddingHandler = new InsetHandler() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.1
        @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
        public void handleInset(View view, Insets insets) {
            view.setPadding(insets.left, insets.f59top, insets.right, insets.bottom);
        }
    };
    public static final InsetHandler consumeInsetWithPaddingIgnoreBottomHandler = new InsetHandler() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.2
        @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
        public void handleInset(View view, Insets insets) {
            view.setPadding(insets.left, insets.f59top, insets.right, 0);
        }
    };
    public static final InsetHandler consumeInsetWithPaddingIgnoreTopHandler = new InsetHandler() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.3
        @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
        public void handleInset(View view, Insets insets) {
            view.setPadding(insets.left, 0, insets.right, insets.bottom);
        }
    };
    public static final InsetHandler consumeInsetWithPaddingWithGravityHandler = new InsetHandler() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.4
        @Override // com.qmuiteam.qmui.util.QMUIWindowInsetHelper.InsetHandler
        public void handleInset(View view, Insets insets) {
            Insets insetsAdapterInsetsWithGravity = QMUIWindowInsetHelper.adapterInsetsWithGravity(view, insets);
            view.setPadding(insetsAdapterInsetsWithGravity.left, insetsAdapterInsetsWithGravity.f59top, insetsAdapterInsetsWithGravity.right, insetsAdapterInsetsWithGravity.bottom);
        }
    };
    private static final OnApplyWindowInsetsListener sStopDispatchListener = new OnApplyWindowInsetsListener() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.5
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.CONSUMED;
        }
    };
    private static final OnApplyWindowInsetsListener sOverrideWithNothingHandleListener = new OnApplyWindowInsetsListener() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.6
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }
    };

    public interface InsetHandler {
        void handleInset(View view, Insets insets);
    }

    public static void handleWindowInsets(View view, int i) {
        handleWindowInsets(view, i, false);
    }

    public static void handleWindowInsets(View view, int i, boolean z) {
        handleWindowInsets(view, i, z, false);
    }

    public static void handleWindowInsets(View view, int i, boolean z, boolean z2) {
        handleWindowInsets(view, i, consumeInsetWithPaddingWithGravityHandler, z, z2, false);
    }

    public static void handleWindowInsets(View view, int i, boolean z, boolean z2, boolean z3) {
        handleWindowInsets(view, i, consumeInsetWithPaddingWithGravityHandler, z, z2, z3);
    }

    public static void handleWindowInsets(View view, final int i, final InsetHandler insetHandler, boolean z, final boolean z2, final boolean z3) {
        setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.7
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                if (view2.getFitsSystemWindows()) {
                    insetHandler.handleInset(view2, z2 ? windowInsetsCompat.getInsetsIgnoringVisibility(i) : windowInsetsCompat.getInsets(i));
                    if (z3) {
                        return WindowInsetsCompat.CONSUMED;
                    }
                }
                return windowInsetsCompat;
            }
        }, z);
    }

    public static void stopDispatchWindowInsets(View view) {
        setOnApplyWindowInsetsListener(view, sStopDispatchListener, true);
    }

    public static void overrideWithDoNotHandleWindowInsets(View view) {
        setOnApplyWindowInsetsListener(view, sOverrideWithNothingHandleListener, false);
    }

    public static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener, final boolean z) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.8
                WindowInsetsCompat mLastInsets = null;
                WindowInsets mReturnedInsets = null;

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                    boolean z2 = true;
                    if (Build.VERSION.SDK_INT < 30) {
                        QMUIWindowInsetHelper.callCompatInsetAnimationCallback(windowInsets, view);
                        if (windowInsetsCompat.equals(this.mLastInsets)) {
                            if (z) {
                                return this.mReturnedInsets;
                            }
                            z2 = false;
                        }
                        this.mLastInsets = windowInsetsCompat;
                    }
                    WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat);
                    if (Build.VERSION.SDK_INT >= 30) {
                        return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                    }
                    if (z2) {
                        ViewCompat.requestApplyInsets(view2);
                    }
                    WindowInsets windowInsets2 = windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                    this.mReturnedInsets = windowInsets2;
                    return windowInsets2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0060 A[PHI: r0 r1
  0x0060: PHI (r0v5 int) = (r0v1 int), (r0v6 int) binds: [B:40:0x005d, B:18:0x002e] A[DONT_GENERATE, DONT_INLINE]
  0x0060: PHI (r1v5 int) = (r1v1 int), (r1v6 int) binds: [B:40:0x005d, B:18:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0062 A[PHI: r0 r1
  0x0062: PHI (r0v4 int) = (r0v1 int), (r0v6 int) binds: [B:38:0x0059, B:15:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x0062: PHI (r1v4 int) = (r1v1 int), (r1v6 int) binds: [B:38:0x0059, B:15:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.core.graphics.Insets adapterInsetsWithGravity(android.view.View r8, androidx.core.graphics.Insets r9) {
        /*
            int r0 = r9.left
            int r1 = r9.right
            int r2 = r9.f59top
            int r9 = r9.bottom
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            boolean r3 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            r4 = 0
            if (r3 == 0) goto L31
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            int r3 = r8.width
            r5 = -2
            if (r3 != r5) goto L23
            int r3 = r8.leftToLeft
            if (r3 != 0) goto L1e
            r1 = r4
            goto L23
        L1e:
            int r3 = r8.rightToRight
            if (r3 != 0) goto L23
            r0 = r4
        L23:
            int r3 = r8.height
            if (r3 != r5) goto L63
            int r3 = r8.topToTop
            if (r3 != 0) goto L2c
            goto L62
        L2c:
            int r8 = r8.bottomToBottom
            if (r8 != 0) goto L63
            goto L60
        L31:
            boolean r3 = r8 instanceof android.widget.FrameLayout.LayoutParams
            r5 = -1
            if (r3 == 0) goto L3c
            r3 = r8
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r3 = r3.gravity
            goto L3d
        L3c:
            r3 = r5
        L3d:
            if (r3 != r5) goto L41
            r3 = 51
        L41:
            int r6 = r8.width
            if (r6 == r5) goto L51
            r6 = r3 & 7
            r7 = 3
            if (r6 == r7) goto L50
            r7 = 5
            if (r6 == r7) goto L4e
            goto L51
        L4e:
            r0 = r4
            goto L51
        L50:
            r1 = r4
        L51:
            int r8 = r8.height
            if (r8 == r5) goto L63
            r8 = r3 & 112(0x70, float:1.57E-43)
            r3 = 48
            if (r8 == r3) goto L62
            r3 = 80
            if (r8 == r3) goto L60
            goto L63
        L60:
            r2 = r4
            goto L63
        L62:
            r9 = r4
        L63:
            androidx.core.graphics.Insets r8 = androidx.core.graphics.Insets.of(r0, r2, r1, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.util.QMUIWindowInsetHelper.adapterInsetsWithGravity(android.view.View, androidx.core.graphics.Insets):androidx.core.graphics.Insets");
    }
}
