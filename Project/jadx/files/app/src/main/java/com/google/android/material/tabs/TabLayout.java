package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int f15844l0 = R$style.Widget_Design_TabLayout;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final Pools.Pool<g> f15845m0 = new Pools.SynchronizedPool(16);
    ColorStateList A;
    ColorStateList B;
    ColorStateList C;

    @NonNull
    Drawable D;
    private int E;
    PorterDuff.Mode F;
    float G;
    float H;
    final int I;
    int J;
    private final int K;
    private final int L;
    private final int M;
    private int N;
    int O;
    int P;
    int Q;
    int R;
    boolean S;
    boolean T;
    int U;
    boolean V;
    private com.google.android.material.tabs.b W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    private c f15846a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final ArrayList<c> f15847b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    private c f15848c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private ValueAnimator f15849d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @Nullable
    ViewPager f15850e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @Nullable
    private PagerAdapter f15851f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private DataSetObserver f15852g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private h f15853h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private b f15854i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f15855j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Pools.Pool<i> f15856k0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ArrayList<g> f15857s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private g f15858t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    final f f15859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f15860v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f15861w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f15862x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f15863y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f15864z;

    /* JADX INFO: loaded from: classes.dex */
    public @interface LabelVisibility {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f15866s;

        b() {
        }

        void a(boolean z2) {
            this.f15866s = z2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f15850e0 == viewPager) {
                tabLayout.a(pagerAdapter2, this.f15866s);
            }
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t2);

        void b(T t2);

        void c(T t2);
    }

    public interface d extends c<g> {
    }

    private class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.d();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.d();
        }
    }

    class f extends LinearLayout {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        ValueAnimator f15868s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f15869t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        float f15870u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f15871v;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ View f15873s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ View f15874t;

            a(View view, View view2) {
                this.f15873s = view;
                this.f15874t = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                f.this.a(this.f15873s, this.f15874t, valueAnimator.getAnimatedFraction());
            }
        }

        class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ int f15876s;

            b(int i2) {
                this.f15876s = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.f15869t = this.f15876s;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f15869t = this.f15876s;
            }
        }

        f(Context context) {
            super(context);
            this.f15869t = -1;
            this.f15871v = -1;
            setWillNotDraw(false);
        }

        private void b() {
            View childAt = getChildAt(this.f15869t);
            com.google.android.material.tabs.b bVar = TabLayout.this.W;
            TabLayout tabLayout = TabLayout.this;
            bVar.a(tabLayout, childAt, tabLayout.D);
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int iHeight = TabLayout.this.D.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.D.getIntrinsicHeight();
            }
            int i2 = TabLayout.this.Q;
            int height = 0;
            if (i2 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i2 == 1) {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            } else if (i2 != 2) {
                iHeight = i2 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.D.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.D.getBounds();
                TabLayout.this.D.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawableWrap = tabLayout.D;
                if (tabLayout.E != 0) {
                    drawableWrap = DrawableCompat.wrap(drawableWrap);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawableWrap.setColorFilter(TabLayout.this.E, PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(drawableWrap, TabLayout.this.E);
                    }
                }
                drawableWrap.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f15868s;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
            } else {
                a(false, this.f15869t, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            boolean z2;
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.O == 1 || tabLayout.R == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) s.a(getContext(), 16)) * 2)) {
                    z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.O = 0;
                    tabLayout2.a(false);
                    z2 = true;
                }
                if (z2) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f15871v == i2) {
                return;
            }
            requestLayout();
            this.f15871v = i2;
        }

        void a(int i2) {
            Rect bounds = TabLayout.this.D.getBounds();
            TabLayout.this.D.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.f15868s;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f15868s.cancel();
            }
            this.f15869t = i2;
            this.f15870u = f2;
            a(getChildAt(this.f15869t), getChildAt(this.f15869t + 1), this.f15870u);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view, View view2, float f2) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.b bVar = TabLayout.this.W;
                TabLayout tabLayout = TabLayout.this;
                bVar.a(tabLayout, view, view2, f2, tabLayout.D);
            } else {
                Drawable drawable = TabLayout.this.D;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.D.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.f15868s;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f15868s.cancel();
            }
            a(true, i2, i3);
        }

        private void a(boolean z2, int i2, int i3) {
            View childAt = getChildAt(this.f15869t);
            View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                b();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z2) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f15868s = valueAnimator;
                valueAnimator.setInterpolator(com.google.android.material.a.a.b);
                valueAnimator.setDuration(i3);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i2));
                valueAnimator.start();
                return;
            }
            this.f15868s.removeAllUpdateListeners();
            this.f15868s.addUpdateListener(aVar);
        }
    }

    public static class g {

        @Nullable
        private Object a;

        @Nullable
        private Drawable b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private CharSequence f15878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private CharSequence f15879d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private View f15881f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public TabLayout f15883h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public i f15884i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f15880e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @LabelVisibility
        private int f15882g = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f15885j = -1;

        @Nullable
        public Object e() {
            return this.a;
        }

        @Nullable
        public CharSequence f() {
            return this.f15878c;
        }

        public boolean g() {
            TabLayout tabLayout = this.f15883h;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f15880e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            this.f15883h = null;
            this.f15884i = null;
            this.a = null;
            this.b = null;
            this.f15885j = -1;
            this.f15878c = null;
            this.f15879d = null;
            this.f15880e = -1;
            this.f15881f = null;
        }

        public void i() {
            TabLayout tabLayout = this.f15883h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.c(this);
        }

        void j() {
            i iVar = this.f15884i;
            if (iVar != null) {
                iVar.update();
            }
        }

        @NonNull
        public g a(@Nullable Object obj) {
            this.a = obj;
            return this;
        }

        @Nullable
        public Drawable b() {
            return this.b;
        }

        public int c() {
            return this.f15880e;
        }

        @LabelVisibility
        public int d() {
            return this.f15882g;
        }

        @Nullable
        public View a() {
            return this.f15881f;
        }

        void b(int i2) {
            this.f15880e = i2;
        }

        @NonNull
        public g a(@Nullable View view) {
            this.f15881f = view;
            j();
            return this;
        }

        @NonNull
        public g b(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f15879d) && !TextUtils.isEmpty(charSequence)) {
                this.f15884i.setContentDescription(charSequence);
            }
            this.f15878c = charSequence;
            j();
            return this;
        }

        @NonNull
        public g a(@LayoutRes int i2) {
            a(LayoutInflater.from(this.f15884i.getContext()).inflate(i2, (ViewGroup) this.f15884i, false));
            return this;
        }

        @NonNull
        public g a(@Nullable Drawable drawable) {
            this.b = drawable;
            TabLayout tabLayout = this.f15883h;
            if (tabLayout.O == 1 || tabLayout.R == 2) {
                this.f15883h.a(true);
            }
            j();
            if (com.google.android.material.badge.a.a && this.f15884i.d() && this.f15884i.f15893w.isVisible()) {
                this.f15884i.invalidate();
            }
            return this;
        }

        @NonNull
        public g a(@Nullable CharSequence charSequence) {
            this.f15879d = charSequence;
            j();
            return this;
        }
    }

    public static class h implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NonNull
        private final WeakReference<TabLayout> f15886s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f15887t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f15888u;

        public h(TabLayout tabLayout) {
            this.f15886s = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f15888u = 0;
            this.f15887t = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f15887t = this.f15888u;
            this.f15888u = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f15886s.get();
            if (tabLayout != null) {
                tabLayout.a(i2, f2, this.f15888u != 2 || this.f15887t == 1, (this.f15888u == 2 && this.f15887t == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.f15886s.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f15888u;
            tabLayout.b(tabLayout.a(i2), i3 == 0 || (i3 == 2 && this.f15887t == 0));
        }
    }

    public final class i extends LinearLayout {

        @Nullable
        private Drawable A;
        private int B;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private g f15889s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private TextView f15890t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private ImageView f15891u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        private View f15892v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @Nullable
        private BadgeDrawable f15893w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @Nullable
        private View f15894x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @Nullable
        private TextView f15895y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        @Nullable
        private ImageView f15896z;

        class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ View f15897s;

            a(View view) {
                this.f15897s = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.f15897s.getVisibility() == 0) {
                    i.this.d(this.f15897s);
                }
            }
        }

        public i(@NonNull Context context) {
            super(context);
            this.B = 2;
            a(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f15860v, TabLayout.this.f15861w, TabLayout.this.f15862x, TabLayout.this.f15863y);
            setGravity(17);
            setOrientation(!TabLayout.this.S ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        @NonNull
        private FrameLayout c() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(@NonNull View view) {
            if (d() && view == this.f15892v) {
                com.google.android.material.badge.a.b(this.f15893w, view, b(view));
            }
        }

        private void e() {
            FrameLayout frameLayoutC;
            if (com.google.android.material.badge.a.a) {
                frameLayoutC = c();
                addView(frameLayoutC, 0);
            } else {
                frameLayoutC = this;
            }
            this.f15891u = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) frameLayoutC, false);
            frameLayoutC.addView(this.f15891u, 0);
        }

        private void f() {
            FrameLayout frameLayoutC;
            if (com.google.android.material.badge.a.a) {
                frameLayoutC = c();
                addView(frameLayoutC);
            } else {
                frameLayoutC = this;
            }
            this.f15890t = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) frameLayoutC, false);
            frameLayoutC.addView(this.f15890t);
        }

        private void g() {
            if (d()) {
                a(true);
                View view = this.f15892v;
                if (view != null) {
                    com.google.android.material.badge.a.a(this.f15893w, view);
                    this.f15892v = null;
                }
            }
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.f15893w;
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.f15893w == null) {
                this.f15893w = BadgeDrawable.a(getContext());
            }
            h();
            BadgeDrawable badgeDrawable = this.f15893w;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h() {
            g gVar;
            g gVar2;
            if (d()) {
                if (this.f15894x != null) {
                    g();
                    return;
                }
                if (this.f15891u != null && (gVar2 = this.f15889s) != null && gVar2.b() != null) {
                    View view = this.f15892v;
                    ImageView imageView = this.f15891u;
                    if (view == imageView) {
                        d(imageView);
                        return;
                    } else {
                        g();
                        c(this.f15891u);
                        return;
                    }
                }
                if (this.f15890t == null || (gVar = this.f15889s) == null || gVar.d() != 1) {
                    g();
                    return;
                }
                View view2 = this.f15892v;
                TextView textView = this.f15890t;
                if (view2 == textView) {
                    d(textView);
                } else {
                    g();
                    c(this.f15890t);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.A;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.A.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            int iMax = 0;
            int iMin = 0;
            boolean z2 = false;
            for (View view : new View[]{this.f15890t, this.f15891u, this.f15894x}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z2 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z2 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z2 = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            int iMax = 0;
            int iMin = 0;
            boolean z2 = false;
            for (View view : new View[]{this.f15890t, this.f15891u, this.f15894x}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z2 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z2 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z2 = true;
                }
            }
            return iMax - iMin;
        }

        @Nullable
        public g getTab() {
            return this.f15889s;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f15893w;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f15893w.b()));
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f15889s.c(), 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatWrap.setClickable(false);
                accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.J, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f15890t != null) {
                float f2 = TabLayout.this.G;
                int i4 = this.B;
                ImageView imageView = this.f15891u;
                boolean z2 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f15890t;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.H;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f15890t.getTextSize();
                int lineCount = this.f15890t.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f15890t);
                if (f2 != textSize || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.R == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f15890t.getLayout()) == null || a(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z2 = false;
                    }
                    if (z2) {
                        this.f15890t.setTextSize(0, f2);
                        this.f15890t.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f15889s == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f15889s.i();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2 && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f15890t;
            if (textView != null) {
                textView.setSelected(z2);
            }
            ImageView imageView = this.f15891u;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f15894x;
            if (view != null) {
                view.setSelected(z2);
            }
        }

        void setTab(@Nullable g gVar) {
            if (gVar != this.f15889s) {
                this.f15889s = gVar;
                update();
            }
        }

        final void update() {
            g gVar = this.f15889s;
            Drawable drawableMutate = null;
            View viewA = gVar != null ? gVar.a() : null;
            if (viewA != null) {
                ViewParent parent = viewA.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewA);
                    }
                    addView(viewA);
                }
                this.f15894x = viewA;
                TextView textView = this.f15890t;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f15891u;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f15891u.setImageDrawable(null);
                }
                this.f15895y = (TextView) viewA.findViewById(R.id.text1);
                TextView textView2 = this.f15895y;
                if (textView2 != null) {
                    this.B = TextViewCompat.getMaxLines(textView2);
                }
                this.f15896z = (ImageView) viewA.findViewById(R.id.icon);
            } else {
                View view = this.f15894x;
                if (view != null) {
                    removeView(view);
                    this.f15894x = null;
                }
                this.f15895y = null;
                this.f15896z = null;
            }
            if (this.f15894x == null) {
                if (this.f15891u == null) {
                    e();
                }
                if (gVar != null && gVar.b() != null) {
                    drawableMutate = DrawableCompat.wrap(gVar.b()).mutate();
                }
                if (drawableMutate != null) {
                    DrawableCompat.setTintList(drawableMutate, TabLayout.this.B);
                    PorterDuff.Mode mode = TabLayout.this.F;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawableMutate, mode);
                    }
                }
                if (this.f15890t == null) {
                    f();
                    this.B = TextViewCompat.getMaxLines(this.f15890t);
                }
                TextViewCompat.setTextAppearance(this.f15890t, TabLayout.this.f15864z);
                ColorStateList colorStateList = TabLayout.this.A;
                if (colorStateList != null) {
                    this.f15890t.setTextColor(colorStateList);
                }
                a(this.f15890t, this.f15891u);
                h();
                a(this.f15891u);
                a(this.f15890t);
            } else if (this.f15895y != null || this.f15896z != null) {
                a(this.f15895y, this.f15896z);
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f15879d)) {
                setContentDescription(gVar.f15879d);
            }
            setSelected(gVar != null && gVar.g());
        }

        final void b() {
            setOrientation(!TabLayout.this.S ? 1 : 0);
            if (this.f15895y == null && this.f15896z == null) {
                a(this.f15890t, this.f15891u);
            } else {
                a(this.f15895y, this.f15896z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return this.f15893w != null;
        }

        private void c(@Nullable View view) {
            if (d() && view != null) {
                a(false);
                com.google.android.material.badge.a.a(this.f15893w, view, b(view));
                this.f15892v = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            int i2 = TabLayout.this.I;
            if (i2 != 0) {
                this.A = AppCompatResources.getDrawable(context, i2);
                Drawable drawable = this.A;
                if (drawable != null && drawable.isStateful()) {
                    this.A.setState(getDrawableState());
                }
            } else {
                this.A = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable layerDrawable = gradientDrawable;
            if (TabLayout.this.C != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = com.google.android.material.j.b.a(TabLayout.this.C);
                if (Build.VERSION.SDK_INT >= 21) {
                    GradientDrawable gradientDrawable3 = gradientDrawable;
                    if (TabLayout.this.V) {
                        gradientDrawable3 = null;
                    }
                    layerDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, TabLayout.this.V ? null : gradientDrawable2);
                } else {
                    Drawable drawableWrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(drawableWrap, colorStateListA);
                    layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableWrap});
                }
            }
            ViewCompat.setBackground(this, layerDrawable);
            TabLayout.this.invalidate();
        }

        @Nullable
        private FrameLayout b(@NonNull View view) {
            if ((view == this.f15891u || view == this.f15890t) && com.google.android.material.badge.a.a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(@NonNull Canvas canvas) {
            Drawable drawable = this.A;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.A.draw(canvas);
            }
        }

        void a() {
            setTab(null);
            setSelected(false);
        }

        private void a(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private void a(boolean z2) {
            setClipChildren(z2);
            setClipToPadding(z2);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z2);
                viewGroup.setClipToPadding(z2);
            }
        }

        private void a(@Nullable TextView textView, @Nullable ImageView imageView) {
            g gVar = this.f15889s;
            Drawable drawableMutate = (gVar == null || gVar.b() == null) ? null : DrawableCompat.wrap(this.f15889s.b()).mutate();
            g gVar2 = this.f15889s;
            CharSequence charSequenceF = gVar2 != null ? gVar2.f() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(charSequenceF);
            if (textView != null) {
                if (z2) {
                    textView.setText(charSequenceF);
                    if (this.f15889s.f15882g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iA = (z2 && imageView.getVisibility() == 0) ? (int) s.a(getContext(), 8) : 0;
                if (TabLayout.this.S) {
                    if (iA != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, iA);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iA != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iA;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f15889s;
            CharSequence charSequence = gVar3 != null ? gVar3.f15879d : null;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21 || i2 > 23) {
                if (z2) {
                    charSequence = charSequenceF;
                }
                TooltipCompat.setTooltipText(this, charSequence);
            }
        }

        private float a(@NonNull Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }
    }

    public static class j implements d {
        private final ViewPager a;

        public j(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@NonNull g gVar) {
            this.a.setCurrentItem(gVar.c());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void f(@NonNull g gVar) {
        for (int size = this.f15847b0.size() - 1; size >= 0; size--) {
            this.f15847b0.get(size).c(gVar);
        }
    }

    @NonNull
    private LinearLayout.LayoutParams g() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.f15857s.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f15857s.get(i2);
                if (gVar != null && gVar.b() != null && !TextUtils.isEmpty(gVar.f())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.S) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.K;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.R;
        if (i3 == 0 || i3 == 2) {
            return this.M;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f15859u.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h() {
        if (this.f15849d0 == null) {
            this.f15849d0 = new ValueAnimator();
            this.f15849d0.setInterpolator(com.google.android.material.a.a.b);
            this.f15849d0.setDuration(this.P);
            this.f15849d0.addUpdateListener(new a());
        }
    }

    private void i() {
        int size = this.f15857s.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15857s.get(i2).j();
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f15859u.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f15859u.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    @NonNull
    public g c() {
        g gVarA = a();
        gVarA.f15883h = this;
        gVarA.f15884i = e(gVarA);
        if (gVarA.f15885j != -1) {
            gVarA.f15884i.setId(gVarA.f15885j);
        }
        return gVarA;
    }

    void d() {
        int currentItem;
        e();
        PagerAdapter pagerAdapter = this.f15851f0;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g gVarC = c();
                gVarC.b(this.f15851f0.getPageTitle(i2));
                a(gVarC, false);
            }
            ViewPager viewPager = this.f15850e0;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            c(a(currentItem));
        }
    }

    public void e() {
        for (int childCount = this.f15859u.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<g> it = this.f15857s.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.h();
            b(next);
        }
        this.f15858t = null;
    }

    public int getSelectedTabPosition() {
        g gVar = this.f15858t;
        if (gVar != null) {
            return gVar.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f15857s.size();
    }

    public int getTabGravity() {
        return this.O;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.B;
    }

    public int getTabIndicatorAnimationMode() {
        return this.U;
    }

    public int getTabIndicatorGravity() {
        return this.Q;
    }

    int getTabMaxWidth() {
        return this.J;
    }

    public int getTabMode() {
        return this.R;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.C;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.D;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.a(this);
        if (this.f15850e0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f15855j0) {
            setupWithViewPager(null);
            this.f15855j0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i2 = 0; i2 < this.f15859u.getChildCount(); i2++) {
            View childAt = this.f15859u.getChildAt(i2);
            if (childAt instanceof i) {
                ((i) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.s.a(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.L
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.s.a(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.J = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.R
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.shape.h.a(this, f2);
    }

    public void setInlineLabel(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            for (int i2 = 0; i2 < this.f15859u.getChildCount(); i2++) {
                View childAt = this.f15859u.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).b();
                }
            }
            f();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        h();
        this.f15849d0.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.D != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.D = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.E = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.Q != i2) {
            this.Q = i2;
            ViewCompat.postInvalidateOnAnimation(this.f15859u);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f15859u.a(i2);
    }

    public void setTabGravity(int i2) {
        if (this.O != i2) {
            this.O = i2;
            f();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            i();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.U = i2;
        if (i2 == 0) {
            this.W = new com.google.android.material.tabs.b();
        } else {
            if (i2 == 1) {
                this.W = new com.google.android.material.tabs.a();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.T = z2;
        ViewCompat.postInvalidateOnAnimation(this.f15859u);
    }

    public void setTabMode(int i2) {
        if (i2 != this.R) {
            this.R = i2;
            f();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            for (int i2 = 0; i2 < this.f15859u.getChildCount(); i2++) {
                View childAt = this.f15859u.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            i();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        a(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.V != z2) {
            this.V = z2;
            for (int i2 = 0; i2 < this.f15859u.getChildCount(); i2++) {
                View childAt = this.f15859u.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        a(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Deprecated
    public void b(@Nullable c cVar) {
        this.f15847b0.remove(cVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.f15846a0;
        if (cVar2 != null) {
            b(cVar2);
        }
        this.f15846a0 = cVar;
        if (cVar != null) {
            a(cVar);
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f15844l0), attributeSet, i2);
        this.f15857s = new ArrayList<>();
        this.D = new GradientDrawable();
        this.E = 0;
        this.J = Integer.MAX_VALUE;
        this.f15847b0 = new ArrayList<>();
        this.f15856k0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        this.f15859u = new f(context2);
        super.addView(this.f15859u, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.TabLayout, i2, f15844l0, R$styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.a(context2);
            materialShapeDrawable.b(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(com.google.android.material.i.c.b(context2, typedArrayC, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayC.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        this.f15859u.a(typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayC.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayC.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(typedArrayC.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f15863y = dimensionPixelSize;
        this.f15862x = dimensionPixelSize;
        this.f15861w = dimensionPixelSize;
        this.f15860v = dimensionPixelSize;
        this.f15860v = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, this.f15860v);
        this.f15861w = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f15861w);
        this.f15862x = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f15862x);
        this.f15863y = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f15863y);
        this.f15864z = typedArrayC.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(this.f15864z, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.A = com.google.android.material.i.c.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayC.hasValue(R$styleable.TabLayout_tabTextColor)) {
                this.A = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.TabLayout_tabTextColor);
            }
            if (typedArrayC.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
                this.A = a(this.A.getDefaultColor(), typedArrayC.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.B = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.TabLayout_tabIconTint);
            this.F = s.a(typedArrayC.getInt(R$styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.C = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.TabLayout_tabRippleColor);
            this.P = typedArrayC.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.K = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.L = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.I = typedArrayC.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.N = typedArrayC.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.R = typedArrayC.getInt(R$styleable.TabLayout_tabMode, 1);
            this.O = typedArrayC.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.S = typedArrayC.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.V = typedArrayC.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayC.recycle();
            Resources resources = getResources();
            this.H = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.M = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            f();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void f() {
        int i2 = this.R;
        ViewCompat.setPaddingRelative(this.f15859u, (i2 == 0 || i2 == 2) ? Math.max(0, this.N - this.f15860v) : 0, 0, 0, 0);
        int i3 = this.R;
        if (i3 == 0) {
            c(this.O);
        } else if (i3 == 1 || i3 == 2) {
            int i4 = this.O;
            this.f15859u.setGravity(1);
        }
        a(true);
    }

    private void g(@NonNull g gVar) {
        for (int size = this.f15847b0.size() - 1; size >= 0; size--) {
            this.f15847b0.get(size).a(gVar);
        }
    }

    public void a(int i2, float f2, boolean z2, boolean z3) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.f15859u.getChildCount()) {
            return;
        }
        if (z3) {
            this.f15859u.a(i2, f2);
        }
        ValueAnimator valueAnimator = this.f15849d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f15849d0.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z2) {
            setSelectedTabView(iRound);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    protected boolean b(g gVar) {
        return f15845m0.release(gVar);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public boolean b() {
        return this.T;
    }

    private void b(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f15859u.a()) {
            int scrollX = getScrollX();
            int iA = a(i2, 0.0f);
            if (scrollX != iA) {
                h();
                this.f15849d0.setIntValues(scrollX, iA);
                this.f15849d0.start();
            }
            this.f15859u.a(i2, this.P);
            return;
        }
        a(i2, 0.0f, true);
    }

    private void h(@NonNull g gVar) {
        for (int size = this.f15847b0.size() - 1; size >= 0; size--) {
            this.f15847b0.get(size).b(gVar);
        }
    }

    public void c(@Nullable g gVar) {
        b(gVar, true);
    }

    private void c(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                this.f15859u.setGravity(1);
                return;
            } else if (i2 != 2) {
                return;
            }
        }
        this.f15859u.setGravity(GravityCompat.START);
    }

    private void d(@NonNull g gVar) {
        i iVar = gVar.f15884i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f15859u.addView(iVar, gVar.c(), g());
    }

    @NonNull
    private i e(@NonNull g gVar) {
        Pools.Pool<i> pool = this.f15856k0;
        i iVarAcquire = pool != null ? pool.acquire() : null;
        if (iVarAcquire == null) {
            iVarAcquire = new i(getContext());
        }
        iVarAcquire.setTab(gVar);
        iVarAcquire.setFocusable(true);
        iVarAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f15879d)) {
            iVarAcquire.setContentDescription(gVar.f15878c);
        } else {
            iVarAcquire.setContentDescription(gVar.f15879d);
        }
        return iVarAcquire;
    }

    public void a(@NonNull g gVar) {
        a(gVar, this.f15857s.isEmpty());
    }

    public void a(@NonNull g gVar, boolean z2) {
        a(gVar, this.f15857s.size(), z2);
    }

    public void a(@NonNull g gVar, int i2, boolean z2) {
        if (gVar.f15883h == this) {
            a(gVar, i2);
            d(gVar);
            if (z2) {
                gVar.i();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void d(int i2) {
        i iVar = (i) this.f15859u.getChildAt(i2);
        this.f15859u.removeViewAt(i2);
        if (iVar != null) {
            iVar.a();
            this.f15856k0.release(iVar);
        }
        requestLayout();
    }

    public void b(@Nullable g gVar, boolean z2) {
        g gVar2 = this.f15858t;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                f(gVar);
                b(gVar.c());
                return;
            }
            return;
        }
        int iC = gVar != null ? gVar.c() : -1;
        if (z2) {
            if ((gVar2 == null || gVar2.c() == -1) && iC != -1) {
                a(iC, 0.0f, true);
            } else {
                b(iC);
            }
            if (iC != -1) {
                setSelectedTabView(iC);
            }
        }
        this.f15858t = gVar;
        if (gVar2 != null) {
            h(gVar2);
        }
        if (gVar != null) {
            g(gVar);
        }
    }

    private void a(@NonNull TabItem tabItem) {
        g gVarC = c();
        CharSequence charSequence = tabItem.f15841s;
        if (charSequence != null) {
            gVarC.b(charSequence);
        }
        Drawable drawable = tabItem.f15842t;
        if (drawable != null) {
            gVarC.a(drawable);
        }
        int i2 = tabItem.f15843u;
        if (i2 != 0) {
            gVarC.a(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            gVarC.a(tabItem.getContentDescription());
        }
        a(gVarC);
    }

    public void a(@NonNull d dVar) {
        a((c) dVar);
    }

    @Deprecated
    public void a(@Nullable c cVar) {
        if (this.f15847b0.contains(cVar)) {
            return;
        }
        this.f15847b0.add(cVar);
    }

    protected g a() {
        g gVarAcquire = f15845m0.acquire();
        return gVarAcquire == null ? new g() : gVarAcquire;
    }

    @Nullable
    public g a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f15857s.get(i2);
    }

    public void a(@Nullable ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(@Nullable ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.f15850e0;
        if (viewPager2 != null) {
            h hVar = this.f15853h0;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f15854i0;
            if (bVar != null) {
                this.f15850e0.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f15848c0;
        if (cVar != null) {
            b(cVar);
            this.f15848c0 = null;
        }
        if (viewPager != null) {
            this.f15850e0 = viewPager;
            if (this.f15853h0 == null) {
                this.f15853h0 = new h(this);
            }
            this.f15853h0.a();
            viewPager.addOnPageChangeListener(this.f15853h0);
            this.f15848c0 = new j(viewPager);
            a(this.f15848c0);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.f15854i0 == null) {
                this.f15854i0 = new b();
            }
            this.f15854i0.a(z2);
            viewPager.addOnAdapterChangeListener(this.f15854i0);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f15850e0 = null;
            a((PagerAdapter) null, false);
        }
        this.f15855j0 = z3;
    }

    void a(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f15851f0;
        if (pagerAdapter2 != null && (dataSetObserver = this.f15852g0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f15851f0 = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.f15852g0 == null) {
                this.f15852g0 = new e();
            }
            pagerAdapter.registerDataSetObserver(this.f15852g0);
        }
        d();
    }

    private void a(@NonNull g gVar, int i2) {
        gVar.b(i2);
        this.f15857s.add(i2, gVar);
        int size = this.f15857s.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.f15857s.get(i2).b(i2);
            }
        }
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.R == 1 && this.O == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int a(int i2, float f2) {
        int i3 = this.R;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f15859u.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.f15859u.getChildCount() ? this.f15859u.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
    }

    void a(boolean z2) {
        for (int i2 = 0; i2 < this.f15859u.getChildCount(); i2++) {
            View childAt = this.f15859u.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    @NonNull
    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }
}
