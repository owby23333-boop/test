package com.qmuiteam.qmui.widget.webview;

import android.util.Pair;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIWebViewBridgeHandler {
    private static final String MESSAGE_CALLBACK_ID = "callbackId";
    private static final String MESSAGE_CMD_GET_SUPPORTED_CMD_LIST = "getSupportedCmdList";
    private static final String MESSAGE_DATA = "data";
    private static final String MESSAGE_INNER_CMD_NAME = "__cmd__";
    private static final String MESSAGE_JS_FETCH_SCRIPT = "QMUIBridge._fetchQueueFromNative()";
    private static final String MESSAGE_JS_RESPONSE_SCRIPT = "QMUIBridge._handleResponseFromNative($data$)";
    private static final String MESSAGE_PARAM_HOLDER = "$data$";
    private List<Pair<String, ValueCallback<String>>> mStartupMessageList = new ArrayList();
    private WebView mWebView;

    protected abstract List<String> getSupportedCmdList();

    protected abstract void handleMessage(String str, MessageFinishCallback messageFinishCallback);

    public QMUIWebViewBridgeHandler(WebView webView) {
        this.mWebView = webView;
    }

    public final void evaluateBridgeScript(String str, ValueCallback<String> valueCallback) {
        List<Pair<String, ValueCallback<String>>> list = this.mStartupMessageList;
        if (list != null) {
            list.add(new Pair<>(str, valueCallback));
        } else {
            this.mWebView.evaluateJavascript(str, valueCallback);
        }
    }

    void onBridgeLoaded() {
        List<Pair<String, ValueCallback<String>>> list = this.mStartupMessageList;
        if (list != null) {
            for (Pair<String, ValueCallback<String>> pair : list) {
                this.mWebView.evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
            }
            this.mStartupMessageList = null;
        }
    }

    void fetchAndMessageFromJs() {
        this.mWebView.evaluateJavascript(MESSAGE_JS_FETCH_SCRIPT, new ValueCallback<String>() { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebViewBridgeHandler.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                String strUnescape = QMUIWebViewBridgeHandler.unescape(str);
                if (strUnescape != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(strUnescape);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string = jSONObject.getString(QMUIWebViewBridgeHandler.MESSAGE_CALLBACK_ID);
                            String string2 = jSONObject.getString("data");
                            MessageFinishCallback messageFinishCallback = new MessageFinishCallback(string) { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebViewBridgeHandler.1.1
                                {
                                    QMUIWebViewBridgeHandler qMUIWebViewBridgeHandler = QMUIWebViewBridgeHandler.this;
                                }

                                @Override // com.qmuiteam.qmui.widget.webview.QMUIWebViewBridgeHandler.MessageFinishCallback
                                public void finish(Object obj) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(QMUIWebViewBridgeHandler.MESSAGE_CALLBACK_ID, getCallbackId());
                                        jSONObject2.put("data", obj);
                                        QMUIWebViewBridgeHandler.this.mWebView.evaluateJavascript(QMUIWebViewBridgeHandler.MESSAGE_JS_RESPONSE_SCRIPT.replace(QMUIWebViewBridgeHandler.MESSAGE_PARAM_HOLDER, jSONObject2.toString()), null);
                                    } catch (Throwable unused) {
                                    }
                                }
                            };
                            try {
                                JSONObject jSONObject2 = new JSONObject(string2);
                                QMUIWebViewBridgeHandler.this.handleInnerMessage(jSONObject2.getString(QMUIWebViewBridgeHandler.MESSAGE_INNER_CMD_NAME), jSONObject2, messageFinishCallback);
                            } catch (Throwable unused) {
                                QMUIWebViewBridgeHandler.this.handleMessage(string2, messageFinishCallback);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInnerMessage(String str, JSONObject jSONObject, MessageFinishCallback messageFinishCallback) {
        if (MESSAGE_CMD_GET_SUPPORTED_CMD_LIST.equals(str)) {
            messageFinishCallback.finish(new JSONArray((Collection) getSupportedCmdList()));
            return;
        }
        throw new RuntimeException("not a inner api message. fallback to custom message");
    }

    public static String unescape(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String strReplace = str.substring(1, str.length() - 1).replace("\\\\", "\\").replace("\\\"", "\"");
        if ("null".equals(strReplace)) {
            return null;
        }
        return strReplace;
    }

    public static String escape(String str) {
        if (str == null || str.isEmpty()) {
            return "\"null\"";
        }
        return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    public abstract class MessageFinishCallback {
        private final String mCallbackId;

        public abstract void finish(Object obj);

        public MessageFinishCallback(String str) {
            this.mCallbackId = str;
        }

        public String getCallbackId() {
            return this.mCallbackId;
        }
    }
}
