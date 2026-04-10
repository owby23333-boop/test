package com.drake.statelayout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"stateCreate", "Lcom/drake/statelayout/StateLayout;", "Landroid/app/Activity;", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "statelayout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StateUtilsKt {
    public static final StateLayout stateCreate(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        View viewFindViewById = activity.findViewById(android.R.id.content);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        View view = ((ViewGroup) viewFindViewById).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return stateCreate(view);
    }

    public static final StateLayout stateCreate(final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        View viewRequireView = fragment.requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView()");
        final StateLayout stateLayoutStateCreate = stateCreate(viewRequireView);
        fragment.getViewLifecycleOwner().getLifecycle().addObserver(new LifecycleObserver() { // from class: com.drake.statelayout.StateUtilsKt.stateCreate.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void removeState() {
                ViewParent parent = stateLayoutStateCreate.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(stateLayoutStateCreate);
                fragment.getLifecycle().removeObserver(this);
            }
        });
        return stateLayoutStateCreate;
    }

    public static final StateLayout stateCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if ((viewGroup instanceof ViewPager) || (viewGroup instanceof RecyclerView)) {
            throw new UnsupportedOperationException("You should using StateLayout wrap [ " + view + " ] in layout when parent is ViewPager or RecyclerView");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StateLayout stateLayout = new StateLayout(context, null, 0, 6, null);
        stateLayout.setId(view.getId());
        int iIndexOfChild = viewGroup.indexOfChild(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        viewGroup.removeView(view);
        viewGroup.addView(stateLayout, iIndexOfChild, layoutParams);
        if (view instanceof ConstraintLayout) {
            stateLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        } else {
            stateLayout.addView(view);
        }
        stateLayout.setContent(view);
        return stateLayout;
    }
}
