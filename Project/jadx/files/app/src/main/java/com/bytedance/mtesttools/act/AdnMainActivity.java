package com.bytedance.mtesttools.act;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.c;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.f;
import com.bytedance.mtesttools.base.BaseActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: loaded from: classes2.dex */
public class AdnMainActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ListView f14483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f14484d;

    private void b() {
        this.f14484d.a(f.b());
    }

    private void c() {
    }

    private void d() {
        this.f14484d = new c(this);
        this.f14483c.setAdapter((ListAdapter) this.f14484d);
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity
    protected int a() {
        return R$layout.ttt_activity_adn_main;
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f14483c = (ListView) findViewById(R$id.adn_list);
        a("组件整体接入情况", true);
        d();
        c();
        b();
    }
}
