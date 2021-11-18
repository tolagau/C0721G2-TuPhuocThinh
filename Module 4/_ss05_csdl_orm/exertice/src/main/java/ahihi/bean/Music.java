package ahihi.bean;


import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "idol")
    private String idol;
    @Column(name = "type_music")
    private String typeMusic;
    @Column(name = "link")
    private String link;

    public Music() {
    }

    public Music(Integer id, String name, String idol, String typeMusic, String link) {
        this.id = id;
        this.name = name;
        this.idol = idol;
        this.typeMusic = typeMusic;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdol() {
        return idol;
    }

    public void setIdol(String idol) {
        this.idol = idol;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
