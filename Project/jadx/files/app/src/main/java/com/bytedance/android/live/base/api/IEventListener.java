package com.bytedance.android.live.base.api;

/* JADX INFO: loaded from: classes2.dex */
public interface IEventListener {

    public static class Event {
        public static final int TYPE_COMMENT = 4;
        public static final int TYPE_ENTER = 1;
        public static final int TYPE_EXIT = 2;
        public static final int TYPE_FOLLOW = 3;
        public static final int TYPE_ORDER = 5;
        public static final int TYPE_UNKNOWN = 0;
        public long time;
        public int type;

        public Event(int i2, long j2) {
            this.type = 0;
            this.time = 0L;
            this.type = i2;
            this.time = j2;
        }
    }

    void onEvent(Event event);
}
