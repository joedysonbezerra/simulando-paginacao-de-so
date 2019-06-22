class VirtualPage {
   private boolean reference;
   private boolean modify;
   private boolean isPresent;
   private int pageFrameNumber;
   private int counter = 0;

   public boolean isReference() {
      return reference;
   }

   public void setReference(boolean reference) {
      this.reference = reference;
   }

   public boolean isModify() {
      return modify;
   }

   public void setModify(boolean modify) {
      this.modify = modify;
   }

   public boolean isPresent() {
      return isPresent;
   }

   public void setPresent(boolean isPresent) {
      this.isPresent = isPresent;
   }

   public int pageFrameNumber() {
      return pageFrameNumber;
   }

   public void setPageFrameNumber(int pageFrameNumber) {
      this.pageFrameNumber = pageFrameNumber;
   }

   public int getPageFrameNumber() {
      return pageFrameNumber;
   }

   public int getCounter() {
      return counter;
   }

   public void setCounter() {
      this.counter = 0;
   }

   public void increaseCounter() {
      this.counter++;
   }
}
