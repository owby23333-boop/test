package cn.bmob.v3.http;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.datatype.BmobTableSchema;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.bean.R1;
import cn.bmob.v3.http.bean.Upyun;
import cn.bmob.v3.http.rx.RetryWithDelay;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.DeleteBatchListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.Utils;
import com.google.gson.JsonElement;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobFactory {
    private static byte[] lock = new byte[0];
    private static volatile BmobFactory mClient;

    public static class CheckInfo {
        boolean isOk;
        String objName;
        Object object;

        public CheckInfo() {
        }

        public void work() {
            String strReplace = "{0} is must not be null".replace("{0}", this.objName);
            if (this.object != null) {
                this.isOk = true;
            } else {
                this.isOk = false;
                throw new IllegalArgumentException(strReplace);
            }
        }

        public CheckInfo(Object obj, String str) {
            this.object = obj;
            this.objName = str;
        }
    }

    private BmobFactory() {
    }

    public static CheckInfo checkNull(String str) {
        return new CheckInfo(Boolean.valueOf((str == null || "".equals(str)) ? false : true), "objectId is can not be null");
    }

    private RxBmob createSaveCDNRequest(String str, String str2, long j2, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str);
            jSONObject2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, str2);
            jSONObject2.put("filesize", j2);
            jSONObject2.put("cdn", "upyun");
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().direct(BmobURL.getDefault().getUrl("savecdnupload"), jSONObject).mapSaveCDN().retryWhen(new RetryWithDelay(2, 1000)).subscribe(updateListener).build();
    }

    public static BmobFactory getInstance() {
        if (mClient == null) {
            synchronized (lock) {
                if (mClient == null) {
                    mClient = new BmobFactory();
                }
            }
        }
        return mClient;
    }

    public static List<R1> rByBatch(JSONArray jSONArray) {
        return Arrays.asList(new R1(Boolean.valueOf(jSONArray.length() == 0), new BmobException(ErrorCode.E9005, "A batch operation can not be less than 0")), new R1(Boolean.valueOf(jSONArray.length() > 50), new BmobException(ErrorCode.E9005, "A batch operation can not be more than 50")));
    }

    public static List<R1> rByContext(String str, String str2) {
        return Arrays.asList(rContext(), rEmpty(str, str2));
    }

    public static List<R1> rByDeleteCDNBatch(String[] strArr) {
        return Arrays.asList(rNull(strArr, "urls must not be null"), new R1(Boolean.valueOf(strArr.length == 0), new BmobException(ErrorCode.E9005, "urls length can not be less than 0")));
    }

    public static List<R1> rByEmpty(String str, String str2, String str3, String str4) {
        return Arrays.asList(rEmpty(str, str2), rEmpty(str3, str4));
    }

    public static List<R1> rByNull(Object obj, String str) {
        return Arrays.asList(rContext(), rNull(obj, str));
    }

    public static List<R1> rBySave(String str) {
        return Arrays.asList(new R1(Boolean.valueOf(str.equals("_User")), new BmobException(ErrorCode.E9011, ErrorCode.E9011S)), new R1(Boolean.valueOf(!Utils.checkTableName(str, 1, 49) && !str.equals("_Role") && str.equals("_Installation") && str.equals("_Article")), new BmobException(ErrorCode.E9013, ErrorCode.E9013S)));
    }

    public static R1 rContext() {
        return new R1(Boolean.valueOf(Bmob.getApplicationContext() == null), new BmobException(ErrorCode.E9012, ErrorCode.E9012S));
    }

    public static R1 rEmpty(String str, String str2) {
        return new R1(Boolean.valueOf(TextUtils.isEmpty(str)), new BmobException(ErrorCode.E9018, str2));
    }

    public static void rEmptyListener(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
        }
    }

    public static R1 rNull(Object obj, int i2, String str) {
        return new R1(Boolean.valueOf(obj == null), new BmobException(i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Disposable saveCDNDisposable(String str, String str2, long j2, UpdateListener updateListener) {
        return createSaveCDNRequest(str, str2, j2, updateListener).getDisposable();
    }

    public RxBmob createAllTableSchemaRequest(JSONObject jSONObject, QueryListListener<BmobTableSchema> queryListListener) {
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(BmobURL.getDefault().getUrl("schemas"), jSONObject).map(new Function<JsonElement, List<BmobTableSchema>>() { // from class: cn.bmob.v3.http.BmobFactory.3
            @Override // io.reactivex.functions.Function
            public List<BmobTableSchema> apply(JsonElement jsonElement) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(jsonElement.getAsJsonObject().getAsJsonArray("results").toString());
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            arrayList.add(new BmobTableSchema(jSONObject2.getString("className"), Utils.parse2Map(jSONObject2.getJSONObject("fields"))));
                        }
                    }
                    return arrayList;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).subscribe(queryListListener).build();
    }

    public RxBmob createBQLStatisticRequest(String str, JSONObject jSONObject, BmobCallback bmobCallback) {
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(str, jSONObject).mapStatistics().subscribe(bmobCallback).build();
    }

    public Observable<Upyun> createCDNObservable() {
        return createCDNRequest().getObservable();
    }

    public RxBmob createCDNRequest() {
        return new RxBmob.Builder().direct(BmobURL.getDefault().getUrl("cdn"), null).mapCDN().doOnNext(new Consumer<Upyun>() { // from class: cn.bmob.v3.http.BmobFactory.5
            @Override // io.reactivex.functions.Consumer
            public void accept(final Upyun upyun) {
                Schedulers.io().createWorker().schedule(new Runnable() { // from class: cn.bmob.v3.http.BmobFactory.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BmobContentProvider.updateUpyun(GsonUtil.toJson(upyun), BmobClient.curCDNVersion);
                    }
                });
            }
        }).build();
    }

    public RxBmob createCheckRequest(List<R1> list, String str, JSONObject jSONObject, BmobCallback bmobCallback) {
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).mapVoid().subscribe(bmobCallback).build();
    }

    public RxBmob createCountRequest(List<R1> list, String str, JSONObject jSONObject, BmobCallback bmobCallback) {
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).mapCount().subscribe(bmobCallback).build();
    }

    public RxBmob createDeleteBatchCDNRequest(String[] strArr, DeleteBatchListener deleteBatchListener) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str : strArr) {
                jSONArray.put(Utils.convertUrl(str));
            }
            jSONObject2.put("upyun", jSONArray);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(rByDeleteCDNBatch(strArr)).nextTest(BmobURL.getDefault().getUrl("delcdnbatch"), jSONObject).mapCDNDeleteBatch().subscribe(deleteBatchListener).build();
    }

    public RxBmob createDeleteCDNRequest(List<R1> list, String str, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, Utils.convertUrl(str));
            jSONObject2.put("cdn", "upyun");
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(list).nextTest(BmobURL.getDefault().getUrl("delcdnupload"), jSONObject).mapDeleteCDN().subscribe(updateListener).build();
    }

    public <T> RxBmob createLoginRequest(final Class<T> cls, List<R1> list, String str, JSONObject jSONObject, LogInListener<T> logInListener) {
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).doOnNext(new Consumer<JsonElement>() { // from class: cn.bmob.v3.http.BmobFactory.1
            @Override // io.reactivex.functions.Consumer
            public void accept(JsonElement jsonElement) {
                BLog.e(jsonElement.toString());
                BmobContentProvider.updateUser(jsonElement.toString(), cls);
                JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
                if (jsonElement2 != null) {
                    BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
                }
            }
        }).mapT(cls).subscribe(logInListener).build();
    }

    public RxBmob createStatisticsRequest(List<R1> list, String str, JSONObject jSONObject, BmobCallback bmobCallback) {
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).mapStatistics().subscribe(bmobCallback).build();
    }

    public RxBmob createTableSchemaRequest(JSONObject jSONObject, QueryListener<BmobTableSchema> queryListener) {
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(BmobURL.getDefault().getUrl("schemas"), jSONObject).map(new Function<JsonElement, BmobTableSchema>() { // from class: cn.bmob.v3.http.BmobFactory.4
            @Override // io.reactivex.functions.Function
            public BmobTableSchema apply(JsonElement jsonElement) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jsonElement.getAsJsonObject().toString());
                    return new BmobTableSchema(jSONObject2.getString("className"), Utils.parse2Map(jSONObject2.getJSONObject("fields")));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).subscribe(queryListener).build();
    }

    public RxBmob createTimeRequest(QueryListener<Long> queryListener) {
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(BmobURL.getDefault().getUrl("timestamp"), new JSONObject()).map(new Function<JsonElement, Long>() { // from class: cn.bmob.v3.http.BmobFactory.2
            @Override // io.reactivex.functions.Function
            public Long apply(JsonElement jsonElement) {
                return Long.valueOf(jsonElement.getAsJsonObject().get(ExifInterface.LATITUDE_SOUTH).getAsLong());
            }
        }).subscribe(queryListener).build();
    }

    public Observable saveCDN(final String str, final String str2, final long j2) {
        return new RxBmob.Builder().create(new ObservableOnSubscribe<BmobException>() { // from class: cn.bmob.v3.http.BmobFactory.6
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<BmobException> observableEmitter) {
                BmobFactory.this.saveCDNDisposable(str, str2, j2, new UpdateListener() { // from class: cn.bmob.v3.http.BmobFactory.6.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // cn.bmob.v3.listener.UpdateListener, cn.bmob.v3.listener.BmobCallback1
                    public void done(BmobException bmobException) {
                        if (bmobException == null) {
                            BLog.i("saveCDN success");
                            observableEmitter.onNext(new BmobException());
                        } else {
                            BLog.e(bmobException.getMessage());
                            observableEmitter.onNext(bmobException);
                        }
                        observableEmitter.onComplete();
                    }
                });
            }
        }).build().getObservable();
    }

    public static List<R1> rByNull(Object obj, String str, Object obj2, String str2) {
        return Arrays.asList(rNull(obj, str), rNull(obj2, str2));
    }

    public static R1 rEmpty(String str, int i2, String str2) {
        return new R1(Boolean.valueOf(TextUtils.isEmpty(str)), new BmobException(i2, str2));
    }

    public static R1 rNull(Object obj, String str) {
        boolean z2 = true;
        if (!(obj instanceof String) ? obj != null : !TextUtils.isEmpty((String) obj)) {
            z2 = false;
        }
        return new R1(Boolean.valueOf(z2), new BmobException(ErrorCode.E9018, str));
    }

    public static List<R1> rByNull(Object obj, String str, Object obj2, String str2, Object obj3, String str3) {
        return Arrays.asList(rNull(obj, str), rNull(obj2, str2), rNull(obj3, str3));
    }
}
