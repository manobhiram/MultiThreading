


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinNoReturn extends RecursiveAction {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

    public ForkJoinNoReturn(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 1) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<ForkJoinNoReturn> subtasks =
                new ArrayList<ForkJoinNoReturn>();

            subtasks.addAll(createSubtasks());

            for(RecursiveAction subtask : subtasks){
                subtask.fork();
                
                
            }

        } else {
            System.out.println("thread is" + Thread.currentThread().getName()+" Doing workLoad myself: " + this.workLoad);
        }
    }

    private List<ForkJoinNoReturn> createSubtasks() {
        List<ForkJoinNoReturn> subtasks =
            new ArrayList<ForkJoinNoReturn>();

        ForkJoinNoReturn subtask1 = new ForkJoinNoReturn(this.workLoad / 2);
        ForkJoinNoReturn subtask2 = new ForkJoinNoReturn(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }

    
    public static void main(String[] args) {
    	System.out.println("hello is " + Runtime.getRuntime().availableProcessors());
    	ForkJoinPool forkJoinPool = new ForkJoinPool();
    	ForkJoinNoReturn myRecursiveAction = new ForkJoinNoReturn(8);

    	forkJoinPool.invoke(myRecursiveAction);
	}
}

