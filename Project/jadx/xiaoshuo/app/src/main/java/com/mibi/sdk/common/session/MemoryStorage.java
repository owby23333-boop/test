package com.mibi.sdk.common.session;

import android.os.Parcel;
import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.w51;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
public class MemoryStorage {
    private static final String DEFAULT_GROUP = "MEMORY_STORAGE_DEFAULT_GROUP";
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> mStorage = new ConcurrentHashMap<>();

    private MemoryStorage() {
    }

    private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> copy(ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> concurrentHashMap2 = new ConcurrentHashMap<>();
        for (String str : concurrentHashMap.keySet()) {
            ConcurrentHashMap<String, Object> concurrentHashMap3 = concurrentHashMap.get(str);
            for (String str2 : concurrentHashMap3.keySet()) {
                Object obj = concurrentHashMap3.get(str2);
                if (obj instanceof Serializable) {
                    ConcurrentHashMap<String, Object> concurrentHashMap4 = concurrentHashMap2.get(str);
                    if (concurrentHashMap4 == null) {
                        concurrentHashMap4 = new ConcurrentHashMap<>();
                        concurrentHashMap2.put(str, concurrentHashMap4);
                    }
                    concurrentHashMap4.put(str2, obj);
                }
            }
        }
        return concurrentHashMap2;
    }

    private Object innerGet(String str, String str2) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str2);
    }

    public static MemoryStorage newMemoryStorage() {
        return new MemoryStorage();
    }

    public <T> T get(String str, String str2) {
        try {
            return (T) innerGet(str, str2);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(DEFAULT_GROUP, str);
    }

    public double getDouble(String str) {
        return getDouble(DEFAULT_GROUP, str);
    }

    public int getInt(String str) {
        return getInt(DEFAULT_GROUP, str);
    }

    public long getLong(String str) {
        return getLong(DEFAULT_GROUP, str);
    }

    public <T extends Serializable> T getSerializable(String str) {
        return (T) getSerializable(DEFAULT_GROUP, str);
    }

    public String getString(String str) {
        return getString(DEFAULT_GROUP, str);
    }

    public boolean has(String str) {
        return has(DEFAULT_GROUP, str);
    }

    public MemoryStorage put(String str, Object obj) {
        return put(DEFAULT_GROUP, str, obj);
    }

    public void readFromParcel(Parcel parcel) {
        this.mStorage = (ConcurrentHashMap) parcel.readSerializable();
    }

    public MemoryStorage remove(String str) {
        return remove(DEFAULT_GROUP, str);
    }

    public MemoryStorage removeGroup(String str) {
        this.mStorage.remove(str);
        return this;
    }

    public MemoryStorage update(MemoryStorage memoryStorage) {
        this.mStorage = copy(memoryStorage.mStorage);
        return this;
    }

    public void writeToParcel(Parcel parcel) {
        parcel.writeSerializable(copy(this.mStorage));
    }

    public boolean getBoolean(String str, String str2) {
        return getBoolean(str, str2, false);
    }

    public double getDouble(String str, String str2) {
        return getDouble(str, str2, w51.l);
    }

    public int getInt(String str, String str2) {
        return getInt(str, str2, 0);
    }

    public long getLong(String str, String str2) {
        return getLong(str, str2, 0L);
    }

    public <T extends Serializable> T getSerializable(String str, String str2) {
        Object objInnerGet = innerGet(str, str2);
        if (objInnerGet == null) {
            return null;
        }
        try {
            return (T) objInnerGet;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public String getString(String str, String str2) {
        return getString(str, str2, null);
    }

    public boolean has(String str, String str2) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mStorage.get(str);
        return (concurrentHashMap == null || concurrentHashMap.get(str2) == null) ? false : true;
    }

    public MemoryStorage put(String str, String str2, Object obj) {
        if (obj == null) {
            obj = "";
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.mStorage.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(str2, obj);
        return this;
    }

    public MemoryStorage remove(String str, String str2) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mStorage.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(str2);
        }
        return this;
    }

    public boolean getBoolean(String str, String str2, boolean z) {
        Object objInnerGet = innerGet(str, str2);
        if (objInnerGet == null) {
            return z;
        }
        if (objInnerGet.equals(Boolean.FALSE)) {
            return false;
        }
        boolean z2 = objInnerGet instanceof String;
        if (z2 && ((String) objInnerGet).equalsIgnoreCase(MscKeys.VAL_FALSE)) {
            return false;
        }
        if (objInnerGet.equals(Boolean.TRUE)) {
            return true;
        }
        if (z2 && ((String) objInnerGet).equalsIgnoreCase(a.c)) {
            return true;
        }
        return z;
    }

    public double getDouble(String str, String str2, double d) {
        Object objInnerGet = innerGet(str, str2);
        if (objInnerGet == null) {
            return d;
        }
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).doubleValue() : Double.parseDouble((String) objInnerGet);
        } catch (Exception unused) {
            return d;
        }
    }

    public int getInt(String str, String str2, int i) {
        Object objInnerGet = innerGet(str, str2);
        if (objInnerGet == null) {
            return i;
        }
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).intValue() : Integer.parseInt((String) objInnerGet);
        } catch (Exception unused) {
            return i;
        }
    }

    public long getLong(String str, String str2, long j) {
        Object objInnerGet = innerGet(str, str2);
        if (objInnerGet == null) {
            return j;
        }
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).longValue() : Long.parseLong((String) objInnerGet);
        } catch (Exception unused) {
            return j;
        }
    }

    public String getString(String str, String str2, String str3) {
        Object objInnerGet = innerGet(str, str2);
        return objInnerGet == null ? str3 : objInnerGet.toString();
    }
}
