package com.anythink.expressad.atsignalcommon.webEnvCheck;

import android.content.Context;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.d.b.b;
import com.anythink.expressad.foundation.g.a;

/* JADX INFO: loaded from: classes2.dex */
public class WebEnvCheckEntry {
    public void check(Context context) {
        try {
            new WindVaneWebView(context).loadDataWithBaseURL(null, "<html><script>" + b.a().b() + "</script></html>", "text/html", a.bN, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
