package com.bytedance.sdk.openadsdk.core.ugeno.express;

import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.sdk.component.adexpress.g.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1354a;
    private float dl;
    private iq g;
    private boolean gc;
    private JSONObject z;

    public g(z zVar) {
        super(zVar);
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f1354a = zVar.f1355a;
        this.gc = zVar.gc;
    }

    public float gk() {
        return this.dl;
    }

    public float x() {
        return this.f1354a;
    }

    public JSONObject lq() {
        return this.z;
    }

    public iq mc() {
        return this.g;
    }

    public boolean un() {
        return this.gc;
    }

    public static class z extends i.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1355a;
        private float dl;
        private iq g;
        private boolean gc;
        private JSONObject z;

        public z gc(JSONObject jSONObject) {
            this.z = jSONObject;
            return this;
        }

        public z z(iq iqVar) {
            this.g = iqVar;
            return this;
        }

        public z z(float f) {
            this.dl = f;
            return this;
        }

        public z g(float f) {
            this.f1355a = f;
            return this;
        }

        public z a(boolean z) {
            this.gc = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.g.i.z
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public g z() {
            return new g(this);
        }
    }
}
