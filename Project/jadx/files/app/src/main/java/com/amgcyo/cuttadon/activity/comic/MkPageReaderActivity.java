package com.amgcyo.cuttadon.activity.comic;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.adapter.comic.MkReaderAdapterQuick;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager;
import com.fatcatfat.io.R;
import com.kathline.horizontalrefresh.HorizontalRefreshLayout;
import com.mardous.discreteseekbar.DiscreteSeekBar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkPageReaderActivity extends MkComicsBaseReaderActivity implements RecyclerViewPager.OnPageChangedListener {
    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected int B() {
        return ((RecyclerViewPager) this.mRecyclerView).getCurrentPosition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amgcyo.cuttadon.view.comic.recyclerviewpager.RecyclerViewPager.OnPageChangedListener
    public void OnPageChanged(RecyclerView recyclerView, int i2, int i3) {
        MkReaderAdapterQuick mkReaderAdapterQuick;
        if (i2 < 0 || i3 < 0 || (mkReaderAdapterQuick = this.L0) == null) {
            return;
        }
        ComicChapter comicChapter = (ComicChapter) mkReaderAdapterQuick.getItem(i3);
        ComicChapter comicChapter2 = (ComicChapter) this.L0.getItem(i2);
        if (comicChapter2 != null && comicChapter != null && comicChapter2.getOwnerChapterIndex() != comicChapter.getOwnerChapterIndex() && comicChapter.getItemType() == 2) {
            b(comicChapter);
        }
        if (comicChapter != null) {
            this.P0 = comicChapter.getIndex() + 1;
            this.Q0 = comicChapter.getCount();
            h0();
            if (!this.isDanmuOpen || com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter.getDanmakuContents())) {
                return;
            }
            comicChapter.setState(1);
            m(i3);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void S() {
        G();
        int iB = B();
        if (iB != 0) {
            this.mRecyclerView.smoothScrollToPosition(iB - 1);
        } else if (this.currentId <= 0) {
            g(com.amgcyo.cuttadon.f.o.d(R.string.reader_prev_none));
        } else {
            Q();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (this.L0 == null) {
            A();
            return;
        }
        X();
        this.F0.a("pref_reader_page_load_prev", true);
        this.F0.a("pref_reader_page_load_next", true);
        this.F0.b("pref_reader_page_trigger", 10);
        this.L0.g(0);
        this.Y0 = this.F0.a("pref_reader_page_quick_turn", false);
        V();
        ((RecyclerViewPager) this.mRecyclerView).setTriggerOffset(0.15f);
        ((RecyclerViewPager) this.mRecyclerView).setFlingFactor(0.5f);
        ((RecyclerViewPager) this.mRecyclerView).setOnPageChangedListener(this);
        this.mRecyclerView.setItemAnimator(null);
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.comic_ac_page_reader;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void nextPage() {
        G();
        int iB = B();
        if (iB != this.L0.getItemCount() - 1) {
            this.mRecyclerView.smoothScrollToPosition(iB + 1);
        } else {
            showLoading("");
            l(3);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    public void onPrevLoadSuccess(List<ComicChapter> list) {
        super.onPrevLoadSuccess(list);
        ((RecyclerViewPager) this.mRecyclerView).b();
        HorizontalRefreshLayout horizontalRefreshLayout = this.m1;
        if (horizontalRefreshLayout != null) {
            horizontalRefreshLayout.c();
        }
        this.mRecyclerView.smoothScrollToPosition(B() - 1);
    }

    @Override // com.mardous.discreteseekbar.DiscreteSeekBar.g
    public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z2) {
        if (z2) {
            int iB = B() + i2;
            int i3 = this.P0;
            this.S0 = this.L0.a(iB - i3, i2, i2 < i3);
        }
    }

    @Override // com.mardous.discreteseekbar.DiscreteSeekBar.g
    public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {
        this.mRecyclerView.scrollToPosition(this.S0);
    }
}
