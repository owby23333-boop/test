package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";
    private SerialLruCache<String, String> a = null;
    private Map<String, String> b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient StrategyInfoHolder f440c = null;

    StrategyConfig() {
    }

    StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.a = new SerialLruCache<>(this.a, 256);
            strategyConfig.b = new ConcurrentHashMap(this.b);
            strategyConfig.f440c = this.f440c;
        }
        return strategyConfig;
    }

    void b() {
        if (this.a == null) {
            this.a = new SerialLruCache<>(256);
        }
        if (this.b == null) {
            this.b = new ConcurrentHashMap();
        }
    }

    String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.b.get(str);
        }
        return str2;
    }

    void a(StrategyInfoHolder strategyInfoHolder) {
        this.f440c = strategyInfoHolder;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    void a(l.d dVar) {
        if (dVar.b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            for (int i2 = 0; i2 < dVar.b.length; i2++) {
                l.b bVar = dVar.b[i2];
                if (bVar.f476j) {
                    this.a.remove(bVar.a);
                } else if (bVar.f470d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.a, bVar.f470d);
                } else {
                    if (!"http".equalsIgnoreCase(bVar.f469c) && !"https".equalsIgnoreCase(bVar.f469c)) {
                        this.a.put(bVar.a, NO_RESULT);
                    } else {
                        this.a.put(bVar.a, bVar.f469c);
                    }
                    if (!TextUtils.isEmpty(bVar.f471e)) {
                        this.b.put(bVar.a, bVar.f471e);
                    } else {
                        this.b.remove(bVar.a);
                    }
                }
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.a.containsKey(str)) {
                        this.a.put((String) entry.getKey(), this.a.get(str));
                    } else {
                        this.a.put((String) entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.b.toString());
        }
    }

    String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.a.get(str);
            if (str2 == null) {
                this.a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f440c.d().a(str, false);
            return str2;
        }
        if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
