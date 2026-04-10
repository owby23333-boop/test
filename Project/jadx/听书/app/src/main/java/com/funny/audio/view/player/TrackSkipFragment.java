package com.funny.audio.view.player;

import android.view.View;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.FragmentTrackPlayerSkipBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.media_player.SkipSetting;
import com.funny.audio.view.core.BaseBottomSheetDialogFragment;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUISlider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackSkipFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/funny/audio/view/player/TrackSkipFragment;", "Lcom/funny/audio/view/core/BaseBottomSheetDialogFragment;", "Lcom/funny/audio/databinding/FragmentTrackPlayerSkipBinding;", "()V", "initData", "", "initView", "view", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackSkipFragment extends BaseBottomSheetDialogFragment<FragmentTrackPlayerSkipBinding> {
    public static final /* synthetic */ FragmentTrackPlayerSkipBinding access$getBd(TrackSkipFragment trackSkipFragment) {
        return trackSkipFragment.getBd();
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getBd().sliderSkipStart.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackSkipFragment.initView.1
            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onLongTouch(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStartMoving(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStopMoving(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchDown(QMUISlider slider, int progress, int tickCount, boolean hitThumb) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipStart.setText(progress + "s");
                if (progress > 0) {
                    TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipStart.setVisibility(0);
                } else {
                    TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipStart.setVisibility(8);
                }
            }
        });
        getBd().sliderSkipEnd.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackSkipFragment.initView.2
            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onLongTouch(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStartMoving(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStopMoving(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchDown(QMUISlider slider, int progress, int tickCount, boolean hitThumb) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipEnd.setText(progress + "s");
                if (progress > 0) {
                    TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipEnd.setVisibility(0);
                } else {
                    TrackSkipFragment.access$getBd(TrackSkipFragment.this).tvSkipEnd.setVisibility(8);
                }
            }
        });
        QMUIFrameLayout qMUIFrameLayout = getBd().btnSaveSetting;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnSaveSetting");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackSkipFragment.initView.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SkipSetting skipSetting = new SkipSetting(0L, 0L, 3, null);
                skipSetting.setSkipStart(TrackSkipFragment.access$getBd(TrackSkipFragment.this).sliderSkipStart.getCurrentProgress() * 1000);
                skipSetting.setSkipEnd(TrackSkipFragment.access$getBd(TrackSkipFragment.this).sliderSkipEnd.getCurrentProgress() * 1000);
                MediaPlayerManager.INSTANCE.setSkipSetting(skipSetting);
                TrackSkipFragment.this.dismiss();
            }
        }, 1, null);
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initData() {
        SkipSetting skip = MediaPlayerManager.INSTANCE.getCurrentPlaySetting().getSkip();
        long j = 1000;
        getBd().sliderSkipStart.setCurrentProgress((int) (skip.getSkipStart() / j));
        getBd().sliderSkipEnd.setCurrentProgress((int) (skip.getSkipEnd() / j));
    }
}
