package com.amgcyo.cuttadon.view.xtablayout;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.view.xtablayout.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class XTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final Pools.Pool<g> f5585g0 = new Pools.SynchronizedPool(16);
    private int A;
    private int B;
    private ColorStateList C;
    private float D;
    private boolean E;
    private float F;
    private float G;
    private final int H;
    private final int I;
    private int J;
    private final int K;
    private final int L;
    private int M;
    private final int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private d V;
    private List<d> W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.xtablayout.d f5586a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private ViewPager f5587b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private PagerAdapter f5588c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private DataSetObserver f5589d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private h f5590e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Pools.Pool<i> f5591f0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f5592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f5593t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList<g> f5594u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private g f5595v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final f f5596w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5597x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5598y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5599z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (XTabLayout.this.R > 0) {
                LinearLayout linearLayout = (LinearLayout) XTabLayout.this.getChildAt(0);
                linearLayout.setShowDividers(2);
                com.amgcyo.cuttadon.view.xtablayout.b bVar = new com.amgcyo.cuttadon.view.xtablayout.b(XTabLayout.this.getContext());
                bVar.a(XTabLayout.this.R, XTabLayout.this.S);
                bVar.a(XTabLayout.this.T);
                bVar.b(XTabLayout.this.U);
                linearLayout.setDividerDrawable(bVar);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ i f5601s;

        b(i iVar) {
            this.f5601s = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = this.f5601s.getWidth();
            String strA = this.f5601s.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Paint paint = new Paint();
            paint.setTextSize(XTabLayout.this.F);
            Rect rect = new Rect();
            paint.getTextBounds(strA, 0, strA.length(), rect);
            if (width - rect.width() < XTabLayout.this.c(20)) {
                int iWidth = rect.width() + XTabLayout.this.c(20);
                ViewGroup.LayoutParams layoutParams = this.f5601s.getLayoutParams();
                layoutParams.width = iWidth;
                this.f5601s.setLayoutParams(layoutParams);
            }
        }
    }

    class c implements d.e {
        c() {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.e
        public void a(com.amgcyo.cuttadon.view.xtablayout.d dVar) {
            XTabLayout.this.scrollTo(dVar.c(), 0);
        }
    }

    public interface d {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar);
    }

    private class e extends DataSetObserver {
        private e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            XTabLayout.this.f();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            XTabLayout.this.f();
        }

        /* synthetic */ e(XTabLayout xTabLayout, a aVar) {
            this();
        }
    }

    private class f extends LinearLayout {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f5603s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5604t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final Paint f5605u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f5606v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private float f5607w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f5608x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f5609y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private com.amgcyo.cuttadon.view.xtablayout.d f5610z;

        class a implements d.e {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f5611c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f5612d;

            a(int i2, int i3, int i4, int i5) {
                this.a = i2;
                this.b = i3;
                this.f5611c = i4;
                this.f5612d = i5;
            }

            @Override // com.amgcyo.cuttadon.view.xtablayout.d.e
            public void a(com.amgcyo.cuttadon.view.xtablayout.d dVar) {
                float fB = dVar.b();
                f.this.b(com.amgcyo.cuttadon.view.xtablayout.a.a(this.a, this.b, fB), com.amgcyo.cuttadon.view.xtablayout.a.a(this.f5611c, this.f5612d, fB));
            }
        }

        class b extends d.C0121d {
            final /* synthetic */ int a;

            b(int i2) {
                this.a = i2;
            }

            @Override // com.amgcyo.cuttadon.view.xtablayout.d.c
            public void c(com.amgcyo.cuttadon.view.xtablayout.d dVar) {
                f.this.f5606v = this.a;
                f.this.f5607w = 0.0f;
            }
        }

        f(Context context) {
            super(context);
            this.f5606v = -1;
            this.f5608x = -1;
            this.f5609y = -1;
            setWillNotDraw(false);
            this.f5605u = new Paint();
        }

        void b(int i2) {
            if (this.f5603s != i2) {
                this.f5603s = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void c(int i2) {
            if (this.f5604t != i2) {
                this.f5604t = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i2 = this.f5608x;
            if (i2 < 0 || this.f5609y <= i2) {
                return;
            }
            if (this.f5604t == 0 || XTabLayout.this.f5593t) {
                int i3 = this.f5609y - this.f5608x;
                if (i3 > XTabLayout.this.f5595v.f()) {
                    this.f5608x += (i3 - XTabLayout.this.f5595v.f()) / 2;
                    this.f5609y -= (i3 - XTabLayout.this.f5595v.f()) / 2;
                }
            } else {
                int i4 = this.f5609y;
                int i5 = this.f5608x;
                int i6 = i4 - i5;
                int i7 = this.f5604t;
                if (i6 > i7) {
                    this.f5608x = i5 + ((i6 - i7) / 2);
                    this.f5609y = i4 - ((i6 - i7) / 2);
                }
            }
            canvas.drawRect(this.f5608x, getHeight() - this.f5603s, this.f5609y, getHeight(), this.f5605u);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            com.amgcyo.cuttadon.view.xtablayout.d dVar = this.f5610z;
            if (dVar == null || !dVar.e()) {
                c();
                return;
            }
            this.f5610z.a();
            a(this.f5606v, Math.round((1.0f - this.f5610z.b()) * this.f5610z.d()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            boolean z2 = true;
            if (XTabLayout.this.Q == 1 && XTabLayout.this.P == 1) {
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
                if (iMax * childCount <= getMeasuredWidth() - (XTabLayout.this.c(16) * 2)) {
                    boolean z3 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z3 = true;
                        }
                    }
                    z2 = z3;
                } else {
                    XTabLayout.this.P = 0;
                    XTabLayout.this.a(false);
                }
                if (z2) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        private void c() {
            int left;
            int right;
            int i2;
            View childAt = getChildAt(this.f5606v);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                int i3 = 0;
                if (this.f5604t == 0 && !XTabLayout.this.f5593t) {
                    this.f5604t = R.attr.maxWidth;
                }
                int i4 = this.f5604t;
                if (i4 != 0 && (i2 = this.f5609y - this.f5608x) > i4) {
                    i3 = (i2 - i4) / 2;
                    left += i3;
                    right -= i3;
                }
                if (this.f5607w > 0.0f && this.f5606v < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f5606v + 1);
                    int left2 = childAt2.getLeft() + i3;
                    int right2 = childAt2.getRight() - i3;
                    float f2 = this.f5607w;
                    left = (int) ((left2 * f2) + ((1.0f - f2) * left));
                    right = (int) ((right2 * f2) + ((1.0f - f2) * right));
                }
            }
            b(left, right);
        }

        void a(int i2) {
            if (this.f5605u.getColor() != i2) {
                this.f5605u.setColor(i2);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        float b() {
            return this.f5606v + this.f5607w;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, int i3) {
            int i4 = i2 + XTabLayout.this.f5597x;
            int i5 = i3 - XTabLayout.this.f5599z;
            if (i4 == this.f5608x && i5 == this.f5609y) {
                return;
            }
            this.f5608x = i4;
            this.f5609y = i5;
            ViewCompat.postInvalidateOnAnimation(this);
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
            com.amgcyo.cuttadon.view.xtablayout.d dVar = this.f5610z;
            if (dVar != null && dVar.e()) {
                this.f5610z.a();
            }
            this.f5606v = i2;
            this.f5607w = f2;
            c();
        }

        void a(int i2, int i3) {
            int i4;
            int i5;
            com.amgcyo.cuttadon.view.xtablayout.d dVar = this.f5610z;
            if (dVar != null && dVar.e()) {
                this.f5610z.a();
            }
            boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i2);
            if (childAt == null) {
                c();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i2 - this.f5606v) > 1) {
                int iC = XTabLayout.this.c(24);
                i4 = (i2 >= this.f5606v ? !z2 : z2) ? left - iC : iC + right;
                i5 = i4;
            } else {
                i4 = this.f5608x;
                i5 = this.f5609y;
            }
            if (i4 == left && i5 == right) {
                return;
            }
            com.amgcyo.cuttadon.view.xtablayout.d dVarA = com.amgcyo.cuttadon.view.xtablayout.g.a();
            this.f5610z = dVarA;
            dVarA.a(com.amgcyo.cuttadon.view.xtablayout.a.a);
            dVarA.a(i3);
            dVarA.a(0.0f, 1.0f);
            dVarA.a(new a(i4, left, i5, right));
            dVarA.a(new b(i2));
            dVarA.f();
        }
    }

    public static final class g {
        private Drawable a;
        private CharSequence b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f5614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f5616e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private XTabLayout f5617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private i f5618g;

        /* synthetic */ g(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f5617f = null;
            this.f5618g = null;
            this.a = null;
            this.b = null;
            this.f5614c = null;
            this.f5615d = -1;
            this.f5616e = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i() {
            i iVar = this.f5618g;
            if (iVar != null) {
                iVar.update();
            }
        }

        @Nullable
        public CharSequence e() {
            return this.b;
        }

        public int f() {
            return this.f5618g.b();
        }

        public void g() {
            XTabLayout xTabLayout = this.f5617f;
            if (xTabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            xTabLayout.b(this);
        }

        private g() {
            this.f5615d = -1;
        }

        @Nullable
        public View b() {
            return this.f5616e;
        }

        @Nullable
        public Drawable c() {
            return this.a;
        }

        public int d() {
            return this.f5615d;
        }

        void b(int i2) {
            this.f5615d = i2;
        }

        @NonNull
        public g a(@Nullable View view) {
            this.f5616e = view;
            i();
            return this;
        }

        @NonNull
        public g a(@LayoutRes int i2) {
            a(LayoutInflater.from(this.f5618g.getContext()).inflate(i2, (ViewGroup) this.f5618g, false));
            return this;
        }

        @NonNull
        public g a(@Nullable Drawable drawable) {
            this.a = drawable;
            i();
            return this;
        }

        @NonNull
        public g a(@Nullable CharSequence charSequence) {
            this.b = charSequence;
            i();
            return this;
        }

        @Nullable
        public CharSequence a() {
            return this.f5614c;
        }
    }

    public static class h implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final WeakReference<XTabLayout> f5619s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f5620t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f5621u;

        public h(XTabLayout xTabLayout) {
            this.f5619s = new WeakReference<>(xTabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f5620t = this.f5621u;
            this.f5621u = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            XTabLayout xTabLayout = this.f5619s.get();
            if (xTabLayout != null) {
                xTabLayout.a(i2, f2, this.f5621u != 2 || this.f5620t == 1, (this.f5621u == 2 && this.f5620t == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            XTabLayout xTabLayout = this.f5619s.get();
            if (xTabLayout == null || xTabLayout.getSelectedTabPosition() == i2) {
                return;
            }
            int i3 = this.f5621u;
            xTabLayout.b(xTabLayout.a(i2), i3 == 0 || (i3 == 2 && this.f5620t == 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f5621u = 0;
            this.f5620t = 0;
        }
    }

    class i extends LinearLayout implements View.OnLongClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private g f5622s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private TextView f5623t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private ImageView f5624u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private View f5625v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private TextView f5626w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private ImageView f5627x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f5628y;

        public i(Context context) {
            super(context);
            this.f5628y = 2;
            ViewCompat.setPaddingRelative(this, XTabLayout.this.f5597x, XTabLayout.this.f5598y, XTabLayout.this.f5599z, XTabLayout.this.A);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            a((g) null);
            setSelected(false);
        }

        public int b() {
            if (TextUtils.isEmpty(this.f5623t.getText().toString())) {
                return 0;
            }
            Rect rect = new Rect();
            String string = this.f5623t.getText().toString();
            this.f5623t.getPaint().getTextBounds(string, 0, string.length(), rect);
            return rect.width();
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            getLocationOnScreen(new int[2]);
            Context context = getContext();
            getWidth();
            getHeight();
            int i2 = context.getResources().getDisplayMetrics().widthPixels;
            return true;
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = XTabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(XTabLayout.this.J, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f5623t != null) {
                getResources();
                float f2 = XTabLayout.this.D;
                int i4 = this.f5628y;
                ImageView imageView = this.f5624u;
                boolean z2 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f5623t;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = XTabLayout.this.G;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f5623t.getTextSize();
                int lineCount = this.f5623t.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f5623t);
                if (f2 != textSize || (maxLines >= 0 && i4 != maxLines)) {
                    if (XTabLayout.this.Q == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f5623t.getLayout()) == null || a(layout, 0, f2) > layout.getWidth())) {
                        z2 = false;
                    }
                    if (z2) {
                        if (!this.f5623t.isSelected() || XTabLayout.this.F == 0.0f) {
                            this.f5623t.setTextSize(0, XTabLayout.this.D);
                        } else {
                            this.f5623t.setTextSize(0, XTabLayout.this.F);
                        }
                        this.f5623t.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            g gVar = this.f5622s;
            if (gVar == null) {
                return zPerformClick;
            }
            gVar.g();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (!z2) {
                if (XTabLayout.this.H != 0) {
                    setBackgroundColor(XTabLayout.this.H);
                }
                this.f5623t.setTextSize(0, XTabLayout.this.D);
            }
            if (z3 && z2) {
                if (XTabLayout.this.I != 0) {
                    setBackgroundColor(XTabLayout.this.I);
                }
                sendAccessibilityEvent(4);
                TextView textView = this.f5623t;
                if (textView != null) {
                    textView.setSelected(z2);
                    if (XTabLayout.this.F != 0.0f) {
                        this.f5623t.setTextSize(0, XTabLayout.this.F);
                    }
                }
                ImageView imageView = this.f5624u;
                if (imageView != null) {
                    imageView.setSelected(z2);
                }
            }
        }

        final void update() {
            g gVar = this.f5622s;
            View viewB = gVar != null ? gVar.b() : null;
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f5625v = viewB;
                TextView textView = this.f5623t;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f5624u;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f5624u.setImageDrawable(null);
                }
                this.f5626w = (TextView) viewB.findViewById(R.id.text1);
                TextView textView2 = this.f5626w;
                if (textView2 != null) {
                    this.f5628y = TextViewCompat.getMaxLines(textView2);
                }
                this.f5627x = (ImageView) viewB.findViewById(R.id.icon);
            } else {
                View view = this.f5625v;
                if (view != null) {
                    removeView(view);
                    this.f5625v = null;
                }
                this.f5626w = null;
                this.f5627x = null;
            }
            if (this.f5625v != null) {
                if (this.f5626w == null && this.f5627x == null) {
                    return;
                }
                a(this.f5626w, this.f5627x);
                return;
            }
            if (this.f5624u == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(com.fatcatfat.io.R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                addView(imageView2, 0);
                this.f5624u = imageView2;
            }
            if (this.f5623t == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(com.fatcatfat.io.R.layout.design_layout_tab_text, (ViewGroup) this, false);
                addView(textView3);
                this.f5623t = textView3;
                this.f5628y = TextViewCompat.getMaxLines(this.f5623t);
            }
            if (XTabLayout.this.E) {
                this.f5623t.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.f5623t.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.f5623t.setTextAppearance(getContext(), XTabLayout.this.B);
            if (XTabLayout.this.C != null) {
                this.f5623t.setTextColor(XTabLayout.this.C);
            }
            a(this.f5623t, this.f5624u);
        }

        public String a() {
            return this.f5623t.getText().toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(@Nullable g gVar) {
            if (gVar != this.f5622s) {
                this.f5622s = gVar;
                update();
            }
        }

        private void a(@Nullable TextView textView, @Nullable ImageView imageView) {
            g gVar = this.f5622s;
            Drawable drawableC = gVar != null ? gVar.c() : null;
            g gVar2 = this.f5622s;
            CharSequence charSequenceE = gVar2 != null ? gVar2.e() : null;
            g gVar3 = this.f5622s;
            CharSequence charSequenceA = gVar3 != null ? gVar3.a() : null;
            if (imageView != null) {
                if (drawableC != null) {
                    imageView.setImageDrawable(drawableC);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequenceA);
            }
            boolean z2 = !TextUtils.isEmpty(charSequenceE);
            if (textView != null) {
                if (z2) {
                    textView.setAllCaps(XTabLayout.this.f5592s);
                    textView.setText(charSequenceE);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequenceA);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iC = (z2 && imageView.getVisibility() == 0) ? XTabLayout.this.c(8) : 0;
                if (iC != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iC;
                    imageView.requestLayout();
                }
            }
            if (!z2 && !TextUtils.isEmpty(charSequenceA)) {
                setOnLongClickListener(this);
            } else {
                setOnLongClickListener(null);
                setLongClickable(false);
            }
        }

        private float a(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }
    }

    public static class j implements d {
        private final ViewPager a;

        public j(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void a(g gVar) {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void b(g gVar) {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.XTabLayout.d
        public void c(g gVar) {
            XTabLayout.a(this.a, gVar.d());
        }
    }

    public XTabLayout(Context context) {
        this(context, null);
    }

    private int getDefaultHeight() {
        int size = this.f5594u.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f5594u.get(i2);
                if (gVar != null && gVar.c() != null && !TextUtils.isEmpty(gVar.e())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return z2 ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f5596w.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabMaxWidth() {
        return this.J;
    }

    private int getTabMinWidth() {
        if (this.f5588c0 != null && this.M != 0) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            return (this.f5588c0.getCount() == 1 || this.M == 1) ? windowManager.getDefaultDisplay().getWidth() : this.f5588c0.getCount() < this.M ? windowManager.getDefaultDisplay().getWidth() / this.f5588c0.getCount() : windowManager.getDefaultDisplay().getWidth() / this.M;
        }
        if (this.M != 0) {
            return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() / this.M;
        }
        int i2 = this.K;
        if (i2 != -1) {
            return i2;
        }
        if (this.Q == 0) {
            return this.N;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f5596w.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f5596w.getChildCount();
        if (i2 >= childCount || this.f5596w.getChildAt(i2).isSelected()) {
            return;
        }
        int i3 = 0;
        while (i3 < childCount) {
            this.f5596w.getChildAt(i3).setSelected(i3 == i2);
            i3++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f5595v;
        if (gVar != null) {
            return gVar.d();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f5594u.size();
    }

    public int getTabGravity() {
        return this.P;
    }

    public int getTabMode() {
        return this.Q;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.C;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iC = c(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(iC, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(iC, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            PagerAdapter pagerAdapter = this.f5588c0;
            if (pagerAdapter == null || this.M == 0) {
                int iC2 = this.L;
                if (iC2 <= 0) {
                    iC2 = size - c(56);
                }
                this.J = iC2;
            } else if (pagerAdapter.getCount() == 1 || this.M == 1) {
                this.J = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
            } else {
                int iC3 = this.L;
                if (iC3 <= 0) {
                    iC3 = size - c(56);
                }
                this.J = iC3;
            }
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i4 = this.Q;
            if (i4 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i4 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setAllCaps(boolean z2) {
        this.f5592s = z2;
    }

    public void setDividerColor(int i2) {
        this.T = i2;
        c();
    }

    public void setDividerGravity(int i2) {
        this.U = i2;
        c();
    }

    public void setOnTabSelectedListener(d dVar) {
        this.V = dVar;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.f5596w.a(i2);
    }

    public void setSelectedTabIndicatorHeight(int i2) {
        this.f5596w.b(i2);
    }

    public void setSelectedTabIndicatorWidth(int i2) {
        this.f5596w.c(i2);
    }

    public void setTabGravity(int i2) {
        if (this.P != i2) {
            this.P = i2;
            d();
        }
    }

    public void setTabMode(int i2) {
        if (i2 != this.Q) {
            this.Q = i2;
            d();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            g();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        a(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        h hVar;
        ViewPager viewPager2 = this.f5587b0;
        if (viewPager2 != null && (hVar = this.f5590e0) != null) {
            viewPager2.removeOnPageChangeListener(hVar);
        }
        if (viewPager == null) {
            this.f5587b0 = null;
            setOnTabSelectedListener(null);
            a((PagerAdapter) null, true);
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        this.f5587b0 = viewPager;
        if (this.f5590e0 == null) {
            this.f5590e0 = new h(this);
        }
        this.f5590e0.a();
        viewPager.addOnPageChangeListener(this.f5590e0);
        setOnTabSelectedListener(new j(viewPager));
        a(adapter, true);
    }

    public void setxTabDisplayNum(int i2) {
        this.M = i2;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public XTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        post(new a());
    }

    private void d(int i2) {
        i iVar = (i) this.f5596w.getChildAt(i2);
        this.f5596w.removeViewAt(i2);
        if (iVar != null) {
            iVar.c();
            this.f5591f0.release(iVar);
        }
        requestLayout();
    }

    private LinearLayout.LayoutParams e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int currentItem;
        b();
        PagerAdapter pagerAdapter = this.f5588c0;
        if (pagerAdapter == null) {
            b();
            return;
        }
        int count = pagerAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            g gVarA = a();
            gVarA.a(this.f5588c0.getPageTitle(i2));
            a(gVarA, false);
        }
        ViewPager viewPager = this.f5587b0;
        if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
            return;
        }
        b(a(currentItem));
    }

    private void g() {
        int size = this.f5594u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5594u.get(i2).i();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public XTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5592s = false;
        this.f5593t = false;
        this.f5594u = new ArrayList<>();
        this.D = 0.0f;
        this.F = 0.0f;
        this.J = Integer.MAX_VALUE;
        this.W = new ArrayList();
        this.f5591f0 = new Pools.SimplePool(12);
        com.amgcyo.cuttadon.view.xtablayout.c.a(context);
        setHorizontalScrollBarEnabled(false);
        this.f5596w = new f(context);
        super.addView(this.f5596w, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XTabLayout, i2, 2131821195);
        this.f5596w.b(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, c(2)));
        this.f5596w.c(typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0));
        this.f5596w.a(typedArrayObtainStyledAttributes.getColor(9, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.A = dimensionPixelSize;
        this.f5599z = dimensionPixelSize;
        this.f5598y = dimensionPixelSize;
        this.f5597x = dimensionPixelSize;
        this.f5597x = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, this.f5597x);
        this.f5598y = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, this.f5598y);
        this.f5599z = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, this.f5599z);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, this.A);
        this.f5592s = typedArrayObtainStyledAttributes.getBoolean(23, false);
        this.B = typedArrayObtainStyledAttributes.getResourceId(24, 2131820960);
        this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(28, 0);
        this.E = typedArrayObtainStyledAttributes.getBoolean(25, false);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(22, 0);
        typedArrayObtainStyledAttributes.getBoolean(27, false);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(this.B, R$styleable.TextAppearance);
        try {
            if (this.D == 0.0f) {
                this.D = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, 0);
            }
            this.C = typedArrayObtainStyledAttributes2.getColorStateList(3);
            typedArrayObtainStyledAttributes2.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(26)) {
                this.C = typedArrayObtainStyledAttributes.getColorStateList(26);
            }
            if (typedArrayObtainStyledAttributes.hasValue(21)) {
                this.C = b(this.C.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(21, 0));
            }
            this.M = typedArrayObtainStyledAttributes.getInt(2, 0);
            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, -1);
            this.H = typedArrayObtainStyledAttributes.getColor(0, 0);
            this.I = typedArrayObtainStyledAttributes.getColor(20, 0);
            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.Q = typedArrayObtainStyledAttributes.getInt(14, 1);
            this.P = typedArrayObtainStyledAttributes.getInt(8, 0);
            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.T = typedArrayObtainStyledAttributes.getColor(3, -16777216);
            this.U = typedArrayObtainStyledAttributes.getInteger(4, 1);
            this.f5593t = typedArrayObtainStyledAttributes.getBoolean(7, false);
            typedArrayObtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.G = resources.getDimensionPixelSize(com.fatcatfat.io.R.dimen.design_tab_text_size_2line);
            this.N = resources.getDimensionPixelSize(com.fatcatfat.io.R.dimen.design_tab_scrollable_min_width);
            d();
            c();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private i c(@NonNull g gVar) {
        Pools.Pool<i> pool = this.f5591f0;
        i iVarAcquire = pool != null ? pool.acquire() : null;
        if (iVarAcquire == null) {
            iVarAcquire = new i(getContext());
        }
        iVarAcquire.a(gVar);
        iVarAcquire.setFocusable(true);
        iVarAcquire.setMinimumWidth(getTabMinWidth());
        return iVarAcquire;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void b() {
        for (int childCount = this.f5596w.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<g> it = this.f5594u.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.h();
            f5585g0.release(next);
        }
        this.f5595v = null;
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2, boolean z2, boolean z3) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.f5596w.getChildCount()) {
            return;
        }
        if (z3) {
            this.f5596w.a(i2, f2);
        }
        com.amgcyo.cuttadon.view.xtablayout.d dVar = this.f5586a0;
        if (dVar != null && dVar.e()) {
            this.f5586a0.a();
        }
        scrollTo(a(i2, f2), 0);
        if (z2) {
            setSelectedTabView(iRound);
        }
    }

    private void d() {
        ViewCompat.setPaddingRelative(this.f5596w, this.Q == 0 ? Math.max(0, this.O - this.f5597x) : 0, 0, 0, 0);
        int i2 = this.Q;
        if (i2 == 0) {
            this.f5596w.setGravity(GravityCompat.START);
        } else if (i2 == 1) {
            this.f5596w.setGravity(1);
        }
        a(true);
    }

    private void c(g gVar, boolean z2) {
        i iVar = gVar.f5618g;
        if (this.F != 0.0f) {
            iVar.post(new b(iVar));
        }
        this.f5596w.addView(iVar, e());
        if (z2) {
            iVar.setSelected(true);
        }
    }

    private void b(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f5596w.a()) {
            int scrollX = getScrollX();
            int iA = a(i2, 0.0f);
            if (scrollX != iA) {
                if (this.f5586a0 == null) {
                    this.f5586a0 = com.amgcyo.cuttadon.view.xtablayout.g.a();
                    this.f5586a0.a(com.amgcyo.cuttadon.view.xtablayout.a.a);
                    this.f5586a0.a(200);
                    this.f5586a0.a(new c());
                }
                this.f5586a0.a(scrollX, iA);
                this.f5586a0.f();
            }
            this.f5596w.a(i2, 200);
            return;
        }
        a(i2, 0.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * i2);
    }

    public void a(@NonNull g gVar) {
        a(gVar, this.f5594u.isEmpty());
    }

    public void a(@NonNull g gVar, boolean z2) {
        if (gVar.f5617f == this) {
            c(gVar, z2);
            a(gVar, this.f5594u.size());
            if (z2) {
                gVar.g();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(@NonNull TabItem tabItem) {
        g gVarA = a();
        CharSequence charSequence = tabItem.f5582s;
        if (charSequence != null) {
            gVarA.a(charSequence);
        }
        Drawable drawable = tabItem.f5583t;
        if (drawable != null) {
            gVarA.a(drawable);
        }
        int i2 = tabItem.f5584u;
        if (i2 != 0) {
            gVarA.a(i2);
        }
        a(gVarA);
    }

    void b(g gVar) {
        b(gVar, true);
    }

    void b(g gVar, boolean z2) {
        d dVar;
        d dVar2;
        g gVar2 = this.f5595v;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                d dVar3 = this.V;
                if (dVar3 != null) {
                    dVar3.a(gVar2);
                }
                Iterator<d> it = this.W.iterator();
                while (it.hasNext()) {
                    it.next().a(this.f5595v);
                }
                b(gVar.d());
                return;
            }
            return;
        }
        if (z2) {
            int iD = gVar != null ? gVar.d() : -1;
            if (iD != -1) {
                setSelectedTabView(iD);
            }
            g gVar3 = this.f5595v;
            if ((gVar3 == null || gVar3.d() == -1) && iD != -1) {
                a(iD, 0.0f, true);
            } else {
                b(iD);
            }
        }
        g gVar4 = this.f5595v;
        if (gVar4 != null && (dVar2 = this.V) != null) {
            dVar2.b(gVar4);
        }
        Iterator<d> it2 = this.W.iterator();
        while (it2.hasNext()) {
            it2.next().b(this.f5595v);
        }
        this.f5595v = gVar;
        g gVar5 = this.f5595v;
        if (gVar5 != null && (dVar = this.V) != null) {
            dVar.c(gVar5);
        }
        Iterator<d> it3 = this.W.iterator();
        while (it3.hasNext()) {
            it3.next().c(this.f5595v);
        }
    }

    public void a(d dVar) {
        this.W.add(dVar);
    }

    @NonNull
    public g a() {
        g gVarAcquire = f5585g0.acquire();
        if (gVarAcquire == null) {
            gVarAcquire = new g(null);
        }
        gVarAcquire.f5617f = this;
        gVarAcquire.f5618g = c(gVarAcquire);
        return gVarAcquire;
    }

    @Nullable
    public g a(int i2) {
        return this.f5594u.get(i2);
    }

    public void a(int i2, int i3) {
        setTabTextColors(b(i2, i3));
    }

    private void a(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f5588c0;
        if (pagerAdapter2 != null && (dataSetObserver = this.f5589d0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f5588c0 = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.f5589d0 == null) {
                this.f5589d0 = new e(this, null);
            }
            pagerAdapter.registerDataSetObserver(this.f5589d0);
        }
        f();
    }

    private void a(g gVar, int i2) {
        gVar.b(i2);
        this.f5594u.add(i2, gVar);
        int size = this.f5594u.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.f5594u.get(i2).b(i2);
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

    private static ColorStateList b(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.Q == 1 && this.P == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int a(int i2, float f2) {
        if (this.Q != 0) {
            return 0;
        }
        View childAt = this.f5596w.getChildAt(i2);
        int i3 = i2 + 1;
        return ((childAt.getLeft() + ((int) ((((childAt != null ? childAt.getWidth() : 0) + ((i3 < this.f5596w.getChildCount() ? this.f5596w.getChildAt(i3) : null) != null ? r4.getWidth() : 0)) * f2) * 0.5f))) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        for (int i2 = 0; i2 < this.f5596w.getChildCount(); i2++) {
            View childAt = this.f5596w.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ViewPager viewPager, int i2) {
        try {
            ViewPager.class.getDeclaredField("mFirstLayout").setAccessible(true);
            viewPager.setCurrentItem(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            viewPager.setCurrentItem(i2);
        }
    }
}
