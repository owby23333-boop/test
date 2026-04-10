package anet.channel.b;

import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anetwork.channel.cache.Cache;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a implements Cache {
    private static boolean a = true;
    private static Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f296d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            b = new b();
            f295c = new c();
            f296d = new d();
        } catch (ClassNotFoundException unused) {
            a = false;
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (aVFSCacheCacheForModule != null) {
            return aVFSCacheCacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache aVFSCacheCacheForModule;
        if (a && (aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = 5242880L;
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            aVFSCacheCacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void clear() {
        if (a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f296d);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "clear cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // anetwork.channel.cache.Cache
    public Cache.Entry get(String str) {
        if (!a) {
            return null;
        }
        try {
            IAVFSCache iAVFSCacheB = b();
            if (iAVFSCacheB != null) {
                return (Cache.Entry) iAVFSCacheB.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (Exception e2) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, e2, new Object[0]);
        }
        return null;
    }

    @Override // anetwork.channel.cache.Cache
    public void put(String str, Cache.Entry entry) {
        if (a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.setObjectForKey(StringUtils.md5ToHex(str), entry, (IAVFSCache.OnObjectSetCallback) b);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void remove(String str) {
        if (a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f295c);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "remove cache failed", null, e2, new Object[0]);
            }
        }
    }
}
