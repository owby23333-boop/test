package com.anythink.basead;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public i a;
    public j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Dialog f5869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f5870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditText f5871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f5872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f5873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f5875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f5876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f5877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f5878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f5879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f5880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f5881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f5882q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f5883r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a f5884s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View.OnClickListener f5885t = new View.OnClickListener() { // from class: com.anythink.basead.c.5
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view instanceof TextView) {
                c cVar = c.this;
                com.anythink.core.common.j.c.a(cVar.a, cVar.b, ((TextView) view).getTag().toString(), "");
                c.b(c.this);
                if (c.this.f5884s != null) {
                    c.this.f5884s.a();
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.anythink.basead.c$1, reason: invalid class name */
    final class AnonymousClass1 implements DialogInterface.OnCancelListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            if (c.this.f5884s != null) {
                c.this.f5884s.b();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.c$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.b(c.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.c$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.f5871f != null) {
                String string = c.this.f5871f.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    c cVar = c.this;
                    com.anythink.core.common.j.c.a(cVar.a, cVar.b, "0", string);
                    c.b(c.this);
                    if (c.this.f5884s != null) {
                        c.this.f5884s.a();
                        return;
                    }
                    return;
                }
                if (c.this.f5883r) {
                    return;
                }
                c.this.f5883r = true;
                c.this.f5871f.setCursorVisible(false);
                c.this.f5871f.setHint(h.a(c.this.f5868c, "myoffer_feedback_hint", com.anythink.expressad.foundation.h.i.f10649g));
                c.this.f5871f.setHintTextColor(Color.parseColor("#999999"));
                c.this.f5871f.postDelayed(new Runnable() { // from class: com.anythink.basead.c.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.f5883r = false;
                        c.this.f5871f.setCursorVisible(true);
                        c.this.f5871f.setHint("");
                    }
                }, 1500L);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.c$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.f5869d != null) {
                c.this.f5869d.dismiss();
            }
            if (c.this.f5884s != null) {
                c.this.f5884s.b();
            }
        }
    }

    public interface a {
        void a();

        void b();
    }

    public final void b() {
        this.f5868c = null;
        this.a = null;
        this.b = null;
        this.f5884s = null;
    }

    private void c() {
        this.f5872g = (ImageView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_iv_close", "id"));
        this.f5871f = (EditText) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_et", "id"));
        this.f5873h = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_commit", "id"));
        this.f5874i = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_1", "id"));
        this.f5875j = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_2", "id"));
        this.f5876k = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_3", "id"));
        this.f5877l = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_4", "id"));
        this.f5878m = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_5", "id"));
        this.f5879n = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_6", "id"));
        this.f5880o = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_7", "id"));
        this.f5881p = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_8", "id"));
        this.f5882q = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_9", "id"));
        this.f5872g.setOnClickListener(new AnonymousClass2());
        this.f5874i.setOnClickListener(this.f5885t);
        this.f5875j.setOnClickListener(this.f5885t);
        this.f5876k.setOnClickListener(this.f5885t);
        this.f5877l.setOnClickListener(this.f5885t);
        this.f5878m.setOnClickListener(this.f5885t);
        this.f5879n.setOnClickListener(this.f5885t);
        this.f5880o.setOnClickListener(this.f5885t);
        this.f5881p.setOnClickListener(this.f5885t);
        this.f5882q.setOnClickListener(this.f5885t);
        this.f5873h.setOnClickListener(new AnonymousClass3());
    }

    private void d() {
        this.f5872g.setOnClickListener(new AnonymousClass2());
        this.f5874i.setOnClickListener(this.f5885t);
        this.f5875j.setOnClickListener(this.f5885t);
        this.f5876k.setOnClickListener(this.f5885t);
        this.f5877l.setOnClickListener(this.f5885t);
        this.f5878m.setOnClickListener(this.f5885t);
        this.f5879n.setOnClickListener(this.f5885t);
        this.f5880o.setOnClickListener(this.f5885t);
        this.f5881p.setOnClickListener(this.f5885t);
        this.f5882q.setOnClickListener(this.f5885t);
        this.f5873h.setOnClickListener(new AnonymousClass3());
    }

    private void e() {
        new Handler().postDelayed(new AnonymousClass4(), 30L);
    }

    public final void a(Context context, i iVar, j jVar, a aVar) {
        try {
            this.f5868c = context;
            this.a = iVar;
            this.b = jVar;
            this.f5884s = aVar;
            int i2 = context.getResources().getDisplayMetrics().widthPixels;
            int i3 = context.getResources().getDisplayMetrics().heightPixels;
            if (i2 > i3) {
                this.f5870e = LayoutInflater.from(context).inflate(h.a(context, "myoffer_feedback_land", "layout"), (ViewGroup) null, false);
            } else {
                this.f5870e = LayoutInflater.from(context).inflate(h.a(context, "myoffer_feedback", "layout"), (ViewGroup) null, false);
            }
            this.f5872g = (ImageView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_iv_close", "id"));
            this.f5871f = (EditText) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_et", "id"));
            this.f5873h = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_commit", "id"));
            this.f5874i = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_1", "id"));
            this.f5875j = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_2", "id"));
            this.f5876k = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_3", "id"));
            this.f5877l = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_4", "id"));
            this.f5878m = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_5", "id"));
            this.f5879n = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_6", "id"));
            this.f5880o = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_7", "id"));
            this.f5881p = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_8", "id"));
            this.f5882q = (TextView) this.f5870e.findViewById(h.a(this.f5868c, "myoffer_feedback_tv_9", "id"));
            this.f5872g.setOnClickListener(new AnonymousClass2());
            this.f5874i.setOnClickListener(this.f5885t);
            this.f5875j.setOnClickListener(this.f5885t);
            this.f5876k.setOnClickListener(this.f5885t);
            this.f5877l.setOnClickListener(this.f5885t);
            this.f5878m.setOnClickListener(this.f5885t);
            this.f5879n.setOnClickListener(this.f5885t);
            this.f5880o.setOnClickListener(this.f5885t);
            this.f5881p.setOnClickListener(this.f5885t);
            this.f5882q.setOnClickListener(this.f5885t);
            this.f5873h.setOnClickListener(new AnonymousClass3());
            this.f5869d = new Dialog(this.f5868c, h.a(this.f5868c, "myoffer_feedback_dialog", com.anythink.expressad.foundation.h.i.f10647e));
            this.f5869d.setContentView(this.f5870e);
            this.f5869d.setCancelable(true);
            this.f5869d.setOnCancelListener(new AnonymousClass1());
            Window window = this.f5869d.getWindow();
            if (window != null) {
                if (i2 > i3) {
                    window.setLayout(h.a(this.f5868c, 280.0f), h.a(this.f5868c, 320.0f));
                } else {
                    window.setLayout(h.a(this.f5868c, 300.0f), h.a(this.f5868c, 426.0f));
                }
            }
            this.f5869d.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void b(c cVar) {
        new Handler().postDelayed(cVar.new AnonymousClass4(), 30L);
    }

    private void a(int i2, int i3) {
        Context context = this.f5868c;
        this.f5869d = new Dialog(context, h.a(context, "myoffer_feedback_dialog", com.anythink.expressad.foundation.h.i.f10647e));
        this.f5869d.setContentView(this.f5870e);
        this.f5869d.setCancelable(true);
        this.f5869d.setOnCancelListener(new AnonymousClass1());
        Window window = this.f5869d.getWindow();
        if (window != null) {
            if (i2 > i3) {
                window.setLayout(h.a(this.f5868c, 280.0f), h.a(this.f5868c, 320.0f));
            } else {
                window.setLayout(h.a(this.f5868c, 300.0f), h.a(this.f5868c, 426.0f));
            }
        }
        this.f5869d.show();
    }

    public final boolean a() {
        Dialog dialog = this.f5869d;
        return dialog != null && dialog.isShowing();
    }
}
