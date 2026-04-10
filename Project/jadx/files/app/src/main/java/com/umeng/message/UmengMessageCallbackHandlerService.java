package com.umeng.message;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.ab;
import com.umeng.message.proguard.c;
import com.umeng.message.proguard.q;
import com.umeng.message.proguard.r;
import com.umeng.message.proguard.s;
import com.umeng.message.service.UMJobIntentService;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UmengMessageCallbackHandlerService extends UMJobIntentService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f20267j = "MsgCallback";

    public static void removeCacheLog(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    String strOptString = jSONObject.optString("msg_id");
                    int iOptInt = jSONObject.optInt(MsgConstant.KEY_ACTION_TYPE);
                    arrayList.add(ContentProviderOperation.newDelete(ab.f20369g).withSelection("MsgId=? And ActionType=?", new String[]{strOptString, iOptInt + ""}).build());
                    if (iOptInt != 0) {
                        arrayList.add(ContentProviderOperation.newDelete(ab.f20370h).withSelection("MsgId=?", new String[]{strOptString}).build());
                    }
                }
                context.getContentResolver().applyBatch(ab.a, arrayList);
            } catch (Throwable th) {
                UPLog.i(f20267j, "remove cache log:" + th.getMessage());
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.umeng.message.service.UMJobIntentService, com.umeng.message.service.JobIntentService
    public void a(Intent intent) {
        final Context contextB = r.b();
        if (contextB == null) {
            UPLog.i(f20267j, "context null!");
            return;
        }
        if (intent == null || intent.getAction() == null) {
            return;
        }
        UPLog.i(f20267j, "action: ", intent.getAction());
        String action = intent.getAction();
        byte b = -1;
        switch (action.hashCode()) {
            case -971092519:
                if (action.equals(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION)) {
                    b = 0;
                }
                break;
            case -84030499:
                if (action.equals(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION)) {
                    b = 3;
                }
                break;
            case 519195784:
                if (action.equals(MsgConstant.MESSAGE_MESSAGE_SEND_ACTION)) {
                    b = 4;
                }
                break;
            case 1234078163:
                if (action.equals(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION)) {
                    b = 2;
                }
                break;
            case 1766750944:
                if (action.equals(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION)) {
                    b = 1;
                }
                break;
        }
        if (b == 0) {
            try {
                final String stringExtra = intent.getStringExtra(MsgConstant.KEY_REGISTRATION_ID);
                boolean booleanExtra = intent.getBooleanExtra("status", false);
                UPLog.i(f20267j, "deviceToken: ", stringExtra, " status：" + booleanExtra);
                final UPushRegisterCallback registerCallback = PushAgent.getInstance(contextB).getRegisterCallback();
                if (booleanExtra) {
                    c.b(new Runnable() { // from class: com.umeng.message.UmengMessageCallbackHandlerService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String deviceToken = "";
                            try {
                                MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(contextB);
                                deviceToken = messageSharedPrefs.getDeviceToken();
                                if (stringExtra != null && deviceToken != null && !stringExtra.equals(deviceToken)) {
                                    messageSharedPrefs.setRegistered(false);
                                    messageSharedPrefs.setDeviceToken(stringExtra);
                                    contextB.getContentResolver().delete(ab.f20368f, null, null);
                                    messageSharedPrefs.resetTags();
                                }
                            } catch (Exception unused) {
                            }
                            UPushRegisterCallback uPushRegisterCallback = registerCallback;
                            if (uPushRegisterCallback != null) {
                                uPushRegisterCallback.onSuccess(stringExtra);
                            }
                            s.a().a(deviceToken);
                            PushAgent.getInstance(contextB).onAppStart();
                        }
                    });
                } else if (registerCallback != null) {
                    registerCallback.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (b == 1) {
            try {
                boolean booleanExtra2 = intent.getBooleanExtra("status", false);
                UPushSettingCallback callback = PushAgent.getInstance(contextB).getCallback();
                UPLog.i(f20267j, "push open status:" + booleanExtra2);
                if (booleanExtra2) {
                    if (callback != null) {
                        callback.onSuccess();
                    }
                } else if (callback != null) {
                    callback.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                }
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        if (b == 2) {
            try {
                boolean booleanExtra3 = intent.getBooleanExtra("status", false);
                UPushSettingCallback callback2 = PushAgent.getInstance(contextB).getCallback();
                UPLog.i(f20267j, "push close status:" + booleanExtra3);
                if (booleanExtra3) {
                    if (callback2 != null) {
                        callback2.onSuccess();
                    }
                } else if (callback2 != null) {
                    callback2.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                }
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                return;
            }
        }
        if (b == 3) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(intent.getStringExtra(AgooConstants.MESSAGE_BODY)));
                UPushMessageHandler messageHandler = PushAgent.getInstance(contextB).getMessageHandler();
                if (messageHandler != null) {
                    messageHandler.handleMessage(contextB, uMessage);
                    return;
                }
                return;
            } catch (Throwable th4) {
                UPLog.i(f20267j, "MESSAGE_HANDLER_ACTION:", th4.getMessage());
                return;
            }
        }
        if (b != 4) {
            return;
        }
        try {
            String stringExtra2 = intent.getStringExtra(MsgConstant.KEY_SEND_MESSAGE);
            String stringExtra3 = intent.getStringExtra(MsgConstant.KEY_PX_PATH);
            JSONObject jSONObject = new JSONObject(stringExtra2);
            jSONObject.put(MsgConstant.KEY_PX_PATH, stringExtra3);
            UMWorkDispatch.sendEvent(contextB, MsgConstant.PUSH_MESSAGE_HANDLER_ACTION, q.a(), jSONObject.toString());
        } catch (Throwable th5) {
            UPLog.i(f20267j, "MESSAGE_SEND_ACTION:", th5.getMessage());
        }
    }
}
