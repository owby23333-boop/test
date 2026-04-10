package com.bytedance.adsdk.e.bf.e.e;

import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.eq2;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p implements com.bytedance.adsdk.e.bf.e.e {
    private final Object e;

    public p(String str) {
        if (str.equalsIgnoreCase(a.c)) {
            this.e = Boolean.TRUE;
        } else if (str.equalsIgnoreCase(MscKeys.VAL_FALSE)) {
            this.e = Boolean.FALSE;
        } else {
            if (!str.equalsIgnoreCase(eq2.g)) {
                throw new IllegalArgumentException();
            }
            this.e = null;
        }
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        Object obj = this.e;
        return obj != null ? obj.toString() : "NULL";
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        return this.e;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.e + "]";
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return com.bytedance.adsdk.e.bf.d.ga.CONSTANT;
    }
}
