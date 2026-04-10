package r0;

import android.os.Parcel;
import android.os.RemoteException;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* JADX INFO: compiled from: C0036b.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements InnerIdSupplier {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f21691s = new a();

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void a(SupplierListener supplierListener) {
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    /* JADX INFO: renamed from: do */
    public boolean mo6do() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getAAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            r0.a r0 = r5.f21691s
            android.os.IBinder r1 = r0.a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 6
            r4 = 0
            r0.transact(r3, r1, r2, r4)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.b.getAAID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getOAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            r0.a r0 = r5.f21691s
            android.os.IBinder r1 = r0.a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 4
            r4 = 0
            r0.transact(r3, r1, r2, r4)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.b.getOAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public String getUDID() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getVAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            r0.a r0 = r5.f21691s
            android.os.IBinder r1 = r0.a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 5
            r4 = 0
            r0.transact(r3, r1, r2, r4)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.b.getVAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public boolean isSupported() {
        a aVar = this.f21691s;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public void shutDown() {
        a aVar = this.f21691s;
        if (aVar != null) {
            if (aVar.a != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    try {
                        aVar.a.transact(7, parcelObtain, parcelObtain2, 0);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
            this.f21691s = null;
        }
    }
}
