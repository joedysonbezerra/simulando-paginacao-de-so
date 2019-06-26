import java.util.Vector;

class LeastRecentlyUsed {
   Vector<VirtualPage> lru;

   LeastRecentlyUsed() {
      this.lru = new Vector<VirtualPage>();
      new Thread(new Time(this.lru)).start();
   }

   // Escolhe qual página será retirado da mémoria ram
   public VirtualPage swap() {
      VirtualPage page = this.lru.lastElement();
      this.lru.remove(this.lru.size() - 1);
      page.setCounter();
      page.setPresent(false);
      page.setReference(false);
      page.setModify(false);
      System.out.println("Troca - " + page.getPageFrameNumber());
      return page;
   }

   public void setLru(VirtualPage page) {
      this.lru.add(page);
   }

}
