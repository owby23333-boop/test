package com.funny.audio.view.player;

import android.view.View;
import android.widget.TextView;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.databinding.FragmentTrackPlayerTimingBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.media_player.TimePauseSetting;
import com.funny.audio.media_player.TimePauseType;
import com.funny.audio.view.core.BaseBottomSheetDialogFragment;
import com.qmuiteam.qmui.widget.QMUISeekBar;
import com.qmuiteam.qmui.widget.QMUISlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: TrackTimingFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/funny/audio/view/player/TrackTimingFragment;", "Lcom/funny/audio/view/core/BaseBottomSheetDialogFragment;", "Lcom/funny/audio/databinding/FragmentTrackPlayerTimingBinding;", "()V", "canUpdateSlide", "", "initData", "", "initView", "view", "Landroid/view/View;", "loadDataFromManager", "onMessageEvent", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "releaseView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackTimingFragment extends BaseBottomSheetDialogFragment<FragmentTrackPlayerTimingBinding> {
    private boolean canUpdateSlide = true;

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        final TextView textView = getBd().tvTimingEpisodeLabel;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvTimingEpisodeLabel");
        final TextView textView2 = getBd().tvTimingEpisode;
        Intrinsics.checkNotNullExpressionValue(textView2, "bd.tvTimingEpisode");
        final QMUISeekBar qMUISeekBar = getBd().seekBarTimingEpisode;
        Intrinsics.checkNotNullExpressionValue(qMUISeekBar, "bd.seekBarTimingEpisode");
        final TextView textView3 = getBd().tvTimingMinuteLabel;
        Intrinsics.checkNotNullExpressionValue(textView3, "bd.tvTimingMinuteLabel");
        final TextView textView4 = getBd().tvTimingMinute;
        Intrinsics.checkNotNullExpressionValue(textView4, "bd.tvTimingMinute");
        final QMUISeekBar qMUISeekBar2 = getBd().seekBarTimingMinute;
        Intrinsics.checkNotNullExpressionValue(qMUISeekBar2, "bd.seekBarTimingMinute");
        qMUISeekBar.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackTimingFragment.initView.1
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
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                if (progress > 0) {
                    textView.setVisibility(0);
                    textView3.setVisibility(8);
                    textView2.setText(String.valueOf(progress));
                    textView4.setText("定时停止播放");
                    qMUISeekBar2.setCurrentProgress(0);
                    return;
                }
                textView.setVisibility(8);
                textView3.setVisibility(8);
                textView2.setText("定集停止播放");
                qMUISeekBar.setCurrentProgress(0);
                textView4.setText("定时停止播放");
                qMUISeekBar2.setCurrentProgress(0);
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchDown(QMUISlider slider, int progress, int tickCount, boolean hitThumb) {
                if (hitThumb) {
                    this.canUpdateSlide = false;
                }
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
                if (progress > 0) {
                    TimePauseSetting timePauseSetting = new TimePauseSetting(false, 0, 0L, 0L, 15, null);
                    timePauseSetting.setEnable(true);
                    timePauseSetting.setType(TimePauseType.INSTANCE.getEPISODES());
                    long j = progress;
                    timePauseSetting.setSetValue(j);
                    timePauseSetting.setValue(j);
                    MediaPlayerManager.INSTANCE.setTimePauseSetting(timePauseSetting);
                } else {
                    MediaPlayerManager.INSTANCE.setTimePauseSetting(new TimePauseSetting(false, 0, 0L, 0L, 15, null));
                }
                this.canUpdateSlide = true;
            }
        });
        qMUISeekBar2.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackTimingFragment.initView.2
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
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                if (progress > 0) {
                    textView.setVisibility(8);
                    textView3.setVisibility(0);
                    textView4.setText(TrackPlayerActivityKt.formatDuration(progress * 5 * 60 * 1000));
                    textView2.setText("定集停止播放");
                    qMUISeekBar.setCurrentProgress(0);
                    return;
                }
                textView.setVisibility(8);
                textView3.setVisibility(8);
                textView2.setText("定集停止播放");
                qMUISeekBar.setCurrentProgress(0);
                textView4.setText("定时停止播放");
                qMUISeekBar2.setCurrentProgress(0);
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchDown(QMUISlider slider, int progress, int tickCount, boolean hitThumb) {
                if (hitThumb) {
                    this.canUpdateSlide = false;
                }
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
                if (progress > 0) {
                    TimePauseSetting timePauseSetting = new TimePauseSetting(false, 0, 0L, 0L, 15, null);
                    timePauseSetting.setEnable(true);
                    timePauseSetting.setType(TimePauseType.INSTANCE.getMINUTES());
                    long j = progress * 5 * 60 * 1000;
                    timePauseSetting.setSetValue(j);
                    timePauseSetting.setValue(j);
                    MediaPlayerManager.INSTANCE.setTimePauseSetting(timePauseSetting);
                } else {
                    MediaPlayerManager.INSTANCE.setTimePauseSetting(new TimePauseSetting(false, 0, 0L, 0L, 15, null));
                }
                this.canUpdateSlide = true;
            }
        });
        EventBus.getDefault().register(this);
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(UpdatePlayerEvent updatePlayerEvent) {
        Intrinsics.checkNotNullParameter(updatePlayerEvent, "updatePlayerEvent");
        loadDataFromManager();
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initData() {
        loadDataFromManager();
    }

    private final void loadDataFromManager() {
        if (this.canUpdateSlide) {
            TimePauseSetting timePauseSetting = MediaPlayerManager.INSTANCE.getTimePauseSetting();
            TextView textView = getBd().tvTimingEpisodeLabel;
            Intrinsics.checkNotNullExpressionValue(textView, "bd.tvTimingEpisodeLabel");
            TextView textView2 = getBd().tvTimingEpisode;
            Intrinsics.checkNotNullExpressionValue(textView2, "bd.tvTimingEpisode");
            QMUISeekBar qMUISeekBar = getBd().seekBarTimingEpisode;
            Intrinsics.checkNotNullExpressionValue(qMUISeekBar, "bd.seekBarTimingEpisode");
            TextView textView3 = getBd().tvTimingMinuteLabel;
            Intrinsics.checkNotNullExpressionValue(textView3, "bd.tvTimingMinuteLabel");
            TextView textView4 = getBd().tvTimingMinute;
            Intrinsics.checkNotNullExpressionValue(textView4, "bd.tvTimingMinute");
            QMUISeekBar qMUISeekBar2 = getBd().seekBarTimingMinute;
            Intrinsics.checkNotNullExpressionValue(qMUISeekBar2, "bd.seekBarTimingMinute");
            if (timePauseSetting.getEnable()) {
                int type = timePauseSetting.getType();
                if (type == TimePauseType.INSTANCE.getMINUTES()) {
                    textView.setVisibility(8);
                    textView3.setVisibility(0);
                    textView4.setText(TrackPlayerActivityKt.formatDuration(timePauseSetting.getValue()));
                    qMUISeekBar2.setCurrentProgress((int) (((timePauseSetting.getSetValue() / ((long) 1000)) / ((long) 60)) / ((long) 5)));
                    textView2.setText("定集停止播放");
                    qMUISeekBar.setCurrentProgress(0);
                    return;
                }
                if (type == TimePauseType.INSTANCE.getEPISODES()) {
                    textView.setVisibility(0);
                    textView3.setVisibility(8);
                    textView2.setText(String.valueOf(timePauseSetting.getValue()));
                    qMUISeekBar.setCurrentProgress((int) timePauseSetting.getSetValue());
                    textView4.setText("定时停止播放");
                    qMUISeekBar2.setCurrentProgress(0);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
            textView3.setVisibility(8);
            textView2.setText("定集停止播放");
            qMUISeekBar.setCurrentProgress(0);
            textView4.setText("定时停止播放");
            qMUISeekBar2.setCurrentProgress(0);
        }
    }
}
