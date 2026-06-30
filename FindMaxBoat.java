import java.util.Scanner;
import java.util.Arrays;
public class FindMaxBoat{
    public static void main(String[] args) throws NotValidValue{
        Scanner  sc = new Scanner(System.in);
        System.out.print("Enter the number of weights: ");
        int n = sc.nextInt();
        System.out.print("Enter maximum weight for single boat: ");
        int limit = sc.nextInt();
        System.out.println("A single weight must be less than or equal to limit");
        int weights[] = new int[n];
        for(int i=0; i<n; i++){
            boolean isValidInput = false;
           
            while(! isValidInput){
                try{
                    System.out.print("Enter weight"+(i+1)+":");
                    int value = sc.nextInt();
                    if(value > limit ){
                        throw new NotValidValue("value more than limit");
                    }
                    else if(value < 1){
                        throw new NotValidValue("Weight must greater than or equal to one");
                    }
                    weights[i]= value;
                    isValidInput = true;
                    
                }

                catch(NotValidValue e){
                    System.out.println("Invalid: "+e.getMessage()+ ", please try again!!");
                }
            }

        }


        Arrays.sort(weights);
        int left = 0;
        int right = n-1;
        int boatCount = 0;
        while(left <= right){
            if((weights[left]+weights[right])<=limit){
                left++;
            }
            right--;
            boatCount++;
        }
        System.out.println("Number of Boat: "+boatCount);
    }

}

    class NotValidValue extends Exception{
        public NotValidValue(String msg){
            super(msg);
        }
}