import java.util.ArrayList;

class MemoryManagementUnit implements MMUI {
   VirtualMemory virtualMemory;
   PhysicalMemory ramMemory;
   HardDisk HD;
   LeastRecentlyUsed LRU;

   MemoryManagementUnit(int size) {
      this.virtualMemory = new VirtualMemory(size);
      this.ramMemory = new PhysicalMemory(size / 2);
      this.HD = new HardDisk();
      this.LRU = new LeastRecentlyUsed();
      new Thread(new Log(virtualMemory, ramMemory, HD)).start();
   }

   public void read(int firstAddressVirtualMemory, int address, int pid) {
      VirtualPage page = this.virtualMemory.getPage(firstAddressVirtualMemory + address);
      if (!page.isPresent()) {
         System.out.println("Page Fault!");
         int response = this.ramMemory.isFull();
         if (response == -1) {
            VirtualPage swapPage = this.LRU.swap();
            int swapAddress = swapPage.getPageFrameNumber();
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), swapAddress);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            page.setPageFrameNumber(swapAddress);
            this.LRU.setLru(page);
         } else {
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), response);
            page.setPageFrameNumber(response);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            this.LRU.setLru(page);
         }
      } else {
         page.setReference(true);
         page.setCounter();
      }
   };

   public void write(int firstAddressVirtualMemory, int address, int pid, int value) {
      System.out.println("Escrita no Processo - " + pid + "Endereço - " + address + " Valor - " + value);
      VirtualPage page = this.virtualMemory.getPage(firstAddressVirtualMemory + address);
      if (!page.isPresent()) {
         System.out.println("Page Fault!");
         int response = this.ramMemory.isFull();
         if (response == -1) {
            VirtualPage swapPage = this.LRU.swap();
            int swapAddress = swapPage.getPageFrameNumber();
            this.ramMemory.setPhysicalMemory(value, swapAddress);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            page.setPageFrameNumber(swapAddress);
            this.LRU.setLru(page);
         } else {
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), response);
            page.setPageFrameNumber(response);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            this.LRU.setLru(page);
         }
      } else {
         page.setModify(true);
         page.setPresent(true);
         page.setReference(true);
         page.setCounter();
         this.HD.setProcessData(pid, address, value);
         this.ramMemory.setPhysicalMemory(value, page.pageFrameNumber());
      }
   };
}
