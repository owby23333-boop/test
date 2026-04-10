package com.mibi.sdk.common.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mibi.sdk.common.utils.MibiLog;

/* JADX INFO: loaded from: classes13.dex */
public class AccountInteractActivity extends Activity {
    public static final String KEY_INTENT = "intent";
    public static final String KEY_REQUEST_CODE = "requestCode";
    public static final int REQUEST_CODE_THROTTING = 1001;
    private static final String TAG = "AccountInteractAC";

    public static void startActivity(Context context, Intent intent, int i) {
        Intent intent2 = new Intent(context, (Class<?>) AccountInteractActivity.class);
        intent2.putExtra("intent", intent);
        intent2.putExtra(KEY_REQUEST_CODE, i);
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder("handle result req : ");
        sb.append(i);
        sb.append(" res : ");
        sb.append(i2);
        sb.append(" ; data is null : ");
        sb.append(intent == null);
        MibiLog.d(TAG, sb.toString());
        if (i == 1001) {
            AccountInteractHelper.notifyInteractionResult(i2 == -1);
        } else {
            AccountInteractHelper.notifyInteractionResult(false);
        }
        finish();
    }

    @Override // android.app.Activity
    @SuppressLint({"WrongConstant"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = (Intent) getIntent().getParcelableExtra("intent");
            intent.removeFlags(195);
            int intExtra = getIntent().getIntExtra(KEY_REQUEST_CODE, 1001);
            if (intent != null) {
                MibiLog.d(TAG, "start account throtting intent");
                startActivityForResult(intent, intExtra);
            } else {
                MibiLog.d(TAG, "intent is null");
                AccountInteractHelper.notifyInteractionResult(false);
                finish();
            }
        } catch (Exception e) {
            MibiLog.d(TAG, e.getMessage());
            AccountInteractHelper.notifyInteractionResult(false);
            finish();
        }
    }
}
