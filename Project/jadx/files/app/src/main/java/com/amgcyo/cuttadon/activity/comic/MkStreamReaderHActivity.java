package com.amgcyo.cuttadon.activity.comic;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.mardous.discreteseekbar.DiscreteSeekBar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkStreamReaderHActivity extends MkStreamReaderPActivity {
    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void S() {
        super.S();
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity, com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    protected void nextPage() {
        super.nextPage();
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity
    public void onPrevLoadSuccess(List<ComicChapter> list) {
        super.onPrevLoadSuccess(list);
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.mardous.discreteseekbar.DiscreteSeekBar.g
    public void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z2) {
        super.onProgressChanged(discreteSeekBar, i2, z2);
    }

    @Override // com.amgcyo.cuttadon.activity.comic.MkStreamReaderPActivity, com.mardous.discreteseekbar.DiscreteSeekBar.g
    public void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar) {
        super.onStopTrackingTouch(discreteSeekBar);
    }
}
