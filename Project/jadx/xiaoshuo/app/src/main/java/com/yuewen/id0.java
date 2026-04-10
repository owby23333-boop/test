package com.yuewen;

import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes12.dex */
public class id0 implements xl3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final id0 f12457b = new id0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<gd0> f12458a = new ConcurrentLinkedQueue<>();

    public static id0 b() {
        return f12457b;
    }

    public final void c(@NonNull gd0 gd0Var) {
        this.f12458a.offer(gd0Var);
        if (this.f12458a.peek() == gd0Var) {
            gd0Var.b();
        }
    }

    public final void d() {
        this.f12458a.poll();
        gd0 gd0VarPeek = this.f12458a.peek();
        if (gd0VarPeek != null) {
            gd0VarPeek.b();
        }
    }

    public <T> void e(@NonNull gd0<T> gd0Var) {
        c(gd0Var);
        gd0Var.a(new ed0() { // from class: com.yuewen.hd0
            @Override // com.yuewen.ed0
            public final void onDismiss() {
                this.f12002a.d();
            }
        });
    }
}
