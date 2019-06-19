import java.util.ArrayList;

class VirtualMemory {
   ArrayList<VirtualPage> virtualMemory;

   public VirtualMemory(int size) {
      this.virtualMemory = new ArrayList<VirtualPage>();

      for (int i = 0; i < size; i++) {
         VirtualPage page = new VirtualPage();
         this.virtualMemory.add(page);
      }
   }

   public void printVirtualMemory() {
      System.out.println(">>>>> Memória Virtual <<<<<<");
      virtualMemory.forEach(page -> System.out.println("[ " + page.isReference() + ", " + page.isModify() + ", "
            + page.isPresent() + ", " + page.pageFrameNumber() + " ],"));
      System.out.println(">>>>> Memória Virtual - FIM <<<<<<");
   }
}
