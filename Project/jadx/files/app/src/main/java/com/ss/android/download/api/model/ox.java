package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    private final String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f17952h;
    private final boolean hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private final JSONObject f17953io;
    private final int jb;
    private final Object je;
    private final long ko;
    private final String lc;
    private final JSONObject lz;
    private String mb;
    private final String nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f17954o;
    private final String ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f17955u;
    private final JSONObject ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List<String> f17956x;

    public static class mb {
        private String b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f17957e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f17958h;

        /* JADX INFO: renamed from: io, reason: collision with root package name */
        private String f17959io;
        private List<String> jb;
        private int je;
        private long ko;
        private JSONObject lz;
        private String mb;
        private Object nk;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f17960o;
        private String ox;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f17961u;
        private JSONObject ww;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private Map<String, Object> f17962x;
        private boolean hj = false;
        private boolean lc = false;

        public mb b(String str) {
            this.f17961u = str;
            return this;
        }

        public mb hj(String str) {
            this.f17960o = str;
            return this;
        }

        public mb mb(boolean z2) {
            this.lc = z2;
            return this;
        }

        public mb ox(String str) {
            this.b = str;
            return this;
        }

        public mb mb(String str) {
            this.ox = str;
            return this;
        }

        public mb ox(long j2) {
            this.ko = j2;
            return this;
        }

        public mb mb(long j2) {
            this.f17958h = j2;
            return this;
        }

        public mb ox(boolean z2) {
            this.hj = z2;
            return this;
        }

        public mb mb(JSONObject jSONObject) {
            this.ww = jSONObject;
            return this;
        }

        public mb ox(JSONObject jSONObject) {
            this.lz = jSONObject;
            return this;
        }

        public mb mb(List<String> list) {
            this.jb = list;
            return this;
        }

        public mb mb(int i2) {
            this.je = i2;
            return this;
        }

        public mb mb(Object obj) {
            this.nk = obj;
            return this;
        }

        public ox mb() {
            if (TextUtils.isEmpty(this.mb)) {
                this.mb = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.ww == null) {
                this.ww = new JSONObject();
            }
            try {
                if (this.f17962x != null && !this.f17962x.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f17962x.entrySet()) {
                        if (!this.ww.has(entry.getKey())) {
                            this.ww.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.lc) {
                    this.f17959io = this.b;
                    this.f17957e = new JSONObject();
                    if (this.hj) {
                        this.f17957e.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.ww.toString());
                    } else {
                        Iterator<String> itKeys = this.ww.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.f17957e.put(next, this.ww.get(next));
                        }
                    }
                    this.f17957e.put("category", this.mb);
                    this.f17957e.put("tag", this.ox);
                    this.f17957e.put("value", this.f17958h);
                    this.f17957e.put("ext_value", this.ko);
                    if (!TextUtils.isEmpty(this.f17960o)) {
                        this.f17957e.put("refer", this.f17960o);
                    }
                    if (this.lz != null) {
                        this.f17957e = com.ss.android.download.api.b.ox.mb(this.lz, this.f17957e);
                    }
                    if (this.hj) {
                        if (!this.f17957e.has("log_extra") && !TextUtils.isEmpty(this.f17961u)) {
                            this.f17957e.put("log_extra", this.f17961u);
                        }
                        this.f17957e.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.hj) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.ww.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f17961u)) {
                        jSONObject.put("log_extra", this.f17961u);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.ww);
                }
                if (!TextUtils.isEmpty(this.f17960o)) {
                    jSONObject.putOpt("refer", this.f17960o);
                }
                if (this.lz != null) {
                    jSONObject = com.ss.android.download.api.b.ox.mb(this.lz, jSONObject);
                }
                this.ww = jSONObject;
            } catch (Exception e2) {
                x.m().mb(e2, "DownloadEventModel build");
            }
            return new ox(this);
        }
    }

    ox(mb mbVar) {
        this.mb = mbVar.mb;
        this.ox = mbVar.ox;
        this.b = mbVar.b;
        this.hj = mbVar.hj;
        this.f17952h = mbVar.f17958h;
        this.f17955u = mbVar.f17961u;
        this.ko = mbVar.ko;
        this.ww = mbVar.ww;
        this.lz = mbVar.lz;
        this.f17956x = mbVar.jb;
        this.jb = mbVar.je;
        this.je = mbVar.nk;
        this.f17954o = mbVar.lc;
        this.lc = mbVar.f17959io;
        this.f17953io = mbVar.f17957e;
        this.nk = mbVar.f17960o;
    }

    public String b() {
        return this.b;
    }

    public long h() {
        return this.f17952h;
    }

    public boolean hj() {
        return this.hj;
    }

    public int jb() {
        return this.jb;
    }

    public Object je() {
        return this.je;
    }

    public long ko() {
        return this.ko;
    }

    public JSONObject lc() {
        return this.f17953io;
    }

    public JSONObject lz() {
        return this.lz;
    }

    public String mb() {
        return this.mb;
    }

    public boolean nk() {
        return this.f17954o;
    }

    public String o() {
        return this.lc;
    }

    public String ox() {
        return this.ox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.mb);
        sb.append("\ttag: ");
        sb.append(this.ox);
        sb.append("\tlabel: ");
        sb.append(this.b);
        sb.append("\nisAd: ");
        sb.append(this.hj);
        sb.append("\tadId: ");
        sb.append(this.f17952h);
        sb.append("\tlogExtra: ");
        sb.append(this.f17955u);
        sb.append("\textValue: ");
        sb.append(this.ko);
        sb.append("\nextJson: ");
        sb.append(this.ww);
        sb.append("\nparamsJson: ");
        sb.append(this.lz);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f17956x;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.jb);
        sb.append("\textraObject: ");
        Object obj = this.je;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.f17954o);
        sb.append("\tV3EventName: ");
        sb.append(this.lc);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f17953io;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public String u() {
        return this.f17955u;
    }

    public JSONObject ww() {
        return this.ww;
    }

    public List<String> x() {
        return this.f17956x;
    }
}
