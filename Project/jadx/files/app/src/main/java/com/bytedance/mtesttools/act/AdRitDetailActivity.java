package com.bytedance.mtesttools.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.b;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.f;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g;
import com.bytedance.mtesttools.base.BaseActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: loaded from: classes2.dex */
public class AdRitDetailActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ListView f14445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    b f14446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TextView f14447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f14448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    d f14449g;

    class a implements AdapterView.OnItemClickListener {
        a(AdRitDetailActivity adRitDetailActivity) {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        }
    }

    private void b() {
        this.f14445c.setOnItemClickListener(new a(this));
    }

    private void c() {
        this.f14446d = new b(this);
        this.f14445c.setAdapter((ListAdapter) this.f14446d);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.ttt_rit_info_layout, (ViewGroup) this.f14445c, false);
        this.f14447e = (TextView) viewInflate.findViewById(R$id.rit_id);
        this.f14448f = (TextView) viewInflate.findViewById(R$id.ad_type);
        this.f14445c.addHeaderView(viewInflate);
        this.f14447e.setText(this.f14449g.b());
        this.f14448f.setText(com.bytedance.mtesttools.base.a.a(this.f14449g.c()));
        this.f14446d.a(this.f14449g.d());
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity
    protected int a() {
        return R$layout.ttt_activity_ad_rit;
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f14446d != null) {
            Intent intent = new Intent();
            intent.putExtra("rit_id", this.f14449g.b());
            intent.putExtra("load_status", this.f14446d.a());
            setResult(-1, intent);
        }
        super.finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 22 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("slot_id");
            int intExtra = intent.getIntExtra("load_status", 0);
            f.a(stringExtra, intExtra);
            b bVar = this.f14446d;
            if (bVar != null) {
                bVar.a(stringExtra, intExtra);
            }
        }
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f14445c = (ListView) findViewById(R$id.slot_list);
        this.f14449g = (d) getIntent().getSerializableExtra("rit_config");
        if (this.f14449g == null) {
            g.a(this, "暂无数据，请稍后重试");
            finish();
        } else {
            a("广告位详情", true);
            c();
            b();
        }
    }
}
