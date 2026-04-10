package com.funny.audio.view;

import android.content.Intent;
import android.widget.ImageView;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityH5InBinding;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: H5InActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/funny/audio/view/H5InActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityH5InBinding;", "()V", "title", "", "url", "initData", "", "initStatusBar", "initView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class H5InActivity extends BaseActivity<ActivityH5InBinding> {
    private String title;
    private String url = "";

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this.title = navigationUtils.getTitle(intent);
        NavigationUtils navigationUtils2 = NavigationUtils.INSTANCE;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        this.url = navigationUtils2.getURL(intent2);
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.H5InActivity.initView.1
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
                H5InActivity.this.finish();
            }
        }, 1, null);
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        if (this.title == null) {
            getBd().tvTitle.setVisibility(8);
        } else {
            getBd().tvTitle.setVisibility(0);
            getBd().tvTitle.setText(this.title);
        }
        getBd().webview.getSettings().setJavaScriptEnabled(true);
        getBd().webview.loadUrl(this.url);
    }

    private final void initStatusBar() {
        H5InActivity h5InActivity = this;
        StatusBarUtils.INSTANCE.translucent(h5InActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(h5InActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(h5InActivity);
        }
    }
}
