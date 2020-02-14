import java.util.ArrayList;
import csis4463.*;
import java.util.stream.*;
import java.util.HashMap;

public class Assignment4 {

    public static void main (String[]args){
        Assignment4 a4 = new Assignment4();
        String [] names= new String [4];
        names[0]="length";
        names[1]="expanded";
        names[2]="memory";
        names[3]="generated";

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For A* Misplaced Tiles");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.AStarMTNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }
        System.out.println();

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For A* Manhattan Distance");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.AStarMDNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }
        System.out.println();

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For Iterative Deepening");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.IDNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }
        System.out.println();

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For ID Misplaced Tiles");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.IDMTNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }
        System.out.println();

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For ID Manhattan Distance");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.IDMDNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }
        System.out.println();

        for(String temp: names) {
            System.out.format("%13s", temp);
        }
        System.out.println("    For Uniformed Cost Search");
        for(int i=1 ; i<7 ; i++) {
            ArrayList<SlidingTilePuzzle> puzzleList = a4.puzzleListMake(3, 3, i*2, 100);
            for (int temp : a4.USCNumbers(puzzleList)) {
                System.out.format("%13s",temp);
            }
            System.out.println();
        }


    }

    public ArrayList<SlidingTilePuzzle> puzzleListMake(int row, int col, int path,int listSize){
        ArrayList<SlidingTilePuzzle> puzzleList= new ArrayList<>();
        for (int i =0; i<listSize ; i++) {
            SlidingTilePuzzle temp = new SlidingTilePuzzle(row, col, path);
            puzzleList.add(temp);
        }
        return puzzleList;
    }

    public int[] AStarMTNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
         int [] returns = new int [4];
         int [] expanded = new int [puzzleList.size()];
         int [] generated = new int [puzzleList.size()];
         int [] memory = new int [puzzleList.size()];
         int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.AStarSearchMisplacedTiles(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

    public int[] AStarMDNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
        int [] returns = new int [4];
        int [] expanded = new int [puzzleList.size()];
        int [] generated = new int [puzzleList.size()];
        int [] memory = new int [puzzleList.size()];
        int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.AStarSearchManhattanDistance(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

    public int[] USCNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
        int [] returns = new int [4];
        int [] expanded = new int [puzzleList.size()];
        int [] generated = new int [puzzleList.size()];
        int [] memory = new int [puzzleList.size()];
        int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.uniformCostSearch(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

    public int[] IDNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
        int [] returns = new int [4];
        int [] expanded = new int [puzzleList.size()];
        int [] generated = new int [puzzleList.size()];
        int [] memory = new int [puzzleList.size()];
        int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.iterativeDeepening(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

    public int[] IDMTNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
        int [] returns = new int [4];
        int [] expanded = new int [puzzleList.size()];
        int [] generated = new int [puzzleList.size()];
        int [] memory = new int [puzzleList.size()];
        int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.idaStarMisplacedTiles(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

    public int[] IDMDNumbers(ArrayList<SlidingTilePuzzle> puzzleList){
        int [] returns = new int [4];
        int [] expanded = new int [puzzleList.size()];
        int [] generated = new int [puzzleList.size()];
        int [] memory = new int [puzzleList.size()];
        int [] length = new int [puzzleList.size()];
        for(int i=0 ; i<puzzleList.size() ; i++){
            PuzzleSolution solution = SlidingTilePuzzleSolver.idaStarManhattanDistance(puzzleList.get(i));
            expanded[i] = solution.getNumberOfStatesExpanded();
            generated[i]=(int)solution.getNumGenerated();
            memory[i] = solution.getNumberOfStatesInMemory();
            length[i] = solution.getPathLength();
        }
        returns[0]=IntStream.of(length).sum()/length.length;
        returns[1]=IntStream.of(expanded).sum()/expanded.length;
        returns[2]=IntStream.of(memory).sum()/memory.length;
        returns[3]=IntStream.of(generated).sum()/generated.length;

        return returns;
    }

}