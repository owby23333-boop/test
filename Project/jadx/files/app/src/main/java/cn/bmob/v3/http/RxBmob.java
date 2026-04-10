package cn.bmob.v3.http;

import android.text.TextUtils;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.datatype.BmobReturn;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.bean.Api;
import cn.bmob.v3.http.bean.CDN;
import cn.bmob.v3.http.bean.R1;
import cn.bmob.v3.http.bean.Result;
import cn.bmob.v3.http.bean.Upyun;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.BmobCallback1;
import cn.bmob.v3.listener.BmobCallback2;
import cn.bmob.v3.listener.DeleteBatchListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.UploadFileListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.ManifestUtils;
import com.anythink.expressad.foundation.d.c;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RxBmob {
    final Disposable mDisposable;
    final Observable observable;

    public static final class Builder {
        Observable observable = Observable.empty();
        Disposable mDisposable = this.observable.subscribe();

        public RxBmob build() {
            return new RxBmob(this);
        }

        public Builder check(boolean z2, final List<R1> list) {
            if (list == null) {
                throw new IllegalArgumentException("R1 list is null ");
            }
            Observable observableCreate = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.1
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) {
                    boolean z3;
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        R1 r1 = (R1) it.next();
                        if (r1.getR().booleanValue()) {
                            observableEmitter.onError(r1.getE());
                            z3 = true;
                            break;
                        }
                    }
                    if (z3) {
                        return;
                    }
                    observableEmitter.onNext("");
                }
            });
            Observable observableCreate2 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.2
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    if (Bmob.getApplicationContext() == null) {
                        observableEmitter.onError(new BmobException(ErrorCode.E9012, ErrorCode.E9012S));
                    } else {
                        observableEmitter.onNext("");
                    }
                }
            });
            Observable observableCreate3 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.3
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    if (TextUtils.isEmpty(RequestUtils.getAppKey())) {
                        observableEmitter.onError(new BmobException(9001, ErrorCode.E9001S));
                    } else {
                        observableEmitter.onNext("");
                    }
                }
            });
            Observable observableCreate4 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.4
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) {
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                    if (ManifestUtils.detectNetWork(Bmob.getApplicationContext())) {
                        observableEmitter.onNext("");
                    } else {
                        observableEmitter.onError(new BmobException(ErrorCode.E9016, ErrorCode.E9016S));
                    }
                }
            });
            if (z2) {
                this.observable = Observable.combineLatest(observableCreate2, observableCreate3, observableCreate4, observableCreate, new Function4<String, String, String, String, Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.5
                    @Override // io.reactivex.functions.Function4
                    public Boolean apply(String str, String str2, String str3, String str4) {
                        return Boolean.valueOf(TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4));
                    }
                });
            } else {
                this.observable = Observable.combineLatest(observableCreate2, observableCreate3, observableCreate, new Function3<String, String, String, Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.6
                    @Override // io.reactivex.functions.Function3
                    public Boolean apply(String str, String str2, String str3) {
                        return Boolean.valueOf(TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3));
                    }
                });
            }
            this.mDisposable = this.observable.subscribe(new Consumer<Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.7
                @Override // io.reactivex.functions.Consumer
                public void accept(Boolean bool) {
                    BLog.e("check result:" + bool);
                }
            }, new Consumer<Throwable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.8
                @Override // io.reactivex.functions.Consumer
                public void accept(Throwable th) {
                    BLog.e(th.getMessage());
                }
            }, new Action() { // from class: cn.bmob.v3.http.RxBmob.Builder.9
                @Override // io.reactivex.functions.Action
                public void run() {
                    BLog.e(c.bX);
                }
            }, new Consumer<Disposable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.10
                @Override // io.reactivex.functions.Consumer
                public void accept(Disposable disposable) {
                    BLog.e("Disposable");
                }
            });
            return this;
        }

        public Builder checkTest(boolean z2, final List<R1> list, final BmobCallback bmobCallback) {
            if (list == null) {
                throw new IllegalArgumentException("R1 list is null ");
            }
            Observable observableCreate = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.11
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) {
                    boolean z3;
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        R1 r1 = (R1) it.next();
                        if (r1.getR().booleanValue()) {
                            observableEmitter.onError(r1.getE());
                            z3 = true;
                            break;
                        }
                    }
                    if (z3) {
                        return;
                    }
                    observableEmitter.onNext("");
                }
            });
            Observable observableCreate2 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.12
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    if (Bmob.getApplicationContext() == null) {
                        observableEmitter.onError(new BmobException(ErrorCode.E9012, ErrorCode.E9012S));
                    } else {
                        observableEmitter.onNext("");
                    }
                }
            });
            Observable observableCreate3 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.13
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    if (TextUtils.isEmpty(RequestUtils.getAppKey())) {
                        observableEmitter.onError(new BmobException(9001, ErrorCode.E9001S));
                    } else {
                        observableEmitter.onNext("");
                    }
                }
            });
            Observable observableCreate4 = Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.14
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) {
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                    if (ManifestUtils.detectNetWork(Bmob.getApplicationContext())) {
                        observableEmitter.onNext("");
                    } else {
                        observableEmitter.onError(new BmobException(ErrorCode.E9016, ErrorCode.E9016S));
                    }
                }
            });
            if (z2) {
                this.observable = Observable.combineLatest(observableCreate2, observableCreate3, observableCreate4, observableCreate, new Function4<String, String, String, String, Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.15
                    @Override // io.reactivex.functions.Function4
                    public Boolean apply(String str, String str2, String str3, String str4) {
                        return Boolean.valueOf(TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4));
                    }
                });
            } else {
                this.observable = Observable.combineLatest(observableCreate2, observableCreate3, observableCreate, new Function3<String, String, String, Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.16
                    @Override // io.reactivex.functions.Function3
                    public Boolean apply(String str, String str2, String str3) {
                        return Boolean.valueOf(TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3));
                    }
                });
            }
            this.mDisposable = this.observable.subscribe(new Consumer<Boolean>() { // from class: cn.bmob.v3.http.RxBmob.Builder.17
                @Override // io.reactivex.functions.Consumer
                public void accept(Boolean bool) {
                    BLog.e("" + bool);
                }
            }, new Consumer<Throwable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.18
                @Override // io.reactivex.functions.Consumer
                public void accept(Throwable th) {
                    BmobCallback bmobCallback2 = bmobCallback;
                    if (bmobCallback2 instanceof BmobCallback2) {
                        ((BmobCallback2) bmobCallback2).done(null, th);
                    } else if (bmobCallback2 instanceof BmobCallback1) {
                        ((BmobCallback1) bmobCallback2).done(th);
                    } else if (bmobCallback2 instanceof UploadFileListener) {
                        ((UploadFileListener) bmobCallback2).done(new BmobException(ErrorCode.E9015, th));
                    }
                }
            }, new Action() { // from class: cn.bmob.v3.http.RxBmob.Builder.19
                @Override // io.reactivex.functions.Action
                public void run() {
                    BLog.e(c.bX);
                }
            }, new Consumer<Disposable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.20
                @Override // io.reactivex.functions.Consumer
                public void accept(Disposable disposable) {
                    BLog.e("Disposable");
                }
            });
            return this;
        }

        public Builder create(ObservableOnSubscribe observableOnSubscribe) {
            this.observable = Observable.create(observableOnSubscribe);
            return this;
        }

        public Builder direct(String str, JSONObject jSONObject) {
            this.observable = BmobClient.getInstance().request(str, jSONObject);
            return this;
        }

        public <T> Builder doOnNext(Consumer<T> consumer) {
            this.observable = this.observable.doOnNext(consumer);
            return this;
        }

        public <T, R> Builder map(Function<T, R> function) {
            this.observable = this.observable.map(function);
            return this;
        }

        public Builder mapBatch() {
            this.observable = this.observable.map(new Function<JsonElement, List<BatchResult>>() { // from class: cn.bmob.v3.http.RxBmob.Builder.33
                @Override // io.reactivex.functions.Function
                public List<BatchResult> apply(JsonElement jsonElement) throws Exception {
                    ArrayList arrayList = new ArrayList();
                    try {
                        arrayList.clear();
                        JSONArray jSONArray = new JSONArray(jsonElement.toString());
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            BatchResult batchResult = new BatchResult();
                            if (jSONObject.has("success")) {
                                batchResult.setSuccess(true);
                                JSONObject jSONObject2 = jSONObject.getJSONObject("success");
                                if (jSONObject2.has("createdAt")) {
                                    batchResult.setCreatedAt(jSONObject2.getString("createdAt"));
                                }
                                if (jSONObject2.has("objectId")) {
                                    batchResult.setObjectId(jSONObject2.getString("objectId"));
                                }
                                if (jSONObject2.has("updatedAt")) {
                                    batchResult.setUpdatedAt(jSONObject2.getString("updatedAt"));
                                }
                            } else {
                                boolean zHas = jSONObject.has("error");
                                int i3 = ErrorCode.E9015;
                                if (zHas) {
                                    batchResult.setSuccess(false);
                                    JSONObject jSONObject3 = jSONObject.getJSONObject("error");
                                    if (jSONObject3.has("code")) {
                                        i3 = jSONObject3.getInt("code");
                                    }
                                    batchResult.setError(new BmobException(i3, jSONObject3.has("error") ? jSONObject3.getString("error") : "批量操作出错"));
                                } else {
                                    batchResult.setSuccess(false);
                                    batchResult.setError(new BmobException(ErrorCode.E9015, "服务端返回异常"));
                                }
                            }
                            arrayList.add(batchResult);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    return arrayList;
                }
            });
            return this;
        }

        public Builder mapCDN() {
            this.observable = this.observable.map(new Function<JsonElement, Upyun>() { // from class: cn.bmob.v3.http.RxBmob.Builder.24
                @Override // io.reactivex.functions.Function
                public Upyun apply(JsonElement jsonElement) throws Exception {
                    return CDN.parse(jsonElement.getAsJsonObject().get("cdn").getAsJsonObject().toString()).getUpyun();
                }
            });
            return this;
        }

        public Builder mapCDNDeleteBatch() {
            this.observable = this.observable.map(new Function<JsonElement, BmobReturn<String[]>>() { // from class: cn.bmob.v3.http.RxBmob.Builder.27
                @Override // io.reactivex.functions.Function
                public BmobReturn<String[]> apply(JsonElement jsonElement) throws Exception {
                    Api api = (Api) GsonUtil.toObject(jsonElement.toString(), Api.class);
                    Result result = api.getResult();
                    if (result == null) {
                        return new BmobReturn<>(null, new BmobException(9002, jsonElement.toString()));
                    }
                    int code = result.getCode();
                    String message = result.getMessage();
                    if (code == 200) {
                        return new BmobReturn<>(null, null);
                    }
                    JsonArray asJsonArray = api.getData().getAsJsonObject().get("upyun").getAsJsonArray();
                    if (asJsonArray == null || asJsonArray.size() <= 0) {
                        return new BmobReturn<>(null, new BmobException(code, message));
                    }
                    int size = asJsonArray.size();
                    String[] strArr = new String[asJsonArray.size()];
                    for (int i2 = 0; i2 < size; i2++) {
                        strArr[i2] = asJsonArray.get(i2).getAsString();
                    }
                    return new BmobReturn<>(strArr, new BmobException(code, message));
                }
            });
            return this;
        }

        public Builder mapCount() {
            this.observable = this.observable.map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.http.RxBmob.Builder.29
                @Override // io.reactivex.functions.Function
                public Object apply(JsonElement jsonElement) throws Exception {
                    return Integer.valueOf(jsonElement.getAsJsonObject().get("count").getAsInt());
                }
            });
            return this;
        }

        public Builder mapDeleteCDN() {
            this.observable = this.observable.map(new Function<JsonElement, BmobException>() { // from class: cn.bmob.v3.http.RxBmob.Builder.26
                @Override // io.reactivex.functions.Function
                public BmobException apply(JsonElement jsonElement) throws Exception {
                    String asString = jsonElement.getAsJsonObject().get("msg").getAsString();
                    if (asString == null || !asString.equals("ok")) {
                        throw Exceptions.propagate(new BmobException(ErrorCode.E9015, asString));
                    }
                    return new BmobException();
                }
            });
            return this;
        }

        public Builder mapFindObjects() {
            this.observable = this.observable.map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.35
                @Override // io.reactivex.functions.Function
                public String apply(JsonElement jsonElement) throws Exception {
                    return jsonElement.getAsJsonObject().getAsJsonArray("results").toString();
                }
            });
            return this;
        }

        public Builder mapGetObject() {
            this.observable = this.observable.map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.34
                @Override // io.reactivex.functions.Function
                public String apply(JsonElement jsonElement) throws Exception {
                    return jsonElement.toString();
                }
            });
            return this;
        }

        public Builder mapJSONArray() {
            this.observable = this.observable.map(new Function<JsonElement, JSONArray>() { // from class: cn.bmob.v3.http.RxBmob.Builder.23
                @Override // io.reactivex.functions.Function
                public JSONArray apply(JsonElement jsonElement) throws Exception {
                    return new JSONArray(jsonElement.getAsJsonObject().get("results").getAsJsonArray().toString());
                }
            });
            return this;
        }

        public Builder mapJSONObject() {
            this.observable = this.observable.map(new Function<JsonElement, JSONObject>() { // from class: cn.bmob.v3.http.RxBmob.Builder.22
                @Override // io.reactivex.functions.Function
                public JSONObject apply(JsonElement jsonElement) throws Exception {
                    return new JSONObject(jsonElement.toString());
                }
            });
            return this;
        }

        public Builder mapPolicyQuery(final BmobCallback bmobCallback) {
            this.observable = this.observable.map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.37
                @Override // io.reactivex.functions.Function
                public String apply(JsonElement jsonElement) {
                    BmobCallback bmobCallback2 = bmobCallback;
                    if (!(bmobCallback2 instanceof QueryListener) && !(bmobCallback2 instanceof SQLQueryListener)) {
                        if (bmobCallback2 instanceof FindListener) {
                            return jsonElement.getAsJsonObject().getAsJsonArray("results").toString();
                        }
                        throw Exceptions.propagate(new BmobException(ErrorCode.E9015, " mapPolicyQuery does not support this BmobCallback"));
                    }
                    String string = jsonElement.toString();
                    Type type = ((ParameterizedType) bmobCallback.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                    if (type == BmobUser.class) {
                        BmobContentProvider.updateUser(string, type.getClass());
                        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
                        if (jsonElement2 != null) {
                            BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
                        }
                    }
                    return string;
                }
            });
            return this;
        }

        public Builder mapSQLQuery() {
            this.observable = this.observable.map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.36
                @Override // io.reactivex.functions.Function
                public String apply(JsonElement jsonElement) {
                    return jsonElement.toString();
                }
            });
            return this;
        }

        public Builder mapSaveCDN() {
            this.observable = this.observable.map(new Function<JsonElement, BmobException>() { // from class: cn.bmob.v3.http.RxBmob.Builder.25
                @Override // io.reactivex.functions.Function
                public BmobException apply(JsonElement jsonElement) throws Exception {
                    String asString = jsonElement.getAsJsonObject().get("msg").getAsString();
                    if (asString == null || !asString.equals("ok")) {
                        throw Exceptions.propagate(new BmobException(ErrorCode.E9020, asString));
                    }
                    return new BmobException();
                }
            });
            return this;
        }

        public Builder mapStatistics() {
            this.observable = this.observable.map(new Function<JsonElement, JSONArray>() { // from class: cn.bmob.v3.http.RxBmob.Builder.30
                @Override // io.reactivex.functions.Function
                public JSONArray apply(JsonElement jsonElement) throws Exception {
                    try {
                        JsonArray asJsonArray = jsonElement.getAsJsonObject().get("results").getAsJsonArray();
                        if (asJsonArray == null || asJsonArray.size() <= 0) {
                            return null;
                        }
                        return new JSONArray(asJsonArray.toString());
                    } catch (JSONException unused) {
                        return null;
                    }
                }
            });
            return this;
        }

        public Builder mapString() {
            this.observable = this.observable.map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.http.RxBmob.Builder.31
                @Override // io.reactivex.functions.Function
                public String apply(JsonElement jsonElement) throws Exception {
                    return jsonElement.toString();
                }
            });
            return this;
        }

        public <T> Builder mapT(final Class<T> cls) {
            this.observable = this.observable.map(new Function<JsonElement, T>() { // from class: cn.bmob.v3.http.RxBmob.Builder.32
                @Override // io.reactivex.functions.Function
                public T apply(JsonElement jsonElement) throws Exception {
                    return (T) GsonUtil.toObject(jsonElement, cls);
                }
            });
            return this;
        }

        public Builder mapVoid() {
            this.observable = this.observable.map(new Function<JsonElement, BmobException>() { // from class: cn.bmob.v3.http.RxBmob.Builder.28
                @Override // io.reactivex.functions.Function
                public BmobException apply(JsonElement jsonElement) throws Exception {
                    return new BmobException();
                }
            });
            return this;
        }

        public Builder merge(Observable observable, Observable observable2) {
            this.observable = Observable.merge(observable, observable2);
            return this;
        }

        public <T> Builder next(final Observable<T> observable) {
            this.observable = this.observable.concatMap(new Function<Boolean, Observable<T>>() { // from class: cn.bmob.v3.http.RxBmob.Builder.21
                @Override // io.reactivex.functions.Function
                public Observable<T> apply(Boolean bool) throws Exception {
                    return observable;
                }
            });
            return this;
        }

        public Builder nextTest(String str, JSONObject jSONObject) {
            this.observable = BmobClient.getInstance().request(str, jSONObject);
            return this;
        }

        public Builder observeOn(Scheduler scheduler) {
            this.observable = this.observable.observeOn(scheduler);
            return this;
        }

        public Builder retryWhen(Function<Observable<? extends Throwable>, Observable<?>> function) {
            this.observable = this.observable.retryWhen(function);
            return this;
        }

        public Builder subscribe(final BmobCallback bmobCallback) {
            if (bmobCallback == null) {
                BLog.e("listener is null,just create observable.");
                return this;
            }
            this.mDisposable = this.observable.subscribe(new Consumer<Object>() { // from class: cn.bmob.v3.http.RxBmob.Builder.38
                @Override // io.reactivex.functions.Consumer
                public void accept(Object obj) {
                    if (obj == null) {
                        BLog.e("value is null");
                        return;
                    }
                    BmobCallback bmobCallback2 = bmobCallback;
                    if (bmobCallback2 instanceof UploadFileListener) {
                        if ((obj instanceof BmobException) && ((BmobException) obj).getErrorCode() == 0) {
                            ((UploadFileListener) bmobCallback).done(null);
                            return;
                        } else {
                            ((UploadFileListener) bmobCallback).done((BmobException) obj);
                            return;
                        }
                    }
                    if (bmobCallback2 instanceof DeleteBatchListener) {
                        BmobReturn bmobReturn = (BmobReturn) obj;
                        if (bmobReturn.getE() == null) {
                            ((DeleteBatchListener) bmobCallback).done((String[]) null, (BmobException) null);
                            return;
                        } else {
                            ((DeleteBatchListener) bmobCallback).done((String[]) bmobReturn.getT(), bmobReturn.getE());
                            return;
                        }
                    }
                    if (bmobCallback2 instanceof BmobCallback2) {
                        ((BmobCallback2) bmobCallback2).done(obj, null);
                        return;
                    }
                    if (!(bmobCallback2 instanceof BmobCallback1)) {
                        BLog.e("not support this callback");
                    } else if ((obj instanceof BmobException) && ((BmobException) obj).getErrorCode() == 0) {
                        ((BmobCallback1) bmobCallback).done(null);
                    } else {
                        ((BmobCallback1) bmobCallback).done(obj);
                    }
                }
            }, new Consumer<Throwable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.39
                @Override // io.reactivex.functions.Consumer
                public void accept(Throwable th) {
                    BmobCallback bmobCallback2 = bmobCallback;
                    if (bmobCallback2 instanceof UploadFileListener) {
                        if (!(th instanceof BmobException)) {
                            ((UploadFileListener) bmobCallback2).done(new BmobException(ErrorCode.E9015, RxBmob.getStackMsg(th)));
                            return;
                        } else {
                            ((UploadFileListener) bmobCallback2).done((BmobException) th);
                            return;
                        }
                    }
                    if (bmobCallback2 instanceof DeleteBatchListener) {
                        if (!(th instanceof BmobException)) {
                            ((DeleteBatchListener) bmobCallback2).done((String[]) null, new BmobException(ErrorCode.E9015, RxBmob.getStackMsg(th)));
                            return;
                        } else {
                            ((DeleteBatchListener) bmobCallback2).done((String[]) null, (BmobException) th);
                            return;
                        }
                    }
                    if (bmobCallback2 instanceof BmobCallback2) {
                        if (!(th instanceof BmobException)) {
                            ((BmobCallback2) bmobCallback2).done(null, new BmobException(ErrorCode.E9015, RxBmob.getStackMsg(th)));
                            return;
                        } else {
                            ((BmobCallback2) bmobCallback2).done(null, (BmobException) th);
                            return;
                        }
                    }
                    if (!(bmobCallback2 instanceof BmobCallback1)) {
                        BLog.e("not support this callback");
                    } else if (!(th instanceof BmobException)) {
                        ((BmobCallback1) bmobCallback2).done(new BmobException(ErrorCode.E9015, RxBmob.getStackMsg(th)));
                    } else {
                        ((BmobCallback1) bmobCallback2).done((BmobException) th);
                    }
                }
            }, new Action() { // from class: cn.bmob.v3.http.RxBmob.Builder.40
                @Override // io.reactivex.functions.Action
                public void run() {
                    bmobCallback.onFinish();
                }
            }, new Consumer<Disposable>() { // from class: cn.bmob.v3.http.RxBmob.Builder.41
                @Override // io.reactivex.functions.Consumer
                public void accept(Disposable disposable) {
                }
            });
            return this;
        }

        public Builder subscribeOn(Scheduler scheduler) {
            this.observable = this.observable.subscribeOn(scheduler);
            return this;
        }

        public Builder zip(Observable observable, Observable observable2, BiFunction biFunction) {
            this.observable = Observable.zip(observable, observable2, biFunction);
            return this;
        }

        public Builder create(Observable observable) {
            this.observable = observable;
            return this;
        }

        public Builder check(List<R1> list) {
            return check(true, list);
        }
    }

    public RxBmob() {
        this(new Builder());
    }

    private static String getStackMsg(Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            stringBuffer.append(stackTraceElement.toString() + "\n");
        }
        return stringBuffer.toString();
    }

    public Disposable getDisposable() {
        return this.mDisposable;
    }

    public Observable getObservable() {
        return this.observable.hide();
    }

    public RxBmob(Builder builder) {
        this.observable = builder.observable.compose(BmobClient.applySchedulers());
        this.mDisposable = builder.mDisposable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            stringBuffer.append(stackTraceElement.toString() + "\n");
        }
        return stringBuffer.toString();
    }
}
