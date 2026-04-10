package com.yuewen;

import android.text.TextUtils;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes12.dex */
public class fc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<f> f11094a = new PriorityQueue<>(1, new a());

    public class a implements Comparator<f> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            int i = fVar.f11105b;
            int i2 = fVar2.f11105b;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }
    }

    public class b implements t41<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11096a;

        public b(String str) {
            this.f11096a = str;
        }

        @Override // com.yuewen.t41
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar) {
            return !TextUtils.isEmpty(fVar.f11104a) && fVar.f11104a.equals(this.f11096a);
        }
    }

    public class c implements t41<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11098a;

        public c(Runnable runnable) {
            this.f11098a = runnable;
        }

        @Override // com.yuewen.t41
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar) {
            return fVar.c == this.f11098a;
        }
    }

    public class d implements t41<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11100a;

        public d(Runnable runnable) {
            this.f11100a = runnable;
        }

        @Override // com.yuewen.t41
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar) {
            return fVar.c == this.f11100a;
        }
    }

    public class e implements t41<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f11102a;

        public e(f fVar) {
            this.f11102a = fVar;
        }

        @Override // com.yuewen.t41
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean a(f fVar) {
            f fVar2 = this.f11102a;
            if (fVar2.c == fVar.c) {
                return true;
            }
            if (TextUtils.isEmpty(fVar2.f11104a) || TextUtils.isEmpty(fVar.f11104a)) {
                return false;
            }
            return this.f11102a.f11104a.equals(fVar.f11104a);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11105b;
        public final Runnable c;

        public f(String str, int i, Runnable runnable) {
            this.f11104a = str;
            this.f11105b = i;
            this.c = runnable;
        }
    }

    public final void a(f fVar) {
        jh0.b(this.f11094a, new e(fVar));
        this.f11094a.offer(fVar);
    }

    public void b(Runnable runnable) {
        d("", runnable);
    }

    public void c(String str, int i, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a(new f(str, i, runnable));
    }

    public void d(String str, Runnable runnable) {
        c(str, -1, runnable);
    }

    public void e(Runnable runnable) {
        c("", Integer.MAX_VALUE, runnable);
    }

    public void f(String str, Runnable runnable) {
        c(str, Integer.MAX_VALUE, runnable);
    }

    public void g(Runnable runnable) {
        c("", -1, runnable);
    }

    public void h(String str, Runnable runnable) {
        c(str, -1, runnable);
    }

    public void i() {
        this.f11094a.clear();
    }

    public boolean j(Runnable runnable) {
        return ((f) jh0.c(this.f11094a, new d(runnable))) != null;
    }

    public void k(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        jh0.b(this.f11094a, new c(runnable));
    }

    public void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        jh0.b(this.f11094a, new b(str));
    }

    public void m() {
        while (!this.f11094a.isEmpty()) {
            this.f11094a.peek().c.run();
            this.f11094a.poll();
        }
    }
}
