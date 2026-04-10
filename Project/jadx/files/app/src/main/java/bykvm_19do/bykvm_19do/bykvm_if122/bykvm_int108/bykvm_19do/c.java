package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener;
import com.bytedance.msdk.api.AdError;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    private Context a;
    private IGMInitAdnResult b;

    class a implements IGMInitAdnResult {
        a() {
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
            if (c.this.b != null) {
                c.this.b.fail(adError);
            }
            if (adError != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), (Pair<Boolean, String>) new Pair(false, "errorCode = " + adError.code + " errorMessage = " + adError.message));
            }
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            if (c.this.b != null) {
                c.this.b.success();
            }
            if (TextUtils.equals(c.this.b(), "pangle")) {
                w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), (Pair<Boolean, String>) new Pair(true, ""));
        }
    }

    class b implements TTOnNetworkInitializationFinishedListener {
        b() {
        }

        @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
        public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
            if (TextUtils.equals(c.this.b(), "pangle")) {
                w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            }
            if (adError.code == 30011) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), (Pair<Boolean, String>) new Pair(true, ""));
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), (Pair<Boolean, String>) new Pair(false, "errorCode = " + adError.code + " errorMessage = " + adError.message));
        }
    }

    public c(Context context) {
        this.a = context;
    }

    private void a(ITTAdapterConfiguration iTTAdapterConfiguration, Map<String, Object> map) {
        iTTAdapterConfiguration.initAdn(this.a, map, new a());
    }

    private void a(boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(b());
        if (z2 || aVarA != null) {
            g();
        }
    }

    private void b(ITTAdapterConfiguration iTTAdapterConfiguration, Map<String, Object> map) {
        iTTAdapterConfiguration.initializeNetwork(this.a, map, new b());
    }

    private void g() {
        try {
            if (this.a == null) {
                throw new Exception("adn init context is null");
            }
            String strA = a();
            if (!TextUtils.isEmpty(strA)) {
                throw new Exception("adn init " + strA);
            }
            Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (mapE == null) {
                throw new Exception("adn init adpters is null");
            }
            ITTAdapterConfiguration iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName(b()));
            if (iTTAdapterConfiguration == null) {
                throw new Exception("adn init configuration is null");
            }
            Map<String, Object> mapD = d();
            if (mapD == null) {
                throw new Exception("adn init getConfig() is null");
            }
            if (iTTAdapterConfiguration.isNewInitFunction()) {
                a(iTTAdapterConfiguration, mapD);
            } else {
                b(iTTAdapterConfiguration, mapD);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(b(), (Pair<Boolean, String>) new Pair(false, th.toString()));
        }
    }

    protected abstract String a();

    public void a(IGMInitAdnResult iGMInitAdnResult) {
        this.b = iGMInitAdnResult;
        e();
    }

    protected abstract String b();

    public void b(IGMInitAdnResult iGMInitAdnResult) {
        this.b = iGMInitAdnResult;
        f();
    }

    protected bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(b());
    }

    protected abstract Map<String, Object> d();

    public void e() {
        a(false);
    }

    public void f() {
        a(true);
    }
}
