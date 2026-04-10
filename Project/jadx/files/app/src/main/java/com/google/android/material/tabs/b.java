package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.internal.s;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: TabIndicatorInterpolator.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    b() {
    }

    static RectF a(@NonNull TabLayout.i iVar, @Dimension(unit = 0) int i2) {
        int contentWidth = iVar.getContentWidth();
        int contentHeight = iVar.getContentHeight();
        int iA = (int) s.a(iVar.getContext(), i2);
        if (contentWidth >= iA) {
            iA = contentWidth;
        }
        int left = (iVar.getLeft() + iVar.getRight()) / 2;
        int top = (iVar.getTop() + iVar.getBottom()) / 2;
        int i3 = iA / 2;
        return new RectF(left - i3, top - (contentHeight / 2), i3 + left, top + (left / 2));
    }

    static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.b() && (view instanceof TabLayout.i)) {
            return a((TabLayout.i) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    void a(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }

    void a(TabLayout tabLayout, View view, View view2, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2, @NonNull Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(com.google.android.material.a.a.a((int) rectFA.left, (int) rectFA2.left, f2), drawable.getBounds().top, com.google.android.material.a.a.a((int) rectFA.right, (int) rectFA2.right, f2), drawable.getBounds().bottom);
    }
}
