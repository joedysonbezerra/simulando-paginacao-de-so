import java.util.ArrayList;

class VirtualMemory {
   ArrayList<VirtualPage> vm;
   SharedValue v;

   public VirtualMemory(int size) {
      this.vm = new ArrayList<VirtualPage>(size);

      for (int i = 0; i < size; i++) {
         VirtualPage page = new VirtualPage();
         this.vm.add(page);
      }
      SharedValue t = new SharedValue(1);
      v = t;
      System.out.println(t.getValue());
      System.out.println(v.getValue());
      t.setValue(2);
      System.out.println(t.getValue());
      System.out.println(v.getValue());

   }
}
