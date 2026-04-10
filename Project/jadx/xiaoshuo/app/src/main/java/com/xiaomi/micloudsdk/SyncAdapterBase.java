package com.xiaomi.micloudsdk;

import android.accounts.Account;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SyncResult;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.exception.CloudServerException;
import com.xiaomi.micloudsdk.utils.CloudUtils;

/* JADX INFO: loaded from: classes8.dex */
public abstract class SyncAdapterBase extends AbstractThreadedSyncAdapter {
    public static final String ACTION_RESUME_SYNC = "com.miui.net.RESUME_SYNC";
    private static final int BAD_REQUEST_LIMIT_PER_DAY = 100;
    public static final String PREF_RESUME_SYNC_TIME = "ResumeSyncTime_%s";
    private static final String PREF_TOKEN_EXPIRED_COUNT = "TokenExpiredCount_%s";
    private static final String PREF_TOKEN_EXPIRED_DAY = "TokenExpiredDay_%s";
    private static final int RESUME_SYNC_INTERVAL = 300000;
    private static final int RESUME_SYNC_INTERVAL_LONG = 1800000;
    private static final String TAG = "MiCloudSyncAdapterBase";
    protected Account mAccount;
    protected final String mAuthType;
    protected String mAuthority;
    protected Context mContext;
    protected ExtendedAuthToken mExtToken;
    protected String mExtTokenStr;
    protected String[] mNumbers;
    protected ContentResolver mResolver;
    protected SyncResult mSyncResult;
    protected String[] mTickets;

    public SyncAdapterBase(Context context, boolean z, String str) {
        super(context, z);
        this.mTickets = new String[2];
        this.mNumbers = new String[2];
        this.mContext = context;
        this.mResolver = context.getContentResolver();
        this.mAuthType = str;
    }

    private void handleBadRequest() {
        Log.w(TAG, "Http bad request error. Suspending sync.");
        suspendSync(300000);
    }

    private void handleForbidden() {
        Log.w(TAG, "Http forbidden error. Suspend sync.");
        suspendSync(RESUME_SYNC_INTERVAL_LONG);
    }

    private void handleNotAcceptable() {
        Log.w(TAG, "Http not-acceptable error. Suspend sync.");
        suspendSync(RESUME_SYNC_INTERVAL_LONG);
    }

    private void handleUnauthorized() {
        int i = 0;
        String str = String.format(PREF_TOKEN_EXPIRED_COUNT, this.mAuthority);
        String str2 = String.format(PREF_TOKEN_EXPIRED_DAY, this.mAuthority);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        long j = defaultSharedPreferences.getLong(str2, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 86400000;
        int i2 = (jCurrentTimeMillis == j ? defaultSharedPreferences.getInt(str, 0) : 0) + 1;
        Log.w(TAG, "Http unauthorized error: " + i2 + " times today.");
        if (i2 >= 100) {
            Log.w(TAG, "Http unauthorized error reached limit. Suspend sync.");
            suspendSync(RESUME_SYNC_INTERVAL_LONG);
        } else {
            i = i2;
        }
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putLong(str2, jCurrentTimeMillis);
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    private void suspendSync(int i) {
        ContentResolver.cancelSync(this.mAccount, this.mAuthority);
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i);
        Intent intent = new Intent(ACTION_RESUME_SYNC);
        intent.putExtra(Intents.EXTRA_AUTHORITY, this.mAuthority);
        intent.putExtra("account", this.mAccount);
        alarmManager.set(1, jCurrentTimeMillis, PendingIntent.getBroadcast(this.mContext, 0, intent, 67108864));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String str = String.format(PREF_RESUME_SYNC_TIME, this.mAuthority);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putLong(str, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public abstract String getErrorTitle();

    public abstract String getForbiddenErrorText();

    public abstract String getNotAcceptableErrorText();

    public int getSyncMode() {
        return CloudUtils.getSyncMode();
    }

    public abstract String getUnauthorizedErrorText();

    public abstract void onPerformMiCloudSync(Bundle bundle) throws CloudServerException;

    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015d A[EDGE_INSN: B:77:0x015d->B:57:0x015d BREAK  A[LOOP:0: B:15:0x00a2->B:79:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // android.content.AbstractThreadedSyncAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPerformSync(android.accounts.Account r18, android.os.Bundle r19, java.lang.String r20, android.content.ContentProviderClient r21, android.content.SyncResult r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.micloudsdk.SyncAdapterBase.onPerformSync(android.accounts.Account, android.os.Bundle, java.lang.String, android.content.ContentProviderClient, android.content.SyncResult):void");
    }
}
