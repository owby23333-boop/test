package com.ss.android.z.z.gc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.wp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2119a;
    private final String dl;
    private final long e;
    private final JSONObject fo;
    private final String g;
    private final long gc;
    private final JSONObject gz;
    private final String i;
    private final int kb;
    private final JSONObject ls;
    private final String m;
    private final String pf;
    private final List<String> uy;
    private final boolean v;
    private final Object wp;
    private String z;

    a(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f2119a = zVar.f2120a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.fo = zVar.fo;
        this.uy = zVar.kb;
        this.kb = zVar.wp;
        this.wp = zVar.i;
        this.v = zVar.pf;
        this.pf = zVar.ls;
        this.ls = zVar.p;
        this.i = zVar.v;
    }

    public static class z {
        private String dl;
        private long e;
        private JSONObject fo;
        private String g;
        private long gc;
        private JSONObject gz;
        private Object i;
        private List<String> kb;
        private String ls;
        private String m;
        private JSONObject p;
        private Map<String, Object> uy;
        private String v;
        private int wp;
        private String z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2120a = false;
        private boolean pf = false;

        public z z(boolean z) {
            this.pf = z;
            return this;
        }

        public z z(String str) {
            this.g = str;
            return this;
        }

        public z g(String str) {
            this.dl = str;
            return this;
        }

        public z z(long j) {
            this.gc = j;
            return this;
        }

        public z g(long j) {
            this.e = j;
            return this;
        }

        public z dl(String str) {
            this.m = str;
            return this;
        }

        public z g(boolean z) {
            this.f2120a = z;
            return this;
        }

        public z z(JSONObject jSONObject) {
            this.gz = jSONObject;
            return this;
        }

        public z g(JSONObject jSONObject) {
            this.fo = jSONObject;
            return this;
        }

        public z z(List<String> list) {
            this.kb = list;
            return this;
        }

        public z z(int i) {
            this.wp = i;
            return this;
        }

        public z z(Object obj) {
            this.i = obj;
            return this;
        }

        public z a(String str) {
            this.v = str;
            return this;
        }

        public a z() {
            if (TextUtils.isEmpty(this.z)) {
                this.z = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.gz == null) {
                this.gz = new JSONObject();
            }
            try {
                Map<String, Object> map = this.uy;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.uy.entrySet()) {
                        if (!this.gz.has(entry.getKey())) {
                            this.gz.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.pf) {
                    this.ls = this.dl;
                    JSONObject jSONObject2 = new JSONObject();
                    this.p = jSONObject2;
                    if (this.f2120a) {
                        jSONObject2.put("ad_extra_data", this.gz.toString());
                    } else {
                        Iterator<String> itKeys = this.gz.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.p.put(next, this.gz.get(next));
                        }
                    }
                    this.p.put("category", this.z);
                    this.p.put("tag", this.g);
                    this.p.put("value", this.gc);
                    this.p.put("ext_value", this.e);
                    if (!TextUtils.isEmpty(this.v)) {
                        this.p.put("refer", this.v);
                    }
                    JSONObject jSONObject3 = this.fo;
                    if (jSONObject3 != null) {
                        this.p = com.ss.android.z.z.m.g.z(jSONObject3, this.p);
                    }
                    if (this.f2120a) {
                        if (!this.p.has(MediationConstant.EXTRA_LOG_EXTRA) && !TextUtils.isEmpty(this.m)) {
                            this.p.put(MediationConstant.EXTRA_LOG_EXTRA, this.m);
                        }
                        this.p.put("is_ad_event", "1");
                    }
                }
                if (this.f2120a) {
                    jSONObject.put("ad_extra_data", this.gz.toString());
                    if (!jSONObject.has(MediationConstant.EXTRA_LOG_EXTRA) && !TextUtils.isEmpty(this.m)) {
                        jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.m);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.gz);
                }
                if (!TextUtils.isEmpty(this.v)) {
                    jSONObject.putOpt("refer", this.v);
                }
                JSONObject jSONObject4 = this.fo;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.z.z.m.g.z(jSONObject4, jSONObject);
                }
                this.gz = jSONObject;
            } catch (Exception e) {
                wp.tb().z(e, "DownloadEventModel build");
            }
            return new a(this);
        }
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public boolean a() {
        return this.f2119a;
    }

    public long gc() {
        return this.gc;
    }

    public String m() {
        return this.m;
    }

    public long e() {
        return this.e;
    }

    public JSONObject gz() {
        return this.gz;
    }

    public JSONObject fo() {
        return this.fo;
    }

    public List<String> uy() {
        return this.uy;
    }

    public int kb() {
        return this.kb;
    }

    public Object wp() {
        return this.wp;
    }

    public boolean i() {
        return this.v;
    }

    public String v() {
        return this.pf;
    }

    public JSONObject pf() {
        return this.ls;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("category: ").append(this.z).append("\ttag: ").append(this.g).append("\tlabel: ").append(this.dl).append("\nisAd: ").append(this.f2119a).append("\tadId: ").append(this.gc).append("\tlogExtra: ").append(this.m).append("\textValue: ").append(this.e).append("\nextJson: ").append(this.gz).append("\nparamsJson: ").append(this.fo).append("\nclickTrackUrl: ");
        List<String> list = this.uy;
        StringBuilder sbAppend2 = sbAppend.append(list != null ? list.toString() : "").append("\teventSource: ").append(this.kb).append("\textraObject: ");
        Object obj = this.wp;
        StringBuilder sbAppend3 = sbAppend2.append(obj != null ? obj.toString() : "").append("\nisV3: ").append(this.v).append("\tV3EventName: ").append(this.pf).append("\tV3EventParams: ");
        JSONObject jSONObject = this.ls;
        return sbAppend3.append(jSONObject != null ? jSONObject.toString() : "").toString();
    }
}
