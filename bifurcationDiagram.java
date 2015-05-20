import java.awt.*;
import java.util.*;
public class bifurcationDiagram{

   private static double r = 1.1;
   private static double x = 0.0;
   private static ArrayList<Point> values = new ArrayList<Point>();   
   
   public static void main(String[] args){
      
      DrawingPanel panel = new DrawingPanel(600,300);    //pixelValue = actualValue*100*1.5 
      Graphics g = panel.getGraphics();
      
      iterator(g);
   }
   
   public static double function(double x){
      return (r*(1-x)*x);
   }
   
   public static double functionDerivative(double x){
      return (r*(1-2*x));
   }
   
   // public static double stableValue(r){
//       return 1-(1-r);
//    }
   
   public static void iterator(Graphics g){
      
      double stableX = 1-(1/r);
      // while(Math.abs(functionDerivative(stableX))<1){
//          stableX = 1-(1/r);
//          values.add(new Point((r), function(stableX)));
//          r+=.1;
//       }
      pointCreator(stableX);
      for (int ii = 0; ii < values.size(); ii++){
         int xPixel = (int)(values.get(ii).getX()*150);
         System.out.println(xPixel);
         int yPixel = (int)(values.get(ii).getY()*150);
         System.out.println(300-yPixel);
         g.drawRect(xPixel, 300-yPixel, 2,2);
      }
   }
   
   public static void pointCreator(double stableX){
      while(Math.abs(functionDerivative(stableX))<1){
         stableX = 1-(1/r);
         values.add(new Point((r), function(stableX)));
         r+=.1;
      }
      //pointCreator(function(stableX));
   }
}