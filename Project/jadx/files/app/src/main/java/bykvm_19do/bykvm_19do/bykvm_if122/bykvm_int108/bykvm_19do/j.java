package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f1735c;

    public j(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarC = c();
        if (aVarC != null) {
            this.f1735c = aVarC.a();
        }
        if (TextUtils.isEmpty(this.f1735c)) {
            this.f1735c = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b();
        }
    }

    public j(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f1735c = gMNetworkRequestInfo.getAppId();
        }
    }

    public static j a(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A() ? new k(context) : new i(context);
    }

    public static j a(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A() ? new k(context, gMNetworkRequestInfo) : new i(context, gMNetworkRequestInfo);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected String a() {
        return TextUtils.isEmpty(this.f1735c) ? "appId为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put("app_id", this.f1735c);
        map.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_USE_TEXTURE_VIEW, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().E()));
        map.put(TTBaseAdapterConfiguration.PANGLE_APP_NAME, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().i());
        map.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_PAID, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().D()));
        map.put(TTBaseAdapterConfiguration.PANGLE_TITLE_BAR_THEME, Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().o()));
        map.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_NOTIFY, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().B()));
        map.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_PAGE_WHEN_SCREEN_LOCK, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().C()));
        map.put(TTBaseAdapterConfiguration.PANGLE_DIRECT_DOWNLOAD_NETWORKTYPE, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().p());
        map.put(TTBaseAdapterConfiguration.PANGLE_NEED_CLEAR_TASK_RESET, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().m());
        map.put(TTBaseAdapterConfiguration.PANGLE_KEYWORDS, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().l());
        map.put(TTBaseAdapterConfiguration.PANGLE_PLUGIN_UPDATE_CONFIG, Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().n()));
        return map;
    }
}
