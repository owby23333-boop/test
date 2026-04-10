package com.bytedance.mtesttools.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.d;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.c;
import com.bytedance.msdk.api.AdError;
import com.bytedance.mtesttools.base.BaseActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: loaded from: classes2.dex */
public class AdSlotDetailActivity extends BaseActivity implements View.OnClickListener, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a {
    FrameLayout A;
    FrameLayout B;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a C;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b D;
    private int E;
    private int F = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ListView f14450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f14451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TextView f14452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f14453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TextView f14454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ImageView f14455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TextView f14456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TextView f14457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TextView f14458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    RelativeLayout f14459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    TextView f14460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    TextView f14461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    View f14462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f14463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextView f14464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    TextView f14465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    TextView f14466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ProgressBar f14467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    TextView f14468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    e f14469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f14470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    g f14471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    FrameLayout f14472y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    FrameLayout f14473z;

    class a implements b.d {
        a() {
        }

        @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b.d
        public void a(int i2) {
            AdSlotDetailActivity.this.E = i2;
            if (AdSlotDetailActivity.this.E == 1) {
                if (AdSlotDetailActivity.this.f14469v.j() == 7) {
                    AdSlotDetailActivity.this.f14457j.setText("模版（模版2.0）");
                    return;
                } else {
                    AdSlotDetailActivity.this.f14457j.setText("模板（含广点通1.0）");
                    return;
                }
            }
            if (AdSlotDetailActivity.this.E == 2) {
                AdSlotDetailActivity.this.f14457j.setText("自渲染");
            } else {
                AdSlotDetailActivity.this.f14457j.setText("模板（含广点通2.0）");
            }
        }

        @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b.d
        public void onCancel() {
        }
    }

    class b implements a.d {
        b() {
        }

        @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a.d
        public void a(int i2) {
            AdSlotDetailActivity.this.F = i2;
            if (AdSlotDetailActivity.this.F == 1) {
                AdSlotDetailActivity.this.f14460m.setText("竖版");
            } else {
                AdSlotDetailActivity.this.f14460m.setText("横版");
            }
        }

        @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a.d
        public void onCancel() {
        }
    }

    private void c() {
        this.f14466s.setOnClickListener(this);
        this.f14458k.setOnClickListener(this);
        this.f14461n.setOnClickListener(this);
    }

