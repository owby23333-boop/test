package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static int a(String str, int i2) {
        try {
            long j2 = Long.parseLong(str);
            if (j2 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j2 < 0) {
                return 0;
            }
            return (int) j2;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static long a(a0 a0Var) {
        return a(a0Var.m());
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.a) {
            return;
        }
        List<l> listA = l.a(sVar, rVar);
        if (listA.isEmpty()) {
            return;
        }
        mVar.a(sVar, listA);
    }

    public static int b(String str, int i2) {
        char cCharAt;
        while (i2 < str.length() && ((cCharAt = str.charAt(i2)) == ' ' || cCharAt == '\t')) {
            i2++;
        }
        return i2;
    }

    public static boolean b(a0 a0Var) {
        int iK;
        return (a0Var.s().e().equals("HEAD") || ((((iK = a0Var.k()) >= 100 && iK < 200) || iK == 204 || iK == 304) && a(a0Var) == -1 && !DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(a0Var.b(DownloadUtils.TRANSFER_ENCODING)))) ? false : true;
    }
}
