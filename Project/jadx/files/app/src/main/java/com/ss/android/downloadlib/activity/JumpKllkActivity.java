package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.utils.ko;

/* JADX INFO: loaded from: classes3.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void mb() {
        if (getIntent() == null) {
            b.mb().mb("handleIntent is null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            b.mb().mb("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
        int iOptInt = x.lz().optInt("ab", 0);
        ko.mb(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
    }
}
