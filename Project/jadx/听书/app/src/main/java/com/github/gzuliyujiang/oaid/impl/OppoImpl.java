package com.github.gzuliyujiang.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;
import com.github.gzuliyujiang.oaid.impl.OAIDService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: loaded from: classes3.dex */
class OppoImpl implements IOAID {
    private final Context context;
    private String sign;

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public void doGet(final IGetter getter) {
        if (this.context == null || getter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        OAIDService.bind(this.context, intent, getter, new OAIDService.RemoteCaller() { // from class: com.github.gzuliyujiang.oaid.impl.OppoImpl.1
            @Override // com.github.gzuliyujiang.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder service) throws OAIDException, RemoteException {
                try {
                    return OppoImpl.this.realGetOUID(service);
                } catch (RemoteException e) {
                    throw e;
                } catch (OAIDException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new OAIDException(e3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String realGetOUID(IBinder service) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.context.getPackageName();
        String str = this.sign;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.sign = string;
            return getSerId(service, packageName, string);
        }
        return getSerId(service, packageName, str);
    }

    private String getSerId(IBinder service, String pkgName, String sign) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(service);
        if (iOpenIDAsInterface == null) {
            throw new OAIDException("IOpenID is null");
        }
        return iOpenIDAsInterface.getSerID(pkgName, sign, "OUID");
    }
}
