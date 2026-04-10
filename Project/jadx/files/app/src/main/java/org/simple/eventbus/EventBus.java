package org.simple.eventbus;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.simple.eventbus.handler.AsyncEventHandler;
import org.simple.eventbus.handler.DefaultEventHandler;
import org.simple.eventbus.handler.EventHandler;
import org.simple.eventbus.handler.UIThreadEventHandler;
import org.simple.eventbus.matchpolicy.DefaultMatchPolicy;
import org.simple.eventbus.matchpolicy.MatchPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class EventBus {
    private static final String DESCRIPTOR = "EventBus";
    private static EventBus sDefaultBus;
    private String mDesc;
    EventDispatcher mDispatcher;
    ThreadLocal<Queue<EventType>> mLocalEvents;
    SubsciberMethodHunter mMethodHunter;
    private List<EventType> mStickyEvents;
    private final Map<EventType, CopyOnWriteArrayList<Subscription>> mSubcriberMap;

    private class EventDispatcher {
        EventHandler mAsyncEventHandler;
        private Map<EventType, List<EventType>> mCacheEventTypes;
        MatchPolicy mMatchPolicy;
        EventHandler mPostThreadHandler;
        EventHandler mUIThreadEventHandler;

        private EventDispatcher() {
            this.mUIThreadEventHandler = new UIThreadEventHandler();
            this.mPostThreadHandler = new DefaultEventHandler();
            this.mAsyncEventHandler = new AsyncEventHandler();
            this.mCacheEventTypes = new ConcurrentHashMap();
            this.mMatchPolicy = new DefaultMatchPolicy();
        }

        private void deliveryEvent(EventType eventType, Object obj) {
            Iterator<EventType> it = getMatchedEventTypes(eventType, obj).iterator();
            while (it.hasNext()) {
                handleEvent(it.next(), obj);
            }
        }

        private EventHandler getEventHandler(ThreadMode threadMode) {
            return threadMode == ThreadMode.ASYNC ? this.mAsyncEventHandler : threadMode == ThreadMode.POST ? this.mPostThreadHandler : this.mUIThreadEventHandler;
        }

        private List<EventType> getMatchedEventTypes(EventType eventType, Object obj) {
            List<EventType> list;
            if (this.mCacheEventTypes.containsKey(eventType)) {
                list = this.mCacheEventTypes.get(eventType);
            } else {
                List<EventType> listFindMatchEventTypes = this.mMatchPolicy.findMatchEventTypes(eventType, obj);
                this.mCacheEventTypes.put(eventType, listFindMatchEventTypes);
                list = listFindMatchEventTypes;
            }
            return list != null ? list : new ArrayList();
        }

        private void handleEvent(EventType eventType, Object obj) {
            List<Subscription> list = (List) EventBus.this.mSubcriberMap.get(eventType);
            if (list == null) {
                return;
            }
            for (Subscription subscription : list) {
                getEventHandler(subscription.threadMode).handleEvent(subscription, obj);
            }
        }

        private void handleStickyEvent(EventType eventType, Object obj) {
            List<EventType> matchedEventTypes = getMatchedEventTypes(eventType, eventType.event);
            Object obj2 = eventType.event;
            for (EventType eventType2 : matchedEventTypes) {
                List<Subscription> list = (List) EventBus.this.mSubcriberMap.get(eventType2);
                if (list != null) {
                    for (Subscription subscription : list) {
                        EventHandler eventHandler = getEventHandler(subscription.threadMode);
                        if (isTarget(subscription, obj) && (subscription.eventType.equals(eventType2) || subscription.eventType.paramClass.isAssignableFrom(eventType2.paramClass))) {
                            eventHandler.handleEvent(subscription, obj2);
                        }
                    }
                }
            }
        }

        private boolean isTarget(Subscription subscription, Object obj) {
            Reference<Object> reference = subscription.subscriber;
            Object obj2 = reference != null ? reference.get() : null;
            return obj == null || !(obj == null || obj2 == null || !obj2.equals(obj));
        }

        void dispatchEvents(Object obj) {
            Queue<EventType> queue = EventBus.this.mLocalEvents.get();
            while (queue.size() > 0) {
                deliveryEvent(queue.poll(), obj);
            }
        }

        void dispatchStickyEvents(Object obj) {
            Iterator it = EventBus.this.mStickyEvents.iterator();
            while (it.hasNext()) {
                handleStickyEvent((EventType) it.next(), obj);
            }
        }
    }

    private EventBus() {
        this(DESCRIPTOR);
    }

    public static EventBus getDefault() {
        if (sDefaultBus == null) {
            synchronized (EventBus.class) {
                if (sDefaultBus == null) {
                    sDefaultBus = new EventBus();
                }
            }
        }
        return sDefaultBus;
    }

    public synchronized void clear() {
        this.mLocalEvents.get().clear();
        this.mSubcriberMap.clear();
    }

    public String getDescriptor() {
        return this.mDesc;
    }

    public EventDispatcher getDispatcher() {
        return this.mDispatcher;
    }

    public Queue<EventType> getEventQueue() {
        return this.mLocalEvents.get();
    }

    public List<EventType> getStickyEvents() {
        return this.mStickyEvents;
    }

    public Map<EventType, CopyOnWriteArrayList<Subscription>> getSubscriberMap() {
        return this.mSubcriberMap;
    }

    public void post(Object obj) {
        post(obj, EventType.DEFAULT_TAG);
    }

    public void postSticky(Object obj) {
        postSticky(obj, EventType.DEFAULT_TAG);
    }

    public void register(Object obj) {
        if (obj == null) {
            return;
        }
        synchronized (this) {
            this.mMethodHunter.findSubcribeMethods(obj);
        }
    }

    public void registerSticky(Object obj) {
        register(obj);
        this.mDispatcher.dispatchStickyEvents(obj);
    }

    public void removeStickyEvent(Class<?> cls) {
        removeStickyEvent(cls, EventType.DEFAULT_TAG);
    }

    public void setAsyncEventHandler(EventHandler eventHandler) {
        this.mDispatcher.mAsyncEventHandler = eventHandler;
    }

    public void setMatchPolicy(MatchPolicy matchPolicy) {
        this.mDispatcher.mMatchPolicy = matchPolicy;
    }

    public void setPostThreadHandler(EventHandler eventHandler) {
        this.mDispatcher.mPostThreadHandler = eventHandler;
    }

    public void setUIThreadEventHandler(EventHandler eventHandler) {
        this.mDispatcher.mUIThreadEventHandler = eventHandler;
    }

    public void unregister(Object obj) {
        if (obj == null) {
            return;
        }
        synchronized (this) {
            this.mMethodHunter.removeMethodsFromMap(obj);
        }
    }

    public EventBus(String str) {
        this.mDesc = DESCRIPTOR;
        this.mSubcriberMap = new ConcurrentHashMap();
        this.mStickyEvents = Collections.synchronizedList(new LinkedList());
        this.mLocalEvents = new ThreadLocal<Queue<EventType>>() { // from class: org.simple.eventbus.EventBus.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Queue<EventType> initialValue() {
                return new ConcurrentLinkedQueue();
            }
        };
        this.mDispatcher = new EventDispatcher();
        this.mMethodHunter = new SubsciberMethodHunter(this.mSubcriberMap);
        this.mDesc = str;
    }

    public void post(Object obj, String str) {
        this.mLocalEvents.get().offer(new EventType(obj.getClass(), str));
        this.mDispatcher.dispatchEvents(obj);
    }

    public void postSticky(Object obj, String str) {
        EventType eventType = new EventType(obj.getClass(), str);
        eventType.event = obj;
        this.mStickyEvents.add(eventType);
    }

    public void removeStickyEvent(Class<?> cls, String str) {
        Iterator<EventType> it = this.mStickyEvents.iterator();
        while (it.hasNext()) {
            EventType next = it.next();
            if (next.paramClass.equals(cls) && next.tag.equals(str)) {
                it.remove();
            }
        }
    }
}
