package com.bumptech.glide.l;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RequestManagerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class o extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.l.a f13385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final q f13386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Set<o> f13387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.i f13388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private o f13389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private Fragment f13390x;

    /* JADX INFO: compiled from: RequestManagerFragment.java */
    private class a implements q {
        a() {
        }

        @Override // com.bumptech.glide.l.q
        @NonNull
        public Set<com.bumptech.glide.i> a() {
            Set<o> setA = o.this.a();
            HashSet hashSet = new HashSet(setA.size());
            for (o oVar : setA) {
                if (oVar.c() != null) {
                    hashSet.add(oVar.c());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new com.bumptech.glide.l.a());
    }

    @Nullable
    @TargetApi(17)
    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f13390x;
    }

    private void f() {
        o oVar = this.f13389w;
        if (oVar != null) {
            oVar.b(this);
            this.f13389w = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.i iVar) {
        this.f13388v = iVar;
    }

    @NonNull
    com.bumptech.glide.l.a b() {
        return this.f13385s;
    }

    @Nullable
    public com.bumptech.glide.i c() {
        return this.f13388v;
    }

    @NonNull
    public q d() {
        return this.f13386t;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13385s.a();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f13385s.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f13385s.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    o(@NonNull com.bumptech.glide.l.a aVar) {
        this.f13386t = new a();
        this.f13387u = new HashSet();
        this.f13385s = aVar;
    }

    private void a(o oVar) {
        this.f13387u.add(oVar);
    }

    private void b(o oVar) {
        this.f13387u.remove(oVar);
    }

    @TargetApi(17)
    private boolean b(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @NonNull
    @TargetApi(17)
    Set<o> a() {
        if (equals(this.f13389w)) {
            return Collections.unmodifiableSet(this.f13387u);
        }
        if (this.f13389w != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (o oVar : this.f13389w.a()) {
                if (b(oVar.getParentFragment())) {
                    hashSet.add(oVar);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    void a(@Nullable Fragment fragment) {
        this.f13390x = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(@NonNull Activity activity) {
        f();
        this.f13389w = com.bumptech.glide.c.a((Context) activity).h().b(activity);
        if (equals(this.f13389w)) {
            return;
        }
        this.f13389w.a(this);
    }
}
