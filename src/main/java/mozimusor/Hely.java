package mozimusor;
import jakarta.persistence.*;

@Entity
@Table(name = "hely")

public class Hely {
    @Id
    private Integer fkod;
    private Integer moziazon;

    public Integer getFkod() {
        return fkod;
    }

    public void setFkod(Integer fkod) {
        this.fkod = fkod;
    }

    public Integer getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Integer moziazon) {
        this.moziazon = moziazon;
    }
}
