package com.xuexiang.xupdate.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

/* JADX INFO: loaded from: classes4.dex */
public class UpdateDialog extends BaseDialog implements View.OnClickListener, IDownloadEventHandler {
    private Button mBtnBackgroundUpdate;
    private Button mBtnUpdate;
    private ImageView mIvClose;
    private ImageView mIvTop;
    private LinearLayout mLlClose;
    private NumberProgressBar mNumberProgressBar;
    private PromptEntity mPromptEntity;
    private IPrompterProxy mPrompterProxy;
    private TextView mTvIgnore;
    private TextView mTvTitle;
    private TextView mTvUpdateInfo;
    private UpdateEntity mUpdateEntity;

    public static UpdateDialog newInstance(Context context, UpdateEntity updateEntity, IPrompterProxy iPrompterProxy, PromptEntity promptEntity) {
        UpdateDialog updateDialog = new UpdateDialog(context);
        updateDialog.setIPrompterProxy(iPrompterProxy).setUpdateEntity(updateEntity).setPromptEntity(promptEntity);
        updateDialog.initTheme(promptEntity.getThemeColor(), promptEntity.getTopResId(), promptEntity.getButtonTextColor(), promptEntity.getWidthRatio(), promptEntity.getHeightRatio());
        return updateDialog;
    }

    private UpdateDialog(Context context) {
        super(context, R.layout.xupdate_dialog_update);
    }

    public UpdateDialog setPromptEntity(PromptEntity promptEntity) {
        this.mPromptEntity = promptEntity;
        return this;
    }

