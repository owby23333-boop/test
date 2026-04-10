package com.anythink.core.common;

import android.content.Context;
import android.os.CountDownTimer;
import com.anythink.core.common.e.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o<T extends com.anythink.core.common.e.q> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected CountDownTimer f7836c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f7838e;
    final String a = getClass().getSimpleName();
    ArrayList<T> b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f7837d = com.anythink.core.common.b.n.a().p();

    protected o(Context context) {
        this.f7838e = context.getApplicationContext();
    }

    protected abstract void a(List<T> list);

    public final synchronized void a(T t2, boolean z2) {
        boolean z3 = true;
        if (z2) {
            this.b.add(t2);
            a(true);
            return;
        }
        final com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.f7838e).b(this.f7837d);
        if (!this.b.isEmpty()) {
            z3 = false;
        } else if (aVarB.aa() > 0) {
            com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.o.1
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.f7836c = new CountDownTimer(aVarB.aa(), aVarB.aa()) { // from class: com.anythink.core.common.o.1.1
                        @Override // android.os.CountDownTimer
                        public final void onFinish() {
                            o.this.a(true);
                        }

                        @Override // android.os.CountDownTimer
                        public final void onTick(long j2) {
                        }
                    };
                    o.this.f7836c.start();
                }
            });
            z3 = false;
        }
        this.b.add(t2);
        a(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z2) {
        if (z2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.b);
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            this.b.clear();
        } else {
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.f7838e).b(this.f7837d);
            ArrayList arrayList2 = new ArrayList();
            if (this.b.size() >= aVarB.Y()) {
                for (int iY = aVarB.Y() - 1; iY >= 0; iY--) {
                    arrayList2.add(this.b.get(iY));
                    this.b.remove(iY);
                }
                if (arrayList2.size() > 0) {
                    a(arrayList2);
                }
            }
        }
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.o.2
            @Override // java.lang.Runnable
            public final void run() {
                CountDownTimer countDownTimer;
                if (!o.this.b.isEmpty() || (countDownTimer = o.this.f7836c) == null) {
                    return;
                }
                countDownTimer.cancel();
            }
        });
    }
}
