import java.awt.*;

public class Cube {
    private Facet[] facets;

    public Cube(){
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 1 ,0), new R3Vector(1, 1,0), new R3Vector(1, 0,0), Color.black);
        facets[1] = new Facet(new R3Vector(1, 0, 0), new R3Vector(1, 1 ,0), new R3Vector(1, 1,1), new R3Vector(1, 0,1), Color.green);     ////
        facets[2] = new Facet(new R3Vector(0, 1, 1), new R3Vector(0, 0 ,1), new R3Vector(1, 0,1), new R3Vector(1, 1,1), Color.pink);
        facets[3] = new Facet(new R3Vector(0, 1, 0), new R3Vector(0, 1 ,1), new R3Vector(1, 1,1), new R3Vector(1, 1,0), Color.yellow);  //
        facets[4] = new Facet(new R3Vector(0, 0, 0), new R3Vector(0, 0 ,1), new R3Vector(0, 1,1), new R3Vector(0, 1,0), Color.blue);   //
        facets[5] = new Facet(new R3Vector(1, 0, 1), new R3Vector(0, 0 ,1), new R3Vector(0, 0,0), new R3Vector(1, 0,0), Color.red);   /////
    }
    public void rotate(double ux,double uy,double uz){
        for (int i = 0; i < 6; i++) {
            facets[i].rotate(ux, uy, uz);
        }
    }
    public void scale(double k){
        for (int i = 0; i < 6; i++) {
            facets[i].scale(k);
        }
    }
    public void translate(double dx,double dy, double dz){
        for (int i = 0; i < 6; i ++) {
            facets[i].translate(dx,dy,dz);
        }
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < 6; i++){
            facets[i].draw(g);
        }
    }

    public void perspdraw(Graphics2D g){
        for (int i = 0; i < 6; i++){
            facets[i].perspdraw(g);
        }
    }

}
