package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m<R extends g, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private h<R, T> mListener = null;
    private final com.kwad.sdk.core.network.a.b mMonitorRecorder = com.kwad.sdk.core.network.a.c.wK();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.aZ(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.kwai.e eVar;
        if (cVar == null || cVar.wn() || (eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)) == null || !af.isNetworkConnected(eVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.Ba();
    }

    private void notifyOnErrorListener(@NonNull R r2, int i2, String str) {
        i.wr().b(r2, i2);
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onError(r2, i2, str);
        this.mMonitorRecorder.wJ();
    }

    private void notifyOnErrorListener(@NonNull R r2, c cVar, String str) {
        String url = r2.getUrl();
        com.kwad.sdk.core.network.idc.a.wy().a(url, url.contains("/rest/zt/emoticon/package/list") ? INet.HostType.ZT : "api", new DomainException(cVar.afI, cVar.afJ));
        notifyOnErrorListener(r2, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r2) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onStartRequest(r2);
    }

    private void notifyOnSuccess(@NonNull R r2, T t2) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onSuccess(r2, t2);
        this.mMonitorRecorder.wJ();
    }

    private void onRequest(@NonNull h<R, T> hVar) {
        this.mMonitorRecorder.wD();
        this.mListener = hVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            r.wu().A(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void setMonitorRequestId(@NonNull g gVar) {
        Map<String, String> header = gVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.bY(str);
        }
    }

    protected void afterParseData(T t2) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void fetchImpl() {
        try {
            this.mMonitorRecorder.wH();
            R rCreateRequest = createRequest();
            notifyOnStartRequest(rCreateRequest);
            this.mMonitorRecorder.bU(rCreateRequest.getUrl()).bV(rCreateRequest.getUrl());
            setMonitorRequestId(rCreateRequest);
            if (af.isNetworkConnected(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())) {
                c cVarDoPost = null;
                try {
                    String url = rCreateRequest.getUrl();
                    AdHttpProxy adHttpProxySq = com.kwad.sdk.b.sq();
                    (adHttpProxySq instanceof com.kwad.sdk.core.network.b.b ? this.mMonitorRecorder.bX("ok_http") : this.mMonitorRecorder.bX("http")).wG();
                    cVarDoPost = isPostByJson() ? adHttpProxySq.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody()) : adHttpProxySq.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBodyMap());
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    this.mMonitorRecorder.bW("requestError:" + e2.getMessage());
                }
                this.mMonitorRecorder.wE().wF().bb(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(rCreateRequest, cVarDoPost);
                } catch (Exception e3) {
                    this.mMonitorRecorder.bW("onResponseError:" + e3.getMessage());
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
                }
            } else {
                notifyOnErrorListener(rCreateRequest, f.afQ.errorCode, f.afQ.msg);
                this.mMonitorRecorder.aY(f.afQ.errorCode).bW(f.afQ.msg);
            }
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            try {
                try {
                    this.mMonitorRecorder.bW("requestError:" + th.getMessage());
                } catch (Exception unused2) {
                }
                com.kwad.sdk.core.d.b.printStackTrace(th);
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused3) {
                }
            } catch (Throwable th2) {
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused4) {
                }
                throw th2;
            }
        }
    }

    protected boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    protected void onResponse(R r2, c cVar) {
        if (cVar == null) {
            f fVar = f.afQ;
            notifyOnErrorListener(r2, fVar.errorCode, fVar.msg);
            this.mMonitorRecorder.bW("responseBase is null");
            com.kwad.sdk.core.d.b.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.aY(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.afK) || !cVar.wn()) {
            notifyOnErrorListener(r2, cVar, "网络错误");
            this.mMonitorRecorder.bW("httpCodeError:" + cVar.code + ":" + cVar.afK);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.b.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r2.getUrl(), cVar.afK);
            BaseResultData data = parseData(cVar.afK);
            afterParseData(data);
            if (cVar.afK != null) {
                this.mMonitorRecorder.K(r7.length()).wI().ba(data.result);
            }
            if (data.isResultOk()) {
                if (data.isDataEmpty()) {
                    f fVar2 = f.afS;
                    notifyOnErrorListener(r2, fVar2.errorCode, fVar2.msg);
                    return;
                } else {
                    checkAndSetHasData(data);
                    notifyOnSuccess(r2, data);
                    return;
                }
            }
            notifyOnErrorListener(r2, data.result, data.errorMsg);
            this.mMonitorRecorder.bW("serverCodeError:" + data.result + ":" + data.errorMsg);
        } catch (Exception e2) {
            f fVar3 = f.afR;
            notifyOnErrorListener(r2, fVar3.errorCode, fVar3.msg);
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mMonitorRecorder.bW("parseDataError:" + e2.getMessage());
        }
    }

    @NonNull
    protected abstract T parseData(String str);

    public void request(@NonNull h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
