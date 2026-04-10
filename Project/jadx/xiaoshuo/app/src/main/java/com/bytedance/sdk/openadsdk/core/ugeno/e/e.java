package com.bytedance.sdk.openadsdk.core.ugeno.e;

import com.bytedance.adsdk.ugeno.bf.s;
import com.bytedance.sdk.component.adexpress.bf.xu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e extends xu {
    private s bf;
    private float d;
    private JSONObject e;
    private float tg;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.e.e$e, reason: collision with other inner class name */
    public static class C0155e extends xu.e {
        private s bf;
        private float d;
        private JSONObject e;
        private float tg;

        public C0155e bf(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public C0155e bf(float f) {
            this.tg = f;
            return this;
        }

        public C0155e e(s sVar) {
            this.bf = sVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.bf.xu.e
        /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
        public e e() {
            return new e(this);
        }

        public C0155e e(float f) {
            this.d = f;
            return this;
        }
    }

    public e(C0155e c0155e) {
        super(c0155e);
        this.e = c0155e.e;
        this.bf = c0155e.bf;
        this.d = c0155e.d;
        this.tg = c0155e.tg;
    }

    public JSONObject dt() {
        return this.e;
    }

    public float f() {
        return this.d;
    }

    public float k() {
        return this.tg;
    }

    public s pe() {
        return this.bf;
    }
}
