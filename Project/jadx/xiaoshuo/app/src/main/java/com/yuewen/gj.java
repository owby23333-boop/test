package com.yuewen;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes12.dex */
public abstract class gj<T> implements mx2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f11573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f11574b;
    public gi1 c;

    public gj(ViewGroup viewGroup, gi1 gi1Var) {
        this.f11573a = viewGroup;
        this.f11574b = viewGroup.getContext();
        this.c = gi1Var;
    }

    public ImageView b() {
        return null;
    }

    public abstract void c(T t);

    public void d(boolean z) {
    }
}
