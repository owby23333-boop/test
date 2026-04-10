package v0;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import com.repack.huawei.hms.ads.identifier.AdvertisingIdClient;
import v.c;

/* JADX INFO: compiled from: C0023a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f21721s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f21722t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f21723u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SupplierListener f21724v;

    /* JADX INFO: renamed from: v0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: C0023a.java */
    public class RunnableC0602a implements Runnable {
        public RunnableC0602a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(a.this.f21721s);
                a.this.f21722t = advertisingIdInfo.getId();
                advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception e2) {
                c.b(a.class.getSimpleName(), "thread", e2);
            }
            a aVar = a.this;
            aVar.getClass();
            try {
                boolean z2 = !TextUtils.isEmpty(aVar.f21722t);
                aVar.f21723u = z2;
                if (z2) {
                    SupplierListener supplierListener = aVar.f21724v;
                    if (supplierListener != null) {
                        supplierListener.OnSupport(z2, aVar);
                    }
                } else {
                    SupplierListener supplierListener2 = aVar.f21724v;
                    if (supplierListener2 != null) {
                        supplierListener2.OnSupport(z2, new DefaultSupplier());
                    }
                }
            } catch (Exception e3) {
                c.b(a.class.getSimpleName(), "CallBack", e3);
            }
        }
    }

    public a(Context context) {
        this.f21721s = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f21724v = supplierListener;
        new Thread(new RunnableC0602a()).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        TextUtils.isEmpty("");
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        return this.f21722t;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        return this.f21723u;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
