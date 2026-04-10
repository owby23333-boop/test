package com.funny.audio.view.mine;

import com.funny.audio.AppManager;
import com.funny.audio.databinding.ActivityPureModeBinding;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: PureModeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/funny/audio/view/mine/PureModeActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityPureModeBinding;", "()V", "initData", "", "initStatusBar", "initView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PureModeActivity extends BaseActivity<ActivityPureModeBinding> {
    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
    }

    private final void initStatusBar() {
        PureModeActivity pureModeActivity = this;
        StatusBarUtils.INSTANCE.translucent(pureModeActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(pureModeActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(pureModeActivity);
        }
    }
}
