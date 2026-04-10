package cn.bmob.v3.http.cache;

import android.text.TextUtils;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobCallback;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.util.BLog;
import io.reactivex.disposables.Disposable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CENPolicyQuery extends PolicyQuery {
    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public BmobQuery.CachePolicy cachePolicy() {
        return BmobQuery.CachePolicy.CACHE_ELSE_NETWORK;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public boolean needNetwork() {
        return true;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public Disposable subscribe(final Class cls, final List list, final String str, final JSONObject jSONObject, long j2, final BmobCallback bmobCallback) {
        return createSubscription(cacheObservable(list, jSONObject, j2), new QueryListener<String>() { // from class: cn.bmob.v3.http.cache.CENPolicyQuery.1
            @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
            public void done(String str2, BmobException bmobException) {
                if (!TextUtils.isEmpty(str2)) {
                    BLog.i("CACHE_ELSE_NETWORK：data-> has data ");
                    CENPolicyQuery.this.onNextListener(cls, str2, bmobCallback);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("CACHE_ELSE_NETWORK：data-> empty ,e->");
                sb.append(bmobException == null ? " null " : bmobException.getMessage());
                BLog.i(sb.toString());
                CENPolicyQuery cENPolicyQuery = CENPolicyQuery.this;
                cENPolicyQuery.createSubscription(cENPolicyQuery.networkObservable(list, str, jSONObject, bmobCallback), new QueryListener<String>() { // from class: cn.bmob.v3.http.cache.CENPolicyQuery.1.1
                    @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
                    public void done(String str3, BmobException bmobException2) {
                        if (bmobException2 == null) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            CENPolicyQuery.this.onNextListener(cls, str3, bmobCallback);
                        } else {
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            CENPolicyQuery.this.onErrorListener(bmobException2, bmobCallback);
                        }
                    }
                });
            }
        });
    }
}
