
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Time implements Runnable {
   Vector<VirtualPage> lru;

   Time(Vector<VirtualPage> lru) {
      this.lru = lru;
   }

   // Incrementa o contador de todos que tiverem na mémoria ram e ordena
   @Override
   public void run() {
      while (true) {
         lru.forEach(page -> {
            page.increaseCounter();
            // System.out.print(page.getCounter() + ", ");
         });
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         Collections.sort(this.lru, Comparator.comparing(page -> page.getCounter()));
      }
   }
}
