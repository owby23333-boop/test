package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;

/* JADX INFO: compiled from: TTIAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: compiled from: TTIAdLoad.java */
    class a implements GMSettingConfigCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f2099d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a f2100e;

        a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
            this.a = activity;
            this.b = eVar;
            this.f2098c = i2;
            this.f2099d = i3;
            this.f2100e = aVar;
        }

        @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
        public void configLoad() {
            g.this.a(this.a, this.b, this.f2098c, this.f2099d, this.f2100e);
        }
    }

    public abstract String a();

    public abstract void a(Activity activity, ViewGroup viewGroup);

    public abstract void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar);

    public void b(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        if (GMMediationAdSdk.configLoadSuccess()) {
            a(activity, eVar, i2, i3, aVar);
        } else {
            GMMediationAdSdk.registerConfigCallback(new a(activity, eVar, i2, i3, aVar));
        }
    }

    public abstract GMAdEcpmInfo c();

    public abstract String d();

    public RewardItem e() {
        return null;
    }

    public abstract String f();

    public boolean g() {
        return true;
    }

    public final String b() {
        GMAdEcpmInfo gMAdEcpmInfoC = c();
        return gMAdEcpmInfoC == null ? "" : gMAdEcpmInfoC.getAdnName();
    }
}
