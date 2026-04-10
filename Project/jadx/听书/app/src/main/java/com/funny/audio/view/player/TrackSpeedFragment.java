package com.funny.audio.view.player;

import android.view.View;
import com.funny.audio.databinding.FragmentTrackPlayerSpeedBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.view.core.BaseBottomSheetDialogFragment;
import com.qmuiteam.qmui.widget.QMUISlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackSpeedFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/funny/audio/view/player/TrackSpeedFragment;", "Lcom/funny/audio/view/core/BaseBottomSheetDialogFragment;", "Lcom/funny/audio/databinding/FragmentTrackPlayerSpeedBinding;", "()V", "initData", "", "initView", "view", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackSpeedFragment extends BaseBottomSheetDialogFragment<FragmentTrackPlayerSpeedBinding> {
    public static final /* synthetic */ FragmentTrackPlayerSpeedBinding access$getBd(TrackSpeedFragment trackSpeedFragment) {
        return trackSpeedFragment.getBd();
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getBd().seekBarSpeed.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackSpeedFragment.initView.1
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
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                float f = (progress * 0.25f) + 0.5f;
                TrackSpeedFragment.access$getBd(TrackSpeedFragment.this).tvSpeed.setText(f + "x");
                MediaPlayerManager.INSTANCE.setPlaySpeed(f);
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
                MediaPlayerManager.INSTANCE.savePlaySpeed();
            }
        });
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initData() {
        getBd().seekBarSpeed.setCurrentProgress((int) ((MediaPlayerManager.INSTANCE.getCurrentPlaySetting().getPlaySpeed() - 0.5f) / 0.25f));
    }
}
