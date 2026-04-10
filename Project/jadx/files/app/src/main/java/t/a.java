package t;

import android.content.Context;
import android.os.Build;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import x0.b;

/* JADX INFO: compiled from: C0033a.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f21699s;

    /* JADX INFO: renamed from: t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: C0033a.java */
    public class RunnableC0598a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final SupplierListener f21700s;

        public RunnableC0598a(SupplierListener supplierListener) {
            this.f21700s = supplierListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SupplierListener supplierListener = this.f21700s;
                if (supplierListener == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    supplierListener.OnSupport(false, new DefaultSupplier());
                } else {
                    a.this.getClass();
                    supplierListener.OnSupport(x0.a.b, a.this);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(Context context) {
        o.a.a(context);
        this.f21699s = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        new Thread(new RunnableC0598a(supplierListener)).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        try {
            String strA = (x0.a.a && x0.a.b) ? b.a.a.a(x0.a.a(this.f21699s), "AUID") : "";
            return strA == null ? "" : strA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        try {
            String strA = (x0.a.a && x0.a.b) ? b.a.a.a(x0.a.a(this.f21699s), "OUID") : "";
            return strA == null ? "" : strA;
        } catch (Exception e2) {
            e2.printStackTrace();
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
            String strA = (x0.a.a && x0.a.b) ? b.a.a.a(x0.a.a(this.f21699s), "DUID") : "";
            return strA == null ? "" : strA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        return x0.a.b;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
