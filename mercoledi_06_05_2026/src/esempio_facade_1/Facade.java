package esempio_facade_1;

public class Facade {
    private SubsystemA a = new SubsystemA();
    private SubsystemB b = new SubsystemB();

    public void operazioneUnificata() {
        a.operationA();
        b.operationB();
    }
}
