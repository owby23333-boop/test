package com.zackratos.ultimatebarx.ultimatebarx.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.umeng.analytics.pro.d;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameLayoutCreator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/view/FrameLayoutCreator;", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/BaseCreator;", "frameLayout", "Landroid/widget/FrameLayout;", "tag", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;", "landscape", "", "(Landroid/widget/FrameLayout;Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;Z)V", "getNavigationBarView", "Landroid/view/View;", d.R, "Landroid/content/Context;", "fitWindow", "getStatusBarView", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class FrameLayoutCreator extends BaseCreator {
    private final FrameLayout frameLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameLayoutCreator(FrameLayout frameLayout, Tag tag, boolean z) {
        super(tag, z);
        Intrinsics.checkParameterIsNotNull(frameLayout, "frameLayout");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        this.frameLayout = frameLayout;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.view.Creator
    public View getStatusBarView(Context context, boolean fitWindow) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        View viewFindViewWithTag = this.frameLayout.findViewWithTag(getTag().getStatusBarViewTag());
        if (viewFindViewWithTag == null) {
            viewFindViewWithTag = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, UltimateBarXKt.getStatusBarHeight());
            layoutParams.gravity = 48;
            viewFindViewWithTag.setLayoutParams(layoutParams);
            viewFindViewWithTag.setTag(getTag().getStatusBarViewTag());
            this.frameLayout.addView(viewFindViewWithTag);
        }
        ViewGroup.LayoutParams layoutParams2 = viewFindViewWithTag.getLayoutParams();
        if (layoutParams2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.topMargin = fitWindow ? -UltimateBarXKt.getStatusBarHeight() : 0;
        viewFindViewWithTag.setLayoutParams(layoutParams3);
        return viewFindViewWithTag;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.view.Creator
    public View getNavigationBarView(Context context, boolean fitWindow) {
        int navigationBarHeight;
        int i;
        Intrinsics.checkParameterIsNotNull(context, "context");
        View viewFindViewWithTag = this.frameLayout.findViewWithTag(getTag().getNavigationBarViewTag());
        int navigationBarHeight2 = -1;
        if (getLandscape()) {
            i = 5;
            navigationBarHeight2 = UltimateBarXKt.getNavigationBarHeight();
            navigationBarHeight = -1;
        } else {
            navigationBarHeight = UltimateBarXKt.getNavigationBarHeight();
            i = 80;
        }
        if (viewFindViewWithTag == null) {
            viewFindViewWithTag = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(navigationBarHeight2, navigationBarHeight);
            layoutParams.gravity = i;
            viewFindViewWithTag.setLayoutParams(layoutParams);
            viewFindViewWithTag.setTag(getTag().getNavigationBarViewTag());
            this.frameLayout.addView(viewFindViewWithTag);
        }
        ViewGroup.LayoutParams layoutParams2 = viewFindViewWithTag.getLayoutParams();
        if (layoutParams2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        if (getLandscape()) {
            layoutParams3.rightMargin = fitWindow ? -UltimateBarXKt.getNavigationBarHeight() : 0;
        } else {
            layoutParams3.bottomMargin = fitWindow ? -UltimateBarXKt.getNavigationBarHeight() : 0;
        }
        viewFindViewWithTag.setLayoutParams(layoutParams3);
        return viewFindViewWithTag;
    }
}
