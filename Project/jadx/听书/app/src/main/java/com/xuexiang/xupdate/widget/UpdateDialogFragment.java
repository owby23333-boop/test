package com.xuexiang.xupdate.widget;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.kuaishou.weapon.p0.g;
import com.xuexiang.xupdate.R;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.PromptEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IPrompterProxy;
import com.xuexiang.xupdate.utils.ColorUtils;
import com.xuexiang.xupdate.utils.DialogUtils;
import com.xuexiang.xupdate.utils.DrawableUtils;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class UpdateDialogFragment extends DialogFragment implements View.OnClickListener, IDownloadEventHandler {
    public static final String KEY_UPDATE_ENTITY = "key_update_entity";
    public static final String KEY_UPDATE_PROMPT_ENTITY = "key_update_prompt_entity";
    public static final int REQUEST_CODE_REQUEST_PERMISSIONS = 111;
    private static IPrompterProxy sIPrompterProxy;
    private Button mBtnBackgroundUpdate;
    private Button mBtnUpdate;
    private int mCurrentOrientation;
    private ImageView mIvClose;
    private ImageView mIvTop;
    private LinearLayout mLlClose;
    private NumberProgressBar mNumberProgressBar;
    private PromptEntity mPromptEntity;
    private TextView mTvIgnore;
    private TextView mTvTitle;
    private TextView mTvUpdateInfo;
    private UpdateEntity mUpdateEntity;

    public static void show(FragmentManager fragmentManager, UpdateEntity updateEntity, IPrompterProxy iPrompterProxy, PromptEntity promptEntity) {
        UpdateDialogFragment updateDialogFragment = new UpdateDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_UPDATE_ENTITY, updateEntity);
        bundle.putParcelable(KEY_UPDATE_PROMPT_ENTITY, promptEntity);
        updateDialogFragment.setArguments(bundle);
        setIPrompterProxy(iPrompterProxy);
        updateDialogFragment.show(fragmentManager);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        _XUpdate.setIsPrompterShow(getUrl(), true);
        setStyle(1, R.style.XUpdate_Fragment_Dialog);
        this.mCurrentOrientation = getResources().getConfiguration().orientation;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.addFlags(8);
        super.onStart();
        DialogUtils.syncSystemUiVisibility(getActivity(), window);
        window.clearFlags(8);
        initDialog();
    }

    private void initDialog() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        dialog.setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.xupdate_layout_update_prompter, viewGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        initData();
    }

    private void initView(View view) {
        this.mIvTop = (ImageView) view.findViewById(R.id.iv_top);
        this.mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        this.mTvUpdateInfo = (TextView) view.findViewById(R.id.tv_update_info);
        this.mBtnUpdate = (Button) view.findViewById(R.id.btn_update);
        this.mBtnBackgroundUpdate = (Button) view.findViewById(R.id.btn_background_update);
        this.mTvIgnore = (TextView) view.findViewById(R.id.tv_ignore);
        this.mNumberProgressBar = (NumberProgressBar) view.findViewById(R.id.npb_progress);
        this.mLlClose = (LinearLayout) view.findViewById(R.id.ll_close);
        this.mIvClose = (ImageView) view.findViewById(R.id.iv_close);
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        PromptEntity promptEntity = (PromptEntity) arguments.getParcelable(KEY_UPDATE_PROMPT_ENTITY);
        this.mPromptEntity = promptEntity;
        if (promptEntity == null) {
            this.mPromptEntity = new PromptEntity();
        }
        initTheme(this.mPromptEntity.getThemeColor(), this.mPromptEntity.getTopResId(), this.mPromptEntity.getButtonTextColor());
        UpdateEntity updateEntity = (UpdateEntity) arguments.getParcelable(KEY_UPDATE_ENTITY);
        this.mUpdateEntity = updateEntity;
        if (updateEntity != null) {
            initUpdateInfo(updateEntity);
            initListeners();
        }
    }

    private PromptEntity getPromptEntity() {
        Bundle arguments;
        if (this.mPromptEntity == null && (arguments = getArguments()) != null) {
            this.mPromptEntity = (PromptEntity) arguments.getParcelable(KEY_UPDATE_PROMPT_ENTITY);
        }
        if (this.mPromptEntity == null) {
            this.mPromptEntity = new PromptEntity();
        }
        return this.mPromptEntity;
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

    private void initTheme(int i, int i2, int i3) {
        if (i == -1) {
            i = ColorUtils.getColor(getContext(), R.color.xupdate_default_theme_color);
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
        DrawableUtils.setBackgroundCompat(this.mBtnUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, getContext()), i));
        DrawableUtils.setBackgroundCompat(this.mBtnBackgroundUpdate, DrawableUtils.getDrawable(UpdateUtils.dip2px(4, getContext()), i));
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_update) {
            int iCheckSelfPermission = ActivityCompat.checkSelfPermission(getActivity(), g.j);
            if (!UpdateUtils.isPrivateApkCacheDir(this.mUpdateEntity) && iCheckSelfPermission != 0) {
                requestPermissions(new String[]{g.j}, 111);
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
            UpdateUtils.saveIgnoreVersion(getActivity(), this.mUpdateEntity.getVersionName());
            dismissDialog();
        }
    }

    @Override // androidx.fragment.app.Fragment
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
        if (isRemoving()) {
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
        if (isRemoving()) {
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
        if (isRemoving()) {
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
        if (isRemoving()) {
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
        _XUpdate.startInstallApk(getContext(), this.mUpdateEntity);
    }

    private void dismissDialog() {
        _XUpdate.setIsPrompterShow(getUrl(), false);
        clearIPrompterProxy();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (fragmentManager.isDestroyed() || fragmentManager.isStateSaved()) {
            return;
        }
        try {
            super.show(fragmentManager, str);
        } catch (Exception e) {
            _XUpdate.onUpdateError(3000, e.getMessage());
        }
    }

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, "update_dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        _XUpdate.setIsPrompterShow(getUrl(), false);
        clearIPrompterProxy();
        super.onDestroyView();
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

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.mCurrentOrientation) {
            reloadView();
        }
        this.mCurrentOrientation = configuration.orientation;
    }

    private void reloadView() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.xupdate_layout_update_prompter, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(viewInflate);
            initView(viewGroup);
            initData();
        }
    }

    private String getUrl() {
        IPrompterProxy iPrompterProxy = sIPrompterProxy;
        return iPrompterProxy != null ? iPrompterProxy.getUrl() : "";
    }
}
