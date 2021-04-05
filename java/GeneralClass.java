public class GeneralClass<T> {
    private T t;

    public T getT(){
        return t;
    }
    public void setT(T t){
        this.t = t;
    }


    public static void main(String [] args){

        GeneralClass<String> a= new GeneralClass<>();
        a.setT("hah");
        System.out.println(a.getT());

        GeneralClass<Integer> b = new GeneralClass<>();
        b.setT(12);
        System.out.println(b.getT());
    }
}
