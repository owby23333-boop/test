package com.amgcyo.cuttadon.view.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.view.dialog.SaltedBottomSheetBehavior;
import com.fatcatfat.io.R;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class m1 extends AppCompatDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private SaltedBottomSheetBehavior<FrameLayout> f4747s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f4748t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4749u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f4750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ViewPager f4751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ViewPager.SimpleOnPageChangeListener f4752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private SaltedBottomSheetBehavior.c f4753y;

    /* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
    class a extends ViewPager.SimpleOnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            super.onPageSelected(i2);
            m1.this.f4747s.b(m1.this.f4751w.getChildAt(i2));
        }
    }

    /* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m1 m1Var = m1.this;
            if (m1Var.f4748t && m1Var.isShowing() && m1.this.a()) {
                m1.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
    class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!m1.this.f4748t) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                m1 m1Var = m1.this;
                if (m1Var.f4748t) {
                    m1Var.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
    class d implements View.OnTouchListener {
        d(m1 m1Var) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: SaltedBottomSheetDialog.java */
    class e extends SaltedBottomSheetBehavior.c {
        e() {
        }

        @Override // com.amgcyo.cuttadon.view.dialog.SaltedBottomSheetBehavior.c
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.amgcyo.cuttadon.view.dialog.SaltedBottomSheetBehavior.c
        public void a(@NonNull View view, int i2) {
            if (i2 == 5) {
                m1.this.cancel();
            }
        }
    }

    public m1(@NonNull Context context, @StyleRes int i2) {
        super(context, getThemeResId(context, i2));
        this.f4748t = true;
        this.f4749u = true;
        this.f4752x = new a();
        this.f4753y = new e();
        supportRequestWindowFeature(1);
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 2131821007;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        SaltedBottomSheetBehavior<FrameLayout> saltedBottomSheetBehavior = this.f4747s;
        if (saltedBottomSheetBehavior != null) {
            saltedBottomSheetBehavior.c(4);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f4748t != z2) {
            this.f4748t = z2;
            SaltedBottomSheetBehavior<FrameLayout> saltedBottomSheetBehavior = this.f4747s;
            if (saltedBottomSheetBehavior != null) {
                saltedBottomSheetBehavior.a(z2);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f4748t) {
            this.f4748t = true;
        }
        this.f4749u = z2;
        this.f4750v = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(a(i2, null, null));
    }

    public void a(ViewPager viewPager) {
        this.f4751w = viewPager;
        if (viewPager == null) {
            return;
        }
        viewPager.addOnPageChangeListener(this.f4752x);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    private View a(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.saltedfish_design_bottom_sheet_dialog, null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.f4747s = SaltedBottomSheetBehavior.c(frameLayout2);
        this.f4747s.a(this.f4753y);
        this.f4747s.a(this.f4748t);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(frameLayout2, new c());
        frameLayout2.setOnTouchListener(new d(this));
        return frameLayout;
    }

    boolean a() {
        if (!this.f4750v) {
            if (Build.VERSION.SDK_INT < 11) {
                this.f4749u = true;
            } else {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
                this.f4749u = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            }
            this.f4750v = true;
        }
        return this.f4749u;
    }
}
