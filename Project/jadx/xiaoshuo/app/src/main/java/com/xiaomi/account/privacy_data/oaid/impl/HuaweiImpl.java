package com.xiaomi.account.privacy_data.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.account.privacy_data.oaid.IGetter;
import com.xiaomi.account.privacy_data.oaid.IOAID;
import com.xiaomi.account.privacy_data.oaid.OAIDException;
import com.xiaomi.account.privacy_data.oaid.OAIDLog;
import com.xiaomi.account.privacy_data.oaid.OAIDService;
import repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes5.dex */
public class HuaweiImpl implements IOAID {
    private final Context context;
    private String packageName;

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    @Override // com.xiaomi.account.privacy_data.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            if (!TextUtils.isEmpty(string)) {
                OAIDLog.print("Get oaid from global settings: " + string);
                iGetter.onOAIDGetComplete(string);
                return;
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
        if (TextUtils.isEmpty(this.packageName) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.packageName);
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.xiaomi.account.privacy_data.oaid.impl.HuaweiImpl.1
            @Override // com.xiaomi.account.privacy_data.oaid.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
                OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                    throw new OAIDException("User has disabled advertising identifier");
                }
                return openDeviceIdentifierServiceAsInterface.getOaid();
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
}
