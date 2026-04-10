package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static DexClassLoader b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Looper f19204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f19205d;
    public String a;

    public interface a {
        void a();

        void a(int i2);

        void a(Throwable th);
    }

    private d(Context context) {
        this.a = "";
        this.a = context.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin";
    }

    public static d a(Context context) {
        if (f19205d == null) {
            f19205d = new d(context);
        }
        return f19205d;
    }

    @SuppressLint({"NewApi"})
    public static void a(final String str, final a aVar) {
        new Thread() { // from class: com.tencent.smtt.utils.d.2
            /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|54|3|59|4|(4:5|(1:7)(1:61)|53|32)|8|49|9|13|53|32|(1:(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
            
                r1.printStackTrace();
             */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws java.lang.Throwable {
                /*
                    r9 = this;
                    r0 = 0
                    java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    java.lang.String r2 = "https://tbs.imtt.qq.com/plugin/DebugPlugin_v2.tbs"
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    int r2 = r1.getContentLength()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    r3 = 5000(0x1388, float:7.006E-42)
                    r1.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    r1.connect()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
                    java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    java.lang.String r4 = r1     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r3.<init>(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    java.io.FileOutputStream r0 = com.tencent.smtt.utils.FileUtil.d(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r3 = 8192(0x2000, float:1.148E-41)
                    byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r4 = 0
                    r5 = 0
                L2f:
                    int r6 = r1.read(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    if (r6 <= 0) goto L42
                    int r5 = r5 + r6
                    r0.write(r3, r4, r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    int r6 = r5 * 100
                    int r6 = r6 / r2
                    com.tencent.smtt.utils.d$a r7 = r2     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r7.a(r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    goto L2f
                L42:
                    com.tencent.smtt.utils.d$a r2 = r2     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r2.a()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
                    r1.close()     // Catch: java.lang.Exception -> L4b
                    goto L4f
                L4b:
                    r1 = move-exception
                    r1.printStackTrace()
                L4f:
                    r0.close()     // Catch: java.lang.Exception -> L76
                    goto L7a
                L53:
                    r2 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                    goto L7c
                L58:
                    r2 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                    goto L62
                L5d:
                    r2 = move-exception
                    r1 = r0
                    goto L7c
                L60:
                    r2 = move-exception
                    r1 = r0
                L62:
                    r2.printStackTrace()     // Catch: java.lang.Throwable -> L7b
                    com.tencent.smtt.utils.d$a r3 = r2     // Catch: java.lang.Throwable -> L7b
                    r3.a(r2)     // Catch: java.lang.Throwable -> L7b
                    r0.close()     // Catch: java.lang.Exception -> L6e
                    goto L72
                L6e:
                    r0 = move-exception
                    r0.printStackTrace()
                L72:
                    r1.close()     // Catch: java.lang.Exception -> L76
                    goto L7a
                L76:
                    r0 = move-exception
                    r0.printStackTrace()
                L7a:
                    return
                L7b:
                    r2 = move-exception
                L7c:
                    r0.close()     // Catch: java.lang.Exception -> L80
                    goto L84
                L80:
                    r0 = move-exception
                    r0.printStackTrace()
                L84:
                    r1.close()     // Catch: java.lang.Exception -> L88
                    goto L8c
                L88:
                    r0 = move-exception
                    r0.printStackTrace()
                L8c:
                    goto L8e
                L8d:
                    throw r2
                L8e:
                    goto L8d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.d.AnonymousClass2.run():void");
            }
        }.start();
    }

    public void a(final String str, final WebView webView, final Context context) {
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        final TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        String str2 = this.a + File.separator + "DebugPlugin.tbs";
        FileUtil.b(new File(str2));
        a(str2, new a() { // from class: com.tencent.smtt.utils.d.1
            @Override // com.tencent.smtt.utils.d.a
            public void a() {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "下载成功", 0).show();
                        relativeLayout.setVisibility(4);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        d.this.a(str, webView, context, d.f19204c);
                    }
                });
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(final int i2) {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        textView.setText("已下载" + i2 + "%");
                    }
                });
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(Throwable th) {
                webView.post(new Runnable() { // from class: com.tencent.smtt.utils.d.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "下载失败，请检查网络", 0).show();
                    }
                });
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void a(String str, WebView webView, Context context, Looper looper) {
        TbsLog.i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        String str2 = this.a + File.separator + "DebugPlugin.tbs";
        String str3 = this.a + File.separator + "DebugPlugin.apk";
        File file = new File(str2);
        File file2 = new File(str3);
        f19204c = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (!file2.exists()) {
            TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
            a(str, webView, context);
            return;
        }
        try {
            String strA = b.a(context, true, new File(str3));
            if (!"308202fb308201e3a0030201020204375ef026300d06092a864886f70d01010b0500302e310b3009060355040613023836311f301d0603550403131674656e63656e7462726f7773696e6773657276696365301e170d3232303531383038333632345a170d3437303531323038333632345a302e310b3009060355040613023836311f301d0603550403131674656e63656e7462726f7773696e677365727669636530820122300d06092a864886f70d01010105000382010f003082010a0282010100c85799a78f706304be13eba6b9d824cf61f3bc15bf0536fb7272c0d93dd0e6574249cf13e0120e843a5b3d25c2ca899d175e0689633f4aac7de14011073fd35266d342e7da9a9f7ecd20872a1183556d5ef9a4b0a53f59cec0d877ea9472b974d1a4902d0031d3b6ace2a06a4fc3475cf8c5b759e9b5c1c6c252b6698a940971c81ff25e6e16e998f102128649db8465786dacd1adbadba0e1673099596eefa51ba245106d6e4121d83ef1540e546dbbabda80a1763094bc12abe5b667c7619ba194043c204ccd60a4b23ed9283cbb19d69f5a662b55f855d11048f9c91834b4849e711ae486c3337ae7cfa2dde3cb0e70c5e1ef30db86e3a9ec02ee3be90b690203010001a321301f301d0603551d0e041604148c544df62af09c37c889982a833dd664abc7ab63300d06092a864886f70d01010b050003820101003d67c21bcbc4d5ba11727a85157df542d35de5f0ead38aa3ee65017298ed5e9692f71993a44e7ece954da1314450324e6b93f0cd927b1ff836d1ff237c13e4a226a4d1d66d0f73681ee90b0a71606726799c4cb350d4c97e38076d27039762b5b117eaabc2fb2f8adaa0ca5be5b336dfbc47e3390803fadf3d62f208f5c5b213f113a77b59bf9a0706390e0963e11f9fa622b4091f7189ffa56042ba3d21b5299ecdc533eee59471169b20927288c5331e13c526918487664443cb7e6a40d6d7df3a17386c323ebf3b4066f73aee5c7381f52f0388c48b5a6e45bc6a524ca9f028a7428dc72388857a3acd56e6cf8458463cdb53b1547a272f2613970763ec12".equals(strA)) {
                TbsLog.e("debugtbs", "verifyPlugin apk: " + str3 + " signature failed - sig: " + strA);
                Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                return;
            }
            String str4 = this.a + File.separator + "opt";
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            if (b == null) {
                b = new DexClassLoader(str3, str4, null, context.getClassLoader());
            }
            HashMap map = new HashMap();
            map.put("url", str);
            map.put("tbs_version", "" + WebView.getTbsSDKVersion(context));
            map.put("tbs_core_version", "" + WebView.getTbsCoreVersion(context));
            if (f19204c != null) {
                map.put("looper", looper);
            }
            Object objNewInstance = b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(Context.class, Map.class).newInstance(context, map);
            if (!(objNewInstance instanceof FrameLayout)) {
                TbsLog.e("debugtbs", "get debugview failure: " + objNewInstance);
                return;
            }
            FrameLayout frameLayout = (FrameLayout) objNewInstance;
            webView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.i("debugtbs", "show " + frameLayout + " successful in " + webView);
        } catch (Exception e2) {
            FileUtil.b(file2);
            e2.printStackTrace();
        }
    }
}
