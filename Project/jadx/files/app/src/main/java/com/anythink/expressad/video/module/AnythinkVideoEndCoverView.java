package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.module.a.a.j;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkVideoEndCoverView extends AnythinkBaseView implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f11851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f11852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f11853p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f11854q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f11855r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f11856s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f11857t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private b f11858u;

    public AnythinkVideoEndCoverView(Context context) {
        super(context);
        this.f11851n = "AnythinkVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f11853p = (ImageView) view.findViewById(findID("anythink_vec_iv_icon"));
            this.f11854q = (ImageView) view.findViewById(findID("anythink_vec_iv_close"));
            this.f11855r = (TextView) view.findViewById(findID("anythink_vec_tv_title"));
            this.f11856s = (TextView) view.findViewById(findID("anythink_vec_tv_desc"));
            this.f11857t = (TextView) view.findViewById(findID("anythink_vec_btn"));
            return true;
        } catch (Throwable th) {
            o.d("AnythinkVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    private void b() {
        View view = this.f11852o;
        if (view == null) {
            init(this.a);
            preLoadData(this.f11858u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f11852o.getParent()).removeView(this.f11852o);
        }
        addView(this.f11852o);
        a(this.f11852o);
        c();
    }

    private void e() {
        ImageView imageView;
        c cVar = this.b;
        if (cVar != null) {
            if (!TextUtils.isEmpty(cVar.bd()) && (imageView = this.f11853p) != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new j(imageView, t.b(n.a().g(), 8.0f)));
            }
            TextView textView = this.f11855r;
            if (textView != null) {
                textView.setText(this.b.bb());
            }
            TextView textView2 = this.f11857t;
            if (textView2 != null) {
                textView2.setText(this.b.cU);
            }
            TextView textView3 = this.f11856s;
            if (textView3 != null) {
                textView3.setText(this.b.bc());
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        this.f11854q.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnythinkVideoEndCoverView.this.f11787e.a(104, "");
            }
        });
        this.f11853p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnythinkVideoEndCoverView.this.a();
            }
        });
        this.f11857t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnythinkVideoEndCoverView.this.a();
            }
        });
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("anythink_reward_videoend_cover");
        if (iFindLayout >= 0) {
            this.f11852o = this.f11785c.inflate(iFindLayout, (ViewGroup) null);
            View view = this.f11852o;
            if (view != null) {
                this.f11788f = a(view);
                addView(this.f11852o, -1, -1);
                c();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f11789g = motionEvent.getRawX();
        this.f11790h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f11786d = configuration.orientation;
        removeView(this.f11852o);
        View view = this.f11852o;
        if (view == null) {
            init(this.a);
            preLoadData(this.f11858u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f11852o.getParent()).removeView(this.f11852o);
        }
        addView(this.f11852o);
        a(this.f11852o);
        c();
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        this.f11858u = bVar;
        try {
            if (this.b == null || !this.f11788f || this.b == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.b.bd()) && this.f11853p != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new j(this.f11853p, t.b(n.a().g(), 8.0f)));
            }
            if (this.f11855r != null) {
                this.f11855r.setText(this.b.bb());
            }
            if (this.f11857t != null) {
                this.f11857t.setText(this.b.cU);
            }
            if (this.f11856s != null) {
                this.f11856s.setText(this.b.bc());
            }
        } catch (Throwable th) {
            o.a("AnythinkVideoEndCoverView", th.getMessage());
        }
    }

    public AnythinkVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11851n = "AnythinkVideoEndCoverView";
    }

    protected final void a() {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2 = null;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e3) {
                jSONObject = jSONObject3;
                e2 = e3;
            }
            try {
                jSONObject.put(a.cc, t.a(n.a().g(), this.f11789g));
                jSONObject.put(a.cd, t.a(n.a().g(), this.f11790h));
                jSONObject.put(a.cf, 0);
                try {
                    this.f11786d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                jSONObject.put(a.cg, this.f11786d);
                jSONObject.put(a.ch, t.c(getContext()));
            } catch (JSONException e5) {
                e2 = e5;
                o.d("AnythinkVideoEndCoverView", e2.getMessage());
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(a.ce, jSONObject);
                jSONObject2 = jSONObject4;
            } catch (JSONException e6) {
                e = e6;
                jSONObject2 = jSONObject4;
                e.printStackTrace();
            }
        } catch (JSONException e7) {
            e = e7;
        }
        this.f11787e.a(105, jSONObject2);
    }
}
