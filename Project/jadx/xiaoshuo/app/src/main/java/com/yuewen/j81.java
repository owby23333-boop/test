package com.yuewen;

import android.text.TextUtils;
import android.util.Base64;
import com.duokan.kernel.filterlib.DkfLib;
import com.iflytek.aikit.media.param.MscKeys;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class j81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12849a = "24d18b700592cc55775b2ae16886e842";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12850b = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIyRSAKqBHhNYsTJkjTIfNac+u1tJKFydY3UnExuOnkkq1iEtKAkIKQtJTRKWFKHfm954Z+1hG7uihQubs7sH5Qtk75XpbuzRy6A/C8OB1Fwl//tLUMBNP4nsdp/k5YamWF9g5qkvPL9cZi71Ofnwa62gAgRLViq0/m5F8w2Iu3fAgMBAAECgYB1Nk/NqOfBSQYrAcogqW0vqAa1JGV/GmpbsgYC1Yd8rM8UKNRVFMsDG4ICcFvltYYAfqlc+4dK2S3aVj2f3dUWBd6UcweSBhsqDUCYdop7K02yA2Z8nZXAuLzL23/8Gsx9F1In+IgL9UQzvfrQjEzFjfHzmJZqQFub5XtqfwShAQJBAMFzz+8uoOYoxzjG+oblGgz7OOS2QiLINjgmtdRPGB3Q5bOE1NldbLajwQ69e9Dsj/64HLp/BUCU3rzJ+RWFi28CQQC6BCaKNmWm8ZTGtxIqjbpENAtFqUJIgkze9ASDVl7Bt8UJhVpgAPN1FiEeietACAqeL97/PVJfFq+mCXfchkyRAkBpGVdNlaKaiGr7wLaZFNzbUp0tPIufw/AY/4bnqnTqtfQlXLQax3Ppofuf23fqIKt2cmZBOAMNfBOqs3wcoioHAkAjwHB32ASplXz2xHDlZOAMA8S22tU2gnSr1VKYu5zytpNURSEdmpEwS9SJvhBM+j6wMJs3i12tkPqpeuBirh1BAkBzjSToWmon3wJsNXgk+VNHAhqrLitvvuG0ZBJl7hwOiubhwktAa01AnMqHQ3rFkI6KHVvF0VMlrBftB0UquYMg";
    public static Comparator<v52> c = new a();

    public class a implements Comparator<v52> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(v52 v52Var, v52 v52Var2) {
            return v52Var.getName().compareTo(v52Var2.getName());
        }
    }

    public static String a(List<v52<String>> list, String str) {
        try {
            LinkedList<v52> linkedList = new LinkedList(list);
            Collections.sort(linkedList, c);
            if (!TextUtils.isEmpty(str)) {
                linkedList.add(new v52("uid", str));
            }
            linkedList.add(new v52("key", f12849a));
            StringBuilder sb = new StringBuilder();
            for (v52 v52Var : linkedList) {
                sb.append(v52Var.getName());
                sb.append(MscKeys.KEY_VAL_SEP);
                sb.append(v52Var.a());
                sb.append(com.alipay.sdk.m.w.a.p);
            }
            sb.deleteCharAt(sb.length() - 1);
            return od0.a(DkfLib.md5Encode(sb.toString().getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(List<v52<String>> list, String str) {
        try {
            LinkedList<v52> linkedList = new LinkedList(list);
            Collections.sort(linkedList, c);
            if (!TextUtils.isEmpty(str)) {
                linkedList.add(new v52("uid", str));
            }
            StringBuilder sb = new StringBuilder();
            for (v52 v52Var : linkedList) {
                sb.append(v52Var.getName());
                sb.append(MscKeys.KEY_VAL_SEP);
                sb.append(v52Var.a());
                sb.append(com.alipay.sdk.m.w.a.p);
            }
            sb.deleteCharAt(sb.length() - 1);
            String string = sb.toString();
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(f12850b, 0)));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(privateKeyGeneratePrivate);
            signature.update(string.getBytes("UTF-8"));
            return Base64.encodeToString(signature.sign(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
