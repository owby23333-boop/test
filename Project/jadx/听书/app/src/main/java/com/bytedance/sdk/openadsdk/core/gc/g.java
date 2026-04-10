package com.bytedance.sdk.openadsdk.core.gc;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.gc.z;
import com.bytedance.sdk.openadsdk.core.gc.gc.e;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.uy;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<V> extends com.bytedance.sdk.openadsdk.core.gc.z.z<V> {
    protected com.bytedance.sdk.openadsdk.core.gc.gc.g z;

    public interface z<V> {
        void z(V v);
    }

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, z<V> zVar);

    protected abstract void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, V v);

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
        return true;
    }

    public g(com.bytedance.sdk.openadsdk.core.gc.gc.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
        gVar2.z(i);
        com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar, j jVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar2, com.bytedance.sdk.openadsdk.core.gc.gc.gc<V> gcVar, e eVar) {
        if (zVar.g() == null || zVar.g().isEmpty()) {
            if (eVar != null) {
                eVar.z(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (zVar.g().size() > 1 && gz.z(i).z("mix_ad", gVar2, zVar.g().get(0))) {
            com.bytedance.sdk.openadsdk.core.z.z(zVar.g());
            arrayList.add(zVar.g().get(0));
        } else {
            arrayList.addAll(zVar.g());
        }
        for (na naVar : arrayList) {
            if (naVar.ts()) {
                if (naVar.bp() <= 0) {
                    naVar.gc((System.currentTimeMillis() + 10500000) / 1000);
                }
                z(i, gVar2, naVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (eVar != null) {
                eVar.z(-4);
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(d.p, jVar.gz);
            z(i, arrayList, gVar2, gcVar, bundle, eVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(final int i, final List<na> list, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.core.gc.gc.gc<V> gcVar, final Bundle bundle, final e eVar) {
        z(gVar, list, (z) new z<V>() { // from class: com.bytedance.sdk.openadsdk.core.gc.g.1
            @Override // com.bytedance.sdk.openadsdk.core.gc.g.z
            public void z(V v) {
                com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVarZ = g.this.z(i, gVar, v, (List<na>) list, bundle, gcVar);
                e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.z(dlVarZ);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.gc.gc.dl z(final int i, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final V v, final List<na> list, Bundle bundle, final com.bytedance.sdk.openadsdk.core.gc.gc.gc<V> gcVar) {
        final long j = bundle.getLong(d.p);
        final boolean z2 = bundle.getBoolean("is_cache");
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            it.next().ac().g();
        }
        final na naVar = list.get(0);
        return new com.bytedance.sdk.openadsdk.core.gc.gc.dl() { // from class: com.bytedance.sdk.openadsdk.core.gc.g.2
            private final AtomicBoolean uy = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
            public void g() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
            public void z() {
                g.this.z(gVar, (List<na>) list, v);
                com.bytedance.sdk.openadsdk.core.i.a.g(naVar, eo.g(i), j);
                com.bytedance.sdk.openadsdk.core.gc.gc.gc gcVar2 = gcVar;
                if (gcVar2 != null) {
                    gcVar2.z(v);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
            public void dl() {
                if (this.uy.compareAndSet(false, true)) {
                    g.this.z(z2, gVar, list);
                }
            }
        };
    }

    protected void z(boolean z2, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
        if (z2) {
            com.bytedance.sdk.openadsdk.core.gc.gc.g gVar2 = this.z;
            if (gVar2 != null) {
                gVar2.z().g(gVar, list);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.gc.gc.g gVar3 = this.z;
        if (gVar3 != null) {
            gVar3.z().z(gVar, list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
        if ((!na.z(naVar) || uy.z(naVar)) && !TextUtils.isEmpty(tf.z(naVar))) {
            if (zw.g().a(String.valueOf(eo.fo(naVar))) && zw.g().bp()) {
                if (tf.v(naVar) != null) {
                    tf.v(naVar).gc(1);
                }
                if (tf.pf(naVar) != null) {
                    tf.pf(naVar).gc(1);
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, naVar);
                aVarZ.z("material_meta", naVar);
                aVarZ.z("ad_slot", Integer.valueOf(i));
                com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, (z.InterfaceC0028z) null);
            }
        }
    }
}
