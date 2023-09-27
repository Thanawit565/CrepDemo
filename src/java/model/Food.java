 package model;


public class Food {

    private String name;
    private String type;
    private String[] nutrient;
    private String spicy;
    private int price;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the nutrient
     */
    public String[] getNutrient() {
        return nutrient;
    }

    /**
     * @param nutrient the nutrient to set
     */
    public void setNutrient(String[] nutrient) {
        this.nutrient = nutrient;
    }

    /**
     * @return the spicy
     */
    public String getSpicy() {
        return spicy;
    }

    /**
     * @param spicy the spicy to set
     */
    public void setSpicy(String spicy) {
        this.spicy = spicy;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

}
