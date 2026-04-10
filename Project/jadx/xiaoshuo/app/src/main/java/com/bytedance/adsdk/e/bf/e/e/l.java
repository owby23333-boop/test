package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends w {
    private static final ThreadLocal<StringBuilder> tg = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.e.bf.e.e.l.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public l() {
        super(com.bytedance.adsdk.e.bf.d.bf.PLUS);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        Object objE2 = this.e.e(map);
        if (objE2 == null || (objE = this.bf.e(map)) == null) {
            return null;
        }
        if (!(objE2 instanceof String) && !(objE instanceof String)) {
            return com.bytedance.adsdk.e.bf.tg.e.v.e((Number) objE2, (Number) objE);
        }
        StringBuilder sb = tg.get();
        sb.append(objE2);
        sb.append(objE);
        String string = sb.toString();
        sb.setLength(0);
        return string;
    }
}
