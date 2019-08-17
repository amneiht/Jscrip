import java.util.*;
import java.util.Map.Entry;

public class HashMapDemo {

   public static void main(String args[]) {
   
      // Tao mot hash map
      HashMap<String,Double> hm = new HashMap<String,Double>();
      // Dat cac phan tu vao map
      hm.put("Zara", new Double(3434.34));
      hm.put("Mahnaz", new Double(123.22));
      hm.put("Ayan", new Double(1378.00));
      hm.put("Daisy", new Double(99.22));
      hm.put("Qadir", new Double(-19.08));
      
      // Lay mot tap hop cac entry
      Set<Entry<String, Double>> set = hm.entrySet();
      // Lay mot iterator
      Iterator<Entry<String, Double>> i = set.iterator();
      // Hien thi cac phan tu
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Gui 1000 vao trong tai khoan cua Zara
      double balance = ((Double)hm.get("Zara")).doubleValue();
      hm.put("Zara", new Double(balance + 1000));
      Object ds=hm.get("Zarsa");
      double p=0.0;
      if(ds!=null ) p=(double)ds;
      System.out.println("Balance hien tai cua Zara la: " +
      p);
   }
}