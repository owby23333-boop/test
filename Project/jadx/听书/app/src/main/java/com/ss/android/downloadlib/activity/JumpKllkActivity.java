package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.gz;
import com.ss.android.downloadlib.gc.dl;

/* JADX INFO: loaded from: classes4.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void z() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            dl.z().z("handleIntent is null");
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            dl.z().z("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            gz.z((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
            return;
        }
        int iOptInt = wp.fo().optInt("ab", 0);
        gz.z(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
    }
}
