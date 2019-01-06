package sk.pds.semestralka.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Arrays;
import java.util.Objects;

public class CarPicture {
    private int pictureId;
    private String name;
    private String subName;
    private String type;
    private String color;
    @Lob
    @Column(name="picture")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] picture;

    public CarPicture() {
    }

    public CarPicture(int pictureId, String name, String subName, String type, String color, byte[] picture) {
        this.pictureId = pictureId;
        this.name = name;
        this.subName = subName;
        this.type = type;
        this.color = color;
        this.picture = picture;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPicture)) return false;
        CarPicture that = (CarPicture) o;
        return getPictureId() == that.getPictureId() &&
                getName().equals(that.getName()) &&
                getSubName().equals(that.getSubName()) &&
                getType().equals(that.getType()) &&
                getColor().equals(that.getColor()) &&
                Arrays.equals(getPicture(), that.getPicture());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getPictureId(), getName(), getSubName(), getType(), getColor());
        result = 31 * result + Arrays.hashCode(getPicture());
        return result;
    }

    @Override
    public String toString() {
        return "CarPicture{" +
                "pictureId=" + pictureId +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
