package study.library.model;


import javax.persistence.*;

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

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    @Override
    public String toString() {
        String ret = "\nID:" + this.id +
                "\nName:" + this.name +
                "\nAuthor:" + this.author +
                "\nOwner:";
        if (this.owner != null)
            ret += this.owner.getLogin();
        else
            ret += "No owner";
        return ret;
    }
}
