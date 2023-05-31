package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Column
    private int series;
    @Column
    private String model;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "car")
    private User user;

    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {}

    public String getModel () {
        return model;
    }
    public int getSeries () {
        return series;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return model + " " + series;
    }
}