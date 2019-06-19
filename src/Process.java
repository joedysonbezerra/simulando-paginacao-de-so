import java.util.Objects;

class Process extends Thread {
   private int pid;
   private int firstAddressMemory;
   private MemoryManagementUnit mmu;
   private String operations[];

   public void getInput() {
      String input = "5-R,6-R,7-R,2-W,1-W,3-R,6-W,1-W,0-R,1-W,0-W,4-R,5-R,7-W,1-R,2-W";
      this.operations = input.split(",");
   }

   public void executeOperations() {
      for (String operation : this.operations) {
         if (Objects.equals(operation.substring(2), "R")) {
            mmu.read();
         } else {
            mmu.write();
         }
      }
   }

   @Override
   public void run() {
      this.getInput();
      this.executeOperations();
   }
}
