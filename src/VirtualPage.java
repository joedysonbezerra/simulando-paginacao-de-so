class VirtualPage {
   private boolean reference;
   private boolean modify;
   private boolean isPresent;
   private int pageFrameNumber;
   private SharedValue counter;

   public VirtualPage() {
      this.counter = new SharedValue();
   }

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

   public int getPageFrameNumber() {
      return pageFrameNumber;
   }

   public void setPageFrameNumber(int pageFrameNumber) {
      this.pageFrameNumber = pageFrameNumber;
   }

   public void setCounter() {
      this.counter.setValue(this.counter.getValue() + 1);
   }

}
