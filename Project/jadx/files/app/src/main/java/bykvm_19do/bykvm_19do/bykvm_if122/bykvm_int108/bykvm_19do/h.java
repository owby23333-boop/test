package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1734d;

    public h(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarC = c();
        if (aVarC != null) {
            this.f1733c = aVarC.a();
            this.f1734d = aVarC.b();
        }
    }

    public h(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f1733c = gMNetworkRequestInfo.getAppId();
            this.f1734d = gMNetworkRequestInfo.getAppKey();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String a() {
        return (TextUtils.isEmpty(this.f1733c) || TextUtils.isEmpty(this.f1734d)) ? "appId为空或appKey为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String b() {
        return "mintegral";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put("app_id", this.f1733c);
        map.put("app_key", this.f1734d);
        return map;
    }
}
