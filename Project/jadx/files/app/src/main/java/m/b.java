package m;

import android.content.Context;
import com.repack.bun.lib.sysParamters;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import v.c;

/* JADX INFO: compiled from: C0031b.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f21069s;

    /* JADX INFO: compiled from: C0031b.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final SupplierListener f21070s;

        public a(SupplierListener supplierListener) {
            this.f21070s = supplierListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SupplierListener supplierListener = this.f21070s;
                if (supplierListener != null) {
                    supplierListener.OnSupport(b.this.isSupported(), b.this);
                }
            } catch (Exception e2) {
                c.b("buniasuplier", "exception", e2);
            }
        }
    }

    public b(Context context) {
        this.f21069s = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        new Thread(new a(supplierListener)).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        try {
            return m.a.a(this.f21069s, sysParamters.c());
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        try {
            return m.a.b(this.f21069s);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        try {
            return m.a.b(this.f21069s, sysParamters.c());
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return m.a.a(this.f21069s);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
