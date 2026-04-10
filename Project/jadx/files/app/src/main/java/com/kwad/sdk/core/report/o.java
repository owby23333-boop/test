package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public SubBusinessType aif;
    public com.kwai.adclient.logger.model.d aig;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String suffixRatio;
    public String tag;

    public static class a {
        private String category;
        private String eventId;
        private JSONObject msg;
        private String tag;
        private BusinessType biz = BusinessType.OTHER;
        private SubBusinessType subBiz = SubBusinessType.OTHER;
        private com.kwai.adclient.logger.model.d aig = com.kwai.adclient.logger.model.d.aDj;
        private String suffixRatio = "";

        public final a a(BusinessType businessType) {
            this.biz = businessType;
            return this;
        }

        public final a a(SubBusinessType subBusinessType) {
            this.subBiz = subBusinessType;
            return this;
        }

        public final a a(com.kwai.adclient.logger.model.d dVar) {
            this.aig = dVar;
            return this;
        }

        public final a cl(String str) {
            this.category = str;
            return this;
        }

        public final a cm(@NonNull String str) {
            this.eventId = str;
            return this;
        }

        public final a cn(@NonNull String str) {
            this.tag = str;
            return this;
        }

        public final o xm() {
            return new o(this.category, this.biz, this.subBiz, this.aig, this.eventId, this.tag, this.suffixRatio, this.msg);
        }

        public final a z(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }
    }

    public o(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.logger.model.d dVar, String str2, String str3, String str4, JSONObject jSONObject) {
        this.biz = BusinessType.OTHER;
        this.aif = SubBusinessType.OTHER;
        this.aig = com.kwai.adclient.logger.model.d.aDj;
        this.category = str;
        this.biz = businessType;
        this.aif = subBusinessType;
        this.aig = dVar;
        this.eventId = str2;
        this.tag = str3;
        this.suffixRatio = str4;
        this.msg = jSONObject;
    }
}
