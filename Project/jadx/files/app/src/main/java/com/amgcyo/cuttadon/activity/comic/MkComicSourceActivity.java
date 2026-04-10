package com.amgcyo.cuttadon.activity.comic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.ComicSourceBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.ComicPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkComicSourceActivity extends BaseRefreshMoreRecyclerActivity<ComicPresenter> implements BaseQuickAdapter.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private List<ComicSourceBean> f2354r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private MkBook f2355s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f2356t0;

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "请选择漫画源";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 908) {
            Object[] objArr = message.f21203y;
            MkBook mkBook = (MkBook) objArr[0];
            this.f2356t0 = ((Integer) objArr[1]).intValue();
            String comic_source = mkBook.getComic_source();
            if (TextUtils.isEmpty(comic_source)) {
                showMessage("更换书源失败!");
                finish();
                return;
            }
            this.f2354r0 = com.amgcyo.cuttadon.utils.otherutils.r.b(comic_source, ComicSourceBean.class);
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2354r0)) {
                showEmpty();
                return;
            }
            this.f2256n0 = new com.amgcyo.cuttadon.adapter.comic.c(this.f2354r0, mkBook.getReading_site_id(), mkBook.getLast_chapter_name());
            this.recyclerView.setAdapter(this.f2256n0);
            c(false);
            d(false);
            this.f2256n0.a((BaseQuickAdapter.g) this);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.f2355s0 = (MkBook) extras.getSerializable("book");
        MkBook mkBook = this.f2355s0;
        if (mkBook == null) {
            finish();
            return;
        }
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_detail_source", "csj_new_position_lists", mkBook.getForm());
        if (normalAdParamsA != null && this.adFrameLayout != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3703q);
            this.adFrameLayout.b(normalAdParamsA);
        }
        loadData();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
        ((ComicPresenter) this.f2276v).a(Message.a(this, new Object[]{this.f2355s0, 908}));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (this.f2355s0 == null || com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2354r0) || this.f2277w == null) {
            showMessage("更换书源失败!");
            finish();
            return;
        }
        ComicSourceBean comicSourceBean = this.f2354r0.get(i2);
        if (comicSourceBean == null) {
            return;
        }
        String sourceId = comicSourceBean.getSourceId();
        AppDatabase.i().a().b(sourceId, comicSourceBean.getTitle(), this.f2355s0.getBook_id());
        this.f2355s0.setReading_site_id(sourceId);
        me.jessyan.art.d.f.a().a(new MkCommentEvent(this.f2356t0), "comic_tag_finish_activity");
        showMessage("更换书源成功");
        r0.a(this.f2277w, this.f2355s0);
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public ComicPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ComicPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ComicPresenter) this.f2276v;
    }
}
