package w0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import v.c;

/* JADX INFO: compiled from: C0037a.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f21734s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Context f21735t;

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: C0037a.java */
    public class RunnableC0603a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final SupplierListener f21736s;

        public RunnableC0603a(SupplierListener supplierListener) {
            this.f21736s = supplierListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SupplierListener supplierListener = this.f21736s;
                if (supplierListener == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 28) {
                    supplierListener.OnSupport(false, new DefaultSupplier());
                } else {
                    supplierListener.OnSupport(a.this.isSupported(), a.this);
                }
            } catch (Exception e2) {
                c.b("vivosuplier", "exception", e2);
            }
        }
    }

    public a(Context context) {
        this.f21735t = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        new Thread(new RunnableC0603a(supplierListener)).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        String str;
        Context context = this.f21735t;
        String str2 = this.f21734s;
        d1.c cVarA = d1.c.a(context);
        cVarA.getClass();
        if (d1.c.b) {
            String str3 = d1.c.f20781n;
            if (str3 != null) {
                str = str3;
            } else {
                cVarA.a(2, str2);
                if (d1.c.f20774g == null && d1.c.f20781n != null) {
                    d1.c.a(d1.c.a, 2, str2);
                }
                str = d1.c.f20781n;
            }
        } else {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        d1.c cVarA = d1.c.a(this.f21735t);
        cVarA.getClass();
        String str = null;
        if (d1.c.b) {
            String str2 = d1.c.f20779l;
            if (str2 != null) {
                str = str2;
            } else {
                cVarA.a(0, null);
                if (d1.c.f20772e == null) {
                    d1.c.a(d1.c.a, 0, null);
                }
                str = d1.c.f20779l;
            }
        }
        return str == null ? "" : str;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        String str;
        Context context = this.f21735t;
        String str2 = this.f21734s;
        d1.c cVarA = d1.c.a(context);
        cVarA.getClass();
        if (d1.c.b) {
            String str3 = d1.c.f20780m;
            if (str3 != null) {
                str = str3;
            } else {
                cVarA.a(1, str2);
                if (d1.c.f20773f == null && d1.c.f20780m != null) {
                    d1.c.a(d1.c.a, 1, str2);
                }
                str = d1.c.f20780m;
            }
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        d1.c.a(this.f21735t).getClass();
        return d1.c.b;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
