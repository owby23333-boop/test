package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.wu;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private final String bf;
    private final String bh;
    private final String d;
    private String e;
    private final long ga;
    private final List<String> m;
    private final long p;
    private final String s;
    private final boolean t;
    private final boolean tg;
    private final JSONObject v;
    private final String vn;
    private final JSONObject w;
    private final int wu;
    private final Object xu;
    private final JSONObject zk;

    public static class e {
        private String bf;
        private Object bh;
        private String d;
        private String e;
        private long ga;
        private JSONObject l;
        private Map<String, Object> m;
        private long p;
        private String t;
        private JSONObject v;
        private String vn;
        private String w;
        private List<String> wu;
        private int xu;
        private JSONObject zk;
        private boolean tg = false;
        private boolean s = false;

        public e bf(String str) {
            this.d = str;
            return this;
        }

        public e d(String str) {
            this.vn = str;
            return this;
        }

        public e e(boolean z) {
            this.s = z;
            return this;
        }

        public e tg(String str) {
            this.t = str;
            return this;
        }

        public e bf(long j) {
            this.p = j;
            return this;
        }

        public e e(String str) {
            this.bf = str;
            return this;
        }

        public e bf(boolean z) {
            this.tg = z;
            return this;
        }

        public e e(long j) {
            this.ga = j;
            return this;
        }

        public e bf(JSONObject jSONObject) {
            this.zk = jSONObject;
            return this;
        }

        public e e(JSONObject jSONObject) {
            this.v = jSONObject;
            return this;
        }

        public e e(List<String> list) {
            this.wu = list;
            return this;
        }

        public e e(int i) {
            this.xu = i;
            return this;
        }

        public e e(Object obj) {
            this.bh = obj;
            return this;
        }

        public d e() {
            if (TextUtils.isEmpty(this.e)) {
                this.e = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.v == null) {
                this.v = new JSONObject();
            }
            try {
                Map<String, Object> map = this.m;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.m.entrySet()) {
                        if (!this.v.has(entry.getKey())) {
                            this.v.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.s) {
                    this.w = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    this.l = jSONObject2;
                    if (this.tg) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.v.toString());
                    } else {
                        Iterator<String> itKeys = this.v.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.l.put(next, this.v.get(next));
                        }
                    }
                    this.l.put("category", this.e);
                    this.l.put("tag", this.bf);
                    this.l.put("value", this.ga);
                    this.l.put("ext_value", this.p);
                    if (!TextUtils.isEmpty(this.t)) {
                        this.l.put("refer", this.t);
                    }
                    JSONObject jSONObject3 = this.zk;
                    if (jSONObject3 != null) {
                        this.l = com.ss.android.download.api.d.bf.e(jSONObject3, this.l);
                    }
                    if (this.tg) {
                        if (!this.l.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.vn)) {
                            this.l.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.vn);
                        }
                        this.l.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.tg) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.v.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.vn)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.vn);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.v);
                }
                if (!TextUtils.isEmpty(this.t)) {
                    jSONObject.putOpt("refer", this.t);
                }
                JSONObject jSONObject4 = this.zk;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.d.bf.e(jSONObject4, jSONObject);
                }
                this.v = jSONObject;
            } catch (Exception e) {
                wu.dt().e(e, "DownloadEventModel build");
            }
            return new d(this);
        }
    }

    public d(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d;
        this.tg = eVar.tg;
        this.ga = eVar.ga;
        this.vn = eVar.vn;
        this.p = eVar.p;
        this.v = eVar.v;
        this.zk = eVar.zk;
        this.m = eVar.wu;
        this.wu = eVar.xu;
        this.xu = eVar.bh;
        this.t = eVar.s;
        this.s = eVar.w;
        this.w = eVar.l;
        this.bh = eVar.t;
    }

    public String bf() {
        return this.bf;
    }

    public boolean bh() {
        return this.t;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public long ga() {
        return this.ga;
    }

    public List<String> m() {
        return this.m;
    }

    public long p() {
        return this.p;
    }

    public JSONObject s() {
        return this.w;
    }

    public String t() {
        return this.s;
    }

    public boolean tg() {
        return this.tg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.e);
        sb.append("\ttag: ");
        sb.append(this.bf);
        sb.append("\tlabel: ");
        sb.append(this.d);
        sb.append("\nisAd: ");
        sb.append(this.tg);
        sb.append("\tadId: ");
        sb.append(this.ga);
        sb.append("\tlogExtra: ");
        sb.append(this.vn);
        sb.append("\textValue: ");
        sb.append(this.p);
        sb.append("\nextJson: ");
        sb.append(this.v);
        sb.append("\nparamsJson: ");
        sb.append(this.zk);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.m;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.wu);
        sb.append("\textraObject: ");
        Object obj = this.xu;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.t);
        sb.append("\tV3EventName: ");
        sb.append(this.s);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.w;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public JSONObject v() {
        return this.v;
    }

    public String vn() {
        return this.vn;
    }

    public int wu() {
        return this.wu;
    }

    public Object xu() {
        return this.xu;
    }

    public JSONObject zk() {
        return this.zk;
    }
}
