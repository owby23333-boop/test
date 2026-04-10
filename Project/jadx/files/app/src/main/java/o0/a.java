package o0;

import android.content.Context;
import com.repack.bun.miitmdid.supplier.sumsung.SumsungCore;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0053a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements InnerIdSupplier, e.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SupplierListener f21267s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SumsungCore f21268t;

    public a(Context context, SupplierListener supplierListener) {
        this.f21267s = supplierListener;
        this.f21268t = new SumsungCore(context, this);
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // e.a
    public void a(boolean z2) {
        SupplierListener supplierListener = this.f21267s;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // e.a
    public void d() {
        SupplierListener supplierListener = this.f21267s;
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
        return (!isSupported() || (aaid = this.f21268t.getAAID()) == null) ? "" : aaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        String oaid;
        return (!isSupported() || (oaid = this.f21268t.getOAID()) == null) ? "" : oaid;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        String udid;
        return (!isSupported() || (udid = this.f21268t.getUDID()) == null) ? "" : udid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        String vaid;
        return (!isSupported() || (vaid = this.f21268t.getVAID()) == null) ? "" : vaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        SumsungCore sumsungCore = this.f21268t;
        if (sumsungCore != null) {
            return sumsungCore.isSupported();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
        SumsungCore sumsungCore = this.f21268t;
        if (sumsungCore != null) {
            sumsungCore.shutdown();
        }
    }
}
