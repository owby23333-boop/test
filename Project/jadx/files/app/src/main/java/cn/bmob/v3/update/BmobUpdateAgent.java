package cn.bmob.v3.update;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.widget.Toast;
import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.listener.BmobDialogButtonListener;
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.update.res.UpdateConfig;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.DownloadApk;
import cn.bmob.v3.util.FileUtils;
import cn.bmob.v3.util.InstallUtil;
import cn.bmob.v3.util.ManifestUtils;
import com.anythink.china.common.a.a;
import com.umeng.analytics.pro.o;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BmobUpdateAgent {
    private static BmobDialogButtonListener dialogListener;
    private static BmobUpdateListener updateListener;

    public static void add2IgnoreVersion(String str) {
        List<String> localVersions = getLocalVersions();
        if (localVersions == null || localVersions.size() <= 0 || !localVersions.contains(str)) {
            localVersions.add(str);
        }
        saveIgnoreVersion(localVersions);
    }

    private static boolean checkConfig(Context context) {
        PackageInfo packageInfo;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        if (!UpdateConfig.isUpdateCheck()) {
            return true;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), o.a.f19768e);
            if (packageInfo.activities != null) {
                i2 = 0;
                z2 = false;
                while (i2 < packageInfo.activities.length) {
                    if ("cn.bmob.v3.update.UpdateDialogActivity".equals(packageInfo.activities[i2].name)) {
                        z2 = true;
                    }
                    i2++;
                }
            } else {
                i2 = 0;
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (!z2) {
            Toast.makeText(context, "Please add Activity in AndroidManifest!", 0).show();
            return false;
        }
        if (packageInfo.requestedPermissions != null) {
            int i3 = i2;
            z3 = false;
            z4 = false;
            for (int i4 = 0; i4 < packageInfo.requestedPermissions.length; i4++) {
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(packageInfo.requestedPermissions[i4])) {
                    i3 = 1;
                } else if ("android.permission.ACCESS_NETWORK_STATE".equals(packageInfo.requestedPermissions[i4])) {
                    z3 = true;
                } else if ("android.permission.INTERNET".equals(packageInfo.requestedPermissions[i4])) {
                    z4 = true;
                }
            }
            i2 = i3;
        } else {
            z3 = false;
            z4 = false;
        }
        if (!(i2 != 0 && z3 && z4)) {
            Toast.makeText(context, "Please add Permission in AndroidManifest!", 0).show();
            return false;
        }
        return true;
    }

    private static void checkVer(final Context context) {
        if (checkConfig(context)) {
            BmobQuery bmobQuery = new BmobQuery();
            bmobQuery.addWhereEqualTo("platform", "Android");
            String channel = UpdateConfig.getChannel(context);
            if (!TextUtils.isEmpty(channel)) {
                bmobQuery.addWhereEqualTo("channel", channel);
            }
            bmobQuery.addWhereGreaterThan("version_i", Integer.valueOf(ManifestUtils.getVersionCode()));
            bmobQuery.order("-version_i");
            bmobQuery.findObjects(new FindListener<AppVersion>() { // from class: cn.bmob.v3.update.BmobUpdateAgent.5
                @Override // cn.bmob.v3.listener.FindListener, cn.bmob.v3.listener.BmobCallback2
                public void done(List<AppVersion> list, BmobException bmobException) {
                    if (bmobException != null) {
                        if (BmobUpdateAgent.updateListener != null) {
                            BmobUpdateAgent.updateListener.onUpdateReturned(-1, new UpdateResponse(bmobException.getErrorCode(), bmobException.getMessage()));
                            return;
                        }
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        if (BmobUpdateAgent.updateListener != null) {
                            BmobUpdateAgent.updateListener.onUpdateReturned(1, new UpdateResponse(1, "未查询到版本更新信息。"));
                            return;
                        }
                        return;
                    }
                    UpdateResponse updateResponse = new UpdateResponse(list.get(0));
                    if (updateResponse.target_size <= 0) {
                        if (BmobUpdateAgent.updateListener != null) {
                            BmobUpdateAgent.updateListener.onUpdateReturned(2, new UpdateResponse(2, "target_size为空或格式不对，请填写apk文件大小(long类型)。"));
                            return;
                        }
                        return;
                    }
                    if (TextUtils.isEmpty(updateResponse.path)) {
                        if (BmobUpdateAgent.updateListener != null) {
                            BmobUpdateAgent.updateListener.onUpdateReturned(2, new UpdateResponse(2, "path/android_url需填写其中之一。"));
                            return;
                        }
                        return;
                    }
                    if (BmobUpdateAgent.updateListener != null) {
                        BmobUpdateAgent.updateListener.onUpdateReturned(0, updateResponse);
                    }
                    File file = new File(InstallUtil.getAppDir(), updateResponse.path_md5 + a.f6395g);
                    if (UpdateConfig.isSilentDownload()) {
                        if (file.exists()) {
                            BmobUpdateAgent.parseResult(context, updateResponse, file, false);
                            return;
                        } else {
                            BmobUpdateAgent.dialogResult(6, context, updateResponse, file);
                            return;
                        }
                    }
                    if (UpdateConfig.isUpdateForce()) {
                        BmobUpdateAgent.parseResult(context, updateResponse, file, false);
                    } else if (!BmobUpdateAgent.isIgnored(String.valueOf(updateResponse.version_i))) {
                        BmobUpdateAgent.parseResult(context, updateResponse, file, true);
                    } else if (BmobUpdateAgent.updateListener != null) {
                        BmobUpdateAgent.updateListener.onUpdateReturned(3, new UpdateResponse(3, "该版本已被忽略更新"));
                    }
                }
            });
        }
    }

    public static boolean deleteApk() {
        return FileUtils.deleteQuietly(new File(InstallUtil.getAppDir()));
    }

    public static void deleteIgnoreVersion(String str) {
        List<String> localVersions = getLocalVersions();
        if (localVersions != null && localVersions.size() > 0 && localVersions.contains(str)) {
            localVersions.remove(str);
        }
        saveIgnoreVersion(localVersions);
    }

    public static void deleteResponse(UpdateResponse updateResponse) {
        if (updateResponse == null) {
            return;
        }
        File file = new File(InstallUtil.getAppDir(), updateResponse.path_md5 + a.f6395g);
        if (file.exists()) {
            file.delete();
        }
    }

    static void dialogResult(int i2, Context context, UpdateResponse updateResponse, File file) {
        BmobDialogButtonListener bmobDialogButtonListener;
        BmobDialogButtonListener bmobDialogButtonListener2;
        if (i2 == 6) {
            if (!UpdateConfig.isSilentDownload() && (bmobDialogButtonListener = dialogListener) != null) {
                bmobDialogButtonListener.onClick(6);
            }
            updateApp(context, updateResponse, file);
            return;
        }
        if (i2 != 7) {
            if (i2 == 8 && (bmobDialogButtonListener2 = dialogListener) != null) {
                bmobDialogButtonListener2.onClick(8);
                return;
            }
            return;
        }
        BmobDialogButtonListener bmobDialogButtonListener3 = dialogListener;
        if (bmobDialogButtonListener3 != null) {
            bmobDialogButtonListener3.onClick(7);
        }
    }

    private static void downloadApk(boolean z2, Context context, UpdateResponse updateResponse, File file) {
        if (z2 && file != null && file.exists()) {
            file.delete();
        }
        new DownloadApk(context, updateResponse.path).startDownload();
    }

    public static void forceUpdate(Context context) {
        UpdateConfig.setUpdateForce(true);
        UpdateConfig.setSilentDownload(false);
        checkVer(context);
    }

    private static List<String> getLocalVersions() {
        String ignoreVersions = BmobContentProvider.getIgnoreVersions();
        if (ignoreVersions == null || ignoreVersions.equals("")) {
            return new ArrayList();
        }
        if (!ignoreVersions.contains(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ignoreVersions);
            return arrayList;
        }
        String[] strArrSplit = ignoreVersions.split(DispatchConstants.SIGN_SPLIT_SYMBOL);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArrSplit) {
            arrayList2.add(str);
        }
        return arrayList2;
    }

    public static void initAppVersion() {
        AppVersion appVersion = new AppVersion();
        appVersion.setUpdate_log("");
        appVersion.setVersion("");
        appVersion.setVersion_i(0);
        appVersion.setTarget_size("0");
        appVersion.setPath(BmobFile.createEmptyFile());
        appVersion.setAndroid_url("");
        appVersion.setChannel("");
        appVersion.setIos_url("");
        appVersion.setIsforce(false);
        appVersion.setPlatform("Android");
        final Observable<R> map = appVersion.saveObservable().map(new Function<String, BmobException>() { // from class: cn.bmob.v3.update.BmobUpdateAgent.1
            @Override // io.reactivex.functions.Function
            public BmobException apply(String str) {
                return new BmobException();
            }
        });
        BmobQuery bmobQuery = new BmobQuery();
        bmobQuery.setLimit(1);
        bmobQuery.findObjectsObservable(AppVersion.class).concatMap(new Function<List<AppVersion>, Observable<BmobException>>() { // from class: cn.bmob.v3.update.BmobUpdateAgent.4
            @Override // io.reactivex.functions.Function
            public Observable<BmobException> apply(List<AppVersion> list) {
                return (list == null || list.size() <= 0) ? map : Observable.error(new BmobException(ErrorCode.E9015, "AppVersion is exists,no need recreate"));
            }
        }).onErrorResumeNext(new Function<Throwable, Observable<? extends BmobException>>() { // from class: cn.bmob.v3.update.BmobUpdateAgent.3
            @Override // io.reactivex.functions.Function
            public Observable<? extends BmobException> apply(Throwable th) {
                return ((th instanceof BmobException) && ((BmobException) th).getErrorCode() == 101) ? map : Observable.error(th);
            }
        }).subscribe(new Observer<BmobException>() { // from class: cn.bmob.v3.update.BmobUpdateAgent.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                BLog.e(th.getMessage());
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(BmobException bmobException) {
                BLog.i("AppVersion create success");
            }
        });
    }

    public static boolean isIgnored(String str) {
        List<String> localVersions = getLocalVersions();
        return localVersions != null && localVersions.size() > 0 && localVersions.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseResult(Context context, UpdateResponse updateResponse, File file, boolean z2) {
        if (ManifestUtils.getVersionCode() >= updateResponse.version_i.intValue()) {
            BmobUpdateListener bmobUpdateListener = updateListener;
            if (bmobUpdateListener != null) {
                bmobUpdateListener.onUpdateReturned(1, new UpdateResponse(1, "已经是最新版本了，无需更新。"));
                return;
            }
            return;
        }
        Intent intent = new Intent(context, (Class<?>) UpdateDialogActivity.class);
        intent.putExtra("response", updateResponse);
        if (file.exists()) {
            intent.putExtra(BmobDbOpenHelper.FILE, file.getPath());
        }
        intent.putExtra("showCheckBox", z2);
        context.startActivity(intent);
    }

    private static void saveIgnoreVersion(List<String> list) {
        if (list == null || list.size() <= 0) {
            BmobContentProvider.updateIgnoreVersions("");
            return;
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(list.get(i2));
            if (i2 != size - 1) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
        }
        BmobContentProvider.updateIgnoreVersions(sb.toString());
    }

    public static void setDefault() {
        setUpdateOnlyWifi(true);
        setUpdateListener(null);
        setDialogListener(null);
    }

    public static void setDialogListener(BmobDialogButtonListener bmobDialogButtonListener) {
        dialogListener = bmobDialogButtonListener;
    }

    public static void setUpdateCheckConfig(boolean z2) {
        UpdateConfig.setUpdateCheck(z2);
    }

    public static void setUpdateListener(BmobUpdateListener bmobUpdateListener) {
        updateListener = bmobUpdateListener;
    }

    public static void setUpdateOnlyWifi(boolean z2) {
        UpdateConfig.setUpdateOnlyWifi(z2);
    }

    public static void silentUpdate(Context context) {
        if ("3".equals(ManifestUtils.getNetType(context)) || !UpdateConfig.isUpdateOnlyWifi()) {
            UpdateConfig.setUpdateForce(false);
            UpdateConfig.setSilentDownload(true);
            checkVer(context);
        }
    }

    public static void update(Context context) {
        if ("3".equals(ManifestUtils.getNetType(context)) || !UpdateConfig.isUpdateOnlyWifi()) {
            UpdateConfig.setUpdateForce(false);
            UpdateConfig.setSilentDownload(false);
            checkVer(context);
        }
    }

    private static void updateApp(Context context, UpdateResponse updateResponse, File file) {
        if (file == null || !file.exists()) {
            downloadApk(true, context, updateResponse, file);
            return;
        }
        long length = file.length();
        long j2 = updateResponse.target_size;
        if (j2 > 0) {
            if (length >= j2) {
                InstallUtil.startInstall(context, file);
                return;
            } else {
                downloadApk(true, context, updateResponse, file);
                return;
            }
        }
        file.delete();
        BmobUpdateListener bmobUpdateListener = updateListener;
        if (bmobUpdateListener != null) {
            bmobUpdateListener.onUpdateReturned(2, new UpdateResponse(2, ""));
        }
    }
}
