public class data_sorting_1 {
    public static void printArray(int arr[]){
for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
}
    }
public static void main(String[] args) {
       int arr[]={2,4,1,7,3,9,6,5};
       //bubble sort
       for(int i=0;i<arr.length-1;i++){
        for(int j=0;j<arr.length-i-1;j++){
            if(arr[j]>arr[j+1]){
                //swap
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
       }
       printArray(arr);
}
}
