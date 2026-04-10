package me.jessyan.art.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import me.jessyan.art.mvp.b;

/* JADX INFO: loaded from: classes.dex */
public class BasePresenter<M extends b> implements c, LifecycleObserver {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected CompositeDisposable f21195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected M f21196t;

    public BasePresenter() {
        getClass().getSimpleName();
        a();
    }

    public void a() {
        if (c()) {
            me.jessyan.art.d.f.a().a(this);
        }
    }

    public void b() {
        CompositeDisposable compositeDisposable = this.f21195s;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public boolean c() {
        return true;
    }

    @Override // me.jessyan.art.mvp.c
    public void onDestroy() {
        if (c()) {
            me.jessyan.art.d.f.a().b(this);
        }
        b();
        M m2 = this.f21196t;
        if (m2 != null) {
            m2.onDestroy();
        }
        this.f21196t = null;
        this.f21195s = null;
    }

    public void a(Disposable disposable) {
        if (this.f21195s == null) {
            this.f21195s = new CompositeDisposable();
        }
        this.f21195s.add(disposable);
    }

    public BasePresenter(M m2) {
        getClass().getSimpleName();
        me.jessyan.art.f.g.a(m2, "%s cannot be null", b.class.getName());
        this.f21196t = m2;
        a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().removeObserver(this);
    }
}
