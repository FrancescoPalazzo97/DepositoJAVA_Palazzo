// Esercizio 1
public class Book {
    private String id;
    private String title;
    private String author;
    private float price;
    private static int bookCounter = 0;

    public Book(String title, String author, float price) {
        bookCounter++;
        this.id = "code" + bookCounter;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  title='" + getTitle() + "',\n" +
                "  author='" + getAuthor() + "',\n" +
                "  price='" + getPrice() + "',\n" +
                "  code='" + getId() + "',\n" +
                "}\n";
    }

}
