package com.amgcyo.cuttadon.fragment.fission6;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.fission6.Fission6VipActivity;
import com.amgcyo.cuttadon.api.entity.config.Fission;
import com.amgcyo.cuttadon.api.entity.fission6.Fission6Index;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.m0;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.dialog.a1;
import com.amgcyo.cuttadon.view.otherview.ProgressWheel;
import com.amgcyo.cuttadon.view.smilerefresh.MkPullToRefresh;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.j;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class Fission6IndexFragment extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> implements PullToRefreshView.j {
    private Fission G;

    @BindView(R.id.fission6_progresswheel)
    ProgressWheel fission6Progresswheel;

    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;

    @BindView(R.id.img_vip)
    ImageView img_vip;

    @BindView(R.id.swipe_refresh_layout)
    MkPullToRefresh mRefreshView;

    @BindView(R.id.tv_desc_fission6)
    TextView tvDescFission6;

    @BindView(R.id.tv_mycode)
    TextView tvMycode;

    @BindView(R.id.tv_share)
    TextView tvShare;

    @BindView(R.id.tv_vali_count)
    TextView tvValiCount;

    @BindView(R.id.tv_fission6_type)
    TextView tv_fission6_type;

    @BindView(R.id.tv_fission_day)
    TextView tv_fission_day;

    class a implements g<Bitmap> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ Fission6Index f3849s;

        a(Fission6Index fission6Index) {
            this.f3849s = fission6Index;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Bitmap> jVar, boolean z2) {
            Fission6IndexFragment.this.a(h.C0(), (Bitmap) null);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Bitmap bitmap, Object obj, j<Bitmap> jVar, DataSource dataSource, boolean z2) {
            String strC0 = h.C0();
            Fission6IndexFragment.this.G = h.A();
            if (Fission6IndexFragment.this.G != null) {
                String menu_url = Fission6IndexFragment.this.G.getMenu_url();
                if (!TextUtils.isEmpty(menu_url)) {
                    strC0 = menu_url + "?channel=" + com.amgcyo.cuttadon.utils.otherutils.g.T() + "&appName=" + o.d(R.string.app_name) + "&inviteCode=" + this.f3849s.getCoder_number();
                }
            }
            Fission6IndexFragment.this.a(strC0, bitmap);
            return false;
        }
    }

    class b extends com.amgcyo.cuttadon.j.g.h.a<Bitmap, Bitmap> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3851c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Bitmap bitmap, String str) {
            super(bitmap);
            this.f3851c = str;
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Bitmap a(Bitmap bitmap) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(Fission6IndexFragment.this.getResources(), R.mipmap.app_logo);
            }
            return com.king.zxing.r.a.a(this.f3851c, n.a(200.0f), bitmap, Color.parseColor("#00998A"));
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        public void b(Bitmap bitmap) {
            if (bitmap != null) {
                Fission6IndexFragment.this.imgQrcode.setImageBitmap(bitmap);
                m0.a("fission6_bitmapt.jpg", bitmap);
            }
            ProgressWheel progressWheel = Fission6IndexFragment.this.fission6Progresswheel;
            if (progressWheel != null) {
                progressWheel.setVisibility(8);
            }
            TextView textView = Fission6IndexFragment.this.tvShare;
            if (textView != null) {
                textView.setEnabled(true);
            }
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "finish_activity")
    private void subscriberLoginOrRegUser(MkUser mkUser) {
        a(mkUser);
    }

    @Subscriber(mode = ThreadMode.POST, tag = "login_out")
    private void subscriberLoginOut(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            a("请登录后查看已推广人数", "请登录后查看我的邀请码", o.d(R.string.liji_login));
        }
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fission6_index_fragment;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            a("请登录后查看已推广人数", "请登录后查看我的邀请码", o.d(R.string.liji_login));
        } else {
            a(mkUserJ);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        ProgressWheel progressWheel = this.fission6Progresswheel;
        if (progressWheel != null) {
            progressWheel.setVisibility(8);
        }
        MkPullToRefresh mkPullToRefresh = this.mRefreshView;
        if (mkPullToRefresh != null) {
            mkPullToRefresh.setRefreshing(false);
        }
        if (message.f21197s == 1637) {
            Fission6Index fission6Index = (Fission6Index) message.f21202x;
            if (fission6Index == null) {
                a("获取数据失败，请下拉刷新重试！");
                a("获取失败！", "我的邀请码获取失败！", o.d(R.string.retry_agin));
                return;
            }
            this.tvShare.setText("立即分享");
            String avatar = fission6Index.getAvatar();
            String fission_day = fission6Index.getFission_day();
            if (!TextUtils.isEmpty(fission_day)) {
                this.tv_fission_day.setText(String.format("%s天 ", fission_day));
            }
            c.e(this.f3725t).asBitmap().mo49load(avatar).listener(new a(fission6Index)).submit();
            this.G = h.A();
            Fission fission = this.G;
            if (fission != null) {
                this.tvDescFission6.setText(fission.getMenu_remark());
            } else {
                this.tvDescFission6.setText(o.d(R.string.fission6_default_remark));
            }
            this.tvMycode.setText(String.format("我的邀请码：%s", fission6Index.getCoder_number()));
            this.tvValiCount.setText(String.format(Locale.getDefault(), "已推广%d人", Integer.valueOf(fission6Index.getFission_count())));
        }
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.setOnRefreshListener(this);
    }

    public /* synthetic */ void l() {
        this.fission6Progresswheel.setVisibility(0);
        if (!h.N0()) {
            this.img_vip.setVisibility(8);
            return;
        }
        this.img_vip.setVisibility(0);
        int iU = h.u();
        int i2 = R.drawable.fission6_cz1;
        if (iU > 0) {
            this.tv_fission6_type.setText("免章节");
            i2 = R.drawable.fission6_cz2;
        }
        this.f3728w.a(this.f3725t, ImageConfigImpl.builder().resId(i2).imageView(this.img_vip).build());
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        f();
    }

    @OnClick({R.id.img_vip, R.id.tv_share})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.img_vip) {
            r0.startActivity(this.f3725t, Fission6VipActivity.class);
            return;
        }
        if (id != R.id.tv_share) {
            return;
        }
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            r0.a(this.f3725t, true);
            return;
        }
        if (o.d(R.string.retry_agin).equals(this.tvShare.getText().toString())) {
            a(mkUserJ);
        } else {
            new a1(this.f3725t).show();
        }
    }

    @Override // me.jessyan.art.base.f.i
    public UserPresenter obtainPresenter() {
        return new UserPresenter(e.a(this.f3725t));
    }

    private void a(MkUser mkUser) {
        this.fission6Progresswheel.setVisibility(0);
        this.tvShare.setEnabled(false);
        ((UserPresenter) this.f3726u).j(Message.a(this, new Object[]{mkUser}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        String str2 = "url:" + str;
        Context context = this.f3725t;
        if (context != null) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.fragment.fission6.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3856s.l();
                }
            });
        }
        g0.a().b("fission6_share_url", str);
        com.amgcyo.cuttadon.j.g.b.a(new b(bitmap, str));
    }

    private void a(String str, String str2, String str3) {
        this.G = h.A();
        Fission fission = this.G;
        if (fission != null) {
            this.tvDescFission6.setText(fission.getMenu_remark());
        } else {
            this.tvDescFission6.setText(o.d(R.string.fission6_default_remark));
        }
        this.tvValiCount.setText(str);
        this.tvMycode.setText(str2);
        this.tvShare.setText(str3);
        a(h.C0(), (Bitmap) null);
        MkPullToRefresh mkPullToRefresh = this.mRefreshView;
        if (mkPullToRefresh != null) {
            mkPullToRefresh.setRefreshing(false);
        }
    }
}
