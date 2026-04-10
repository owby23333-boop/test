package com.king.zxing;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureActivity extends AppCompatActivity implements p {
    public static final String KEY_RESULT = "SCAN_RESULT";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private SurfaceView f16419s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ViewfinderView f16420t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View f16421u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private h f16422v;

    @Deprecated
    public com.king.zxing.camera.d getCameraManager() {
        return this.f16422v.a();
    }

    public h getCaptureHelper() {
        return this.f16422v;
    }

    public int getIvTorchId() {
        return R$id.ivTorch;
    }

    public int getLayoutId() {
        return R$layout.zxl_capture;
    }

    public int getSurfaceViewId() {
        return R$id.surfaceView;
    }

    public int getViewfinderViewId() {
        return R$id.viewfinderView;
    }

    public void initCaptureHelper() {
        this.f16422v = new h(this, this.f16419s, this.f16420t, this.f16421u);
        this.f16422v.a(this);
    }

    public void initUI() {
        this.f16419s = (SurfaceView) findViewById(getSurfaceViewId());
        int viewfinderViewId = getViewfinderViewId();
        if (viewfinderViewId != 0) {
            this.f16420t = (ViewfinderView) findViewById(viewfinderViewId);
        }
        int ivTorchId = getIvTorchId();
        if (ivTorchId != 0) {
            this.f16421u = findViewById(ivTorchId);
            this.f16421u.setVisibility(4);
        }
        initCaptureHelper();
    }

    public boolean isContentView(@LayoutRes int i2) {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int layoutId = getLayoutId();
        if (isContentView(layoutId)) {
            setContentView(layoutId);
        }
        initUI();
        this.f16422v.b();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16422v.c();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16422v.d();
    }

    @Override // com.king.zxing.p
    public boolean onResultCallback(String str) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f16422v.e();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f16422v.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
