package com.anythink.expressad.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.video.signal.factory.b;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkLandingPageView extends AnythinkH5EndCardView {

    private static final class a implements com.anythink.expressad.atsignalcommon.base.a {
        private a() {
        }

        @Override // com.anythink.expressad.atsignalcommon.base.a
        public final boolean a(String str) {
            if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            }
            s.a(n.a().g(), str, null);
            return true;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public AnythinkLandingPageView(Context context) {
        super(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final String a() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.ad();
        }
        return null;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        super.init(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        byte b = 0;
        if (this.f11788f) {
            this.f11825s.setFilter(new a(b));
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        try {
            o.a(AnythinkBaseView.TAG, "webviewshow");
            j.a();
            j.a((WebView) this.f11825s, "webviewshow", "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public AnythinkLandingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
