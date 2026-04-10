package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> {
    private boolean hs;
    protected long ht;
    private float hu;
    private float hv;
    private int hw;
    private MotionEvent hx;
    protected SimpleImageLoadingListener hy;

    public final void cj() {
        if (this.hs) {
            return;
        }
        this.hs = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 1, getStayTime());
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.hu = motionEvent.getX();
            this.hv = motionEvent.getY();
            this.hx = MotionEvent.obtain(motionEvent);
            this.hw = 0;
        }
        if (a(motionEvent)) {
            if (!com.kwad.sdk.utils.b.a(this.hx, motionEvent, this.mAdTemplate)) {
                return true;
            }
            if (action == 3 && this.hw == 0) {
                motionEvent.setAction(1);
                this.hw = 1;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || !(action != 3 || motionEvent.getX() == 0.0f || motionEvent.getY() == 0.0f)) {
            return Math.abs(motionEvent.getX() - this.hu) > 20.0f || Math.abs(motionEvent.getY() - this.hv) > 20.0f;
        }
        return false;
    }

    public a(Context context) {
        super(context);
        this.hw = 0;
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.ht);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.b.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.ht);
            }
        };
    }

    protected final void ck() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        } else {
            complianceTextView.setVisibility(8);
        }
    }
}
