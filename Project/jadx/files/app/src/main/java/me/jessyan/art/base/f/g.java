package me.jessyan.art.base.f;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleObserver;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/* JADX INFO: compiled from: FragmentDelegateImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements f {
    private Fragment a;
    private i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Unbinder f21159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private me.jessyan.art.mvp.c f21160d;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        this.a = fragment;
        this.b = (i) fragment;
    }

    @Override // me.jessyan.art.base.f.f
    public void a(@Nullable View view, @Nullable Bundle bundle) {
        if (view != null) {
            this.f21159c = ButterKnife.bind(this.a, view);
        }
    }

    @Override // me.jessyan.art.base.f.f
    public boolean isAdded() {
        Fragment fragment = this.a;
        return fragment != null && fragment.isAdded();
    }

    @Override // me.jessyan.art.base.f.f
    public void onAttach(@NonNull Context context) {
    }

    @Override // me.jessyan.art.base.f.f
    public void onCreate(@Nullable Bundle bundle) {
        me.jessyan.art.mvp.c cVar;
        if (this.b.useEventBus()) {
            me.jessyan.art.d.f.a().a(this.a);
        }
        this.f21160d = this.b.obtainPresenter();
        this.b.setPresenter(this.f21160d);
        Fragment fragment = this.a;
        if (fragment == null || (cVar = this.f21160d) == null || !(cVar instanceof LifecycleObserver)) {
            return;
        }
        fragment.getLifecycle().addObserver((LifecycleObserver) this.f21160d);
    }

    @Override // me.jessyan.art.base.f.f
    public void onDestroy() {
        i iVar = this.b;
        if (iVar != null && iVar.useEventBus()) {
            me.jessyan.art.d.f.a().b(this.a);
        }
        me.jessyan.art.mvp.c cVar = this.f21160d;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.f21159c = null;
        this.a = null;
        this.b = null;
        this.f21160d = null;
    }

    @Override // me.jessyan.art.base.f.f
    public void onDestroyView() {
        Unbinder unbinder = this.f21159c;
        if (unbinder == null || unbinder == Unbinder.EMPTY) {
            return;
        }
        try {
            unbinder.unbind();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            y0.a.a.c("onDestroyView: " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // me.jessyan.art.base.f.f
    public void onDetach() {
    }

    @Override // me.jessyan.art.base.f.f
    public void onPause() {
    }

    @Override // me.jessyan.art.base.f.f
    public void onResume() {
    }

    @Override // me.jessyan.art.base.f.f
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @Override // me.jessyan.art.base.f.f
    public void onStart() {
    }

    @Override // me.jessyan.art.base.f.f
    public void onStop() {
    }

    @Override // me.jessyan.art.base.f.f
    public void a(@Nullable Bundle bundle) {
        this.b.initData(bundle);
    }
}
