package cn.bmob.v3;

import android.content.Context;
import android.text.TextUtils;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobTableSchema;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UploadBatchListener;
import com.umeng.message.common.UPushNotificationChannel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Bmob {
    private static byte[] lock = new byte[0];

    private static void checkContext() {
        if (BmobWrapper.getInstance().getApplicationContext() == null) {
            throw new RuntimeException("applicationContext is null. You must call initialize  before using the Bmob library.");
        }
    }

    public static Disposable getAllTableSchema(QueryListListener<BmobTableSchema> queryListListener) {
        return getAllTableSchemaRequest(queryListListener).getDisposable();
    }

    public static Observable<List<BmobTableSchema>> getAllTableSchemaObservable() {
        return getAllTableSchemaRequest(null).getObservable();
    }

    private static RxBmob getAllTableSchemaRequest(QueryListListener<BmobTableSchema> queryListListener) {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e2 = e3;
        }
        try {
            jSONObject.put("data", new JSONObject());
            jSONObject.put("c", "");
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createAllTableSchemaRequest(jSONObject, queryListListener);
    }

    public static Context getApplicationContext() {
        checkContext();
        return BmobWrapper.getInstance().getApplicationContext();
    }

    public static File getCacheDir() {
        return BmobWrapper.getInstance().getCacheDir();
    }

    public static long getConnectTimeout() {
        checkContext();
        return BmobWrapper.getInstance().getConnectTimeout();
    }

    public static int getFileBlockSize() {
        checkContext();
        return BmobWrapper.getInstance().getUploadBlockSize();
    }

    public static long getFileExpiration() {
        checkContext();
        return BmobWrapper.getInstance().getFileExpiration();
    }

    public static File getFilesDir() {
        return BmobWrapper.getInstance().getFilesDir();
    }

    public static Disposable getServerTime(QueryListener<Long> queryListener) {
        return BmobFactory.getInstance().createTimeRequest(queryListener).getDisposable();
    }

    public static Observable<Long> getServerTimeObservable() {
        return BmobFactory.getInstance().createTimeRequest(null).getObservable();
    }

    public static Disposable getTableSchema(String str, QueryListener<BmobTableSchema> queryListener) {
        return getTableSchemaRequest(str, queryListener).getDisposable();
    }

    public static Observable<BmobTableSchema> getTableSchemaObservable(String str) {
        return getTableSchemaRequest(str, null).getObservable();
    }

    private static RxBmob getTableSchemaRequest(String str, QueryListener<BmobTableSchema> queryListener) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            e = e2;
            jSONObject = jSONObject2;
        }
        try {
            jSONObject.put("data", new JSONObject());
            jSONObject.put("c", str);
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
        }
        return BmobFactory.getInstance().createTableSchemaRequest(jSONObject, queryListener);
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME, false);
    }

    public static void resetDomain(String str) {
        BmobClient.setIsNewDomain(true);
        BmobClient.setHasInit(false);
        BmobURL.getDefault().setDefaultBaseUrl(str);
    }

    @Deprecated
    public static void uploadBatch(String[] strArr, UploadBatchListener uploadBatchListener) {
        BmobFile.uploadBatch(strArr, uploadBatchListener);
    }

    public static File getCacheDir(String str) {
        File file;
        synchronized (lock) {
            file = new File(getCacheDir(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    public static File getFilesDir(String str) {
        File file;
        synchronized (lock) {
            file = new File(getFilesDir(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2) {
        initialize(context, str, str2, true);
    }

    private static void initialize(Context context, String str, String str2, boolean z2) {
        BmobWrapper.initialize(new BmobConfig.Builder(context).setApplicationId(str).setUploadBlockSize(BmobConstants.BLOCK_SIZE).setFileExpiration(BmobConstants.EXPIRATION).setConnectTimeout(BmobConstants.CONNECT_TIMEOUT).build());
    }

    public static void initialize(BmobConfig bmobConfig) {
        if (!TextUtils.isEmpty(bmobConfig.applicationId)) {
            BmobWrapper.initialize(bmobConfig);
            return;
        }
        throw new RuntimeException("ApplicationId is null. You must call setApplicationId(Your AppId) method in BmobConfig.Builder(context).");
    }
}
