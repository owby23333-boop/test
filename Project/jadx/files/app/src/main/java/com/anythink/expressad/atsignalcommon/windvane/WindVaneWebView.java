package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.anythink.expressad.atsignalcommon.base.BaseWebView;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class WindVaneWebView extends BaseWebView {
    private Object a;
    private Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f8302d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected o f8303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected d f8304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected i f8305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f8308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f8309l;

    public WindVaneWebView(Context context) {
        super(context);
        this.f8307j = false;
        this.f8308k = 0.0f;
        this.f8309l = 0.0f;
    }

    static /* synthetic */ boolean a(WindVaneWebView windVaneWebView) {
        windVaneWebView.f8307j = true;
        return true;
    }

    public void clearWebView() {
        if (this.f8307j) {
            return;
        }
        loadUrl(com.anythink.core.common.res.d.a);
    }

    public String getCampaignId() {
        return this.f8301c;
    }

    public Object getJsObject(String str) {
        i iVar = this.f8305h;
        if (iVar == null) {
            return null;
        }
        return iVar.a(str);
    }

    public Object getMraidObject() {
        return this.b;
    }

    public Object getObject() {
        return this.a;
    }

    public String getRid() {
        return this.f8306i;
    }

    public d getSignalCommunication() {
        return this.f8304g;
    }

    public e getWebViewListener() {
        return this.f8302d;
    }

    public boolean isDestroyed() {
        return this.f8307j;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.anythink.expressad.atsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f8308k = motionEvent.getRawX();
                    this.f8309l = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f8308k;
                    float y2 = motionEvent.getY() - this.f8309l;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48.0f) && ((rawX <= 0.0f || rawX <= 48.0f) && ((y2 >= 0.0f || (-1.0f) * y2 <= 48.0f) && (y2 <= 0.0f || y2 <= 48.0f)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        if (this.f8305h == null) {
            return;
        }
        i.a(cls);
    }

    public void release() {
        try {
            removeAllViews();
            setDownloadListener(null);
            this.a = null;
            if (t.j(getContext()) != 0) {
                com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.a(WindVaneWebView.this);
                        WindVaneWebView.this.destroy();
                    }
                }, r0 * 1000);
            } else {
                this.f8307j = true;
                destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        i iVar = this.f8305h;
        if (iVar != null) {
            iVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        i iVar = this.f8305h;
        if (iVar != null) {
            iVar.a(obj);
        }
    }

    public void setCampaignId(String str) {
        this.f8301c = str;
    }

    public void setMraidObject(Object obj) {
        this.b = obj;
    }

    public void setObject(Object obj) {
        this.a = obj;
    }

    public void setRid(String str) {
        this.f8306i = str;
    }

    public void setSignalCommunication(d dVar) {
        this.f8304g = dVar;
        dVar.a(this);
    }

    public void setWebViewChromeClient(o oVar) {
        this.f8303f = oVar;
        setWebChromeClient(oVar);
    }

    public void setWebViewListener(e eVar) {
        this.f8302d = eVar;
        o oVar = this.f8303f;
        if (oVar != null) {
            oVar.a(eVar);
        }
        com.anythink.expressad.atsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(eVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    @Override // com.anythink.expressad.atsignalcommon.base.BaseWebView
    protected final void a() {
        super.a();
        getSettings().setSavePassword(false);
        try {
            getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        } catch (Throwable unused) {
            getSettings().setUserAgentString(com.anythink.core.common.k.d.i() + " WindVane/3.0.2");
        }
        if (this.f8303f == null) {
            this.f8303f = new o(this);
        }
        setWebViewChromeClient(this.f8303f);
        this.mWebViewClient = new p();
        setWebViewClient(this.mWebViewClient);
        if (this.f8304g == null) {
            this.f8304g = new m(this.f8262e);
            setSignalCommunication(this.f8304g);
        }
        this.f8305h = new i(this.f8262e, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8307j = false;
        this.f8308k = 0.0f;
        this.f8309l = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8307j = false;
        this.f8308k = 0.0f;
        this.f8309l = 0.0f;
    }
}
