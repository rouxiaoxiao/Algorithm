package groceries;

public class DupNum {
    public static void main(String[] args) {
        int[] numbers = {2,4,3,1,4};
        int length = numbers.length;
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers,length,duplication));
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0; i<length; i++){
            if(numbers[i]>=length){
                numbers[i]=numbers[i]-length;
                if(numbers[numbers[i]]>=length||numbers[i]==i){
                    duplication[0]=numbers[i];
                    return true;
                }
                numbers[i]=numbers[i]+length;
            }else{
                if(numbers[numbers[i]]>=length){
                    duplication[0]=numbers[i];
                    return true;
                }
                numbers[numbers[i]]=numbers[numbers[i]]+length;
            }
        }
        return false;
    }
}
