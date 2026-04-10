package com.bytedance.sdk.component.z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.z.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected gz dl;
    e e;
    protected i g;
    protected String gc;
    protected Context z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f867a = new Handler(Looper.getMainLooper());
    protected volatile boolean m = false;
    private final Map<String, e> gz = new HashMap();

    protected abstract Context getContext(uy uyVar);

    protected abstract String z();

    protected abstract void z(uy uyVar);

    protected abstract void z(String str);

    protected z() {
    }

    protected void invokeMethod(final String str) {
        if (this.m) {
            return;
        }
        fo.z("Received call: ".concat(String.valueOf(str)));
        this.f867a.post(new Runnable() { // from class: com.bytedance.sdk.component.z.z.1
            @Override // java.lang.Runnable
            public void run() {
                ls lsVarZ;
                if (z.this.m) {
                    return;
                }
                try {
                    lsVarZ = z.this.z(new JSONObject(str));
                } catch (Exception e) {
                    fo.g("Exception thrown while parsing function.", e);
                    lsVarZ = null;
                }
                if (ls.z(lsVarZ)) {
                    fo.z("By pass invalid call: ".concat(String.valueOf(lsVarZ)));
                    if (lsVarZ != null) {
                        z.this.g(io.z(new fv(lsVarZ.z, "Failed to parse invocation.")), lsVarZ);
                        return;
                    }
                    return;
                }
                z.this.z(lsVarZ);
            }
        });
    }

    protected void z(String str, ls lsVar) {
        z(str);
    }

    protected void g() {
        this.e.z();
        Iterator<e> it = this.gz.values().iterator();
        while (it.hasNext()) {
            it.next().z();
        }
        this.f867a.removeCallbacksAndMessages(null);
        this.m = true;
    }

    protected final void z(ls lsVar) {
        String strZ;
        if (this.m || (strZ = z()) == null) {
            return;
        }
        e eVarG = g(lsVar.e);
        if (eVarG == null) {
            fo.g("Received call with unknown namespace, ".concat(String.valueOf(lsVar)));
            if (this.g != null) {
                z();
            }
            g(io.z(new fv(-4, "Namespace " + lsVar.e + " unknown.")), lsVar);
            return;
        }
        m mVar = new m();
        mVar.g = strZ;
        mVar.z = this.z;
        mVar.dl = eVarG;
        try {
            e.z zVarZ = eVarG.z(lsVar, mVar);
            if (zVarZ == null) {
                fo.g("Received call but not registered, ".concat(String.valueOf(lsVar)));
                if (this.g != null) {
                    z();
                }
                g(io.z(new fv(-2, "Function " + lsVar.f859a + " is not registered.")), lsVar);
                return;
            }
            if (zVarZ.z) {
                g(zVarZ.g, lsVar);
            }
            if (this.g != null) {
                z();
            }
        } catch (Exception e) {
            fo.z("call finished with error, ".concat(String.valueOf(lsVar)), e);
            g(io.z(e), lsVar);
        }
    }

    final void z(uy uyVar, q qVar) {
        this.z = getContext(uyVar);
        this.dl = uyVar.f866a;
        this.g = uyVar.fo;
        this.e = new e(uyVar, this, qVar);
        this.gc = uyVar.kb;
        z(uyVar);
    }

    final <T> void z(String str, T t) {
        if (this.m) {
            return;
        }
        String strZ = this.dl.z(t);
        fo.z("Sending js event: ".concat(String.valueOf(str)));
        z("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + strZ + "}");
    }

    final void g(String str, ls lsVar) {
        JSONObject jSONObject;
        if (this.m) {
            return;
        }
        if (TextUtils.isEmpty(lsVar.m)) {
            fo.z("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            fo.z(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        fo.z("Invoking js callback: " + lsVar.m);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        z(pf.z().z("__msg_type", "callback").z("__callback_id", lsVar.m).z("__params", jSONObject).g(), lsVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ls z(JSONObject jSONObject) {
        String strOptString;
        if (this.m) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (z() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return ls.z().z(string2).g(string).dl(strOptString3).a(strOptString).gc(strOptString2).m(strOptString4).e(jSONObject.optString("__iframe_url")).z();
        } catch (JSONException e) {
            fo.g("Failed to create call.", e);
            return ls.z(strOptString2, -1);
        }
    }

    private e g(String str) {
        if (TextUtils.equals(str, this.gc) || TextUtils.isEmpty(str)) {
            return this.e;
        }
        return this.gz.get(str);
    }
}
