import java.util.ArrayList;
import java.util.Vector;

class PhysicalMemory {
   Vector<Integer> physicalMemory = new Vector<Integer>();

   PhysicalMemory(int size) {
      for (int i = 0; i < size; i++) {
         physicalMemory.add(null);
      }
   }

   public ArrayList isFull() {
      ArrayList response = new ArrayList();
      response.add(true);
      response.add(-1);

      int address = 0;

      for (Integer element : physicalMemory) {
         if (element == null) {
            response.set(0, false);
            response.set(1, address);
            break;
         }
         address++;
      }

      return response;
   }

   public void printPhysicalMemory() {
      System.out.println(">>>>> Memória Ram <<<<<<");
      System.out.print("[ ");
      physicalMemory.forEach(value -> System.out.print(value + " "));
      System.out.println("]");
   }

}
