package com.anythink.expressad.foundation.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.anythink.core.common.b.n;
import com.anythink.expressad.d.a;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.FeedBackButton;
import com.anythink.expressad.widget.FeedbackRadioGroup;
import com.anythink.expressad.widget.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f10384n = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f10385s;
    private String a;
    private c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FeedBackButton f10386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10388e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10394k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.anythink.expressad.widget.a.c f10398p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<C0206a> f10399q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10389f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10390g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10391h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10392i = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f10395l = 1.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f10396m = t.b(n.a().g(), 20.0f);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f10397o = f10384n;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private b f10400r = new b() { // from class: com.anythink.expressad.foundation.f.a.a.1
        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            a.a(a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            a.b(a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
            a.c(a.this);
        }
    };

    public a(String str) {
        this.f10399q = new ArrayList();
        this.a = str;
        if (this.f10399q == null) {
            this.f10399q = new ArrayList();
        }
        g();
        n();
        h();
    }

    private void g() {
        if (this.f10400r == null) {
            this.f10400r = new b() { // from class: com.anythink.expressad.foundation.f.a.a.2
                @Override // com.anythink.expressad.widget.a.b
                public final void a() {
                    a.a(a.this);
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void h() {
        try {
            com.anythink.expressad.foundation.f.b.a();
            if (com.anythink.expressad.foundation.f.b.a(n.a().g()) != null) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.foundation.b.a.b().e();
                com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
                if (aVarB == null) {
                    com.anythink.expressad.d.b.a();
                    aVarB = com.anythink.expressad.d.b.c();
                }
                a.b bVarL = aVarB.L();
                if (bVarL == null) {
                    o.b("", "feedback fbk is null");
                    return;
                }
                g();
                com.anythink.expressad.foundation.f.b.a();
                this.f10398p = new com.anythink.expressad.widget.a.c(com.anythink.expressad.foundation.f.b.a(n.a().g()), this.f10400r);
                FeedbackRadioGroup feedbackRadioGroupA = a(bVarL);
                this.f10398p.c(bVarL.c());
                this.f10398p.b(bVarL.b());
                this.f10398p.a(bVarL.a());
                this.f10398p.a(feedbackRadioGroupA);
                this.f10398p.a(!TextUtils.isEmpty(f10385s));
                a(feedbackRadioGroupA, bVarL);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        List<C0206a> list = this.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.b();
                }
            }
        }
        f10385s = "";
    }

    private void j() {
        List<C0206a> list = this.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.a();
                }
            }
        }
        f10385s = "";
    }

    private void k() {
        List<C0206a> list = this.f10399q;
        if (list != null) {
            Iterator<C0206a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private String l() {
        return this.a;
    }

    private void m() {
        FeedBackButton feedBackButton = this.f10386c;
        if (feedBackButton != null) {
            int i2 = this.f10389f;
            if (i2 >= 0) {
                feedBackButton.setX(i2);
            }
            int i3 = this.f10390g;
            if (i3 >= 0) {
                this.f10386c.setY(i3);
            }
            float f2 = this.f10395l;
            if (f2 >= 0.0f) {
                this.f10386c.setAlpha(f2);
                this.f10386c.setEnabled(this.f10395l != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f10386c.getLayoutParams();
            int i4 = this.f10391h;
            if (i4 > 0) {
                this.f10386c.setWidth(i4);
                if (layoutParams != null) {
                    layoutParams.width = this.f10391h;
                }
            }
            int i5 = this.f10392i;
            if (i5 > 0) {
                this.f10386c.setHeight(i5);
                if (layoutParams != null) {
                    layoutParams.height = this.f10392i;
                }
            }
            if (layoutParams != null) {
                this.f10386c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.f10393j)) {
                    this.f10386c.setTextColor(Color.parseColor(this.f10393j));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i6 = this.f10396m;
            if (i6 > 0) {
                gradientDrawable.setCornerRadius(i6);
            }
            if (TextUtils.isEmpty(this.f10394k)) {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(Color.parseColor(this.f10394k));
            }
            try {
                this.f10386c.setBackgroundDrawable(gradientDrawable);
            } catch (Throwable unused) {
            }
        }
    }

    private void n() {
        Context contextG = n.a().g();
        if (contextG != null) {
            try {
                this.f10386c = new FeedBackButton(contextG);
                FeedBackButton feedBackButton = this.f10386c;
                int i2 = 8;
                if (this.f10397o != 8) {
                    i2 = 0;
                }
                feedBackButton.setVisibility(i2);
                this.f10386c.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.f.a.a.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.this.a();
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private int o() {
        return this.f10387d;
    }

    private int p() {
        return this.f10388e;
    }

    public final void b() {
        com.anythink.expressad.widget.a.c cVar = this.f10398p;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.f10398p.cancel();
    }

    public final FeedBackButton c() {
        if (this.f10386c == null) {
            n();
        }
        return this.f10386c;
    }

    public final c e() {
        return this.b;
    }

    public final void a() {
        com.anythink.expressad.foundation.f.b.a();
        Activity activityA = com.anythink.expressad.foundation.f.b.a(n.a().g());
        com.anythink.expressad.widget.a.c cVar = this.f10398p;
        if (cVar == null || cVar.getContext() != activityA) {
            h();
        }
        Context contextG = n.a().g();
        FeedBackButton feedBackButton = this.f10386c;
        if (feedBackButton != null) {
            contextG = feedBackButton.getContext();
        }
        com.anythink.expressad.foundation.f.b.a();
        boolean zA = com.anythink.expressad.foundation.f.b.a(contextG, this.f10398p);
        List<C0206a> list = this.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.a(zA);
                }
            }
        }
    }

    public final void d() {
        FeedBackButton feedBackButton = this.f10386c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f10386c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f10386c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f10386c);
            }
        }
        com.anythink.expressad.widget.a.c cVar = this.f10398p;
        if (cVar != null) {
            cVar.a((b) null);
        }
        this.f10398p = null;
        this.f10399q = null;
        this.f10386c = null;
        this.f10400r = null;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.f.a.a$a, reason: collision with other inner class name */
    public static class C0206a implements b {
        private com.anythink.expressad.foundation.f.a a;
        private String b;

        public C0206a(String str, com.anythink.expressad.foundation.f.a aVar) {
            this.a = aVar;
            this.b = str;
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.foundation.f.b.f10401c = false;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar != null) {
                String unused = a.f10385s;
                aVar.c();
            }
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.foundation.f.b.f10401c = false;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
        }

        public final void a(boolean z2) {
            com.anythink.expressad.foundation.f.b.f10401c = true;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar == null || !z2) {
                return;
            }
            aVar.a();
        }
    }

    private void b(C0206a c0206a) {
        List<C0206a> list = this.f10399q;
        if (list != null) {
            list.remove(c0206a);
        }
    }

    public final void c(int i2) {
        this.f10388e = i2;
    }

    static /* synthetic */ void c(a aVar) {
        List<C0206a> list = aVar.f10399q;
        if (list != null) {
            Iterator<C0206a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void b(int i2) {
        this.f10387d = i2;
    }

    static /* synthetic */ void b(a aVar) {
        List<C0206a> list = aVar.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.b();
                }
            }
        }
        f10385s = "";
    }

    public final void a(int i2) {
        this.f10397o = i2;
        FeedBackButton feedBackButton = this.f10386c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i2);
        }
    }

    private void a(FeedbackRadioGroup feedbackRadioGroup, a.b bVar) {
        ColorStateList colorStateList;
        JSONArray jSONArrayD = bVar.d();
        Context contextG = n.a().g();
        if (jSONArrayD == null || jSONArrayD.length() <= 0 || contextG == null) {
            return;
        }
        int iA = i.a(contextG, "anythink_cm_feedback_choice_btn_bg", i.f10645c);
        Resources resourcesA = i.a(contextG);
        int iA2 = i.a(contextG, "anythink_cm_feedback_rb_text_color_color_list", i.f10646d);
        if (resourcesA != null) {
            try {
                colorStateList = resourcesA.getColorStateList(iA2);
            } catch (Exception e2) {
                e2.printStackTrace();
                colorStateList = null;
            }
        } else {
            colorStateList = null;
        }
        int iB = t.b(contextG, 14.0f);
        int iB2 = t.b(contextG, 7.0f);
        int iB3 = t.b(contextG, 6.0f);
        for (int i2 = 0; i2 < jSONArrayD.length(); i2++) {
            String strOptString = jSONArrayD.optString(i2);
            RadioButton radioButton = new RadioButton(contextG);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setBackgroundResource(iA);
            radioButton.setText(strOptString);
            if (colorStateList != null) {
                radioButton.setTextColor(colorStateList);
            }
            radioButton.setPadding(iB, iB2, iB, iB2);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
            int i3 = iB3 / 4;
            layoutParams.setMargins(iB3, i3, iB3, i3);
            a(radioButton);
            feedbackRadioGroup.addView(radioButton, layoutParams);
        }
    }

    private static FeedbackRadioGroup a(a.b bVar) {
        JSONArray jSONArrayD = bVar.d();
        Context contextG = n.a().g();
        if (jSONArrayD == null || jSONArrayD.length() <= 0 || contextG == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(contextG);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.anythink.expressad.foundation.f.a.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2) {
                    String unused = a.f10385s = (String) compoundButton.getText();
                }
                if (a.this.f10398p != null) {
                    a.this.f10398p.a(!TextUtils.isEmpty(a.f10385s));
                }
            }
        });
    }

    public final void a(C0206a c0206a) {
        if (this.f10399q == null) {
            this.f10399q = new ArrayList();
        }
        this.f10399q.add(c0206a);
    }

    private void a(boolean z2) {
        List<C0206a> list = this.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.a(z2);
                }
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, float f2, String str, String str2) {
        this.f10389f = i2;
        this.f10390g = i3;
        this.f10391h = i4;
        this.f10392i = i5;
        this.f10393j = str;
        this.f10394k = str2;
        this.f10395l = f2;
        this.f10396m = i6;
        m();
    }

    public final void a(c cVar) {
        this.b = cVar;
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f10386c;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f10395l);
            feedBackButton.setEnabled(this.f10395l != 0.0f);
            feedBackButton.setVisibility(this.f10397o != 8 ? 0 : 8);
            this.f10386c = feedBackButton;
            c cVar = this.b;
            if (cVar != null && !cVar.j()) {
                m();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.f.a.a.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        List<C0206a> list = aVar.f10399q;
        if (list != null) {
            for (C0206a c0206a : list) {
                if (c0206a != null) {
                    c0206a.a();
                }
            }
        }
        f10385s = "";
    }
}
