// Esercizio 1
public class Student {
    static private int id;
    private String name;
    private int vote;

    public Student() {
        id++;
        this.name = "Sconosciuto";
        this.vote = 0;
    }

    public Student(String name, int vote) {
        id++;
        this.name = name;
        this.vote = vote;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return this.vote;
    }

    public void setVote(int vote) {
        boolean isVoteValid = vote > 0 && vote < 10;
        if (!isVoteValid) {
            System.out.println("Il voto inserito non è valido. Inserisci un voto compreso tra 0 e 10");
            return;
        }

        System.out.println("Il voto è stato modificato da " + this.vote + " a " + vote);
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", vote='" + getVote() + "'" +
                "}";
    }

}
