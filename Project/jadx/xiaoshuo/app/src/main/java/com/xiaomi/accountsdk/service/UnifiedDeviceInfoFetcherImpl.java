package com.xiaomi.accountsdk.service;

import android.content.Context;
import android.os.Bundle;
import com.xiaomi.accountsdk.account.data.Constants;
import com.xiaomi.accountsdk.hasheddeviceidlib.IUnifiedDeviceIdFetcher;
import com.xiaomi.accountsdk.service.DeviceInfoResult;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.yuewen.pt;

/* JADX INFO: loaded from: classes5.dex */
public class UnifiedDeviceInfoFetcherImpl implements IUnifiedDeviceIdFetcher {
    private static final String TAG = "UnifiedDeviceInfoFetcherImpl";

    @Override // com.xiaomi.accountsdk.hasheddeviceidlib.IUnifiedDeviceIdFetcher
    public String getHashedDeviceId(Context context) {
        DeviceInfoResult deviceInfoRpc;
        for (int i = 0; i < 3 && (deviceInfoRpc = PassportCommonServiceClient.getDeviceInfoRpc(context, Constants.PASSPORT_SID, 1, 5000)) != null; i++) {
            AccountLogger.log(TAG, "getHashedDeviceId>>>errorCode=" + deviceInfoRpc.errorCode);
            DeviceInfoResult.ErrorCode errorCode = deviceInfoRpc.errorCode;
            if (errorCode != DeviceInfoResult.ErrorCode.ERROR_APP_PERMISSION_FORBIDDEN && errorCode != DeviceInfoResult.ErrorCode.ERROR_TIME_OUT && errorCode != DeviceInfoResult.ErrorCode.ERROR_EXECUTION_EXCEPTION) {
                Bundle bundle = deviceInfoRpc.deviceInfo;
                if (bundle != null) {
                    return bundle.getString(DeviceInfoResult.BUNDLE_KEY_HASHED_DEVICE_ID);
                }
                return null;
            }
            AccountLogger.log(TAG, "getHashedDeviceId>>>has no permission, retry " + i);
            try {
                Thread.sleep(pt.f16197b);
            } catch (InterruptedException e) {
                AccountLogger.log(TAG, "getHashedDeviceId>>>has no permission, err  ", e);
                return null;
            }
        }
        return null;
    }
}
