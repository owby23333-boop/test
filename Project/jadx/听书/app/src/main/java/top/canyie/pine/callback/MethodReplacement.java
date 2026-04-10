package top.canyie.pine.callback;

import top.canyie.pine.Pine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MethodReplacement extends MethodHook {
    public static final MethodReplacement DO_NOTHING = new MethodReplacement() { // from class: top.canyie.pine.callback.MethodReplacement.1
        @Override // top.canyie.pine.callback.MethodReplacement
        public Object replaceCall(Pine.CallFrame callFrame) {
            return null;
        }
    };

    public static MethodReplacement returnConstant(final Object obj) {
        return new MethodReplacement() { // from class: top.canyie.pine.callback.MethodReplacement.2
            @Override // top.canyie.pine.callback.MethodReplacement
            public Object replaceCall(Pine.CallFrame callFrame) {
                return obj;
            }
        };
    }

    @Override // top.canyie.pine.callback.MethodHook
    public final void afterCall(Pine.CallFrame callFrame) {
    }

    @Override // top.canyie.pine.callback.MethodHook
    public final void beforeCall(Pine.CallFrame callFrame) {
        try {
            callFrame.setResult(replaceCall(callFrame));
        } catch (Throwable th) {
            callFrame.setThrowable(th);
        }
    }

    public abstract Object replaceCall(Pine.CallFrame callFrame);
}
