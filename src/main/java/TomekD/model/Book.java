package TomekD.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book extends BaseEntity {

    @NotNull
    @Length(min = 2, max = 255)
    private String title;

    @NotNull
    @Length(min = 3, max = 255, message = "Podaj dlugosc od {min} do {max}")
    private String author;

    @Min(0)
    private Integer available;

    public Book() {  }

    public Book(String title, String author, Integer available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public void decrementQuantity(){
        available--;
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

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
