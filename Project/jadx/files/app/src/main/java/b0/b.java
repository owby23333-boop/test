package b0;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0045b.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f609s;

    public b(Context context) {
        this.f609s = context;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public boolean mo6do() {
        return true;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        String strA = a.a(this.f609s, a.f608e);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        String strA = a.a(this.f609s, a.f606c);
        return strA == null ? "" : strA;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        String strA = a.a(this.f609s, a.f607d);
        return strA == null ? "" : strA;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        return (a.b == null || a.a == null) ? false : true;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
    }
}
