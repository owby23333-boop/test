package com.bytedance.sdk.component.kb.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.kb.a.a;
import com.bytedance.sdk.component.kb.a.dl;
import com.bytedance.sdk.component.kb.a.gc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl f756a;
    private Map<String, Object> dl;
    private JSONObject g;
    private com.bytedance.sdk.component.kb.z.z gc;
    private int m;
    private String z;

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f757a;
        private StringBuilder dl;
        private JSONObject e;
        private String g;
        private Map<String, Object> gc;
        private dl m;
        private int z = 1;

        public z(String str) {
            this.g = str;
        }

        public z z(JSONObject jSONObject) {
            this.f757a = jSONObject;
            return this;
        }

        public z z(Map<String, Object> map) {
            this.gc = map;
            return this;
        }

        public z z(dl dlVar) {
            this.m = dlVar;
            return this;
        }

        public z g(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public g z() {
            return new g(this);
        }
    }

    private g(z zVar) {
        this.m = 1;
        this.m = zVar.z;
        if (zVar.z != 2) {
            this.z = zVar.g;
            if (zVar.e != null) {
                com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(zVar.e);
            }
        } else {
            this.gc = new com.bytedance.sdk.component.kb.z.z(zVar.dl, zVar.f757a, (Map<String, Object>) zVar.gc);
            this.m = 2;
        }
        this.g = zVar.f757a;
        this.dl = zVar.gc;
        this.f756a = zVar.m;
    }

    public void z() {
        com.bytedance.sdk.component.kb.dl.dl dlVarZ;
        if (this.m == 2) {
            dl dlVar = this.f756a;
            if (dlVar != null) {
                dlVar.z(this.gc);
            }
            this.gc.m();
            return;
        }
        if (TextUtils.isEmpty(this.z) || (dlVarZ = com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(this.z)) == null) {
            return;
        }
        z(dlVarZ.z(), this.dl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.kb.dl.z zVar, Map<String, Object> map) {
        if (zVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.kb.z.z zVar2 = new com.bytedance.sdk.component.kb.z.z(zVar, this.g, map);
        zVar2.z(this.z);
        zVar2.z(this);
        dl dlVar = this.f756a;
        if (dlVar != null) {
            dlVar.z(zVar2);
        }
        zVar2.m();
        for (com.bytedance.sdk.component.kb.dl.z zVar3 : com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(this.z).dl(zVar, zVar2.dl(), map)) {
            if (zVar3 != null) {
                z(zVar3, map);
            }
        }
    }

    @Override // com.bytedance.sdk.component.kb.a.a
    public gc g() {
        return new gc() { // from class: com.bytedance.sdk.component.kb.z.g.1
            @Override // com.bytedance.sdk.component.kb.a.gc
            public void z(com.bytedance.sdk.component.kb.z.z zVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.kb.dl.z> it = com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(g.this.z).z(zVar.e(), zVar.dl(), map).iterator();
                while (it.hasNext()) {
                    g.this.z(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.kb.a.gc
            public void g(com.bytedance.sdk.component.kb.z.z zVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.kb.dl.z> it = com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(g.this.z).g(zVar.e(), zVar.dl(), map).iterator();
                while (it.hasNext()) {
                    g.this.z(it.next(), map);
                }
            }
        };
    }
}
