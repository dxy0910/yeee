class Single{
    private static Single INSTANCE=new Single ( ) ;
    private Single ( )  { }
    public static Single getInstance ( ) {
       return TNSTANCE;
   }
}
class Example15 {
    public static void main(String[ ] args) {
      Single s1=Single.getInstance ( );
      Single s2=Single.getInstance ( );
      system.out.println(s1==s2);
  }
}