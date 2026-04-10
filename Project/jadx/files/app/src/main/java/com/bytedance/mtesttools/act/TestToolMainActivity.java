package com.bytedance.mtesttools.act;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.d;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.f;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.mtesttools.base.BaseActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class TestToolMainActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ExpandableListView f14485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.a f14486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TextView f14487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f14488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TextView f14489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    TextView f14490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    RelativeLayout f14491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TextView f14492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TextView f14493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TextView f14494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    TextView f14495m;

    class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.b group = TestToolMainActivity.this.f14486d.getGroup(i2);
            if (group == null || group.a() == null || group.a().size() <= i3) {
                return false;
            }
            d dVar = group.a().get(i3);
            Intent intent = new Intent(TestToolMainActivity.this.getApplicationContext(), (Class<?>) AdRitDetailActivity.class);
            intent.putExtra("rit_config", dVar);
            TestToolMainActivity.this.startActivityForResult(intent, 33);
            return false;
        }
    }

    class b implements ExpandableListView.OnGroupClickListener {
        b(TestToolMainActivity testToolMainActivity) {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j2) {
            return true;
        }
    }

    private void b() {
        f.b(this);
        this.f14492j.setText(bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.b() + " 家广告网络");
        boolean zA = bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.a(f.a);
        boolean zB = bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.b(f.a);
        boolean zA2 = bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d.a(this, f.a);
        if (zA) {
            this.f14493k.setEnabled(true);
            this.f14493k.setSelected(false);
        } else {
            this.f14493k.setEnabled(false);
        }
        if (zB) {
            this.f14494l.setEnabled(true);
            this.f14494l.setSelected(false);
        } else {
            this.f14494l.setEnabled(false);
        }
        if (zA2) {
            this.f14495m.setEnabled(true);
            this.f14495m.setSelected(false);
        } else {
            this.f14495m.setEnabled(false);
        }
        this.f14486d.a(f.a());
        int groupCount = this.f14486d.getGroupCount();
        if (groupCount == 0) {
            return;
        }
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.f14485c.expandGroup(i2);
        }
    }

    private void c() {
        String str;
        String sdkVersion = GMMediationAdSdk.getSdkVersion();
        this.f14487e.setText("Android " + sdkVersion);
        String appName = GMMediationAdSdk.getAppName();
        String appId = GMMediationAdSdk.getAppId();
        if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(appId)) {
            this.f14488f.setText(appName + " " + appId);
        }
        String strA = f.a(this);
        if (TextUtils.isEmpty(strA)) {
            String zbh = GMMediationAdSdk.getZbh(this);
            if (TextUtils.isEmpty(zbh)) {
                str = "暂无";
            } else {
                str = "OAID：\n" + zbh;
            }
        } else {
            str = "IMEI：\n" + strA;
        }
        this.f14489g.setText(str);
        if (!GMMediationAdSdk.configLoadSuccess()) {
            this.f14490h.setEnabled(false);
            this.f14490h.setText("未到达");
        } else {
            this.f14490h.setText("已到达");
            this.f14490h.setEnabled(true);
            this.f14490h.setSelected(false);
        }
    }

    private void d() {
        startActivity(new Intent(getApplicationContext(), (Class<?>) AdnMainActivity.class));
    }

    private void e() {
        this.f14491i.setOnClickListener(this);
    }

    private void f() {
        this.f14486d = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.a(this);
        this.f14485c.setGroupIndicator(null);
        this.f14485c.setDivider(null);
        this.f14485c.setChildDivider(null);
        this.f14485c.setOnChildClickListener(new a());
        this.f14485c.setOnGroupClickListener(new b(this));
        this.f14485c.setAdapter(this.f14486d);
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.ttt_msdk_info_layout, (ViewGroup) this.f14485c, false);
        this.f14487e = (TextView) viewInflate.findViewById(R$id.msdk_version);
        this.f14488f = (TextView) viewInflate.findViewById(R$id.test_app_name);
        this.f14489g = (TextView) viewInflate.findViewById(R$id.device_id);
        this.f14490h = (TextView) viewInflate.findViewById(R$id.config_is_load);
        this.f14491i = (RelativeLayout) viewInflate.findViewById(R$id.adn_layout);
        this.f14492j = (TextView) viewInflate.findViewById(R$id.adn_num);
        this.f14493k = (TextView) viewInflate.findViewById(R$id.adapter_status);
        this.f14494l = (TextView) viewInflate.findViewById(R$id.sdk_status);
        this.f14495m = (TextView) viewInflate.findViewById(R$id.manifest_status);
        this.f14485c.addHeaderView(viewInflate);
    }

    private void g() {
        try {
            Method declaredMethod = Class.forName("com.bytedance.msdk.api.v2.GMMediationAdSdk").getDeclaredMethod("resetIfTest", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
            declaredMethod.setAccessible(false);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    private void h() {
        try {
            Method declaredMethod = Class.forName("com.bytedance.msdk.api.v2.GMMediationAdSdk").getDeclaredMethod("setIfTest", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, 2);
            declaredMethod.setAccessible(false);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity
    protected int a() {
        return R$layout.ttt_activity_test_main;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 33 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("rit_id");
            int intExtra = intent.getIntExtra("load_status", 0);
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_if122.a aVar = this.f14486d;
            if (aVar != null) {
                aVar.a(stringExtra, intExtra);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.adn_layout) {
            d();
        }
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        h();
        this.f14485c = (ExpandableListView) findViewById(R$id.ad_list);
        a("穿山甲聚合测试工具", false);
        f();
        e();
        c();
        b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        g();
    }
}
