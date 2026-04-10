package com.mibi.sdk.common;

import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.yuewen.w51;
import java.io.Serializable;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes13.dex */
public class SortedParameter implements Serializable {
    protected TreeMap<String, Object> mParams;

    public SortedParameter() {
        this.mParams = new TreeMap<>();
    }

    private Object innerGet(String str) {
        return this.mParams.get(str);
    }

    public SortedParameter add(String str, Object obj) {
        if (obj == null) {
            obj = "";
        }
        this.mParams.put(str, obj);
        return this;
    }

    public SortedParameter addAll(SortedParameter sortedParameter) {
        if (sortedParameter != null) {
            this.mParams.putAll(sortedParameter.mParams);
        }
        return this;
    }

    public <T> T get(String str) {
        try {
            return (T) this.mParams.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, w51.l);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public TreeMap<String, Object> getParams() {
        return this.mParams;
    }

    public <T extends Serializable> T getSerializable(String str) {
        Object objInnerGet = innerGet(str);
        if (objInnerGet == null) {
            return null;
        }
        try {
            return (T) objInnerGet;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public boolean has(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean isEmpty() {
        return this.mParams.isEmpty();
    }

    public String toString() {
        return this.mParams.toString();
    }

    public boolean getBoolean(String str, boolean z) {
        Object objInnerGet = innerGet(str);
        if (objInnerGet == null) {
            return z;
        }
        try {
            if (objInnerGet.equals(Boolean.FALSE)) {
                return false;
            }
            if ((objInnerGet instanceof String) && ((String) objInnerGet).equalsIgnoreCase(MscKeys.VAL_FALSE)) {
                return false;
            }
            if (objInnerGet.equals(Boolean.TRUE)) {
                return true;
            }
            if (objInnerGet instanceof String) {
                if (((String) objInnerGet).equalsIgnoreCase(a.c)) {
                    return true;
                }
            }
            return z;
        } catch (Exception unused) {
            return z;
        }
    }

    public double getDouble(String str, double d) {
        Object objInnerGet = innerGet(str);
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).doubleValue() : Double.parseDouble((String) objInnerGet);
        } catch (Exception unused) {
            return d;
        }
    }

    public int getInt(String str, int i) {
        Object objInnerGet = innerGet(str);
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).intValue() : Integer.parseInt((String) objInnerGet);
        } catch (Exception unused) {
            return i;
        }
    }

    public long getLong(String str, long j) {
        Object objInnerGet = innerGet(str);
        try {
            return objInnerGet instanceof Number ? ((Number) objInnerGet).longValue() : Long.parseLong((String) objInnerGet);
        } catch (Exception unused) {
            return j;
        }
    }

    public String getString(String str, String str2) {
        Object objInnerGet = innerGet(str);
        return objInnerGet == null ? str2 : objInnerGet.toString();
    }

    public SortedParameter(String str, Object obj) {
        this();
        add(str, obj);
    }
}
