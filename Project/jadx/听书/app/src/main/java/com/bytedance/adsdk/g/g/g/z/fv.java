package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fv extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f133a = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.g.g.g.z.fv.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public fv() {
        super(com.bytedance.adsdk.g.g.a.dl.PLUS);
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ;
        Object objZ2 = this.z.z(map);
        if (objZ2 == null || (objZ = this.g.z(map)) == null) {
            return null;
        }
        if ((objZ2 instanceof String) || (objZ instanceof String)) {
            StringBuilder sb = f133a.get();
            sb.append(objZ2).append(objZ);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.bytedance.adsdk.g.g.gc.z.gz.z((Number) objZ2, (Number) objZ);
    }
}
