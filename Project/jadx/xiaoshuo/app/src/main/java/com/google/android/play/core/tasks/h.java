package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes7.dex */
final class h<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f7007a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<g<TResult>> f7008b;
    private boolean c;

    public final void a(Task<TResult> task) {
        g<TResult> gVarPoll;
        synchronized (this.f7007a) {
            if (this.f7008b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.f7007a) {
                        gVarPoll = this.f7008b.poll();
                        if (gVarPoll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    gVarPoll.a(task);
                }
            }
        }
    }

    public final void a(g<TResult> gVar) {
        synchronized (this.f7007a) {
            if (this.f7008b == null) {
                this.f7008b = new ArrayDeque();
            }
            this.f7008b.add(gVar);
        }
    }
}
