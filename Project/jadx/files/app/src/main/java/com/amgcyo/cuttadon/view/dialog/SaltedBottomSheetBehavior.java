package com.amgcyo.cuttadon.view.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SaltedBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private float a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f4639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f4640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f4641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f4643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ViewDragHelper f4644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4647m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f4648n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    WeakReference<V> f4649o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    WeakReference<View> f4650p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f4651q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private VelocityTracker f4652r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f4653s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4654t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f4655u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CoordinatorLayout f4656v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ViewDragHelper.Callback f4657w;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f4659s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f4660t;

        a(View view, int i2) {
            this.f4659s = view;
            this.f4660t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SaltedBottomSheetBehavior.this.a(this.f4659s, this.f4660t);
        }
    }

    class b extends ViewDragHelper.Callback {
        b() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i2, int i3) {
            SaltedBottomSheetBehavior saltedBottomSheetBehavior = SaltedBottomSheetBehavior.this;
            return MathUtils.clamp(i2, saltedBottomSheetBehavior.f4639e, saltedBottomSheetBehavior.f4641g ? saltedBottomSheetBehavior.f4648n : saltedBottomSheetBehavior.f4640f);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            int i2;
            int i3;
            SaltedBottomSheetBehavior saltedBottomSheetBehavior = SaltedBottomSheetBehavior.this;
            if (saltedBottomSheetBehavior.f4641g) {
                i2 = saltedBottomSheetBehavior.f4648n;
                i3 = saltedBottomSheetBehavior.f4639e;
            } else {
                i2 = saltedBottomSheetBehavior.f4640f;
                i3 = saltedBottomSheetBehavior.f4639e;
            }
            return i2 - i3;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1) {
                SaltedBottomSheetBehavior.this.d(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            SaltedBottomSheetBehavior.this.a(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f2, float f3) {
            int i2;
            int i3;
            int i4 = 3;
            if (f3 < 0.0f) {
                i3 = SaltedBottomSheetBehavior.this.f4639e;
            } else {
                SaltedBottomSheetBehavior saltedBottomSheetBehavior = SaltedBottomSheetBehavior.this;
                if (saltedBottomSheetBehavior.f4641g && saltedBottomSheetBehavior.a(view, f3)) {
                    i3 = SaltedBottomSheetBehavior.this.f4648n;
                    i4 = 5;
                } else {
                    if (f3 == 0.0f) {
                        int top = view.getTop();
                        if (Math.abs(top - SaltedBottomSheetBehavior.this.f4639e) < Math.abs(top - SaltedBottomSheetBehavior.this.f4640f)) {
                            i3 = SaltedBottomSheetBehavior.this.f4639e;
                        } else {
                            i2 = SaltedBottomSheetBehavior.this.f4640f;
                        }
                    } else {
                        i2 = SaltedBottomSheetBehavior.this.f4640f;
                    }
                    i3 = i2;
                    i4 = 4;
                }
            }
            if (!SaltedBottomSheetBehavior.this.f4644j.settleCapturedViewAt(view.getLeft(), i3)) {
                SaltedBottomSheetBehavior.this.d(i4);
            } else {
                SaltedBottomSheetBehavior.this.d(2);
                ViewCompat.postOnAnimation(view, new d(view, i4));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            WeakReference<V> weakReference;
            View view2;
            SaltedBottomSheetBehavior saltedBottomSheetBehavior = SaltedBottomSheetBehavior.this;
            int i3 = saltedBottomSheetBehavior.f4643i;
            if (i3 == 1 || saltedBottomSheetBehavior.f4655u) {
                return false;
            }
            return ((i3 == 3 && saltedBottomSheetBehavior.f4653s == i2 && (view2 = saltedBottomSheetBehavior.f4650p.get()) != null && view2.canScrollVertically(-1)) || (weakReference = SaltedBottomSheetBehavior.this.f4649o) == null || weakReference.get() != view) ? false : true;
        }
    }

    public static abstract class c {
        public abstract void a(@NonNull View view, float f2);

        public abstract void a(@NonNull View view, int i2);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final View f4662s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final int f4663t;

        d(View view, int i2) {
            this.f4662s = view;
            this.f4663t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = SaltedBottomSheetBehavior.this.f4644j;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                SaltedBottomSheetBehavior.this.d(this.f4663t);
            } else {
                ViewCompat.postOnAnimation(this.f4662s, this);
            }
        }
    }

    public SaltedBottomSheetBehavior() {
        this.f4643i = 4;
        this.f4657w = new b();
    }

    public void a(boolean z2) {
        this.f4641g = z2;
    }

    void b(View view) {
        this.f4650p = new WeakReference<>(a(view));
    }

    public final void c(int i2) {
        if (i2 == this.f4643i) {
            return;
        }
        WeakReference<V> weakReference = this.f4649o;
        if (weakReference == null) {
            if (i2 == 4 || i2 == 3 || (this.f4641g && i2 == 5)) {
                this.f4643i = i2;
                return;
            }
            return;
        }
        V v2 = weakReference.get();
        if (v2 == null) {
            return;
        }
        ViewParent parent = v2.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v2)) {
            v2.post(new a(v2, i2));
        } else {
            a((View) v2, i2);
        }
    }

    void d(int i2) {
        c cVar;
        if (this.f4643i == i2) {
            return;
        }
        this.f4643i = i2;
        V v2 = this.f4649o.get();
        if (v2 == null || (cVar = this.f4651q) == null) {
            return;
        }
        cVar.a((View) v2, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            this.f4645k = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            b();
        }
        if (this.f4652r == null) {
            this.f4652r = VelocityTracker.obtain();
        }
        this.f4652r.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.f4654t = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f4650p;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.isPointInChildBounds(view, x2, this.f4654t)) {
                this.f4653s = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f4655u = true;
            }
            this.f4645k = this.f4653s == -1 && !coordinatorLayout.isPointInChildBounds(v2, x2, this.f4654t);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4655u = false;
            this.f4653s = -1;
            if (this.f4645k) {
                this.f4645k = false;
                return false;
            }
        }
        if (!this.f4645k && this.f4644j.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        View view2 = this.f4650p.get();
        return (actionMasked != 2 || view2 == null || this.f4645k || this.f4643i == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.f4654t) - motionEvent.getY()) <= ((float) this.f4644j.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        int iMax;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v2)) {
            ViewCompat.setFitsSystemWindows(v2, true);
        }
        if (this.f4656v == null) {
            this.f4656v = coordinatorLayout;
        }
        int top = v2.getTop();
        coordinatorLayout.onLayoutChild(v2, i2);
        this.f4648n = coordinatorLayout.getHeight();
        if (this.f4637c) {
            if (this.f4638d == 0) {
                this.f4638d = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            iMax = Math.max(this.f4638d, this.f4648n - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            iMax = this.b;
        }
        this.f4639e = Math.max(0, this.f4648n - v2.getHeight());
        this.f4640f = Math.max(this.f4648n - iMax, this.f4639e);
        int i3 = this.f4643i;
        if (i3 == 3) {
            ViewCompat.offsetTopAndBottom(v2, this.f4639e);
        } else if (this.f4641g && i3 == 5) {
            ViewCompat.offsetTopAndBottom(v2, this.f4648n);
        } else {
            int i4 = this.f4643i;
            if (i4 == 4) {
                ViewCompat.offsetTopAndBottom(v2, this.f4640f);
            } else if (i4 == 1 || i4 == 2) {
                ViewCompat.offsetTopAndBottom(v2, top - v2.getTop());
            }
        }
        if (this.f4644j == null) {
            this.f4644j = ViewDragHelper.create(coordinatorLayout, this.f4657w);
        }
        this.f4649o = new WeakReference<>(v2);
        this.f4650p = new WeakReference<>(a(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        return view == this.f4650p.get() && (this.f4643i != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr) {
        if (view != this.f4650p.get()) {
            return;
        }
        int top = v2.getTop();
        int i4 = top - i3;
        if (i3 > 0) {
            int i5 = this.f4639e;
            if (i4 < i5) {
                iArr[1] = top - i5;
                ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                d(3);
            } else {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v2, -i3);
                d(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.f4640f;
            if (i4 <= i6 || this.f4641g) {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v2, -i3);
                d(1);
            } else {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                d(4);
            }
        }
        a(v2.getTop());
        this.f4646l = i3;
        this.f4647m = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.getSuperState());
        int i2 = savedState.f4658s;
        if (i2 == 1 || i2 == 2) {
            this.f4643i = 4;
        } else {
            this.f4643i = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), this.f4643i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
        this.f4646l = 0;
        this.f4647m = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view) {
        int i2;
        int i3 = 3;
        if (v2.getTop() == this.f4639e) {
            d(3);
            return;
        }
        WeakReference<View> weakReference = this.f4650p;
        if (weakReference != null && view == weakReference.get() && this.f4647m) {
            if (this.f4646l > 0) {
                i2 = this.f4639e;
            } else if (this.f4641g && a(v2, a())) {
                i2 = this.f4648n;
                i3 = 5;
            } else {
                if (this.f4646l == 0) {
                    int top = v2.getTop();
                    if (Math.abs(top - this.f4639e) < Math.abs(top - this.f4640f)) {
                        i2 = this.f4639e;
                    } else {
                        i2 = this.f4640f;
                    }
                } else {
                    i2 = this.f4640f;
                }
                i3 = 4;
            }
            if (this.f4644j.smoothSlideViewTo(v2, v2.getLeft(), i2)) {
                d(2);
                ViewCompat.postOnAnimation(v2, new d(v2, i3));
            } else {
                d(i3);
            }
            this.f4647m = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4643i == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f4644j;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            b();
        }
        if (this.f4652r == null) {
            this.f4652r = VelocityTracker.obtain();
        }
        this.f4652r.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f4645k && Math.abs(this.f4654t - motionEvent.getY()) > this.f4644j.getTouchSlop()) {
            this.f4644j.captureChildView(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f4645k;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final int f4658s;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4658s = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4658s);
        }

        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f4658s = i2;
        }
    }

    public void a(c cVar) {
        this.f4651q = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f4637c
            if (r4 != 0) goto L15
            r3.f4637c = r0
            goto L24
        Lc:
            boolean r2 = r3.f4637c
            if (r2 != 0) goto L17
            int r2 = r3.b
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L24
        L17:
            r3.f4637c = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.b = r1
            int r1 = r3.f4648n
            int r1 = r1 - r4
            r3.f4640f = r1
        L24:
            if (r0 == 0) goto L3a
            int r4 = r3.f4643i
            r0 = 4
            if (r4 != r0) goto L3a
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f4649o
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L3a
            r4.requestLayout()
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.dialog.SaltedBottomSheetBehavior.b(int):void");
    }

    boolean a(View view, float f2) {
        if (this.f4642h) {
            return true;
        }
        return view.getTop() >= this.f4640f && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f4640f)) / ((float) this.b) > 0.5f;
    }

    public SaltedBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.f4643i = 4;
        this.f4657w = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(8);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            b(i2);
        } else {
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(8, -1));
        }
        a(typedArrayObtainStyledAttributes.getBoolean(7, false));
        b(typedArrayObtainStyledAttributes.getBoolean(10, false));
        typedArrayObtainStyledAttributes.recycle();
        this.a = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @VisibleForTesting
    View a(View view) {
        if (view == null) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) view;
            View viewA = a(viewPager.getChildAt(viewPager.getCurrentItem()));
            if (viewA != null && ViewCompat.isNestedScrollingEnabled(viewA)) {
                return viewA;
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View viewA2 = a(viewGroup.getChildAt(i2));
                if (viewA2 != null) {
                    return viewA2;
                }
            }
        }
        return null;
    }

    public static <V extends View> SaltedBottomSheetBehavior<V> c(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SaltedBottomSheetBehavior) {
                return (SaltedBottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void b(boolean z2) {
        this.f4642h = z2;
    }

    private void b() {
        this.f4653s = -1;
        VelocityTracker velocityTracker = this.f4652r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4652r = null;
        }
    }

    private float a() {
        this.f4652r.computeCurrentVelocity(1000, this.a);
        return this.f4652r.getYVelocity(this.f4653s);
    }

    void a(View view, int i2) {
        int i3;
        if (i2 == 4) {
            i3 = this.f4640f;
        } else if (i2 == 3) {
            i3 = this.f4639e;
        } else if (this.f4641g && i2 == 5) {
            i3 = this.f4648n;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        if (this.f4644j.smoothSlideViewTo(view, view.getLeft(), i3)) {
            d(2);
            ViewCompat.postOnAnimation(view, new d(view, i2));
        } else {
            d(i2);
        }
    }

    void a(int i2) {
        c cVar;
        V v2 = this.f4649o.get();
        if (v2 == null || (cVar = this.f4651q) == null) {
            return;
        }
        if (i2 > this.f4640f) {
            cVar.a(v2, (r2 - i2) / (this.f4648n - r2));
        } else {
            cVar.a(v2, (r2 - i2) / (r2 - this.f4639e));
        }
    }
}
