package io.rx_cache2;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ActionsList<T> {
    protected Observable<List<T>> cache;
    protected final Evict<T> evict;
    boolean startToEvict;

    public interface Evict<T> {
        Observable<List<T>> call(Observable<List<T>> observable);
    }

    public interface Func1Count {
        boolean call(int i2);
    }

    public interface Func1Element<T> {
        boolean call(T t2);
    }

    public interface Func2 {
        boolean call(int i2, int i3);
    }

    public interface Func3<T> {
        boolean call(int i2, int i3, T t2);
    }

    public interface Replace<T> {
        T call(T t2);
    }

    public ActionsList(Evict<T> evict, Observable<List<T>> observable) {
        this.evict = evict;
        this.cache = observable;
    }

    public static <T> ActionsList<T> with(Evict<T> evict, Observable<List<T>> observable) {
        return new ActionsList<>(evict, observable);
    }

    public ActionsList<T> add(Func2 func2, T t2) {
        return addAll(func2, Arrays.asList(t2));
    }

    public ActionsList<T> addAll(final Func2 func2, final List<T> list) {
        this.cache = (Observable<List<T>>) this.cache.map(new Function<List<T>, List<T>>() { // from class: io.rx_cache2.ActionsList.5
            @Override // io.reactivex.functions.Function
            public List<T> apply(List<T> list2) throws Exception {
                int size = list2.size();
                int i2 = 0;
                while (true) {
                    if (i2 > size) {
                        break;
                    }
                    if (func2.call(i2, size)) {
                        list2.addAll(i2, list);
                        break;
                    }
                    i2++;
                }
                return list2;
            }
        });
        return this;
    }

    public ActionsList<T> addAllFirst(List<T> list) {
        return addAll(new Func2() { // from class: io.rx_cache2.ActionsList.3
            @Override // io.rx_cache2.ActionsList.Func2
            public boolean call(int i2, int i3) {
                return i2 == 0;
            }
        }, list);
    }

    public ActionsList<T> addAllLast(List<T> list) {
        return addAll(new Func2() { // from class: io.rx_cache2.ActionsList.4
            @Override // io.rx_cache2.ActionsList.Func2
            public boolean call(int i2, int i3) {
                return i2 == i3;
            }
        }, list);
    }

    public ActionsList<T> addFirst(T t2) {
        return addAll(new Func2() { // from class: io.rx_cache2.ActionsList.1
            @Override // io.rx_cache2.ActionsList.Func2
            public boolean call(int i2, int i3) {
                return i2 == 0;
            }
        }, Arrays.asList(t2));
    }

    public ActionsList<T> addLast(T t2) {
        return addAll(new Func2() { // from class: io.rx_cache2.ActionsList.2
            @Override // io.rx_cache2.ActionsList.Func2
            public boolean call(int i2, int i3) {
                return i2 == i3;
            }
        }, Arrays.asList(t2));
    }

    public ActionsList<T> evict(final Func1Element<T> func1Element) {
        return evict(new Func3<T>() { // from class: io.rx_cache2.ActionsList.14
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return func1Element.call(t2);
            }
        });
    }

    public ActionsList<T> evictAll() {
        return evictIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.16
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return true;
            }
        });
    }

    public ActionsList<T> evictAllKeepingFirstN(final int i2) {
        return evictIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.17
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i3, int i4, T t2) {
                return i3 >= i4 - (i4 - i2);
            }
        });
    }

    public ActionsList<T> evictAllKeepingLastN(final int i2) {
        return evictIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.18
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i3, int i4, T t2) {
                return i3 < i4 - i2;
            }
        });
    }

    public ActionsList<T> evictFirst() {
        return evict(new Func3<T>() { // from class: io.rx_cache2.ActionsList.6
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return i2 == 0;
            }
        });
    }

    public ActionsList<T> evictFirstN(int i2) {
        return evictFirstN(new Func1Count() { // from class: io.rx_cache2.ActionsList.7
            @Override // io.rx_cache2.ActionsList.Func1Count
            public boolean call(int i3) {
                return true;
            }
        }, i2);
    }

    public ActionsList<T> evictIterable(final Func3<T> func3) {
        this.cache = (Observable<List<T>>) this.cache.map(new Function<List<T>, List<T>>() { // from class: io.rx_cache2.ActionsList.19
            @Override // io.reactivex.functions.Function
            public List<T> apply(List<T> list) throws Exception {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (func3.call(i2, size, list.get(i2))) {
                        list.set(i2, null);
                    }
                }
                list.removeAll(Collections.singleton(null));
                return list;
            }
        });
        return this;
    }

    public ActionsList<T> evictLast() {
        return evict(new Func3<T>() { // from class: io.rx_cache2.ActionsList.8
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return i2 == i3 - 1;
            }
        });
    }

    public ActionsList<T> evictLastN(int i2) {
        return evictLastN(new Func1Count() { // from class: io.rx_cache2.ActionsList.9
            @Override // io.rx_cache2.ActionsList.Func1Count
            public boolean call(int i3) {
                return true;
            }
        }, i2);
    }

    public Observable<List<T>> toObservable() {
        return this.evict.call(this.cache);
    }

    public ActionsList<T> update(final Func1Element<T> func1Element, Replace<T> replace) {
        return update(new Func3<T>() { // from class: io.rx_cache2.ActionsList.20
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return func1Element.call(t2);
            }
        }, replace);
    }

    public ActionsList<T> updateIterable(final Func1Element<T> func1Element, Replace<T> replace) {
        return updateIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.22
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return func1Element.call(t2);
            }
        }, replace);
    }

    public ActionsList<T> evictFirstN(final Func1Count func1Count, final int i2) {
        return evictIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.11
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i3, int i4, T t2) {
                return i3 < i2 && func1Count.call(i4);
            }
        });
    }

    public ActionsList<T> evictLastN(final Func1Count func1Count, final int i2) {
        this.startToEvict = false;
        return evictIterable(new Func3<T>() { // from class: io.rx_cache2.ActionsList.13
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i3, int i4, T t2) {
                ActionsList actionsList = ActionsList.this;
                if (!actionsList.startToEvict) {
                    actionsList.startToEvict = i4 - i3 == i2;
                }
                return ActionsList.this.startToEvict && i4 - i3 <= i2 && func1Count.call(i4);
            }
        });
    }

    public ActionsList<T> evict(final Func3<T> func3) {
        this.cache = (Observable<List<T>>) this.cache.map(new Function<List<T>, List<T>>() { // from class: io.rx_cache2.ActionsList.15
            @Override // io.reactivex.functions.Function
            public List<T> apply(List<T> list) throws Exception {
                int size = list.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (func3.call(i2, size, list.get(i2))) {
                        list.remove(i2);
                        break;
                    }
                    i2++;
                }
                return list;
            }
        });
        return this;
    }

    public ActionsList<T> evictFirst(final Func1Count func1Count) {
        return evict(new Func3<T>() { // from class: io.rx_cache2.ActionsList.10
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return i2 == 0 && func1Count.call(i3);
            }
        });
    }

    public ActionsList<T> evictLast(final Func1Count func1Count) {
        return evict(new Func3<T>() { // from class: io.rx_cache2.ActionsList.12
            @Override // io.rx_cache2.ActionsList.Func3
            public boolean call(int i2, int i3, T t2) {
                return i2 == i3 + (-1) && func1Count.call(i3);
            }
        });
    }

    public ActionsList<T> update(final Func3<T> func3, final Replace<T> replace) {
        this.cache = (Observable<List<T>>) this.cache.map(new Function<List<T>, List<T>>() { // from class: io.rx_cache2.ActionsList.21
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // io.reactivex.functions.Function
            public List<T> apply(List<T> list) throws Exception {
                int size = list.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (func3.call(i2, size, list.get(i2))) {
                        list.set(i2, replace.call(list.get(i2)));
                        break;
                    }
                    i2++;
                }
                return list;
            }
        });
        return this;
    }

    public ActionsList<T> updateIterable(final Func3<T> func3, final Replace<T> replace) {
        this.cache = (Observable<List<T>>) this.cache.map(new Function<List<T>, List<T>>() { // from class: io.rx_cache2.ActionsList.23
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // io.reactivex.functions.Function
            public List<T> apply(List<T> list) throws Exception {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (func3.call(i2, size, list.get(i2))) {
                        list.set(i2, replace.call(list.get(i2)));
                    }
                }
                return list;
            }
        });
        return this;
    }
}
