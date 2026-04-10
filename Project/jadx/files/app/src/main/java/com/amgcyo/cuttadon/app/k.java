package com.amgcyo.cuttadon.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.squareup.leakcanary.RefWatcher;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FragmentLifecycleCallbacksImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends FragmentManager.FragmentLifecycleCallbacks {
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @NotNull Context context) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(@NotNull FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        fragment.setRetainInstance(true);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        try {
            ((RefWatcher) me.jessyan.art.f.e.a(fragment.getActivity()).e().get(me.jessyan.art.d.j.c.d(RefWatcher.class.getName()))).watch(fragment);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @NotNull Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @NotNull View view, Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
    }
}
