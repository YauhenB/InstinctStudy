package study.library.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Book model.
 */

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "author")
    private String author;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "owner"))
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(final User owner) {
        this.owner = owner;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(final String author) {

        this.author = author;
    }

    @Override
    public String toString() {
        String ret = "\nID:" + this.id
                + "\nName:" + this.name
                + "\nAuthor:" + this.author
                + "\nOwner:";
        if (this.owner == null) {
            ret += "No owner";
        } else {
            ret += this.owner.getLogin();
        }
        return ret;
    }
}
