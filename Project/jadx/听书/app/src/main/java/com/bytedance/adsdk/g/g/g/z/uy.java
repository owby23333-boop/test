package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements com.bytedance.adsdk.g.g.g.z {
    private com.bytedance.adsdk.g.g.z.z dl;
    private String g;
    private com.bytedance.adsdk.g.g.g.z[] z;

    public uy(String str) {
        this.g = str;
    }

    public void z(com.bytedance.adsdk.g.g.g.z[] zVarArr) {
        this.z = zVarArr;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        com.bytedance.adsdk.g.g.z.z zVar = new com.bytedance.adsdk.g.g.z.z();
        this.dl = zVar;
        zVar.z(this.g);
        Object[] objArr = new Object[this.z.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.g.g.g.z[] zVarArr = this.z;
            if (i < zVarArr.length) {
                com.bytedance.adsdk.g.g.g.z zVar2 = zVarArr[i];
                if (zVar2 != null) {
                    objArr[i] = zVar2.z(map);
                }
                i++;
            } else {
                this.dl.z(objArr);
                return com.bytedance.adsdk.g.kb.z(this.g).z(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.g.METHOD;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.g).append("(");
        com.bytedance.adsdk.g.g.g.z[] zVarArr = this.z;
        if (zVarArr != null && zVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.g.g.g.z[] zVarArr2 = this.z;
                if (i >= zVarArr2.length) {
                    break;
                }
                sb.append(zVarArr2[i].g()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
