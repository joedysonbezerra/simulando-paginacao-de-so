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

   public void read(int address, int pid) {
      System.out.println("Leitura - " + address);
   };

   public void write(int address, int pid, int value) {
      System.out.println("Escrita - " + address + " Value - " + value);
   };
}
