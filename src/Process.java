import java.util.Objects;

class Process extends Thread {
   private int pid;
   private int firstAddressMemory;
   private MMUI mmu;
   private String operations[];

   Process(int pid, int firstAddressMemory, MMUI mmu) {
      this.pid = pid;
      this.firstAddressMemory = firstAddressMemory;
      this.mmu = mmu;
   }

   public void getInput() {
      String input = "5-R,6-R,7-R,2-W,1-W,3-R,6-W,1-W,0-R,1-W,0-W,4-R,5-R,7-W,1-R,2-W";
      this.operations = input.split(",");
   }

   public void executeOperations() {
      for (String operation : this.operations) {
         if (Objects.equals(operation.substring(2), "R")) {
            mmu.read(firstAddressMemory, pid);
         } else {
            mmu.write(firstAddressMemory, pid);
         }
      }
   }

   @Override
   public void run() {
      this.getInput();
      this.executeOperations();
   }
}
