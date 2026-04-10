package com.bytedance.adsdk.ugeno.gc;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z implements gz {
    @Override // com.bytedance.adsdk.ugeno.gc.gz
    public List<e> z() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e("slide") { // from class: com.bytedance.adsdk.ugeno.gc.z.1
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.a(context);
            }
        });
        arrayList.add(new e("tap") { // from class: com.bytedance.adsdk.ugeno.gc.z.2
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.gc(context);
            }
        });
        arrayList.add(new e("timer") { // from class: com.bytedance.adsdk.ugeno.gc.z.3
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.m(context);
            }
        });
        arrayList.add(new e("touchStart") { // from class: com.bytedance.adsdk.ugeno.gc.z.4
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.gz(context);
            }
        });
        arrayList.add(new e("touchEnd") { // from class: com.bytedance.adsdk.ugeno.gc.z.5
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.e(context);
            }
        });
        arrayList.add(new e("animateState") { // from class: com.bytedance.adsdk.ugeno.gc.z.6
            @Override // com.bytedance.adsdk.ugeno.gc.e
            public com.bytedance.adsdk.ugeno.gc.dl.g z(Context context) {
                return new com.bytedance.adsdk.ugeno.gc.dl.z(context);
            }
        });
        return arrayList;
    }
}
