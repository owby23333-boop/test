package com.iflytek.aikit.media.param;

import android.text.TextUtils;
import com.duokan.dksearch.ui.b;
import com.duokan.reader.domain.payment.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class HashParam {
    HashMap<String, String> kparam = new HashMap<>();

    public HashParam() {
    }

    public static boolean parseBoolean(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equals(a.c) || str.equals("1")) {
            return true;
        }
        if (str.equals(MscKeys.VAL_FALSE) || str.equals("0")) {
            return false;
        }
        return z;
    }

    public static int parseInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long parseLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public static String trimInvalid(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("[,\n ]", b.e.t);
    }

    public void clear() {
        this.kparam.clear();
    }

    public boolean getBoolean(String str, boolean z) {
        return parseBoolean(this.kparam.get(str), z);
    }

    public HashMap<String, String> getHash() {
        return this.kparam;
    }

    public int getInt(String str, int i) {
        return parseInt(this.kparam.get(str), i);
    }

    public long getLong(String str, long j) {
        return parseLong(this.kparam.get(str), j);
    }

    public String getString(String str) {
        return this.kparam.get(str);
    }

    public boolean hasKey(String str) {
        return this.kparam.containsKey(str);
    }

    public void initWithParam(String str) {
        this.kparam.clear();
        putMultiParam(str);
    }

    public boolean isEmpty() {
        return this.kparam.isEmpty();
    }

    public void putHash(HashParam hashParam) {
        if (hashParam != null) {
            this.kparam.putAll(hashParam.getHash());
        }
    }

    public void putMultiParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(",")) {
            int iIndexOf = str2.indexOf(MscKeys.KEY_VAL_SEP);
            if (iIndexOf > 0 && iIndexOf < str2.length()) {
                this.kparam.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
            }
        }
    }

    public void putParam(String str, String str2) {
        putParam(str, str2, true);
    }

    public String remove(String str) {
        return this.kparam.remove(str);
    }

    public Boolean removeParam(String str) {
        return Boolean.valueOf(this.kparam.remove(str) != null);
    }

    public void replaceKey(String[][] strArr) {
        if (strArr == null) {
            return;
        }
        for (String[] strArr2 : strArr) {
            if (this.kparam.containsKey(strArr2[0])) {
                String str = this.kparam.get(strArr2[0]);
                this.kparam.remove(strArr2[0]);
                for (int i = 1; i < strArr2.length; i++) {
                    this.kparam.put(strArr2[i], str);
                }
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.kparam.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(MscKeys.KEY_VAL_SEP);
            stringBuffer.append(entry.getValue());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public void trimParam() {
        for (Map.Entry<String, String> entry : this.kparam.entrySet()) {
            entry.setValue(trimInvalid(entry.getValue()));
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HashParam m103clone() {
        HashParam hashParam = new HashParam();
        hashParam.kparam = (HashMap) this.kparam.clone();
        return hashParam;
    }

    public String getString(String str, String str2) {
        String str3 = this.kparam.get(str);
        return str3 == null ? str2 : str3;
    }

    public void putParam(HashParam hashParam, String str) {
        if (hashParam == null) {
            return;
        }
        putParam(str, hashParam.getString(str));
    }

    public HashParam(String str, String[][] strArr) {
        initWithParam(str);
        replaceKey(strArr);
    }

    public void putParam(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z || !this.kparam.containsKey(str)) {
            this.kparam.put(str, str2);
        }
    }
}
