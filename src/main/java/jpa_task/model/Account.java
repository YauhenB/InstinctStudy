package jpa_task.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "owner"))
    private Client owner;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nId: " + this.getId().toString()
                + "\nLogin: " + this.getLogin()
                + "\nPassword: " + this.getPassword()
                + "\nOwner id:" + owner.getId();
    }


}
