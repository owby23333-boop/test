package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bh extends w {
    public bh() {
        super(com.bytedance.adsdk.e.bf.d.bf.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE = this.e.e(map);
        Object objE2 = this.bf.e(map);
        return (objE == null && objE2 == null) ? Boolean.FALSE : (objE != null || objE2 == null) ? (objE == null || objE2 != null) ? ((objE instanceof Number) && (objE2 instanceof Number)) ? Boolean.valueOf(!com.bytedance.adsdk.e.bf.tg.e.bf.e((Number) objE, (Number) objE2)) : Boolean.valueOf(!objE.equals(objE2)) : Boolean.TRUE : Boolean.TRUE;
    }
}
