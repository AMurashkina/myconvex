public class Main {
    public static void main(String[] args) throws Exception{
        R3Vector a = new R3Vector(10, 0, 0);
        R3Vector b = new R3Vector(5, 5, 5);

        // a.out();// метод вызываемый от экземпляра класса
        //(a.sum(a.sum(a))).out();  //a.sum(a) = new R3Vector
        //R3Vector.sum(R3Vector.sum(a,a),a);  // сумма 3 векторов
        //(a.scale(2)).out();
        //(a.transiate(0,0,0)).out();
        //System.out.println(R3Vector.scalproizv(a,b));
        //(a.vectproizv(a,b)).out();
        //System.out.println(R3Vector.vectproizv(a,a));
       // Facet f = new Facet(new R3Vector(0,0,0),new R3Vector(0,1,0),new R3Vector(1,1,0),new R3Vector(1,0,0));
        //f.out();

        Cube c = new Cube();
        c.scale(100);
        c.rotate(30,30,30);
        //c.translate(-25,-25,-25);

        Viewer v = new Viewer(c);

    }

}
