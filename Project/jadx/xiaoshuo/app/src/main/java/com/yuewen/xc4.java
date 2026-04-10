package com.yuewen;

import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.nh1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class xc4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19859a = "VideoRequestBuilder";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19860b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public Integer i;

    public nh1 a() {
        if (TextUtils.isEmpty(this.f19860b)) {
            return null;
        }
        try {
            nh1.a aVar = new nh1.a();
            HashMap map = new HashMap();
            map.put("_oaid", this.c);
            map.put("_devid", this.d);
            map.put("userId", this.e);
            map.put("num", this.f + "");
            map.put("ref", this.g);
            map.put("scene", this.h);
            map.put("_appver", this.i + "");
            aVar.o(b(this.f19860b, map));
            aVar.n("GET");
            return aVar.j();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String b(String str, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean z = !str.contains("?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                sb.append("?");
                z = false;
            } else {
                sb.append(com.alipay.sdk.m.w.a.p);
            }
            sb.append(entry.getKey());
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public xc4 c(Integer num) {
        this.i = num;
        return this;
    }

    public xc4 d(String str) {
        this.d = str;
        return this;
    }

    public xc4 e(int i) {
        this.f = i;
        return this;
    }

    public xc4 f(String str) {
        this.c = str;
        return this;
    }

    public xc4 g(String str) {
        this.g = str;
        return this;
    }

    public xc4 h(String str) {
        this.h = str;
        return this;
    }

    public xc4 i(String str) {
        this.f19860b = str;
        return this;
    }

    public xc4 j(String str) {
        this.e = str;
        return this;
    }
}
