package me.jessyan.lifecyclemodel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class HolderFragment extends Fragment {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String HOLDER_TAG = "me.jessyan.lifecyclemodel.state.StateProviderHolderFragment";
    private static final String LOG_TAG = "LifecycleModelStores";
    private static final HolderFragmentManager sHolderFragmentManager = new HolderFragmentManager();
    private final LifecycleModelStore mLifecycleModelStore = new LifecycleModelStore();

    public HolderFragment() {
        setRetainInstance(true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static HolderFragment holderFragmentFor(FragmentActivity fragmentActivity) {
        return sHolderFragmentManager.holderFragmentFor(fragmentActivity);
    }

    public LifecycleModelStore getLifecycleModelStore() {
        return this.mLifecycleModelStore;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        sHolderFragmentManager.holderFragmentCreated(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mLifecycleModelStore.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static HolderFragment holderFragmentFor(Fragment fragment) {
        return sHolderFragmentManager.holderFragmentFor(fragment);
    }

    static class HolderFragmentManager {
        private Map<Activity, HolderFragment> mNotCommittedActivityHolders = new HashMap();
        private Map<Fragment, HolderFragment> mNotCommittedFragmentHolders = new HashMap();
        private Application.ActivityLifecycleCallbacks mActivityCallbacks = new EmptyActivityLifecycleCallbacks() { // from class: me.jessyan.lifecyclemodel.HolderFragment.HolderFragmentManager.1
            @Override // me.jessyan.lifecyclemodel.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (((HolderFragment) HolderFragmentManager.this.mNotCommittedActivityHolders.remove(activity)) != null) {
                    String str = "Failed to save a LifecycleModel for " + activity;
                }
            }
        };
        private boolean mActivityCallbacksIsAdded = false;
        private FragmentManager.FragmentLifecycleCallbacks mParentDestroyedCallback = new FragmentManager.FragmentLifecycleCallbacks() { // from class: me.jessyan.lifecyclemodel.HolderFragment.HolderFragmentManager.2
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                super.onFragmentDestroyed(fragmentManager, fragment);
                if (((HolderFragment) HolderFragmentManager.this.mNotCommittedFragmentHolders.remove(fragment)) != null) {
                    String str = "Failed to save a LifecycleModel for " + fragment;
                }
            }
        };

        HolderFragmentManager() {
        }

        private static HolderFragment createHolderFragment(FragmentManager fragmentManager) {
            HolderFragment holderFragment = new HolderFragment();
            fragmentManager.beginTransaction().add(holderFragment, HolderFragment.HOLDER_TAG).commitAllowingStateLoss();
            return holderFragment;
        }

        private static HolderFragment findHolderFragment(FragmentManager fragmentManager) {
            if (fragmentManager.isDestroyed()) {
                throw new IllegalStateException("Can't access LifecycleModels from onDestroy");
            }
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(HolderFragment.HOLDER_TAG);
            if (fragmentFindFragmentByTag == null || (fragmentFindFragmentByTag instanceof HolderFragment)) {
                return (HolderFragment) fragmentFindFragmentByTag;
            }
            throw new IllegalStateException("Unexpected fragment instance was returned by HOLDER_TAG");
        }

        void holderFragmentCreated(Fragment fragment) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                this.mNotCommittedActivityHolders.remove(fragment.getActivity());
            } else {
                this.mNotCommittedFragmentHolders.remove(parentFragment);
                parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.mParentDestroyedCallback);
            }
        }

        HolderFragment holderFragmentFor(FragmentActivity fragmentActivity) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            HolderFragment holderFragmentFindHolderFragment = findHolderFragment(supportFragmentManager);
            if (holderFragmentFindHolderFragment != null) {
                return holderFragmentFindHolderFragment;
            }
            HolderFragment holderFragment = this.mNotCommittedActivityHolders.get(fragmentActivity);
            if (holderFragment != null) {
                return holderFragment;
            }
            if (!this.mActivityCallbacksIsAdded) {
                this.mActivityCallbacksIsAdded = true;
                fragmentActivity.getApplication().registerActivityLifecycleCallbacks(this.mActivityCallbacks);
            }
            HolderFragment holderFragmentCreateHolderFragment = createHolderFragment(supportFragmentManager);
            this.mNotCommittedActivityHolders.put(fragmentActivity, holderFragmentCreateHolderFragment);
            return holderFragmentCreateHolderFragment;
        }

        HolderFragment holderFragmentFor(Fragment fragment) {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            HolderFragment holderFragmentFindHolderFragment = findHolderFragment(childFragmentManager);
            if (holderFragmentFindHolderFragment != null) {
                return holderFragmentFindHolderFragment;
            }
            HolderFragment holderFragment = this.mNotCommittedFragmentHolders.get(fragment);
            if (holderFragment != null) {
                return holderFragment;
            }
            fragment.getFragmentManager().registerFragmentLifecycleCallbacks(this.mParentDestroyedCallback, false);
            HolderFragment holderFragmentCreateHolderFragment = createHolderFragment(childFragmentManager);
            this.mNotCommittedFragmentHolders.put(fragment, holderFragmentCreateHolderFragment);
            return holderFragmentCreateHolderFragment;
        }
    }
}
