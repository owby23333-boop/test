package com.repack.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.Keep;
import com.repack.bun.supplier.SupplierListener;
import p.a;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public Context mContext;
    public p.a mDidService;
    public y.a mListener;
    public boolean isBinded = false;
    public ServiceConnection mServiceConnection = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            p.a c0594a;
            boolean z2 = SupplementaryDIDManager.DEBUG;
            SupplementaryDIDManager supplementaryDIDManager = SupplementaryDIDManager.this;
            int i2 = a.AbstractBinderC0593a.f21661s;
            if (iBinder == null) {
                c0594a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0594a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p.a)) ? new a.AbstractBinderC0593a.C0594a(iBinder) : (p.a) iInterfaceQueryLocalInterface;
            }
            supplementaryDIDManager.mDidService = c0594a;
            SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    }

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(boolean z2) {
        try {
            if (z2) {
                ((w.a) this.mListener).a(this.mDidService);
            } else {
                w.a aVar = (w.a) this.mListener;
                SupplierListener supplierListener = aVar.f21726s;
                if (supplierListener != null) {
                    supplierListener.OnSupport(false, aVar);
                }
            }
        } catch (Exception e2) {
            if (DEBUG) {
                StringBuilder sbA = b.a("notify did bind status error :");
                sbA.append(e2.getMessage());
                sbA.toString();
            }
        }
    }

    public void deInit() {
        try {
            if (!this.isBinded || this.mServiceConnection == null || this.mContext == null) {
                return;
            }
            boolean z2 = DEBUG;
            this.isBinded = false;
            this.mContext.unbindService(this.mServiceConnection);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void init(y.a aVar) {
        try {
            this.mListener = aVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            boolean z2 = DEBUG;
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (Exception unused) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z2) {
        DEBUG = z2;
    }
}
