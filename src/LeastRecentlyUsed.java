import java.util.Vector;

class LeastRecentlyUsed {
   Vector<VirtualPage> lru;

   LeastRecentlyUsed() {
      this.lru = new Vector<VirtualPage>();
      new Thread(new Time(this.lru)).start();
   }

   public int swap() {
      page = this.lru.lastElement();
      this.lru.remove(this.lru.size() - 1);
      return page.getPageFrameNumber();
   }

   public void setLru(VirtualPage page) {
      // existe
      if (page == lru) {
         page.setCounter();
      } else {
         this.lru.add(page);
      }

   }

}
