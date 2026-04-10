package com.zackratos.ultimatebarx.ultimatebarx.java;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;

/* JADX INFO: loaded from: classes4.dex */
public class UltimateBarX {
    public static Operator statusBar(FragmentActivity fragmentActivity) {
        return new StatusBarOperator(fragmentActivity);
    }

    public static Operator navigationBar(FragmentActivity fragmentActivity) {
        return new NavigationBarOperator(fragmentActivity);
    }

    public static Operator getStatusBar(FragmentActivity fragmentActivity) {
        return new StatusBarOperator(fragmentActivity, getStatusBarConfig(fragmentActivity));
    }

    public static Operator getNavigationBar(FragmentActivity fragmentActivity) {
        return new NavigationBarOperator(fragmentActivity, getNavigationBarConfig(fragmentActivity));
    }

    public static Operator statusBarOnly(FragmentActivity fragmentActivity) {
        return new StatusBarOnlyOperator(fragmentActivity);
    }

    public static Operator getStatusBarOnly(FragmentActivity fragmentActivity) {
        return new StatusBarOnlyOperator(fragmentActivity, getStatusBarConfig(fragmentActivity));
    }

    public static Operator statusBar(Fragment fragment) {
        return new StatusBarOperator(fragment);
    }

    public static Operator navigationBar(Fragment fragment) {
        return new NavigationBarOperator(fragment);
    }

    public static Operator getStatusBar(Fragment fragment) {
        return new StatusBarOperator(fragment, getStatusBarConfig(fragment));
    }

    public static Operator getNavigationBar(Fragment fragment) {
        return new NavigationBarOperator(fragment, getNavigationBarConfig(fragment));
    }

    public static Operator statusBarOnly(Fragment fragment) {
        return new StatusBarOnlyOperator(fragment);
    }

    public static Operator getStatusBarOnly(Fragment fragment) {
        return new StatusBarOnlyOperator(fragment, getStatusBarConfig(fragment));
    }

    public static void addStatusBarTopPadding(View view) {
        UltimateBarXKt.addStatusBarTopPadding(view);
    }

    public static void addNavigationBarBottomPadding(View view) {
        UltimateBarXKt.addNavigationBarBottomPadding(view);
    }

    public static BarConfig getStatusBarConfig(FragmentActivity fragmentActivity) {
        return UltimateBarXKt.getStatusBarConfig(fragmentActivity);
    }

    public static BarConfig getNavigationBarConfig(FragmentActivity fragmentActivity) {
        return UltimateBarXKt.getNavigationBarConfig(fragmentActivity);
    }

    public static BarConfig getStatusBarConfig(Fragment fragment) {
        return UltimateBarXKt.getStatusBarConfig(fragment);
    }

    public static BarConfig getNavigationBarConfig(Fragment fragment) {
        return UltimateBarXKt.getNavigationBarConfig(fragment);
    }

    public static int getStatusBarHeight() {
        return UltimateBarXKt.getStatusBarHeight();
    }

    public static int getNavigationBarHeight() {
        return UltimateBarXKt.getNavigationBarHeight();
    }
}
