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
      page.setCounter();
      return page.getPageFrameNumber();
   }

   public void setLru(VirtualPage page) {
      this.lru.add(page);
   }

}
