import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mohru on 03.01.2017.
 */
public class MainClass2 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Ala");
        strings.add("ma");
        strings.add("kota");

        printList(strings);

        System.out.println();

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        printList(ints);

        System.out.println();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Circle());
        shapes.add(new Rectangle());

        drawShapes(shapes);

        System.out.println();

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());

        //drawShapes(circles);
        drawShapesW(circles);


        //  przyklad ze nie mozemy usuwac elementow listy podczas iterowania po niej
        //  zapomnialam powiedziec, a to wazne - tez mnie kiedys o to na rozmowie pytali ;P

        /*for (Circle circle : circles) {
            circles.remove(circle);
        }*/

        // bezpieczne usuwanie w petli tylko przy uzyciu iteratora lub CopyOnWriteArrayList
        for (Iterator<Circle> it = circles.iterator(); it.hasNext(); ) {
            it.next();
            it.remove();
        }
    }

 /*   public static void printList(List<Object> list){
        list.forEach(System.out::println);
    }*/

    public static void printList(List<?> list) {
        for (Object a : list) {
            System.out.println(a);
        }
    }

    public static void drawShapes(List<Shape> shapes) {
        shapes.forEach(Shape::draw);
    }

    public static void drawShapesW(List<? extends Shape> shapes) {
        shapes.forEach(Shape::draw);
    }

    public void addingToList(List<? super Shape> list) {
        list.add(new Circle());
    }
}

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing circle");
    }

    final void f() {
        System.out.println("costam");
    }
}

class Class1 extends Circle {

   /* @Override
    void f() {
    }*/
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}