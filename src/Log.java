import java.util.Random;

class Log implements Runnable {

   VirtualMemory virtualMemory;
   PhysicalMemory ramMemory;

   Log(VirtualMemory vm, PhysicalMemory rm) {
      this.virtualMemory = vm;
      this.ramMemory = rm;
   }

   @Override
   public void run() {
      while (true) {
         virtualMemory.printVirtualMemory();
         ramMemory.printPhysicalMemory();
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
