package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: compiled from: BottomSheetDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends AppCompatDialog {
    private BottomSheetBehavior.g A;
    private boolean B;

    @NonNull
    private BottomSheetBehavior.g C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f15088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FrameLayout f15089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CoordinatorLayout f15090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FrameLayout f15091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f15092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f15093x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15095z;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class C0318a implements OnApplyWindowInsetsListener {
        C0318a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (a.this.A != null) {
                a.this.f15088s.b(a.this.A);
            }
            if (windowInsetsCompat != null) {
                a aVar = a.this;
                aVar.A = new f(aVar.f15091v, windowInsetsCompat, null);
                a.this.f15088s.a(a.this.A);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f15093x && aVar.isShowing() && a.this.b()) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!a.this.f15093x) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                a aVar = a.this;
                if (aVar.f15093x) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class d implements View.OnTouchListener {
        d(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, int i2) {
            if (i2 == 5) {
                a.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetDialog.java */
    private static class f extends BottomSheetBehavior.g {
        private final boolean a;
        private final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindowInsetsCompat f15097c;

        /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, C0318a c0318a) {
            this(view, windowInsetsCompat);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, int i2) {
            a(view);
        }

        private f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f15097c = windowInsetsCompat;
            this.b = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            MaterialShapeDrawable materialShapeDrawableB = BottomSheetBehavior.b(view).b();
            ColorStateList colorStateListF = materialShapeDrawableB != null ? materialShapeDrawableB.f() : ViewCompat.getBackgroundTintList(view);
            if (colorStateListF != null) {
                this.a = com.google.android.material.c.a.a(colorStateListF.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.a = com.google.android.material.c.a.a(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.a = this.b;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@NonNull View view, float f2) {
            a(view);
        }

        private void a(View view) {
            if (view.getTop() < this.f15097c.getSystemWindowInsetTop()) {
                a.a(view, this.a);
                view.setPadding(view.getPaddingLeft(), this.f15097c.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.a(view, this.b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }
    }

    public a(@NonNull Context context, @StyleRes int i2) {
        super(context, getThemeResId(context, i2));
        this.f15093x = true;
        this.f15094y = true;
        this.C = new e();
        supportRequestWindowFeature(1);
        this.B = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int getThemeResId(@NonNull Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorA = a();
        if (!this.f15092w || bottomSheetBehaviorA.c() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorA.f(5);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z2 = this.B && Color.alpha(window.getNavigationBarColor()) < 255;
        FrameLayout frameLayout = this.f15089t;
        if (frameLayout != null) {
            frameLayout.setFitsSystemWindows(!z2);
        }
        CoordinatorLayout coordinatorLayout = this.f15090u;
        if (coordinatorLayout != null) {
            coordinatorLayout.setFitsSystemWindows(!z2);
        }
        if (z2) {
            window.getDecorView().setSystemUiVisibility(768);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (Build.VERSION.SDK_INT < 23) {
                    window.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f15088s;
        if (bottomSheetBehavior == null || bottomSheetBehavior.c() != 5) {
            return;
        }
        this.f15088s.f(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f15093x != z2) {
            this.f15093x = z2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f15088s;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.d(z2);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f15093x) {
            this.f15093x = true;
        }
        this.f15094y = z2;
        this.f15095z = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(a(i2, null, null));
    }

    private FrameLayout c() {
        if (this.f15089t == null) {
            this.f15089t = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f15090u = (CoordinatorLayout) this.f15089t.findViewById(R$id.coordinator);
            this.f15091v = (FrameLayout) this.f15089t.findViewById(R$id.design_bottom_sheet);
            this.f15088s = BottomSheetBehavior.b(this.f15091v);
            this.f15088s.a(this.C);
            this.f15088s.d(this.f15093x);
        }
        return this.f15089t;
    }

    boolean b() {
        if (!this.f15095z) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.f15094y = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f15095z = true;
        }
        return this.f15094y;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> a() {
        if (this.f15088s == null) {
            c();
        }
        return this.f15088s;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    private View a(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        c();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f15089t.findViewById(R$id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        if (this.B) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f15091v, new C0318a());
        }
        this.f15091v.removeAllViews();
        if (layoutParams == null) {
            this.f15091v.addView(view);
        } else {
            this.f15091v.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.f15091v, new c());
        this.f15091v.setOnTouchListener(new d(this));
        return this.f15089t;
    }

    public static void a(@NonNull View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z2 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }
}
