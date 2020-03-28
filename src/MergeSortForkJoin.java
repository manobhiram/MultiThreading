
public class MergeSortForkJoin {

	public static void main(String[] args) {
		int[] arr = {12, 11, 17,1, 9, 13, 5, 6, 7};
		mergesort(arr,0,arr.length-1);
		
		for(int i : arr){
			System.out.print(i);
			System.out.print(" ");
		}
		
	}
	
	public static void mergesort(int[] arr,int l, int m){
		
		if(l<m)
		{
			int n= (l+m)/2;
			
			mergesort(arr,l,n);
			mergesort(arr,n+1,m);
			
			merge(arr,l,n,m);
		}
	}
	
	
	public static void merge(int[] arr,int l,int m,int r){
	
		int n1= m-l+1;
		int n2 = r-m;
		
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		
		
		for(int i=0;i<n1;i++)
		{
			arr1[i] = arr[l+i];
		}
		for(int i=0;i<n2;i++)
		{
			arr2[i] = arr[m+1+i];
		}
		int k = l;
		int i=0,j=0;
		while(i<n1 && j<n2)
		{
			if(arr1[i] <= arr2[j]){
				arr[k] = arr1[i];
				i++;
			}
			else{
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
           arr[k]= arr1[i];
           i++;
           k++;
		}
		while(j<n2){
	           arr[k]= arr2[j];
	           j++;
	           k++;
			}
		
		
	}
}
