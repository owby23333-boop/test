package com.bumptech.glide.l;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes2.dex */
public class p implements Handler.Callback {
    private static final b B = new a();
    private final k A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile com.bumptech.glide.i f13391s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Handler f13394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final b f13395w;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, o> f13392t = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, t> f13393u = new HashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f13396x = new ArrayMap<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f13397y = new ArrayMap<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Bundle f13398z = new Bundle();

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.l.p.b
        @NonNull
        public com.bumptech.glide.i a(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
            return new com.bumptech.glide.i(cVar, lVar, qVar, context);
        }
    }

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface b {
        @NonNull
        com.bumptech.glide.i a(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context);
    }

    public p(@Nullable b bVar, com.bumptech.glide.f fVar) {
        this.f13395w = bVar == null ? B : bVar;
        this.f13394v = new Handler(Looper.getMainLooper(), this);
        this.A = a(fVar);
    }

    private static k a(com.bumptech.glide.f fVar) {
        return (com.bumptech.glide.load.resource.bitmap.q.f13786h && com.bumptech.glide.load.resource.bitmap.q.f13785g) ? fVar.a(d.e.class) ? new i() : new j() : new g();
    }

    @Deprecated
    private void b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f13398z.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f13398z, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    @NonNull
    private com.bumptech.glide.i c(@NonNull Context context) {
        if (this.f13391s == null) {
            synchronized (this) {
                if (this.f13391s == null) {
                    this.f13391s = this.f13395w.a(com.bumptech.glide.c.a(context.getApplicationContext()), new com.bumptech.glide.l.b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f13391s;
    }

    private static boolean d(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        androidx.fragment.app.FragmentManager fragmentManager;
        androidx.fragment.app.FragmentManager fragmentManager2;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = message.arg1 == 1;
        int i2 = message.what;
        Object objRemove = null;
        if (i2 == 1) {
            FragmentManager fragmentManager3 = (FragmentManager) message.obj;
            if (a(fragmentManager3, z4)) {
                objRemove = this.f13392t.remove(fragmentManager3);
                fragmentManager2 = fragmentManager3;
                z2 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
        } else if (i2 != 2) {
            fragmentManager = null;
            z3 = false;
        } else {
            androidx.fragment.app.FragmentManager fragmentManager4 = (androidx.fragment.app.FragmentManager) message.obj;
            if (a(fragmentManager4, z4)) {
                objRemove = this.f13393u.remove(fragmentManager4);
                fragmentManager2 = fragmentManager4;
                z2 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
        }
        if (Log.isLoggable("RMRetriever", 5) && z2 && objRemove == null) {
            String str = "Failed to remove expected request manager fragment, manager: " + fragmentManager;
        }
        return z3;
    }

    @NonNull
    public com.bumptech.glide.i a(@NonNull Context context) {
        if (context != null) {
            if (com.bumptech.glide.util.l.e() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return a((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return a(contextWrapper.getBaseContext());
                    }
                }
            }
            return c(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @Nullable
    private static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(17)
    private static void c(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    @Deprecated
    o b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null);
    }

    @NonNull
    public com.bumptech.glide.i a(@NonNull FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.l.d()) {
            return a(fragmentActivity.getApplicationContext());
        }
        c((Activity) fragmentActivity);
        this.A.a(fragmentActivity);
        return a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, d(fragmentActivity));
    }

    @NonNull
    public com.bumptech.glide.i a(@NonNull Fragment fragment) {
        com.bumptech.glide.util.k.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.l.d()) {
            return a(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.A.a(fragment.getActivity());
        }
        return a(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.i a(@NonNull Activity activity) {
        if (com.bumptech.glide.util.l.d()) {
            return a(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return a((FragmentActivity) activity);
        }
        c(activity);
        this.A.a(activity);
        return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    @NonNull
    public com.bumptech.glide.i a(@NonNull View view) {
        if (com.bumptech.glide.util.l.d()) {
            return a(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.util.k.a(view);
        com.bumptech.glide.util.k.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return a(view.getContext().getApplicationContext());
        }
        if (activityB instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activityB;
            Fragment fragmentA = a(view, fragmentActivity);
            return fragmentA != null ? a(fragmentA) : a(fragmentActivity);
        }
        android.app.Fragment fragmentA2 = a(view, activityB);
        if (fragmentA2 == null) {
            return a(activityB);
        }
        return a(fragmentA2);
    }

    private static void a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    private Fragment a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f13396x.clear();
        a(fragmentActivity.getSupportFragmentManager().getFragments(), this.f13396x);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f13396x.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f13396x.clear();
        return fragment;
    }

    @Nullable
    @Deprecated
    private android.app.Fragment a(@NonNull View view, @NonNull Activity activity) {
        this.f13397y.clear();
        a(activity.getFragmentManager(), this.f13397y);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f13397y.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f13397y.clear();
        return fragment;
    }

    @TargetApi(26)
    @Deprecated
    private void a(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    a(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        b(fragmentManager, arrayMap);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.i a(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!com.bumptech.glide.util.l.d() && Build.VERSION.SDK_INT >= 17) {
                if (fragment.getActivity() != null) {
                    this.A.a(fragment.getActivity());
                }
                return a(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return a(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    private o a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment) {
        o oVar = this.f13392t.get(fragmentManager);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = (o) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (oVar2 != null) {
            return oVar2;
        }
        o oVar3 = new o();
        oVar3.a(fragment);
        this.f13392t.put(fragmentManager, oVar3);
        fragmentManager.beginTransaction().add(oVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f13394v.obtainMessage(1, fragmentManager).sendToTarget();
        return oVar3;
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.i a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z2) {
        o oVarA = a(fragmentManager, fragment);
        com.bumptech.glide.i iVarC = oVarA.c();
        if (iVarC == null) {
            iVarC = this.f13395w.a(com.bumptech.glide.c.a(context), oVarA.b(), oVarA.d(), context);
            if (z2) {
                iVarC.onStart();
            }
            oVarA.a(iVarC);
        }
        return iVarC;
    }

    @NonNull
    t a(androidx.fragment.app.FragmentManager fragmentManager) {
        return a(fragmentManager, (Fragment) null);
    }

    @NonNull
    private t a(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment) {
        t tVar = this.f13393u.get(fragmentManager);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = (t) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (tVar2 != null) {
            return tVar2;
        }
        t tVar3 = new t();
        tVar3.a(fragment);
        this.f13393u.put(fragmentManager, tVar3);
        fragmentManager.beginTransaction().add(tVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f13394v.obtainMessage(2, fragmentManager).sendToTarget();
        return tVar3;
    }

    @NonNull
    private com.bumptech.glide.i a(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z2) {
        t tVarA = a(fragmentManager, fragment);
        com.bumptech.glide.i iVarH = tVarA.h();
        if (iVarH == null) {
            iVarH = this.f13395w.a(com.bumptech.glide.c.a(context), tVarA.g(), tVarA.i(), context);
            if (z2) {
                iVarH.onStart();
            }
            tVarA.a(iVarH);
        }
        return iVarH;
    }

    private boolean a(FragmentManager fragmentManager, boolean z2) {
        o oVar = this.f13392t.get(fragmentManager);
        o oVar2 = (o) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (oVar2 == oVar) {
            return true;
        }
        if (oVar2 != null && oVar2.c() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + oVar2 + " New: " + oVar);
        }
        if (!z2 && !fragmentManager.isDestroyed()) {
            FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(oVar, "com.bumptech.glide.manager");
            if (oVar2 != null) {
                fragmentTransactionAdd.remove(oVar2);
            }
            fragmentTransactionAdd.commitAllowingStateLoss();
            this.f13394v.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
            Log.isLoggable("RMRetriever", 3);
            return false;
        }
        if (Log.isLoggable("RMRetriever", 5)) {
            fragmentManager.isDestroyed();
        }
        oVar.b().a();
        return true;
    }

    private boolean a(androidx.fragment.app.FragmentManager fragmentManager, boolean z2) {
        t tVar = this.f13393u.get(fragmentManager);
        t tVar2 = (t) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (tVar2 == tVar) {
            return true;
        }
        if (tVar2 != null && tVar2.h() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + tVar2 + " New: " + tVar);
        }
        if (!z2 && !fragmentManager.isDestroyed()) {
            androidx.fragment.app.FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(tVar, "com.bumptech.glide.manager");
            if (tVar2 != null) {
                fragmentTransactionAdd.remove(tVar2);
            }
            fragmentTransactionAdd.commitNowAllowingStateLoss();
            this.f13394v.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
            Log.isLoggable("RMRetriever", 3);
            return false;
        }
        if (fragmentManager.isDestroyed()) {
            Log.isLoggable("RMRetriever", 5);
        } else {
            Log.isLoggable("RMRetriever", 6);
        }
        tVar.g().a();
        return true;
    }
}
