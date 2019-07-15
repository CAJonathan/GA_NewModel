package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Crossover;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import org.javatuples.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  Lai ghép một điểm cắt. Chọn ra một điểm cắt trên nhiễm sắc thể cha, chia nst cha thành 2 đoạn. Copy đoạn
 * thứ nhất vào nst con, các gene trong nhiễm sắc thể con còn thiếu thì lấy từ nst mẹ theo đúng thứ tự ta được
 * một nhiễm sắc thể con. làm lại quá trình trên nhưng thay đổi vai trò của cha mẹ, ta được nst con tiếp theo.
 * Ví dụ:
 * p1 = (1, 4, 3, 6, 7, 2, 5)
 * p2 = (4, 3, 7, 5, 1, 2, 6)
 * Chọn được điểm cắt là 3, ta được 2 nst con:
 * c1 = (1, 4, 3, 7, 5, 2, 6)
 * c2 = (4, 3, 7, 1, 6, 2, 5)
 */

public class SimpleCrossover implements CrossoverOperator {

    public Pair<Individual, Individual> execute(Individual indDad, Individual indMom){
        List<Integer> dad = indDad.getChromosome();
        List<Integer> mom = indMom.getChromosome();
        int numOfGene = dad.size();

        Integer[] child1 = new Integer[numOfGene];
        Integer[] child2 = new Integer[numOfGene];

        int cuttingPoint = (new Random()).nextInt(numOfGene - 2) + 1;
        boolean[] visited1 = new boolean[numOfGene + 1];
        boolean[] visited2 = new boolean[numOfGene + 1];
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        for(int i = 0 ; i < cuttingPoint ; i ++){
            int gene1 = dad.get(i);
            int gene2 = mom.get(i);
            child1[i] = gene1;
            child2[i] = gene2;
            visited1[gene1] = true;
            visited2[gene2] = true;
        }

        for(int i = cuttingPoint ; i < numOfGene ; i ++){
            for(Integer gene1 : mom){
                if(!visited1[gene1]){
                    child1[i] = gene1;
                    visited1[gene1] = true;
                    break;
                }
            }

            for(Integer gene2 : dad){
                if(!visited2[gene2]){
                    child2[i] = gene2;
                    visited2[gene2] = true;
                    break;
                }
            }
        }

        return new Pair<>(new Individual(Arrays.asList(child1)), new Individual(Arrays.asList(child2)));
    }
}
