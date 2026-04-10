package com.bytedance.adsdk.ugeno.gc;

import com.bytedance.adsdk.ugeno.gc.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements dl {
    @Override // com.bytedance.adsdk.ugeno.gc.dl
    public List<g> z() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g("update") { // from class: com.bytedance.adsdk.ugeno.gc.gc.1
            @Override // com.bytedance.adsdk.ugeno.gc.g
            public com.bytedance.adsdk.ugeno.gc.g.z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
                return new com.bytedance.adsdk.ugeno.gc.g.gc(dlVar, str, zVar);
            }
        });
        arrayList.add(new g("emit") { // from class: com.bytedance.adsdk.ugeno.gc.gc.2
            @Override // com.bytedance.adsdk.ugeno.gc.g
            public com.bytedance.adsdk.ugeno.gc.g.z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
                return new com.bytedance.adsdk.ugeno.gc.g.g(dlVar, str, zVar);
            }
        });
        arrayList.add(new g("startAnimate") { // from class: com.bytedance.adsdk.ugeno.gc.gc.3
            @Override // com.bytedance.adsdk.ugeno.gc.g
            public com.bytedance.adsdk.ugeno.gc.g.z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
                return new com.bytedance.adsdk.ugeno.gc.g.a(dlVar, str, zVar);
            }
        });
        return arrayList;
    }
}
