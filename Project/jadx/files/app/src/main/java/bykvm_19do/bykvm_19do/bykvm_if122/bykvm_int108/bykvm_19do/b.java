package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1729c;

    public b(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarC = c();
        if (aVarC != null) {
            this.f1729c = aVarC.a();
        }
    }

    public b(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f1729c = gMNetworkRequestInfo.getAppId();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String a() {
        return TextUtils.isEmpty(this.f1729c) ? "appId为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String b() {
        return "baidu";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put("app_id", this.f1729c);
        map.put(TTBaseAdapterConfiguration.BAIDU_HTTPS, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().y()));
        if (!TextUtils.isEmpty(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().v())) {
            map.put(TTBaseAdapterConfiguration.BAIDU_WX_APP_ID, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().v());
        }
        return map;
    }
}
