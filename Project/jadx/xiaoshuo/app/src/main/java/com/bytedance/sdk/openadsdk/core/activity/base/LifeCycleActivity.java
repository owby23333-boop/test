package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/* JADX INFO: loaded from: classes10.dex */
public class LifeCycleActivity extends Activity {
    e e;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e eVar = this.e;
        if (eVar != null) {
            eVar.e(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e eVar = this.e;
        if (eVar != null) {
            eVar.vn(this);
        }
        this.e = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        e eVar = this.e;
        if (eVar != null) {
            eVar.tg(this);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        e eVar = this.e;
        if (eVar != null) {
            eVar.d(this);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        e eVar = this.e;
        if (eVar != null) {
            eVar.bf(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        e eVar = this.e;
        if (eVar != null) {
            eVar.ga(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        e eVar = this.e;
        if (eVar != null) {
            eVar.e(this);
        }
    }
}
