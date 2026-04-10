package cn.bmob.v3.http.rx;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.CacheHelper;
import cn.bmob.v3.util.ZipUtil;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PolicyAction1 implements Consumer<String> {
    BmobQuery.CachePolicy cachePolicy;
    boolean isSqlQuery;
    JSONObject params;

    public PolicyAction1(boolean z2, BmobQuery.CachePolicy cachePolicy, JSONObject jSONObject) {
        this.isSqlQuery = z2;
        this.cachePolicy = cachePolicy;
        this.params = jSONObject;
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(final String str) {
        if (this.cachePolicy == BmobQuery.CachePolicy.IGNORE_CACHE) {
            BLog.e("IGNORE_CACHE：该策略下无需缓存数据");
        } else {
            final Scheduler.Worker workerCreateWorker = Schedulers.io().createWorker();
            workerCreateWorker.schedule(new Runnable() { // from class: cn.bmob.v3.http.rx.PolicyAction1.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = PolicyAction1.this.isSqlQuery ? str.split(DispatchConstants.SIGN_SPLIT_SYMBOL)[1] : str;
                    List list = GsonUtil.toList(str2);
                    BLog.i("size:" + list.size());
                    if (list != null && list.size() > 0) {
                        CacheHelper.saveToKeyValueCache(CacheHelper.getCacheKey(PolicyAction1.this.params), ZipUtil.compress(str2));
                    } else {
                        BLog.e("no data need to be cache");
                        workerCreateWorker.dispose();
                    }
                }
            });
        }
    }
}
