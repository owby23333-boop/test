package com.xiaomi.account.privacy_data.oaid.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import com.xiaomi.account.privacy_data.oaid.OAIDService;
import com.yuewen.yg3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: loaded from: classes5.dex */
public class OppoImpl implements IOAID {
    private final Context context;
    private String sign;

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
    }

    private String getSerId(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String realGetOUID(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, OAIDException, RemoteException {
        String packageName = this.context.getPackageName();
        String str = this.sign;
        if (str != null) {
            return getSerId(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance(yg3.b.f20351b).digest(this.context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArrDigest) {
            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.sign = string;
        return getSerId(iBinder, packageName, string);
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.OppoImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                try {
                    return OppoImpl.this.realGetOUID(iBinder);
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

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
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
}
