package me.jessyan.art.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: compiled from: FragmentLifecycle.java */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
public class g extends FragmentManager.FragmentLifecycleCallbacks {
    @Inject
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private me.jessyan.art.base.f.f a(Fragment fragment) {
        if (fragment instanceof me.jessyan.art.base.f.i) {
            return (me.jessyan.art.base.f.f) a((me.jessyan.art.base.f.i) fragment).get(me.jessyan.art.d.j.c.d("FRAGMENT_DELEGATE"));
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.a(bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        if (fragment instanceof me.jessyan.art.base.f.i) {
            me.jessyan.art.base.f.f fVarA = a(fragment);
            if (fVarA == null || !fVarA.isAdded()) {
                me.jessyan.art.d.j.a<String, Object> aVarA = a((me.jessyan.art.base.f.i) fragment);
                me.jessyan.art.base.f.g gVar = new me.jessyan.art.base.f.g(fragmentManager, fragment);
                aVarA.put(me.jessyan.art.d.j.c.d("FRAGMENT_DELEGATE"), gVar);
                fVarA = gVar;
            }
            fVarA.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onDestroy();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onDetach();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onResume();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onStop();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.a(view, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        me.jessyan.art.base.f.f fVarA = a(fragment);
        if (fVarA != null) {
            fVarA.onDestroyView();
        }
    }

    @NonNull
    private me.jessyan.art.d.j.a<String, Object> a(me.jessyan.art.base.f.i iVar) {
        me.jessyan.art.d.j.a<String, Object> aVarProvideCache = iVar.provideCache();
        me.jessyan.art.f.g.a(aVarProvideCache, "%s cannot be null on Fragment", me.jessyan.art.d.j.a.class.getName());
        return aVarProvideCache;
    }
}
