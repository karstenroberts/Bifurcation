import java.awt.*;
import java.util.*;
public class BifurcationDiagram{



   //To show the full graph in domain (0,4), switch width and height to something with 4:1 ratio (i.e. width = 1200 height = 300), and change xShift to 0, 



   /**
   *This ArrayList contains all points to be graphed
   */
   private static ArrayList<Point> values = new ArrayList<Point>();   
   /**
   *This is the value that controls how accurate you wish to be. Default is +/- .001 from the actual value.
   */
   public static final double accuracyValue = .001;
   
   public static final int width = 1100; //proportion width:heigth should be 4:1
   public static final int height = 1100;
   public static final int xShift = 3300;

   /**
   *This is the main method
   *
   *@param args
   */
   public static void main(String[] args){
      double r = 1.1;
      double x = 0;
      
      DrawingPanel panel = new DrawingPanel(width,height);//pixel value = actual value * 300
      Graphics g = panel.getGraphics();
      
      pointCreator4(r,x);
      graphCreator(g);
   }

   /**
   *This function is the recursive solution, but turned out too be far to taxing on the computer and took 3+ hours to run on a low granularit.
   *
   *@param r This is the value of r
   *@param x this is the initial value of x
   *@param iterations This is the number of times to recurse
   *@return This program returns the value of x given that initial x at the given value of r 
   */
   //THIS IS NOT USED, DO NOT USE THIS METHOD, YOU WILL DIE BEFORE IT ACTUALLY FINISHES. LITERALLY.
   public static double function(double r, double x, int iterations){
      if(iterations == 0){
         System.out.println(x);
         return (r*(1-x)*x);
      }
      else{
         System.out.println(iterations);
         return r*(1-function(r,x,iterations-1))*function(r,x,iterations-1);
      }
   }
   
   /**
   *This is the method I ended up using to calculate the end value of x. I have recursed twice already.
   *
   *@param r This is the value of r
   *@param x This is the initial value of x
   *@return This method returnsthe value of x given the intial x at the geven value of r
   */
   public static double function(double r, double x){
      //return r*(1-(r*(1-x)*x))*(r*(1-x)*x);
      return r*(1-(r*(1-(r*(1-x)*x))*(r*(1-x)*x)))*(r*(1-(r*(1-x)*x))*(r*(1-x)*x));
   }
      
   /**
   *This method calculates the coordinates of each point, and then creates a point object using those coordinates and adds it to an ArrayList
   *
   *@param r This is the value of r
   *@param x This is the initial value of x
   */
   public static void pointCreator4(double r, double x){
      for(double rIncrement = r; rIncrement < 4; rIncrement+=.0001){
         for(double xIncrement = 0.01; xIncrement < 1.0; xIncrement += .0001){
            if(Math.abs(function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,xIncrement)))))))))))))))))))))))))))))))) - xIncrement) < accuracyValue){//This determines if the given point is part of the graph, because the output of the recursive function should be equal to the initial value of x.
               if(!((function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,xIncrement-accuracyValue))))))))))))))))))))))))))))))))<xIncrement-accuracyValue) //The
               && (function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement, function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,function(rIncrement,xIncrement+accuracyValue))))))))))))))))))))))))))))))))>xIncrement+accuracyValue))){//This determines if the point is part of the graph, because for each iteration only every other intersection for each value of r actually is graphed, and all of those that shouldn't be come from above the line, and exit below 
                  values.add(new Point(rIncrement, xIncrement));
               }
            }
         }
      }
   }
   
   /**
   *This method graphs all of the points in the ArrayList. Commented out section draws a line at the beginning of chaotic behavior.
   *
   *@param g This is the graphics object that the points are printed out on
   */
   public static void graphCreator(Graphics g){
      for(int ii = 0; ii < values.size(); ii += 1){
         g.drawRect((int)(values.get(ii).getX()*(height))-xShift, (int)(height-(values.get(ii).getY()*(height))), 0,0);
      }
      /*for(int jj = 0; jj <= 600; jj++){
         g.setColor(Color.RED);
         g.drawRect(1070, jj,1,1);
      }*/
   }
}