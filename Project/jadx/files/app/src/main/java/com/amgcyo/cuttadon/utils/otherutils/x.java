package com.amgcyo.cuttadon.utils.otherutils;

import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.comic.CategoryComicBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: MkBookUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class x {
    public static List<ShelfCategory> a(List<MkBook> list) {
        TreeMap treeMap = new TreeMap();
        ArrayList arrayList = new ArrayList();
        for (MkBook mkBook : list) {
            if (treeMap.containsKey(mkBook.getBook_shelf_category())) {
                List list2 = (List) treeMap.get(mkBook.getBook_shelf_category());
                if (list2 != null) {
                    list2.add(mkBook);
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(mkBook);
                treeMap.put(mkBook.getBook_shelf_category(), arrayList2);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ShelfCategory shelfCategory = new ShelfCategory();
            List<MkBook> list3 = (List) entry.getValue();
            String str = (String) entry.getKey();
            shelfCategory.setCategoryCount(list3.size());
            shelfCategory.setArtBookList(list3);
            if (TextUtils.isEmpty(str)) {
                shelfCategory.setCategoryName("");
            } else {
                shelfCategory.setCategoryName(str);
            }
            arrayList.add(shelfCategory);
        }
        return arrayList;
    }

    public static List<ShelfCategory> b(List<MkBook> list) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (MkBook mkBook : list) {
            if (map.containsKey(mkBook.getBook_shelf_category())) {
                List list2 = (List) map.get(mkBook.getBook_shelf_category());
                if (list2 != null) {
                    list2.add(mkBook);
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(mkBook);
                map.put(mkBook.getBook_shelf_category(), arrayList2);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            ShelfCategory shelfCategory = new ShelfCategory();
            ArrayList arrayList3 = new ArrayList();
            List<MkBook> list3 = (List) entry.getValue();
            String str = (String) entry.getKey();
            shelfCategory.setCategoryCount(list3.size());
            if (TextUtils.isEmpty(str)) {
                shelfCategory.setCategoryName("");
            } else {
                shelfCategory.setCategoryName(str);
            }
            for (MkBook mkBook2 : list3) {
                arrayList3.add(new CategoryComicBean(mkBook2.getImage(), mkBook2.getForm()));
            }
            shelfCategory.setCategoryPics(arrayList3);
            arrayList.add(shelfCategory);
        }
        boolean z2 = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(((ShelfCategory) it.next()).getCategoryName())) {
                z2 = true;
            }
        }
        if (!z2) {
            ShelfCategory shelfCategory2 = new ShelfCategory();
            shelfCategory2.setCategoryName("");
            arrayList.add(shelfCategory2);
        }
        return arrayList;
    }
}
