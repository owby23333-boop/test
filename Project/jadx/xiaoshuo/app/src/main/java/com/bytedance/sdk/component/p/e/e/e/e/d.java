package com.bytedance.sdk.component.p.e.e.e.e;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private final Context e;
    protected final List<com.bytedance.sdk.component.p.e.tg.e> bf = new ArrayList();
    private boolean d = false;
    private Runnable tg = new Runnable() { // from class: com.bytedance.sdk.component.p.e.e.e.e.d.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                ArrayList arrayList = new ArrayList(d.this.bf);
                d.this.bf.clear();
                d.this.d(arrayList);
                d.this.d = false;
            }
        }
    };

    public d(Context context) {
        this.e = context;
    }

    public abstract String bf();

    public void bf(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.p.e.tg.e> it = this.bf.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.p.e.tg.e next = it.next();
                if (next != null) {
                    String strD = next.d();
                    if (!TextUtils.isEmpty(strD) && list.contains(strD)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.p.e.d.d.bf("DBInsertMemRepo", bf() + "deleteMemList: " + th.getMessage());
        }
    }

    public void d(List<com.bytedance.sdk.component.p.e.tg.e> list) {
        com.bytedance.sdk.component.p.e.e.e.d.insert(getContext(), bf(), list);
    }

    public Context getContext() {
        return this.e;
    }

    private void e() {
        if (this.d) {
            return;
        }
        com.bytedance.sdk.component.p.e.p.e.e().postDelayed(this.tg, com.bytedance.sdk.component.p.e.p.e.bf());
        this.d = true;
    }

    public synchronized void e(com.bytedance.sdk.component.p.e.tg.e eVar) {
        if (eVar.p() != null && !TextUtils.isEmpty(eVar.d())) {
            this.bf.add(eVar);
            e();
        }
    }
}
