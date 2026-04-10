package cn.bmob.v3;

import android.content.Context;
import android.text.TextUtils;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.QueryConditions;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.cache.PolicyFactory;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.CacheHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobQuery<T> {
    private String _c_;
    private Context appContext;
    private CachePolicy cachePolicy;
    private QueryConditions conditions;
    private boolean isUsingRelation;
    private long maxCacheAge;
    private Class<T> queryClass;

    public enum CachePolicy {
        IGNORE_CACHE,
        CACHE_ONLY,
        NETWORK_ONLY,
        CACHE_ELSE_NETWORK,
        NETWORK_ELSE_CACHE,
        CACHE_THEN_NETWORK
    }

    public BmobQuery() {
        this(null);
    }

    public static void clearAllCachedResults() {
        CacheHelper.clearCacheDir();
    }

    private RxBmob countRequest(Class<T> cls, CountListener countListener) {
        if (cls == null) {
            throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
        }
        this.conditions.setQueryType(3);
        this.conditions.setClazz(cls);
        return BmobFactory.getInstance().createCountRequest(BmobFactory.rByContext("no check", " no check"), BmobURL.getDefault().getUrl("find"), this.conditions.assembleParams(), countListener);
    }

    private Disposable doBql(Class<T> cls, String str, BmobCallback bmobCallback, Object... objArr) {
        this.conditions.setQueryType(5);
        this.conditions.setBql(str);
        if (objArr != null && objArr.length > 0) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr2[i2] = objArr[i2];
            }
            this.conditions.setValues(objArr2);
        }
        JSONObject jSONObjectAssembleParams = this.conditions.assembleParams();
        if (bmobCallback instanceof QueryListener) {
            return BmobFactory.getInstance().createBQLStatisticRequest(BmobURL.getDefault().getUrl("cloud_query"), jSONObjectAssembleParams, bmobCallback).getDisposable();
        }
        if (bmobCallback instanceof SQLQueryListener) {
            return PolicyFactory.getInstance().createPolicySubscription(null, cls, this.cachePolicy, this.maxCacheAge, BmobURL.getDefault().getUrl("cloud_query"), jSONObjectAssembleParams, bmobCallback);
        }
        throw new IllegalArgumentException("doBql does not support this BmobCallback");
    }

    private Disposable doQueryGeneral(String str, BmobCallback bmobCallback, int i2) {
        this.conditions.setQueryType(i2);
        Class<?> cls = (Class) ((ParameterizedType) bmobCallback.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.conditions.setClazz(cls);
        return PolicyFactory.getInstance().createPolicySubscription(str, cls, this.cachePolicy, this.maxCacheAge, BmobURL.getDefault().getUrl("find"), this.conditions.assembleParams(), bmobCallback);
    }

    private RxBmob doQueryTablenameGeneral(String str, BmobCallback bmobCallback, boolean z2) {
        this.conditions.setQueryType(1);
        if (z2) {
            if (TextUtils.isEmpty(str) || bmobCallback == null) {
                throw new IllegalArgumentException(" objectId or listener must not be null");
            }
            this.conditions.setObjectId(str);
        } else if (bmobCallback == null) {
            throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
        }
        JSONObject jSONObjectAssembleParams = this.conditions.assembleParams();
        try {
            jSONObjectAssembleParams.put("c", this._c_);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return z2 ? new RxBmob.Builder().nextTest(BmobURL.getDefault().getUrl("find"), jSONObjectAssembleParams).mapJSONObject().subscribe(bmobCallback).build() : new RxBmob.Builder().nextTest(BmobURL.getDefault().getUrl("find"), jSONObjectAssembleParams).mapJSONArray().subscribe(bmobCallback).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Disposable doSQLQuery(Class<T> cls, SQLQueryListener<T> sQLQueryListener) {
        this.conditions.setQueryType(5);
        return PolicyFactory.getInstance().createPolicySubscription(null, cls, this.cachePolicy, this.maxCacheAge, BmobURL.getDefault().getUrl("cloud_query"), this.conditions.assembleParams(), sQLQueryListener);
    }

    private RxBmob findObjectsByTableRequest(boolean z2, QueryListener<JSONArray> queryListener) {
        this.conditions.setQueryType(1);
        JSONObject jSONObjectAssembleParams = this.conditions.assembleParams();
        try {
            jSONObjectAssembleParams.put("c", this._c_);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().direct(BmobURL.getDefault().getUrl("find"), jSONObjectAssembleParams).mapJSONArray().subscribe(queryListener).build();
    }

    private RxBmob findStatisticsRequest(Class<?> cls, QueryListener<JSONArray> queryListener) {
        this.conditions.setQueryType(4);
        this.conditions.setClazz(cls);
        return BmobFactory.getInstance().createStatisticsRequest(BmobFactory.rByContext("no check", " no check"), BmobURL.getDefault().getUrl("find"), this.conditions.assembleParams(), queryListener);
    }

    private JSONObject generateQueryParams(Context context, Class<T> cls) {
        this.conditions.setClazz(cls);
        this.conditions.assembleParams();
        return BmobClient.generateCacheKey(context, getParams());
    }

    private RxBmob getObjectByTableRequest(String str, QueryListener<JSONObject> queryListener) {
        if (TextUtils.isEmpty(str) || queryListener == null) {
            throw new IllegalArgumentException(" objectId or listener must not be null");
        }
        this.conditions.setQueryType(1);
        this.conditions.setObjectId(str);
        JSONObject jSONObjectAssembleParams = this.conditions.assembleParams();
        try {
            jSONObjectAssembleParams.put("c", this._c_);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().direct(BmobURL.getDefault().getUrl("find"), jSONObjectAssembleParams).mapJSONObject().subscribe(queryListener).build();
    }

    private JSONObject getParams() {
        return this.conditions.getParams();
    }

    public BmobQuery<T> addQueryKeys(String str) {
        this.conditions.addQueryKeys(str);
        return this;
    }

    public BmobQuery<T> addWhereContainedIn(String str, Collection<? extends Object> collection) {
        this.conditions.addWhereContainedIn(str, collection);
        return this;
    }

    public BmobQuery<T> addWhereContains(String str, String str2) {
        addWhereMatches(str, Pattern.quote(str2));
        return this;
    }

    public BmobQuery<T> addWhereContainsAll(String str, Collection<?> collection) {
        this.conditions.addWhereContainsAll(str, collection);
        return this;
    }

    public BmobQuery<T> addWhereDoesNotExists(String str) {
        this.conditions.addWhereDoesNotExists(str);
        return this;
    }

    public <E> BmobQuery<T> addWhereDoesNotMatchQuery(String str, String str2, BmobQuery<E> bmobQuery) {
        this.conditions.addWhereDoesNotMatchQuery(str, str2, bmobQuery);
        return this;
    }

    public BmobQuery<T> addWhereEndsWith(String str, String str2) {
        addWhereMatches(str, Pattern.quote(str2) + "$");
        return this;
    }

    public BmobQuery<T> addWhereEqualTo(String str, Object obj) {
        this.conditions.addWhereEqualTo(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereExists(String str) {
        this.conditions.addWhereExists(str);
        return this;
    }

    public BmobQuery<T> addWhereGreaterThan(String str, Object obj) {
        this.conditions.addWhereGreaterThan(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereGreaterThanOrEqualTo(String str, Object obj) {
        this.conditions.addWhereGreaterThanOrEqualTo(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereLessThan(String str, Object obj) {
        this.conditions.addWhereLessThan(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereLessThanOrEqualTo(String str, Object obj) {
        this.conditions.addWhereLessThanOrEqualTo(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereMatches(String str, String str2) {
        this.conditions.addWhereMatches(str, str2);
        return this;
    }

    public <E> BmobQuery<T> addWhereMatchesQuery(String str, String str2, BmobQuery<E> bmobQuery) {
        this.conditions.addWhereMatchesQuery(str, str2, bmobQuery);
        return this;
    }

    public BmobQuery<T> addWhereNear(String str, BmobGeoPoint bmobGeoPoint) {
        this.conditions.addWhereNear(str, bmobGeoPoint);
        return this;
    }

    public BmobQuery<T> addWhereNotContainedIn(String str, Collection<? extends Object> collection) {
        this.conditions.addWhereNotContainedIn(str, collection);
        return this;
    }

    public BmobQuery<T> addWhereNotEqualTo(String str, Object obj) {
        this.conditions.addWhereNotEqualTo(str, obj);
        return this;
    }

    public BmobQuery<T> addWhereRelatedTo(String str, BmobPointer bmobPointer) {
        this.conditions.addWhereRelatedTo(str, bmobPointer);
        this.isUsingRelation = true;
        return this;
    }

    public BmobQuery<T> addWhereStartsWith(String str, String str2) {
        addWhereMatches(str, "^" + Pattern.quote(str2));
        return this;
    }

    public BmobQuery<T> addWhereWithinGeoBox(String str, BmobGeoPoint bmobGeoPoint, BmobGeoPoint bmobGeoPoint2) {
        this.conditions.addWhereWithinGeoBox(str, bmobGeoPoint, bmobGeoPoint2);
        return this;
    }

    public BmobQuery<T> addWhereWithinKilometers(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        this.conditions.addWhereWithinKilometers(str, bmobGeoPoint, d2);
        return this;
    }

    public BmobQuery<T> addWhereWithinMiles(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        this.conditions.addWhereWithinMiles(str, bmobGeoPoint, d2);
        return this;
    }

    public BmobQuery<T> addWhereWithinRadians(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        this.conditions.addWhereWithinRadians(str, bmobGeoPoint, d2);
        return this;
    }

    public BmobQuery<T> and(List<BmobQuery<T>> list) {
        this.conditions.and(list);
        return this;
    }

    public BmobQuery<T> average(String[] strArr) {
        this.conditions.average(strArr);
        return this;
    }

    public void clearCachedResult(Class<T> cls) {
        CacheHelper.clearFromKeyValueCache(CacheHelper.getCacheKey(generateQueryParams(this.appContext, cls)));
    }

    public Disposable count(Class<T> cls, CountListener countListener) {
        return countRequest(cls, countListener).getDisposable();
    }

    public Observable<Integer> countObservable(Class<T> cls) {
        return countRequest(cls, null).getObservable();
    }

    public Observable<BmobQueryResult<T>> doSQLQueryObservable(final Class<T> cls) {
        if (cls != null) {
            return new RxBmob.Builder().create(new ObservableOnSubscribe<BmobQueryResult<T>>() { // from class: cn.bmob.v3.BmobQuery.4
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(final ObservableEmitter<BmobQueryResult<T>> observableEmitter) {
                    if (observableEmitter.isDisposed()) {
                        BLog.e(BmobConstants.TAG, "doSQLQueryObservable: subscriber is unSubscribed ");
                    } else {
                        BmobQuery.this.doSQLQuery(cls, new SQLQueryListener<T>() { // from class: cn.bmob.v3.BmobQuery.4.1
                            @Override // cn.bmob.v3.listener.SQLQueryListener, cn.bmob.v3.listener.BmobCallback2
                            public void done(BmobQueryResult<T> bmobQueryResult, BmobException bmobException) {
                                if (bmobException == null) {
                                    observableEmitter.onNext(bmobQueryResult);
                                } else {
                                    observableEmitter.onError(bmobException);
                                }
                                observableEmitter.onComplete();
                            }
                        });
                    }
                }
            }).build().getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    public Disposable doStatisticQuery(String str, QueryListener<JSONArray> queryListener) {
        return doBql(null, str, queryListener, new Object[0]);
    }

    public Disposable findObjects(FindListener<T> findListener) {
        return query((String) null, (BmobCallback) findListener, false);
    }

    public Disposable findObjectsByTable(QueryListener<JSONArray> queryListener) {
        return doQueryTablenameGeneral(null, queryListener, false).getDisposable();
    }

    public Observable<JSONArray> findObjectsByTableObservable() {
        return findObjectsByTableRequest(null).getObservable();
    }

    public Observable<List<T>> findObjectsObservable(final Class<T> cls) {
        if (cls != null) {
            return new RxBmob.Builder().create(new ObservableOnSubscribe<List<T>>() { // from class: cn.bmob.v3.BmobQuery.2
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(final ObservableEmitter<List<T>> observableEmitter) throws Exception {
                    if (observableEmitter.isDisposed()) {
                        BLog.e(BmobConstants.TAG, "findObjectsObservable: subscriber is unsubscribed ");
                    } else {
                        BmobQuery.this.query((String) null, cls, new FindListener<T>() { // from class: cn.bmob.v3.BmobQuery.2.1
                            @Override // cn.bmob.v3.listener.FindListener, cn.bmob.v3.listener.BmobCallback2
                            public void done(List<T> list, BmobException bmobException) {
                                if (bmobException == null) {
                                    observableEmitter.onNext(list);
                                } else {
                                    observableEmitter.onError(bmobException);
                                }
                                observableEmitter.onComplete();
                            }
                        });
                    }
                }
            }).build().getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    public List<T> findObjectsSync(Class<T> cls) throws BmobException {
        if (!BmobNative.hasKey()) {
            throw new BmobException(9001, ErrorCode.E9001S);
        }
        this.conditions.setClazz(cls);
        try {
            return BmobClient.getInstance().findObjectsSync(cls, this.conditions.assembleParams(), this.cachePolicy);
        } catch (Exception e2) {
            throw new BmobException("find error", e2);
        }
    }

    public Disposable findStatistics(Class<?> cls, QueryListener<JSONArray> queryListener) {
        if (cls != null) {
            return findStatisticsRequest(cls, queryListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    public Observable<JSONArray> findStatisticsObservable(Class<?> cls) {
        if (cls != null) {
            return findStatisticsRequest(cls, null).getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    public CachePolicy getCachePolicy() {
        return this.cachePolicy;
    }

    public long getMaxCacheAge() {
        return this.maxCacheAge;
    }

    public Disposable getObject(String str, QueryListener<T> queryListener) {
        return query(str, (BmobCallback) queryListener, true);
    }

    public Disposable getObjectByTable(String str, QueryListener<JSONObject> queryListener) {
        return doQueryTablenameGeneral(str, queryListener, true).getDisposable();
    }

    public Observable<JSONObject> getObjectByTableObservable(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(" objectId must not be null");
        }
        return getObjectByTableRequest(str, null).getObservable();
    }

    public Observable<T> getObjectObservable(final Class<T> cls, final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(" objectId must not be null");
        }
        if (cls != null) {
            return new RxBmob.Builder().create(new ObservableOnSubscribe<T>() { // from class: cn.bmob.v3.BmobQuery.3
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(final ObservableEmitter<T> observableEmitter) throws Exception {
                    if (observableEmitter.isDisposed()) {
                        BLog.e(BmobConstants.TAG, "getObjectObservable: subscriber is unsubscribed ");
                    } else {
                        BmobQuery.this.query(str, cls, new QueryListener<T>() { // from class: cn.bmob.v3.BmobQuery.3.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
                            public void done(T t2, BmobException bmobException) {
                                if (bmobException == null) {
                                    observableEmitter.onNext(t2);
                                } else {
                                    observableEmitter.onError(bmobException);
                                }
                                observableEmitter.onComplete();
                            }
                        });
                    }
                }
            }).build().getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    protected Class<T> getQueryClass() {
        return this.queryClass;
    }

    public JSONObject getWhere() {
        return this.conditions.getWhere();
    }

    public BmobQuery<T> groupby(String[] strArr) {
        this.conditions.groupby(strArr);
        return this;
    }

    public boolean hasCachedResult(Class<T> cls) {
        return CacheHelper.loadFromKeyValueCache(CacheHelper.getCacheKey(generateQueryParams(this.appContext, cls)), this.maxCacheAge) != null;
    }

    public Observable hasCachedResultObservable(final Class<T> cls) {
        return new RxBmob.Builder().create(new ObservableOnSubscribe<Boolean>() { // from class: cn.bmob.v3.BmobQuery.1
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) {
                observableEmitter.onNext(Boolean.valueOf(BmobQuery.this.hasCachedResult(cls)));
            }
        }).subscribeOn(Schedulers.io()).build().getObservable();
    }

    public BmobQuery<T> having(HashMap<String, Object> map) {
        this.conditions.having(map);
        return this;
    }

    public BmobQuery<T> include(String str) {
        this.conditions.setInclude(str);
        return this;
    }

    public BmobQuery<T> max(String[] strArr) {
        this.conditions.max(strArr);
        return this;
    }

    public BmobQuery<T> min(String[] strArr) {
        this.conditions.min(strArr);
        return this;
    }

    public BmobQuery<T> or(List<BmobQuery<T>> list) {
        this.conditions.or(list);
        return this;
    }

    public BmobQuery<T> order(String str) {
        this.conditions.setOrder(str);
        return this;
    }

    protected Disposable query(String str, Class<T> cls, BmobCallback bmobCallback) {
        if (bmobCallback == null) {
            throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
        }
        this.conditions.setQueryType(2);
        if (!TextUtils.isEmpty(str)) {
            this.conditions.setObjectId(str);
        }
        this.conditions.setClazz(cls);
        return PolicyFactory.getInstance().createPolicySubscription(str, cls, this.cachePolicy, this.maxCacheAge, BmobURL.getDefault().getUrl("find"), this.conditions.assembleParams(), bmobCallback);
    }

    public void setCachePolicy(CachePolicy cachePolicy) {
        this.cachePolicy = cachePolicy;
    }

    public BmobQuery<T> setHasGroupCount(boolean z2) {
        this.conditions.setHasGroupCount(z2);
        return this;
    }

    public BmobQuery<T> setLimit(int i2) {
        this.conditions.setLimit(Integer.valueOf(i2));
        return this;
    }

    public void setMaxCacheAge(long j2) {
        this.maxCacheAge = j2;
    }

    public BmobQuery<T> setPage(int i2, int i3) {
        if (i2 < 1) {
            i2 = 1;
        }
        this.conditions.setSkip(Integer.valueOf((i2 - 1) * i3));
        this.conditions.setLimit(Integer.valueOf(i3));
        return this;
    }

    public BmobQuery<T> setPreparedParams(Object[] objArr) {
        this.conditions.setValues(objArr);
        return this;
    }

    protected void setQueryClass(Class<T> cls) {
        this.queryClass = cls;
    }

    public BmobQuery<T> setSQL(String str) {
        this.conditions.setBql(str);
        return this;
    }

    public BmobQuery<T> setSkip(int i2) {
        this.conditions.setSkip(Integer.valueOf(i2));
        return this;
    }

    public BmobQuery<T> sum(String[] strArr) {
        this.conditions.sum(strArr);
        return this;
    }

    public BmobQuery(String str) {
        this.isUsingRelation = false;
        if (!TextUtils.isEmpty(str)) {
            this._c_ = str;
        }
        this.cachePolicy = CachePolicy.IGNORE_CACHE;
        this.maxCacheAge = 18000000L;
        this.conditions = new QueryConditions();
        this.appContext = Bmob.getApplicationContext();
    }

    public Disposable doStatisticQuery(String str, QueryListener<JSONArray> queryListener, Object... objArr) {
        return doBql(null, str, queryListener, objArr);
    }

    public Disposable doSQLQuery(SQLQueryListener<T> sQLQueryListener) {
        if (sQLQueryListener != null) {
            return doSQLQuery((Class) ((ParameterizedType) sQLQueryListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], sQLQueryListener);
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    private RxBmob findObjectsByTableRequest(QueryListener<JSONArray> queryListener) {
        if (queryListener != null) {
            this.conditions.setQueryType(1);
            JSONObject jSONObjectAssembleParams = this.conditions.assembleParams();
            try {
                jSONObjectAssembleParams.put("c", this._c_);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return new RxBmob.Builder().direct(BmobURL.getDefault().getUrl("find"), jSONObjectAssembleParams).mapJSONArray().subscribe(queryListener).build();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    public Disposable doSQLQuery(String str, SQLQueryListener<T> sQLQueryListener) {
        return doSQLQuery(str, sQLQueryListener, new Object[0]);
    }

    public Disposable doSQLQuery(String str, SQLQueryListener<T> sQLQueryListener, Object... objArr) {
        if (sQLQueryListener != null) {
            return doBql((Class) ((ParameterizedType) sQLQueryListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], str, sQLQueryListener, objArr);
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    protected Disposable query(String str, BmobCallback bmobCallback, boolean z2) {
        if (z2) {
            if (TextUtils.isEmpty(str) || bmobCallback == null) {
                return null;
            }
            this.conditions.setObjectId(str);
        } else if (bmobCallback == null) {
            return null;
        }
        return doQueryGeneral(str, bmobCallback, 2);
    }
}
