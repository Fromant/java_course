package interfaces.interfaces.usage_examples;

import interfaces.interfaces.PubInterface;
import interfaces.interfaces.practice1.PrivInterface;
// error: private interface cannot be accessed from outside package
class Practice1 implements PrivInterface {
    @Override
    public void doSomething() {

    }
}

// all OK with public interface
class Practice2 implements PubInterface {
    @Override
    public void doSomething() {

    }
}
