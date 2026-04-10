package cn.bmob.v3.http.cache;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.QueryListener;
import io.reactivex.disposables.Disposable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class COPolicyQuery extends PolicyQuery {
    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public BmobQuery.CachePolicy cachePolicy() {
        return BmobQuery.CachePolicy.CACHE_ONLY;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public boolean needNetwork() {
        return false;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public Disposable subscribe(final Class cls, List list, String str, JSONObject jSONObject, long j2, final BmobCallback bmobCallback) {
        return createSubscription(cacheObservable(list, jSONObject, j2), new QueryListener<String>() { // from class: cn.bmob.v3.http.cache.COPolicyQuery.1
            @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
            public void done(String str2, BmobException bmobException) {
                if (bmobException == null) {
                    COPolicyQuery.this.onNextListener(cls, str2, bmobCallback);
                } else {
                    COPolicyQuery.this.onErrorListener(bmobException, bmobCallback);
                }
            }
        });
    }
}
