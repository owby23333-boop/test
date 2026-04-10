package cn.bmob.v3.http;

import android.content.Context;
import android.os.Build;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.up.UpConfig;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.helper.RequestHelper;
import cn.bmob.v3.http.bean.Api;
import cn.bmob.v3.http.bean.Collect;
import cn.bmob.v3.http.bean.Init;
import cn.bmob.v3.http.bean.Result;
import cn.bmob.v3.http.bean.Sk;
import cn.bmob.v3.http.interceptor.GzipRequestInterceptor;
import cn.bmob.v3.http.interceptor.HttpLoggingInterceptor;
import cn.bmob.v3.http.interceptor.ResponseInterceptor;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.EncryptUtils;
import cn.bmob.v3.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taobao.accs.common.Constants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobClient<T> {
    private static volatile BmobClient mClient;
    private OkHttpClient client = new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(Bmob.getConnectTimeout(), TimeUnit.SECONDS).readTimeout(UpConfig.READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(UpConfig.WRITE_TIMEOUT, TimeUnit.SECONDS).addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)).addInterceptor(new GzipRequestInterceptor()).addNetworkInterceptor(new ResponseInterceptor()).build();
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static boolean isNewDomain = false;
    private static boolean hasInit = false;
    public static int curCDNVersion = 0;
    private static String CREATE = "create";
    private static String UPDATE = "update";
    private static String FIND = "find";
    private static byte[] lock = new byte[0];
    private static ObservableTransformer schedulersTransformer = createSchedulers();

    private BmobClient() {
    }

    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return schedulersTransformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<JsonElement> createObservable(final String str, final JSONObject jSONObject) {
        return Observable.create(new ObservableOnSubscribe<JsonElement>() { // from class: cn.bmob.v3.http.BmobClient.5
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<JsonElement> observableEmitter) throws Exception {
                if (observableEmitter.isDisposed()) {
                    BLog.e(BmobConstants.TAG, "createObservable:subscriber is cancel");
                    return;
                }
                try {
                    BLog.e(str);
                    Response responseExecute = BmobClient.this.client.newCall(BmobClient.createRequest(str, jSONObject)).execute();
                    int iCode = responseExecute.code();
                    String strString = responseExecute.body().string();
                    if (200 != iCode) {
                        try {
                            observableEmitter.onError(new BmobException(iCode, strString));
                        } catch (Exception unused) {
                        }
                        BLog.e(iCode + "\n" + strString);
                        return;
                    }
                    if (str.equals(BmobURL.getDefault().getUrl("delcdnbatch"))) {
                        observableEmitter.onNext(new JsonParser().parse(strString));
                        observableEmitter.onComplete();
                        return;
                    }
                    Api api = (Api) GsonUtil.toObject(strString, Api.class);
                    Result result = api.getResult();
                    if (result == null) {
                        observableEmitter.onError(new BmobException(9002, strString));
                        return;
                    }
                    int code = result.getCode();
                    if (200 == code) {
                        observableEmitter.onNext(api.getData());
                        return;
                    }
                    boolean zIsDisposed = observableEmitter.isDisposed();
                    try {
                        observableEmitter.onError(new BmobException(code, result.getMessage()));
                    } catch (Exception e2) {
                        System.out.println(e2.toString());
                    }
                    System.out.println(zIsDisposed);
                } catch (Exception unused2) {
                    observableEmitter.onError(new BmobException(ErrorCode.E9015, "请检查网络是否可用！"));
                }
            }
        });
    }

    public static JSONObject createParams(Context context, JSONObject jSONObject, String str) {
        try {
            if (str.equals(BmobURL.getDefault().getSecretUrl())) {
                jSONObject.put(Constants.KEY_APP_KEY, RequestUtils.getAppKey());
                BLog.e(Constants.KEY_APP_KEY + RequestUtils.getAppKey());
            }
            String sessionToken = BmobContentProvider.getSessionToken();
            BLog.e("sessionToken:" + sessionToken);
            jSONObject.put(BmobDbOpenHelper.SESSION_TOKEN, sessionToken);
            jSONObject.put("appSign", RequestUtils.getAppSign(context));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("caller", "Android");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", Build.VERSION.RELEASE);
            jSONObject3.put(Constants.KEY_PACKAGE, context.getPackageName());
            jSONObject3.put("uuid", RequestUtils.getCombinedDeviceID(context));
            jSONObject2.put("ex", jSONObject3);
            jSONObject.put("client", jSONObject2);
            jSONObject.put("v", BmobConstants.VERSION_NAME);
            if (!str.equals(BmobURL.getDefault().getSecretUrl()) && !str.equals(BmobURL.getDefault().getInitUrl())) {
                jSONObject.put("timestamp", RequestUtils.getTimeStamp());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static Request createRequest(String str, JSONObject jSONObject) {
        String strEncrypt;
        String userAgent = RequestHelper.getUserAgent(Bmob.getApplicationContext());
        Context applicationContext = Bmob.getApplicationContext();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectCreateParams = createParams(applicationContext, jSONObject, str);
        StringBuilder sb = new StringBuilder();
        sb.append("params:");
        sb.append(jSONObjectCreateParams == null ? "" : jSONObjectCreateParams.toString());
        BLog.e(sb.toString());
        if (str.equals(BmobURL.getDefault().getSecretUrl())) {
            strEncrypt = EncryptUtils.encryptAgent(userAgent, jSONObjectCreateParams.toString());
        } else {
            String str2 = BmobNative.SECRET_KEY;
            strEncrypt = EncryptUtils.encrypt(str2, str2, jSONObjectCreateParams.toString());
        }
        Request.Builder builderPost = new Request.Builder().header("Content-Type", "text/plain; charset=utf-8").header("Accept-Encoding", "gzip,deflate,sdch").header("User-Agent", userAgent).url(str).post(RequestBody.create(MEDIA_TYPE, strEncrypt));
        if (!str.equals(BmobURL.getDefault().getSecretUrl())) {
            builderPost.addHeader("Accept-Id", RequestUtils.getAcceptId());
        }
        return builderPost.build();
    }

    private static ObservableTransformer createSchedulers() {
        return new ObservableTransformer() { // from class: cn.bmob.v3.http.BmobClient.4
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource apply(Observable observable) {
                return observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private JsonElement doReq(String str, JSONObject jSONObject) {
        Api api;
        Result result;
        try {
            Response responseExecute = this.client.newCall(createRequest(str, jSONObject)).execute();
            int iCode = responseExecute.code();
            String strString = responseExecute.body().string();
            if (200 == iCode && (result = (api = (Api) GsonUtil.toObject(strString, Api.class)).getResult()) != null && 200 == result.getCode()) {
                return api.getData();
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject generateCacheKey(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(BmobDbOpenHelper.SESSION_TOKEN, BmobContentProvider.getSessionToken());
            jSONObject.put("appSign", RequestUtils.getAppSign(context));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("caller", "Android");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", Build.VERSION.RELEASE);
            jSONObject3.put(Constants.KEY_PACKAGE, context.getPackageName());
            jSONObject3.put("uuid", RequestUtils.getCombinedDeviceID(context));
            jSONObject2.put("ex", jSONObject3);
            jSONObject.put("client", jSONObject2);
            jSONObject.put("v", BmobConstants.VERSION_NAME);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static BmobClient getInstance() {
        if (mClient == null) {
            synchronized (lock) {
                if (mClient == null) {
                    mClient = new BmobClient();
                }
            }
        }
        return mClient;
    }

    private synchronized Observable<Sk> getSk() {
        return createObservable(Sk.class, BmobURL.getDefault().getSecretUrl(), null);
    }

    private Observable<Long> getTime() {
        return BmobFactory.getInstance().createTimeRequest(null).getObservable();
    }

    public static boolean hasInit() {
        return hasInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Observable<Init> init() {
        return createObservable(Init.class, BmobURL.getDefault().getInitUrl(), null);
    }

    private static void initCollect(Context context) {
        JSONObject jSONObject = new JSONObject();
        String collectUrl = BmobURL.getDefault().getCollectUrl();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("c", "collect");
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        getInstance().request(collectUrl, jSONObject).subscribe(new Observer<JsonElement>() { // from class: cn.bmob.v3.http.BmobClient.3
            @Override // io.reactivex.Observer
            public void onComplete() {
                BLog.i("onComplete()");
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                BLog.e(th.toString());
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(JsonElement jsonElement) {
                BLog.i(jsonElement.toString());
                Collect collect = (Collect) new Gson().fromJson((JsonElement) jsonElement.getAsJsonObject(), (Class) Collect.class);
                if (collect.getIsOpen() == 1) {
                    BLog.e("collect", collect.getIsOpen() + "-" + collect.getId());
                }
            }
        });
    }

    public static boolean isIsNewDomain() {
        return isNewDomain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInit(Init init) {
        BmobContentProvider.updateInit(init);
        BmobURL.getDefault().setUrls(init);
        curCDNVersion = init.getUpyunVer();
        BmobContentProvider.updateUpyun("", curCDNVersion);
        BmobNative.saveInterval(String.valueOf((int) ((System.currentTimeMillis() / 1000) - init.getTimestamp())));
    }

    public static void setHasInit(boolean z2) {
        hasInit = z2;
    }

    public static void setIsNewDomain(boolean z2) {
        isNewDomain = z2;
    }

    private BmobObject sync(String str, JSONObject jSONObject, String str2) {
        createRequest(str, jSONObject);
        JsonElement jsonElementDoReq = doReq(str, jSONObject);
        BmobObject bmobObject = new BmobObject();
        if ("create".equals(str2)) {
            bmobObject.setObjectId(JsonUtil.getString(jsonElementDoReq, "objectId"));
        } else if ("update".equals(str2)) {
            bmobObject.setUpdatedAt(JsonUtil.getString(jsonElementDoReq, "updatedAt"));
        }
        return bmobObject;
    }

    private List<T> syncFind(Class<T> cls, String str, JSONObject jSONObject) {
        BLog.e(str);
        String string = doReq(str, jSONObject).getAsJsonObject().getAsJsonArray("results").toString();
        BLog.e(string);
        return string2List(cls, string);
    }

    public List<T> findObjectsSync(Class<T> cls, JSONObject jSONObject, BmobQuery.CachePolicy cachePolicy) {
        return syncFind(cls, BmobURL.getDefault().getUrl("find"), jSONObject);
    }

    public Observable<JsonElement> request(final String str, final JSONObject jSONObject) {
        BLog.e(str);
        synchronized (lock) {
            if (BmobNative.hasKey() && hasInit) {
                return createObservable(str, jSONObject).compose(applySchedulers());
            }
            return getSk().concatMap(new Function<Sk, Observable<Init>>() { // from class: cn.bmob.v3.http.BmobClient.2
                @Override // io.reactivex.functions.Function
                public Observable<Init> apply(Sk sk) {
                    BmobNative.SECRET_KEY = sk.getSecretKey();
                    BmobNative.saveKey(sk.getSecretKey());
                    return BmobClient.this.init();
                }
            }).concatMap(new Function<Init, Observable<JsonElement>>() { // from class: cn.bmob.v3.http.BmobClient.1
                @Override // io.reactivex.functions.Function
                public Observable<JsonElement> apply(Init init) {
                    boolean unused = BmobClient.hasInit = true;
                    BmobClient.this.saveInit(init);
                    return BmobClient.this.createObservable(str, jSONObject);
                }
            }).compose(applySchedulers());
        }
    }

    public String saveSync(JSONObject jSONObject) {
        return sync(BmobURL.getDefault().getUrl(CREATE), jSONObject, CREATE).getObjectId();
    }

    public List<T> string2List(Class<T> cls, String str) {
        Gson gsonCreate = new GsonBuilder().create();
        ArrayList arrayList = new ArrayList();
        List list = (List) gsonCreate.fromJson(str, (Class) List.class);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(gsonCreate.fromJson(gsonCreate.toJson(list.get(i2)), (Class) cls));
            }
        }
        return arrayList;
    }

    public String updateSync(JSONObject jSONObject) {
        return sync(BmobURL.getDefault().getUrl(UPDATE), jSONObject, UPDATE).getUpdatedAt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Observable<T> createObservable(final Class<T> cls, final String str, final JSONObject jSONObject) {
        return Observable.create(new ObservableOnSubscribe<T>() { // from class: cn.bmob.v3.http.BmobClient.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                if (observableEmitter.isDisposed()) {
                    BLog.e(BmobConstants.TAG, "createObservable:subcriber is cancel");
                    return;
                }
                try {
                    Response responseExecute = BmobClient.this.client.newCall(BmobClient.createRequest(str, jSONObject)).execute();
                    int iCode = responseExecute.code();
                    String strString = responseExecute.body().string();
                    if (200 == iCode) {
                        Api api = (Api) GsonUtil.toObject(strString, Api.class);
                        if (api == null) {
                            observableEmitter.onError(new BmobException(9002, "解析Api出错，请不要混淆bmobsdk！或者是网络被劫持，请切换网络重新尝试！" + strString));
                            BLog.e("解析Api出错,请不要混淆bmobsdk.");
                        } else {
                            Result result = api.getResult();
                            if (result != null) {
                                int code = result.getCode();
                                if (200 == code) {
                                    observableEmitter.onNext(new Gson().fromJson(api.getData().toString(), (Class) cls));
                                } else if (BmobURL.getDefault().getBaseUrl().equals(BmobURL.getStandbyBaseUrl())) {
                                    observableEmitter.onError(new BmobException(code, result.getMessage()));
                                } else {
                                    Bmob.resetDomain(BmobURL.getStandbyBaseUrl());
                                    BmobClient.this.createObservable(cls, str, jSONObject);
                                }
                            } else {
                                observableEmitter.onError(new BmobException(9002, "解析Api并获取结果出错,请不要混淆bmobsdk."));
                                BLog.e("解析Api并获取结果出错,请不要混淆bmobsdk.");
                            }
                        }
                    } else if (BmobURL.getDefault().getBaseUrl().equals(BmobURL.getStandbyBaseUrl())) {
                        observableEmitter.onError(new BmobException(iCode, strString));
                    } else {
                        Bmob.resetDomain(BmobURL.getStandbyBaseUrl());
                        BmobClient.this.createObservable(cls, str, jSONObject);
                    }
                } catch (Exception unused) {
                    observableEmitter.onError(new BmobException(ErrorCode.E9015, "请检查网络是否可用！"));
                }
            }
        });
    }
}
