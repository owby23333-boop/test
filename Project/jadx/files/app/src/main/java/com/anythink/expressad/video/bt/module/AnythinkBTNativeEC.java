package com.anythink.expressad.video.bt.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.b.a;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.module.a.a.e;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.anythink.expressad.videocommon.view.StarLevelView;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.umeng.message.proguard.ad;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkBTNativeEC extends BTBaseView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11502p = "anythink_reward_endcard_native_hor";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11503q = "anythink_reward_endcard_native_land";
    private TextView A;
    private TextView B;
    private StarLevelView C;
    private boolean D;
    private boolean E;
    private int F;
    private Runnable G;
    private View H;
    private View I;
    private String J;
    private j K;
    private WebView L;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ViewGroup f11504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ViewGroup f11505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RelativeLayout f11506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f11507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RoundImageView f11508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f11509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f11510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f11511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f11512z;

    public AnythinkBTNativeEC(Context context) {
        super(context);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    static /* synthetic */ boolean a(AnythinkBTNativeEC anythinkBTNativeEC) {
        anythinkBTNativeEC.E = true;
        return true;
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript renderScriptCreate = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(10.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            bitmap.recycle();
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        boolean zB;
        int iFindLayout = findLayout(isLandscape() ? f11503q : f11502p);
        if (iFindLayout > 0) {
            if (isLandscape()) {
                this.f11505s = (ViewGroup) this.f11552f.inflate(iFindLayout, (ViewGroup) null);
                addView(this.f11505s);
                zB = b(this.f11505s);
            } else {
                this.f11504r = (ViewGroup) this.f11552f.inflate(iFindLayout, (ViewGroup) null);
                addView(this.f11504r);
                zB = b(this.f11504r);
            }
            this.f11554h = zB;
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new Runnable() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this);
                    if (AnythinkBTNativeEC.this.H != null) {
                        AnythinkBTNativeEC.this.H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.F * 1000);
        }
        if (!this.f11554h && this.L != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f11550d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("unitId", this.J);
                jSONObject.put("data", jSONObject2);
                o.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e2) {
                o.a(BTBaseView.TAG, e2.getMessage());
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.L != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.f11550d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("unitId", this.J);
                jSONObject3.put("data", jSONObject4);
                o.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e3) {
                o.a(BTBaseView.TAG, e3.getMessage());
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f11553g = configuration.orientation;
        if (this.f11553g == 2) {
            removeView(this.f11504r);
            a(this.f11505s);
        } else {
            removeView(this.f11505s);
            a(this.f11504r);
        }
    }

    public void preLoadData() {
        Bitmap bitmapBlurBitmap;
        try {
            if (this.b == null || !this.f11554h) {
                return;
            }
            if (this.f11551e != null) {
                this.F = this.f11551e.p();
            }
            b.a(this.a.getApplicationContext()).a(this.b.be(), new e(this.f11508v, this.b, this.J));
            b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(this.f11509w, t.b(a.b().d(), 8.0f)));
            this.f11512z.setText(this.b.bb());
            this.A.setText(this.b.bc());
            this.B.setText(this.b.aY() + ad.f20406s);
            this.C.removeAllViews();
            double dAX = this.b.aX();
            if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                dAX = 5.0d;
            }
            this.C.initScore(dAX);
            if (Build.VERSION.SDK_INT < 17) {
                this.f11507u.setVisibility(8);
                return;
            }
            try {
                Bitmap bitmapA = a(this.f11508v.getDrawable());
                if (bitmapA != null && (bitmapBlurBitmap = blurBitmap(bitmapA)) != null) {
                    this.f11507u.setImageBitmap(bitmapBlurBitmap);
                }
            } catch (Throwable unused) {
                this.f11507u.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.D = true;
            }
            b.a(this.a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new c() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.2
                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        int iB = t.b(AnythinkBTNativeEC.this.a, 12.0f);
                        AnythinkBTNativeEC.this.f11510x.getLayoutParams().height = iB;
                        AnythinkBTNativeEC.this.f11510x.getLayoutParams().width = (int) (iB * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                        AnythinkBTNativeEC.this.f11510x.setImageBitmap(bitmap);
                        AnythinkBTNativeEC.this.f11510x.setBackgroundColor(1426063360);
                    } catch (Throwable unused2) {
                    }
                }

                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(String str, String str2) {
                }
            });
            a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
            if (aVarB != null) {
                final String strJ = aVarB.J();
                if (TextUtils.isEmpty(strJ)) {
                    this.f11511y.setVisibility(8);
                }
                this.f11511y.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.b(AnythinkBTNativeEC.this.a, strJ);
                    }
                });
            } else {
                this.f11511y.setVisibility(8);
            }
            if (this.E) {
                return;
            }
            this.H.setVisibility(8);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setCreateWebView(WebView webView) {
        this.L = webView;
    }

    public void setJSCommon(j jVar) {
        this.K = jVar;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setUnitId(String str) {
        this.J = str;
    }

    private void a(View view) {
        if (view == null) {
            init(this.a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    private boolean b(int i2) {
        if (isLandscape()) {
            this.f11505s = (ViewGroup) this.f11552f.inflate(i2, (ViewGroup) null);
            addView(this.f11505s);
            return b(this.f11505s);
        }
        this.f11504r = (ViewGroup) this.f11552f.inflate(i2, (ViewGroup) null);
        addView(this.f11504r);
        return b(this.f11504r);
    }

    private void c(int i2) {
        JSONObject jSONObject;
        try {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i2));
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
            }
            if (this.K != null) {
                this.K.click(1, jSONObject != null ? jSONObject.toString() : "");
            }
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public AnythinkBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    private boolean b(View view) {
        try {
            this.f11506t = (RelativeLayout) view.findViewById(findID("anythink_native_ec_layout"));
            this.f11507u = (ImageView) view.findViewById(findID("anythink_iv_adbanner_bg"));
            this.f11508v = (RoundImageView) view.findViewById(findID("anythink_iv_adbanner"));
            this.f11509w = (ImageView) view.findViewById(findID("anythink_iv_icon"));
            this.f11510x = (ImageView) view.findViewById(findID("anythink_iv_flag"));
            this.f11511y = (ImageView) view.findViewById(findID("anythink_iv_link"));
            this.f11512z = (TextView) view.findViewById(findID("anythink_tv_apptitle"));
            this.A = (TextView) view.findViewById(findID("anythink_tv_appdesc"));
            this.B = (TextView) view.findViewById(findID("anythink_tv_nuater"));
            this.C = (StarLevelView) view.findViewById(findID("anythink_sv_starlevel"));
            this.H = view.findViewById(findID("anythink_iv_close"));
            this.I = view.findViewById(findID("anythink_tv_cta"));
            return isNotNULL(this.f11507u, this.f11508v, this.f11509w, this.f11512z, this.A, this.B, this.C, this.H, this.I);
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    protected final void a() {
        if (this.f11554h) {
            this.f11506t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (AnythinkBTNativeEC.this.D) {
                        AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 1);
                        AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (AnythinkBTNativeEC.this.L != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", AnythinkBTNativeEC.this.f11550d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("unitId", AnythinkBTNativeEC.this.J);
                            jSONObject.put("data", jSONObject2);
                            o.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e2) {
                            o.a(BTBaseView.TAG, e2.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTNativeEC.this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.I.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.6
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f11509w.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.7
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f11508v.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.8
                @Override // com.anythink.expressad.widget.a
                protected final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    private static Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    private void a(float f2, float f3) {
        if (this.L != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", BTBaseView.f11546n);
                jSONObject.put("id", this.f11550d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f2));
                jSONObject2.put("y", String.valueOf(f3));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(this.L, "onClicked", this.f11550d);
            }
        }
    }

    private int b() {
        return findLayout(isLandscape() ? f11503q : f11502p);
    }

    static /* synthetic */ void a(AnythinkBTNativeEC anythinkBTNativeEC, int i2) {
        JSONObject jSONObject;
        try {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkBTNativeEC.a(i2));
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
            }
            if (anythinkBTNativeEC.K != null) {
                anythinkBTNativeEC.K.click(1, jSONObject != null ? jSONObject.toString() : "");
            }
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    static /* synthetic */ void a(AnythinkBTNativeEC anythinkBTNativeEC, float f2, float f3) {
        if (anythinkBTNativeEC.L != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", BTBaseView.f11546n);
                jSONObject.put("id", anythinkBTNativeEC.f11550d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f2));
                jSONObject2.put("y", String.valueOf(f3));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(anythinkBTNativeEC.L, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(anythinkBTNativeEC.L, "onClicked", anythinkBTNativeEC.f11550d);
            }
        }
    }
}
