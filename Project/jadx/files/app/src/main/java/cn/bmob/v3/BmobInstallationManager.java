package cn.bmob.v3;

import android.annotation.SuppressLint;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.RequestUtils;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class BmobInstallationManager {
    private static BmobInstallationManager INSTANCE;

    public static String getInstallationId() {
        return RequestUtils.getInstallationId(Bmob.getApplicationContext());
    }

    public static BmobInstallationManager getInstance() {
        if (INSTANCE == null) {
            synchronized (BmobInstallationManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BmobInstallationManager();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInstallation(BmobInstallation bmobInstallation, InstallationListener installationListener) {
        BmobContentProvider.updateInstallation(GsonUtil.toJson(bmobInstallation));
        installationListener.done(bmobInstallation, (BmobException) null);
    }

    public BmobInstallation getCurrentInstallation() {
        return (BmobInstallation) GsonUtil.toObject(BmobContentProvider.getInstallation(), BmobInstallation.class);
    }

    @SuppressLint({"CheckResult"})
    public void initialize(final InstallationListener<BmobInstallation> installationListener) {
        BmobQuery bmobQuery = new BmobQuery();
        bmobQuery.addWhereEqualTo("installationId", RequestUtils.getInstallationId(Bmob.getApplicationContext()));
        bmobQuery.findObjectsObservable(BmobInstallation.class).subscribe(new Consumer<List<BmobInstallation>>() { // from class: cn.bmob.v3.BmobInstallationManager.1
            @Override // io.reactivex.functions.Consumer
            public void accept(List<BmobInstallation> list) {
                if (list == null || list.size() <= 0) {
                    BmobInstallationManager.this.saveInstallation(installationListener);
                } else {
                    BmobInstallationManager.this.saveInstallation(list.get(0), installationListener);
                }
            }
        }, new Consumer<Throwable>() { // from class: cn.bmob.v3.BmobInstallationManager.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                BmobInstallationManager.this.saveInstallation(installationListener);
            }
        });
    }

    public void subscribe(String str, InstallationListener<BmobInstallation> installationListener) {
        subscribe(Arrays.asList(str), installationListener);
    }

    public void unsubscribe(String str, InstallationListener<BmobInstallation> installationListener) {
        unsubscribe(Arrays.asList(str), installationListener);
    }

    @SuppressLint({"CheckResult"})
    public void update(final BmobInstallation bmobInstallation, final InstallationListener<BmobInstallation> installationListener) {
        bmobInstallation.updateObservable().subscribe(new Consumer<BmobException>() { // from class: cn.bmob.v3.BmobInstallationManager.5
            @Override // io.reactivex.functions.Consumer
            public void accept(BmobException bmobException) {
                BmobContentProvider.updateInstallation(GsonUtil.toJson(bmobInstallation));
                installationListener.done(bmobInstallation, (BmobException) null);
            }
        }, new Consumer<Throwable>() { // from class: cn.bmob.v3.BmobInstallationManager.6
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                installationListener.done((Object) null, new BmobException(ErrorCode.E9015, "update failed:" + th.getMessage()));
            }
        });
    }

    public void subscribe(List<String> list, InstallationListener<BmobInstallation> installationListener) {
        BmobInstallation currentInstallation = getCurrentInstallation();
        currentInstallation.addAllUnique("channels", list);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(currentInstallation.getChannels());
        arrayList.addAll(list);
        currentInstallation.setChannels(new ArrayList(new HashSet(arrayList)));
        update(currentInstallation, installationListener);
    }

    public void unsubscribe(List<String> list, InstallationListener<BmobInstallation> installationListener) {
        BmobInstallation currentInstallation = getCurrentInstallation();
        currentInstallation.removeAll("channels", list);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(currentInstallation.getChannels());
        arrayList.removeAll(list);
        currentInstallation.setChannels(new ArrayList(new HashSet(arrayList)));
        update(currentInstallation, installationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void saveInstallation(final InstallationListener<BmobInstallation> installationListener) {
        final BmobInstallation bmobInstallation = new BmobInstallation();
        bmobInstallation.setInstallationId(RequestUtils.getInstallationId(Bmob.getApplicationContext()));
        bmobInstallation.setTimeZone(TimeZone.getDefault().getID());
        bmobInstallation.saveObservable().subscribe(new Consumer<String>() { // from class: cn.bmob.v3.BmobInstallationManager.3
            @Override // io.reactivex.functions.Consumer
            public void accept(String str) {
                BLog.i(str);
                BmobContentProvider.updateInstallation(GsonUtil.toJson(bmobInstallation));
                installationListener.done(bmobInstallation, (BmobException) null);
            }
        }, new Consumer<Throwable>() { // from class: cn.bmob.v3.BmobInstallationManager.4
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                BLog.e(th.getMessage());
                installationListener.done((Object) null, new BmobException(ErrorCode.E9015, "save installation failed:" + th.getMessage()));
            }
        });
    }
}
