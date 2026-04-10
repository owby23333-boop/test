package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.fragment.books.MkRequestBookFragment;
import com.amgcyo.cuttadon.fragment.books.a1;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.dialog.u0;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkRequireActivity extends BaseXTablayoutActivity implements com.amgcyo.cuttadon.h.f.c {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private MkRequestBookFragment f2928o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    String f2929p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    int f2930q0 = 0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private boolean f2931r0 = false;

    private void o() {
        MkRequestBookFragment mkRequestBookFragment = this.f2928o0;
        if (mkRequestBookFragment != null) {
            mkRequestBookFragment.m();
        } else {
            showMessage("参数异常，请重启APP后重试！");
        }
        this.f2931r0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        BaseAd baseAdB = com.amgcyo.cuttadon.sdk.utils.e.b("position_asking_book_reward_ad_video", "asking_book");
        if (baseAdB == null) {
            showMessage("错误码：c1227");
            return;
        }
        String platform = baseAdB.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            showMessage("错误码：c1228");
        } else {
            com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, "position_asking_book_reward_ad_video", com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "k"), baseAdB.getStyle(), baseAdB.isNoExempt()), this);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        this.f2928o0 = new MkRequestBookFragment();
        arrayList.add(this.f2928o0);
        arrayList.add(new a1());
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        ViewPager viewPager;
        super.initData(bundle);
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(this.f2277w, true);
            finish();
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getInt("tip_number", 0) <= 0 || (viewPager = this.vpClassify) == null) {
            return;
        }
        viewPager.setCurrentItem(1);
    }

    public void loadRewardVideoAd() {
        this.f2929p0 = com.amgcyo.cuttadon.utils.otherutils.g.B();
        this.f2930q0 = g0.a().a(this.f2929p0 + "technology", 0);
        int iK = com.amgcyo.cuttadon.utils.otherutils.h.k();
        String strD = com.amgcyo.cuttadon.f.o.d(R.string.askbook_msg);
        if (iK <= 0) {
            strD = com.amgcyo.cuttadon.f.o.d(R.string.askbook_msg_not_free);
        }
        String str = "今日求书次数：" + this.f2930q0 + " 总次数：" + iK;
        if (this.f2930q0 <= iK || com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.h.l())) {
            o();
            return;
        }
        u0 u0Var = new u0(this.f2277w, View.inflate(a(), R.layout.dialog_tips_dialog, null), R.style.custom_dialog);
        u0Var.setCancelable(true);
        u0Var.a(strD, "我要求书", "看小视频求书");
        u0Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.user.i
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                this.a.p();
            }
        });
        u0Var.show();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return com.amgcyo.cuttadon.f.n.f3694h;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdClose(String str) {
        if (this.f2931r0) {
            o();
        } else {
            showMessage("获取数据失败，请稍后重试！错误码：c1129");
        }
        this.f2931r0 = false;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdFail(int i2, String str, String str2, String str3) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.a(i2, str2)) {
            o();
            return;
        }
        if (i2 == 0) {
            showMessage("请求数据超时，请检查网络或反馈给客服");
            return;
        }
        showMessage("数据加载失败!错误码：" + i2);
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
        this.f2931r0 = hVar != null;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdVideoCached(Object obj) {
    }

    public void selectedHistoryFragment() {
        ViewPager viewPager = this.vpClassify;
        if (viewPager == null || this.f2286n0 == null) {
            return;
        }
        viewPager.setCurrentItem(1);
        ((a1) this.f2286n0.getItem(1)).onRefresh();
        this.f2929p0 = com.amgcyo.cuttadon.utils.otherutils.g.B();
        g0.a().b(this.f2929p0 + "technology", this.f2930q0 + 1);
    }
}
