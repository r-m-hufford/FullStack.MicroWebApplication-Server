package kelly.ryan.xiong.chatbot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DirectMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DM_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;
    @OneToMany(mappedBy = "directMessage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("channel")
    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectMessage that = (DirectMessage) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(users, that.users) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, messages);
    }

    @Override
    public String toString() {
        return "DirectMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }
}
