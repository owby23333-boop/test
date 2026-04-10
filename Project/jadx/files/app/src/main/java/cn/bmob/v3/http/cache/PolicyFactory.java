package cn.bmob.v3.http.cache;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.QueryListener;
import io.reactivex.disposables.Disposable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PolicyFactory {
    private static byte[] lock;
    private static volatile PolicyFactory mClient;
    private static Map<BmobQuery.CachePolicy, PolicyQuery> strategyMap = new HashMap();

    static {
        strategyMap.put(BmobQuery.CachePolicy.IGNORE_CACHE, new ICPolicyQuery());
        strategyMap.put(BmobQuery.CachePolicy.NETWORK_ONLY, new NOPolicyQuery());
        strategyMap.put(BmobQuery.CachePolicy.CACHE_ONLY, new COPolicyQuery());
        strategyMap.put(BmobQuery.CachePolicy.CACHE_ELSE_NETWORK, new CENPolicyQuery());
        strategyMap.put(BmobQuery.CachePolicy.CACHE_THEN_NETWORK, new CTEPolicyQuery());
        strategyMap.put(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE, new NECPolicyQuery());
        lock = new byte[0];
    }

    private PolicyFactory() {
    }

    public static PolicyFactory getInstance() {
        if (mClient == null) {
            synchronized (lock) {
                if (mClient == null) {
                    mClient = new PolicyFactory();
                }
            }
        }
        return mClient;
    }

    public PolicyQuery create(BmobQuery.CachePolicy cachePolicy) {
        return strategyMap.get(cachePolicy);
    }

    public <T> Disposable createPolicySubscription(String str, Class<T> cls, BmobQuery.CachePolicy cachePolicy, long j2, String str2, JSONObject jSONObject, BmobCallback bmobCallback) {
        return create(cachePolicy).subscribe(cls, bmobCallback instanceof QueryListener ? BmobFactory.rByContext(str, "objectId can't be empty") : Collections.emptyList(), str2, jSONObject, j2, bmobCallback);
    }
}
