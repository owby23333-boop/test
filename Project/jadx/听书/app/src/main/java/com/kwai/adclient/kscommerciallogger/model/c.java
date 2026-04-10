package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final d avM;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.category = aVar.beV;
        this.biz = aVar.beW;
        this.subBiz = aVar.beX;
        this.tag = aVar.mTag;
        this.avM = aVar.beY;
        this.extraParam = aVar.beZ;
        this.eventId = aVar.bfa;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    public final String Th() {
        return this.category;
    }

    public final SubBusinessType Ti() {
        return this.subBiz;
    }

    public final d Tj() {
        return this.avM;
    }

    public final JSONObject Tk() {
        return this.msg;
    }

    public final JSONObject Tl() {
        return this.extraParam;
    }

    public final String Tm() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put("biz", businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.avM;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static class a {
        private final String beV;
        private BusinessType beW;
        private SubBusinessType beX;
        private d beY;
        private JSONObject beZ;
        private String bfa;
        private String mTag;
        private JSONObject msg;

        private a(String str) {
            this.beV = str;
        }

        public static a Tn() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a To() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a c(BusinessType businessType) {
            this.beW = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.beX = subBusinessType;
            return this;
        }

        public final a hN(String str) {
            this.mTag = str;
            return this;
        }

        public final a b(d dVar) {
            this.beY = dVar;
            return this;
        }

        public final a hO(String str) {
            this.bfa = str;
            return this;
        }

        public final a A(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Tp() {
            if (com.kwai.adclient.kscommerciallogger.a.Te().isDebug()) {
                if (TextUtils.isEmpty(this.beV) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bfa)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.Te().Tg() && !com.kwai.adclient.kscommerciallogger.b.hM(this.bfa)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.beV) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bfa)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.Te().Tg() && !com.kwai.adclient.kscommerciallogger.b.hM(this.bfa)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.Te().Tf() != null) {
                this.beZ = com.kwai.adclient.kscommerciallogger.a.Te().Tf();
            }
            return new c(this, (byte) 0);
        }
    }
}
