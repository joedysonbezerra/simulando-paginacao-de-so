public interface MMUI {
   MemoryManagementUnit(int size);

   public void read(int address, int pid);

   public void write(int address, int pid);
}
