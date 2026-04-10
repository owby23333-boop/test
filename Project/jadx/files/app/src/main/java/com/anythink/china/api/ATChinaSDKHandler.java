package com.anythink.china.api;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.anythink.china.activity.TransparentActivity;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.Random;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes2.dex */
public class ATChinaSDKHandler {
    private static boolean allowUserOaidSDK = true;

    public static void handleInitOaidSDK(Context context, final OaidSDKCallbackListener oaidSDKCallbackListener) {
        try {
            if (allowUserOaidSDK) {
                MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.anythink.china.api.ATChinaSDKHandler.1
                    public void OnSupport(boolean z2, IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = oaidSDKCallbackListener;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.OnSupport(z2, idSupplier);
                        }
                    }

                    public void onSupport(IdSupplier idSupplier) {
                        OaidSDKCallbackListener oaidSDKCallbackListener2 = oaidSDKCallbackListener;
                        if (oaidSDKCallbackListener2 != null) {
                            oaidSDKCallbackListener2.onSupport(idSupplier);
                        }
                    }
                });
            } else if (oaidSDKCallbackListener != null) {
                oaidSDKCallbackListener.OnSupport(false, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void requestPermissionIfNecessary(Context context) {
        String[] strArr = {"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (context == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        int iNextInt = new Random().nextInt(Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        Intent intent = new Intent(context, (Class<?>) TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(TransparentActivity.b, iNextInt);
        intent.putExtra(TransparentActivity.f6352d, strArr);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public static void setAllowUseMdidSDK(boolean z2) {
        allowUserOaidSDK = z2;
    }
}
