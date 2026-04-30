package esercizio_observer_2;

public class S_User {
    private S_User istance;

    private S_User() {
    }

    public S_User getIstance() {

        if (istance == null) {
            istance = new S_User();
        }

        return istance;
    }

}
