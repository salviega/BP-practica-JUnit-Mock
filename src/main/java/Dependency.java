public class Dependency {

    private final SubDependency subDependency;

    public Dependency(SubDependency subDependency) {
        super();
        this.subDependency = subDependency;
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }
    public String getSubdependencyClassName() {
        return getSubDependency().getClassName();
    }
    public String getClassNameUpperCase() {
        return getClassName().toUpperCase();
    }
    public SubDependency getSubDependency() {
        return subDependency;
    }
    public int  AddTwo(int number) {
        if (number == 1) {
            return 5;
        }
        return 0;
    }
}


