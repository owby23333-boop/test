package com.msa.sdk.core.feedback;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;
import com.msa.sdk.tool.MsaUtils;
import com.xiaomi.ad.feedback.IAdFeedbackListener;
import com.xiaomi.ad.feedback.IAdFeedbackService;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DislikeManager {
    private static final String TAG = "DislikeManager";

    private DislikeManager() {
    }

    private static Intent buildIntent(Context context) {
        Intent intent = new Intent("miui.intent.action.ad.FEEDBACK_SERVICE");
        intent.setPackage(MsaUtils.getMsaPackageName(context));
        return intent;
    }

    public static boolean isSupport(Context context) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(buildIntent(context), 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    public static void showDislikeWindow(final Context context, final IAdFeedbackListener iAdFeedbackListener, final String str, final String str2, final String str3) {
        if (context.bindService(buildIntent(context), new ServiceConnection() { // from class: com.msa.sdk.core.feedback.DislikeManager.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    try {
                        IAdFeedbackService.Stub.asInterface(iBinder).showFeedbackWindowAndTrackResult(iAdFeedbackListener, str, str2, str3);
                    } catch (Exception e) {
                        Log.e(DislikeManager.TAG, "show dislike window exception", e);
                    }
                } finally {
                    context.unbindService(this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1)) {
            return;
        }
        Log.e(TAG, "bind service fail");
    }

    public static void showDislikeWindow(final Context context, final IAdFeedbackListener iAdFeedbackListener, final String str, final String str2, final List<String> list) {
        if (context.bindService(buildIntent(context), new ServiceConnection() { // from class: com.msa.sdk.core.feedback.DislikeManager.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    try {
                        IAdFeedbackService.Stub.asInterface(iBinder).showFeedbackWindowAndTrackResultForMultiAds(iAdFeedbackListener, str, str2, list);
                    } catch (Exception e) {
                        Log.e(DislikeManager.TAG, "show dislike window with passbacks exception", e);
                    }
                } finally {
                    context.unbindService(this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1)) {
            return;
        }
        Log.e(TAG, "bind service fail");
    }
}
