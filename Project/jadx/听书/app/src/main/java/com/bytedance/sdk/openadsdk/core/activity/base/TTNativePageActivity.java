package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.dislike.ui.z;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.dl;
import com.bytedance.sdk.openadsdk.core.ugeno.dl.z;
import com.bytedance.sdk.openadsdk.core.ugeno.fo.a;
import com.bytedance.sdk.openadsdk.core.ugeno.fo.g;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.gc;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements l.z {
    private static WeakReference<dl> e;
    private ImageView fo;
    private m fv;
    private int gk;
    private ImageView gz;
    private int h;
    private boolean hh;
    private TTViewStub i;
    private z io;
    private a iq;
    private TextView kb;
    private boolean l;
    private long lq;
    private TTViewStub ls;
    com.bytedance.sdk.openadsdk.core.dislike.ui.z m;
    private ImageView p;
    private TTViewStub pf;
    private FrameLayout q;
    private FrameLayout sy;
    private Activity tb;
    private boolean uf;
    private TextView uy;
    private TTViewStub v;
    private Context wp;
    private g zw;
    private AtomicBoolean js = new AtomicBoolean(true);
    private boolean x = true;
    private final l mc = new l(Looper.getMainLooper(), this);
    private String un = "立即下载";

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gc == null) {
            return;
        }
        setRequestedOrientation(1);
        this.tb = this;
        this.wp = this;
        getWindow().addFlags(1024);
        try {
            zw.z(this.tb);
        } catch (Throwable th) {
            wp.z(th);
        }
        setContentView(gc.eo(this.wp));
        this.lq = System.currentTimeMillis();
        String stringExtra = getIntent().getStringExtra("title");
        gc();
        m();
        uy();
        if (this.gc != null && this.gc.ct() != null) {
            this.gc.ct().z("landing_page");
        }
        m mVar = new m(this.gc);
        this.fv = mVar;
        mVar.z(true);
        this.fv.z();
        if (this.gc != null) {
            e();
        }
        TextView textView = this.uy;
        if (textView != null && !this.hh && !this.l) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = tb.z(this.tb, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        g(4);
        com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, getClass().getName());
        if (this.hh || this.l) {
            i();
        }
    }

    private void gc() {
        if (this.gc == null || this.gc.hh() == null || this.gc.hh().a() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.gc);
    }

    private void m() {
        this.l = gb.js(this.gc);
        this.hh = gb.fv(this.gc);
        if (this.l) {
            if (com.bytedance.sdk.openadsdk.core.gz.a.f1113a) {
                if (this.hh) {
                    this.l = false;
                    return;
                }
                return;
            }
            this.hh = false;
        }
    }

    private void e() {
        if (uy.gz(this.gc)) {
            z zVar = new z(this, this.q, this.fv, this.gc, this.dl, this.f913a, gz());
            this.io = zVar;
            zVar.z(new com.bytedance.sdk.openadsdk.core.ugeno.a.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
                public void z(View view) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
                public void z(int i) {
                    TTNativePageActivity.this.z(i);
                }
            });
            this.io.z();
            return;
        }
        fo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        Intent intent;
        WeakReference<dl> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = e) != null && weakReference.get() != null) {
            e.get().g(false);
            e.get().z(eo.js(this.gc), false);
            e = null;
        } else {
            if (na.g(this.gc) && eo.gc(this.gc)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.g.z(this.tb, intent, null);
            } catch (Throwable th) {
                wp.g("TTNativePageActivity", th);
            }
        }
        finish();
    }

    private com.bytedance.sdk.openadsdk.core.multipro.g.z gz() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.core.multipro.g.z.z(new JSONObject(stringExtra));
        } catch (JSONException e2) {
            wp.z(e2);
            return null;
        }
    }

    private void fo() {
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVarHh = this.gc.hh();
        if (zVarHh == null) {
            return;
        }
        int iA = zVarHh.a();
        if (iA == 2) {
            a aVar = new a(this.wp, this.q, this.fv, this.gc, this.dl, this.f913a);
            this.iq = aVar;
            aVar.i();
            return;
        }
        if (iA == 3) {
            g gVar = new g(this.wp, this.q, this.fv, this.gc, this.dl, this.f913a);
            this.zw = gVar;
            gVar.g(false);
            this.zw.i();
            if (TextUtils.equals(zVarHh.z(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.wp);
            float fDl = oq.dl(this.wp, 18.0f);
            float fDl2 = oq.dl(this.wp, 18.0f);
            int i = (int) fDl;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 53;
            int i2 = (int) fDl2;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.sy.addView(imageView, layoutParams);
            tb.z(this.wp, "tt_unmute", imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.uf = !r3.uf;
                    tb.z(TTNativePageActivity.this.wp, TTNativePageActivity.this.uf ? "tt_mute" : "tt_unmute", imageView);
                    TTNativePageActivity.this.zw.dl(TTNativePageActivity.this.uf);
                }
            });
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void uy() {
        TTViewStub tTViewStub;
        this.sy = (FrameLayout) findViewById(2114387634);
        this.q = (FrameLayout) findViewById(2114387720);
        this.ls = (TTViewStub) findViewById(2114387956);
        this.i = (TTViewStub) findViewById(2114387770);
        this.v = (TTViewStub) findViewById(2114387792);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387933);
        this.pf = tTViewStub2;
        if (this.hh || this.l) {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.p = (ImageView) findViewById(2114387843);
        } else {
            int iL = com.bytedance.sdk.openadsdk.core.uy.ls().l();
            if (iL == 0) {
                TTViewStub tTViewStub3 = this.i;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            } else if (iL == 1 && (tTViewStub = this.v) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.gz = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.fo = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.uy = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.kb = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.z();
                }
            });
        }
    }

    private boolean kb() {
        return this.hh || this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m mVar = this.fv;
        if (mVar != null) {
            mVar.dl();
        }
        a();
        z zVar = this.io;
        if (zVar != null) {
            zVar.dl();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        m mVar = this.fv;
        if (mVar != null) {
            mVar.z(0);
        }
        if (this.x) {
            this.x = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.START, this.lq);
                jSONObject.put(TtmlNode.END, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, this.gc);
            } catch (JSONException e2) {
                wp.z(e2);
            }
            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        z zVar = this.io;
        if (zVar != null) {
            zVar.g();
        }
        dl();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean wp() {
        return na.dl(this.gc);
    }

    private void g(int i) {
        if (wp()) {
            oq.z((View) this.fo, 4);
        } else {
            if (this.fo == null || !wp()) {
                return;
            }
            oq.z((View) this.fo, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        z zVar = this.io;
        if (zVar != null) {
            zVar.a();
        }
        g gVar = this.zw;
        if (gVar != null) {
            gVar.ls();
        }
        m mVar = this.fv;
        if (mVar != null) {
            mVar.a();
        }
    }

    protected void z() {
        if (this.gc == null || isFinishing()) {
            return;
        }
        if (this.m == null) {
            g();
        }
        this.m.z();
    }

    void g() {
        this.m = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.tb, this.gc.ct(), this.dl, true);
        com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.tb, this.gc, this.m);
        this.m.z(new z.InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z() {
                TTNativePageActivity.this.dl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z(int i, String str, boolean z) {
                TTNativePageActivity.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void g() {
                TTNativePageActivity.this.a();
            }
        });
    }

    private void i() {
        this.h = 0;
        if (this.hh) {
            this.h = com.bytedance.sdk.openadsdk.core.gz.a.z;
        } else if (this.l && !com.bytedance.sdk.openadsdk.core.gz.a.f1113a) {
            this.h = gb.v(this.gc);
        }
        dl(this.h);
        if (this.h > 0 && !this.mc.hasMessages(10)) {
            if (this.hh) {
                this.mc.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.l) {
                this.mc.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    private void dl(int i) {
        if (i > 0) {
            if (this.hh) {
                oq.z(this.uy, i + "s后可领取奖励");
                return;
            } else {
                if (this.l) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    oq.z(this.uy, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.hh) {
            oq.z(this.uy, "领取成功");
        } else if (this.l) {
            oq.z((View) this.p, 8);
            oq.z(this.uy, "恭喜你！福利已领取");
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 10 && kb()) {
            int i = this.gk + 1;
            this.gk = i;
            if (this.hh) {
                com.bytedance.sdk.openadsdk.core.gz.a.g = i;
            }
            int iMax = Math.max(0, this.h - this.gk);
            dl(iMax);
            if (iMax <= 0 && this.l) {
                com.bytedance.sdk.openadsdk.core.gz.a.f1113a = true;
            }
            this.mc.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public void dl() {
        if (kb()) {
            this.mc.removeMessages(10);
        }
    }

    public void a() {
        if (!kb() || this.mc.hasMessages(10)) {
            return;
        }
        this.mc.sendEmptyMessageDelayed(10, 1000L);
    }

    public static void z(dl dlVar) {
        e = new WeakReference<>(dlVar);
    }
}
