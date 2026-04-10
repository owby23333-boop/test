package com.github.gzuliyujiang.oaid.g;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: compiled from: OppoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements com.github.gzuliyujiang.oaid.d {
    private final Context a;
    private String b;

    /* JADX INFO: compiled from: OppoImpl.java */
    class a implements m.a {
        a() {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return n.this.a(iBinder);
            } catch (RemoteException e2) {
                throw e2;
            } catch (OAIDException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new OAIDException(e4);
            }
        }
    }

    public n(Context context) {
        if (context instanceof Application) {
            this.a = context;
        } else {
            this.a = context.getApplicationContext();
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.a, intent, cVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            this.b = sb.toString();
            return a(iBinder, packageName, this.b);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
