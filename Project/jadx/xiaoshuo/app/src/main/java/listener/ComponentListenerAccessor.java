package listener;

/* JADX INFO: loaded from: classes8.dex */
public class ComponentListenerAccessor {
    public static void bindOriginListener(ComponentListener componentListener, Object obj) {
        if (componentListener != null) {
            componentListener.setOriginListener(obj);
        }
    }

    public static Object getOriginListener(ComponentListener componentListener) {
        if (componentListener != null) {
            return componentListener.getOriginListener();
        }
        return null;
    }
}
