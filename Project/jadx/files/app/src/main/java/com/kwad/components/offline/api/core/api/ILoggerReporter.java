package com.kwad.components.offline.api.core.api;

import com.kwai.adclient.logger.model.BusinessType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ILoggerReporter {

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(String str, BusinessType businessType, String str2, JSONObject jSONObject);
}