    private void d() {
        this.f14451d = new d(this);
        this.f14450c.setAdapter((ListAdapter) this.f14451d);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.ttt_slot_info_layout, (ViewGroup) this.f14450c, false);
        this.f14452e = (TextView) viewInflate.findViewById(R$id.slot_id);
        this.f14453f = (TextView) viewInflate.findViewById(R$id.bidding_ad);
        this.f14454g = (TextView) viewInflate.findViewById(R$id.ad_type);
        this.f14455h = (ImageView) viewInflate.findViewById(R$id.adn_icon);
        this.f14456i = (TextView) viewInflate.findViewById(R$id.adn_type);
        this.f14457j = (TextView) viewInflate.findViewById(R$id.render_type);
        this.f14458k = (TextView) viewInflate.findViewById(R$id.render_type_edit);
        this.f14459l = (RelativeLayout) viewInflate.findViewById(R$id.orientation_layout);
        this.f14460m = (TextView) viewInflate.findViewById(R$id.orientation_type);
        this.f14461n = (TextView) viewInflate.findViewById(R$id.orientation_type_edit);
        this.f14462o = viewInflate.findViewById(R$id.space_top);
        this.f14463p = viewInflate.findViewById(R$id.space_bottom);
        this.f14464q = (TextView) viewInflate.findViewById(R$id.ad_load_title);
        this.f14465r = (TextView) viewInflate.findViewById(R$id.ad_load_desc);
        this.f14466s = (TextView) viewInflate.findViewById(R$id.ad_load_btn);
        this.f14467t = (ProgressBar) viewInflate.findViewById(R$id.progress_bar);
        this.f14468u = (TextView) viewInflate.findViewById(R$id.progress_text);
        this.f14473z = (FrameLayout) viewInflate.findViewById(R$id.banner_container);
        this.A = (FrameLayout) viewInflate.findViewById(R$id.feed_container);
        this.B = (FrameLayout) viewInflate.findViewById(R$id.draw_container);
        b();
        this.f14450c.addHeaderView(viewInflate);
        this.f14451d.a(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.e.a(this.f14469v.j(), this.f14469v.h()));
        if (this.f14469v.k()) {
            this.f14453f.setVisibility(0);
        } else {
            this.f14453f.setVisibility(8);
        }
        this.f14452e.setText(this.f14469v.c());
        this.f14454g.setText(com.bytedance.mtesttools.base.a.a(this.f14469v.j()));
        if (this.f14469v.b() > 0) {
            this.f14455h.setImageResource(this.f14469v.b());
        }
        this.f14456i.setText(this.f14469v.a());
    }

    private void e() {
        this.f14451d.a();
        if (this.f14469v.j() == 5) {
            if (this.E == 0) {
                bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "请选择渲染类型");
                return;
            }
        } else if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 7) {
            if (this.E == 0) {
                bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "请选择渲染类型");
                return;
            }
        } else if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 2) {
            if (this.E == 0) {
                bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "请选择渲染类型");
                return;
            }
        } else if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 8 && this.E == 0) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "请选择渲染类型");
            return;
        }
        f();
        this.f14471x = c.a(this.f14469v);
        if (this.f14471x != null) {
            n();
            this.f14471x.b(this, this.f14469v, this.E, this.F, this);
        }
    }

    private void f() {
        FrameLayout frameLayout = this.f14473z;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
        }
        FrameLayout frameLayout3 = this.B;
        if (frameLayout3 != null) {
            frameLayout3.removeAllViews();
        }
    }

    private void g() {
        g gVar = this.f14471x;
        if (gVar == null || !gVar.g()) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "正在缓存中，请稍后重试");
            return;
        }
        this.f14470w = false;
        this.f14464q.setText("您还没有加载任何广告");
        this.f14465r.setVisibility(0);
        this.f14462o.setVisibility(8);
        this.f14463p.setVisibility(8);
        this.f14466s.setText("加载广告");
        switch (this.f14469v.j()) {
            case 1:
                h();
                break;
            case 2:
                l();
                break;
            case 3:
                p();
                break;
            case 5:
                j();
                break;
            case 7:
                o();
                break;
            case 8:
                k();
                break;
            case 9:
                i();
                break;
            case 10:
                m();
                break;
        }
    }

    private void h() {
        this.f14473z.setVisibility(0);
        this.f14471x.a(this, this.f14473z);
    }

    private void i() {
        this.B.setVisibility(0);
        this.f14471x.a(this, this.B);
    }

    private void j() {
        this.A.setVisibility(0);
        this.f14471x.a(this, this.A);
    }

    private void k() {
        this.f14471x.a(this, null);
    }

    private void l() {
        this.f14471x.a(this, null);
    }

    private void m() {
        this.f14471x.a(this, null);
    }

    private void n() {
        this.f14464q.setVisibility(8);
        this.f14465r.setVisibility(8);
        this.f14466s.setVisibility(8);
        this.f14467t.setVisibility(0);
        this.f14468u.setVisibility(0);
    }

    private void o() {
        this.f14471x.a(this, null);
    }

    private void p() {
        this.f14472y.setVisibility(0);
        this.f14471x.a(this, this.f14472y);
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        e eVar = this.f14469v;
        if (eVar != null) {
            intent.putExtra("slot_id", eVar.c());
            intent.putExtra("load_status", this.f14469v.f());
        }
        setResult(-1, intent);
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.ad_load_btn) {
            if (this.f14470w) {
                g();
                return;
            } else {
                e();
                return;
            }
        }
        if (id != R$id.render_type_edit) {
            if (id == R$id.orientation_type_edit) {
                if (this.C == null) {
                    this.C = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.a(this, new b());
                }
                this.C.show();
                return;
            }
            return;
        }
        e eVar = this.f14469v;
        if (eVar == null) {
            return;
        }
        if (this.D == null) {
            this.D = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_for12.b(this, eVar.j(), new a());
        }
        this.D.show();
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f14450c = (ListView) findViewById(R$id.callback_list);
        this.f14472y = (FrameLayout) findViewById(R$id.splash_container);
        this.f14469v = (e) getIntent().getSerializableExtra("water_fall_config");
        if (this.f14469v == null) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g.a(this, "暂无数据，请稍后重试");
            finish();
            return;
        }
        a("代码位详情", true);
        d();
        c();
        if (this.f14469v.j() == 7 || this.f14469v.j() == 8) {
            this.f14459l.setVisibility(0);
            if (this.F == 1) {
                this.f14460m.setText("竖版");
            } else {
                this.f14460m.setText("横版");
            }
        } else {
            this.f14459l.setVisibility(8);
        }
        this.E = this.f14469v.g();
        if (this.f14469v.j() == 5) {
            if (this.f14469v.g() <= 0) {
                this.f14458k.setVisibility(0);
                this.f14457j.setText("—");
                return;
            }
            this.f14458k.setVisibility(8);
            int i2 = this.E;
            if (i2 == 1) {
                this.f14457j.setText("模板（含广点通1.0）");
                return;
            } else if (i2 == 2) {
                this.f14457j.setText("自渲染");
                return;
            } else {
                this.f14457j.setText("模板（含广点通2.0）");
                return;
            }
        }
        if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 7) {
            if (this.f14469v.g() <= 0) {
                this.f14458k.setVisibility(0);
                this.f14457j.setText("—");
                return;
            }
            this.f14458k.setVisibility(8);
            int i3 = this.E;
            if (i3 == 2) {
                this.f14457j.setText("自渲染");
                return;
            } else if (i3 == 1) {
                this.f14457j.setText("模版（模版2.0）");
                return;
            } else {
                this.f14457j.setText("—");
                return;
            }
        }
        if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 2) {
            if (this.f14469v.g() <= 0) {
                this.f14458k.setVisibility(0);
                this.f14457j.setText("—");
                return;
            }
            this.f14458k.setVisibility(8);
            int i4 = this.E;
            if (i4 == 1) {
                this.f14457j.setText("模板（含广点通1.0）");
                return;
            } else if (i4 == 2) {
                this.f14457j.setText("自渲染");
                return;
            } else {
                this.f14457j.setText("模板（含广点通2.0）");
                return;
            }
        }
        if ("gdt".equals(this.f14469v.d()) && this.f14469v.j() == 8) {
            if (this.f14469v.g() <= 0) {
                this.f14458k.setVisibility(0);
                this.f14457j.setText("—");
                return;
            }
            this.f14458k.setVisibility(8);
            int i5 = this.E;
            if (i5 == 1) {
                this.f14457j.setText("模板（含广点通1.0）");
                return;
            } else if (i5 == 2) {
                this.f14457j.setText("自渲染");
                return;
            } else {
                this.f14457j.setText("模板（含广点通2.0）");
                return;
            }
        }
        if (this.f14469v.j() != 9) {
            this.f14458k.setVisibility(8);
            this.f14457j.setText("—");
            return;
        }
        if ("gdt".equals(this.f14469v.d())) {
            this.f14458k.setVisibility(8);
            this.f14457j.setText("自渲染");
            return;
        }
        if ("ks".equals(this.f14469v.d())) {
            this.f14458k.setVisibility(8);
            this.f14457j.setText("模板");
            return;
        }
        int i6 = this.E;
        if (i6 == 1) {
            this.f14457j.setText("模板");
        } else if (i6 == 2) {
            this.f14457j.setText("自渲染");
        } else {
            this.f14457j.setText("-");
        }
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity
    protected int a() {
        return R$layout.ttt_activity_ad_slot;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a
    public void b(String str, AdError adError) {
        b();
        if (adError == null) {
            this.f14470w = true;
            this.f14464q.setText("您的广告已加载成功");
            this.f14462o.setVisibility(0);
            this.f14463p.setVisibility(0);
            this.f14465r.setVisibility(8);
            this.f14466s.setText("展示广告");
            this.f14469v.d(1);
            this.f14451d.a(str);
            return;
        }
        this.f14465r.setVisibility(0);
        this.f14464q.setText("您的广告加载失败");
        this.f14466s.setText("重新加载");
        this.f14462o.setVisibility(8);
        this.f14463p.setVisibility(8);
        this.f14469v.d(2);
        this.f14451d.a(str, adError);
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a
    public void a(String str, AdError adError) {
        if ("onAdSkip".equals(str) || "onAdDismiss".equals(str)) {
            this.f14472y.setVisibility(8);
        }
        if (adError != null) {
            this.f14451d.a(str, adError);
            return;
        }
        g gVar = this.f14471x;
        if (gVar != null) {
            this.f14451d.a(str, gVar);
        } else {
            this.f14451d.a(str, adError);
        }
    }

    private void b() {
        this.f14464q.setVisibility(0);
        this.f14465r.setVisibility(0);
        this.f14466s.setVisibility(0);
        this.f14467t.setVisibility(8);
        this.f14468u.setVisibility(8);
    }
}
