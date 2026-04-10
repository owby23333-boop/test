package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.openvk.component.video.api.a.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.widget.v;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class gc extends m {
    private int b;
    private int bm;
    private SeekBar bv;
    private View ec;
    private TextView eo;
    private final l f;
    private TextView gb;
    private ImageView gp;
    private final Rect hn;
    private TextView j;
    private int ja;
    private TextView jq;
    private boolean k;
    private ColorStateList lk;
    private int lw;
    private final Rect ly;
    private final Rect me;
    private float n;
    private TextView na;
    private boolean nb;
    private ColorStateList nh;
    private ImageView oq;
    private boolean qd;
    private float r;
    private int rv;
    private ColorStateList s;
    private boolean sd;
    private final Rect sf;
    private ImageView sv;
    private View t;
    private int tc;
    private int tf;
    private float u;
    private ImageView vm;
    private float vo;
    private View wj;
    private v wn;
    private boolean wo;
    private TextView xl;
    private TextView y;
    private float yw;
    private boolean yx;
    private final Rect yz;
    private int zx;
    private final View.OnTouchListener zz;

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bykv.vk.openvk.component.video.api.a.g
    public /* bridge */ /* synthetic */ void z(na naVar, WeakReference weakReference, boolean z) {
        z(naVar, (WeakReference<Context>) weakReference, z);
    }

    public gc(Context context, View view, boolean z, EnumSet<g.z> enumSet, na naVar, com.bykv.vk.openvk.component.video.api.a.dl dlVar, boolean z2) {
        super(context, view, z, enumSet, naVar, dlVar, z2, null);
        this.f = new l(Looper.getMainLooper(), this);
        this.yx = false;
        this.qd = false;
        this.zx = 0;
        this.b = 0;
        this.lw = 0;
        this.rv = 0;
        this.tc = 0;
        this.me = new Rect();
        this.yz = new Rect();
        this.bm = 0;
        this.tf = 0;
        this.ja = 0;
        this.wn = null;
        this.nb = false;
        this.zz = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.7
            private float g;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        gc.this.nb = Math.abs(this.g - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.g = x;
                }
                return false;
            }
        };
        this.sf = new Rect();
        this.ly = new Rect();
        this.hn = new Rect();
        this.sy = zw.getContext().getApplicationContext();
        a(z2);
        this.z = view;
        this.q = z;
        v vVar = new v(this);
        this.wn = vVar;
        vVar.z(this.q);
        DisplayMetrics displayMetrics = this.sy.getResources().getDisplayMetrics();
        this.tf = displayMetrics.widthPixels;
        this.ja = displayMetrics.heightPixels;
        this.io = enumSet == null ? EnumSet.noneOf(g.z.class) : enumSet;
        this.x = dlVar;
        this.uf = naVar;
        a(8);
        z(context, this.z, naVar);
        a();
        ls();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    protected void z(Context context, View view, na naVar) {
        super.z(context, view, naVar);
        this.eo = (TextView) view.findViewById(2114387759);
        this.oq = (ImageView) view.findViewById(2114387678);
        this.wj = view.findViewById(2114387605);
        this.gp = (ImageView) view.findViewById(2114387897);
        this.na = (TextView) view.findViewById(2114387730);
        this.xl = (TextView) view.findViewById(2114387706);
        this.j = (TextView) view.findViewById(2114387846);
        this.t = view.findViewById(2114387823);
        this.vm = (ImageView) view.findViewById(2114387618);
        this.y = (TextView) view.findViewById(2114387860);
        this.bv = (SeekBar) view.findViewById(2114387872);
        this.gb = (TextView) view.findViewById(2114387668);
        this.jq = (TextView) view.findViewById(2114387811);
        this.ec = view.findViewById(2114387628);
        this.sv = (ImageView) view.findViewById(2114387661);
        this.e = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    protected void a() {
        super.a();
        this.wn.z(this.z);
        oq.z((View) this.oq, (this.q || this.io.contains(g.z.hideCloseBtn)) ? 8 : 0);
        this.oq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gc.this.q()) {
                    gc.this.l.dl(gc.this, view);
                }
            }
        });
        oq.z((View) this.eo, (!this.q || this.io.contains(g.z.alwayShowBackBtn)) ? 0 : 8);
        this.eo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gc.this.q()) {
                    gc.this.l.a(gc.this, view);
                }
            }
        });
        this.gp.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gc.this.q()) {
                    gc.this.l.gc(gc.this, view);
                }
            }
        });
        this.vm.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.this.g(false, true);
                gc.this.gz();
                gc.this.e();
                gc.this.q();
            }
        });
        this.sv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gc.this.q()) {
                    gc.this.l.g(gc.this, view);
                }
            }
        });
        this.bv.setThumbOffset(0);
        this.bv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!gc.this.yx && gc.this.sy != null) {
                    seekBar.setThumb(gc.g(15, "#1E000000"));
                }
                if (gc.this.q()) {
                    seekBar.setThumbOffset(0);
                    gc.this.l.z(gc.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!gc.this.yx && gc.this.sy != null) {
                    seekBar.setThumb(gc.g(22, "#1E000000"));
                }
                if (gc.this.q()) {
                    seekBar.setThumbOffset(0);
                    gc.this.l.g(gc.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (gc.this.q()) {
                    gc.this.l.z(gc.this, i, z);
                }
            }
        });
        this.bv.setOnTouchListener(this.zz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable g(int i, String str) {
        Context context = zw.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iDl = oq.dl(context, i);
        shapeDrawable.setIntrinsicWidth(iDl);
        shapeDrawable.setIntrinsicHeight(iDl);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(oq.dl(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void gc() {
        this.f.removeMessages(1);
        this.f.sendMessageDelayed(this.f.obtainMessage(1), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void m() {
        this.f.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void g(boolean z) {
        int i = uy() ? this.ja : this.p;
        int dimensionPixelSize = uy() ? this.tf : this.fv;
        if (this.tb <= 0 || this.js <= 0 || i <= 0) {
            return;
        }
        if (!kb() && !uy() && !this.io.contains(g.z.fixedSize)) {
            dimensionPixelSize = this.sy.getResources().getDimensionPixelSize(tb.fo(this.sy, "tt_video_container_maxheight"));
        }
        int i2 = (int) (this.tb * ((i * 1.0f) / this.js));
        if (i2 > dimensionPixelSize) {
            i = (int) (this.js * ((dimensionPixelSize * 1.0f) / this.tb));
        } else {
            dimensionPixelSize = i2;
        }
        if (!z && !uy()) {
            i = this.p;
            dimensionPixelSize = this.fv;
        }
        this.g.z(i, dimensionPixelSize);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(String str) {
        TextView textView = this.na;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.xl;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void g(int i) {
        View view = this.ec;
        if (view != null && view.getVisibility() == 0) {
            oq.z((View) this.pf, 8);
            return;
        }
        oq.z((View) this.pf, 0);
        this.bv.setProgress(i);
        this.pf.setProgress(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(long j, long j2) {
        this.gb.setText(com.bykv.vk.openvk.component.video.z.gc.z.z(j2));
        this.jq.setText(com.bykv.vk.openvk.component.video.z.gc.z.z(j));
        this.bv.setProgress(com.bykv.vk.openvk.component.video.z.gc.z.z(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void e() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            iq();
            return;
        }
        oq.m(this.f1408a);
        oq.m(this.gc);
        oq.gc(this.t);
        if (this.m != null && this.uf != null && !TextUtils.isEmpty(tf.g(this.uf))) {
            oq.m(this.m);
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.m);
            z(this.m, tf.g(this.uf));
        }
        if (this.dl.getVisibility() == 0) {
            oq.z((View) this.dl, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bykv.vk.openvk.component.video.api.a.g
    public void z() {
        z(false, this.q);
        uf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(long j) {
        this.jq.setText(com.bykv.vk.openvk.component.video.z.gc.z.z(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(na naVar, WeakReference<Context> weakReference, boolean z) {
        if (naVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            z(zw.getContext(), this.z);
            fv();
            return;
        }
        z(this.z, zw.getContext());
        z(false, this.q);
        oq.z(this.gz, 0);
        oq.z((View) this.fo, 0);
        oq.z(this.uy, 0);
        if (this.fo != null && this.uf != null && !TextUtils.isEmpty(tf.g(this.uf))) {
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.fo);
            z(this.fo, tf.g(this.uf));
        }
        oq.z((View) this.v, 0);
        oq.z((View) this.kb, 8);
        oq.z((View) this.wp, 8);
        oq.z((View) this.i, 8);
        oq.z(this.v, tb.z(this.sy, "tt_video_dial_replay"));
        oq.z(this.v, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.gc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (gc.this.l != null) {
                    gc.this.l.z();
                }
            }
        }, "video_ad_button");
        oq.z(this.v, (View.OnTouchListener) null, "video_ad_button");
        if (x()) {
            oq.z(this.uy, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void gz() {
        oq.gc(this.f1408a);
        oq.gc(this.t);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void fo() {
        this.bv.setProgress(0);
        this.bv.setSecondaryProgress(0);
        this.pf.setProgress(0);
        this.pf.setSecondaryProgress(0);
        this.gb.setText(tb.z(this.sy, "tt_00_00"));
        this.jq.setText(tb.z(this.sy, "tt_00_00"));
        a(8);
        if (l()) {
            this.g.setVisibility(8);
        }
        if (this.m != null) {
            this.m.setImageDrawable(null);
            this.m.setBackground(null);
        }
        a(8);
        oq.z(this.ec, 8);
        oq.z(this.gz, 8);
        oq.z((View) this.fo, 8);
        oq.z(this.uy, 8);
        oq.z((View) this.kb, 8);
        oq.z((View) this.wp, 8);
        oq.z((View) this.i, 8);
        if (this.hh != null) {
            this.hh.z(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.pf.g
    public boolean uy() {
        return this.yx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean kb() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(ViewGroup viewGroup) {
        if (viewGroup != null && (this.z.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.yx = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
            this.b = marginLayoutParams.leftMargin;
            this.zx = marginLayoutParams.topMargin;
            this.lw = marginLayoutParams.width;
            this.rv = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.z.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.tc = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.me.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                oq.g(viewGroup, 0, 0, 0, 0);
            }
            g(true);
            tb.z(this.sy, "tt_shrink_video", this.sv);
            this.bv.setThumb(g(18, "#00000000"));
            this.bv.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.z.gc.z.z(this.z, false);
            m(this.yx);
            oq.z(this.wj, 8);
            if (!this.q) {
                oq.z((View) this.oq, 8);
                oq.z((View) this.eo, 8);
            } else if (this.io.contains(g.z.hideCloseBtn)) {
                oq.z((View) this.oq, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void g(ViewGroup viewGroup) {
        wp.a("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || this.z == null || !(this.z.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.yx = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
        marginLayoutParams.width = this.lw;
        marginLayoutParams.height = this.rv;
        marginLayoutParams.leftMargin = this.b;
        marginLayoutParams.topMargin = this.zx;
        this.z.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.tc);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            oq.g(viewGroup, this.me.left, this.me.top, this.me.right, this.me.bottom);
        }
        g(true);
        tb.z(this.sy, "tt_enlarge_video", this.sv);
        this.bv.setThumb(g(15, "#1E000000"));
        this.bv.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.z.gc.z.z(this.z, true);
        m(this.yx);
        oq.z(this.wj, 8);
        if (this.io.contains(g.z.alwayShowBackBtn)) {
            oq.z((View) this.eo, 0);
        }
    }

    private void m(boolean z) {
        if (z) {
            h();
        } else {
            gk();
        }
    }

    private void h() {
        DisplayMetrics displayMetrics = this.sy.getResources().getDisplayMetrics();
        TextView textView = this.jq;
        if (textView != null) {
            this.vo = textView.getTextSize();
            this.jq.setTextSize(2, 14.0f);
            ColorStateList textColors = this.jq.getTextColors();
            this.lk = textColors;
            if (textColors != null) {
                this.jq.setTextColor(tb.uy(this.sy, "tt_ssxinzi15"));
            }
            this.u = this.jq.getAlpha();
            this.jq.setAlpha(0.85f);
            this.jq.setShadowLayer(0.0f, oq.dl(this.sy, 0.5f), oq.dl(this.sy, 0.5f), tb.uy(this.sy, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.jq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.sf.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                oq.g(this.jq, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.sf.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.sf.bottom);
            }
        }
        TextView textView2 = this.gb;
        if (textView2 != null) {
            this.yw = textView2.getTextSize();
            this.gb.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.gb.getTextColors();
            this.s = textColors2;
            if (textColors2 != null) {
                this.gb.setTextColor(tb.uy(this.sy, "tt_ssxinzi15"));
            }
            this.n = this.gb.getAlpha();
            this.gb.setAlpha(0.85f);
            this.gb.setShadowLayer(0.0f, oq.dl(this.sy, 0.5f), oq.dl(this.sy, 0.5f), tb.uy(this.sy, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.gb.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.ly.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                oq.g(this.gb, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ly.top, this.ly.right, this.ly.bottom);
            }
        }
        ImageView imageView = this.sv;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.hn.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                oq.g(this.sv, this.hn.left, this.hn.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.hn.bottom);
            }
        }
        if (this.sv != null) {
            tb.z(this.sy, "tt_shrink_fullscreen", this.sv);
        }
        TextView textView3 = this.xl;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.nh = textColors3;
            if (textColors3 != null) {
                this.xl.setTextColor(tb.uy(this.sy, "tt_ssxinzi15"));
            }
            this.r = this.xl.getAlpha();
            this.xl.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.xl.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.yz.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                oq.g(this.xl, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.ly.top, this.ly.right, this.ly.bottom);
            }
        }
        View view = this.wj;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.bm = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.wj.setLayoutParams(layoutParams5);
            tb.z(this.sy, "tt_shadow_fullscreen_top", this.wj);
        }
        g(this.sd, true);
    }

    private void gk() {
        TextView textView = this.jq;
        if (textView != null) {
            textView.setTextSize(0, this.vo);
            ColorStateList colorStateList = this.lk;
            if (colorStateList != null) {
                this.jq.setTextColor(colorStateList);
            }
            this.jq.setAlpha(this.u);
            this.jq.setShadowLayer(oq.dl(this.sy, 1.0f), 0.0f, 0.0f, tb.uy(this.sy, "tt_video_shadow_color"));
            oq.g(this.jq, this.sf.left, this.sf.top, this.sf.right, this.sf.bottom);
        }
        TextView textView2 = this.gb;
        if (textView2 != null) {
            textView2.setTextSize(0, this.yw);
            ColorStateList colorStateList2 = this.s;
            if (colorStateList2 != null) {
                this.gb.setTextColor(colorStateList2);
            }
            this.gb.setAlpha(this.n);
            this.gb.setShadowLayer(oq.dl(this.sy, 1.0f), 0.0f, 0.0f, tb.uy(this.sy, "tt_video_shadow_color"));
            oq.g(this.gb, this.ly.left, this.ly.top, this.ly.right, this.ly.bottom);
        }
        ImageView imageView = this.sv;
        if (imageView != null) {
            oq.g(imageView, this.hn.left, this.hn.top, this.hn.right, this.hn.bottom);
        }
        if (this.sv != null) {
            tb.z(this.sy, "tt_enlarge_video", this.sv);
        }
        TextView textView3 = this.xl;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.nh;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.xl.setAlpha(this.r);
            oq.g(this.xl, this.ly.left, this.ly.top, this.ly.right, this.ly.bottom);
        }
        View view = this.wj;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.bm;
            this.wj.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.wj.setBackground(gradientDrawable);
        }
        g(this.sd, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 1) {
            return;
        }
        wp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(boolean z, boolean z2, boolean z3) {
        oq.z(this.ec, 0);
        oq.z((View) this.pf, 0);
        if (this.yx) {
            oq.z(this.wj, 0);
            oq.z((View) this.xl, 0);
        } else if (z3) {
            oq.z(this.wj, 8);
        }
        oq.z((View) this.dl, (!z || this.f1408a.getVisibility() == 0) ? 8 : 0);
        if (!this.q && !this.yx) {
            if (!this.io.contains(g.z.hideCloseBtn) && !z3) {
                oq.z((View) this.oq, 0);
            }
            oq.z((View) this.eo, z3 ? 8 : 0);
        }
        oq.z((View) this.gb, 0);
        oq.z((View) this.jq, 0);
        if (x()) {
            oq.z((View) this.bv, 8);
        } else {
            oq.z((View) this.bv, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void z(boolean z, boolean z2) {
        oq.z(this.ec, 8);
        oq.z(this.wj, 8);
        oq.z((View) this.pf, z ? 0 : 8);
        oq.z((View) this.dl, 8);
        if (!this.q && !this.yx) {
            oq.z((View) this.oq, 8);
            if (!this.io.contains(g.z.alwayShowBackBtn)) {
                oq.z((View) this.eo, 8);
            }
        } else if (this.io.contains(g.z.hideCloseBtn)) {
            oq.z((View) this.oq, 8);
        }
        if (z2) {
            oq.z((View) this.oq, 8);
            oq.z((View) this.eo, 8);
        }
        dl(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.pf.g
    public void wp() {
        z(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean dl(int i) {
        SeekBar seekBar = this.bv;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void dl(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.na != null) {
            if (this.q) {
                textView2 = this.na;
            } else {
                textView = this.na;
                if (z) {
                    i = 0;
                    oq.z((View) textView, i);
                }
                textView2 = textView;
            }
            textView = textView2;
            i = 8;
            oq.z((View) textView, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean i() {
        return this.iq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void a(int i) {
        this.zw = i;
        oq.z(this.z, i);
        if (i != 0) {
            this.k = false;
        } else if (this.wo) {
            this.k = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.v.z
    public void z(View view, boolean z) {
        if (uy()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.uf != null && !TextUtils.isEmpty(this.uf.li())) {
                z(this.uf.li());
            }
            this.j.setText(str);
        } else {
            z("");
            this.j.setText("");
        }
        if (this.h) {
            return;
        }
        dl(this.q && !this.yx);
        if (q()) {
            this.l.z(this, view, true, this.f1408a.getVisibility() != 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.v.z
    public void v() {
        wp();
        dl(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.v.z
    public boolean pf() {
        return this.hh != null && this.hh.z();
    }

    private boolean x() {
        if (this.uf == null) {
            return false;
        }
        int iYx = this.uf.yx();
        return iYx == 1 || iYx == 2;
    }
}
