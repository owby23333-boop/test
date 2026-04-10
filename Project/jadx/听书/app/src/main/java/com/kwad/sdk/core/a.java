package com.kwad.sdk.core;

import android.text.TextUtils;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private ConcurrentHashMap<String, DownloadParams> awA;
    private ConcurrentHashMap<String, AdTemplate> awB;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.awA = new ConcurrentHashMap<>();
        this.awB = new ConcurrentHashMap<>();
    }

    public static a Em() {
        return C0391a.awC;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.a$a, reason: collision with other inner class name */
    static final class C0391a {
        private static final a awC = new a(0);
    }

    public final DownloadParams di(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        DownloadParams downloadParams = this.awA.get(str);
        if (downloadParams != null) {
            return downloadParams;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            DownloadParams downloadParams2 = new DownloadParams();
            try {
                downloadParams2.parseJson(new JSONObject(string));
                return downloadParams2;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return null;
    }

    public final void dj(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awA.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void a(String str, DownloadParams downloadParams) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awA.put(str, downloadParams);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, downloadParams.toJson().toString()).apply();
    }

    public final AdTemplate dk(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return null;
        }
        AdTemplate adTemplate = this.awB.get(str);
        if (adTemplate != null) {
            return adTemplate;
        }
        String string = ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            AdTemplate adTemplate2 = new AdTemplate();
            try {
                adTemplate2.parseJson(new JSONObject(string));
                return adTemplate2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void dl(String str) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awB.remove(str);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().remove(str).apply();
    }

    public final void e(String str, AdTemplate adTemplate) {
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        this.awB.put(str, adTemplate);
        ((f) ServiceProvider.get(f.class)).getContext().getSharedPreferences("ksadsdk_notification_download_complete", 0).edit().putString(str, adTemplate.toJson().toString()).apply();
    }
}
