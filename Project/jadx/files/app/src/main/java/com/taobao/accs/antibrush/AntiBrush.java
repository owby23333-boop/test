package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.g;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost = null;
    private static volatile boolean mIsInCheckCodeActivity = false;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    /* JADX INFO: compiled from: Taobao */
    public static class AntiReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                try {
                    String stringExtra = intent.getStringExtra("Result");
                    ALog.e(AntiBrush.TAG, "anti onReceive result: " + stringExtra, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), stringExtra.equalsIgnoreCase("success"));
                } catch (Exception e2) {
                    ALog.e(AntiBrush.TAG, "anti onReceive", e2, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                }
            } catch (Throwable th) {
                AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                throw th;
            }
        }
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void handleantiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleantiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
        } catch (Throwable th) {
            ALog.e(TAG, "handleantiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z2) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z2);
        g.a().b(context, intent);
        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            mTimeoutTask = null;
        }
        String str = mHost;
        if (str != null) {
            UtilityImpl.b(context, b.a(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkAntiBrush(java.net.URL r8, java.util.Map<java.lang.Integer, java.lang.String> r9) {
        /*
            r7 = this;
            r0 = 1
            java.lang.String r1 = "AntiBrush"
            r2 = 0
            if (r9 == 0) goto L8a
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L87
            boolean r3 = com.taobao.accs.utl.UtilityImpl.i(r3)     // Catch: java.lang.Throwable -> L87
            if (r3 == 0) goto L8a
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r3 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_STATUS     // Catch: java.lang.Throwable -> L87
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L87
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L87
            java.lang.Object r3 = r9.get(r3)     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L87
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L87
            if (r4 == 0) goto L26
            r3 = 0
            goto L2e
        L26:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L87
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L87
        L2e:
            r4 = 419(0x1a3, float:5.87E-43)
            if (r3 != r4) goto L8a
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r3 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_LOCATION     // Catch: java.lang.Throwable -> L87
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L87
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L87
            java.lang.Object r9 = r9.get(r3)     // Catch: java.lang.Throwable -> L87
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L87
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L87
            if (r3 != 0) goto L8a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87
            r3.<init>()     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = "start anti bursh location:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L87
            r3.append(r9)     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L87
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L87
            com.taobao.accs.utl.ALog.e(r1, r3, r4)     // Catch: java.lang.Throwable -> L87
            r7.handleantiBrush(r9)     // Catch: java.lang.Throwable -> L87
            java.util.concurrent.ScheduledFuture<?> r9 = com.taobao.accs.antibrush.AntiBrush.mTimeoutTask     // Catch: java.lang.Throwable -> L87
            r3 = 0
            if (r9 == 0) goto L6d
            java.util.concurrent.ScheduledFuture<?> r9 = com.taobao.accs.antibrush.AntiBrush.mTimeoutTask     // Catch: java.lang.Throwable -> L87
            r9.cancel(r0)     // Catch: java.lang.Throwable -> L87
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r3     // Catch: java.lang.Throwable -> L87
        L6d:
            com.taobao.accs.antibrush.a r9 = new com.taobao.accs.antibrush.a     // Catch: java.lang.Throwable -> L87
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L87
            r4 = 60000(0xea60, double:2.9644E-319)
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L87
            java.util.concurrent.ScheduledFuture r9 = com.taobao.accs.common.ThreadPoolExecutorFactory.schedule(r9, r4, r6)     // Catch: java.lang.Throwable -> L87
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r9     // Catch: java.lang.Throwable -> L87
            if (r8 != 0) goto L80
            goto L84
        L80:
            java.lang.String r3 = r8.getHost()     // Catch: java.lang.Throwable -> L87
        L84:
            com.taobao.accs.antibrush.AntiBrush.mHost = r3     // Catch: java.lang.Throwable -> L87
            goto L8b
        L87:
            r8 = move-exception
            r0 = 0
            goto Lad
        L8a:
            r0 = 0
        L8b:
            java.lang.String r8 = com.taobao.accs.client.GlobalClientInfo.f18117c     // Catch: java.lang.Throwable -> Lac
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lac
            if (r8 != 0) goto Lb4
            java.lang.String r8 = com.taobao.accs.antibrush.AntiBrush.mHost     // Catch: java.lang.Throwable -> Lac
            java.lang.String r8 = com.taobao.accs.antibrush.b.a(r8)     // Catch: java.lang.Throwable -> Lac
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lac
            if (r8 == 0) goto Lb4
            java.lang.String r8 = "cookie invalid, clear"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lac
            com.taobao.accs.utl.ALog.e(r1, r8, r9)     // Catch: java.lang.Throwable -> Lac
            android.content.Context r8 = r7.mContext     // Catch: java.lang.Throwable -> Lac
            com.taobao.accs.utl.UtilityImpl.o(r8)     // Catch: java.lang.Throwable -> Lac
            goto Lb4
        Lac:
            r8 = move-exception
        Lad:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r2 = "checkAntiBrush error"
            com.taobao.accs.utl.ALog.e(r1, r2, r8, r9)
        Lb4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.antibrush.AntiBrush.checkAntiBrush(java.net.URL, java.util.Map):boolean");
    }
}
