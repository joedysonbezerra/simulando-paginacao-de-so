import java.util.Objects;

class Process extends Thread {
   private int pid;
   private int firstAddressMemory;
   private MMUI mmu;
   private String operations[];

   Process(int pid, int firstAddressMemory, MMUI mmu, String operations) {
      this.pid = pid;
      this.firstAddressMemory = firstAddressMemory;
      this.mmu = mmu;
      getInput(operations);
   }

   public void getInput(String input) {
      this.operations = input.split(",");
   }

   public void executeOperations() {
      for (String operation : this.operations) {
         int address = firstAddressMemory + Integer.parseInt(String.valueOf(operation.charAt(0)));
         if (operation.charAt(2) == 'R') {
            mmu.read(address, pid);
         } else if (operation.charAt(2) == 'W') {
            mmu.write(address, pid, Integer.parseInt(operation.substring(4)));
         }
      }
   }

   @Override
   public void run() {
      this.executeOperations();
   }
}
