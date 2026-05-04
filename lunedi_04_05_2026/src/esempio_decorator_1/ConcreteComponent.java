package esempio_decorator_1;

//Componente concreto
public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("Operazione  base");
    }
}
