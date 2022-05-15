package lesson11;

public class Main {

    public static void main(String[] args) {

        NoteBook noteBook = NoteBook.builder()
                .price(300)
                .os("Windows")
                .monitorSize(14)
                .processor("Intel")
                .brand("Lenovo")
                .color("Black")
                .model("Legion")
                .weight(1.2)
                .build();

        System.out.println(noteBook.toString());
    }
}
