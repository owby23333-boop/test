package t0;

import android.content.Context;
import com.repack.bun.miitmdid.core.MdidSdkHelper;
import com.repack.bun.supplier.IIdentifierListener;
import com.repack.bun.supplier.IdSupplier;
import com.sntech.stat.Cdo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RepackMsaManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21716f;

    public void a(Context context) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.f21715e = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: t0.a
            @Override // com.repack.bun.supplier.IIdentifierListener
            public final void OnSupport(boolean z2, IdSupplier idSupplier) {
                this.a.a(jCurrentTimeMillis, z2, idSupplier);
            }
        });
        boolean z2 = Cdo.f125do;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j2, boolean z2, IdSupplier idSupplier) {
        if (idSupplier != null && idSupplier.isSupported()) {
            this.a = idSupplier.getOAID();
            this.b = idSupplier.getVAID();
            this.f21713c = idSupplier.getAAID();
            this.f21716f = idSupplier.isSupported();
        }
        this.f21714d = System.currentTimeMillis() - j2;
        boolean z3 = Cdo.f125do;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", this.f21715e);
        jSONObject.put("isSupported", this.f21716f);
        jSONObject.put("oaid", this.a);
        jSONObject.put("vaid", this.b);
        jSONObject.put("aaid", this.f21713c);
        jSONObject.put("takeMs", this.f21714d);
        return jSONObject;
    }
}
