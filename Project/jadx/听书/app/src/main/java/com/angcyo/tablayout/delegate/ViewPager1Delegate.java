package com.angcyo.tablayout.delegate;

import androidx.viewpager.widget.ViewPager;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.ViewPagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPager1Delegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J(\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/angcyo/tablayout/delegate/ViewPager1Delegate;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/angcyo/tablayout/ViewPagerDelegate;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "dslTabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "forceSmoothScroll", "", "(Landroidx/viewpager/widget/ViewPager;Lcom/angcyo/tablayout/DslTabLayout;Ljava/lang/Boolean;)V", "getDslTabLayout", "()Lcom/angcyo/tablayout/DslTabLayout;", "getForceSmoothScroll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "onGetCurrentItem", "", "onPageScrollStateChanged", "", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onSetCurrentItem", "fromIndex", "toIndex", "reselect", "fromUser", "Companion", "ViewPager1Delegate_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ViewPager1Delegate implements ViewPager.OnPageChangeListener, ViewPagerDelegate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DslTabLayout dslTabLayout;
    private final Boolean forceSmoothScroll;
    private final ViewPager viewPager;

    public ViewPager1Delegate(ViewPager viewPager, DslTabLayout dslTabLayout, Boolean bool) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.viewPager = viewPager;
        this.dslTabLayout = dslTabLayout;
        this.forceSmoothScroll = bool;
        viewPager.addOnPageChangeListener(this);
        if (dslTabLayout != null) {
            dslTabLayout.setupViewPager(this);
        }
    }

    public /* synthetic */ ViewPager1Delegate(ViewPager viewPager, DslTabLayout dslTabLayout, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewPager, dslTabLayout, (i & 4) != 0 ? null : bool);
    }

    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public final DslTabLayout getDslTabLayout() {
        return this.dslTabLayout;
    }

    public final Boolean getForceSmoothScroll() {
        return this.forceSmoothScroll;
    }

    /* JADX INFO: compiled from: ViewPager1Delegate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/angcyo/tablayout/delegate/ViewPager1Delegate$Companion;", "", "()V", "install", "Lcom/angcyo/tablayout/delegate/ViewPager1Delegate;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "dslTabLayout", "Lcom/angcyo/tablayout/DslTabLayout;", "forceSmoothScroll", "", "(Landroidx/viewpager/widget/ViewPager;Lcom/angcyo/tablayout/DslTabLayout;Ljava/lang/Boolean;)Lcom/angcyo/tablayout/delegate/ViewPager1Delegate;", "ViewPager1Delegate_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ViewPager1Delegate install$default(Companion companion, ViewPager viewPager, DslTabLayout dslTabLayout, Boolean bool, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = null;
            }
            return companion.install(viewPager, dslTabLayout, bool);
        }

        public final ViewPager1Delegate install(ViewPager viewPager, DslTabLayout dslTabLayout, Boolean forceSmoothScroll) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
            return new ViewPager1Delegate(viewPager, dslTabLayout, forceSmoothScroll);
        }
    }

    @Override // com.angcyo.tablayout.ViewPagerDelegate
    public int onGetCurrentItem() {
        return this.viewPager.getCurrentItem();
    }

    @Override // com.angcyo.tablayout.ViewPagerDelegate
    public void onSetCurrentItem(int fromIndex, int toIndex, boolean reselect, boolean fromUser) {
        if (fromUser) {
            Boolean bool = this.forceSmoothScroll;
            this.viewPager.setCurrentItem(toIndex, bool != null ? bool.booleanValue() : Math.abs(toIndex - fromIndex) <= 1);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        DslTabLayout dslTabLayout = this.dslTabLayout;
        if (dslTabLayout != null) {
            dslTabLayout.onPageScrollStateChanged(state);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        DslTabLayout dslTabLayout = this.dslTabLayout;
        if (dslTabLayout != null) {
            dslTabLayout.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        DslTabLayout dslTabLayout = this.dslTabLayout;
        if (dslTabLayout != null) {
            dslTabLayout.onPageSelected(position);
        }
    }
}
