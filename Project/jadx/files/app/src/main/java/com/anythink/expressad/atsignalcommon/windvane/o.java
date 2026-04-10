package com.anythink.expressad.atsignalcommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class o extends WebChromeClient {
    private static final String b = "H5_ENTRY";
    WindVaneWebView a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f8339c;

    public o(WindVaneWebView windVaneWebView) {
        this.a = windVaneWebView;
    }

    public final void a(e eVar) {
        this.f8339c = eVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        d signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication != null && consoleMessage != null) {
            String strMessage = consoleMessage.message();
            if (TextUtils.isEmpty(strMessage) || !strMessage.startsWith("mv://")) {
                return false;
            }
            com.anythink.expressad.foundation.h.o.a(b, "onConsoleMessage: message.length() = " + strMessage.length() + " " + strMessage);
            if (strMessage.contains("wv_hybrid:") && signalCommunication.a("wv_hybrid:")) {
                String strSubstring = strMessage.substring(0, strMessage.lastIndexOf(" ") + 1);
                com.anythink.expressad.foundation.h.o.a(b, "message = ".concat(String.valueOf(strSubstring)));
                signalCommunication.c(strSubstring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        com.anythink.expressad.foundation.h.o.d(b, String.valueOf(str2));
        d signalCommunication = this.a.getSignalCommunication();
        if (signalCommunication == null || str3 == null || !signalCommunication.a(str3)) {
            return false;
        }
        signalCommunication.c(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        e eVar = this.f8339c;
        if (eVar != null) {
            eVar.onProgressChanged(webView, i2);
        }
    }
}
