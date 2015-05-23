import java.awt.*;
import java.util.*;
public class bifurcationDiagram{

   //private static double r = 1.1;
   //private static double x = 0.0;
   private static ArrayList<Point> values = new ArrayList<Point>();   
   
   public static void main(String[] args){
      
      DrawingPanel panel = new DrawingPanel(600,300);    //pixelValue = actualValue*100*1.5 
      Graphics g = panel.getGraphics();
      double r = 1.1;
      double x = 0.0;
      
      iterator(g,r,x);
   }
   
   public static double function(double x, double r){
      return (r*(1-x)*x);
   }
   
   public static double functionDerivative(double x, double r){
      return (r*(1-2*x));
   }
   
   public static void iterator(Graphics g, double r, double x){
      
      double stableX = 1-(1/r);
      pointCreator(stableX,r);
      for (int ii = 0; ii < values.size(); ii++){
         int xPixel = (int)(values.get(ii).getX()*150);
         System.out.println(xPixel);
         int yPixel = (int)(values.get(ii).getY()*150);
         System.out.println(300-yPixel);
         g.drawRect(xPixel, 300-yPixel, 2,2);
      }
   }
   
   public static void pointCreator(double stableX, double r){
      do{
         stableX = 1-(1/r);
         values.add(new Point((r), function(stableX, r)));
         r+=.1;
      }while(Math.abs(functionDerivative(stableX, r))<1);
      int k = 5;
      bifurcationPoints(stableX, r, k);
   }
   
   public static double stableX(double r){
      return 1-(1/r);
   }
   
   public static void bifurcationPoints(double stableX, double r, int k){
      stableX = firstStableX(r);
      double doubleDerivative = functionDerivative(functionDerivative(stableX, r), r);
      do{
         values.add(new Point(r, firstStableX(r)));
         values.add(new Point(r, secondStableX(r)));
         double x1 = firstStableX(r);
         double x2 = secondStableX(r);
//         bifurcationPoints(x1,r, k-1);
//         bifurcationPoints(x2,r, k-1);
         r+=.1;
      }while(Math.abs(functionDerivative(functionDerivative(stableX, r), r)) < 1 && k > 0);
   }
   
//    public static double firstStableX(double r){
//       return (Math.pow(r,2) + Math.sqrt(Math.pow(r,2) - 4*(r-1)*Math.pow(r,3)))/(2*(r-1));
//    }
//    
   public static double firstStableX(double r){
      return (-1*Math.sqrt(Math.pow(r,2) - 2*r - 3) + r + 1)/(2*r + 2);
   }

   public static double secondStableX(double r){
      return (Math.sqrt(Math.pow(r,2) - 2*r - 3) + r + 1)/(2*r + 2);
   }
}