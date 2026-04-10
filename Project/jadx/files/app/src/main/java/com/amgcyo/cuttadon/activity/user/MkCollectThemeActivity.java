package com.amgcyo.cuttadon.activity.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkThemeDetailActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.other.ThemeBookListID;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkCollectThemeActivity extends BaseRefreshMoreRecyclerActivity<BookPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<ShudanListData> f2925r0 = new ArrayList();

    private void a(List<ShudanListData> list, int i2) {
        if (this.pageNo == 1) {
            this.f2925r0.clear();
            for (ShudanListData shudanListData : list) {
                shudanListData.setItemType(2);
                this.f2925r0.add(shudanListData);
            }
            this.f2256n0.b((Collection) this.f2925r0);
        } else {
            Iterator<ShudanListData> it = list.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            this.f2256n0.a((Collection) list);
        }
        this.f2256n0.m();
        if (this.f2258p0 >= i2) {
            this.pageNo++;
        } else {
            this.f2256n0.n();
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "bookThemeStates")
    private void refreshDataByEvent(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            onRefresh();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "我收藏的书单";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        BaseQuickAdapter baseQuickAdapter;
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 825) {
            ThemeBookListID themeBookListID = (ThemeBookListID) message.f21202x;
            this.f2257o0 = themeBookListID.getLimit();
            this.f2258p0 = themeBookListID.getLists().size();
            ((BookPresenter) this.f2276v).r(Message.a(this, new Object[]{themeBookListID.getLists()}));
            return;
        }
        if (i2 == 842) {
            a((List<ShudanListData>) message.f21202x, this.f2257o0);
            d(false);
        } else {
            if (i2 != 852 || (baseQuickAdapter = this.f2256n0) == null) {
                return;
            }
            baseQuickAdapter.n();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        com.amgcyo.cuttadon.f.o.a(this.recyclerView, 0, com.amgcyo.cuttadon.utils.otherutils.n.a(15.0f), 0, 0);
        this.f2256n0 = new com.amgcyo.cuttadon.adapter.other.n(this.G);
        this.f2256n0.a(this.recyclerView);
        this.f2256n0.a(new BaseQuickAdapter.i() { // from class: com.amgcyo.cuttadon.activity.user.h
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void a() {
                this.a.q();
            }
        }, this.recyclerView);
        this.f2256n0.a((BaseQuickAdapter.g) this);
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ((BookPresenter) this.f2276v).u(Message.a(this, new Object[]{Integer.valueOf(this.pageNo)}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        ShudanListData shudanListData;
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2925r0) || (shudanListData = this.f2925r0.get(i2)) == null) {
            return;
        }
        String path = shudanListData.getPath();
        if (TextUtils.isEmpty(path)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("theme_path", path);
        bundle.putBoolean("theme_base_info", true);
        r0.startActivity(this.f2277w, bundle, MkThemeDetailActivity.class);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        super.onRefresh();
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ void q() {
        String str = "加载更多: " + this.pageNo;
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }
}
