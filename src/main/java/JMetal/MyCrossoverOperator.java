//package JMetal;
//
//import Algorithm.Individual;
//import org.javatuples.Pair;
//import org.uma.jmetal.operator.CrossoverOperator;
//import org.uma.jmetal.solution.PermutationSolution;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MyCrossoverOperator implements CrossoverOperator<PermutationSolution> {
//
//    public MyCrossoverOperator(){
//
//    }
//
//    @Override
//    public List<PermutationSolution> execute(List<PermutationSolution> permutationSolutions) {
//        PermutationSolution dad = permutationSolutions.get(0);
//        PermutationSolution mom = permutationSolutions.get(1);
//
//        int numOfGene = dad.getNumberOfVariables();
//        Integer[] child1 = new Integer[numOfGene];
//        Integer[] child2 = new Integer[numOfGene];
//
//        boolean[] isInCircle = new boolean[numOfGene];
//        Arrays.fill(isInCircle, false);
//        int circleIndex = 0;
//        int circleNumber = 0;
//        while(circleIndex < numOfGene ){
//            while(circleIndex < numOfGene && isInCircle[circleIndex]){
//                circleIndex ++;
//            }
//            if(circleIndex >= numOfGene) break;
//            circleNumber ++;
//
//            int begin = (int)dad.getVariableValue(circleIndex);
//            int currentIndex = circleIndex;
//            int check;
//
//            do{
//                check = (int)mom.getVariableValue(currentIndex);
//                child1[currentIndex] = circleNumber % 2 == 1 ? (int)dad.getVariableValue(currentIndex) : check;
//                child2[currentIndex] = circleNumber % 2 == 1 ? check : (int)dad.getVariableValue(currentIndex);
//                isInCircle[currentIndex] = true;
//                currentIndex = dad.indexOf(check);
//            }while(check != begin);
//        }
//
//        List<PermutationSolution> childs = new ArrayList<>();
//        childs.add( )
//        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
//    }
//
//    @Override
//    public int getNumberOfRequiredParents() {
//        return 2;
//    }
//
//    @Override
//    public int getNumberOfGeneratedChildren() {
//        return 2;
//    }
//}
