import Utilities.Factors;
import org.javatuples.Pair;
import java.util.*;

public class Individual {
    private ArrayList<Integer> chromosome;
    private double fitnessScore;

    public Individual(int numOfGene) {
        chromosome = new ArrayList<>();
        for(int i = 1 ; i <= numOfGene ; i ++){
            chromosome.add(i);
        }
        Collections.shuffle(chromosome);
        calculateFitnessScore();
    }

    public Individual(List<Integer> chromosome){
        this.chromosome = new ArrayList<>(chromosome);
        calculateFitnessScore();
    }

    public ArrayList<Integer> getChromosome() {
        return chromosome;
    }

    public void setGene(int index, int gene) {
        chromosome.set(index, gene);
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public void calculateFitnessScore() {
        fitnessScore = 0.0;
        int numOfGenes = chromosome.size();
//        standardize();
        for(int i = 0 ; i < numOfGenes ; i ++) {
            int current = chromosome.get(i);
            int previous = i == 0 ? 0 : chromosome.get(i - 1);
            fitnessScore += Factors.ALPHA / (Factors.remainingEnergy.get(current)) + (1 - Factors.ALPHA) * Factors.K / (Main.distances[previous][current]);
        }
    }

//    private void standardize(){
//        for(int i = 0 ; i < chromosome.size() ; i ++){
//            if(chromosome.get(i) == 0){
//                Collections.swap(chromosome, 0, i);
//            }
//        }
//
//        for(int i = chromosome.size() - 1 ; i > 0 ; i --){
//            if(chromosome.get(i) == 0){
//                Collections.swap(chromosome, i, chromosome.size() - 1);
//            }
//        }
//    }

    public void normalMutate() {
        Random rand = new Random();
        int f = rand.nextInt(chromosome.size());
        int s = rand.nextInt(chromosome.size());

        Collections.swap(chromosome, f, s);
    }

    public void cimMutate() {
        int numOfGene = chromosome.size();
        Random rand = new Random();
        int wall = rand.nextInt(numOfGene);
        ReverseGeneSegment(0, wall - 1);
        ReverseGeneSegment(wall, numOfGene - 1);
        calculateFitnessScore();
    }

    private void ReverseGeneSegment(int start, int end) {
        int i = start;
        int j = end;

        while(i < j) {
            Collections.swap(chromosome, i, j);
            i ++;
            j --;
        }
    }

    public Individual rmxReproduct(Individual partner) {
        Random rand = new Random();

        ArrayList<Integer> dadChromosome = this.chromosome;
        int numOfGenes = dadChromosome.size();

        ArrayList<Integer> momChromosome = partner.getChromosome();
        boolean [] isInOffspringChromosome = new boolean[numOfGenes];
        Arrays.fill(isInOffspringChromosome, false);

        Individual offspring = new Individual(numOfGenes);
        boolean [] isEmptyPosition = new boolean[numOfGenes];
        Arrays.fill(isEmptyPosition, true);

        int rmx = rand.nextInt(numOfGenes/2);
        int beginPosition = rand.nextInt(numOfGenes - rmx);
        int endPosition = beginPosition + rmx;

        for(int i = beginPosition ; i < endPosition ; i ++) {
            offspring.setGene(i, dadChromosome.get(i));
            isEmptyPosition[i] = false;
            isInOffspringChromosome[dadChromosome.get(i)] = true;
        }

        for(int i = beginPosition ; i < endPosition ; i ++) {
            int gene = momChromosome.get(i);

            if(isInOffspringChromosome[gene]) {
                continue;
            } else {
                int freeIndex = i;
                while(!isEmptyPosition[freeIndex]) {
                    freeIndex = momChromosome.indexOf(dadChromosome.get(freeIndex));
                }

                offspring.setGene(freeIndex, gene);
                isEmptyPosition[freeIndex] = false;
                isInOffspringChromosome[gene] = true;
            }
        }

        int i = 0, j = 0;
        while(i < numOfGenes){
            if(!isInOffspringChromosome[momChromosome.get(i)]){
                while(j < numOfGenes && !isEmptyPosition[j]){
                    j ++;
                }
                offspring.setGene(j, momChromosome.get(i));
                isEmptyPosition[j] = false;
                isInOffspringChromosome[momChromosome.get(i)] = true;
            }
            i ++;
        }

        offspring.calculateFitnessScore();
        return offspring;
    }

    public Pair<Individual, Individual> circleCrossover(Individual partner){
        ArrayList<Integer> dad = this.chromosome;
        ArrayList<Integer> mom = partner.getChromosome();
        int numOfGene = dad.size();
        Integer[] child1 = new Integer[numOfGene];
        Integer[] child2 = new Integer[numOfGene];

        boolean[] isInCircle = new boolean[numOfGene];
        Arrays.fill(isInCircle, false);
        int circleIndex = 0;
        int circleNumber = 0;
        while(circleIndex < numOfGene ){
            while(circleIndex < numOfGene && isInCircle[circleIndex]){
                circleIndex ++;
            }
            if(circleIndex >= numOfGene) break;
            circleNumber ++;

            int begin = dad.get(circleIndex);
            int currentIndex = circleIndex;
            int check;

            do{
                check = mom.get(currentIndex);
                child1[currentIndex] = circleNumber % 2 == 1 ? dad.get(currentIndex) : check;
                child2[currentIndex] = circleNumber % 2 == 1 ? check : dad.get(currentIndex);
                isInCircle[currentIndex] = true;
                currentIndex = dad.indexOf(check);
            }while(check != begin);
        }
        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
    }
}
