package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<StateT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.google.android.play.core.splitcompat.b.b f6923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntentFilter f6924b;
    private final Context c;
    private final Set<StateUpdatedListener<StateT>> d = Collections.newSetFromMap(new ConcurrentHashMap());
    private final b e = new b(this, (byte) 0);

    public a(com.google.android.play.core.splitcompat.b.b bVar, IntentFilter intentFilter, Context context) {
        this.f6923a = bVar;
        this.f6924b = intentFilter;
        this.c = context;
    }

    public abstract void a(Intent intent);

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f6923a.a("registerListener", new Object[0]);
        this.d.add(stateUpdatedListener);
        if (this.d.size() == 1) {
            this.c.registerReceiver(this.e, this.f6924b);
        }
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f6923a.a("unregisterListener", new Object[0]);
        this.d.remove(stateUpdatedListener);
        if (this.d.isEmpty()) {
            this.c.unregisterReceiver(this.e);
        }
    }

    public final void a(StateT statet) {
        Iterator<StateUpdatedListener<StateT>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onStateUpdate(statet);
        }
    }
}
