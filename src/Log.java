import java.util.Random;

class Log implements Runnable {

   VirtualMemory virtualMemory;
   PhysicalMemory ramMemory;
   HardDisk HD;

   Log(VirtualMemory vm, PhysicalMemory rm, HardDisk hd) {
      this.virtualMemory = vm;
      this.ramMemory = rm;
      this.HD = hd;
   }

   // Exibe os dados das mémorias na saída padrão
   @Override
   public void run() {
      while (true) {
         this.virtualMemory.printVirtualMemory();
         this.ramMemory.printPhysicalMemory();
         this.HD.printHardDisk();
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
