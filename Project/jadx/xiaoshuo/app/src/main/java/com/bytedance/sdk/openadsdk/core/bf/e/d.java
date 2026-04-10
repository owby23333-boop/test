package com.bytedance.sdk.openadsdk.core.bf.e;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.dt.zk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    private zk d;
    private View tg;
    private List<e> e = new ArrayList();
    private Map<String, Object> bf = new HashMap();

    public void e() {
        for (e eVar : this.e) {
            eVar.e(this.tg);
            if (eVar.e(this.bf)) {
                return;
            }
        }
    }

    public void e(View view) {
        this.tg = view;
    }

    public void e(e eVar) {
        this.e.add(eVar);
    }

    public void e(zk zkVar) {
        this.d = zkVar;
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().e(this.d);
        }
    }
}
