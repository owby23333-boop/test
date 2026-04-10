package com.qmuiteam.qmui.skin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.Spanned;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.skin.annotation.QMUISkinListenWithHierarchyChange;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.skin.handler.IQMUISkinRuleHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleAlphaHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleBackgroundHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleBgTintColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleBorderHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleHintColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleMoreBgColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleMoreTextColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleProgressColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleSeparatorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleSrcHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleTextColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleTextCompoundSrcHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleTextCompoundTintColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleTintColorHandler;
import com.qmuiteam.qmui.skin.handler.QMUISkinRuleUnderlineHandler;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class QMUISkinManager {
    public static final DispatchListenStrategySelector DEFAULT_DISPATCH_LISTEN_STRATEGY_SELECTOR;
    private static final String DEFAULT_NAME = "default";
    public static final int DEFAULT_SKIN = -1;
    private static final String TAG = "QMUISkinManager";
    private static ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private static View.OnLayoutChangeListener mOnLayoutChangeListener;
    private static DispatchListenStrategySelector sDispatchListenStrategySelector;
    private static HashMap<String, IQMUISkinRuleHandler> sRuleHandlers;
    private static HashMap<Integer, Resources.Theme> sStyleIdThemeMap;
    private String mName;
    private String mPackageName;
    private Resources mResources;
    private static final String[] EMPTY_ITEMS = new String[0];
    private static ArrayMap<String, QMUISkinManager> sInstances = new ArrayMap<>();
    private SparseArray<SkinItem> mSkins = new SparseArray<>();
    private boolean mIsInSkinChangeDispatch = false;
    private int mCurrentSkin = -1;
    private final List<WeakReference<?>> mSkinObserverList = new ArrayList();
    private final List<OnSkinChangeListener> mSkinChangeListeners = new ArrayList();

    public enum DispatchListenStrategy {
        LISTEN_ON_LAYOUT,
        LISTEN_ON_HIERARCHY_CHANGE
    }

    public interface DispatchListenStrategySelector {
        DispatchListenStrategy select(ViewGroup viewGroup);
    }

    public interface OnSkinChangeListener {
        void onSkinChange(QMUISkinManager qMUISkinManager, int i, int i2);
    }

    static {
        DispatchListenStrategySelector dispatchListenStrategySelector = new DispatchListenStrategySelector() { // from class: com.qmuiteam.qmui.skin.QMUISkinManager.1
            @Override // com.qmuiteam.qmui.skin.QMUISkinManager.DispatchListenStrategySelector
            public DispatchListenStrategy select(ViewGroup viewGroup) {
                if ((viewGroup instanceof RecyclerView) || (viewGroup instanceof ViewPager) || (viewGroup instanceof AdapterView) || viewGroup.getClass().isAnnotationPresent(QMUISkinListenWithHierarchyChange.class)) {
                    return DispatchListenStrategy.LISTEN_ON_HIERARCHY_CHANGE;
                }
                return DispatchListenStrategy.LISTEN_ON_LAYOUT;
            }
        };
        DEFAULT_DISPATCH_LISTEN_STRATEGY_SELECTOR = dispatchListenStrategySelector;
        sDispatchListenStrategySelector = dispatchListenStrategySelector;
        sRuleHandlers = new HashMap<>();
        sStyleIdThemeMap = new HashMap<>();
        sRuleHandlers.put(QMUISkinValueBuilder.BACKGROUND, new QMUISkinRuleBackgroundHandler());
        QMUISkinRuleTextColorHandler qMUISkinRuleTextColorHandler = new QMUISkinRuleTextColorHandler();
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COLOR, qMUISkinRuleTextColorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.SECOND_TEXT_COLOR, qMUISkinRuleTextColorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.SRC, new QMUISkinRuleSrcHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.BORDER, new QMUISkinRuleBorderHandler());
        QMUISkinRuleSeparatorHandler qMUISkinRuleSeparatorHandler = new QMUISkinRuleSeparatorHandler();
        sRuleHandlers.put(QMUISkinValueBuilder.TOP_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.RIGHT_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.BOTTOM_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.LEFT_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.TINT_COLOR, new QMUISkinRuleTintColorHandler());
        sRuleHandlers.put("alpha", new QMUISkinRuleAlphaHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.BG_TINT_COLOR, new QMUISkinRuleBgTintColorHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.PROGRESS_COLOR, new QMUISkinRuleProgressColorHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COMPOUND_TINT_COLOR, new QMUISkinRuleTextCompoundTintColorHandler());
        QMUISkinRuleTextCompoundSrcHandler qMUISkinRuleTextCompoundSrcHandler = new QMUISkinRuleTextCompoundSrcHandler();
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COMPOUND_LEFT_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COMPOUND_TOP_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COMPOUND_RIGHT_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.TEXT_COMPOUND_BOTTOM_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(QMUISkinValueBuilder.HINT_COLOR, new QMUISkinRuleHintColorHandler());
        sRuleHandlers.put("underline", new QMUISkinRuleUnderlineHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.MORE_TEXT_COLOR, new QMUISkinRuleMoreTextColorHandler());
        sRuleHandlers.put(QMUISkinValueBuilder.MORE_BG_COLOR, new QMUISkinRuleMoreBgColorHandler());
        mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.qmuiteam.qmui.skin.QMUISkinManager.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ViewGroup viewGroup;
                int childCount;
                ViewSkinCurrent viewSkinCurrent;
                if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0 || (viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(viewGroup)) == null) {
                    return;
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt = viewGroup.getChildAt(i9);
                    if (!viewSkinCurrent.equals(QMUISkinManager.getViewSkinCurrent(childAt))) {
                        QMUISkinManager.of(viewSkinCurrent.managerName, childAt.getContext()).dispatch(childAt, viewSkinCurrent.index);
                    }
                }
            }
        };
        mOnHierarchyChangeListener = new ViewGroup.OnHierarchyChangeListener() { // from class: com.qmuiteam.qmui.skin.QMUISkinManager.3
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(view);
                if (viewSkinCurrent == null || viewSkinCurrent.equals(QMUISkinManager.getViewSkinCurrent(view2))) {
                    return;
                }
                QMUISkinManager.of(viewSkinCurrent.managerName, view2.getContext()).dispatch(view2, viewSkinCurrent.index);
            }
        };
    }

    public static void setDispatchListenStrategySelector(DispatchListenStrategySelector dispatchListenStrategySelector) {
        if (dispatchListenStrategySelector == null) {
            sDispatchListenStrategySelector = DEFAULT_DISPATCH_LISTEN_STRATEGY_SELECTOR;
        } else {
            sDispatchListenStrategySelector = dispatchListenStrategySelector;
        }
    }

    public static QMUISkinManager defaultInstance(Context context) {
        Context applicationContext = context.getApplicationContext();
        return of(DEFAULT_NAME, applicationContext.getResources(), applicationContext.getPackageName());
    }

    public static QMUISkinManager of(String str, Resources resources, String str2) {
        QMUISkinManager qMUISkinManager = sInstances.get(str);
        if (qMUISkinManager != null) {
            return qMUISkinManager;
        }
        QMUISkinManager qMUISkinManager2 = new QMUISkinManager(str, resources, str2);
        sInstances.put(str, qMUISkinManager2);
        return qMUISkinManager2;
    }

    public static QMUISkinManager of(String str, Context context) {
        Context applicationContext = context.getApplicationContext();
        return of(str, applicationContext.getResources(), applicationContext.getPackageName());
    }

    public static void setRuleHandler(String str, IQMUISkinRuleHandler iQMUISkinRuleHandler) {
        sRuleHandlers.put(str, iQMUISkinRuleHandler);
    }

    public QMUISkinManager(String str, Resources resources, String str2) {
        this.mName = str;
        this.mResources = resources;
        this.mPackageName = str2;
    }

    public String getName() {
        return this.mName;
    }

    public Resources.Theme getTheme(int i) {
        SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            return skinItem.getTheme();
        }
        return null;
    }

    public Resources.Theme getCurrentTheme() {
        SkinItem skinItem = this.mSkins.get(this.mCurrentSkin);
        if (skinItem != null) {
            return skinItem.getTheme();
        }
        return null;
    }

    public void addSkin(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("index must greater than 0");
        }
        SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            if (skinItem.getStyleRes() != i2) {
                throw new RuntimeException("already exist the theme item for " + i);
            }
        } else {
            this.mSkins.append(i, new SkinItem(i2));
        }
    }

    static ViewSkinCurrent getViewSkinCurrent(View view) {
        Object tag = view.getTag(R.id.qmui_skin_current);
        if (tag instanceof ViewSkinCurrent) {
            return (ViewSkinCurrent) tag;
        }
        return null;
    }

    public void dispatch(View view, int i) {
        Resources.Theme theme;
        if (view == null) {
            return;
        }
        SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            theme = skinItem.getTheme();
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("The skin " + i + " does not exist");
            }
            theme = view.getContext().getTheme();
        }
        runDispatch(view, i, theme);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void runDispatch(View view, int i, Resources.Theme theme) {
        CharSequence text;
        ViewSkinCurrent viewSkinCurrent = getViewSkinCurrent(view);
        if (viewSkinCurrent != null && viewSkinCurrent.index == i && Objects.equals(viewSkinCurrent.managerName, this.mName)) {
            return;
        }
        view.setTag(R.id.qmui_skin_current, new ViewSkinCurrent(this.mName, i));
        if ((view instanceof IQMUISkinDispatchInterceptor) && ((IQMUISkinDispatchInterceptor) view).intercept(i, theme)) {
            return;
        }
        Object tag = view.getTag(R.id.qmui_skin_intercept_dispatch);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            return;
        }
        Object tag2 = view.getTag(R.id.qmui_skin_ignore_apply);
        int i2 = 0;
        boolean z = (tag2 instanceof Boolean) && ((Boolean) tag2).booleanValue();
        if (!z) {
            applyTheme(view, i, theme);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (sDispatchListenStrategySelector.select(viewGroup) == DispatchListenStrategy.LISTEN_ON_HIERARCHY_CHANGE) {
                viewGroup.setOnHierarchyChangeListener(mOnHierarchyChangeListener);
            } else {
                viewGroup.addOnLayoutChangeListener(mOnLayoutChangeListener);
            }
            while (i2 < viewGroup.getChildCount()) {
                runDispatch(viewGroup.getChildAt(i2), i, theme);
                i2++;
            }
            return;
        }
        if (z) {
            return;
        }
        boolean z2 = view instanceof TextView;
        if (z2 || (view instanceof QMUIQQFaceView)) {
            if (z2) {
                text = ((TextView) view).getText();
            } else {
                text = ((QMUIQQFaceView) view).getText();
            }
            if (text instanceof Spanned) {
                IQMUISkinHandlerSpan[] iQMUISkinHandlerSpanArr = (IQMUISkinHandlerSpan[]) ((Spanned) text).getSpans(0, text.length(), IQMUISkinHandlerSpan.class);
                if (iQMUISkinHandlerSpanArr != null) {
                    while (i2 < iQMUISkinHandlerSpanArr.length) {
                        iQMUISkinHandlerSpanArr[i2].handle(view, this, i, theme);
                        i2++;
                    }
                }
                view.invalidate();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void applyTheme(View view, int i, Resources.Theme theme) {
        SimpleArrayMap<String, Integer> skinAttrs = getSkinAttrs(view);
        try {
            if (view instanceof IQMUISkinHandlerView) {
                ((IQMUISkinHandlerView) view).handle(this, i, theme, skinAttrs);
            } else {
                defaultHandleSkinAttrs(view, theme, skinAttrs);
            }
            Object tag = view.getTag(R.id.qmui_skin_apply_listener);
            if (tag instanceof IQMUISkinApplyListener) {
                ((IQMUISkinApplyListener) tag).onApply(view, i, theme);
            }
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view;
                int itemDecorationCount = recyclerView.getItemDecorationCount();
                for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                    Object itemDecorationAt = recyclerView.getItemDecorationAt(i2);
                    if (itemDecorationAt instanceof IQMUISkinHandlerDecoration) {
                        ((IQMUISkinHandlerDecoration) itemDecorationAt).handle(recyclerView, this, i, theme);
                    }
                }
            }
        } catch (Throwable th) {
            QMUILog.printErrStackTrace(TAG, th, "catch error when apply theme: " + view.getClass().getSimpleName() + "; " + i + "; attrs = " + (skinAttrs == null ? "null" : skinAttrs.toString()), new Object[0]);
        }
    }

    void refreshRecyclerDecoration(RecyclerView recyclerView, IQMUISkinHandlerDecoration iQMUISkinHandlerDecoration, int i) {
        SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            iQMUISkinHandlerDecoration.handle(recyclerView, this, i, skinItem.getTheme());
        }
    }

    void refreshTheme(View view, int i) {
        SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            applyTheme(view, i, skinItem.getTheme());
        }
    }

    public void defaultHandleSkinAttrs(View view, Resources.Theme theme, SimpleArrayMap<String, Integer> simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i = 0; i < simpleArrayMap.size(); i++) {
                String strKeyAt = simpleArrayMap.keyAt(i);
                Integer numValueAt = simpleArrayMap.valueAt(i);
                if (numValueAt != null) {
                    defaultHandleSkinAttr(view, theme, strKeyAt, numValueAt.intValue());
                }
            }
        }
    }

    public void defaultHandleSkinAttr(View view, Resources.Theme theme, String str, int i) {
        if (i == 0) {
            return;
        }
        IQMUISkinRuleHandler iQMUISkinRuleHandler = sRuleHandlers.get(str);
        if (iQMUISkinRuleHandler == null) {
            QMUILog.w(TAG, "Do not find handler for skin attr name: " + str, new Object[0]);
        } else {
            iQMUISkinRuleHandler.handle(this, view, theme, str, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SimpleArrayMap<String, Integer> getSkinAttrs(View view) {
        String[] strArrSplit;
        SimpleArrayMap<String, Integer> defaultSkinAttrs;
        SimpleArrayMap<String, Integer> defaultSkinAttrs2;
        String str = (String) view.getTag(R.id.qmui_skin_value);
        if (str == null || str.isEmpty()) {
            strArrSplit = EMPTY_ITEMS;
        } else {
            strArrSplit = str.split("[|]");
        }
        SimpleArrayMap<String, Integer> simpleArrayMap = (!(view instanceof IQMUISkinDefaultAttrProvider) || (defaultSkinAttrs2 = ((IQMUISkinDefaultAttrProvider) view).getDefaultSkinAttrs()) == null || defaultSkinAttrs2.isEmpty()) ? null : new SimpleArrayMap<>(defaultSkinAttrs2);
        IQMUISkinDefaultAttrProvider iQMUISkinDefaultAttrProvider = (IQMUISkinDefaultAttrProvider) view.getTag(R.id.qmui_skin_default_attr_provider);
        if (iQMUISkinDefaultAttrProvider != null && (defaultSkinAttrs = iQMUISkinDefaultAttrProvider.getDefaultSkinAttrs()) != null && !defaultSkinAttrs.isEmpty()) {
            if (simpleArrayMap != null) {
                simpleArrayMap.putAll(defaultSkinAttrs);
            } else {
                simpleArrayMap = new SimpleArrayMap<>(defaultSkinAttrs);
            }
        }
        if (simpleArrayMap == null) {
            if (strArrSplit.length <= 0) {
                return null;
            }
            simpleArrayMap = new SimpleArrayMap<>(strArrSplit.length);
        }
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(":");
            if (strArrSplit2.length == 2) {
                String strTrim = strArrSplit2[0].trim();
                if (!QMUILangHelper.isNullOrEmpty(strTrim)) {
                    int attrFromName = getAttrFromName(strArrSplit2[1].trim());
                    if (attrFromName == 0) {
                        QMUILog.w(TAG, "Failed to get attr id from name: " + strArrSplit2[1], new Object[0]);
                    } else {
                        simpleArrayMap.put(strTrim, Integer.valueOf(attrFromName));
                    }
                }
            }
        }
        return simpleArrayMap;
    }

    public int getAttrFromName(String str) {
        return this.mResources.getIdentifier(str, "attr", this.mPackageName);
    }

    class SkinItem {
        private int styleRes;

        SkinItem(int i) {
            this.styleRes = i;
        }

        public int getStyleRes() {
            return this.styleRes;
        }

        Resources.Theme getTheme() {
            Resources.Theme theme = (Resources.Theme) QMUISkinManager.sStyleIdThemeMap.get(Integer.valueOf(this.styleRes));
            if (theme != null) {
                return theme;
            }
            Resources.Theme themeNewTheme = QMUISkinManager.this.mResources.newTheme();
            themeNewTheme.applyStyle(this.styleRes, true);
            QMUISkinManager.sStyleIdThemeMap.put(Integer.valueOf(this.styleRes), themeNewTheme);
            return themeNewTheme;
        }
    }

    public void register(Activity activity) {
        if (!containSkinObserver(activity)) {
            this.mSkinObserverList.add(new WeakReference<>(activity));
        }
        dispatch(activity.findViewById(android.R.id.content), this.mCurrentSkin);
    }

    public void unRegister(Activity activity) {
        removeSkinObserver(activity);
    }

    public void register(Fragment fragment) {
        if (!containSkinObserver(fragment)) {
            this.mSkinObserverList.add(new WeakReference<>(fragment));
        }
        dispatch(fragment.getView(), this.mCurrentSkin);
    }

    public void unRegister(Fragment fragment) {
        removeSkinObserver(fragment);
    }

    public void register(View view) {
        if (!containSkinObserver(view)) {
            this.mSkinObserverList.add(new WeakReference<>(view));
        }
        dispatch(view, this.mCurrentSkin);
    }

    public void unRegister(View view) {
        removeSkinObserver(view);
    }

    public void register(Dialog dialog) {
        if (!containSkinObserver(dialog)) {
            this.mSkinObserverList.add(new WeakReference<>(dialog));
        }
        Window window = dialog.getWindow();
        if (window != null) {
            dispatch(window.getDecorView(), this.mCurrentSkin);
        }
    }

    public void unRegister(Dialog dialog) {
        removeSkinObserver(dialog);
    }

    public void register(PopupWindow popupWindow) {
        if (!containSkinObserver(popupWindow)) {
            this.mSkinObserverList.add(new WeakReference<>(popupWindow));
        }
        dispatch(popupWindow.getContentView(), this.mCurrentSkin);
    }

    public void unRegister(PopupWindow popupWindow) {
        removeSkinObserver(popupWindow);
    }

    public void register(Window window) {
        if (!containSkinObserver(window)) {
            this.mSkinObserverList.add(new WeakReference<>(window));
        }
        dispatch(window.getDecorView(), this.mCurrentSkin);
    }

    public void unRegister(Window window) {
        removeSkinObserver(window);
    }

    private void removeSkinObserver(Object obj) {
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            Object obj2 = this.mSkinObserverList.get(size).get();
            if (obj2 == obj) {
                this.mSkinObserverList.remove(size);
                return;
            } else {
                if (obj2 == null) {
                    this.mSkinObserverList.remove(size);
                }
            }
        }
    }

    private boolean containSkinObserver(Object obj) {
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            Object obj2 = this.mSkinObserverList.get(size).get();
            if (obj2 == obj) {
                return true;
            }
            if (obj2 == null) {
                this.mSkinObserverList.remove(size);
            }
        }
        return false;
    }

    public void changeSkin(int i) {
        int i2 = this.mCurrentSkin;
        if (i2 == i) {
            return;
        }
        this.mCurrentSkin = i;
        this.mIsInSkinChangeDispatch = true;
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            Object obj = this.mSkinObserverList.get(size).get();
            if (obj == null) {
                this.mSkinObserverList.remove(size);
            } else if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                activity.getWindow().setBackgroundDrawable(QMUIResHelper.getAttrDrawable(activity, this.mSkins.get(i).getTheme(), R.attr.qmui_skin_support_activity_background));
                dispatch(activity.findViewById(android.R.id.content), i);
            } else if (obj instanceof Fragment) {
                dispatch(((Fragment) obj).getView(), i);
            } else if (obj instanceof Dialog) {
                Window window = ((Dialog) obj).getWindow();
                if (window != null) {
                    dispatch(window.getDecorView(), i);
                }
            } else if (obj instanceof PopupWindow) {
                dispatch(((PopupWindow) obj).getContentView(), i);
            } else if (obj instanceof Window) {
                dispatch(((Window) obj).getDecorView(), i);
            } else if (obj instanceof View) {
                dispatch((View) obj, i);
            }
        }
        for (int size2 = this.mSkinChangeListeners.size() - 1; size2 >= 0; size2--) {
            this.mSkinChangeListeners.get(size2).onSkinChange(this, i2, this.mCurrentSkin);
        }
        this.mIsInSkinChangeDispatch = false;
    }

    public void addSkinChangeListener(OnSkinChangeListener onSkinChangeListener) {
        if (this.mIsInSkinChangeDispatch) {
            throw new RuntimeException("Can not add skinChangeListener while dispatching");
        }
        this.mSkinChangeListeners.add(onSkinChangeListener);
    }

    public void removeSkinChangeListener(OnSkinChangeListener onSkinChangeListener) {
        if (this.mIsInSkinChangeDispatch) {
            throw new RuntimeException("Can not add skinChangeListener while dispatching");
        }
        this.mSkinChangeListeners.remove(onSkinChangeListener);
    }

    public int getCurrentSkin() {
        return this.mCurrentSkin;
    }

    class ViewSkinCurrent {
        int index;
        String managerName;

        ViewSkinCurrent(String str, int i) {
            this.managerName = str;
            this.index = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ViewSkinCurrent viewSkinCurrent = (ViewSkinCurrent) obj;
            return this.index == viewSkinCurrent.index && Objects.equals(this.managerName, viewSkinCurrent.managerName);
        }

        public int hashCode() {
            return Objects.hash(this.managerName, Integer.valueOf(this.index));
        }
    }
}
