package com.yuewen;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import miuix.security.DigestUtils;

/* JADX INFO: loaded from: classes10.dex */
public class cl3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9699a = "UTF-8";

    @Deprecated
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(DigestUtils.ALGORITHM_SHA_1);
            byte[] bytes = str.getBytes("iso-8859-1");
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2, TreeMap<String, String> treeMap, String str3) {
        HashSet hashSet = new HashSet();
        hashSet.add("_nonce");
        return c(str, str2, treeMap, str3, hashSet);
    }

    public static String c(String str, String str2, TreeMap<String, String> treeMap, String str3, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str.toUpperCase());
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (treeMap != null && !treeMap.keySet().isEmpty()) {
            for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                boolean z = set != null && set.contains(entry.getKey());
                if (entry.getValue() != null && !z) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        return a(TextUtils.join(com.alipay.sdk.m.w.a.p, arrayList.toArray()));
    }

    public static String d(TreeMap<String, String> treeMap, String str) {
        return b(null, null, treeMap, str);
    }
}
