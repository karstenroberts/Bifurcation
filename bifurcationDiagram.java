import java.util.*;
public class bifurcationDiagram{

   private static double r = 3.0;
   private static double x = 0.0;
   private static ArrayList<Double> values = new ArrayList<Double>();
   
   
   public static void main(String[] args){
      for(double ii = x; Math.abs(functionDerivative(ii)) < 1; ii+=.1){
         values.add(function(ii));
      }
   }
   
   public static double function(double x){
      return (r*(1-x)*x);
   }
   
   public static double functionDerivative(double x){
      return (r*(1-2*x));
   }
}