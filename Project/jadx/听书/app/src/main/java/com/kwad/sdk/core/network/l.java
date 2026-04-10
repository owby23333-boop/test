package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.HU();

    protected void afterParseData(T t) {
    }

    protected boolean enableCrashReport() {
        return true;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    protected boolean isPostByJson() {
        return true;
    }

    protected abstract T parseData(String str);

    public void request(g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((f) null, e.aEv.errorCode, bw.s(th));
            reportSdkCaughtException(th);
        }
    }

    private void onRequest(g<R, T> gVar) {
        this.mMonitorRecorder.HN();
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    private void setMonitorRequestId(f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.em(str);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        R rCreateRequest;
        Throwable th;
        c cVarDoPost = null;
        try {
            this.mMonitorRecorder.HR();
            rCreateRequest = createRequest();
        } catch (Throwable th2) {
            rCreateRequest = null;
            th = th2;
        }
        try {
            notifyOnStartRequest(rCreateRequest);
            this.mMonitorRecorder.ei(rCreateRequest.getUrl()).ej(rCreateRequest.getUrl());
            setMonitorRequestId(rCreateRequest);
            if (!ao.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                notifyOnErrorListener(rCreateRequest, e.aEo.errorCode, e.aEo.msg);
                this.mMonitorRecorder.dx(e.aEo.errorCode).ek(e.aEo.msg);
            } else {
                try {
                    String url = rCreateRequest.getUrl();
                    AdHttpProxy adHttpProxyAI = com.kwad.sdk.g.AI();
                    if (adHttpProxyAI instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.el("ok_http").HQ();
                    } else {
                        this.mMonitorRecorder.el("http").HQ();
                    }
                    if (isPostByJson()) {
                        cVarDoPost = adHttpProxyAI.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody());
                    } else {
                        cVarDoPost = adHttpProxyAI.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBodyMap());
                    }
                    com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVarDoPost);
                } catch (Exception e) {
                    notifyOnErrorListener(rCreateRequest, e.aEv.errorCode, bw.s(e));
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    this.mMonitorRecorder.ek("requestError:" + e.getMessage());
                }
                this.mMonitorRecorder.HO().HP().dA(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(rCreateRequest, cVarDoPost);
                } catch (Exception e2) {
                    notifyOnErrorListener(rCreateRequest, e.aEv.errorCode, bw.s(e2));
                    this.mMonitorRecorder.ek("onResponseError:" + e2.getMessage());
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                try {
                    this.mMonitorRecorder.ek("requestError:" + th.getMessage());
                } finally {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            notifyOnErrorListener(rCreateRequest, e.aEv.errorCode, bw.s(th));
            com.kwad.sdk.core.d.c.printStackTrace(th);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused3) {
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    protected void onResponse(R r, c cVar) {
        if (cVar == null) {
            notifyOnErrorListener(r, e.aEo.errorCode, e.aEo.msg);
            this.mMonitorRecorder.ek("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.dx(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.aEk) || !cVar.Hx()) {
            notifyOnErrorListener(r, cVar, "网络错误");
            this.mMonitorRecorder.ek("httpCodeError:" + cVar.code + ":" + cVar.aEk);
            com.kwad.sdk.core.d.c.w(TAG, "request responseBase httpCodeError:" + cVar.code);
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.aEk);
            BaseResultData data = parseData(cVar.aEk);
            afterParseData(data);
            if (cVar.aEk != null) {
                this.mMonitorRecorder.az(cVar.aEk.length()).HS().dz(data.result);
            }
            if (!data.isResultOk()) {
                this.mMonitorRecorder.ek("serverCodeError:" + data.result + ":" + data.errorMsg);
                if (data.notifyFailOnResultError()) {
                    notifyOnErrorListener(r, data.result, data.errorMsg);
                    return;
                }
            }
            if (data.isDataEmpty()) {
                notifyOnErrorListener(r, e.aEq.errorCode, !TextUtils.isEmpty(data.testErrorMsg) ? data.testErrorMsg : e.aEq.msg);
            } else {
                checkAndSetHasData(data);
                notifyOnSuccess(r, data);
            }
        } catch (Exception e) {
            notifyOnErrorListener(r, e.aEp.errorCode, e.aEp.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mMonitorRecorder.ek("parseDataError:" + e.getMessage());
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Hx() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !ao.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.MI();
    }

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dy(1);
        }
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.HB().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void notifyOnStartRequest(R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnErrorListener(R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.aEi, cVar.aEj);
        com.kwad.sdk.core.network.idc.a.HF().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener(r, cVar.code, str);
    }

    private String getHostTypeByUrl(String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(R r, int i, String str) {
        try {
            h.Hy().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.HT();
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void notifyOnSuccess(R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.HF().HH()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.HF().ec(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.HT();
    }
}
