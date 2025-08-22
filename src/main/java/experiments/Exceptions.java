package experiments;

public class Exceptions {
    public static void main(String[] args) {
        String[] strArray = {"str1", "str2", "str3"};
        uncheckedExceptionStr(strArray);
        try {
            pause();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private static void uncheckedExceptionStr(String[] str){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(str[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Created exception!");
        }
        System.out.println("Program is working");

    }
    private static void pause() throws InterruptedException {
        checkedException();
        System.out.println("pause 3 sec");
    }

    private static void checkedException() throws InterruptedException {
        Thread.sleep(3000);
    }
    private String first(String s){
        return null;
    }
}
