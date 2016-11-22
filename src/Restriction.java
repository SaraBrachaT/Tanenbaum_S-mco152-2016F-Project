
public enum Restriction {
  Not_Window("Gets cold, does not want to sit near a window"), 
  Want_Window("Gets hot, would like to sit near window"), 
  Want_Head("Must sit at the head of the table"),
  Want_Mommy("Wants to sit near Mommy"),
  See_Abba("Should sit next to or across from Abba"),
  Bro_Fight("Brothers fight and should not sit next to/across from each other.");
  
  private String description;
  
  private Restriction(String description){
   this.description = description;
  }
  
  public String getRestrictionDescr(){
   return this.description;
  }
  
  
 
   
}