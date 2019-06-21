class SO {
   public static final int SIZE = 16; // Tamanho da Mémoria Virtual
   public static final int quantityProcess = 2; // Quantidade de Processos

   public static void main(String[] args) {
      MemoryManagementUnit mmu = new MemoryManagementUnit(SIZE);

      int processMemory = SIZE / quantityProcess;

      for (int i = 0; i < quantityProcess; i++) {
         new Process(i, (i * processMemory), mmu).start();
         mmu.HD.setHD(processMemory);
      }

   }
}
