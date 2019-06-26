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
      getInputs(operations);
   }

   public void getInputs(String input) {
      this.operations = input.split(","); // Quebra a string em um array de strings
   }

   public void executeOperations() {
      for (String operation : this.operations) {
         int address = Integer.parseInt(String.valueOf(operation.charAt(0)));

         if (operation.charAt(2) == 'R') { // Leitura
            mmu.read(this.firstAddressMemory, address, pid);
         } else if (operation.charAt(2) == 'W') { // Escrita
            mmu.write(this.firstAddressMemory, address, pid, Integer.parseInt(operation.substring(4)));
         }
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public void run() {
      this.executeOperations();
   }
}
