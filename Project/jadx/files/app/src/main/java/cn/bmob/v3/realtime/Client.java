package cn.bmob.v3.realtime;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.util.HttpConstant;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.BmobNative;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.util.BLog;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.baidu.mobads.sdk.internal.am;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.ByteString;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Client {
    public static final String ACTION_DELETE_ROW = "deleteRow";
    public static final String ACTION_DELETE_TABLE = "deleteTable";
    public static final String ACTION_UPDATE_ROW = "updateRow";
    public static final String ACTION_UPDATE_TABLE = "updateTable";
    public static final String DEFAULT_REAL_TIME_DATA_HOST = "http://io.bmob.cn:3010/socket.io/1/";
    public static final String DEFAULT_REAL_TIME_DATA_PATH_WEBSOCKET = "websocket/";
    public static final String PROTOCOL_WEBSOCKET = "websocket";
    public static final String TAG = "Client";
    private ClientListener mClientListener;
    private WebSocket mWebSocket;
    int ackCount = 0;
    private ListenHandler mListenHandler = new ListenHandler();
    private OkHttpClient mOkHttpClient = new OkHttpClient();

    public interface ClientListener {
        void onConnectCompleted(Client client, Exception exc);

        void onDataChange(Client client, JSONObject jSONObject);

        void onDisconnectCompleted(Client client);
    }

    class ConfigTask extends AsyncTask<Void, Void, String> {
        ConfigTask() {
        }

        private void handleConfig(String str) {
            if (TextUtils.isEmpty(str)) {
                Client.this.mClientListener.onConnectCompleted(Client.this, new BmobException(ErrorCode.E9015, "Get config failed."));
                return;
            }
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length == 0 || strArrSplit.length < 4) {
                Client.this.mClientListener.onConnectCompleted(Client.this, new BmobException(ErrorCode.E9015, "Get config failed:" + str));
                return;
            }
            final String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            String str4 = strArrSplit[3];
            if (!"".equals(str3)) {
                int i2 = Integer.parseInt(str3) / 2;
            }
            if (new HashSet(Arrays.asList(str4.split(","))).contains(Client.PROTOCOL_WEBSOCKET)) {
                new Thread(new Runnable() { // from class: cn.bmob.v3.realtime.Client.ConfigTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Client.this.listenRealTime(str2);
                    }
                }).start();
            } else {
                Client.this.mClientListener.onConnectCompleted(Client.this, new BmobException(ErrorCode.E9015, "websocket not supported"));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            try {
                return Client.this.getServerConfiguration();
            } catch (IOException e2) {
                return e2.getMessage();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            handleConfig(str);
        }
    }

    private class ListenHandler extends Handler {
        private ListenHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == -1) {
                Client.this.mClientListener.onConnectCompleted(Client.this, (Exception) message.obj);
            } else {
                if (i2 == 0) {
                    Client.this.mClientListener.onDisconnectCompleted(Client.this);
                    return;
                }
                if (i2 == 1) {
                    Client.this.mClientListener.onConnectCompleted(Client.this, null);
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    Client.this.mClientListener.onDataChange(Client.this, (JSONObject) message.obj);
                }
            }
        }
    }

    private interface OnNewWebsocketListener {
        void onAck();

        void onChange(JSONObject jSONObject);

        void onConnected(WebSocket webSocket);

        void onDisconnected();

        void onError(String str, String str2);

        void onFailure(Exception exc);

        void onHeartbeat();

        void onJsonMessage();

        void onNoop();

        void onStringMessage();
    }

    private String createSecret() {
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = (byte) (Math.random() * 256.0d);
        }
        return Base64.encodeToString(bArr, 0).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String expectedKey(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest((str + WebSocketProtocol.ACCEPT_MAGIC).getBytes()), 0).trim();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private JSONObject getArgs(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_APP_KEY, BmobNative.getAppId());
            jSONObject.put("tableName", str);
            jSONObject.put("objectId", str2);
            jSONObject.put(NativeAdvancedJsUtils.f8246p, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(WebSocket webSocket, String str, OnNewWebsocketListener onNewWebsocketListener) throws JSONException {
        BLog.e("onMessage：" + str);
        String[] strArrSplit = str.split(":", 4);
        switch (Integer.parseInt(strArrSplit[0])) {
            case 0:
                onNewWebsocketListener.onDisconnected();
                break;
            case 1:
                onNewWebsocketListener.onConnected(webSocket);
                break;
            case 2:
                send("2::");
                onNewWebsocketListener.onHeartbeat();
                break;
            case 3:
                onNewWebsocketListener.onStringMessage();
                break;
            case 4:
                new JSONObject(strArrSplit[3]);
                onNewWebsocketListener.onJsonMessage();
                break;
            case 5:
                JSONObject jSONObject = new JSONObject(strArrSplit[3]);
                String string = jSONObject.getString("name");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("args");
                BLog.e(string);
                if (string.equals("server_pub")) {
                    BLog.e(string);
                    onNewWebsocketListener.onChange(new JSONObject(jSONArrayOptJSONArray.getString(0)));
                }
                break;
            case 6:
                String[] strArrSplit2 = strArrSplit[3].split("\\+", 2);
                JSONArray jSONArray = strArrSplit2.length == 2 ? new JSONArray(strArrSplit2[1]) : null;
                webSocket.send(String.format("6:::%s%s", strArrSplit[1], jSONArray != null ? "+" + jSONArray.toString() : ""));
                break;
            case 7:
                onNewWebsocketListener.onError(strArrSplit[2], strArrSplit[3]);
                break;
            case 8:
                onNewWebsocketListener.onNoop();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenRealTime(String str) {
        newWebSocket(str, new OnNewWebsocketListener() { // from class: cn.bmob.v3.realtime.Client.2
            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onAck() {
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onChange(JSONObject jSONObject) {
                BLog.e("onDataChange");
                Message message = new Message();
                message.what = 5;
                message.obj = jSONObject;
                Client.this.mListenHandler.sendMessage(message);
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onConnected(WebSocket webSocket) {
                Client.this.mWebSocket = webSocket;
                Client.this.mWebSocket.send(String.format("1::%s", ""));
                Message message = new Message();
                message.what = 1;
                Client.this.mListenHandler.sendMessage(message);
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onDisconnected() {
                Client.this.mWebSocket.send(String.format("0::%s", ""));
                Message message = new Message();
                message.what = 0;
                Client.this.mListenHandler.sendMessage(message);
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onError(String str2, String str3) {
                Message message = new Message();
                message.what = -1;
                message.obj = new Exception(str2 + ":" + str3);
                Client.this.mListenHandler.sendMessage(message);
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onFailure(Exception exc) {
                Message message = new Message();
                message.what = -1;
                message.obj = exc;
                Client.this.mListenHandler.sendMessage(message);
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onHeartbeat() {
                BLog.e("onHeartbeat");
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onJsonMessage() {
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onNoop() {
            }

            @Override // cn.bmob.v3.realtime.Client.OnNewWebsocketListener
            public void onStringMessage() {
            }
        });
    }

    private void newWebSocket(String str, final OnNewWebsocketListener onNewWebsocketListener) {
        Request.Builder builder = new Request.Builder();
        final String strCreateSecret = createSecret();
        BLog.e("key:" + strCreateSecret);
        builder.url("http://io.bmob.cn:3010/socket.io/1/websocket/" + str);
        builder.header("GET", "HTTP/1.1");
        builder.header("Upgrade", PROTOCOL_WEBSOCKET);
        builder.header("Connection", "Upgrade");
        builder.header(HttpConstant.HOST, "io.bmob.cn");
        builder.header("Origin", "http://io.bmob.cn");
        builder.header("User-Agent", "android-websockets-2.0");
        builder.header("Sec-WebSocket-Key", strCreateSecret);
        builder.header("Sec-WebSocket-Version", AgooConstants.ACK_FLAG_NULL);
        this.mOkHttpClient.newWebSocket(builder.build(), new WebSocketListener() { // from class: cn.bmob.v3.realtime.Client.1
            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int i2, String str2) {
                super.onClosed(webSocket, i2, str2);
                BLog.e("onClosed：" + str2);
                onNewWebsocketListener.onDisconnected();
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket webSocket, int i2, String str2) {
                super.onClosing(webSocket, i2, str2);
                BLog.e("onClosing：" + str2);
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                super.onFailure(webSocket, th, response);
                BLog.e("onFailure：" + th.toString());
                onNewWebsocketListener.onDisconnected();
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String str2) {
                super.onMessage(webSocket, str2);
                try {
                    Client.this.handleMessage(webSocket, str2, onNewWebsocketListener);
                } catch (JSONException e2) {
                    onNewWebsocketListener.onFailure(e2);
                    e2.printStackTrace();
                }
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                BLog.e("onOpen：" + response.message());
                BLog.e("onOpen：" + response.headers().toString());
                try {
                    BLog.e("onOpen：" + response.body().string());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                BLog.e("onOpen：" + Client.this.expectedKey(strCreateSecret));
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString byteString) {
                super.onMessage(webSocket, byteString);
            }
        });
    }

    public void connect(ClientListener clientListener) {
        this.mClientListener = clientListener;
        new ConfigTask().execute(new Void[0]);
    }

    public void emit(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("args", jSONArray);
            emitRaw(5, jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public void emitRaw(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int i3 = this.ackCount;
        this.ackCount = i3 + 1;
        sb.append(i3);
        String str2 = String.format("%d:%s:%s:%s", Integer.valueOf(i2), sb.toString() + "+", "", str);
        BLog.e("客户端发送：" + str2);
        send(str2);
    }

    public String getServerConfiguration() throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(DEFAULT_REAL_TIME_DATA_HOST);
        builder.post(RequestBody.create(MediaType.parse(am.f12848e), ""));
        builder.header("User-Agent", "android-websockets-2.0");
        return this.mOkHttpClient.newCall(builder.build()).execute().body().string();
    }

    public void send(String str) {
        BLog.e("send：" + str);
        this.mWebSocket.send(str);
    }

    public void subRowDelete(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, str2, ACTION_DELETE_ROW).toString());
        emit("client_sub", jSONArray);
    }

    public void subRowUpdate(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, str2, ACTION_UPDATE_ROW).toString());
        emit("client_sub", jSONArray);
    }

    public void subTableDelete(String str) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, "", ACTION_DELETE_TABLE).toString());
        emit("client_sub", jSONArray);
    }

    public void subTableUpdate(String str) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, "", ACTION_UPDATE_TABLE).toString());
        emit("client_sub", jSONArray);
    }

    public void unsubRowDelete(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, str2, "unsub_deleteRow").toString());
        emit("client_unsub", jSONArray);
    }

    public void unsubRowUpdate(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, str2, "unsub_updateRow").toString());
        emit("client_unsub", jSONArray);
    }

    public void unsubTableDelete(String str) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, "", "unsub_deleteTable").toString());
        emit("client_unsub", jSONArray);
    }

    public void unsubTableUpdate(String str) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(getArgs(str, "", "unsub_updateTable").toString());
        emit("client_unsub", jSONArray);
    }
}
