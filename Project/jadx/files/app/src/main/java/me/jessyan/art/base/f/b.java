package me.jessyan.art.base.f;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: ActivityDelegateImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    private Activity a;
    private h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private me.jessyan.art.mvp.c f21151c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NonNull Activity activity) {
        this.a = activity;
        this.b = (h) activity;
    }

    @Override // me.jessyan.art.base.f.a
    public void onCreate(@Nullable Bundle bundle) {
        me.jessyan.art.mvp.c cVar;
        if (this.b.useEventBus()) {
            me.jessyan.art.d.f.a().a(this.a);
        }
        this.f21151c = this.b.obtainPresenter();
        this.b.setPresenter(this.f21151c);
        ComponentCallbacks2 componentCallbacks2 = this.a;
        if (componentCallbacks2 == null || !(componentCallbacks2 instanceof LifecycleOwner) || (cVar = this.f21151c) == null || !(cVar instanceof LifecycleObserver)) {
            return;
        }
        ((LifecycleOwner) componentCallbacks2).getLifecycle().addObserver((LifecycleObserver) this.f21151c);
    }

    @Override // me.jessyan.art.base.f.a
    public void onDestroy() {
        h hVar = this.b;
        if (hVar != null && hVar.useEventBus()) {
            me.jessyan.art.d.f.a().b(this.a);
        }
        me.jessyan.art.mvp.c cVar = this.f21151c;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.b = null;
        this.a = null;
        this.f21151c = null;
    }

    @Override // me.jessyan.art.base.f.a
    public void onPause() {
    }

    @Override // me.jessyan.art.base.f.a
    public void onResume() {
    }

    @Override // me.jessyan.art.base.f.a
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @Override // me.jessyan.art.base.f.a
    public void onStart() {
    }

    @Override // me.jessyan.art.base.f.a
    public void onStop() {
    }
}
