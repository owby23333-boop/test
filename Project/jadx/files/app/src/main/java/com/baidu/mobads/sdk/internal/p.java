package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.z;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static volatile p a;
    private List<z.a> b = new CopyOnWriteArrayList();

    private p() {
    }

    public static p a() {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }

    private void b(z.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(z.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i2) {
        for (z.a aVar : this.b) {
            if (i2 == 1) {
                aVar.onSuccess();
            } else if (i2 == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
