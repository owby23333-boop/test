package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class s {

    /* JADX INFO: compiled from: ViewUtils.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f15543s;

        a(View view) {
            this.f15543s = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f15543s.getContext().getSystemService("input_method")).showSoftInput(this.f15543s, 1);
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class b implements e {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f15545d;

        b(boolean z2, boolean z3, boolean z4, e eVar) {
            this.a = z2;
            this.b = z3;
            this.f15544c = z4;
            this.f15545d = eVar;
        }

        @Override // com.google.android.material.internal.s.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            if (this.a) {
                fVar.f15547d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean zE = s.e(view);
            if (this.b) {
                if (zE) {
                    fVar.f15546c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f15544c) {
                if (zE) {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    fVar.f15546c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            fVar.a(view);
            e eVar = this.f15545d;
            return eVar != null ? eVar.a(view, windowInsetsCompat, fVar) : windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class c implements OnApplyWindowInsetsListener {
        final /* synthetic */ e a;
        final /* synthetic */ f b;

        c(e eVar, f fVar) {
            this.a = eVar;
            this.b = fVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.a.a(view, windowInsetsCompat, new f(this.b));
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface e {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f fVar);
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Nullable
    public static r b(@NonNull View view) {
        return c(a(view));
    }

    @Nullable
    public static r c(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 18 ? new q(view) : p.a(view);
    }

    public static float d(@NonNull View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ViewCompat.getElevation((View) parent);
        }
        return elevation;
    }

    public static boolean e(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static void f(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void g(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class f {
        public int a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15547d;

        public f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.b = i3;
            this.f15546c = i4;
            this.f15547d = i5;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.a, this.b, this.f15546c, this.f15547d);
        }

        public f(@NonNull f fVar) {
            this.a = fVar.a;
            this.b = fVar.b;
            this.f15546c = fVar.f15546c;
            this.f15547d = fVar.f15547d;
        }
    }

    public static float a(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static void a(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable e eVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i2, i3);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        a(view, new b(z2, z3, z4, eVar));
    }

    public static void a(@NonNull View view, @NonNull e eVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(eVar, new f(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        f(view);
    }

    @Nullable
    public static ViewGroup a(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }
}
