package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPager2 extends ViewGroup {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13229c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13230d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13231e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13232f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static boolean f13233g = true;
    private int A;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f13234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f13235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    RecyclerView f13236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ScrollEventAdapter f13237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    AccessibilityProvider f13238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Rect f13239m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f13240n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CompositeOnPageChangeCallback f13241o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f13242p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LinearLayoutManager f13243q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13244r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Parcelable f13245s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private PagerSnapHelper f13246t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CompositeOnPageChangeCallback f13247u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FakeDrag f13248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private PageTransformerAdapter f13249w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private RecyclerView.ItemAnimator f13250x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f13251y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13252z;

    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        boolean a() {
            return false;
        }

        boolean a(int i2, Bundle bundle) {
            return false;
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        boolean handlesLmPerformAccessibilityAction(int i2) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean onLmPerformAccessibilityAction(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean b(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i2) {
            if (handlesLmPerformAccessibilityAction(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            onChanged();
        }
    }

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(state) : ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f13238l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i2, @Nullable Bundle bundle) {
            return ViewPager2.this.f13238l.handlesLmPerformAccessibilityAction(i2) ? ViewPager2.this.f13238l.onLmPerformAccessibilityAction(i2) : super.performAccessibilityAction(recycler, state, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
            return false;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, @Px int i3) {
        }

        public void onPageSelected(int i2) {
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f2);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f13238l.handlesRvGetAccessibilityClassName() ? ViewPager2.this.f13238l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f13234h);
            accessibilityEvent.setToIndex(ViewPager2.this.f13234h);
            ViewPager2.this.f13238l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {
        private final int a;
        private final RecyclerView b;

        SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.a = i2;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f13239m = new Rect();
        this.f13240n = new Rect();
        this.f13241o = new CompositeOnPageChangeCallback(3);
        this.f13235i = false;
        this.f13242p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f13235i = true;
                viewPager2.f13237k.a();
            }
        };
        this.f13244r = -1;
        this.f13250x = null;
        this.f13251y = false;
        this.f13252z = true;
        this.A = -1;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f13238l = new BasicAccessibilityProvider();
        this.f13236j = new RecyclerViewImpl(context);
        this.f13236j.setId(ViewCompat.generateViewId());
        this.f13236j.setDescendantFocusability(131072);
        this.f13243q = new LinearLayoutManagerImpl(context);
        this.f13236j.setLayoutManager(this.f13243q);
        this.f13236j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f13236j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f13236j.addOnChildAttachStateChangeListener(e());
        this.f13237k = new ScrollEventAdapter(this);
        this.f13248v = new FakeDrag(this, this.f13237k, this.f13236j);
        this.f13246t = new PagerSnapHelperImpl();
        this.f13246t.attachToRecyclerView(this.f13236j);
        this.f13236j.addOnScrollListener(this.f13237k);
        this.f13247u = new CompositeOnPageChangeCallback(3);
        this.f13237k.a(this.f13247u);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f13234h != i2) {
                    viewPager2.f13234h = i2;
                    viewPager2.f13238l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f13236j.requestFocus(2);
                }
            }
        };
        this.f13247u.a(onPageChangeCallback);
        this.f13247u.a(onPageChangeCallback2);
        this.f13238l.a(this.f13247u, this.f13236j);
        this.f13247u.a(this.f13241o);
        this.f13249w = new PageTransformerAdapter(this.f13243q);
        this.f13247u.a(this.f13249w);
        RecyclerView recyclerView = this.f13236j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f13242p);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        RecyclerView.Adapter adapter;
        if (this.f13244r == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f13245s;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f13245s = null;
        }
        this.f13234h = Math.max(0, Math.min(this.f13244r, adapter.getItemCount() - 1));
        this.f13244r = -1;
        this.f13236j.scrollToPosition(this.f13234h);
        this.f13238l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f13236j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.f13248v.b();
    }

    boolean c() {
        return this.f13243q.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.f13236j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.f13236j.canScrollVertically(i2);
    }

    void d() {
        View viewFindSnapView = this.f13246t.findSnapView(this.f13243q);
        if (viewFindSnapView == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = this.f13246t.calculateDistanceToFinalSnap(this.f13243q, viewFindSnapView);
        if (iArrCalculateDistanceToFinalSnap[0] == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f13236j.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).a;
            sparseArray.put(this.f13236j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.f13248v.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.f13248v.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.f13238l.a() ? this.f13238l.b() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f13236j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f13234h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i2) {
        return this.f13236j.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.f13236j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getOrientation() {
        return this.f13243q.getOrientation();
    }

    public int getScrollState() {
        return this.f13237k.d();
    }

    public void invalidateItemDecorations() {
        this.f13236j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f13248v.a();
    }

    public boolean isUserInputEnabled() {
        return this.f13252z;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f13238l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f13236j.getMeasuredWidth();
        int measuredHeight = this.f13236j.getMeasuredHeight();
        this.f13239m.left = getPaddingLeft();
        this.f13239m.right = (i4 - i2) - getPaddingRight();
        this.f13239m.top = getPaddingTop();
        this.f13239m.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f13239m, this.f13240n);
        RecyclerView recyclerView = this.f13236j;
        Rect rect = this.f13240n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f13235i) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.f13236j, i2, i3);
        int measuredWidth = this.f13236j.getMeasuredWidth();
        int measuredHeight = this.f13236j.getMeasuredHeight();
        int measuredState = this.f13236j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f13244r = savedState.b;
        this.f13245s = savedState.f13257c;
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f13236j.getId();
        int i2 = this.f13244r;
        if (i2 == -1) {
            i2 = this.f13234h;
        }
        savedState.b = i2;
        Parcelable parcelable = this.f13245s;
        if (parcelable != null) {
            savedState.f13257c = parcelable;
        } else {
            Object adapter = this.f13236j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f13257c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.f13238l.a(i2, bundle) ? this.f13238l.b(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f13241o.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f13236j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i2) {
        this.f13236j.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.f13249w.a() == null) {
            return;
        }
        double dH = this.f13237k.h();
        int i2 = (int) dH;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (dH - d2);
        this.f13249w.onPageScrolled(i2, f2, Math.round(b() * f2));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f13236j.getAdapter();
        this.f13238l.b(adapter2);
        b(adapter2);
        this.f13236j.setAdapter(adapter);
        this.f13234h = 0;
        f();
        this.f13238l.a((RecyclerView.Adapter<?>) adapter);
        a(adapter);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f13238l.g();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.A = i2;
        this.f13236j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5
            boolean a = false;
            boolean b = false;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            boolean f13253c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.f13253c = true;
                        return;
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        this.a = false;
                        this.b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 1 || !this.f13253c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (ViewPager2.this.canScrollVertically(-1)) {
                        if (!ViewPager2.this.canScrollVertically(1)) {
                            if (this.b) {
                                onOverScrollListener.onOverScrollEnd();
                            } else {
                                this.b = true;
                            }
                        }
                    } else if (this.a) {
                        onOverScrollListener.onOverScrollStart();
                    } else {
                        this.a = true;
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (ViewPager2.this.canScrollHorizontally(-1)) {
                        if (!ViewPager2.this.canScrollHorizontally(1)) {
                            if (this.b) {
                                onOverScrollListener.onOverScrollEnd();
                            } else {
                                this.b = true;
                            }
                        }
                    } else if (this.a) {
                        onOverScrollListener.onOverScrollStart();
                    } else {
                        this.a = true;
                    }
                }
                this.f13253c = false;
            }
        });
    }

    public void setOrientation(int i2) {
        this.f13243q.setOrientation(i2);
        this.f13238l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f13251y) {
                this.f13250x = this.f13236j.getItemAnimator();
                this.f13251y = true;
            }
            this.f13236j.setItemAnimator(null);
        } else if (this.f13251y) {
            this.f13236j.setItemAnimator(this.f13250x);
            this.f13250x = null;
            this.f13251y = false;
        }
        if (pageTransformer == this.f13249w.a()) {
            return;
        }
        this.f13249w.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z2) {
        this.f13252z = z2;
        this.f13238l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f13241o.b(onPageChangeCallback);
    }

    static class SavedState extends View.BaseSavedState {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Parcelable.Creator<SavedState> f13256d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f13257c;

        @RequiresApi(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.f13257c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.f13257c, i2);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.f13236j.addItemDecoration(itemDecoration, i2);
    }

    int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f13236j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i2, boolean z2) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i2, z2);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13239m = new Rect();
        this.f13240n = new Rect();
        this.f13241o = new CompositeOnPageChangeCallback(3);
        this.f13235i = false;
        this.f13242p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f13235i = true;
                viewPager2.f13237k.a();
            }
        };
        this.f13244r = -1;
        this.f13250x = null;
        this.f13251y = false;
        this.f13252z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13239m = new Rect();
        this.f13240n = new Rect();
        this.f13241o = new CompositeOnPageChangeCallback(3);
        this.f13235i = false;
        this.f13242p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f13235i = true;
                viewPager2.f13237k.a();
            }
        };
        this.f13244r = -1;
        this.f13250x = null;
        this.f13251y = false;
        this.f13252z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f13242p);
        }
    }

    void a() {
        PagerSnapHelper pagerSnapHelper = this.f13246t;
        if (pagerSnapHelper != null) {
            View viewFindSnapView = pagerSnapHelper.findSnapView(this.f13243q);
            if (viewFindSnapView == null) {
                return;
            }
            int position = this.f13243q.getPosition(viewFindSnapView);
            if (position != this.f13234h && getScrollState() == 0) {
                this.f13247u.onPageSelected(position);
            }
            this.f13235i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    void a(int i2, boolean z2) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f13244r != -1) {
                this.f13244r = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (iMin == this.f13234h && this.f13237k.e()) {
            return;
        }
        if (iMin == this.f13234h && z2) {
            return;
        }
        double dH = this.f13234h;
        this.f13234h = iMin;
        this.f13238l.e();
        if (!this.f13237k.e()) {
            dH = this.f13237k.h();
        }
        this.f13237k.a(iMin, z2);
        if (!z2) {
            this.f13236j.scrollToPosition(iMin);
            return;
        }
        double d2 = iMin;
        Double.isNaN(d2);
        if (Math.abs(d2 - dH) > 3.0d) {
            this.f13236j.scrollToPosition(d2 > dH ? iMin - 3 : iMin + 3);
            RecyclerView recyclerView = this.f13236j;
            recyclerView.post(new SmoothScrollToPosition(iMin, recyclerView));
            return;
        }
        this.f13236j.smoothScrollToPosition(iMin);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f13239m = new Rect();
        this.f13240n = new Rect();
        this.f13241o = new CompositeOnPageChangeCallback(3);
        this.f13235i = false;
        this.f13242p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f13235i = true;
                viewPager2.f13237k.a();
            }
        };
        this.f13244r = -1;
        this.f13250x = null;
        this.f13251y = false;
        this.f13252z = true;
        this.A = -1;
        a(context, attributeSet);
    }
}
