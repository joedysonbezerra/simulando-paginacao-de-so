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
      // Acessa o endereço da mémoria virtual no index passado como parametro mémoria
      // virtual
      VirtualPage page = this.virtualMemory.getPage(firstAddressVirtualMemory + address);

      // Verifica se página não está presente na mémoria virtual
      if (!page.isPresent()) {
         System.out.println("Page Fault!");
         int response = this.ramMemory.isFull();

         if (response == -1) {// Mémoria Cheia não tem endereços disponivel
            VirtualPage swapPage = this.LRU.swap();
            int swapAddress = swapPage.getPageFrameNumber(); // pode usar esse endereço
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), swapAddress);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            page.setPageFrameNumber(swapAddress);
            this.LRU.setLru(page);
         } else { // Há espaço disponivel na mémoria
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), response);
            page.setPageFrameNumber(response);
            page.setPresent(true);
            page.setReference(true);
            page.setCounter();
            this.LRU.setLru(page);
         }
      } else {// Já está na mémoria ram
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
         if (response == -1) {// Mémoria Cheia não tem endereços disponivel

            VirtualPage swapPage = this.LRU.swap();
            int swapAddress = swapPage.getPageFrameNumber(); // pode usar esse endereço
            this.ramMemory.setPhysicalMemory(value, swapAddress);
            page.setPresent(true);
            page.setReference(true);
            page.setModify(true);
            page.setCounter();
            page.setPageFrameNumber(swapAddress);
            this.HD.setProcessData(pid, address, value);
            this.LRU.setLru(page);
         } else {
            this.ramMemory.setPhysicalMemory(this.HD.getProcessData(pid, address), response);
            page.setPageFrameNumber(response);
            page.setPresent(true);
            page.setModify(true);
            page.setReference(true);
            page.setCounter();
            this.HD.setProcessData(pid, address, value);
            this.LRU.setLru(page);
         }
      } else {// Já está na mémoria ram só modifica o valor
         page.setModify(true);
         page.setPresent(true);
         page.setReference(true);
         page.setCounter();
         this.HD.setProcessData(pid, address, value);
         this.ramMemory.setPhysicalMemory(value, page.pageFrameNumber());
      }
   };
}
