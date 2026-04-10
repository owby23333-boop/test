package i;

import android.content.Context;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import j0.b;

/* JADX INFO: compiled from: C0026a.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f20838s;

    public a(Context context) {
        this.f20838s = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return true;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        try {
            Context context = this.f20838s;
            j0.a aVarA = j0.a.a();
            return aVarA.a(context.getApplicationContext(), aVarA.f20914c);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        try {
            Context context = this.f20838s;
            j0.a aVarA = j0.a.a();
            return aVarA.a(context.getApplicationContext(), aVarA.b);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        try {
            Context context = this.f20838s;
            j0.a aVarA = j0.a.a();
            return aVarA.a(context.getApplicationContext(), aVarA.a);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        try {
            Context context = this.f20838s;
            j0.a aVarA = j0.a.a();
            return aVarA.a(context.getApplicationContext(), aVarA.f20915d);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        try {
            return b.a();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
