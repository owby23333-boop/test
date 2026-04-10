package com.amgcyo.cuttadon.fragment.books;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6IndexActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6VipActivity;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.activity.main.MkNightModelActivity;
import com.amgcyo.cuttadon.activity.main.MkShareActivity;
import com.amgcyo.cuttadon.activity.setting.MkSettingActivity;
import com.amgcyo.cuttadon.activity.user.MkCollectThemeActivity;
import com.amgcyo.cuttadon.activity.user.MkHistoryReadActivity;
import com.amgcyo.cuttadon.activity.user.MkMsgNoticeActivity;
import com.amgcyo.cuttadon.activity.user.MkUserModifyActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.showcaseview.MaterialShowcaseView;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkMineFragmentNew extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> implements PullToRefreshView.j {
    private MkUser G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private String L;
    private String M;
    private boolean N = false;
    private boolean O = false;

    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

    @BindView(R.id.cl_cz_root_child)
    ConstraintLayout cl_cz_root_child;

    @BindView(R.id.cl_fission5_cz_root)
    ConstraintLayout cl_fission5_cz_root;

    @BindView(R.id.cl_fission5_root_child)
    ConstraintLayout cl_fission5_root_child;

    @BindView(R.id.cl_fission6)
    ConstraintLayout cl_fission6;

    @BindView(R.id.cl_sign_in)
    ConstraintLayout cl_sign_in;

    @BindView(R.id.feedback_red_dot)
    ShapeableImageView feedback_red_dot;

    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;

    @BindView(R.id.ll_bar)
    LinearLayout llBar;

    @BindView(R.id.swipe_refresh_layout)
    PullToRefreshView mRefreshView;

    @BindView(R.id.message)
    ImageView message;

    @BindView(R.id.message_text)
    TextView message_text;

    @BindView(R.id.tv_ad_end_time)
    TextView tv_ad_end_time;

    @BindView(R.id.tv_code)
    TextView tv_code;

    @BindView(R.id.tv_copy)
    TextView tv_copy;

    @BindView(R.id.tv_current_version)
    AppCompatTextView tv_current_version;

    @BindView(R.id.tv_fission5_jb)
    TextView tv_fission5_jb;

    @BindView(R.id.tv_fission5_money)
    TextView tv_fission5_money;

    @BindView(R.id.tv_fission6_inval)
    TextView tv_fission6_inval;

    @BindView(R.id.tv_fission6_people)
    TextView tv_fission6_people;

    @BindView(R.id.tv_fission6_title)
    TextView tv_fission6_title;

    @BindView(R.id.tv_nick)
    TextView tv_nick;

    @BindView(R.id.tv_share_appname)
    AppCompatTextView tv_share_appname;

    @BindView(R.id.tv_title)
    AppCompatTextView tv_title;

    @BindView(R.id.vip_des_text)
    TextView vip_des_text;

    @BindView(R.id.vip_join_btn)
    TextView vip_join_btn;

    @BindView(R.id.vip_name_text)
    TextView vip_name_text;

    class a implements com.bumptech.glide.request.g<Drawable> {
        a(MkMineFragmentNew mkMineFragmentNew) {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            return false;
        }
    }

    class b implements com.amgcyo.cuttadon.view.showcaseview.e {
        b(MkMineFragmentNew mkMineFragmentNew) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void a(MaterialShowcaseView materialShowcaseView) {
        }

        @Override // com.amgcyo.cuttadon.view.showcaseview.e
        public void b(MaterialShowcaseView materialShowcaseView) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tip_mine_info_showcase", true);
        }
    }

    private void l() {
        this.H = com.amgcyo.cuttadon.utils.otherutils.h.N0();
        this.I = com.amgcyo.cuttadon.utils.otherutils.h.H0();
        this.J = com.amgcyo.cuttadon.utils.otherutils.h.I0();
        this.K = com.amgcyo.cuttadon.utils.otherutils.h.J0();
        String str = "payOpen: " + this.H + " fission5: " + this.I + " fission6: " + this.J + " fission7: " + this.K;
        if (this.H || this.I) {
            this.cl_cz_root_child.setVisibility(this.H ? 0 : 8);
            this.cl_fission5_cz_root.setVisibility(0);
            this.cl_fission5_root_child.setVisibility(this.I ? 0 : 8);
        } else {
            this.cl_fission5_cz_root.setVisibility(8);
            int height = this.cl_sign_in.getHeight();
            ViewGroup.LayoutParams layoutParams = this.cl_sign_in.getLayoutParams();
            layoutParams.height = (height / 2) + height;
            String str2 = "cl_sign_inHeight：" + height + " " + layoutParams.height;
            this.cl_sign_in.setLayoutParams(layoutParams);
            this.cl_sign_in.setPadding(0, height / 4, 0, 0);
        }
        this.cl_fission6.setVisibility((this.J || this.K) ? 0 : 8);
        if (this.H || this.J || this.K) {
            this.tv_ad_end_time.setVisibility(0);
        } else {
            this.tv_ad_end_time.setVisibility(8);
        }
    }

    private void m() {
        ShapeableImageView shapeableImageView;
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        this.tv_copy.setVisibility(8);
        MkUser mkUser = this.G;
        if (mkUser == null) {
            this.tv_nick.setText(String.format("欢迎使用%s", com.amgcyo.cuttadon.f.o.d(R.string.app_name)));
            this.tv_code.setText(this.M);
            this.tv_code.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3819s.a(view);
                }
            });
            if (this.I) {
                a("****", this.tv_fission5_jb);
                a("****", this.tv_fission5_money);
            }
            if (this.J || this.K) {
                this.tv_fission6_people.setText(com.amgcyo.cuttadon.f.o.d(R.string.no_invle_count));
                this.tv_fission6_title.setText(com.amgcyo.cuttadon.f.o.c(R.string.title_wallet));
                this.tv_fission6_inval.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_str));
                this.tv_ad_end_time.setText(com.amgcyo.cuttadon.f.o.d(R.string.ad_end_time_login));
            }
            if (this.H) {
                this.vip_join_btn.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_now));
                this.vip_name_text.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_prime));
                this.vip_des_text.setText(com.amgcyo.cuttadon.f.o.b());
                this.tv_ad_end_time.setText(com.amgcyo.cuttadon.f.o.d(R.string.ad_end_time_login));
            }
            this.f3728w.a(this.f3725t, ImageConfigImpl.builder().isCircle(true).resId(R.drawable.ic_user_default).imageView(this.iv_avatar).build());
        } else {
            this.tv_nick.setText(String.format("欢迎你：%s", mkUser.getNick()));
            this.tv_code.setText(this.G.getPhone());
            this.L = this.G.getInvitation_code();
            if (!TextUtils.isEmpty(this.L) && (this.J || this.I || this.K)) {
                this.tv_copy.setVisibility(0);
                this.tv_code.setText(String.format("邀请码：%s", this.L));
            }
            if (this.I) {
                a(g0VarA.d("gold"), this.tv_fission5_jb);
                a(g0VarA.d("gold"), this.tv_fission5_money);
            }
            MkAdBean mkAdBeanL0 = com.amgcyo.cuttadon.utils.otherutils.h.l0();
            if (mkAdBeanL0 != null) {
                int ad_state = mkAdBeanL0.getAd_state();
                if (ad_state == 1) {
                    this.tv_ad_end_time.setText(com.amgcyo.cuttadon.f.o.a(mkAdBeanL0.getAd_end_datetime()));
                } else {
                    this.tv_ad_end_time.setText(com.amgcyo.cuttadon.f.o.e(ad_state));
                }
                if (this.J || this.K) {
                    int invitation_count = this.G.getInvitation_count();
                    String str = "invitation_count:" + invitation_count + " ad_state: " + ad_state;
                    this.tv_fission6_people.setText(String.format(Locale.getDefault(), com.amgcyo.cuttadon.f.o.d(R.string.fission6_people), Integer.valueOf(invitation_count)));
                    if (invitation_count > 0) {
                        this.tv_fission6_inval.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_again));
                    } else {
                        this.tv_fission6_inval.setText(com.amgcyo.cuttadon.f.o.d(R.string.invitation_str));
                    }
                    this.tv_fission6_title.setText(com.amgcyo.cuttadon.f.o.c(R.string.title_wallet));
                }
                if (this.H) {
                    this.vip_des_text.setText(com.amgcyo.cuttadon.f.o.b());
                    if (ad_state != 1) {
                        this.vip_name_text.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_prime));
                        this.vip_join_btn.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_now));
                    } else {
                        this.vip_join_btn.setText(com.amgcyo.cuttadon.f.o.d(R.string.mine_vip_join_again));
                        this.vip_name_text.setText(com.amgcyo.cuttadon.f.o.c(R.string.mine_vip_have));
                    }
                }
            }
            boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("tip_mine_info_showcase", false);
            if (this.N && !zA && !this.O) {
                this.O = true;
                new Handler().postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.fragment.books.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3817s.r();
                    }
                }, 500L);
            }
            String strB = com.amgcyo.cuttadon.utils.otherutils.g.b(this.G.getAvatar());
            String str2 = "avatar:" + strB;
            this.f3728w.a(this.f3725t, ImageConfigImpl.builder().url(strB).isCircle(true).placeholder(R.drawable.ic_user_default).errorPic(R.drawable.ic_user_default).fallback(R.drawable.ic_user_default).imageView(this.iv_avatar).listener(new a(this)).build());
        }
        boolean zA2 = g0VarA.a("comment_number");
        TextView textView = this.message_text;
        if (textView != null) {
            textView.setVisibility(zA2 ? 0 : 8);
        }
        if (!g0VarA.a("service_appeal_number") || (shapeableImageView = this.feedback_red_dot) == null) {
            return;
        }
        shapeableImageView.setVisibility(0);
    }

    private void o() {
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.setOnRefreshListener(this);
        this.appBarLayout.a(new AppBarLayout.d() { // from class: com.amgcyo.cuttadon.fragment.books.i0
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void a(AppBarLayout appBarLayout, int i2) {
                this.a.a(appBarLayout, i2);
            }
        });
        this.message.setVisibility(com.amgcyo.cuttadon.utils.otherutils.h.L0() ? 0 : 8);
        this.tv_share_appname.setText(String.format("分享%s", com.amgcyo.cuttadon.f.o.d(R.string.app_name)));
        this.tv_current_version.setText(String.format("当前版本：%s", "5.0.2"));
    }

    private void p() {
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(false);
        }
    }

    private void q() {
        this.tv_title.setVisibility(0);
        MkUser mkUser = this.G;
        if (mkUser != null) {
            this.tv_title.setText(String.format("欢迎你：%s", mkUser.getNick()));
        } else {
            this.tv_title.setText(this.M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        new com.amgcyo.cuttadon.view.showcaseview.h().a(300L);
        com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(getActivity(), "tip_mine_info_showcase");
        fVar.a(com.amgcyo.cuttadon.f.o.a(getActivity(), this.iv_avatar, "点击这里可以修改个人信息\n如修改头像，更改昵称等~", new com.amgcyo.cuttadon.view.showcaseview.i.a(), 30, 1, 30, new b(this)));
        fVar.b();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "mkadbean")
    private void subscriberAd(MkAdBean mkAdBean) {
        p();
        if (mkAdBean != null) {
            String str = "indexAd:" + mkAdBean.toString();
        }
        m();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "golde_money")
    private void subscriberGoldMoney(com.amgcyo.cuttadon.view.read.page.i iVar) {
        if (iVar != null) {
            if (this.tv_fission5_jb != null) {
                a(iVar.b(), this.tv_fission5_jb);
            }
            if (this.tv_fission5_money != null) {
                a(iVar.a(), this.tv_fission5_money);
            }
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "finish_activity")
    private void subscriberLoginOrRegUser(MkUser mkUser) {
        this.G = mkUser;
        MkMainActivity mkMainActivity = (MkMainActivity) getActivity();
        if (mkMainActivity != null) {
            mkMainActivity.getUserIndex(false);
        }
        m();
    }

    @Subscriber(mode = ThreadMode.POST, tag = "login_out")
    private void subscriberLoginOut(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            com.amgcyo.cuttadon.utils.otherutils.h.k("");
            m();
            MkMainActivity mkMainActivity = (MkMainActivity) getActivity();
            if (mkMainActivity != null) {
                mkMainActivity.setLoginText(this.G);
            }
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.mine_frag;
    }

    public /* synthetic */ void a(AppBarLayout appBarLayout, int i2) {
        this.mRefreshView.setEnabled(i2 >= 0);
        if (i2 < 0) {
            q();
        } else {
            this.tv_title.setVisibility(8);
            this.tv_title.setText("  ");
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.j();
        this.N = true;
        o();
        l();
        m();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void hideLoading() {
        super.hideLoading();
        p();
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.M = com.amgcyo.cuttadon.f.o.d(R.string.mine_user_id_default);
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.llBar);
    }

    @OnClick({R.id.message, R.id.cl_appupdate, R.id.cl_fission6, R.id.cl_sign_in, R.id.account_center_out, R.id.tv_copy, R.id.cl_shudan, R.id.cl_history, R.id.cl_feedback, R.id.cl_night, R.id.cl_cz_root_child, R.id.cl_setting, R.id.cl_share, R.id.tv_fission5_tx})
    public void onClick(View view) {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        int id = view.getId();
        switch (id) {
            case R.id.account_center_out /* 2131296321 */:
                break;
            case R.id.message /* 2131298050 */:
                if (this.G == null) {
                    com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
                    return;
                }
                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkMsgNoticeActivity.class);
                TextView textView = this.message_text;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            case R.id.tv_copy /* 2131298648 */:
                if (TextUtils.isEmpty(this.L)) {
                    return;
                }
                String str = this.L;
                if (this.J || this.K) {
                    str = "FromShare#" + this.L;
                }
                com.amgcyo.cuttadon.f.o.a(this.f3725t, str, R.string.code_share_friends);
                return;
            case R.id.tv_fission5_tx /* 2131298703 */:
                if (this.G == null) {
                    com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
                    return;
                } else {
                    com.amgcyo.cuttadon.utils.otherutils.r0.c(this.f3725t);
                    return;
                }
            default:
                switch (id) {
                    case R.id.cl_appupdate /* 2131296812 */:
                        BaseTitleBarActivity baseTitleBarActivity = (BaseTitleBarActivity) getActivity();
                        if (baseTitleBarActivity != null) {
                            baseTitleBarActivity.showAppUpdateChioceDialog();
                            return;
                        }
                        return;
                    case R.id.cl_cz_root_child /* 2131296813 */:
                        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, Fission6VipActivity.class);
                        return;
                    case R.id.cl_feedback /* 2131296814 */:
                        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkFeedBackActivity.class);
                        ShapeableImageView shapeableImageView = this.feedback_red_dot;
                        if (shapeableImageView != null) {
                            shapeableImageView.setVisibility(8);
                            return;
                        }
                        return;
                    default:
                        switch (id) {
                            case R.id.cl_fission6 /* 2131296817 */:
                                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, Fission6IndexActivity.class);
                                break;
                            case R.id.cl_history /* 2131296818 */:
                                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkHistoryReadActivity.class);
                                break;
                            case R.id.cl_night /* 2131296819 */:
                                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkNightModelActivity.class);
                                break;
                            case R.id.cl_setting /* 2131296820 */:
                                com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkSettingActivity.class);
                                break;
                            case R.id.cl_share /* 2131296821 */:
                                if (this.I || this.J || this.K) {
                                    MkMainActivity mkMainActivity = (MkMainActivity) getActivity();
                                    if (mkMainActivity != null) {
                                        mkMainActivity.shareWhenFission();
                                    }
                                } else {
                                    com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkShareActivity.class);
                                }
                                break;
                            case R.id.cl_shudan /* 2131296822 */:
                                if (this.G != null) {
                                    com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkCollectThemeActivity.class);
                                } else {
                                    com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
                                }
                                break;
                        }
                        return;
                }
        }
        if (this.G == null) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, true);
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, MkUserModifyActivity.class);
        }
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        if (getActivity() == null || this.G == null) {
            p();
        } else if (com.amgcyo.cuttadon.h.a.c.a("minefragment_time", com.amgcyo.cuttadon.utils.otherutils.h.S())) {
            ((MkMainActivity) getActivity()).getUserIndex(false);
        } else {
            p();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.N = z2;
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.utils.otherutils.r0.b(this.f3725t);
    }

    private void a(String str, TextView textView) {
        if (TextUtils.isEmpty(str)) {
            str = "0.0";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RelativeSizeSpan(1.6f), 0, str.length(), 33);
        textView.setText(spannableString);
    }
}
