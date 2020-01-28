import java.awt.*;
import java.awt.geom.Path2D;
import java.nio.file.Path;

public class Facet {
    Color color;
    double  t1, t2, t3, t0;
    private R3Vector[] vertex;                  //контейнер для вершин
    public Facet(R3Vector v1,R3Vector v2,R3Vector v3,R3Vector v4, Color color){
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        this.color = color;
    }
    public void out(){
        for (int i = 0; i < 4; i++){
            vertex[i].out();
        }
    }
    public void rotate(double ux,double uy,double uz){
        for (int i = 0; i < 4; i++) {
            vertex[i].rotate(ux, uy, uz);
        }
    }
    public void scale(double k){
        for (int i = 0; i < 4; i++) {
            vertex[i].scale(k);
        }
    }
    public void translate(double dx,double dy, double dz){
        for (int i = 0; i < 4; i++) {
            vertex[i].translate(dx,dy,dz);
        }
    }

    public R3Vector normal(){
        return R3Vector.vectproizv( new R3Vector(vertex[1].getX() - vertex[0].getX(), vertex[1].getY() - vertex[0].getY(), vertex[1].getZ() - vertex[0].getZ()),
                                    new R3Vector(vertex[2].getX() - vertex[1].getX(), vertex[2].getY() - vertex[1].getY(), vertex[2].getZ() - vertex[1].getZ()));
    }

    public void draw(Graphics2D g) {
        Path2D p = new Path2D.Double();

        p.moveTo(vertex[0].getX(),vertex[0].getY());
        p.lineTo(vertex[1].getX(),vertex[1].getY());
        p.lineTo(vertex[2].getX(),vertex[2].getY());
        p.lineTo(vertex[3].getX(),vertex[3].getY());
        p.lineTo(vertex[0].getX(),vertex[0].getY());
        p.closePath();

        g.setColor(color);
        g.draw(p);

    }
    public void perspdraw(Graphics2D g) {
        Path2D p = new Path2D.Double();
        double cp = -200;

        t0 = (vertex[0].getZ() - cp) / (-cp);
        t1 = (vertex[1].getZ() - cp) / (-cp);
        t2 = (vertex[2].getZ() - cp) / (-cp);
        t3 = (vertex[3].getZ() - cp) / (-cp);

        R3Vector v1 = new R3Vector(vertex[0].getX()*t0,vertex[0].getY()*t0,vertex[0].getZ());
        R3Vector v2 = new R3Vector(vertex[1].getX()*t1,vertex[1].getY()*t1,vertex[1].getZ());
        R3Vector v3 = new R3Vector(vertex[2].getX()*t2,vertex[2].getY()*t2,vertex[2].getZ());
        R3Vector v4 = new R3Vector(vertex[3].getX()*t3,vertex[3].getY()*t3,vertex[3].getZ());

        Facet fac = new Facet(v1,v2,v3,v4,Color.gray);

        if((fac.normal()).getZ() > 0) {
        p.moveTo(vertex[0].getX()*t0,vertex[0].getY()*t0);
        p.lineTo(vertex[1].getX()*t1,vertex[1].getY()*t1);
        p.lineTo(vertex[2].getX()*t2,vertex[2].getY()*t2);
        p.lineTo(vertex[3].getX()*t3,vertex[3].getY()*t3);
        p.lineTo(vertex[0].getX()*t0,vertex[0].getY()*t0);
        p.closePath();

        g.setColor(color);
        g.fill(p);
        }

    }

}
