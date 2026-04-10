package com.amgcyo.cuttadon.activity.shelf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.widget.ui.MoreTextView;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BookShelfCleanaupActivity extends BaseXTablayoutActivity {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f2887o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f2888p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2889q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private BookShelfCleanaupFragment f2890r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private BookShelfCleanaupFragment f2891s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f2892t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f2893u0 = false;

    private void p() {
        this.f2891s0 = BookShelfCleanaupFragment.a(3, this.f2889q0);
    }

    private void q() {
        this.f2890r0 = BookShelfCleanaupFragment.a(1, this.f2889q0);
    }

    private void r() {
        this.D.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.shelf.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2903s.o();
            }
        });
    }

    public /* synthetic */ void a(String[] strArr, View view) {
        a.b bVar = new a.b(this.f2277w);
        double dC = n.c(this.f2277w);
        Double.isNaN(dC);
        bVar.a((int) (dC * 0.8d));
        bVar.c(true);
        bVar.a("请选择排序方式", strArr, null, this.f2892t0, new com.lxj.xpopup.c.f() { // from class: com.amgcyo.cuttadon.activity.shelf.c
            @Override // com.lxj.xpopup.c.f
            public final void a(int i2, String str) {
                this.a.a(i2, str);
            }
        }).u();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected List<Fragment> getmFragments() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f2888p0 = intent.getIntExtra("form", 1);
            this.f2889q0 = intent.getIntExtra("type_id", 10);
            String str = "form: " + this.f2888p0 + " pageType: " + this.f2889q0;
        }
        this.f2887o0 = g.j0();
        ArrayList arrayList = new ArrayList();
        q();
        if (this.f2887o0) {
            this.E.setSelectedTabIndicatorColor(0);
            int iB = o.b(R.color.text_33);
            this.E.a(iB, iB);
            arrayList.add(this.f2890r0);
        } else {
            p();
            if (1 == this.f2888p0) {
                arrayList.add(this.f2890r0);
                arrayList.add(this.f2891s0);
            } else {
                arrayList.add(this.f2891s0);
                arrayList.add(this.f2890r0);
            }
        }
        return arrayList;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.f2893u0 = 20 == this.f2889q0;
        if (this.f2893u0) {
            this.D.setVisibility(0);
            final String[] strArr = {"按最近阅读升序", "按最近阅读降序", "按更新时间升序", "按更新时间降序"};
            if (g.u0()) {
                this.f2892t0 = 2;
            } else {
                this.f2892t0 = 0;
            }
            BookShelfCleanaupFragment bookShelfCleanaupFragment = this.f2890r0;
            if (bookShelfCleanaupFragment != null) {
                bookShelfCleanaupFragment.a(Integer.valueOf(this.f2892t0));
            }
            BookShelfCleanaupFragment bookShelfCleanaupFragment2 = this.f2891s0;
            if (bookShelfCleanaupFragment2 != null) {
                bookShelfCleanaupFragment2.a(Integer.valueOf(this.f2892t0));
            }
            this.D.setTextSize(2, 13.0f);
            this.D.setText(strArr[this.f2892t0]);
            this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.shelf.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2904s.a(strArr, view);
                }
            });
            r();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity
    protected String[] n() {
        return this.f2887o0 ? this.f2893u0 ? new String[]{"批量管理"} : new String[]{"小说清理"} : 1 == this.f2888p0 ? new String[]{"小说", "漫画"} : new String[]{"漫画", "小说"};
    }

    public /* synthetic */ void o() {
        if (this.D != null) {
            com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(a(), "tip_batch_sort_model1");
            BaseTitleBarActivity baseTitleBarActivityA = a();
            MoreTextView moreTextView = this.D;
            fVar.a(o.a(baseTitleBarActivityA, moreTextView, "点击这里可以选择书籍排序方式~", new com.amgcyo.cuttadon.view.showcaseview.i.d(moreTextView.getWidth(), this.D.getHeight()), 30, 1, 30, null));
            fVar.b();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseXTablayoutActivity, me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    public /* synthetic */ void a(int i2, String str) {
        this.f2892t0 = i2;
        this.D.setText(str);
        Fragment item = this.f2286n0.getItem(this.vpClassify.getCurrentItem());
        if (item instanceof BookShelfCleanaupFragment) {
            ((BookShelfCleanaupFragment) item).d(this.f2892t0);
        }
    }
}
