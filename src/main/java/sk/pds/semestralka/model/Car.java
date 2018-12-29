package sk.pds.semestralka.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String fuelType;
    private float consumption;

    public Car() {
    }

    public Car(String name, String type, String fuelType, float consumption) {
        this.name = name;
        this.type = type;
        this.fuelType = fuelType;
        this.consumption = consumption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Float.compare(car.getConsumption(), getConsumption()) == 0 &&
                getId().equals(car.getId()) &&
                getName().equals(car.getName()) &&
                getType().equals(car.getType()) &&
                getFuelType().equals(car.getFuelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType(), getFuelType(), getConsumption());
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", type=" + type + ", fuelType=" + fuelType + ", consumption=" + consumption + '}';
    }
}
