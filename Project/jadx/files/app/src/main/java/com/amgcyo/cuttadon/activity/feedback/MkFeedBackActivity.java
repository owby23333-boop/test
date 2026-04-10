package com.amgcyo.cuttadon.activity.feedback;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.fragment.books.MkFeedbackFragment;
import com.amgcyo.cuttadon.fragment.books.z0;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.showcaseview.f;
import com.amgcyo.cuttadon.view.showcaseview.i.d;
import com.amgcyo.cuttadon.widget.ui.MoreTextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkFeedBackActivity extends BaseXTablayoutActivity {
    private void p() {
        this.D.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.feedback.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2499s.o();
            }
        });
    }

    public /* synthetic */ void a(String str, View view) {
        if (g.j() == null) {
            r0.a((Context) a(), true);
        } else {
            showMessage("正在使用系统浏览器打开聊天窗口!");
            com.amgcyo.cuttadon.view.webview.b.startActivity(a(), str);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MkFeedbackFragment());
        arrayList.add(new z0());
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        final String strC = com.amgcyo.cuttadon.sdk.utils.g.c("kf_url");
        String str = "kf_url:" + strC;
        if (!TextUtils.isEmpty(strC)) {
            this.D.setVisibility(0);
            this.D.a();
            this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.feedback.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2500s.a(strC, view);
                }
            });
            p();
        }
        if (g0.a().a("service_appeal_number")) {
            g0.a().b("service_appeal_number", false);
            ViewPager viewPager = this.vpClassify;
            if (viewPager == null) {
                return;
            }
            viewPager.setCurrentItem(1);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return new String[]{"我要反馈 ", "反馈历史 "};
    }

    public /* synthetic */ void o() {
        if (this.D != null) {
            f fVar = new f(a(), "zxkf_key");
            BaseTitleBarActivity baseTitleBarActivityA = a();
            MoreTextView moreTextView = this.D;
            fVar.a(o.a(baseTitleBarActivityA, moreTextView, "点击这里可以联系在线客服哦~", new d(moreTextView.getWidth(), this.D.getHeight()), 30, 1, 30, new c(this)));
            fVar.b();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    public void selectedHistoryFragment() {
        ViewPager viewPager = this.vpClassify;
        if (viewPager == null || this.f2286n0 == null) {
            return;
        }
        viewPager.setCurrentItem(1);
        ((z0) this.f2286n0.getItem(1)).onRefresh();
    }
}
