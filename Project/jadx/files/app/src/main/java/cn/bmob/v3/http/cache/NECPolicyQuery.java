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
public class NECPolicyQuery extends PolicyQuery {
    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public BmobQuery.CachePolicy cachePolicy() {
        return BmobQuery.CachePolicy.NETWORK_ELSE_CACHE;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public boolean needNetwork() {
        return false;
    }

    @Override // cn.bmob.v3.http.cache.PolicyQuery
    public Disposable subscribe(final Class cls, final List list, String str, final JSONObject jSONObject, final long j2, final BmobCallback bmobCallback) {
        return createSubscription(networkObservable(list, str, jSONObject, bmobCallback), new QueryListener<String>() { // from class: cn.bmob.v3.http.cache.NECPolicyQuery.1
            @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
            public void done(String str2, BmobException bmobException) {
                if (bmobException != null) {
                    BLog.i("NETWORK_ELSE_CACHE：e->" + bmobException.getMessage());
                    NECPolicyQuery nECPolicyQuery = NECPolicyQuery.this;
                    nECPolicyQuery.createSubscription(nECPolicyQuery.cacheObservable(list, jSONObject, j2), new QueryListener<String>() { // from class: cn.bmob.v3.http.cache.NECPolicyQuery.1.1
                        @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
                        public void done(String str3, BmobException bmobException2) {
                            if (bmobException2 == null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                NECPolicyQuery.this.onNextListener(cls, str3, bmobCallback);
                            } else {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                NECPolicyQuery.this.onErrorListener(bmobException2, bmobCallback);
                            }
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("NETWORK_ELSE_CACHE：data->");
                sb.append(TextUtils.isEmpty(str2) ? " empty " : " has data ");
                BLog.i(sb.toString());
                NECPolicyQuery.this.onNextListener(cls, str2, bmobCallback);
            }
        });
    }
}
