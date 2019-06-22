
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class Time implements Runnable {
   Vector<VirtualPage> lru;

   Time(Vector<VirtualPage> lru) {
      this.lru = lru;
   }

   @Override
   public void run() {
      while (true) {
         lru.forEach(page -> page.increaseCounter());
         Collections.sort(this.lru, Comparator.comparing(page -> page.getCounter()));
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
