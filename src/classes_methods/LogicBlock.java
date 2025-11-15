package classes_methods;

class GivenClass {
    // non-static logic block - called right before ctor
    {
        System.out.println("logic (1) id= " + this.id);
    }

    // static logic block - called first, at very start of program - static initialization
    static {
        System.out.println("static logic");
    }

    private int id = 1;

    //ctor
    public GivenClass(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);
    }

    //another logic block - called before ctor but after first logic block.
    {
        System.out.println("logic (2) id= " + id);
    }
}

public class LogicBlock {
    public static void main(String[] args) {
        new GivenClass(100); //calling ctor
    }
}
