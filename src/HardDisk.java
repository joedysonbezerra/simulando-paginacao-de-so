import java.util.ArrayList;
import java.util.Random;

class HardDisk {
   ArrayList<ArrayList<Integer>> hd = new ArrayList<ArrayList<Integer>>();

   public void setHD(int size) {
      ArrayList<Integer> processData = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
         processData.add(new Random().nextInt(26));
      }

      hd.add(processData);
   }

   public Integer getProcessData(int processAddress, int dataAddress) {
      return this.hd.get(processAddress).get(dataAddress);
   }

   public void setProcessData(int processAddress, int dataAddress, int value) {
      this.hd.get(processAddress).set(dataAddress, value);
   }

   public void printHardDisk() {
      int i = 0;
      for (ArrayList<Integer> processData : this.hd) {
         System.out.println(">>>>> Dados do Programa em execução - " + i + " <<<<<");
         System.out.print("[ ");
         processData.forEach(value -> System.out.print(value + " "));
         System.out.println("]");
         i++;
      }
   }

}
