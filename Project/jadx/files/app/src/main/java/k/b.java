package k;

import android.content.Context;
import android.os.RemoteException;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0029b.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements InnerIdSupplier, e.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f20926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SupplierListener f20927t;

    public b(Context context, SupplierListener supplierListener) {
        this.f20927t = supplierListener;
        this.f20926s = new a(context, this);
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // e.a
    public void a(boolean z2) {
        SupplierListener supplierListener = this.f20927t;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // e.a
    public void d() {
        SupplierListener supplierListener = this.f20927t;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getAAID() {
        /*
            r4 = this;
            boolean r0 = r4.isSupported()
            java.lang.String r1 = ""
            if (r0 == 0) goto L30
            k.a r0 = r4.f20926s
            android.content.Context r2 = r0.a
            if (r2 == 0) goto L28
            java.lang.String r2 = r2.getPackageName()
            if (r2 == 0) goto L24
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L1b
            goto L24
        L1b:
            c.a r0 = r0.b     // Catch: android.os.RemoteException -> L24
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.getAAID(r2)     // Catch: android.os.RemoteException -> L24
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L30
            goto L31
        L28:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L30:
            r0 = r1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.getAAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        c.a aVar;
        if (isSupported()) {
            a aVar2 = this.f20926s;
            if (aVar2.a == null) {
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                aVar = aVar2.b;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            String oaid = aVar != null ? aVar.getOAID() : null;
            if (oaid != null) {
                return oaid;
            }
        }
        return "";
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        c.a aVar;
        if (isSupported()) {
            a aVar2 = this.f20926s;
            if (aVar2.a == null) {
                throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
            }
            try {
                aVar = aVar2.b;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
            String udid = aVar != null ? aVar.getUDID() : null;
            if (udid != null) {
                return udid;
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getVAID() {
        /*
            r4 = this;
            boolean r0 = r4.isSupported()
            java.lang.String r1 = ""
            if (r0 == 0) goto L34
            k.a r0 = r4.f20926s
            android.content.Context r2 = r0.a
            if (r2 == 0) goto L2c
            java.lang.String r2 = r2.getPackageName()
            if (r2 == 0) goto L28
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L1b
            goto L28
        L1b:
            c.a r0 = r0.b     // Catch: android.os.RemoteException -> L24
            if (r0 == 0) goto L28
            java.lang.String r0 = r0.getVAID(r2)     // Catch: android.os.RemoteException -> L24
            goto L29
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L34
            goto L35
        L2c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L34:
            r0 = r1
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.b.getVAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        a aVar = this.f20926s;
        if (aVar == null) {
            return false;
        }
        try {
            c.a aVar2 = aVar.b;
            if (aVar2 == null) {
                return false;
            }
            return aVar2.i();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
        a aVar = this.f20926s;
        if (aVar != null) {
            try {
                aVar.a.unbindService(aVar.f20923c);
            } catch (IllegalArgumentException unused) {
            }
            aVar.b = null;
        }
    }
}
