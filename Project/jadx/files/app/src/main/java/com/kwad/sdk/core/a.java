package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private ConcurrentHashMap<String, DownloadParams> abf;
    private ConcurrentHashMap<String, AdTemplate> abg;

    /* JADX INFO: renamed from: com.kwad.sdk.core.a$a, reason: collision with other inner class name */
    static final class C0431a {
        private static final a abh = new a(0);
    }

    private a() {
        this.abf = new ConcurrentHashMap<>();
        this.abg = new ConcurrentHashMap<>();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a ud() {
        return C0431a.abh;
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abf.put(str, downloadParams);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final DownloadParams bf(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.abf.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        return null;
    }

    public final void bg(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abf.remove(str);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final AdTemplate bh(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.abg.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public final void bi(String str) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abg.remove(str);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        this.abg.put(str, adTemplate);
        ((e) ServiceProvider.get(e.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }
}
