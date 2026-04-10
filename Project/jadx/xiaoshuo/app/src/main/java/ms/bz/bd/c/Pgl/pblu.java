package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import ms.bz.bd.c.Pgl.pblt;

/* JADX INFO: loaded from: classes9.dex */
public class pblu {
    protected final pblt.pblb bf;
    protected final pblt.pgla d;
    protected final Set<String> e = new HashSet();

    public class pgla implements Runnable {
        final /* synthetic */ String bf;
        final /* synthetic */ String d;
        final /* synthetic */ Context e;
        final /* synthetic */ pblt.pblc tg;

        public pgla(Context context, String str, String str2, pblt.pblc pblcVar) {
            this.e = context;
            this.bf = str;
            this.d = str2;
            this.tg = pblcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                pblu.this.bf(this.e, this.bf, this.d);
                this.tg.e();
            } catch (UnsatisfiedLinkError | pbls e) {
                this.tg.e(e);
            }
        }
    }

    public pblu(pblt.pblb pblbVar, pblt.pgla pglaVar) {
        this.bf = pblbVar;
        this.d = pglaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(Context context, String str, String str2) throws Throwable {
        String[] strArr;
        if (this.e.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((pblw) this.bf).getClass();
            System.loadLibrary(str);
            this.e.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileE = e(context, str, str2);
            if (!fileE.exists()) {
                File fileE2 = e(context);
                File fileE3 = e(context, str, str2);
                File[] fileArrListFiles = fileE2.listFiles(new pblv(this, ((pblw) this.bf).e(str)));
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (!file.getAbsolutePath().equals(fileE3.getAbsolutePath())) {
                            file.delete();
                        }
                    }
                }
                pblt.pgla pglaVar = this.d;
                ((pblw) this.bf).getClass();
                String[] strArr2 = Build.SUPPORTED_ABIS;
                if (strArr2.length > 0) {
                    strArr = strArr2;
                    ((pblr) pglaVar).e(context, strArr, ((pblw) this.bf).e(str), fileE, this);
                } else {
                    String str3 = Build.CPU_ABI2;
                    if (pblt.e(str3)) {
                        strArr2 = new String[]{Build.CPU_ABI};
                        strArr = strArr2;
                        ((pblr) pglaVar).e(context, strArr, ((pblw) this.bf).e(str), fileE, this);
                    } else {
                        strArr = new String[]{Build.CPU_ABI, str3};
                        ((pblr) pglaVar).e(context, strArr, ((pblw) this.bf).e(str), fileE, this);
                    }
                }
            }
            pblt.pblb pblbVar = this.bf;
            String absolutePath = fileE.getAbsolutePath();
            ((pblw) pblbVar).getClass();
            System.load(absolutePath);
            this.e.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }

    public File e(Context context) {
        return context.getDir("lib", 0);
    }

    public File e(Context context, String str, String str2) {
        String strE = ((pblw) this.bf).e(str);
        if (pblt.e(str2)) {
            return new File(e(context), strE);
        }
        return new File(e(context), strE + Consts.DOT + str2);
    }

    public void e(Context context, String str, String str2, pblt.pblc pblcVar) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (pblt.e(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        String.format(Locale.US, "Beginning load of %s...", str);
        if (pblcVar == null) {
            bf(context, str, str2);
        } else {
            new Thread(new pgla(context, str, str2, pblcVar)).start();
        }
    }
}
