package com.bytedance.sdk.openadsdk.core.gc;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.gc.z;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.openadsdk.core.gc.g;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.me;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.nativeexpress.iq;
import com.bytedance.sdk.openadsdk.core.nativeexpress.q;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g<List<v>> {
    private final int dl;
    List<Long> g;

    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    protected /* bridge */ /* synthetic */ void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List list, List<v> list2) {
        z2(gVar, (List<na>) list, list2);
    }

    public dl(com.bytedance.sdk.openadsdk.core.gc.gc.g gVar, int i) {
        super(gVar);
        this.g = new CopyOnWriteArrayList();
        this.dl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final List<na> list, final g.z<List<v>> zVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.g.add(Long.valueOf(jCurrentTimeMillis));
        final int[] iArr = {0};
        final int[] iArr2 = {list.size()};
        if (zw.g().oc() > 0) {
            gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        if (dl.this.g.contains(Long.valueOf(jCurrentTimeMillis))) {
                            dl.this.g.remove(Long.valueOf(jCurrentTimeMillis));
                            dl.this.g(gVar, list, zVar);
                        }
                    }
                }
            }, zw.g().oc());
        }
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            final long j = jCurrentTimeMillis;
            z(it.next(), new com.bytedance.sdk.openadsdk.core.ugeno.dl() { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
                public void z(String str) {
                    synchronized (this) {
                        int[] iArr3 = iArr;
                        int i = iArr3[0] + 1;
                        iArr3[0] = i;
                        dl.this.z(j, gVar, (List<na>) list, (g.z<List<v>>) zVar, i, iArr2[0]);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
                public void z() {
                    synchronized (this) {
                        int[] iArr3 = iArr2;
                        int i = iArr3[0] - 1;
                        iArr3[0] = i;
                        dl.this.z(j, gVar, (List<na>) list, (g.z<List<v>>) zVar, iArr[0], i);
                    }
                }
            });
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, g.z<List<v>> zVar, int i, int i2) {
        if (this.g.contains(Long.valueOf(j))) {
            if (zw.g().ou() != 1 || i == i2) {
                this.g.remove(Long.valueOf(j));
                g(gVar, list, zVar);
            }
        }
    }

    private void z(na naVar, com.bytedance.sdk.openadsdk.core.ugeno.dl dlVar) {
        if (vm.kb(naVar)) {
            com.bytedance.sdk.openadsdk.core.wp.z.z(naVar, dlVar);
            return;
        }
        if (vm.uy(naVar)) {
            me meVarM = vm.m(naVar);
            if (meVarM != null) {
                uy.z(meVarM.fo(), meVarM.uy(), dlVar);
                return;
            }
            return;
        }
        dlVar.z(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, g.z<List<v>> zVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            v vVarZ = z(gVar, it.next());
            if (vVarZ != null) {
                arrayList.add(vVarZ);
            }
        }
        if (zVar != null) {
            zVar.z(arrayList);
        }
    }

    /* JADX INFO: renamed from: z, reason: avoid collision after fix types in other method */
    protected void z2(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, List<v> list2) {
        for (int i = 0; i < list2.size(); i++) {
            v vVar = list2.get(i);
            na naVar = list.get(i);
            if (this.z != null) {
                this.z.z().z(gVar, naVar, vVar, false);
            }
        }
    }

    private v z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
        boolean z = tf.v(naVar) != null;
        int i = this.dl;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.dl(zw.getContext(), naVar, gVar);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.g(zw.getContext(), naVar, gVar);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new iq(zw.getContext(), naVar, gVar);
        }
        if (z) {
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.zw(zw.getContext(), naVar, gVar);
        }
        return new q(zw.getContext(), naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
        int i2;
        if (naVar == null) {
            return;
        }
        String strGc = (gVar == null || !((i2 = this.dl) == 3 || i2 == 4)) ? null : fo.gc();
        com.bytedance.sdk.openadsdk.core.video.dl.z.g(naVar);
        if (naVar.ts() && naVar.jz() != null && !naVar.jz().isEmpty()) {
            for (gk gkVar : naVar.jz()) {
                if (!TextUtils.isEmpty(gkVar.z())) {
                    com.bytedance.sdk.openadsdk.core.io.gc.z().dl().z(new com.bytedance.sdk.openadsdk.i.g(gkVar.z(), gkVar.e()), com.bytedance.sdk.openadsdk.core.io.z.z.g(), gkVar.g(), gkVar.dl(), strGc);
                }
            }
        }
        if (TextUtils.isEmpty(tf.z(naVar))) {
            return;
        }
        if (zw.g().a(String.valueOf(eo.fo(naVar))) && zw.g().bp()) {
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, naVar);
            aVarZ.z("material_meta", naVar);
            aVarZ.z("ad_slot", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, (z.InterfaceC0028z) null);
        }
    }
}
