package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.b.c;
import com.anythink.expressad.atsignalcommon.mraid.MraidUriUtil;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Handler.Callback, d {
    protected Pattern a;
    protected String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f8332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected WindVaneWebView f8333e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f8331c = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Handler f8334f = new Handler(Looper.getMainLooper(), this);

    public m(Context context) {
        this.f8332d = context;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final WebView a() {
        return this.f8333e;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final a b(String str) {
        if (str == null) {
            return null;
        }
        a mraidMethodContext = MraidUriUtil.getMraidMethodContext(this.f8333e, str);
        if (mraidMethodContext != null) {
            mraidMethodContext.a = this.f8333e;
            return mraidMethodContext;
        }
        Matcher matcher = this.a.matcher(str);
        if (matcher.matches()) {
            a aVar = new a();
            int iGroupCount = matcher.groupCount();
            if (iGroupCount >= 5) {
                aVar.f8313f = matcher.group(5);
            }
            if (iGroupCount >= 3) {
                aVar.f8311d = matcher.group(1);
                aVar.f8314g = matcher.group(2);
                aVar.f8312e = matcher.group(3);
                HashMap<String, String> map = com.anythink.expressad.atsignalcommon.base.e.f8271k;
                if (map != null && map.containsKey(aVar.f8312e)) {
                    aVar.f8312e = com.anythink.expressad.atsignalcommon.base.e.f8271k.get(aVar.f8312e);
                }
                aVar.a = this.f8333e;
                return aVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.atsignalcommon.windvane.m.c(java.lang.String):void");
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void d(String str) {
        this.b = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what == 1) {
                Object obj = aVar.b;
                c.f fVar = aVar.f8310c;
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = TextUtils.isEmpty(aVar.f8313f) ? "{}" : aVar.f8313f;
                fVar.a(obj, objArr);
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(WindVaneWebView windVaneWebView) {
        this.f8333e = windVaneWebView;
    }

    private void a(a aVar) {
        WindVaneWebView windVaneWebView = aVar.a;
        Object jsObject = windVaneWebView == null ? null : windVaneWebView.getJsObject(aVar.f8311d);
        if (jsObject == null) {
            return;
        }
        try {
            c.f fVarA = com.anythink.expressad.atsignalcommon.b.c.a(this.f8332d.getClassLoader(), jsObject.getClass().getName()).a(aVar.f8312e, Object.class, String.class);
            fVarA.a();
            if (jsObject == null || !(jsObject instanceof l)) {
                return;
            }
            aVar.b = jsObject;
            aVar.f8310c = fVarA;
            aVar.b = jsObject;
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = aVar;
            this.f8334f.sendMessage(messageObtain);
        } catch (c.b.a e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void b(a aVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = aVar;
        this.f8334f.sendMessage(messageObtain);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final String b() {
        return this.b;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final void a(Pattern pattern) {
        this.a = pattern;
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.d
    public final boolean a(String str) {
        if (!n.a(str)) {
            return false;
        }
        this.a = n.b(str);
        this.b = str;
        return true;
    }
}
