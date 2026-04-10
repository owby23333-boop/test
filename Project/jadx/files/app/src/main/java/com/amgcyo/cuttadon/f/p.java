package com.amgcyo.cuttadon.f;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.activity.main.MkBackflowActivity;
import com.amgcyo.cuttadon.utils.otherutils.ChapterException;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.google.gson.JsonParseException;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Locale;
import me.jessyan.art.base.convert.ApiException;
import okhttp3.HttpUrl;
import org.json.JSONException;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.CustomTimeoutThrowable;

/* JADX INFO: compiled from: ErrorHandleSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p<T> extends DisposableObserver<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private me.jessyan.art.e.a f3713s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f3714t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f3715u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f3716v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private me.jessyan.art.mvp.e f3717w;

    /* JADX INFO: compiled from: ErrorHandleSubscriber.java */
    class a extends com.amgcyo.cuttadon.j.g.h.b<String> {
        a(String str) {
            super(str);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(String str) {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.t("www.baidu.com")) {
                return null;
            }
            x0.c().a("[APP]网络错误");
            p.this.a(str);
            return null;
        }
    }

    protected p(me.jessyan.art.e.c cVar) {
        this.f3715u = true;
        if (cVar != null) {
            this.f3713s = cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        me.jessyan.art.mvp.e eVar = this.f3717w;
        if (eVar == null || !this.f3715u) {
            return;
        }
        eVar.hideLoading();
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        me.jessyan.art.mvp.e eVar = this.f3717w;
        if (eVar != null) {
            eVar.hideLoading();
        }
        a(th);
        me.jessyan.art.e.a aVar = this.f3713s;
        if (aVar != null) {
            aVar.a(th);
        } else {
            o.b("未知异常，请重新启动app");
        }
    }

    @Override // io.reactivex.observers.DisposableObserver
    protected void onStart() {
        me.jessyan.art.mvp.e eVar = this.f3717w;
        if (eVar != null) {
            eVar.showLoading("努力加载中...");
        }
    }

    private void a(Throwable th) {
        String string;
        String str;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        Context contextA = this.f3713s.a();
        String strA = "请求数据超时,请检查网络设置!";
        if (th instanceof UnknownHostException) {
            strA = com.amgcyo.cuttadon.utils.otherutils.g.q0() ? "未知主机异常，如果持续出现，请重新启动APP!" : "网络不可用,请检查网络设置!";
            com.amgcyo.cuttadon.utils.otherutils.h.a();
            string = this.f3716v + strA;
        } else if (th instanceof CustomTimeoutThrowable) {
            Call call = ((CustomTimeoutThrowable) th).call;
            if (call != null) {
                HttpUrl httpUrlUrl = call.request().url();
                if (TextUtils.isEmpty(this.f3716v)) {
                    string = "超时虚假url：" + httpUrlUrl.getUrl() + stringWriter.toString();
                } else {
                    String strK = com.amgcyo.cuttadon.utils.otherutils.g.k();
                    HttpUrl httpUrlA = me.jessyan.retrofiturlmanager.a.f().a(this.f3716v);
                    if (httpUrlA != null) {
                        String url = httpUrlA.getUrl();
                        StringBuilder sb = new StringBuilder();
                        sb.append("超时真实url：");
                        sb.append(httpUrlUrl.getUrl().replace(strK, url + "\n" + stringWriter.toString()));
                        string = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("超时真实url：");
                        sb2.append(httpUrlUrl.getUrl().replace(strK, "\n" + stringWriter.toString()));
                        string = sb2.toString();
                    }
                }
            } else {
                string = "请求数据超时,请检查网络设置!" + stringWriter.toString();
            }
            String str2 = "errorMsg:" + string;
        } else if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            strA = me.jessyan.art.f.e.a(httpException);
            try {
                Response<?> response = httpException.response();
                if (response != null) {
                    string = strA + String.format(Locale.getDefault(), " \n请求url:%s  请求code码：%d", response.raw().request().url(), Integer.valueOf(httpException.code()));
                } else {
                    string = strA + "请求code码" + httpException.code();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                string = strA + stringWriter.toString();
            }
        } else if ((th instanceof JsonParseException) || (th instanceof ParseException) || (th instanceof JSONException)) {
            strA = "数据解析错误";
            string = "数据解析错误" + stringWriter.toString();
        } else {
            String message = th.getMessage();
            if (th instanceof ApiException) {
                ApiException apiException = (ApiException) th;
                int iF = apiException.f();
                if (iF == 20) {
                    String str3 = apiException.f() + " " + apiException.g();
                    r0.a(contextA, MkBackflowActivity.class, apiException.g(), iF);
                } else if (iF == 30) {
                    String str4 = t0.a() + "errorCode30Count";
                    int iA = g0.a().a(str4, 0);
                    if (iA < 2) {
                        String str5 = apiException.f() + " " + apiException.g();
                        r0.a(contextA, MkBackflowActivity.class, apiException.g(), iF);
                        g0.a().b(str4, iA + 1);
                    }
                } else if (iF == 634) {
                    r0.a(contextA, MkBackflowActivity.class, "您当前使用的版本已经停用，请访问App官网下载最新版本。", iF);
                }
                string = "";
                strA = message;
            } else if (th instanceof ChapterException) {
                strA = "章节内容请求失败!请检查网络设置!";
                string = "章节内容请求失败!请检查网络设置!" + stringWriter.toString();
            } else {
                if (message == null) {
                    str = null;
                    strA = null;
                } else if (message.contains("CustomTimeoutThrowable")) {
                    str = "请求数据超时,请检查网络设置!" + stringWriter.toString();
                } else {
                    String str6 = "未知异常：" + message;
                    str = str6 + stringWriter.toString();
                    strA = str6;
                }
                th.printStackTrace();
                string = str;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            string = this.f3714t + "\n" + string;
        }
        try {
            if (!TextUtils.isEmpty(string) && me.jessyan.art.f.f.a(contextA) && me.jessyan.art.f.f.b(contextA)) {
                com.amgcyo.cuttadon.j.g.b.a(new a(string));
            }
            o.b(strA);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    protected p(me.jessyan.art.e.c cVar, String str, String str2) {
        this.f3715u = true;
        if (cVar != null) {
            this.f3713s = cVar.a();
        }
        this.f3714t = str2;
        this.f3716v = str;
    }

    protected p(me.jessyan.art.mvp.e eVar, me.jessyan.art.e.c cVar, String str, String str2) {
        this.f3715u = true;
        if (cVar != null) {
            this.f3713s = cVar.a();
        }
        this.f3714t = str2;
        this.f3716v = str;
        this.f3717w = eVar;
    }

    protected p(me.jessyan.art.mvp.e eVar, boolean z2, me.jessyan.art.e.c cVar, String str, String str2) {
        this.f3715u = true;
        if (cVar != null) {
            this.f3713s = cVar.a();
        }
        this.f3714t = str2;
        this.f3716v = str;
        this.f3717w = eVar;
        this.f3715u = z2;
    }
}
