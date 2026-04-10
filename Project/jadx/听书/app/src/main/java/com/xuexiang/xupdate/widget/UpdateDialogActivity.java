package com.xuexiang.xupdate.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import com.xuexiang.xupdate.R;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.PromptEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IPrompterProxy;
import com.xuexiang.xupdate.utils.ColorUtils;
import com.xuexiang.xupdate.utils.DrawableUtils;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateDialogActivity extends AppCompatActivity implements View.OnClickListener, IDownloadEventHandler {
    private static IPrompterProxy sIPrompterProxy;
    private Button mBtnBackgroundUpdate;
    private Button mBtnUpdate;
    private ImageView mIvClose;
    private ImageView mIvTop;
    private LinearLayout mLlClose;
    private NumberProgressBar mNumberProgressBar;
    private PromptEntity mPromptEntity;
    private TextView mTvIgnore;
    private TextView mTvTitle;
    private TextView mTvUpdateInfo;
    private UpdateEntity mUpdateEntity;

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public static void show(Context context, UpdateEntity updateEntity, IPrompterProxy iPrompterProxy, PromptEntity promptEntity) {
        Intent intent = new Intent(context, (Class<?>) UpdateDialogActivity.class);
        intent.putExtra(UpdateDialogFragment.KEY_UPDATE_ENTITY, updateEntity);
        intent.putExtra(UpdateDialogFragment.KEY_UPDATE_PROMPT_ENTITY, promptEntity);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        setIPrompterProxy(iPrompterProxy);
        context.startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.xupdate_layout_update_prompter);
        _XUpdate.setIsPrompterShow(getUrl(), true);
        initView();
        initData();
    }

    private void initView() {
        this.mIvTop = (ImageView) findViewById(R.id.iv_top);
        this.mTvTitle = (TextView) findViewById(R.id.tv_title);
        this.mTvUpdateInfo = (TextView) findViewById(R.id.tv_update_info);
        this.mBtnUpdate = (Button) findViewById(R.id.btn_update);
        this.mBtnBackgroundUpdate = (Button) findViewById(R.id.btn_background_update);
        this.mTvIgnore = (TextView) findViewById(R.id.tv_ignore);
        this.mNumberProgressBar = (NumberProgressBar) findViewById(R.id.npb_progress);
        this.mLlClose = (LinearLayout) findViewById(R.id.ll_close);
        this.mIvClose = (ImageView) findViewById(R.id.iv_close);
    }

    private void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        PromptEntity promptEntity = (PromptEntity) extras.getParcelable(UpdateDialogFragment.KEY_UPDATE_PROMPT_ENTITY);
        this.mPromptEntity = promptEntity;
        if (promptEntity == null) {
            this.mPromptEntity = new PromptEntity();
        }
        initTheme(this.mPromptEntity.getThemeColor(), this.mPromptEntity.getTopResId(), this.mPromptEntity.getButtonTextColor());
        UpdateEntity updateEntity = (UpdateEntity) extras.getParcelable(UpdateDialogFragment.KEY_UPDATE_ENTITY);
        this.mUpdateEntity = updateEntity;
        if (updateEntity != null) {
            initUpdateInfo(updateEntity);
            initListeners();
        }
    }

    private PromptEntity getPromptEntity() {
        Bundle extras;
        if (this.mPromptEntity == null && (extras = getIntent().getExtras()) != null) {
            this.mPromptEntity = (PromptEntity) extras.getParcelable(UpdateDialogFragment.KEY_UPDATE_PROMPT_ENTITY);
        }
        if (this.mPromptEntity == null) {
            this.mPromptEntity = new PromptEntity();
        }
        return this.mPromptEntity;
    }

    private void initUpdateInfo(UpdateEntity updateEntity) {
        String versionName = updateEntity.getVersionName();
        this.mTvUpdateInfo.setText(UpdateUtils.getDisplayUpdateInfo(this, updateEntity));
        this.mTvTitle.setText(String.format(getString(R.string.xupdate_lab_ready_update), versionName));
        refreshUpdateButton();
        if (updateEntity.isForce()) {
            this.mLlClose.setVisibility(8);
        }
    }

    private void initTheme(int i, int i2, int i3) {
        if (i == -1) {
            i = ColorUtils.getColor(this, R.color.xupdate_default_theme_color);
        }
        if (i2 == -1) {
            i2 = R.drawable.xupdate_bg_app_top;
        }
        if (i3 == 0) {
            i3 = ColorUtils.isColorDark(i) ? -1 : -16777216;
        }
        setDialogTheme(i, i2, i3);
    }

    private void setDialogTheme(int i, int i2, int i3) {
        Drawable topDrawable = _XUpdate.getTopDrawable(this.mPromptEntity.getTopDrawableTag());
        if (topDrawable != null) {
            this.mIvTop.setImageDrawable(topDrawable);
        } else {
            this.mIvTop.setImageResource(i2);
        }
        DrawableUtils.setBackgroundCompat(this.mBtnUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, this), i));
        DrawableUtils.setBackgroundCompat(this.mBtnBackgroundUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, this), i));
        this.mNumberProgressBar.setProgressTextColor(i);
        this.mNumberProgressBar.setReachedBarColor(i);
        this.mBtnUpdate.setTextColor(i3);
        this.mBtnBackgroundUpdate.setTextColor(i3);
    }

    private void initListeners() {
        this.mBtnUpdate.setOnClickListener(this);
        this.mBtnBackgroundUpdate.setOnClickListener(this);
        this.mIvClose.setOnClickListener(this);
        this.mTvIgnore.setOnClickListener(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        initWindowStyle();
    }

    private void initWindowStyle() {
        Window window = getWindow();
        if (window != null) {
            PromptEntity promptEntity = getPromptEntity();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (promptEntity.getWidthRatio() > 0.0f && promptEntity.getWidthRatio() < 1.0f) {
                attributes.width = (int) (displayMetrics.widthPixels * promptEntity.getWidthRatio());
            }
            if (promptEntity.getHeightRatio() > 0.0f && promptEntity.getHeightRatio() < 1.0f) {
                attributes.height = (int) (displayMetrics.heightPixels * promptEntity.getHeightRatio());
            }
            window.setAttributes(attributes);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_update) {
            int iCheckSelfPermission = ActivityCompat.checkSelfPermission(this, g.j);
            if (!UpdateUtils.isPrivateApkCacheDir(this.mUpdateEntity) && iCheckSelfPermission != 0) {
                ActivityCompat.requestPermissions(this, new String[]{g.j}, 111);
                return;
            } else {
                installApp();
                return;
            }
        }
        if (id == R.id.btn_background_update) {
            IPrompterProxy iPrompterProxy = sIPrompterProxy;
            if (iPrompterProxy != null) {
                iPrompterProxy.backgroundDownload();
            }
            dismissDialog();
            return;
        }
        if (id == R.id.iv_close) {
            IPrompterProxy iPrompterProxy2 = sIPrompterProxy;
            if (iPrompterProxy2 != null) {
                iPrompterProxy2.cancelDownload();
            }
            dismissDialog();
            return;
        }
        if (id == R.id.tv_ignore) {
            UpdateUtils.saveIgnoreVersion(this, this.mUpdateEntity.getVersionName());
            dismissDialog();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 111) {
            if (iArr.length > 0 && iArr[0] == 0) {
                installApp();
            } else {
                _XUpdate.onUpdateError(4001);
                dismissDialog();
            }
        }
    }

    private void installApp() {
        if (UpdateUtils.isApkDownloaded(this.mUpdateEntity)) {
            onInstallApk();
            if (!this.mUpdateEntity.isForce()) {
                dismissDialog();
                return;
            } else {
                showInstallButton();
                return;
            }
        }
        IPrompterProxy iPrompterProxy = sIPrompterProxy;
        if (iPrompterProxy != null) {
            iPrompterProxy.startDownload(this.mUpdateEntity, new WeakFileDownloadListener(this));
        }
        if (this.mUpdateEntity.isIgnorable()) {
            this.mTvIgnore.setVisibility(8);
        }
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public void handleStart() {
        if (isFinishing()) {
            return;
        }
        doStart();
    }

    private void doStart() {
        this.mNumberProgressBar.setVisibility(0);
        this.mNumberProgressBar.setProgress(0);
        this.mBtnUpdate.setVisibility(8);
        if (this.mPromptEntity.isSupportBackgroundUpdate()) {
            this.mBtnBackgroundUpdate.setVisibility(0);
        } else {
            this.mBtnBackgroundUpdate.setVisibility(8);
        }
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public void handleProgress(float f) {
        if (isFinishing()) {
            return;
        }
        if (this.mNumberProgressBar.getVisibility() == 8) {
            doStart();
        }
        this.mNumberProgressBar.setProgress(Math.round(f * 100.0f));
        this.mNumberProgressBar.setMax(100);
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public boolean handleCompleted(File file) {
        if (isFinishing()) {
            return true;
        }
        this.mBtnBackgroundUpdate.setVisibility(8);
        if (this.mUpdateEntity.isForce()) {
            showInstallButton();
            return true;
        }
        dismissDialog();
        return true;
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public void handleError(Throwable th) {
        if (isFinishing()) {
            return;
        }
        if (this.mPromptEntity.isIgnoreDownloadError()) {
            refreshUpdateButton();
        } else {
            dismissDialog();
        }
    }

    private void refreshUpdateButton() {
        if (UpdateUtils.isApkDownloaded(this.mUpdateEntity)) {
            showInstallButton();
        } else {
            showUpdateButton();
        }
        this.mTvIgnore.setVisibility(this.mUpdateEntity.isIgnorable() ? 0 : 8);
    }

    private void showInstallButton() {
        this.mNumberProgressBar.setVisibility(8);
        this.mBtnBackgroundUpdate.setVisibility(8);
        this.mBtnUpdate.setText(R.string.xupdate_lab_install);
        this.mBtnUpdate.setVisibility(0);
        this.mBtnUpdate.setOnClickListener(this);
    }

    private void showUpdateButton() {
        this.mNumberProgressBar.setVisibility(8);
        this.mBtnBackgroundUpdate.setVisibility(8);
        this.mBtnUpdate.setText(R.string.xupdate_lab_update);
        this.mBtnUpdate.setVisibility(0);
        this.mBtnUpdate.setOnClickListener(this);
    }

    private void onInstallApk() {
        _XUpdate.startInstallApk(this, this.mUpdateEntity);
    }

    private void dismissDialog() {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (isFinishing()) {
            _XUpdate.setIsPrompterShow(getUrl(), false);
            clearIPrompterProxy();
        }
        super.onStop();
    }

    private static void setIPrompterProxy(IPrompterProxy iPrompterProxy) {
        sIPrompterProxy = iPrompterProxy;
    }

    private static void clearIPrompterProxy() {
        IPrompterProxy iPrompterProxy = sIPrompterProxy;
        if (iPrompterProxy != null) {
            iPrompterProxy.recycle();
            sIPrompterProxy = null;
        }
    }

    private String getUrl() {
        IPrompterProxy iPrompterProxy = sIPrompterProxy;
        return iPrompterProxy != null ? iPrompterProxy.getUrl() : "";
    }
}
