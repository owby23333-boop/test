package com.anythink.expressad.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.module.a.a.e;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkClickCTAView extends AnythinkBaseView implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11796n = "anythink_reward_clickable_cta";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ViewGroup f11797o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f11798p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f11799q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f11800r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f11801s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f11802t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f11803u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f11804v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11805w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ObjectAnimator f11806x;

    public AnythinkClickCTAView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ImageView imageView = this.f11798p;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void e() {
        setWrapContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        this.f11797o = (ViewGroup) findViewById(findID("anythink_viewgroup_ctaroot"));
        this.f11798p = (ImageView) findViewById(findID("anythink_iv_appicon"));
        this.f11799q = (TextView) findViewById(findID("anythink_tv_title"));
        this.f11801s = (TextView) findViewById(findID("anythink_tv_install"));
        return isNotNULL(this.f11797o, this.f11798p, this.f11799q, this.f11801s);
    }

    private void g() {
        JSONObject jSONObject;
        JSONException e2;
        c cVar = this.b;
        if (cVar != null) {
            cVar.j();
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = null;
            e2 = e3;
        }
        try {
            jSONObject.put(a.ce, a(0));
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        this.f11787e.a(105, jSONObject);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f11806x;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f11806x;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f11803u = motionEvent.getRawX();
        this.f11804v = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f11805w = configuration.orientation;
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        c cVar = this.b;
        if (cVar != null) {
            if (cVar.j()) {
                c cVar2 = this.b;
                new com.anythink.expressad.video.dynview.j.c();
                com.anythink.expressad.video.dynview.c cVarB = com.anythink.expressad.video.dynview.j.c.b(this, cVar2);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(cVarB, new AnonymousClass1(this));
            } else {
                int iFindLayout = findLayout(f11796n);
                if (iFindLayout >= 0) {
                    this.f11785c.inflate(iFindLayout, this);
                    this.f11788f = f();
                    c();
                    setWrapContent();
                }
            }
            if (this.f11788f) {
                this.f11801s.setText(this.b.cU);
                if (TextUtils.isEmpty(this.b.bd())) {
                    b();
                } else {
                    com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new e(this.f11798p, this.b, this.f11802t) { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.5
                        @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
                        public final void a(String str, String str2) {
                            super.a(str, str2);
                            AnythinkClickCTAView.this.b();
                        }
                    });
                }
                if (this.f11799q != null && !TextUtils.isEmpty(this.b.bb())) {
                    this.f11799q.setText(this.b.bb());
                }
                if (this.f11800r == null || TextUtils.isEmpty(this.b.bc())) {
                    return;
                }
                this.f11800r.setText(this.b.bc());
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f11806x = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f11802t = str;
    }

    public AnythinkClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f11788f) {
            c cVar = this.b;
            if (cVar != null && cVar.j()) {
                setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.2
                    @Override // com.anythink.expressad.widget.a
                    protected final void a(View view) {
                        AnythinkClickCTAView.b(AnythinkClickCTAView.this);
                    }
                });
            }
            this.f11801s.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.3
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkClickCTAView.b(AnythinkClickCTAView.this);
                }
            });
            ImageView imageView = this.f11798p;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    private void a(ViewGroup viewGroup, c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c cVarB = com.anythink.expressad.video.dynview.j.c.b(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(cVarB, new AnonymousClass1(viewGroup));
    }

    static /* synthetic */ void b(AnythinkClickCTAView anythinkClickCTAView) {
        JSONObject jSONObject;
        JSONException e2;
        c cVar = anythinkClickCTAView.b;
        if (cVar != null) {
            cVar.j();
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = null;
            e2 = e3;
        }
        try {
            jSONObject.put(a.ce, anythinkClickCTAView.a(0));
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        anythinkClickCTAView.f11787e.a(105, jSONObject);
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$1, reason: invalid class name */
    final class AnonymousClass1 implements h {
        final /* synthetic */ ViewGroup a;

        AnonymousClass1(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            this.a.addView(aVar.a());
            AnythinkClickCTAView anythinkClickCTAView = AnythinkClickCTAView.this;
            anythinkClickCTAView.f11788f = anythinkClickCTAView.f();
            AnythinkClickCTAView anythinkClickCTAView2 = AnythinkClickCTAView.this;
            anythinkClickCTAView2.f11800r = (TextView) anythinkClickCTAView2.findViewById(anythinkClickCTAView2.findID("anythink_tv_desc"));
            AnythinkClickCTAView.this.c();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            o.d(AnythinkBaseView.TAG, "errorMsg:" + bVar.b());
        }
    }

    private void a() {
        int iFindLayout = findLayout(f11796n);
        if (iFindLayout >= 0) {
            this.f11785c.inflate(iFindLayout, this);
            this.f11788f = f();
            c();
            setWrapContent();
        }
    }
}
