package com.example.a2;

public class Pojo {

    public class Weight{
        public String imperial;
        public String metric;

        public String getImperial() {
            return imperial;
        }

        public String getMetric() {
            return metric;
        }

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }
    }

    public class Height{
        public String imperial;
        public String metric;

        public String getImperial() {
            return imperial;
        }

        public String getMetric() {
            return metric;
        }

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }
    }



    //public class Root{
        public Weight weight;
        public Height height;
        public int id;
        public String name;
        public String bred_for;
        public String breed_group;
        public String life_span;
        public String temperament;
        public String origin;
        public String reference_image_id;
        public Image image;
        public String country_code;
   // }


    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Weight getWeight() {
        return weight;
    }

    public Height getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBred_for() {
        return bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public Image getImage() {
        return image;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
