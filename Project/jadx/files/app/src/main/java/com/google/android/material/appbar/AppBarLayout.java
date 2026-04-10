package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int J = R$style.Widget_Design_AppBarLayout;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;

    @IdRes
    private int E;

    @Nullable
    private WeakReference<View> F;

    @Nullable
    private ValueAnimator G;
    private int[] H;

    @Nullable
    private Drawable I;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f14922s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f14923t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14924u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f14925v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f14926w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f14927x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private WindowInsetsCompat f14928y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List<c> f14929z;

    /* JADX INFO: Access modifiers changed from: protected */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f14930k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14931l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ValueAnimator f14932m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f14933n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f14934o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private float f14935p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @Nullable
        private WeakReference<View> f14936q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private d f14937r;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f14941s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f14942t;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f14941s = coordinatorLayout;
                this.f14942t = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.b(this.f14941s, this.f14942t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b implements AccessibilityViewCommand {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f14944c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f14945d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
                this.f14944c = view;
                this.f14945d = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.a, this.b, this.f14944c, 0, this.f14945d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class c implements AccessibilityViewCommand {
            final /* synthetic */ AppBarLayout a;
            final /* synthetic */ boolean b;

            c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z2) {
                this.a = appBarLayout;
                this.b = z2;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                this.a.setExpanded(this.b);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t2);
        }

        public BaseBehavior() {
            this.f14933n = -1;
        }

        private static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private void d(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            int iB = b();
            int iB2 = b(t2, iB);
            if (iB2 >= 0) {
                View childAt = t2.getChildAt(iB2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iA = layoutParams.a();
                if ((iA & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (iB2 == t2.getChildCount() - 1) {
                        minimumHeight += t2.getTopInset();
                    }
                    if (a(iA, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt);
                    } else if (a(iA, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                        if (iB < minimumHeight2) {
                            i2 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (a(iA, 32)) {
                        i2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (iB < (minimumHeight + i2) / 2) {
                        i2 = minimumHeight;
                    }
                    a(coordinatorLayout, (AppBarLayout) t2, MathUtils.clamp(i2, -t2.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void e(CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View viewA = a(coordinatorLayout);
            if (viewA == null || t2.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) viewA.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            a(coordinatorLayout, t2, viewA);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int c(@NonNull T t2) {
            return t2.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f14933n = -1;
        }

        private boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            return t2.b() && coordinatorLayout.getHeight() - view.getHeight() <= t2.getHeight();
        }

        private int c(@NonNull T t2, int i2) {
            int iAbs = Math.abs(i2);
            int childCount = t2.getChildCount();
            int topInset = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t2.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorB = layoutParams.b();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i3++;
                } else if (interpolatorB != null) {
                    int iA = layoutParams.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset -= t2.getTopInset();
                    }
                    if (topInset > 0) {
                        float f2 = topInset;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i2;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            int f14938s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            float f14939t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            boolean f14940u;

            static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f14938s = parcel.readInt();
                this.f14939t = parcel.readFloat();
                this.f14940u = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f14938s);
                parcel.writeFloat(this.f14939t);
                parcel.writeByte(this.f14940u ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z2 = (i2 & 2) != 0 && (t2.c() || b(coordinatorLayout, t2, view));
            if (z2 && (valueAnimator = this.f14932m) != null) {
                valueAnimator.cancel();
            }
            this.f14936q = null;
            this.f14931l = i3;
            return z2;
        }

        private int b(@NonNull T t2, int i2) {
            int childCount = t2.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t2.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int downNestedPreScrollRange;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i6 = -t2.getTotalScrollRange();
                    i5 = i6;
                    downNestedPreScrollRange = t2.getDownNestedPreScrollRange() + i6;
                } else {
                    i5 = -t2.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i5 != downNestedPreScrollRange) {
                    iArr[1] = a(coordinatorLayout, t2, i3, i5, downNestedPreScrollRange);
                }
            }
            if (t2.c()) {
                t2.a(t2.a(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int b(@NonNull T t2) {
            return -t2.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int b() {
            return a() + this.f14930k;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = a(coordinatorLayout, t2, i5, -t2.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                e(coordinatorLayout, t2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t2);
            int iA = a();
            int childCount = t2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t2.getChildAt(i2);
                int bottom = childAt.getBottom() + iA;
                if (childAt.getTop() + iA <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
                    savedState.f14938s = i2;
                    savedState.f14940u = bottom == ViewCompat.getMinimumHeight(childAt) + t2.getTopInset();
                    savedState.f14939t = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableOnSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t2, View view, int i2) {
            if (this.f14931l == 0 || i2 == 1) {
                d(coordinatorLayout, t2);
                if (t2.c()) {
                    t2.a(t2.a(view));
                }
            }
            this.f14936q = new WeakReference<>(view);
        }

        private boolean c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            List<View> dependents = coordinatorLayout.getDependents(t2);
            int size = dependents.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).b() != 0;
                }
            }
            return false;
        }

        private void a(CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, float f2) {
            int height;
            int iAbs = Math.abs(b() - i2);
            float fAbs = Math.abs(f2);
            if (fAbs > 0.0f) {
                height = Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / t2.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (AppBarLayout) t2, i2, height);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3) {
            int iB = b();
            if (iB == i2) {
                ValueAnimator valueAnimator = this.f14932m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f14932m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f14932m;
            if (valueAnimator2 == null) {
                this.f14932m = new ValueAnimator();
                this.f14932m.setInterpolator(com.google.android.material.a.a.f14916e);
                this.f14932m.addUpdateListener(new a(coordinatorLayout, t2));
            } else {
                valueAnimator2.cancel();
            }
            this.f14932m.setDuration(Math.min(i3, 600));
            this.f14932m.setIntValues(iB, i2);
            this.f14932m.start();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t2.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t2, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, t2, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2) {
            int iRound;
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t2, i2);
            int pendingAction = t2.getPendingAction();
            int i3 = this.f14933n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t2.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.f14934o) {
                    iRound = ViewCompat.getMinimumHeight(childAt) + t2.getTopInset();
                } else {
                    iRound = Math.round(childAt.getHeight() * this.f14935p);
                }
                b(coordinatorLayout, t2, i4 + iRound);
            } else if (pendingAction != 0) {
                boolean z2 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t2.getUpNestedPreScrollRange();
                    if (z2) {
                        a(coordinatorLayout, (AppBarLayout) t2, i5, 0.0f);
                    } else {
                        b(coordinatorLayout, t2, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z2) {
                        a(coordinatorLayout, (AppBarLayout) t2, 0, 0.0f);
                    } else {
                        b(coordinatorLayout, t2, 0);
                    }
                }
            }
            t2.d();
            this.f14933n = -1;
            a(MathUtils.clamp(a(), -t2.getTotalScrollRange(), 0));
            a(coordinatorLayout, (AppBarLayout) t2, a(), 0, true);
            t2.a(a());
            e(coordinatorLayout, t2);
            return zOnLayoutChild;
        }

        private void a(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull View view) {
            if (b() != (-t2.getTotalScrollRange()) && view.canScrollVertically(1)) {
                a(coordinatorLayout, (AppBarLayout) t2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (b() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i2 = -t2.getDownNestedPreScrollRange();
                    if (i2 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(coordinatorLayout, t2, view, i2));
                        return;
                    }
                    return;
                }
                a(coordinatorLayout, (AppBarLayout) t2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, @NonNull T t2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z2) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new c(this, t2, z2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean a(T t2) {
            d dVar = this.f14937r;
            if (dVar != null) {
                return dVar.a(t2);
            }
            WeakReference<View> weakReference = this.f14936q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2) {
            d(coordinatorLayout, t2);
            if (t2.c()) {
                t2.a(t2.a(a(coordinatorLayout)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, int i4) {
            int iB = b();
            int i5 = 0;
            if (i3 != 0 && iB >= i3 && iB <= i4) {
                int iClamp = MathUtils.clamp(i2, i3, i4);
                if (iB != iClamp) {
                    int iC = t2.a() ? c(t2, iClamp) : iClamp;
                    boolean zA = a(iC);
                    i5 = iB - iClamp;
                    this.f14930k = iClamp - iC;
                    if (!zA && t2.a()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t2);
                    }
                    t2.a(a());
                    a(coordinatorLayout, (AppBarLayout) t2, iClamp, iClamp < iB ? -1 : 1, false);
                }
            } else {
                this.f14930k = 0;
            }
            e(coordinatorLayout, t2);
            return i5;
        }

        private void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, int i2, int i3, boolean z2) {
            View viewA = a(t2, i2);
            if (viewA != null) {
                int iA = ((LayoutParams) viewA.getLayoutParams()).a();
                boolean zA = false;
                if ((iA & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(viewA);
                    if (i3 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i2) < (viewA.getBottom() - minimumHeight) - t2.getTopInset()) : (-i2) >= (viewA.getBottom() - minimumHeight) - t2.getTopInset()) {
                        zA = true;
                    }
                }
                if (t2.c()) {
                    zA = t2.a(a(coordinatorLayout));
                }
                boolean zA2 = t2.a(zA);
                if (z2 || (zA2 && c(coordinatorLayout, t2))) {
                    t2.jumpDrawablesToCurrentState();
                }
            }
        }

        @Nullable
        private static View a(@NonNull AppBarLayout appBarLayout, int i2) {
            int iAbs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private View a(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t2, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t2, savedState.getSuperState());
                this.f14933n = savedState.f14938s;
                this.f14935p = savedState.f14939t;
                this.f14934o = savedState.f14940u;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t2, parcelable);
            this.f14933n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* bridge */ /* synthetic */ View a(@NonNull List list) {
            return a((List<View>) list);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float b(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iA = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iA > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iA / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int c(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.c(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z2) {
            AppBarLayout appBarLayoutA = a(coordinatorLayout.getDependencies(view));
            if (appBarLayoutA != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f14967d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutA.a(false, !z2);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        private void a(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f14930k) + c()) - a(view2));
            }
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.c()) {
                    appBarLayout.a(appBarLayout.a(view));
                }
            }
        }

        private static int a(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).b();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        AppBarLayout a(@NonNull List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.a(windowInsetsCompat);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ MaterialShapeDrawable f14947s;

        b(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
            this.f14947s = materialShapeDrawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.f14947s.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c<T extends AppBarLayout> {
        void a(T t2, int i2);
    }

    public interface d extends c<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void e() {
        WeakReference<View> weakReference = this.F;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.F = null;
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.f14923t = -1;
        this.f14924u = -1;
        this.f14925v = -1;
    }

    private boolean h() {
        return this.I != null && getTopInset() > 0;
    }

    private boolean i() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    private void j() {
        setWillNotDraw(!h());
    }

    public void a(@Nullable c cVar) {
        if (this.f14929z == null) {
            this.f14929z = new ArrayList();
        }
        if (cVar == null || this.f14929z.contains(cVar)) {
            return;
        }
        this.f14929z.add(cVar);
    }

    public void b(@Nullable c cVar) {
        List<c> list = this.f14929z;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public boolean c() {
        return this.D;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void d() {
        this.f14927x = 0;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (h()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f14922s);
            this.I.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.I;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i2 = this.f14924u;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
            } else {
                int i5 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i4 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i4 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    iMin = i5 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i3 += iMin;
                }
                iMin = i5 + minimumHeight;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i3 += iMin;
            }
        }
        int iMax = Math.max(0, i3);
        this.f14924u = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i2 = this.f14925v;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i4 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f14925v = iMax;
        return iMax;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.E;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getPendingAction() {
        return this.f14927x;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.I;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f14928y;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f14923t;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.a;
            if ((i4 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i3 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                minimumHeight -= getTopInset();
            }
            if ((i4 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i3++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f14923t = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.H == null) {
            this.H = new int[4];
        }
        int[] iArr = this.H;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.B ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (this.B && this.C) ? R$attr.state_lifted : -R$attr.state_lifted;
        iArr[2] = this.B ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (this.B && this.C) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (ViewCompat.getFitsSystemWindows(this) && i()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        g();
        this.f14926w = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f14926w = true;
                break;
            }
            i6++;
        }
        Drawable drawable = this.I;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.A) {
            return;
        }
        b(this.D || f());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && i()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        g();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        h.a(this, f2);
    }

    public void setExpanded(boolean z2) {
        a(z2, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.D = z2;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.E = i2;
        e();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.I;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.I = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.I;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.I.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.I, ViewCompat.getLayoutDirection(this));
                this.I.setVisible(getVisibility() == 0, false);
                this.I.setCallback(this);
            }
            j();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.b.a(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.I;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.I;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, J), attributeSet, i2);
        this.f14923t = -1;
        this.f14924u = -1;
        this.f14925v = -1;
        this.f14927x = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.b.a(this);
            com.google.android.material.appbar.b.a(this, attributeSet, i2, J);
        }
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.AppBarLayout, i2, J, new int[0]);
        ViewCompat.setBackground(this, typedArrayC.getDrawable(R$styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.a(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.a(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (typedArrayC.hasValue(R$styleable.AppBarLayout_expanded)) {
            a(typedArrayC.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayC.hasValue(R$styleable.AppBarLayout_elevation)) {
            com.google.android.material.appbar.b.a(this, typedArrayC.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayC.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayC.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayC.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayC.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.D = typedArrayC.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.E = typedArrayC.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayC.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        typedArrayC.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    public void b(d dVar) {
        b((c) dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    boolean b() {
        return getTotalScrollRange() != 0;
    }

    private boolean b(boolean z2) {
        if (this.B == z2) {
            return false;
        }
        this.B = z2;
        refreshDrawableState();
        return true;
    }

    public void a(d dVar) {
        a((c) dVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void a(boolean z2, boolean z3) {
        a(z2, z3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        this.f14927x = (z2 ? 1 : 2) | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        requestLayout();
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        int a;
        Interpolator b;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            int i2 = this.a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }

    @Nullable
    private View b(@Nullable View view) {
        int i2;
        if (this.F == null && (i2 = this.E) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i2) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.E);
            }
            if (viewFindViewById != null) {
                this.F = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.F;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    boolean a() {
        return this.f14926w;
    }

    void a(int i2) {
        this.f14922s = i2;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<c> list = this.f14929z;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f14929z.get(i3);
                if (cVar != null) {
                    cVar.a(this, i2);
                }
            }
        }
    }

    boolean a(boolean z2) {
        if (this.C == z2) {
            return false;
        }
        this.C = z2;
        refreshDrawableState();
        if (!this.D || !(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        a((MaterialShapeDrawable) getBackground(), z2);
        return true;
    }

    private void a(@NonNull MaterialShapeDrawable materialShapeDrawable, boolean z2) {
        float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
        float f2 = z2 ? 0.0f : dimension;
        if (!z2) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.G = ValueAnimator.ofFloat(f2, dimension);
        this.G.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.G.setInterpolator(com.google.android.material.a.a.a);
        this.G.addUpdateListener(new b(this, materialShapeDrawable));
        this.G.start();
    }

    boolean a(@Nullable View view) {
        View viewB = b(view);
        if (viewB != null) {
            view = viewB;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    WindowInsetsCompat a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f14928y, windowInsetsCompat2)) {
            this.f14928y = windowInsetsCompat2;
            j();
            requestLayout();
        }
        return windowInsetsCompat;
    }
}
