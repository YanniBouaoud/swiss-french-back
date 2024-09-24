package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a pizza entity.
 */
@Entity
@Table(name = "car")
@CrossOrigin
public class Car {

    /** Unique ID of a pizza. */
    @Id
    @Column(name = "id")
    private Short id;

    /** Name of the pizza. */
    @Column(name = "name")
    private String name;

    /** Description of the pizza. */
    @Column(name = "description")
    private String description;

    /** URL for retrieving the picture of the pizza. */
    @Column(name = "image")
    private String image;

    /** Second image URL. */
    @Column(name = "image2")
    private String image2;

    /** Third image URL. */
    @Column(name = "image3")
    private String image3;

    /** Price of the pizza. */
    @Column(name = "price")
    private Double price;

    /**
     * Parameterized constructor.
     *
     * @param pId          The unique pId of the pizza.
     * @param pName        The pName of the pizza.
     * @param pDescription The pDescription of the pizza.
     * @param pImage       The pImage for retrieving the picture of the pizza.
     * @param pImage2      The second image for the pizza.
     * @param pImage3      The third image for the pizza.
     * @param pPrice       The pPrice of the pizza.
     */
    public Car(final Short pId, final String pName, final String pDescription, final String pImage,
            final String pImage2, final String pImage3, final Double pPrice) {
        super();
        this.id = pId;
        this.name = pName;
        this.description = pDescription;
        this.image = pImage;
        this.image2 = pImage2;
        this.image3 = pImage3;
        this.price = pPrice;
    }

    /**
     * Default constructor.
     */
    public Car() {
        super();
    }

    /**
     * Getter for ID.
     *
     * @return The ID of the pizza.
     */
    public Short getId() {
        return id;
    }

    /**
     * Setter for ID.
     *
     * @param pId The pId to set.
     */
    public void setId(final Short pId) {
        this.id = pId;
    }

    /**
     * Getter for name.
     *
     * @return The name of the pizza.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param pName The pName to set.
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Getter for description.
     *
     * @return The description of the pizza.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param pDescription The pDescription to set.
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * Getter for first image URL.
     *
     * @return The URL for retrieving the picture of the pizza.
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter for first image URL.
     *
     * @param pImage The pImage to set.
     */
    public void setImage(final String pImage) {
        this.image = pImage;
    }

    /**
     * Getter for second image URL.
     *
     * @return The second image URL.
     */
    public String getImage2() {
        return image2;
    }

    /**
     * Setter for second image URL.
     *
     * @param pImage2 The pImage2 to set.
     */
    public void setImage2(final String pImage2) {
        this.image2 = pImage2;
    }

    /**
     * Getter for third image URL.
     *
     * @return The third image URL.
     */
    public String getImage3() {
        return image3;
    }

    /**
     * Setter for third image URL.
     *
     * @param pImage3 The pImage3 to set.
     */
    public void setImage3(final String pImage3) {
        this.image3 = pImage3;
    }

    /**
     * Getter for price.
     *
     * @return The price of the pizza.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter for price.
     *
     * @param pPrice The pPrice to set.
     */
    public void setPrice(final Double pPrice) {
        this.price = pPrice;
    }

    /**
     * String representation of the object.
     *
     * @return String representation of the pizza.
     */
    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", image2="
                + image2 + ", image3=" + image3 + ", price=" + price + "]";
    }
}
