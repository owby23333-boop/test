package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Map<View, Integer> f16085i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @NonNull
    protected FabTransformationBehavior.e a(Context context, boolean z2) {
        int i2 = z2 ? R$animator.mtrl_fab_transformation_sheet_expand_spec : R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.a = h.a(context, i2);
        eVar.b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @CallSuper
    protected boolean a(@NonNull View view, @NonNull View view2, boolean z2, boolean z3) {
        a(view2, z2);
        return super.a(view, view2, z2, z3);
    }

    private void a(@NonNull View view, boolean z2) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z2) {
                this.f16085i = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z3) {
                    if (!z2) {
                        Map<View, Integer> map = this.f16085i;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.f16085i.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f16085i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (z2) {
                return;
            }
            this.f16085i = null;
        }
    }
}
