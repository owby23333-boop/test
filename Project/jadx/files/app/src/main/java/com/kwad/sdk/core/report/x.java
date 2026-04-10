package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends com.kwad.sdk.core.network.a<y> {
    private ReportResultData ajx;

    @NonNull
    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        if (this.ajx == null) {
            this.ajx = new ReportResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(@Nullable JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
        }
        if (cVar != null) {
            try {
                this.ajx.parseJson(new JSONObject(cVar.afK));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.ajx;
    }

    private void a(y yVar) {
        try {
            List<String> listXy = yVar.xy();
            for (String str : listXy) {
                com.kwad.sdk.b.sq().doGetWithoutResponse(str, null);
                if (!isValidUrl(str)) {
                    e(yVar.getAdTemplate(), yVar.ajy, str);
                }
            }
            a(yVar.getAdTemplate(), listXy);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        q qVar = new q(10217L, adTemplate);
        qVar.aja = com.kwad.sdk.utils.s.toJsonArray(list);
        h.a(qVar);
    }

    private static void e(@NonNull AdTemplate adTemplate, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q qVar = new q(10218L);
        qVar.creativeId = com.kwad.sdk.core.response.a.d.cb(adTemplate).adBaseInfo.creativeId;
        qVar.aiZ = i2;
        qVar.aja = com.kwad.sdk.utils.s.toJsonArray(Collections.singletonList(str));
        h.a(qVar);
    }

    private static boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https");
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetch() {
        super.fetch();
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        String url;
        String str;
        if (!af.isNetworkConnected(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())) {
            com.kwad.sdk.core.d.b.w("ReportNetwork", "no network while report log");
            return;
        }
        y yVarCreateRequest = createRequest();
        com.kwad.sdk.core.network.c cVarDoPost = null;
        try {
            url = yVarCreateRequest.getUrl();
        } catch (Exception e2) {
            e = e2;
            url = null;
        }
        try {
            cVarDoPost = com.kwad.sdk.b.sq().doPost(url, (Map<String, String>) null, yVarCreateRequest.getBody());
            if (cVarDoPost == null || cVarDoPost.code != 200) {
                str = "report fail result is null";
            } else {
                str = "report success actionType:" + yVarCreateRequest.ajy;
            }
            com.kwad.sdk.core.d.b.d("ReportNetwork", str);
        } catch (Exception e3) {
            e = e3;
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        ReportResultData reportResultDataA = a(cVarDoPost);
        if (reportResultDataA.isCheatingFlow()) {
            yVarCreateRequest.getAdTemplate().setCheatingFlow(reportResultDataA.isCheatingFlow());
        }
        if (!yVarCreateRequest.getAdTemplate().mCheatingFlow) {
            a(yVarCreateRequest);
        }
        if (!com.kwad.b.kwai.a.bI.booleanValue() || reportResultDataA.isResultOk()) {
            return;
        }
        throw new RuntimeException("请求返回失败 code:" + reportResultDataA.result + ", errorMsg:" + reportResultDataA.errorMsg + "\n url=" + url);
    }

    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(com.kwad.sdk.core.network.g gVar, com.kwad.sdk.core.network.c cVar) {
    }
}
