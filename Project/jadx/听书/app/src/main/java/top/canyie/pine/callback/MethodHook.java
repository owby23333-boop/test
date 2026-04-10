package top.canyie.pine.callback;

import java.lang.reflect.Member;
import top.canyie.pine.Pine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MethodHook {

    public class Unhook {
        private final Pine.HookRecord hookRecord;

        public Unhook(Pine.HookRecord hookRecord) {
            this.hookRecord = hookRecord;
        }

        public MethodHook getCallback() {
            return MethodHook.this;
        }

        public Member getTarget() {
            return this.hookRecord.target;
        }

        public void unhook() {
            Pine.getHookHandler().handleUnhook(this.hookRecord, MethodHook.this);
        }
    }

    public void afterCall(Pine.CallFrame callFrame) {
    }

    public void beforeCall(Pine.CallFrame callFrame) {
    }
}
