package com.baidu.mobads.sdk.internal.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: classes2.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int a = 100;
    private static final float b = 100.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private OrientationHelper f13208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private OrientationHelper f13209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RecyclerView f13210e;

    @Nullable
    private OrientationHelper b(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return c(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return d(layoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper c(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f13208c;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f13208c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f13208c;
    }

    @NonNull
    private OrientationHelper d(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f13209d;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f13209d = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f13209d;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
        if (this.f13210e == recyclerView) {
            return;
        }
        this.f13210e = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @NonNull
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, d(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f13210e) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.baidu.mobads.sdk.internal.widget.PagerSnapHelper.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected int calculateTimeForScrolling(int i2) {
                return Math.min(100, super.calculateTimeForScrolling(i2));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onStop() {
                RecyclerView.LayoutManager layoutManager2;
                super.onStop();
                if (PagerSnapHelper.this.f13210e == null || PagerSnapHelper.this.f13210e.getScrollState() == 0 || (layoutManager2 = PagerSnapHelper.this.f13210e.getLayoutManager()) == null || layoutManager2.getChildCount() > 1) {
                    return;
                }
                PagerSnapHelper.this.f13210e.stopScroll();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (PagerSnapHelper.this.f13210e == null || PagerSnapHelper.this.f13210e.getLayoutManager() == null) {
                    return;
                }
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] iArrCalculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.f13210e.getLayoutManager(), view);
                int i2 = iArrCalculateDistanceToFinalSnap[0];
                int i3 = iArrCalculateDistanceToFinalSnap[1];
                int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
                if (iCalculateTimeForDeceleration > 0) {
                    action.update(i2, i3, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        };
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, c(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, d(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        OrientationHelper orientationHelperB;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (orientationHelperB = b(layoutManager)) == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = layoutManager.getChildAt(i6);
            if (childAt != null) {
                int iA = a(layoutManager, childAt, orientationHelperB);
                if (iA <= 0 && iA > i4) {
                    view2 = childAt;
                    i4 = iA;
                }
                if (iA >= 0 && iA < i5) {
                    view = childAt;
                    i5 = iA;
                }
            }
        }
        boolean zA = a(layoutManager, i2, i3);
        if (zA && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!zA && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (!zA) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view2) + (a(layoutManager) == zA ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }

    private boolean a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        return layoutManager.canScrollHorizontally() ? i2 > 0 : i3 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(RecyclerView.LayoutManager layoutManager) {
        PointF pointFComputeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (pointFComputeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return pointFComputeScrollVectorForPosition.x < 0.0f || pointFComputeScrollVectorForPosition.y < 0.0f;
    }

    private int a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    @Nullable
    private View a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = layoutManager.getChildAt(i3);
            int iAbs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (iAbs < i2) {
                view = childAt;
                i2 = iAbs;
            }
        }
        return view;
    }
}
