
package entities;
import java.util.List;

public class Book {
    String title;
    String author;
    int date;
    String publisher;
    int cost;
    int count;

    public Book(String title, String author, int date, String publisher, int cost, int count) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.publisher = publisher;
        this.cost = cost;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int totalPrice(List<Book> bookList)
    {
        int sum=0;
        for (Book l: bookList )
        {
            sum+=l.cost;
        }
        return sum;
    }
    public static int totalCount(List<Book> bookList)
    {
        int count=0;
        for (Book l: bookList )
        {
            count+=l.count;
        }
        return count;
    }
}
