package com.anythink.expressad.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.widget.a;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkVastEndCardView extends AnythinkBaseView implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11847n = "anythink_reward_endcard_vast";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ViewGroup f11848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f11849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f11850q;

    public AnythinkVastEndCardView(Context context) {
        super(context);
    }

    private void a() {
        if (this.f11788f) {
            setMatchParent();
            setBackgroundResource(findColor("anythink_reward_endcard_vast_bg"));
            setClickable(true);
            ((RelativeLayout.LayoutParams) this.f11848o.getLayoutParams()).addRule(13, -1);
        }
    }

    private boolean b() {
        this.f11848o = (ViewGroup) findViewById(findID("anythink_rl_content"));
        this.f11849p = findViewById(findID("anythink_iv_vastclose"));
        this.f11850q = findViewById(findID("anythink_iv_vastok"));
        return isNotNULL(this.f11848o, this.f11849p, this.f11850q);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f11788f) {
            this.f11849p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVastEndCardView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnythinkVastEndCardView.this.f11787e.a(104, "");
                }
            });
            this.f11850q.setOnClickListener(new a() { // from class: com.anythink.expressad.video.module.AnythinkVastEndCardView.2
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkVastEndCardView anythinkVastEndCardView = AnythinkVastEndCardView.this;
                    anythinkVastEndCardView.f11787e.a(108, anythinkVastEndCardView.d());
                }
            });
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        int iFindLayout = findLayout(f11847n);
        if (iFindLayout >= 0) {
            this.f11785c.inflate(iFindLayout, this);
            this.f11848o = (ViewGroup) findViewById(findID("anythink_rl_content"));
            this.f11849p = findViewById(findID("anythink_iv_vastclose"));
            this.f11850q = findViewById(findID("anythink_iv_vastok"));
            this.f11788f = isNotNULL(this.f11848o, this.f11849p, this.f11850q);
            c();
            if (this.f11788f) {
                setMatchParent();
                setBackgroundResource(findColor("anythink_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.f11848o.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.f11787e.a(111, "");
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
    }

    public AnythinkVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
