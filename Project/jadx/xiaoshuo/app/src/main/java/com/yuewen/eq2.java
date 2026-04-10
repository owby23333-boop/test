package com.yuewen;

import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class eq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final eq2 f10712a = new eq2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f10713b = "PushHandler";

    @NotNull
    public static final String c = "nopush";

    @NotNull
    public static final String d = "auto;messageId=%s;title=%s;description=%s;channel_id=%s";

    @NotNull
    public static final String e = "operation;plan_id=%s;jobkey=%s;message_id=%s;title=%s;description=%s;channel_id=%s";

    @NotNull
    public static final String f = "push";

    @NotNull
    public static final String g = "null";
    public static final int h = 1;

    @NotNull
    public static final String i = "is_push";

    @NotNull
    public static final String j = "auto";

    @NotNull
    public static final String k = "msg_id";

    @NotNull
    public static final String l = "title";

    @NotNull
    public static final String m = "description";

    @NotNull
    public static final String n = "messageId";

    @NotNull
    public static final String o = "key_message";

    @NotNull
    public static final String p = "extra";

    @NotNull
    public static final String q = "dot_plan_id";

    @NotNull
    public static final String r = "jobkey";

    @NotNull
    public static final String s = "channel_id";

    public final dq2 a(Intent intent) {
        String str;
        boolean booleanExtra = intent.getBooleanExtra("auto", false);
        String stringExtra = intent.getStringExtra("msg_id");
        String stringExtra2 = intent.getStringExtra("title");
        String stringExtra3 = intent.getStringExtra("description");
        String stringExtra4 = intent.getStringExtra("channel_id");
        if (booleanExtra) {
            str = String.format(d, Arrays.copyOf(new Object[]{stringExtra, stringExtra2, stringExtra3, stringExtra4}, 4));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            str = String.format(e, Arrays.copyOf(new Object[]{g, g, stringExtra, stringExtra2, stringExtra3, g}, 6));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        return new dq2(true, str);
    }

    public final dq2 b(Intent intent) {
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        qt1.a(f10713b, "notPPTPush = " + (extras.get(r) == null));
        Object obj = extras.get("key_message");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xiaomi.mipush.sdk.MiPushMessage");
        MiPushMessage miPushMessage = (MiPushMessage) obj;
        String str = miPushMessage.getExtra().get(q);
        String str2 = g;
        if (str == null) {
            str = g;
        }
        String str3 = miPushMessage.getExtra().get(r);
        if (str3 == null) {
            str3 = g;
        }
        String messageId = miPushMessage.getMessageId();
        String title = miPushMessage.getTitle();
        String description = miPushMessage.getDescription();
        String str4 = miPushMessage.getExtra().get("channel_id");
        if (str4 != null) {
            str2 = str4;
        }
        String str5 = String.format(e, Arrays.copyOf(new Object[]{str, str3, messageId, title, description, str2}, 6));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        return new dq2(true, str5);
    }

    @NotNull
    public final dq2 c(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        g(intent);
        return e(intent) ? a(intent) : f(intent) ? b(intent) : new dq2(false, c);
    }

    public final void d(@NotNull MiPushMessage miMessage, @NotNull Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(miMessage, "miMessage");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Map<String, String> extra = miMessage.getExtra();
        if (extra == null || (str = extra.get("channel_id")) == null) {
            str = g;
        }
        intent.putExtra(i, true);
        intent.putExtra("auto", miMessage.getNotifyId() != 1);
        intent.putExtra("msg_id", miMessage.getMessageId());
        intent.putExtra("title", miMessage.getTitle());
        intent.putExtra("description", miMessage.getDescription());
        intent.putExtra("channel_id", str);
    }

    public final boolean e(Intent intent) {
        return intent.getBooleanExtra(i, false);
    }

    public final boolean f(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.get("key_message") instanceof MiPushMessage;
        }
        return false;
    }

    public final void g(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                Object obj = extras.get(str);
                qt1.a(f10713b, "key = " + str + ", value = " + obj);
                if (obj != null) {
                    qt1.a(f10713b, "value class = " + obj.getClass());
                }
            }
        }
    }
}
