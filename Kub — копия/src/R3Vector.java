import java.awt.*;


public class R3Vector {
    private double x,y,z;

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

    public R3Vector(double x, double y, double z){ //конструктор
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void out(){
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
    public R3Vector sum(R3Vector a){
        //x += a.x;
        //y += a.y;
        //z += a.z;      //получили сумму но испортили - а векто
        return new R3Vector(x + a.x ,y + a.y,z + a.z);
    }
    public static R3Vector sum(R3Vector a,R3Vector b){
        return new R3Vector(a.x + b.x ,a.y + b.y ,a.z + b.z );
    }

    public void scale(double k){  //масштабирование
        x *= k;
        y *= k;
        z *= k;
    }
    public void translate(double dx,double dy, double dz){
       x += dx;
       y += dy;
       z += dz;
    }
    public static double scalproizv(R3Vector a,R3Vector b){
        double sc = a.x*b.x + a.y*b.y + a.z*b.z ; // кажетс это ошибка
        return sc;
    }
    public static R3Vector vectproizv(R3Vector a,R3Vector b) {
        return new R3Vector(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }
    public void rotateX(double ux){
        ux = ux*Math.PI/180;
        double yX = y*Math.cos(ux)-z*Math.sin(ux);
        double zX = z*Math.cos(ux)+y*Math.sin(ux);
        y = yX;
        z = zX;
    }
    public void rotateY(double uy){
        uy =uy*Math.PI/180;
        double xY = x*Math.cos(uy)-z*Math.sin(uy);
        double zY= z*Math.cos(uy)+x*Math.sin(uy);
        x = xY;
        z = zY;
    }
    public void rotateZ(double uz){
        uz =uz*Math.PI/180;
        double yZ = y*Math.cos(uz)-x*Math.sin(uz);
        double xZ = x*Math.cos(uz)+y*Math.sin(uz);
        x = xZ;
        y = yZ;
    }
    public void rotate(double ux,double uy,double uz ){
        this.rotateX(ux);
        this.rotateY(uy);
        this.rotateZ(uz);
    }



}
