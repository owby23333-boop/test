package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    private final hh z;
    private long g = 5000;
    private long dl = 1800000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, JSONObject> f297a = new HashMap();
    private final Map<String, JSONObject> gc = new HashMap();
    private String m = "";
    private final ReentrantLock e = new ReentrantLock();

    public q(Context context, hh hhVar) {
        this.z = hhVar;
        g(o.g(context).getString("d_data", ""));
    }

    private boolean dl(JSONObject jSONObject) {
        if (jSONObject.optString("message", "").equals("ok")) {
            return true;
        }
        js.z("__kite", "error response");
        return false;
    }

    private void z(String str) {
        this.z.g("d_data", str);
        this.z.z("d_data", str);
    }

    private void g(String str) {
        if (!this.f297a.isEmpty() && !this.gc.isEmpty()) {
            js.dl("__kite", " map is empty");
            return;
        }
        byte[] bArrClientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (bArrClientUnpackedBase64 == null || bArrClientUnpackedBase64.length == 0) {
            js.dl("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrClientUnpackedBase64));
            if (js.g()) {
                js.z("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.m = jSONObject.optString("version", "");
            z(jSONObject, "fields", this.f297a);
            int iOptInt = jSONObject.optInt("delay_sec", 0);
            if (iOptInt > 0) {
                this.g = ((long) iOptInt) * 1000;
            }
            int iOptInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (iOptInt2 > 0) {
                this.dl = ((long) iOptInt2) * 1000;
            }
            z(jSONObject, "dtrait_fields", this.gc);
            if (js.g()) {
                js.z("__kite" + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", Long.valueOf(this.g), Long.valueOf(this.dl)));
            }
        } catch (Exception e) {
            js.g("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private void z(JSONObject jSONObject, String str, Map<String, JSONObject> map) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            map.put(jSONObject2.optString("name"), jSONObject2);
        }
    }

    public void z(JSONObject jSONObject) {
        this.e.lock();
        try {
            try {
                if (!dl(jSONObject)) {
                    js.dl("__kite", "invalid response");
                } else {
                    String strOptString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(strOptString)) {
                        js.dl("__kite", "response is empty");
                    } else {
                        z(strOptString);
                        g(strOptString);
                        if (js.g()) {
                            js.z("__kiteconfig parse success");
                        }
                    }
                }
            } catch (Exception e) {
                js.g("__kiteerror" + e.getMessage());
            }
        } finally {
            this.e.unlock();
        }
    }

    public void g(JSONObject jSONObject) {
        try {
            if (dl(jSONObject)) {
                String strOptString = jSONObject.optString("data");
                if (TextUtils.isEmpty(strOptString)) {
                    js.z("__kite", "data is null");
                    return;
                }
                z(strOptString);
                g(strOptString);
                js.z("__kitesuccess");
            }
        } catch (Exception e) {
            js.g("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> z() {
        return this.f297a;
    }

    public String g() {
        return this.m;
    }

    public long dl() {
        return this.g;
    }
}
