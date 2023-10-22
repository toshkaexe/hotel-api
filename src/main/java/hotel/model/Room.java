package hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="ROOM_NUMBER")
    private String number;
    @Column(name="NAME")
    private String name;
    @Column(name="BED_INFO")
    private String info;

    public Room(long id, String number, String name, String info) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.info = info;
    }

    public Room() {

    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
