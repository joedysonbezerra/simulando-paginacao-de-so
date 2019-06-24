import java.util.ArrayList;
import java.util.Vector;

class PhysicalMemory {
   Vector<Integer> physicalMemory = new Vector<Integer>();

   PhysicalMemory(int size) {
      for (int i = 0; i < size; i++) {
         physicalMemory.add(null);
      }
   }

   public int isFull() {
      int response = -1;
      int address = 0;

      for (Integer element : physicalMemory) {
         if (element == null) {
            response = address;
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

   public void setPhysicalMemory(int value, int address) {
      physicalMemory.set(address, value);
   }

   public Integer getValue(int address) {
      return physicalMemory.get(address);
   }

}
