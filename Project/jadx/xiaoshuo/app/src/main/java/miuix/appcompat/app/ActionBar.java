package miuix.appcompat.app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import java.util.Map;
import miuix.animation.controller.AnimState;
import miuix.appcompat.app.strategy.IActionBarStrategy;
import miuix.appcompat.internal.app.widget.actionbar.CollapseTitle;
import miuix.appcompat.internal.app.widget.actionbar.ExpandTitle;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ActionBar extends androidx.appcompat.app.ActionBar {
    public static final int DISPLAY_SHOW_ACTIONBAR_BLUR = 32768;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int DISPLAY_SHOW_NAVIGATOR_SWITCH = 8192;
    public static final int DISPLAY_SHOW_SPLIT_ACTIONBAR_BLUR = 16384;
    public static final int DISPLAY_UNBIND_TITLE_UP = 32;
    public static final int STATE_AUTO = -1;
    public static final int STATE_COLLAPSE = 0;
    public static final int STATE_EXPAND = 1;

    public interface FragmentViewPagerChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, boolean z, boolean z2);

        void onPageSelected(int i);
    }

    public interface OnScrollListener {
        boolean onContentScrolled();

        void onFling(float f, int i);

        void onScroll(int i, float f);

        void onStartScroll();

        void onStopScroll();
    }

    public abstract void addActionBarTransitionListener(ActionBarTransitionListener actionBarTransitionListener);

    public abstract void addBadgeOnItemView(int i);

    public abstract void addBadgeOnItemView(int i, int i2);

    public abstract void addBadgeOnItemView(MenuItem menuItem);

    public abstract void addBadgeOnItemView(MenuItem menuItem, int i);

    public abstract void addBadgeOnMoreButton();

    public abstract void addBadgeOnMoreButton(int i);

    public abstract int addFragmentTab(String str, ActionBar.Tab tab, int i, Class<? extends androidx.fragment.app.Fragment> cls, Bundle bundle, boolean z);

    public abstract int addFragmentTab(String str, ActionBar.Tab tab, Class<? extends androidx.fragment.app.Fragment> cls, Bundle bundle, boolean z);

    public abstract void addOnFragmentViewPagerChangeListener(FragmentViewPagerChangeListener fragmentViewPagerChangeListener);

    public abstract void clearBadgeOnItemView(int i);

    public abstract void clearBadgeOnItemView(MenuItem menuItem);

    public abstract void clearBadgeOnMoreButton();

    public abstract IActionBarStrategy getActionBarStrategy();

    public abstract View getActionBarView();

    public abstract CollapseTitle getCollapseTitle();

    public abstract View getEndView();

    public abstract int getExpandState();

    public abstract ExpandTitle getExpandTitle();

    public abstract int getExpandedHeight();

    public abstract androidx.fragment.app.Fragment getFragmentAt(int i);

    public abstract int getFragmentTabCount();

    public abstract Map<Integer, Boolean> getHyperMenuPrimaryCheckedData();

    public abstract Map<Integer, Boolean[]> getHyperMenuSecondaryCheckedData();

    public abstract View getStartView();

    public abstract View getSubTitleView(int i);

    public abstract View getTitleView(int i);

    public abstract int getViewPagerOffscreenPageLimit();

    public abstract void hide(AnimState animState);

    public abstract void hide(boolean z);

    public abstract void hide(boolean z, AnimState animState);

    public abstract boolean isFragmentViewPagerMode();

    public abstract boolean isResizable();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public abstract void onDestroy();

    public abstract void registerCoordinateScrollView(View view);

    public abstract void registerCoordinatedScrollView(View view);

    public abstract void removeActionBarTransitionListener(ActionBarTransitionListener actionBarTransitionListener);

    public abstract void removeAllFragmentTab();

    public abstract void removeFragmentTab(ActionBar.Tab tab);

    public abstract void removeFragmentTab(androidx.fragment.app.Fragment fragment);

    public abstract void removeFragmentTab(String str);

    public abstract void removeFragmentTabAt(int i);

    public abstract void removeOnFragmentViewPagerChangeListener(FragmentViewPagerChangeListener fragmentViewPagerChangeListener);

    public abstract void replaceFragmentTab(String str, int i, Class<? extends androidx.fragment.app.Fragment> cls, Bundle bundle, boolean z);

    public abstract void resetCoordinateScrollView(View view);

    public abstract void restoreHyperMenuPrimaryCheckedData(Map<Integer, Boolean> map);

    public abstract void restoreHyperMenuSecondaryCheckedData(Map<Integer, Boolean[]> map);

    public abstract void selectTab(ActionBar.Tab tab, boolean z);

    public abstract void setActionBarStrategy(IActionBarStrategy iActionBarStrategy);

    public abstract void setActionMenuItemLimit(int i);

    public abstract void setActionModeAnim(boolean z);

    public abstract void setEndActionMenuItemLimit(int i);

    public abstract void setEndView(View view);

    public abstract void setExpandState(int i);

    public abstract void setExpandState(int i, boolean z);

    public abstract void setExpandState(int i, boolean z, boolean z2);

    public abstract void setExpandTabTextAppearance(int i, int i2);

    public abstract void setFragmentActionMenuAt(int i, boolean z);

    public abstract void setFragmentViewPagerMode(FragmentActivity fragmentActivity);

    public abstract void setFragmentViewPagerMode(FragmentActivity fragmentActivity, boolean z);

    public abstract void setProgress(int i);

    public abstract void setProgressBarIndeterminate(boolean z);

    public abstract void setProgressBarIndeterminateVisibility(boolean z);

    public abstract void setProgressBarVisibility(boolean z);

    public abstract void setResizable(boolean z);

    @Deprecated
    public abstract void setSecondaryTabTextAppearance(int i, int i2);

    public abstract void setSecondaryTabTextAppearance(int i, int i2, int i3);

    public abstract void setStartView(View view);

    public abstract void setSubTitleClickListener(View.OnClickListener onClickListener);

    public abstract void setTabBadgeDisappearOnClick(int i, boolean z);

    public abstract void setTabBadgeVisibility(int i, boolean z);

    public abstract void setTabIconWithPosition(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void setTabIconWithPosition(int i, int i2, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5);

    public abstract void setTabTextAppearance(int i, int i2);

    public abstract void setTabsMode(boolean z);

    public abstract void setTitleClickable(boolean z);

    public abstract void setViewPagerDecor(View view);

    public abstract void setViewPagerDraggable(boolean z);

    public abstract void setViewPagerOffscreenPageLimit(int i);

    public abstract void show(AnimState animState);

    public abstract void show(boolean z);

    public abstract void show(boolean z, AnimState animState);

    public abstract void showActionBarShadow(boolean z);

    public abstract void showSplitActionBar(boolean z, boolean z2);

    public abstract void unregisterCoordinateScrollView(View view);

    public abstract void unregisterCoordinatedScrollView(View view);
}
