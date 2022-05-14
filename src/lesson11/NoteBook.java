package lesson11;

public class NoteBook {

    private int price;
    private double weight;
    private String brand;
    private String model;
    private String os;
    private String color;
    private String processor;
    private int monitorSize;

    private NoteBook(int price, double weight, String brand, String model, String os, String color, String processor, int monitorSize) {
        this.price = price;
        this.weight = weight;
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.color = color;
        this.processor = processor;
        this.monitorSize = monitorSize;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "price=" + price +
                ", weight=" + weight +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", processor='" + processor + '\'' +
                ", monitorSize=" + monitorSize +
                '}';
    }

    public static NoteBookBuilder builder() {
        return new NoteBookBuilder();
    }

    public static class NoteBookBuilder {

        private int price;
        private double weight;
        private String brand;
        private String model;
        private String os;
        private String color;
        private String processor;
        private int monitorSize;

        public NoteBookBuilder price(int price) {
            this.price = price;
            return this;
        }

        public NoteBookBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public NoteBookBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public NoteBookBuilder model(String model) {
            this.model = model;
            return this;
        }

        public NoteBookBuilder os(String os) {
            this.os = os;
            return this;
        }

        public NoteBookBuilder color(String color) {
            this.color = color;
            return this;
        }

        public NoteBookBuilder processor (String processor){
        this.processor = processor;
        return this;
        }

        public NoteBookBuilder monitorSize (int monitorSize) {
            this.monitorSize = monitorSize;
            return this;
        }

        public NoteBook build (){
            return new NoteBook(price, weight, brand, model, os, color,processor, monitorSize);
        }
    }
}
