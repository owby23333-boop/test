package cn.bmob.v3.http.cache;

import android.text.TextUtils;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.bean.R1;
import cn.bmob.v3.http.rx.PolicyAction1;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.BmobCallback2;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.CacheHelper;
import cn.bmob.v3.util.ZipUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class PolicyQuery<T> {
    private Observable createCacheObservable(final JSONObject jSONObject, final long j2) {
        return new RxBmob.Builder().create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.http.cache.PolicyQuery.5
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Throwable {
                if (observableEmitter.isDisposed()) {
                    BLog.i("createCacheObservable:subscribe is cancel ");
                    return;
                }
                Object objJsonFromKeyValueCache = CacheHelper.jsonFromKeyValueCache(CacheHelper.getCacheKey(jSONObject), j2);
                StringBuilder sb = new StringBuilder();
                sb.append("cache data:");
                sb.append(objJsonFromKeyValueCache == null ? "no cache" : objJsonFromKeyValueCache.toString());
                BLog.i(sb.toString());
                observableEmitter.onNext(objJsonFromKeyValueCache == null ? "" : objJsonFromKeyValueCache.toString());
                if (PolicyQuery.this.cachePolicy() == BmobQuery.CachePolicy.CACHE_ONLY) {
                    observableEmitter.onComplete();
                }
            }
        }).build().getObservable();
    }

    private Observable<String> createFindObjectsObservable(String str, JSONObject jSONObject) {
        return new RxBmob.Builder().direct(str, jSONObject).mapFindObjects().doOnNext(new PolicyAction1(false, cachePolicy(), jSONObject)).build().getObservable();
    }

    private Observable<String> createGetObjectObservable(String str, JSONObject jSONObject) {
        return new RxBmob.Builder().direct(str, jSONObject).mapGetObject().doOnNext(new PolicyAction1(false, cachePolicy(), jSONObject)).build().getObservable();
    }

    private Observable createNetworkObservable(String str, final JSONObject jSONObject, final BmobCallback bmobCallback) {
        return new RxBmob.Builder().direct(str, jSONObject).mapPolicyQuery(bmobCallback).doOnNext(new Consumer<String>() { // from class: cn.bmob.v3.http.cache.PolicyQuery.6
            @Override // io.reactivex.functions.Consumer
            public void accept(final String str2) {
                if (bmobCallback == null) {
                    BLog.e(BmobConstants.TAG, BmobConstants.NULL_LISTENER);
                } else if (PolicyQuery.this.cachePolicy() == BmobQuery.CachePolicy.IGNORE_CACHE) {
                    BLog.e("IGNORE_CACHE：该策略下无需缓存数据");
                } else {
                    final Scheduler.Worker workerCreateWorker = Schedulers.io().createWorker();
                    workerCreateWorker.schedule(new Runnable() { // from class: cn.bmob.v3.http.cache.PolicyQuery.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            if (PolicyQuery.this.needCache(str2, bmobCallback)) {
                                CacheHelper.saveToKeyValueCache(CacheHelper.getCacheKey(jSONObject), ZipUtil.compress(str2));
                            } else {
                                BLog.e("no data need to be cache");
                                workerCreateWorker.dispose();
                            }
                        }
                    });
                }
            }
        }).build().getObservable();
    }

    private Observable<String> createSQLQueryObservable(String str, JSONObject jSONObject) {
        return new RxBmob.Builder().direct(str, jSONObject).mapSQLQuery().doOnNext(new PolicyAction1(true, cachePolicy(), jSONObject)).build().getObservable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCache(String str, BmobCallback bmobCallback) throws JSONException {
        if (bmobCallback instanceof SQLQueryListener) {
            JSONArray jSONArray = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("results")) {
                    jSONArray = jSONObject.getJSONArray("results");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            str = jSONArray == null ? "" : jSONArray.toString();
        }
        try {
            List list = GsonUtil.toList(str);
            if (list != null) {
                return list.size() > 0;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public Observable cacheObservable(List<R1> list, JSONObject jSONObject, long j2) {
        return new RxBmob.Builder().check(needNetwork(), list).next(createCacheObservable(jSONObject, j2)).build().getObservable();
    }

    public abstract BmobQuery.CachePolicy cachePolicy();

    public Disposable createSubscription(Observable<String> observable, final QueryListener<String> queryListener) {
        return observable.subscribe(new Consumer<String>() { // from class: cn.bmob.v3.http.cache.PolicyQuery.1
            @Override // io.reactivex.functions.Consumer
            public void accept(String str) {
                queryListener.done(str, (BmobException) null);
            }
        }, new Consumer<Throwable>() { // from class: cn.bmob.v3.http.cache.PolicyQuery.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                PolicyQuery.this.onErrorListener((BmobException) th, queryListener);
            }
        }, new Action() { // from class: cn.bmob.v3.http.cache.PolicyQuery.3
            @Override // io.reactivex.functions.Action
            public void run() {
                queryListener.onFinish();
            }
        }, new Consumer<Disposable>() { // from class: cn.bmob.v3.http.cache.PolicyQuery.4
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
            }
        });
    }

    public abstract boolean needNetwork();

    public Observable networkObservable(List<R1> list, String str, JSONObject jSONObject, BmobCallback bmobCallback) {
        return new RxBmob.Builder().check(needNetwork(), list).next(createNetworkObservable(str, jSONObject, bmobCallback)).build().getObservable();
    }

    public void onErrorListener(BmobException bmobException, BmobCallback bmobCallback) {
        if (bmobCallback == null || !(bmobCallback instanceof BmobCallback2)) {
            BLog.e(BmobConstants.TAG, BmobConstants.NULL_LISTENER);
        } else {
            ((BmobCallback2) bmobCallback).done(null, bmobException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNextListener(Class<T> cls, String str, BmobCallback bmobCallback) {
        List list;
        if (bmobCallback == null) {
            BLog.e(BmobConstants.TAG, BmobConstants.NULL_LISTENER);
            return;
        }
        if ((cachePolicy() == BmobQuery.CachePolicy.CACHE_ONLY || cachePolicy() == BmobQuery.CachePolicy.NETWORK_ELSE_CACHE) && TextUtils.isEmpty(str)) {
            onErrorListener(new BmobException(ErrorCode.E9009, "No cache data."), bmobCallback);
            return;
        }
        Gson gsonCreate = new GsonBuilder().create();
        if (bmobCallback instanceof QueryListener) {
            BLog.i("getObject data：" + str);
            ((QueryListener) bmobCallback).done(gsonCreate.fromJson(str, (Class) cls), (BmobException) null);
            return;
        }
        int i2 = 0;
        if (bmobCallback instanceof FindListener) {
            ArrayList arrayList = new ArrayList();
            List list2 = (List) gsonCreate.fromJson(str, (Class) List.class);
            if (list2 != null) {
                while (i2 < list2.size()) {
                    arrayList.add(gsonCreate.fromJson(gsonCreate.toJson(list2.get(i2)), (Class) cls));
                    i2++;
                }
            }
            ((FindListener) bmobCallback).done((List) arrayList, (BmobException) null);
            return;
        }
        if (!(bmobCallback instanceof SQLQueryListener)) {
            BLog.e(BmobConstants.TAG, " onNextListener does not support this listener");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("results") && (list = (List) gsonCreate.fromJson(jSONObject.getJSONArray("results").toString(), (Class) List.class)) != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList2.add(gsonCreate.fromJson(gsonCreate.toJson(list.get(i3)), (Class) cls));
                }
            }
            if (jSONObject.has("count")) {
                i2 = jSONObject.getInt("count");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BLog.i("query sql datas：" + i2 + ",\n" + str);
        ((SQLQueryListener) bmobCallback).done((BmobQueryResult) new BmobQueryResult<>(arrayList2, i2), (BmobException) null);
    }

    public abstract Disposable subscribe(Class<T> cls, List<R1> list, String str, JSONObject jSONObject, long j2, BmobCallback bmobCallback);
}
