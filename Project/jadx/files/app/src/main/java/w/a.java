package w;

import android.content.Context;
import android.os.IBinder;
import com.repack.asus.msa.sdid.SupplementaryDIDManager;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0021a.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements InnerIdSupplier, y.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SupplierListener f21726s;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SupplementaryDIDManager f21731x;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f21727t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f21728u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f21729v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f21730w = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21732y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21733z = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f21726s = supplierListener;
        this.f21731x = new SupplementaryDIDManager(context);
    }

    public void a(p.a aVar) {
        try {
            String udid = aVar.getUDID();
            this.f21727t = udid;
            if (udid == null) {
                this.f21727t = "";
            }
        } catch (Exception unused) {
        }
        try {
            String oaid = aVar.getOAID();
            this.f21728u = oaid;
            if (oaid == null) {
                this.f21728u = "";
            }
        } catch (Exception unused2) {
        }
        try {
            String vaid = aVar.getVAID();
            this.f21729v = vaid;
            if (vaid == null) {
                this.f21729v = "";
            }
        } catch (Exception unused3) {
        }
        try {
            String aaid = aVar.getAAID();
            this.f21730w = aaid;
            if (aaid == null) {
                this.f21730w = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f21733z = aVar.h();
        } catch (Exception unused5) {
        }
        this.f21732y = true;
        SupplierListener supplierListener = this.f21726s;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.f21733z, this);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return false;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getAAID() {
        return this.f21730w;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getOAID() {
        return this.f21728u;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return this.f21727t;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public String getVAID() {
        return this.f21729v;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        return this.f21733z;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        if (!this.f21732y || (supplementaryDIDManager = this.f21731x) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
        this.f21731x.init(this);
    }
}
