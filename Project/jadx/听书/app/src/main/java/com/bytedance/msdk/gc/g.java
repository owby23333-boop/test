package com.bytedance.msdk.gc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;
    private List<z> g = new CopyOnWriteArrayList();

    public static class z {
        private JSONObject g;
        private a z;

        public z(a aVar, JSONObject jSONObject) {
            this.z = aVar;
            this.g = jSONObject;
        }

        public a z() {
            return this.z;
        }

        public JSONObject g() {
            return this.g;
        }
    }

    private g() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public List<z> g() {
        return this.g;
    }

    public void z(a aVar, JSONObject jSONObject) {
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 保存到埋点辅助模块");
        this.g.add(new z(aVar, jSONObject));
    }

    public void dl() {
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 清空埋点辅助模块");
        List<z> list = this.g;
        if (list != null) {
            list.clear();
        }
    }
}
