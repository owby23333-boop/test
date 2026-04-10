package com.amgcyo.cuttadon.activity.fission5;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.setting.MkWebviewActivity;
import com.amgcyo.cuttadon.api.entity.config.FissionData;
import com.amgcyo.cuttadon.api.entity.fission5.Invalitation5Bean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.popupview.BottomSharePopupView;
import com.amgcyo.cuttadon.view.popupview.WebViewPopupView;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class Fission5InvaliUserActivity extends BaseTitleBarActivity<UserPresenter> implements BottomSharePopupView.a {

    @BindView(R.id.laba)
    ImageView laba;

    @BindView(R.id.ll_notice)
    LinearLayout ll_notice;

    @BindView(R.id.marqueerewardview)
    SimpleMarqueeView marqueerewardview;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private AnimationDrawable f2512n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    String f2513o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    List<String> f2514p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private BasePopupView f2515q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private String f2516r0;

    @BindView(R.id.rl_my_code)
    RelativeLayout rl_my_code;

    @BindView(R.id.tv_copy0)
    TextView tv_copy0;

    @BindView(R.id.tv_day1)
    TextView tv_day1;

    @BindView(R.id.tv_day2)
    TextView tv_day2;

    @BindView(R.id.tv_day3)
    TextView tv_day3;

    @BindView(R.id.tv_desc)
    TextView tv_desc;

    @BindView(R.id.tv_mycode)
    TextView tv_mycode;

    @BindView(R.id.tv_ruledesc)
    TextView tv_ruledesc;

    @BindView(R.id.tv_title)
    TextView tv_title;

    private void n() {
        if (TextUtils.isEmpty(this.f2513o0)) {
            return;
        }
        o.a(a(), this.f2513o0, R.string.copy_suc);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(String str, View view) {
        WebViewPopupView webViewPopupView = new WebViewPopupView(this.f2277w, com.amgcyo.cuttadon.utils.otherutils.g.e("invitation"), str);
        a.b bVar = new a.b(this.f2277w);
        bVar.b(true);
        bVar.d(false);
        bVar.e(true);
        bVar.a((BasePopupView) webViewPopupView);
        webViewPopupView.u();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "邀请好友";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        hideLoading();
        if (message.f21197s == 889) {
            Invalitation5Bean invalitation5Bean = (Invalitation5Bean) message.f21202x;
            if (invalitation5Bean == null) {
                showEmpty();
                return;
            }
            this.f2514p0 = invalitation5Bean.getNotice();
            int i2 = 0;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2514p0)) {
                this.ll_notice.setVisibility(8);
            } else {
                a(this.f2514p0);
                this.ll_notice.setVisibility(0);
                this.laba.setImageResource(R.drawable.laba_animl);
                this.f2512n0 = (AnimationDrawable) this.laba.getDrawable();
                this.f2512n0.start();
            }
            this.rl_my_code.setVisibility(0);
            this.f2513o0 = invalitation5Bean.getInvitation_code();
            this.tv_mycode.setText(String.format("我的邀请码：%s", this.f2513o0));
            this.f2516r0 = invalitation5Bean.getInvitation_url();
            try {
                List<Integer> invitation_amount = invalitation5Bean.getInvitation_amount();
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(invitation_amount) && invitation_amount.size() >= 3) {
                    String strValueOf = String.valueOf(invitation_amount.get(0));
                    this.tv_title.setText(strValueOf);
                    this.tv_desc.setText(String.format("如何拿到%s元", strValueOf));
                    Integer num = invitation_amount.get(1);
                    Integer num2 = invitation_amount.get(2);
                    Integer num3 = invitation_amount.get(3);
                    a(this.tv_day1, num + "", "奖励");
                    a(this.tv_day2, num2 + "", "累计");
                    a(this.tv_day3, num3 + "", "加送");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            List<String> rule_msg = invalitation5Bean.getRule_msg();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(rule_msg)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = rule_msg.iterator();
            while (it.hasNext()) {
                i2++;
                sb.append(it.next());
                sb.append("\n");
            }
            sb.append(i2 + 1);
            sb.append(".");
            sb.append(o.d(R.string.app_name));
            sb.append("享有最终解释权！");
            this.tv_ruledesc.setText(sb.toString());
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.D.setTextColor(o.b(R.color.color_ff403a));
        showLoading("正在获取数据...");
        final String strD = o.d(R.string.yqsm);
        this.D.setText(strD);
        this.D.setVisibility(0);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2544s.a(strD, view);
            }
        });
        ((UserPresenter) this.f2276v).z(Message.a(this, new Object[0]));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.invaliuserfission5_activity;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.stopFlipping();
        }
        AnimationDrawable animationDrawable = this.f2512n0;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SimpleMarqueeView simpleMarqueeView = this.marqueerewardview;
        if (simpleMarqueeView != null) {
            simpleMarqueeView.startFlipping();
        }
        AnimationDrawable animationDrawable = this.f2512n0;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    @OnClick({R.id.tv_copy0, R.id.fr_yq, R.id.tv_wx, R.id.tv_qrcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fr_yq /* 2131297022 */:
                BasePopupView basePopupView = this.f2515q0;
                if (basePopupView != null) {
                    basePopupView.u();
                } else {
                    BottomSharePopupView bottomSharePopupView = new BottomSharePopupView(a());
                    bottomSharePopupView.setListener(this);
                    a.b bVar = new a.b(a());
                    bVar.c((Boolean) true);
                    bVar.d(true);
                    bVar.a((BasePopupView) bottomSharePopupView);
                    this.f2515q0 = bottomSharePopupView.u();
                }
                break;
            case R.id.tv_copy0 /* 2131298649 */:
                n();
                break;
            case R.id.tv_qrcode /* 2131298780 */:
                zfbShare();
                break;
            case R.id.tv_wx /* 2131298887 */:
                wxShare();
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.view.popupview.BottomSharePopupView.a
    public void wxShare() {
        if (TextUtils.isEmpty(this.f2516r0)) {
            return;
        }
        Intent intent = new Intent(this.f2277w, (Class<?>) MkWebviewActivity.class);
        intent.putExtra("param_url", this.f2516r0 + "?share=0&app_name=" + URLEncoder.encode(o.d(R.string.app_name)) + "&app_id=" + com.amgcyo.cuttadon.utils.otherutils.h.t());
        intent.putExtra("webview_width", 750);
        intent.putExtra("webview_height", 1333);
        intent.putExtra("WEBVIEW_SHARE", 1);
        this.f2277w.startActivity(intent);
    }

    @Override // com.amgcyo.cuttadon.view.popupview.BottomSharePopupView.a
    public void zfbShare() {
        if (TextUtils.isEmpty(this.f2516r0)) {
            return;
        }
        r0.a(this.f2277w, this.f2516r0 + "?share=1&app_name=" + URLEncoder.encode(o.d(R.string.app_name)) + "&app_id=" + com.amgcyo.cuttadon.utils.otherutils.h.t(), (FissionData) null);
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }

    private void a(List<String> list) {
        com.gongwen.marqueen.b bVar = new com.gongwen.marqueen.b(this.f2277w);
        bVar.a((List) list);
        this.marqueerewardview.setMarqueeFactory(bVar);
    }

    private void a(TextView textView, String str, String str2) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(o.b(R.color.color_9d771d));
        SpannableString spannableString = new SpannableString(str2 + str + "元");
        int length = str2.length();
        int length2 = str.length() + length;
        spannableString.setSpan(foregroundColorSpan, 0, length, 17);
        spannableString.setSpan(new ForegroundColorSpan(o.b(R.color.color_ff6f12)), length, length2, 17);
        spannableString.setSpan(new RelativeSizeSpan(2.6f), length, length2, 33);
        spannableString.setSpan(new StyleSpan(1), length, length2, 33);
        textView.setText(spannableString);
    }
}
