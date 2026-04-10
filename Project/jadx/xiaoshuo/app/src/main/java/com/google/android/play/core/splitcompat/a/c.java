package com.google.android.play.core.splitcompat.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.splitcompat.c f6933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.core.splitcompat.c.b f6934b;
    private final Context c;

    public c(Context context, com.google.android.play.core.splitcompat.c cVar, com.google.android.play.core.splitcompat.c.b bVar) {
        this.f6933a = cVar;
        this.f6934b = bVar;
        this.c = context;
    }

    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    private final Signature[] b() {
        try {
            return this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean a() {
        ArrayList arrayList;
        try {
            File fileB = this.f6933a.b();
            Signature[] signatureArrB = b();
            if (signatureArrB == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Signature signature : signatureArrB) {
                    X509Certificate x509CertificateA = a(signature);
                    if (x509CertificateA != null) {
                        arrayList2.add(x509CertificateA);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            for (File file : fileB.listFiles()) {
                try {
                    if (!a(file.getAbsolutePath(), arrayList)) {
                        Log.e("SplitCompat", "Split verification failure.");
                        return false;
                    }
                    try {
                        file.renameTo(this.f6933a.a(file));
                    } catch (IOException e) {
                        Log.e("SplitCompat", "Cannot write verified split.", e);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.e("SplitCompat", "Split verification error.", e2);
                    return false;
                }
            }
            return true;
        } catch (IOException e3) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e3);
            return false;
        }
    }

    private final boolean a(String str, List<X509Certificate> list) {
        boolean z;
        try {
            X509Certificate[][] x509CertificateArrA = com.google.android.play.core.splitcompat.c.b.a(str);
            if (x509CertificateArrA == null || x509CertificateArrA.length == 0 || x509CertificateArrA[0].length == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 32);
                sb.append("Downloaded split ");
                sb.append(str);
                sb.append(" is not signed.");
                Log.e("SplitCompat", sb.toString());
                return false;
            }
            if (list.isEmpty()) {
                Log.e("SplitCompat", "No certificates found for app.");
                return false;
            }
            Iterator<X509Certificate> it = list.iterator();
            do {
                z = true;
                if (!it.hasNext()) {
                    return true;
                }
                X509Certificate next = it.next();
                int length = x509CertificateArrA.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (x509CertificateArrA[i][0].equals(next)) {
                        break;
                    }
                    i++;
                }
            } while (z);
            Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
            return false;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32);
            sb2.append("Downloaded split ");
            sb2.append(str);
            sb2.append(" is not signed.");
            Log.e("SplitCompat", sb2.toString(), e);
            return false;
        }
    }
}
