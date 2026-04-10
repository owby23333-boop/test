package com.amgcyo.cuttadon.widget.lovelydialog;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: LovelyChoiceDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.amgcyo.cuttadon.widget.lovelydialog.a<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f5659f;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.widget.lovelydialog.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LovelyChoiceDialog.java */
    private class C0123b<T> implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private c<T> f5660s;

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
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c<T> cVar = this.f5660s;
            if (cVar != 0) {
                cVar.a(i2, adapterView.getItemAtPosition(i2));
            }
            b.this.a();
        }

        private C0123b(c<T> cVar) {
            this.f5660s = cVar;
        }
    }

    /* JADX INFO: compiled from: LovelyChoiceDialog.java */
    public interface c<T> {
        void a(int i2, T t2);
    }

    public b(Context context) {
        super(context);
        this.f5659f = (ListView) b(R.id.ld_choices);
    }

    public <T> b a(ArrayAdapter<T> arrayAdapter, c<T> cVar) {
        this.f5659f.setOnItemClickListener(new C0123b(cVar));
        this.f5659f.setAdapter((ListAdapter) arrayAdapter);
        return this;
    }

    @Override // com.amgcyo.cuttadon.widget.lovelydialog.a
    protected int b() {
        return R.layout.dialog_choice;
    }
}
