package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.UgenLottieView;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTRoundRectImageView f1413a;
    private ImageView dl;
    private TextView e;
    private LinearLayout fo;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g fv;
    Stack<View> g;
    private TextView gc;
    private View gk;
    private LinearLayout gz;
    private RelativeLayout h;
    private JSONArray hh;
    private TextView i;
    private String io;
    private String iq;
    private String js;
    private TextView kb;
    private float l;
    private String lq;
    private TextView ls;
    private TextView m;
    private Button p;
    private TextView pf;
    private String q;
    private String sy;
    private String tb;
    private String uf;
    private TTRatingBar2 uy;
    private TextView v;
    private TextView wp;
    private z x;
    protected Context z;
    private String zw;

    public interface z {
        void a(Dialog dialog);

        void dl(Dialog dialog);

        void g(Dialog dialog);

        void gc(Dialog dialog);

        void m(Dialog dialog);

        void z(Dialog dialog);
    }

    public dl(Context context) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.g = new Stack<>();
        this.z = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z();
        setCanceledOnTouchOutside(false);
        g();
    }

    public void z() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        if (this.z.getResources().getConfiguration().orientation == 1) {
            this.gk = z(1);
        } else {
            this.gk = z(0);
        }
        setContentView(this.gk);
    }

    private View z(int i) {
        int iDl;
        LinearLayout linearLayoutG = g(i);
        LinearLayout linearLayout = new LinearLayout(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            iDl = oq.dl(this.z, 40.0f);
        } else {
            layoutParams.addRule(3, m().getId());
            iDl = oq.dl(this.z, 16.0f);
        }
        layoutParams.leftMargin = iDl;
        layoutParams.rightMargin = iDl;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.h.addView(linearLayout);
        this.f1413a = new TTRoundRectImageView(this.z);
        int iDl2 = oq.dl(this.z, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iDl2, iDl2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = oq.dl(this.z, 40.0f);
        } else {
            layoutParams2.topMargin = oq.dl(this.z, 36.0f);
        }
        this.f1413a.setMaxHeight(iDl2);
        this.f1413a.setMaxWidth(iDl2);
        this.f1413a.setMinimumHeight(iDl2);
        this.f1413a.setMinimumWidth(iDl2);
        this.f1413a.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f1413a);
        return z(i, linearLayoutG, linearLayout, iDl);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.gc = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i == 0) {
            layoutParams.topMargin = oq.dl(this.z, 16.0f);
            int iDl = oq.dl(this.z, 25.0f);
            layoutParams.leftMargin = iDl;
            layoutParams.rightMargin = iDl;
        } else {
            layoutParams.topMargin = oq.dl(this.z, 14.0f);
        }
        this.gc.setLayoutParams(layoutParams);
        this.gc.setEllipsize(TextUtils.TruncateAt.END);
        this.gc.setTextColor(Color.parseColor("#161823"));
        this.gc.setTextSize(18.0f);
        this.gc.setGravity(17);
        this.gc.setTypeface(null, 1);
        linearLayout2.addView(this.gc);
        this.m = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = oq.dl(this.z, 5.0f);
        this.m.setLayoutParams(layoutParams2);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setSingleLine(true);
        this.m.setAlpha(0.5f);
        this.m.setTextColor(Color.parseColor("#161823"));
        this.m.setTextSize(14.0f);
        this.m.setGravity(17);
        linearLayout2.addView(this.m);
        return g(i, linearLayout, linearLayout2, i2);
    }

    private LinearLayout g(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.gz = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = oq.dl(this.z, 10.0f);
        this.gz.setLayoutParams(layoutParams);
        this.gz.setOrientation(0);
        linearLayout2.addView(this.gz);
        this.fo = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = oq.dl(this.z, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = oq.dl(this.z, 16.0f);
        } else {
            layoutParams2.topMargin = oq.dl(this.z, 10.0f);
        }
        this.fo.setLayoutParams(layoutParams2);
        this.fo.setOrientation(0);
        this.uy = new TTRatingBar2(this.z, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.uy.setLayoutParams(layoutParams3);
        this.fo.addView(this.uy);
        this.kb = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = oq.dl(this.z, 3.0f);
        this.kb.setTextSize(16.0f);
        this.kb.setTextColor(Color.parseColor("#161823"));
        this.kb.setLayoutParams(layoutParams4);
        this.fo.addView(this.kb);
        linearLayout2.addView(this.fo);
        return z(i, linearLayout, i2);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, int i2) {
        int iN = zw.g().n();
        boolean zS = zw.g().s();
        if (zS && iN == 1) {
            this.p = new ShakeButton(this.z);
        } else if (zS && iN == 2) {
            this.p = new ShineButton(this.z);
        } else {
            this.p = new Button(this.z);
        }
        this.p.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.z);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.z);
        this.i = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            z(i, this.h);
        } else {
            z(oq.dl(this.z, 89.0f), i);
        }
        return z(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i == 1) {
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            int iDl = oq.dl(this.z, 16.0f);
            layoutParams.leftMargin = iDl;
            layoutParams.rightMargin = iDl;
        }
        layoutParams.topMargin = oq.dl(this.z, 3.0f);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setGravity(17);
        this.i.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.i.setTextSize(10.0f);
        } else {
            this.i.setTextSize(12.0f);
        }
        this.i.setLayoutParams(layoutParams);
        this.h.addView(this.i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        if (i == 1) {
            layoutParams2.topMargin = oq.dl(this.z, 9.0f);
        } else {
            layoutParams2.topMargin = oq.dl(this.z, 2.0f);
            layoutParams2.bottomMargin = oq.dl(this.z, 20.0f);
        }
        if (i == 1) {
            layoutParams2.addRule(2, view.getId());
        } else {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        return g(i, linearLayout, i2, linearLayout2, view);
    }

    private LinearLayout g(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            z(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.zw)) {
                ImageView imageView = new ImageView(this.z);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oq.dl(this.z, 0.5f), oq.dl(this.z, 9.0f));
                layoutParams.leftMargin = oq.dl(this.z, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int iDl = oq.dl(this.z, 8.0f);
        z(linearLayout2, iDl);
        g(linearLayout2, iDl);
        return z(i, linearLayout, i2, linearLayout2, view, iDl);
    }

    private void z(LinearLayout linearLayout, int i) {
        this.ls = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.ls.setLayoutParams(layoutParams);
        this.ls.setAlpha(0.75f);
        this.ls.setTextColor(Color.parseColor("#66161823"));
        if (this.z.getResources().getConfiguration().orientation == 2) {
            this.ls.setTextSize(10.0f);
        } else {
            this.ls.setTextSize(12.0f);
        }
        this.ls.setText("功能");
        linearLayout.addView(this.ls);
    }

    private void g(LinearLayout linearLayout, int i) {
        linearLayout.addView(gc());
        this.e = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.e.setLayoutParams(layoutParams);
        this.e.setAlpha(0.75f);
        this.e.setTextColor(Color.parseColor("#66161823"));
        if (this.z.getResources().getConfiguration().orientation == 2) {
            this.e.setTextSize(10.0f);
        } else {
            this.e.setTextSize(12.0f);
        }
        this.e.setText("权限");
        linearLayout.addView(this.e);
    }

    private ImageView gc() {
        ImageView imageView = new ImageView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(oq.dl(this.z, 0.5f), oq.dl(this.z, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private LinearLayout z(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(gc());
        this.v = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.v.setLayoutParams(layoutParams);
        this.v.setAlpha(0.75f);
        this.v.setTextColor(Color.parseColor("#66161823"));
        if (this.z.getResources().getConfiguration().orientation == 2) {
            this.v.setTextSize(10.0f);
        } else {
            this.v.setTextSize(12.0f);
        }
        this.v.setText("隐私");
        linearLayout2.addView(this.v);
        if (!TextUtils.isEmpty(this.io)) {
            linearLayout2.addView(gc());
            this.pf = new TextView(this.z);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.pf.setLayoutParams(layoutParams2);
            this.pf.setAlpha(0.75f);
            this.pf.setTextColor(Color.parseColor("#66161823"));
            if (this.z.getResources().getConfiguration().orientation == 2) {
                this.pf.setTextSize(10.0f);
            } else {
                this.pf.setTextSize(12.0f);
            }
            this.pf.setText("备案");
            linearLayout2.addView(this.pf);
        }
        this.h.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, oq.dl(this.z, 1.0f));
        layoutParams3.topMargin = oq.dl(this.z, 12.0f);
        layoutParams3.addRule(2, this.p.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.h.addView(view);
        z(i2, i);
        return linearLayout;
    }

    private LinearLayout g(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.z);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.z);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.h = new RelativeLayout(this.z);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.z, 8.0f));
        this.h.setBackground(gradientDrawable);
        this.h.setLayoutParams(layoutParams2);
        linearLayout.addView(this.h);
        return z(i, linearLayout);
    }

    private LinearLayout z(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.dl = new ImageView(this.z);
            int iDl = oq.dl(this.z, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDl, iDl);
            int iDl2 = oq.dl(this.z, 36.0f);
            layoutParams.topMargin = iDl2;
            layoutParams.rightMargin = iDl2;
            layoutParams.leftMargin = iDl2;
            layoutParams.bottomMargin = iDl2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.dl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.dl.setLayoutParams(layoutParams);
            this.dl.setMaxHeight(iDl);
            this.dl.setMaxWidth(iDl);
            this.dl.setMinimumHeight(iDl);
            this.dl.setMinimumWidth(iDl);
            com.bytedance.sdk.openadsdk.res.g gVar = new com.bytedance.sdk.openadsdk.res.g(oq.dl(this.z, 28.0f));
            gVar.z(Color.parseColor("#66161823"));
            float fDl = oq.dl(this.z, 2.0f);
            gVar.z(fDl);
            com.bytedance.sdk.openadsdk.res.dl dlVar = new com.bytedance.sdk.openadsdk.res.dl(oq.dl(this.z, 12.0f));
            dlVar.z(-1);
            dlVar.z(fDl);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, dlVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int iDl3 = oq.dl(this.z, 8.0f);
            layerDrawable.setLayerInset(1, iDl3, iDl3, iDl3, iDl3);
            this.dl.setImageDrawable(layerDrawable);
            this.h.addView(this.dl);
        }
        return linearLayout;
    }

    private void z(int i, ViewGroup viewGroup) {
        this.wp = new TextView(this.z);
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.i.getId());
            int iDl = oq.dl(this.z, 16.0f);
            layoutParams.leftMargin = iDl;
            layoutParams.rightMargin = iDl;
            layoutParams.topMargin = oq.dl(this.z, 30.0f);
            this.wp.setLayoutParams(layoutParams);
            this.wp.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.wp.setLayoutParams(layoutParams2);
        }
        this.wp.setEllipsize(TextUtils.TruncateAt.END);
        this.wp.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.wp.setTextSize(10.0f);
        } else {
            this.wp.setTextSize(12.0f);
        }
        viewGroup.addView(this.wp);
    }

    private void z(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = oq.dl(this.z, 14.0f);
            layoutParams.bottomMargin = oq.dl(this.z, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = oq.dl(this.z, 10.0f);
            layoutParams.bottomMargin = oq.dl(this.z, 24.0f);
            layoutParams.addRule(2, this.i.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(oq.dl(this.z, 3.0f));
        this.p.setBackground(gradientDrawable);
        this.p.setGravity(17);
        this.p.setText("立即下载");
        int iDl = oq.dl(this.z, 13.0f);
        this.p.setPadding(0, iDl, 0, iDl);
        this.p.setTextColor(-1);
        this.p.setLayoutParams(layoutParams);
        this.p.setTextSize(15.0f);
        this.h.addView(this.p);
        if (i2 != 1 || TextUtils.isEmpty(this.sy)) {
            return;
        }
        int iDl2 = oq.dl(this.z, 60.0f);
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g gVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g(this.z);
        this.fv = gVar;
        gVar.z(QMUISkinValueBuilder.SRC, this.sy);
        this.fv.z("loop", "true");
        this.fv.z("autoPlay", "true");
        this.fv.z(MediaFormat.KEY_WIDTH, String.valueOf(iDl2));
        this.fv.z(MediaFormat.KEY_HEIGHT, String.valueOf(iDl2));
        this.fv.z("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDl2, iDl2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.p.getId());
        layoutParams2.rightMargin = oq.dl(this.z, 73.0f);
        layoutParams2.topMargin = -oq.dl(this.z, 85.0f);
        this.fv.z(layoutParams2);
        UgenLottieView ugenLottieViewFo = this.fv.fo();
        if (ugenLottieViewFo == null) {
            return;
        }
        this.fv.g();
        this.h.addView(ugenLottieViewFo);
    }

    private View m() {
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.z);
        this.dl = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int iDl = oq.dl(this.z, 46.0f);
        this.dl.setMaxHeight(iDl);
        this.dl.setMaxWidth(iDl);
        this.dl.setMinimumHeight(iDl);
        this.dl.setMinimumWidth(iDl);
        com.bytedance.sdk.openadsdk.res.dl dlVar = new com.bytedance.sdk.openadsdk.res.dl(oq.dl(this.z, 14.0f));
        dlVar.z(-16777216);
        dlVar.z(oq.dl(this.z, 2.0f));
        this.dl.setImageDrawable(dlVar);
        relativeLayout.addView(this.dl);
        TextView textView = new TextView(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("应用详情");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.h.addView(relativeLayout);
        return z(relativeLayout);
    }

    private View z(RelativeLayout relativeLayout) {
        View view = new View(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oq.dl(this.z, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.h.addView(view);
        return view;
    }

    protected void g() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        this.g.clear();
        this.g.push(this.f1413a);
        this.g.push(this.gc);
        this.g.push(this.m);
        this.g.push(this.gz);
        this.g.push(this.fo);
        e();
        this.ls.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dl.this.x == null) {
                    return;
                }
                dl.this.x.gc(dl.this);
            }
        });
        if (this.pf != null && !TextUtils.isEmpty(this.io)) {
            this.pf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (dl.this.x != null) {
                        dl.this.x.m(dl.this);
                    }
                }
            });
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dl.this.x != null) {
                    dl.this.x.g(dl.this);
                }
            }
        });
        this.dl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dl.this.x != null) {
                    dl.this.x.dl(dl.this);
                }
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dl.this.x != null) {
                    dl.this.x.a(dl.this);
                }
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dl.this.x != null) {
                    dl.this.x.z(dl.this);
                }
            }
        });
    }

    private void e() {
        RelativeLayout relativeLayout;
        if (this.gk == null || (relativeLayout = this.h) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.h.getChildAt(i).setVisibility(4);
        }
        this.gk.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.dl.7
            @Override // java.lang.Runnable
            public void run() {
                dl.this.dl(childCount);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i) {
        try {
            Rect rect = new Rect();
            if (this.z.getResources().getConfiguration().orientation == 1) {
                this.wp.getGlobalVisibleRect(rect);
            } else {
                this.p.getGlobalVisibleRect(rect);
            }
            while (!this.g.isEmpty()) {
                Rect rect2 = new Rect();
                View viewPop = this.g.pop();
                if (viewPop != null && viewPop.getVisibility() != 8) {
                    viewPop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (viewPop == this.gc) {
                        View viewPop2 = this.g.pop();
                        if (viewPop2 != null) {
                            viewPop2.setVisibility(8);
                        }
                    } else {
                        viewPop.setVisibility(8);
                    }
                }
            }
            if (this.g.isEmpty()) {
                gz();
            }
        } catch (Throwable unused) {
        }
        this.h.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.h.getChildAt(i2).setVisibility(0);
        }
    }

    private void gz() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.p;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.p.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.p.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g gVar = this.fv;
        if (gVar != null) {
            UgenLottieView ugenLottieViewFo = gVar.fo();
            if (ugenLottieViewFo != null) {
                layoutParams = (RelativeLayout.LayoutParams) ugenLottieViewFo.getLayoutParams();
            } else {
                int iDl = oq.dl(this.z, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(iDl, iDl);
            }
            layoutParams.topMargin = -oq.dl(this.z, 53.0f);
            this.fv.z(layoutParams);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        z zVar = this.x;
        if (zVar != null) {
            zVar.dl(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        dl();
    }

    protected void dl() {
        String str;
        String str2;
        int iA;
        if (this.z == null) {
            this.z = zw.getContext();
        }
        int i = this.z.getResources().getConfiguration().orientation;
        TextView textView = this.gc;
        if (textView != null) {
            textView.setText(this.js);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.f1413a;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.f1413a != null && !TextUtils.isEmpty(this.tb)) {
            com.bytedance.sdk.openadsdk.gz.g.z(this.tb).to(this.f1413a);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.f1413a;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.m != null) {
            if (TextUtils.isEmpty(this.q)) {
                this.m.setVisibility(8);
            } else {
                this.m.setText(this.q);
            }
        }
        if (this.gz != null) {
            JSONArray jSONArray = this.hh;
            if (jSONArray == null || jSONArray.length() <= 0) {
                this.gz.setVisibility(8);
            } else {
                WindowManager windowManager = (WindowManager) this.z.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double dA = oq.a(this.z, width);
                        iA = ((int) (dA - (0.38d * dA))) - 80;
                    } else {
                        iA = oq.a(this.z, width) - 36;
                    }
                } else {
                    iA = 0;
                }
                int length = this.hh.length() <= 3 ? this.hh.length() : 3;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String strOptString = this.hh.optString(i2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        TextView textView2 = new TextView(this.z);
                        textView2.setText(strOptString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int iDl = oq.dl(this.z, 6.0f);
                        textView2.setPadding(iDl, 0, iDl, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int iDl2 = oq.dl(this.z, 3.0f);
                        layoutParams.leftMargin = iDl2;
                        layoutParams.rightMargin = iDl2;
                        textView2.setLayoutParams(layoutParams);
                        textView2.getPaint().getTextBounds(strOptString, 0, strOptString.length(), new Rect());
                        iA -= oq.a(this.z, r10.width()) + 20;
                        if (iA >= 0) {
                            this.gz.addView(textView2);
                        } else if (this.gz.getChildCount() <= 0) {
                            this.gz.setVisibility(8);
                        }
                    }
                    i2++;
                }
            }
        }
        if (this.uy != null && this.kb != null) {
            float f = this.l;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.fo;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.uy.setVisibility(8);
                this.kb.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.l = f;
                this.kb.setText(new DecimalFormat(".0").format(this.l));
                this.uy.setRating(this.l);
                this.uy.z(oq.dl(this.z, 16.0f), oq.dl(this.z, 15.0f));
                this.uy.z(oq.dl(this.z, 3.0f), 0, oq.dl(this.z, 3.0f), 0);
                this.uy.z();
            }
        }
        if (this.wp != null) {
            if (TextUtils.isEmpty(this.iq)) {
                str = String.format("版本号：%1$s", "暂无");
            } else {
                str = String.format("版本号：%1$s", this.iq);
            }
            if (i == 2) {
                TextPaint paint = this.wp.getPaint();
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                double dUy = oq.uy(this.z);
                int iWidth = (((int) (dUy - (0.4d * dUy))) - rect.width()) - oq.dl(this.z, 106.0f);
                TextView textView3 = this.v;
                if (textView3 != null) {
                    TextPaint paint2 = textView3.getPaint();
                    String string = this.v.getText().toString();
                    paint2.getTextBounds(string, 0, string.length(), rect);
                    iWidth -= rect.width();
                }
                TextView textView4 = this.e;
                if (textView4 != null) {
                    TextPaint paint3 = textView4.getPaint();
                    String string2 = this.e.getText().toString();
                    paint3.getTextBounds(string2, 0, string2.length(), rect);
                    iWidth -= rect.width();
                }
                TextView textView5 = this.ls;
                if (textView5 != null) {
                    TextPaint paint4 = textView5.getPaint();
                    String string3 = this.ls.getText().toString();
                    paint4.getTextBounds(string3, 0, string3.length(), rect);
                    iWidth -= rect.width();
                }
                if (this.pf != null && !TextUtils.isEmpty(this.io)) {
                    TextPaint paint5 = this.pf.getPaint();
                    String string4 = this.pf.getText().toString();
                    paint5.getTextBounds(string4, 0, TextUtils.isEmpty(string4) ? 0 : string4.length(), rect);
                    iWidth -= rect.width();
                }
                if (iWidth <= 0) {
                    ((LinearLayout.LayoutParams) this.wp.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i == 1) {
                this.wp.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.i;
        if (textView6 != null) {
            textView6.setSelected(true);
            if (TextUtils.isEmpty(this.uf)) {
                str2 = String.format("开发者：%1$s", "补充中，可于应用官网查看");
            } else {
                str2 = String.format("开发者：%1$s", this.uf);
            }
            if (i == 2) {
                str2 = str2 + "  " + str;
            }
            this.i.setText(str2);
        }
    }

    public dl z(String str) {
        this.js = str;
        return this;
    }

    public dl g(String str) {
        this.tb = str;
        return this;
    }

    public dl dl(String str) {
        this.sy = str;
        return this;
    }

    public dl a(String str) {
        this.q = str;
        return this;
    }

    public dl gc(String str) {
        this.iq = str;
        return this;
    }

    public dl m(String str) {
        this.zw = str;
        return this;
    }

    public dl e(String str) {
        this.io = str;
        return this;
    }

    public dl gz(String str) {
        this.uf = str;
        return this;
    }

    public dl z(JSONArray jSONArray) {
        this.hh = jSONArray;
        return this;
    }

    public dl z(float f) {
        this.l = f;
        return this;
    }

    public dl z(z zVar) {
        this.x = zVar;
        return this;
    }

    public String a() {
        return this.lq;
    }

    public dl fo(String str) {
        this.lq = str;
        return this;
    }
}
