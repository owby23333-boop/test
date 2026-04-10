package com.github.gzuliyujiang.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;
import com.github.gzuliyujiang.oaid.impl.OAIDService;
import repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes3.dex */
class HuaweiImpl implements IOAID {
    private final Context context;
    private String packageName;

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.packageName = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.packageName = "com.huawei.hwid.tv";
            } else {
                this.packageName = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
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
        try {
            String string = Settings.Global.getString(this.context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                OAIDLog.print("Get oaid from global settings: " + string);
                getter.onOAIDGetComplete(string);
                return;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            getter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, getter, new OAIDService.RemoteCaller() { // from class: com.github.gzuliyujiang.oaid.impl.HuaweiImpl.1
            @Override // com.github.gzuliyujiang.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder service) throws OAIDException, RemoteException {
                OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(service);
                if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                    throw new OAIDException("User has disabled advertising identifier");
                }
                return openDeviceIdentifierServiceAsInterface.getOaid();
            }
        });
    }
}
