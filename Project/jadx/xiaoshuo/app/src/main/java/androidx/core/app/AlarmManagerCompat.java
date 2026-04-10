package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long triggerTime, @NonNull PendingIntent showIntent, @NonNull PendingIntent operation) {
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(triggerTime, showIntent), operation);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        alarmManager.setAndAllowWhileIdle(type, triggerAtMillis, operation);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        alarmManager.setExact(type, triggerAtMillis, operation);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        alarmManager.setExactAndAllowWhileIdle(type, triggerAtMillis, operation);
    }
}
