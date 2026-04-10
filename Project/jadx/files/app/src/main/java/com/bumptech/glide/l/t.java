package com.bumptech.glide.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SupportRequestManagerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.l.a f13409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final q f13410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Set<t> f13411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private t f13412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.i f13413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private Fragment f13414x;

    /* JADX INFO: compiled from: SupportRequestManagerFragment.java */
    private class a implements q {
        a() {
        }

        @Override // com.bumptech.glide.l.q
        @NonNull
        public Set<com.bumptech.glide.i> a() {
            Set<t> setF = t.this.f();
            HashSet hashSet = new HashSet(setF.size());
            for (t tVar : setF) {
                if (tVar.h() != null) {
                    hashSet.add(tVar.h());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + t.this + "}";
        }
    }

    public t() {
        this(new com.bumptech.glide.l.a());
    }

    private void b(t tVar) {
        this.f13411u.remove(tVar);
    }

    private boolean c(@NonNull Fragment fragment) {
        Fragment fragmentJ = j();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentJ)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private Fragment j() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f13414x;
    }

    private void k() {
        t tVar = this.f13412v;
        if (tVar != null) {
            tVar.b(this);
            this.f13412v = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.i iVar) {
        this.f13413w = iVar;
    }

    @NonNull
    Set<t> f() {
        t tVar = this.f13412v;
        if (tVar == null) {
            return Collections.emptySet();
        }
        if (equals(tVar)) {
            return Collections.unmodifiableSet(this.f13411u);
        }
        HashSet hashSet = new HashSet();
        for (t tVar2 : this.f13412v.f()) {
            if (c(tVar2.j())) {
                hashSet.add(tVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.l.a g() {
        return this.f13409s;
    }

    @Nullable
    public com.bumptech.glide.i h() {
        return this.f13413w;
    }

    @NonNull
    public q i() {
        return this.f13410t;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerB = b((Fragment) this);
        if (fragmentManagerB == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            a(getContext(), fragmentManagerB);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13409s.a();
        k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f13414x = null;
        k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f13409s.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f13409s.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + j() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public t(@NonNull com.bumptech.glide.l.a aVar) {
        this.f13410t = new a();
        this.f13411u = new HashSet();
        this.f13409s = aVar;
    }

    private void a(t tVar) {
        this.f13411u.add(tVar);
    }

    @Nullable
    private static FragmentManager b(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    void a(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerB;
        this.f13414x = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerB = b(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), fragmentManagerB);
    }

    private void a(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        k();
        this.f13412v = com.bumptech.glide.c.a(context).h().a(fragmentManager);
        if (equals(this.f13412v)) {
            return;
        }
        this.f13412v.a(this);
    }
}
