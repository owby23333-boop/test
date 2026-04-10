package com.msa.sdk.core.feedback;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.msa.sdk.tool.MsaUtils;
import com.msa.sdk.tool.RemoteMethodInvoker;
import com.msa.sdk.tool.TaskRunner;
import com.xiaomi.ad.feedback.IAdFeedbackListener;
import com.xiaomi.ad.feedback.IAdFeedbackService;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DislikeManagerV2 {
    private static final String TAG = "DislikeManagerV2";
    private static volatile DislikeManagerV2 sManager;
    private Context mContext;

    private DislikeManagerV2(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (applicationContext == null) {
            this.mContext = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent buildIntent() {
        Intent intent = new Intent("miui.intent.action.ad.FEEDBACK_SERVICE");
        intent.setPackage(MsaUtils.getMsaPackageName(this.mContext));
        return intent;
    }

    public static DislikeManagerV2 getInstance(Context context) {
        if (sManager == null) {
            synchronized (DislikeManagerV2.class) {
                if (sManager == null) {
                    sManager = new DislikeManagerV2(context);
                }
            }
        }
        return sManager;
    }

    private boolean isSupported() {
        List<ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(buildIntent(), 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    public void showDislikeWindow(final IAdFeedbackListener iAdFeedbackListener, final String str, final String str2, final String str3) {
        if (isSupported()) {
            TaskRunner.CACHED_EXECUTOR.execute(new Runnable() { // from class: com.msa.sdk.core.feedback.DislikeManagerV2.1
                @Override // java.lang.Runnable
                public void run() {
                    new RemoteMethodInvoker<Void, IAdFeedbackService>(DislikeManagerV2.this.mContext, IAdFeedbackService.class) { // from class: com.msa.sdk.core.feedback.DislikeManagerV2.1.1
                        @Override // com.msa.sdk.tool.RemoteMethodInvoker
                        public Void innerInvoke(IAdFeedbackService iAdFeedbackService) {
                            try {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                iAdFeedbackService.showFeedbackWindowAndTrackResult(iAdFeedbackListener, str, str2, str3);
                                return null;
                            } catch (Exception e) {
                                Log.e(DislikeManagerV2.TAG, "showDislikeWindows: ", e);
                                return null;
                            }
                        }
                    }.invoke(DislikeManagerV2.this.buildIntent());
                }
            });
        }
    }

    public void showDislikeWindow(final IAdFeedbackListener iAdFeedbackListener, final String str, final String str2, final List<String> list) {
        if (isSupported()) {
            TaskRunner.CACHED_EXECUTOR.execute(new Runnable() { // from class: com.msa.sdk.core.feedback.DislikeManagerV2.2
                @Override // java.lang.Runnable
                public void run() {
                    new RemoteMethodInvoker<Void, IAdFeedbackService>(DislikeManagerV2.this.mContext, IAdFeedbackService.class) { // from class: com.msa.sdk.core.feedback.DislikeManagerV2.2.1
                        @Override // com.msa.sdk.tool.RemoteMethodInvoker
                        public Void innerInvoke(IAdFeedbackService iAdFeedbackService) {
                            try {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                iAdFeedbackService.showFeedbackWindowAndTrackResultForMultiAds(iAdFeedbackListener, str, str2, list);
                                return null;
                            } catch (Exception e) {
                                Log.e(DislikeManagerV2.TAG, "showDislikeWindows: ", e);
                                return null;
                            }
                        }
                    }.invoke(DislikeManagerV2.this.buildIntent());
                }
            });
        }
    }
}
