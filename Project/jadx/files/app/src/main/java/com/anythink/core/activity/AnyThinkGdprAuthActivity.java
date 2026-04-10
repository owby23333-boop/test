package com.anythink.core.activity;

import android.app.Activity;
import android.os.Bundle;
import com.anythink.core.activity.component.PrivacyPolicyView;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.common.i;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkGdprAuthActivity extends Activity {
    public static ATGDPRAuthCallback mCallback;
    String a;
    PrivacyPolicyView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6469c = false;

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f6469c) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.a();
        this.a = i.l();
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(6);
        } else {
            setRequestedOrientation(7);
        }
        try {
            this.b = new PrivacyPolicyView(this);
            this.b.setResultCallbackListener(new PrivacyPolicyView.a() { // from class: com.anythink.core.activity.AnyThinkGdprAuthActivity.1
                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onLevelSelect(int i2) {
                    ATGDPRAuthCallback aTGDPRAuthCallback = AnyThinkGdprAuthActivity.mCallback;
                    if (aTGDPRAuthCallback != null) {
                        aTGDPRAuthCallback.onAuthResult(i2);
                        AnyThinkGdprAuthActivity.mCallback = null;
                    }
                    AnyThinkGdprAuthActivity.this.finish();
                }

                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onPageLoadFail() {
                    AnyThinkGdprAuthActivity.this.f6469c = true;
                    ATGDPRAuthCallback aTGDPRAuthCallback = AnyThinkGdprAuthActivity.mCallback;
                    if (aTGDPRAuthCallback != null) {
                        aTGDPRAuthCallback.onPageLoadFail();
                    }
                }

                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onPageLoadSuccess() {
                    AnyThinkGdprAuthActivity.this.f6469c = false;
                }
            });
            setContentView(this.b);
            this.b.loadPolicyUrl(this.a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        PrivacyPolicyView privacyPolicyView = this.b;
        if (privacyPolicyView != null) {
            privacyPolicyView.destory();
        }
        mCallback = null;
        super.onDestroy();
    }
}
