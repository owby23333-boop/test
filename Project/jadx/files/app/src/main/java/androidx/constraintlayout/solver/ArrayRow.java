package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable variable = null;
    float constantValue = 0.0f;
    boolean used = false;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();
    boolean isSimpleDefinition = false;

    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f2, boolean z2);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f2);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i2);

        float getVariableValue(int i2);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f2);

        float remove(SolverVariable solverVariable, boolean z2);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z2);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < currentSize; i2++) {
            float variableValue = this.variables.getVariableValue(i2);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i2);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f2)) {
                    f2 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i2) {
        this.variables.put(linearSystem.createErrorVariable(i2, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i2, "em"), -1.0f);
        return this;
    }

    ArrayRow addSingleError(SolverVariable solverVariable, int i2) {
        this.variables.put(solverVariable, i2);
        return this;
    }

    boolean chooseSubject(LinearSystem linearSystem) {
        boolean z2;
        SolverVariable solverVariableChooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (solverVariableChooseSubjectInVariables == null) {
            z2 = true;
        } else {
            pivot(solverVariableChooseSubjectInVariables);
            z2 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return z2;
    }

    SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        float f3 = 0.0f;
        boolean z3 = false;
        for (int i2 = 0; i2 < currentSize; i2++) {
            float variableValue = this.variables.getVariableValue(i2);
            SolverVariable variable = this.variables.getVariable(i2);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f2 > variableValue) {
                    boolean zIsNew = isNew(variable, linearSystem);
                    z2 = zIsNew;
                    f2 = variableValue;
                    solverVariable = variable;
                } else if (!z2 && isNew(variable, linearSystem)) {
                    f2 = variableValue;
                    solverVariable = variable;
                    z2 = true;
                }
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null || f3 > variableValue) {
                    boolean zIsNew2 = isNew(variable, linearSystem);
                    z3 = zIsNew2;
                    f3 = variableValue;
                    solverVariable2 = variable;
                } else if (!z3 && isNew(variable, linearSystem)) {
                    f3 = variableValue;
                    solverVariable2 = variable;
                    z3 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.constantValue = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = i2;
        } else if (f2 >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -i3;
        } else {
            float f3 = 1.0f - f2;
            this.variables.put(solverVariable, f3 * 1.0f);
            this.variables.put(solverVariable2, f3 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f2);
            this.variables.put(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.constantValue = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    ArrayRow createRowDefinition(SolverVariable solverVariable, int i2) {
        this.variable = solverVariable;
        float f2 = i2;
        solverVariable.computedValue = f2;
        this.constantValue = f2;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f2);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f2);
        this.variables.put(solverVariable4, -f2);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f2, float f3, float f4, SolverVariable solverVariable, int i2, SolverVariable solverVariable2, int i3, SolverVariable solverVariable3, int i4, SolverVariable solverVariable4, int i5) {
        if (f3 == 0.0f || f2 == f4) {
            this.constantValue = ((-i2) - i3) + i4 + i5;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.constantValue = ((-i2) - i3) + (i4 * f5) + (i5 * f5);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f5);
            this.variables.put(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f5);
            this.variables.put(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i2) {
        if (i2 < 0) {
            this.constantValue = i2 * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = i2;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.constantValue = i2;
        }
        if (z2) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.constantValue = i2;
        }
        if (z2) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f2;
        return this;
    }

    void ensurePositiveConstant() {
        float f2 = this.constantValue;
        if (f2 < 0.0f) {
            this.constantValue = f2 * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        return solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i2 = 0; i2 < arrayRow.variables.getCurrentSize(); i2++) {
                this.variables.add(arrayRow.variables.getVariable(i2), arrayRow.variables.getVariableValue(i2), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable = null;
        }
        float fRemove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (fRemove == 1.0f) {
            return;
        }
        this.constantValue /= fRemove;
        this.variables.divideByAmount(fRemove);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        return (this.variable != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String toReadableString() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayRow.toReadableString():java.lang.String");
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2) {
        if (solverVariable.isFinalValue) {
            this.constantValue += solverVariable.computedValue * this.variables.get(solverVariable);
            this.variables.remove(solverVariable, z2);
            if (z2) {
                solverVariable.removeFromRow(this);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(ArrayRow arrayRow, boolean z2) {
        this.constantValue += arrayRow.constantValue * this.variables.use(arrayRow, z2);
        if (z2) {
            arrayRow.variable.removeFromRow(this);
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z2 = false;
        while (!z2) {
            int currentSize = this.variables.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                SolverVariable variable = this.variables.getVariable(i2);
                if (variable.definitionId != -1 || variable.isFinalValue) {
                    this.variablesToUpdate.add(variable);
                }
            }
            if (this.variablesToUpdate.size() > 0) {
                for (SolverVariable solverVariable : this.variablesToUpdate) {
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem.mRows[solverVariable.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z2 = true;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i2 = solverVariable.strength;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f2);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.constantValue = i2;
        }
        if (!z2) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i2, SolverVariable solverVariable2) {
        this.constantValue = i2;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
