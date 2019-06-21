class MemoryManagementUnit implements MMUI {
   VirtualMemory virtualMemory;
   PhysicalMemory ramMemory;
   HardDisk HD;

   MemoryManagementUnit(int size) {
      this.virtualMemory = new VirtualMemory(size);
      this.ramMemory = new PhysicalMemory(size / 2);
      this.HD = new HardDisk();
      new Thread(new Log(virtualMemory, ramMemory, HD)).start();
   }

   public void read(int address, int pid) {
      System.out.println("Leitura");
   };

   public void write(int address, int pid) {
      System.out.println("Escrita");
   };
}
