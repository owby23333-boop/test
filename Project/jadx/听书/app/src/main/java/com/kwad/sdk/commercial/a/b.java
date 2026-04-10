package com.kwad.sdk.commercial.a;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avO;
    public String avP;
    public long avQ;
    public long avR;
    public int avS;
    public int avT;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b DT() {
        return new b();
    }

    public final b cv(int i) {
        this.status = i;
        return this;
    }

    public final b ar(long j) {
        this.downloadTime = j;
        return this;
    }

    public final b cw(int i) {
        this.avS = i;
        return this;
    }

    public final b cx(int i) {
        this.avT = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bn, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo adInfoEl = e.el(adTemplate);
        this.url = e.eo(adTemplate);
        try {
            this.avN = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = adInfoEl.downloadId;
        this.avO = adInfoEl.adBaseInfo.appPackageName;
        this.avP = adInfoEl.adBaseInfo.appName;
        this.avQ = adInfoEl.totalBytes;
        this.avR = adInfoEl.soFarBytes;
        return this;
    }
}
