package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class cz implements ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ cv b;

    cz(cv cvVar, RelativeLayout relativeLayout) {
        this.b = cvVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z2) {
        if (z2) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("novel_activity", (Activity) this.b.f12895h);
            map.put("banner_container", this.a);
            map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.b.D));
            map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b.E));
            map.put("novel_id", this.b.F);
            map.put("isnight", Boolean.valueOf(this.b.w()));
            this.b.a(cv.f13058u, map);
        }
    }
}
