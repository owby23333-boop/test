package com.amgcyo.cuttadon.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amgcyo.cuttadon.activity.fission6.Fission6FeedbackActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6IndexActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6VipActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkDataBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: compiled from: Fission6ChapterTipsDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class z0 extends AlertDialog implements View.OnClickListener {
    private TextView A;
    private ConstraintLayout B;
    private ConstraintLayout C;
    private ProgressWheel D;
    private LinearLayout E;
    private LinearLayout F;
    private MkUser G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private String L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MyRewardBaseAdActivity f4843s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4844t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4845u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f4846v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f4847w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f4848x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f4849y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f4850z;

    public z0(MyRewardBaseAdActivity myRewardBaseAdActivity) {
        super(myRewardBaseAdActivity, R.style.style_permission_dialog);
        EventBus.getDefault().register(this);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f4843s = myRewardBaseAdActivity;
    }

    private void a(MkAdBean mkAdBean) {
        this.K = mkAdBean.getAd_state();
        this.F.setVisibility(8);
        this.A.setVisibility(0);
        this.L = mkAdBean.getAd_end_datetime();
        int i2 = this.K;
        if (i2 == 1) {
            this.f4844t.setText(com.amgcyo.cuttadon.f.o.a(this.L));
        } else {
            this.f4844t.setText(com.amgcyo.cuttadon.f.o.e(i2));
        }
        if (this.I || this.J) {
            int invitation_count = this.G.getInvitation_count();
            String str = "invitation_count:" + invitation_count + " ad_state: " + this.K;
            this.f4849y.setText(String.format(Locale.getDefault(), com.amgcyo.cuttadon.f.o.d(R.string.fission6_people), Integer.valueOf(invitation_count)));
            if (invitation_count > 0) {
                this.f4850z.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_again));
            } else {
                this.f4850z.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_str));
            }
            this.f4848x.setText(com.amgcyo.cuttadon.f.o.c(R.string.title_wallet));
        }
        if (this.H) {
            this.f4846v.setText(com.amgcyo.cuttadon.f.o.b());
            if (this.K != 1) {
                this.f4845u.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_prime));
                this.f4847w.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_now));
            } else {
                this.f4847w.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_again));
                this.f4845u.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_have));
            }
        }
    }

    private void b() {
        if (this.f4843s == null) {
            a();
            return;
        }
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.G == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a((Context) this.f4843s, true);
            return;
        }
        Bundle bundle = new Bundle();
        MkDataBean data = this.G.getData();
        String ad_token = data != null ? data.getAd_token() : "";
        if (TextUtils.isEmpty(ad_token)) {
            ad_token = this.G.getToken();
        }
        bundle.putString("otherdata", "  " + this.K + " · " + this.L + " · " + com.amgcyo.cuttadon.utils.otherutils.t0.d(com.amgcyo.cuttadon.h.a.c.a("minefragment_time")) + " · " + ad_token);
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f4843s, bundle, Fission6FeedbackActivity.class);
    }

    private void c() {
        if (g()) {
            return;
        }
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (this.G != null) {
            f();
            return;
        }
        this.E.setVisibility(0);
        this.D.setVisibility(8);
        this.f4848x.setText(com.amgcyo.cuttadon.f.o.c(R.string.title_wallet));
        this.f4850z.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_str));
        this.f4847w.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_now));
        this.f4845u.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_prime));
        this.f4846v.setText(com.amgcyo.cuttadon.f.o.b());
    }

    private void d() {
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.H = com.amgcyo.cuttadon.utils.otherutils.h.N0();
        this.I = com.amgcyo.cuttadon.utils.otherutils.h.I0();
        this.J = com.amgcyo.cuttadon.utils.otherutils.h.J0();
        String str = "payOpen: " + this.H + " fission6: " + this.I + " fission7: " + this.J;
        this.B.setVisibility(this.H ? 0 : 8);
        this.C.setVisibility(this.I ? 0 : 8);
        this.C.setVisibility(this.J ? 0 : 8);
        c();
    }

    private void e() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f4844t = (TextView) findViewById(R.id.tv_ad_end_time);
        this.f4845u = (TextView) findViewById(R.id.vip_name_text);
        this.f4846v = (TextView) findViewById(R.id.vip_des_text);
        this.f4847w = (TextView) findViewById(R.id.vip_join_btn);
        this.f4848x = (TextView) findViewById(R.id.tv_fission6_title);
        this.f4849y = (TextView) findViewById(R.id.tv_fission6_people);
        this.f4850z = (TextView) findViewById(R.id.tv_fission6_inval);
        TextView textView = (TextView) findViewById(R.id.tv_try);
        TextView textView2 = (TextView) findViewById(R.id.tv_feedback);
        this.A = (TextView) findViewById(R.id.tv_info);
        this.C = (ConstraintLayout) findViewById(R.id.cl_fission6);
        this.B = (ConstraintLayout) findViewById(R.id.cl_cz_root_child);
        this.D = (ProgressWheel) findViewById(R.id.fission6_progresswheel);
        this.E = (LinearLayout) findViewById(R.id.ll_layout);
        this.F = (LinearLayout) findViewById(R.id.ll_error);
        imageView.setOnClickListener(this);
        this.f4847w.setOnClickListener(this);
        this.f4850z.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        d();
    }

    private void f() {
        if (this.E == null || this.f4843s == null) {
            a();
            return;
        }
        this.D.setVisibility(0);
        this.E.setVisibility(4);
        this.F.setVisibility(4);
        new ConfigPresenter(me.jessyan.art.f.e.a(this.f4843s)).j(Message.a(this.f4843s, new Object[]{false, 861}));
    }

    private boolean g() {
        if (!com.amgcyo.cuttadon.utils.otherutils.h.F0() || !com.amgcyo.cuttadon.utils.otherutils.g.m0()) {
            return false;
        }
        dismiss();
        return true;
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "mkadbean")
    private void subscriberAd(MkAdBean mkAdBean) {
        if (mkAdBean == null) {
            a();
            return;
        }
        ProgressWheel progressWheel = this.D;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        String str = "indexAd:" + mkAdBean.toString();
        if (!mkAdBean.isSuccess()) {
            LinearLayout linearLayout = this.F;
            if (linearLayout == null) {
                a();
                return;
            } else {
                linearLayout.setVisibility(0);
                this.E.setVisibility(8);
                return;
            }
        }
        if (g()) {
            return;
        }
        LinearLayout linearLayout2 = this.E;
        if (linearLayout2 == null) {
            a();
        } else {
            linearLayout2.setVisibility(0);
            a(mkAdBean);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        EventBus.getDefault().unregister(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close /* 2131297162 */:
                a();
                break;
            case R.id.tv_feedback /* 2131298692 */:
                b();
                break;
            case R.id.tv_fission6_inval /* 2131298705 */:
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f4843s, Fission6IndexActivity.class);
                break;
            case R.id.tv_try /* 2131298856 */:
                f();
                break;
            case R.id.vip_join_btn /* 2131298956 */:
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f4843s, Fission6VipActivity.class);
                break;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.fission6_chapter_bottom, (ViewGroup) null);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_animation);
        e();
    }

    private void a() {
        if (this.f4843s != null) {
            dismiss();
            this.f4843s.finish();
        }
    }
}
