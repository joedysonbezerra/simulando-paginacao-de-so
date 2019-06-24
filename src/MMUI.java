public interface MMUI {
   MemoryManagementUnit(int size);

   public void read(int firstAddressVirtualMemory, int address, int pid);

   public void write(int firstAddressVirtualMemory, int address, int pid, int value);
}
