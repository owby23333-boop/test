package com.kwai.adclient.logger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final d aig;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    public static class a {
        private BusinessType aDf;
        private SubBusinessType aDg;
        private d aDh;
        private JSONObject aDi;
        private final String mCategory;
        private String mEventId;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.mCategory = str;
        }

        public static a FQ() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a FR() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final c FS() {
            if (com.kwai.adclient.logger.a.FG().isDebug()) {
                if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.logger.a.FG().FI() && !com.kwai.adclient.logger.b.eN(this.mEventId)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.mCategory) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.mEventId)) {
                    return null;
                }
                if (com.kwai.adclient.logger.a.FG().FI() && !com.kwai.adclient.logger.b.eN(this.mEventId)) {
                    return null;
                }
            }
            if (com.kwai.adclient.logger.a.FG().FH() != null) {
                this.aDi = com.kwai.adclient.logger.a.FG().FH();
            }
            return new c(this, (byte) 0);
        }

        public final a O(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final a b(BusinessType businessType) {
            this.aDf = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.aDg = subBusinessType;
            return this;
        }

        public final a b(d dVar) {
            this.aDh = dVar;
            return this;
        }

        public final a eO(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a eP(@NonNull String str) {
            this.mEventId = str;
            return this;
        }
    }

    private c(a aVar) {
        this.category = aVar.mCategory;
        this.biz = aVar.aDf;
        this.subBiz = aVar.aDg;
        this.tag = aVar.mTag;
        this.aig = aVar.aDh;
        this.extraParam = aVar.aDi;
        this.eventId = aVar.mEventId;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String FJ() {
        return this.category;
    }

    public final BusinessType FK() {
        return this.biz;
    }

    public final SubBusinessType FL() {
        return this.subBiz;
    }

    public final d FM() {
        return this.aig;
    }

    public final JSONObject FN() {
        return this.msg;
    }

    public final JSONObject FO() {
        return this.extraParam;
    }

    public final String FP() {
        return this.eventId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.biz != null) {
                jSONObject.put("biz", this.biz.value);
            }
            if (this.subBiz != null) {
                jSONObject.put("sub_biz", this.subBiz.value);
            }
            jSONObject.put("tag", this.tag);
            if (this.aig != null) {
                jSONObject.put("type", this.aig.getValue());
            }
            if (this.msg != null) {
                jSONObject.put("msg", this.msg);
            }
            if (this.extraParam != null) {
                jSONObject.put("extra_param", this.extraParam);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
