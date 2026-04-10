package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import com.anythink.expressad.video.module.AnythinkContainerView;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Activity f11961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AnythinkContainerView f11962o;

    private o(Activity activity, AnythinkContainerView anythinkContainerView) {
        this.f11961n = activity;
        this.f11962o = anythinkContainerView;
    }

    @Override // com.anythink.expressad.video.signal.a.e, com.anythink.expressad.video.signal.g
    public final void a(int i2, String str) {
        super.a(i2, str);
        int iIntValue = 1;
        if (i2 == 1) {
            if (this.f11962o != null) {
                try {
                    iIntValue = Integer.valueOf(str).intValue();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.f11962o.showVideoClickView(iIntValue);
                return;
            }
            return;
        }
        if (i2 != 2) {
            if (i2 != 5) {
            }
        } else {
            Activity activity = this.f11961n;
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
