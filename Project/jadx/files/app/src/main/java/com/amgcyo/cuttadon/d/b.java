package com.amgcyo.cuttadon.d;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.other.DnsResult;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.fatcatfat.io.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.record.Record;
import org.minidns.record.h;

/* JADX INFO: compiled from: DnsLookupAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends AsyncTask<String, Void, DnsResult> {
    private final WeakReference<a> a;

    public b(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DnsResult doInBackground(String... strArr) {
        if (TextUtils.isEmpty("nmgrygc.com")) {
            return new DnsResult(107, "main domain is empty.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = strArr[0];
        String str2 = "参数长度：" + strArr.length;
        String str3 = strArr.length >= 2 ? strArr[1] : DnsResult.TXT;
        MkApplication appContext = MkApplication.getAppContext();
        try {
            Class clsF = Record.TYPE.valueOf(str3).f();
            if (clsF == null) {
                return a(str3, appContext, 101, R.string.unsuppRecType);
            }
            org.minidns.hla.b bVarA = org.minidns.hla.a.b.a(str, clsF);
            if (!bVarA.g()) {
                return new DnsResult(102, appContext.getResources().getString(R.string.lookupTypeFail, str3, bVarA.d()));
            }
            Set setA = bVarA.a();
            if (setA.isEmpty()) {
                return a(str3, appContext, 104, R.string.noRecords);
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = setA.iterator();
            while (it.hasNext()) {
                sb.append((h) it.next());
            }
            String string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                return a(str3, appContext, 105, R.string.noRecords);
            }
            try {
                DnsMessage dnsMessageB = bVarA.b();
                long jE = dnsMessageB.e();
                String strReplaceAll = string.replaceAll("\"", "");
                String strA = com.amgcyo.cuttadon.utils.comic.b.a(new Base64Bean(strReplaceAll));
                String str4 = "\n接收时间：" + t0.d(dnsMessageB.f21429p) + "，耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "毫秒；\n原内容：\n" + strReplaceAll + "\n解密后：\n" + strA;
                return new DnsResult(jE, 100, strA, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return new DnsResult(106, appContext.getResources().getString(R.string.lookupErr, str3, e2.getMessage()));
            }
        } catch (IOException e3) {
            return new DnsResult(103, appContext.getResources().getString(R.string.lookupErr, str3, e3.getMessage()));
        }
    }

    @NotNull
    private DnsResult a(String str, Context context, int i2, int i3) {
        return new DnsResult(i2, context.getResources().getString(i3, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(DnsResult dnsResult) {
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.processFinish(dnsResult);
        }
    }
}
