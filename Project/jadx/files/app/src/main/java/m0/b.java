package m0;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;
import com.repack.bun.miitmdid.supplier.msa.MsaClient;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0051b.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements InnerIdSupplier, e.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SupplierListener f21072s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public MsaClient f21073t;

    public b(Context context) {
        if (MsaClient.CheckService(context)) {
            String strC = sysParamters.c();
            if (!TextUtils.isEmpty(strC)) {
                MsaClient.StartMsaKlService(context, strC);
            }
            this.f21073t = new MsaClient(context, this);
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f21072s = supplierListener;
        MsaClient msaClient = this.f21073t;
        if (msaClient != null) {
            msaClient.BindService(sysParamters.c());
        } else {
            d();
        }
    }

    @Override // e.a
    public void d() {
        SupplierListener supplierListener = this.f21072s;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, new DefaultSupplier());
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        String aaid;
        return (!isSupported() || (aaid = this.f21073t.getAAID()) == null) ? "" : aaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        String oaid;
        return (!isSupported() || (oaid = this.f21073t.getOAID()) == null) ? "" : oaid;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        String udid;
        return (!isSupported() || (udid = this.f21073t.getUDID()) == null) ? "" : udid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        String vaid;
        return (!isSupported() || (vaid = this.f21073t.getVAID()) == null) ? "" : vaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        MsaClient msaClient = this.f21073t;
        if (msaClient != null) {
            return msaClient.isSupported();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
        MsaClient msaClient = this.f21073t;
        if (msaClient != null) {
            msaClient.shutdown();
        }
    }

    @Override // e.a
    public void a(boolean z2) {
        SupplierListener supplierListener = this.f21072s;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }
}
