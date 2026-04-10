package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class m extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f1422a;
    public View.OnClickListener dl;
    private Button e;
    private Button fo;
    private Drawable fv;
    public z g;
    private TextView gc;
    private Button gz;
    private String i;
    private boolean js;
    private ViewGroup kb;
    private String ls;
    private TextView m;
    private int p;
    private String pf;
    private View tb;
    private View uy;
    private String v;
    private Context wp;
    TTProgressBar z;

    public interface z {
        void g();

        void z();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public m(Context context) {
        super(context);
        this.p = -1;
        this.js = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.wp = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewQd = this.tb;
        if (viewQd == null) {
            viewQd = com.bytedance.sdk.openadsdk.res.gc.qd(this.wp);
        }
        setContentView(viewQd);
        gc();
        a();
        dl();
    }

    private void dl() {
        oq.z(this.gz, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.g != null) {
                    m.this.g.z();
                }
            }
        }, "positiveBn");
        oq.z(this.e, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.g != null) {
                    m.this.g.g();
                }
            }
        }, "negtiveBn");
        oq.z(this.fo, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.dl != null) {
                    m.this.dl.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void a() {
        Button button;
        if (this.gc != null) {
            if (!TextUtils.isEmpty(this.v)) {
                this.gc.setText(this.v);
                this.gc.setVisibility(0);
            } else {
                this.gc.setVisibility(8);
            }
        }
        if (this.m != null && !TextUtils.isEmpty(this.i)) {
            this.m.setText(this.i);
        }
        if (this.gz != null) {
            if (!TextUtils.isEmpty(this.pf)) {
                this.gz.setText(this.pf);
            } else {
                this.gz.setText("确定");
            }
            int i = this.p;
            if (i != -1) {
                this.gz.setBackgroundColor(i);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(this.ls)) {
                this.e.setText(this.ls);
            } else {
                this.e.setText("取消");
            }
        }
        ImageView imageView = this.f1422a;
        if (imageView != null) {
            Drawable drawable = this.fv;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.f1422a.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.uy;
        if (view == null || (button = this.e) == null) {
            return;
        }
        if (this.js) {
            view.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.uy;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            a();
        } catch (Exception unused) {
        }
    }

    private void gc() {
        this.e = (Button) findViewById(2114387829);
        this.gz = (Button) findViewById(2114387914);
        this.gc = (TextView) findViewById(2114387802);
        this.m = (TextView) findViewById(2114387857);
        this.f1422a = (ImageView) findViewById(2114387832);
        this.uy = findViewById(2114387775);
        this.kb = (ViewGroup) findViewById(2114387849);
        this.fo = (Button) findViewById(2114387749);
    }

    public m z(z zVar) {
        this.g = zVar;
        return this;
    }

    public m z(View.OnClickListener onClickListener) {
        this.dl = onClickListener;
        return this;
    }

    public m z(String str) {
        this.i = str;
        return this;
    }

    public m g(String str) {
        this.v = str;
        return this;
    }

    public m dl(String str) {
        this.pf = str;
        return this;
    }

    public m a(String str) {
        this.ls = str;
        return this;
    }

    public m z(int i) {
        this.p = i;
        return this;
    }

    public m z(Drawable drawable) {
        this.fv = drawable;
        return this;
    }

    public m z(View view) {
        this.tb = view;
        return this;
    }

    public void z() {
        if (this.kb == null) {
            return;
        }
        if (this.z == null) {
            try {
                this.z = new TTProgressBar(this.wp);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
                layoutParams.gravity = 17;
                this.z.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(oq.dl(this.wp, 2.0f));
                this.z.setBackground(gradientDrawable);
                int iDl = oq.dl(this.wp, 10.0f);
                this.z.setPadding(iDl, iDl, iDl, iDl);
                this.z.setIndeterminateDrawable(tb.dl(this.wp, "tt_video_loading_progress_bar"));
                this.kb.addView(this.z);
            } catch (Exception unused) {
            }
        }
        this.kb.setVisibility(0);
    }

    public void g() {
        ViewGroup viewGroup = this.kb;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
