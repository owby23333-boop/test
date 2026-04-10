package me.jessyan.lifecyclemodel;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes3.dex */
public class LifecycleModelStores {
    private LifecycleModelStores() {
    }

    @MainThread
    public static LifecycleModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return HolderFragment.holderFragmentFor(fragmentActivity).getLifecycleModelStore();
    }

    @MainThread
    public static LifecycleModelStore of(@NonNull Fragment fragment) {
        return HolderFragment.holderFragmentFor(fragment).getLifecycleModelStore();
    }
}
