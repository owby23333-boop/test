package com.amgcyo.cuttadon.activity.comic;

import android.graphics.Point;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.utils.comic.PreCacheLayoutManager;
import com.amgcyo.cuttadon.view.comic.zoomablerecyclerview.ZoomableRecyclerView;
import com.fatcatfat.io.R;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mardous.discreteseekbar.DiscreteSeekBar;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkStreamReaderPActivity extends MkComicsBaseReaderActivity {
    protected HashMap<String, String> R1 = new HashMap<>();
    private int S1 = 0;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            RecyclerView recyclerView2;
            ComicChapter comicChapter;
            super.onScrollStateChanged(recyclerView, i2);
            MkStreamReaderPActivity mkStreamReaderPActivity = MkStreamReaderPActivity.this;
            PreCacheLayoutManager preCacheLayoutManager = mkStreamReaderPActivity.M0;
            if (preCacheLayoutManager == null || mkStreamReaderPActivity.L0 == null) {
                return;
            }
            int iFindFirstVisibleItemPosition = preCacheLayoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = MkStreamReaderPActivity.this.M0.findLastVisibleItemPosition();
            if (i2 == 0 && (recyclerView2 = MkStreamReaderPActivity.this.mRecyclerView) != null && !recyclerView2.canScrollVertically(1) && iFindLastVisibleItemPosition != -1 && (comicChapter = (ComicChapter) MkStreamReaderPActivity.this.L0.getItem(iFindLastVisibleItemPosition)) != null && comicChapter.getItemType() != 1 && comicChapter.getItemType() != 3) {
                MkStreamReaderPActivity.this.P0 = comicChapter.getIndex() + 1;
                MkStreamReaderPActivity.this.Q0 = comicChapter.getCount();
                MkStreamReaderPActivity.this.h0();
            }
            if (MkStreamReaderPActivity.this.isDanmuOpen) {
                if (1 == i2 || 2 == i2) {
                    for (int i3 = iFindFirstVisibleItemPosition; i3 <= iFindLastVisibleItemPosition; i3++) {
                        ComicChapter comicChapter2 = (ComicChapter) MkStreamReaderPActivity.this.L0.getItem(i3);
                        if (comicChapter2 != null) {
                            comicChapter2.setState(2);
                            String str = "p" + comicChapter2.getId();
                            HashMap<String, String> map = MkStreamReaderPActivity.this.R1;
                            if (map != null && map.containsKey(str)) {
                                MkStreamReaderPActivity.this.R1.remove(str);
                            }
                            MkStreamReaderPActivity.this.m(i3);
                        }
                    }
                }
                if (i2 == 0) {
                    while (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                        ComicChapter comicChapter3 = (ComicChapter) MkStreamReaderPActivity.this.L0.getItem(iFindFirstVisibleItemPosition);
                        if (comicChapter3 != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(comicChapter3.getDanmakuContents())) {
                            String str2 = "p" + comicChapter3.getId();
                            HashMap<String, String> map2 = MkStreamReaderPActivity.this.R1;
                            if (map2 != null && !map2.containsKey(str2)) {
                                MkStreamReaderPActivity.this.R1.put(str2, str2);
                                comicChapter3.setState(1);
                            }
                            MkStreamReaderPActivity.this.m(iFindFirstVisibleItemPosition);
                        }
                        iFindFirstVisibleItemPosition++;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            int iFindFirstVisibleItemPosition = MkStreamReaderPActivity.this.M0.findFirstVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1 || iFindFirstVisibleItemPosition == MkStreamReaderPActivity.this.S1) {
                return;
            }
            ComicChapter comicChapter = (ComicChapter) MkStreamReaderPActivity.this.L0.getItem(iFindFirstVisibleItemPosition);
            MkStreamReaderPActivity mkStreamReaderPActivity = MkStreamReaderPActivity.this;
            ComicChapter comicChapter2 = (ComicChapter) mkStreamReaderPActivity.L0.getItem(mkStreamReaderPActivity.S1);
            if (comicChapter2 != null && comicChapter != null && comicChapter2.getOwnerChapterIndex() != comicChapter.getOwnerChapterIndex() && MkStreamReaderPActivity.this.turn == 2 && comicChapter.getItemType() == 2) {
                MkStreamReaderPActivity.this.b(comicChapter);
            }
            if (comicChapter == null || comicChapter.getItemType() == 1 || comicChapter.getItemType() == 3) {
                return;
            }
            MkStreamReaderPActivity.this.P0 = comicChapter.getIndex() + 1;
            MkStreamReaderPActivity.this.Q0 = comicChapter.getCount();
            MkStreamReaderPActivity.this.S1 = iFindFirstVisibleItemPosition;
            MkStreamReaderPActivity.this.h0();
        }
    }

    private void i0() {
        this.F0.a("pref_reader_stream_load_prev", false);
        this.F0.a("pref_reader_stream_load_next", true);
        this.L0.g(1);
        this.f2357a1 = this.F0.a("pref_reader_stream_interval", false);
        if (this.f2357a1) {
            this.e1 = this.L0.u();
            this.mRecyclerView.addItemDecoration(this.e1);
        }
        this.mReaderBox.setBackgroundColor(com.amgcyo.cuttadon.f.o.b(R.color.translucent));
        W();
        ((ZoomableRecyclerView) this.mRecyclerView).setVertical(this.turn == 2);
        ((ZoomableRecyclerView) this.mRecyclerView).setDoubleTap(true ^ this.X0);
        ((ZoomableRecyclerView) this.mRecyclerView).setTapListenerListener(this);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.mRecyclerView.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        this.mRecyclerView.addOnScrollListener(new a());
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected int B() {
        return this.S1;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void S() {
        G();
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        if (this.turn == 2) {
            RecyclerView recyclerView = this.mRecyclerView;
            int i2 = point.y;
            recyclerView.smoothScrollBy(0, (-i2) + (i2 / 5));
        } else {
            this.mRecyclerView.smoothScrollBy(-point.x, 0);
        }
        if (this.M0.findFirstVisibleItemPosition() == 0) {
            Q();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        if (this.L0 != null) {
            i0();
        } else {
            A();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.comic_ac_stream_reader;
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void nextPage() {
        G();
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || this.L0 == null) {
            return;
        }
        if (this.turn == 2) {
            int i2 = point.y;
            recyclerView.smoothScrollBy(0, i2 - (i2 / 5));
        } else {
            recyclerView.smoothScrollBy(point.x, 0);
        }
        if (this.M0.findLastVisibleItemPosition() == this.L0.getItemCount() - 1) {
            l(2);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    public void onPrevLoadSuccess(List<ComicChapter> list) {
        super.onPrevLoadSuccess(list);
        if (this.S1 == 0) {
            this.S1 = list.size();
        }
        TwinklingRefreshLayout twinklingRefreshLayout = this.l1;
        if (twinklingRefreshLayout != null) {
            twinklingRefreshLayout.f();
        }
        this.mRecyclerView.smoothScrollToPosition(B() - 1);
    }

    public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z2) {
        if (z2) {
            int i3 = this.S1 + i2;
            int i4 = this.P0;
            this.S0 = this.L0.a(i3 - i4, i2, i2 < i4);
        }
    }

    public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {
        this.M0.scrollToPositionWithOffset(this.S0, 0);
    }
}
