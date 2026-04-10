package b1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sntech.x2.Cif;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppStatus.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static a f610e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f611c;
    public Integer b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f612d = new AtomicBoolean(true);
    public final Context a = Cif.m154do();

    /* JADX INFO: renamed from: b1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppStatus.java */
    public class C0015a implements Application.ActivityLifecycleCallbacks {
        public C0015a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            a aVar = a.this;
            aVar.b = Integer.valueOf(aVar.b.intValue() + 1);
            StringBuilder sbA = y.b.a("onActivityStarted - activityCount = ");
            sbA.append(a.this.b);
            sbA.toString();
            a.a(a.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            a.this.b = Integer.valueOf(r2.b.intValue() - 1);
            StringBuilder sbA = y.b.a("onActivityStopped - activityCount = ");
            sbA.append(a.this.b);
            sbA.toString();
            a.a(a.this);
        }
    }

    /* JADX INFO: compiled from: AppStatus.java */
    public interface b {
        void a(boolean z2);
    }

    public a() {
        a();
    }

    public final void a() {
        try {
            Context context = this.a;
            Application application = context instanceof Application ? (Application) context : context instanceof Activity ? ((Activity) context).getApplication() : null;
            if (application == null) {
                return;
            }
            application.registerActivityLifecycleCallbacks(new C0015a());
        } catch (Exception unused) {
        }
    }

    public static void a(a aVar) {
        boolean z2 = aVar.b.intValue() > 0;
        if (aVar.f612d.get() && !z2) {
            aVar.f612d.set(false);
            b bVar = aVar.f611c;
            if (bVar != null) {
                bVar.a(false);
                return;
            }
            return;
        }
        if (aVar.f612d.get() || !z2) {
            return;
        }
        aVar.f612d.set(true);
        b bVar2 = aVar.f611c;
        if (bVar2 != null) {
            bVar2.a(true);
        }
    }
}