    @Override // com.xuexiang.xupdate.widget.BaseDialog
    protected void initViews() {
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

    @Override // com.xuexiang.xupdate.widget.BaseDialog
    protected void initListeners() {
        this.mBtnUpdate.setOnClickListener(this);
        this.mBtnBackgroundUpdate.setOnClickListener(this);
        this.mIvClose.setOnClickListener(this);
        this.mTvIgnore.setOnClickListener(this);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setIsSyncSystemUiVisibility(true);
    }

    private String getUrl() {
        IPrompterProxy iPrompterProxy = this.mPrompterProxy;
        return iPrompterProxy != null ? iPrompterProxy.getUrl() : "";
    }

    @Override // com.xuexiang.xupdate.widget.BaseDialog, android.app.Dialog
    public void show() {
        _XUpdate.setIsPrompterShow(getUrl(), true);
        super.show();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        _XUpdate.setIsPrompterShow(getUrl(), false);
        clearIPrompterProxy();
        super.dismiss();
    }

    private void clearIPrompterProxy() {
        IPrompterProxy iPrompterProxy = this.mPrompterProxy;
        if (iPrompterProxy != null) {
            iPrompterProxy.recycle();
            this.mPrompterProxy = null;
        }
    }

    public UpdateDialog setUpdateEntity(UpdateEntity updateEntity) {
        this.mUpdateEntity = updateEntity;
        initUpdateInfo(updateEntity);
        return this;
    }

    private void initUpdateInfo(UpdateEntity updateEntity) {
        String versionName = updateEntity.getVersionName();
        this.mTvUpdateInfo.setText(UpdateUtils.getDisplayUpdateInfo(getContext(), updateEntity));
        this.mTvTitle.setText(String.format(getString(R.string.xupdate_lab_ready_update), versionName));
        refreshUpdateButton();
        if (updateEntity.isForce()) {
            this.mLlClose.setVisibility(8);
        }
    }

    private void initTheme(int i, int i2, int i3, float f, float f2) {
        if (i == -1) {
            i = ColorUtils.getColor(getContext(), R.color.xupdate_default_theme_color);
        }
        int i4 = i;
        if (i2 == -1) {
            i2 = R.drawable.xupdate_bg_app_top;
        }
        int i5 = i2;
        if (i3 == 0) {
            i3 = ColorUtils.isColorDark(i4) ? -1 : -16777216;
        }
        setDialogTheme(i4, i5, i3, f, f2);
    }

    private void setDialogTheme(int i, int i2, int i3, float f, float f2) {
        Drawable topDrawable = _XUpdate.getTopDrawable(this.mPromptEntity.getTopDrawableTag());
        if (topDrawable != null) {
            this.mIvTop.setImageDrawable(topDrawable);
        } else {
            this.mIvTop.setImageResource(i2);
        }
        DrawableUtils.setBackgroundCompat(this.mBtnUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, getContext()), i));
        DrawableUtils.setBackgroundCompat(this.mBtnBackgroundUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, getContext()), i));
        this.mNumberProgressBar.setProgressTextColor(i);
        this.mNumberProgressBar.setReachedBarColor(i);
        this.mBtnUpdate.setTextColor(i3);
        this.mBtnBackgroundUpdate.setTextColor(i3);
        initWindow(f, f2);
    }

    private void initWindow(float f, float f2) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (f > 0.0f && f < 1.0f) {
            attributes.width = (int) (displayMetrics.widthPixels * f);
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            attributes.height = (int) (displayMetrics.heightPixels * f2);
        }
        window.setAttributes(attributes);
    }

    private UpdateDialog setIPrompterProxy(IPrompterProxy iPrompterProxy) {
        this.mPrompterProxy = iPrompterProxy;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_update) {
            int iCheckSelfPermission = ActivityCompat.checkSelfPermission(getContext(), g.j);
            if (!UpdateUtils.isPrivateApkCacheDir(this.mUpdateEntity) && iCheckSelfPermission != 0) {
                ActivityCompat.requestPermissions((Activity) getContext(), new String[]{g.j}, 111);
                return;
            } else {
                installApp();
                return;
            }
        }
        if (id == R.id.btn_background_update) {
            this.mPrompterProxy.backgroundDownload();
            dismiss();
        } else if (id == R.id.iv_close) {
            this.mPrompterProxy.cancelDownload();
            dismiss();
        } else if (id == R.id.tv_ignore) {
            UpdateUtils.saveIgnoreVersion(getContext(), this.mUpdateEntity.getVersionName());
            dismiss();
        }
    }

    private void installApp() {
        if (UpdateUtils.isApkDownloaded(this.mUpdateEntity)) {
            onInstallApk();
            if (!this.mUpdateEntity.isForce()) {
                dismiss();
                return;
            } else {
                showInstallButton();
                return;
            }
        }
        IPrompterProxy iPrompterProxy = this.mPrompterProxy;
        if (iPrompterProxy != null) {
            iPrompterProxy.startDownload(this.mUpdateEntity, new WeakFileDownloadListener(this));
        }
        if (this.mUpdateEntity.isIgnorable()) {
            this.mTvIgnore.setVisibility(8);
        }
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public void handleStart() {
        if (isShowing()) {
            doStart();
        }
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
        if (isShowing()) {
            if (this.mNumberProgressBar.getVisibility() == 8) {
                doStart();
            }
            this.mNumberProgressBar.setProgress(Math.round(f * 100.0f));
            this.mNumberProgressBar.setMax(100);
        }
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public boolean handleCompleted(File file) {
        if (!isShowing()) {
            return true;
        }
        this.mBtnBackgroundUpdate.setVisibility(8);
        if (this.mUpdateEntity.isForce()) {
            showInstallButton();
            return true;
        }
        dismiss();
        return true;
    }

    @Override // com.xuexiang.xupdate.widget.IDownloadEventHandler
    public void handleError(Throwable th) {
        if (isShowing()) {
            if (this.mPromptEntity.isIgnoreDownloadError()) {
                refreshUpdateButton();
            } else {
                dismiss();
            }
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
        _XUpdate.startInstallApk(getContext(), this.mUpdateEntity);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        _XUpdate.setIsPrompterShow(getUrl(), true);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        _XUpdate.setIsPrompterShow(getUrl(), false);
        clearIPrompterProxy();
        super.onDetachedFromWindow();
    }
}
