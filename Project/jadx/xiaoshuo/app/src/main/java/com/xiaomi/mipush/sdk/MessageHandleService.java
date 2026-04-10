package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.mibi.sdk.common.CommonConstants;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.fc;
import com.xiaomi.push.fm;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class MessageHandleService extends BaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f7403a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ExecutorService f62a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Intent f7404a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private PushMessageReceiver f63a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f63a = pushMessageReceiver;
            this.f7404a = intent;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m126a() {
            return this.f63a;
        }

        public Intent a() {
            return this.f7404a;
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f7403a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f62a.isShutdown()) {
            return;
        }
        f62a.execute(new v(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f7403a.poll());
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        com.xiaomi.push.ag.a(context).a(new u(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver pushMessageReceiverM126a = aVar.m126a();
            Intent intentA = aVar.a();
            int intExtra = intentA.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(intentA.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = intentA.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                        com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                        pushMessageReceiverM126a.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) intentA.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                pushMessageReceiverM126a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), fm.COMMAND_REGISTER.f391a)) {
                    pushMessageReceiverM126a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        h.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a aVarA = ai.a(context).a(intentA);
            int intExtra2 = intentA.getIntExtra("eventMessageType", -1);
            if (aVarA != null) {
                if (aVarA instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) aVarA;
                    if (!miPushMessage.isArrivedMessage()) {
                        pushMessageReceiverM126a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        fc.a(context.getApplicationContext()).a(context.getPackageName(), intentA, CommonConstants.Mgc.DUPLICATE_RECHARGE_ERROR, (String) null);
                        com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        pushMessageReceiverM126a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            fc.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 1007, (String) null);
                        } else {
                            fc.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 3007, (String) null);
                        }
                        com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        pushMessageReceiverM126a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    pushMessageReceiverM126a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (aVarA instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) aVarA;
                    com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    pushMessageReceiverM126a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), fm.COMMAND_REGISTER.f391a)) {
                        pushMessageReceiverM126a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            h.b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "unknown raw message: " + aVarA);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e) {
            com.xiaomi.channel.commonutils.logger.b.a("MessageHandleService", e);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* JADX INFO: renamed from: a */
    public boolean mo132a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f7403a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
