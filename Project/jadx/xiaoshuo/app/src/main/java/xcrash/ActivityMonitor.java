package xcrash;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes9.dex */
class ActivityMonitor {
    private static final int MAX_ACTIVITY_NUM = 100;
    private static final ActivityMonitor instance = new ActivityMonitor();
    private LinkedList<Activity> activities = null;
    private boolean isAppForeground = false;

    private ActivityMonitor() {
    }

    public static ActivityMonitor getInstance() {
        return instance;
    }

    public void finishAllActivities() {
        LinkedList<Activity> linkedList = this.activities;
        if (linkedList != null) {
            Iterator<Activity> it = linkedList.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
            this.activities.clear();
        }
    }

    public void initialize(Application application) {
        this.activities = new LinkedList<>();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: xcrash.ActivityMonitor.1
            private int activityReferences = 0;
            private boolean isActivityChangingConfigurations = false;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityMonitor.this.activities.addFirst(activity);
                if (ActivityMonitor.this.activities.size() > 100) {
                    ActivityMonitor.this.activities.removeLast();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ActivityMonitor.this.activities.remove(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                int i = this.activityReferences + 1;
                this.activityReferences = i;
                if (i != 1 || this.isActivityChangingConfigurations) {
                    return;
                }
                ActivityMonitor.this.isAppForeground = true;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                boolean zIsChangingConfigurations = activity.isChangingConfigurations();
                this.isActivityChangingConfigurations = zIsChangingConfigurations;
                int i = this.activityReferences - 1;
                this.activityReferences = i;
                if (i != 0 || zIsChangingConfigurations) {
                    return;
                }
                ActivityMonitor.this.isAppForeground = false;
            }
        });
    }

    public boolean isApplicationForeground() {
        return this.isAppForeground;
    }
}
