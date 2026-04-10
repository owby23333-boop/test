package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes12.dex */
public class do1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f10245a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10246b;
    public a c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f10247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f10248b;

        public a(Runnable runnable) {
            this.f10247a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f10247a;
            if (runnable != null) {
                runnable.run();
            } else {
                ia0.w().s(this.f10248b == null);
            }
            if (this.f10248b != null) {
                do1.this.f10245a.postDelayed(this.f10248b, do1.this.f10246b);
            } else {
                do1.this.c = null;
            }
        }
    }

    public do1(int i) {
        this.f10246b = i;
    }

    public void d() {
        if (this.c != null) {
            this.f10245a.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    public void e(@NonNull Runnable runnable) {
        a aVar = this.c;
        if (aVar == null) {
            runnable.run();
            a aVar2 = new a(null);
            this.c = aVar2;
            this.f10245a.postDelayed(aVar2, this.f10246b);
            return;
        }
        if (aVar.f10247a == null) {
            aVar.f10247a = runnable;
            runnable = null;
        }
        a aVar3 = new a(runnable);
        this.c.f10248b = aVar3;
        this.c = aVar3;
    }
}
