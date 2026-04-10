package com.yuewen;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Process;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class yg3 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20348a;

        /* JADX INFO: renamed from: com.yuewen.yg3$a$a, reason: collision with other inner class name */
        public class RunnableC0782a implements Runnable {
            public RunnableC0782a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.killProcess(Process.myPid());
            }
        }

        public a(Context context) {
            this.f20348a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (yg3.c().b(this.f20348a)) {
                return;
            }
            rv1.k(new RunnableC0782a());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f20350a = "MD5";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f20351b = "SHA1";
        public static final String c = "12f8f1807daa34e278199985459ffff3";
        public static final String d = "e24e71701c0581158159182a0ba98af2d146e35";

        public static String a(Signature signature, String str) throws NoSuchAlgorithmException {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(signature.toByteArray());
            return new BigInteger(1, messageDigest.digest()).toString(16).toLowerCase();
        }

        public boolean b(Context context) {
            try {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                boolean z = false;
                for (Signature signature : signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory()) {
                    z = c.equals(a(signature, "MD5")) && d.equals(a(signature, f20351b));
                    if (z) {
                        break;
                    }
                }
                return z;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static void b(Context context) {
        cl2.r(new a(context));
    }

    public static b c() {
        return new b();
    }
}
