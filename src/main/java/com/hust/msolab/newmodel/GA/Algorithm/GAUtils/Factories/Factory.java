package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Factories;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Crossover.*;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Fitness.*;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation.CimMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation.MixedMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation.NormalMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.Mutation.ShufflingSegmentMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.NaturalSelection.MixednaturalSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.NaturalSelection.NormalNaturalSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.NaturalSelection.RouletteWheelSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection.MixedParentsSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection.RandomlyParentsSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.*;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Implemented.ParentsSelection.TounamentSelection;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.util.List;

/**
 *  Factory chung của các toán tử trong thuật toán GA, mỗi toán tử mới được viết thêm đều phải
 * được đăng kí trong các hàm tương ứng với toán tử đó
 *
 * @author sondn on 30/04/2019
 */

public class Factory {

    public double fitness(List<Integer> chromosome){
        FitnessFunction fn;
        switch (Factors.GA_CHOSEN_FITNESS_FUNCTION){
            default:{
                fn = new Fitness1();
                break;
            }

            case 2:{
                fn = new Fitness2();
                break;
            }

            case 3:{
                fn = new Fitness3();
                break;
            }

            case 4:{
                fn = new Fitness4();
                break;
            }

            case 5:{
                fn = new Fitness5();
                break;
            }

            case 6:{
                fn = new Fitness6();
                break;
            }

            case 7:{
                fn = new Fitness7();
                break;
            }

            case 8:{
                fn = new Fitness8();
                break;
            }
        }


        return fn.execute(chromosome);
    }

    public Pair<Individual, Individual> crossover(Individual indDad, Individual indMom){
        CrossoverOperator crO;
        switch (Factors.GA_CHOSEN_CROSSOVER_FUNCTION){
            default: {
                crO = new CircleCrossover();
                break;
            }

            case 2:{
                crO = new SimpleCrossover();
                break;
            }

            case 3:{
                crO = new MixedCrossover();
                break;
            }

            case 4:{
                crO = new RmxCrossover();
                break;
            }

            case 5:{
                crO = new MixedCrossoverV2();
                break;
            }

            case 6:{
                crO = new PositionCrossover();
                break;
            }
        }

        return crO.execute(indDad, indMom);
    }

    public List<Integer> mutation(List<Integer> chromosome){
        MutationOperator mtO;
        switch (Factors.GA_CHOSEN_MUTATION_FUNCTION){
            default:{
                mtO = new CimMutation();
                break;
            }

            case 2:{
                mtO = new NormalMutation();
                break;
            }

            case 3:{
                mtO = new MixedMutation();
                break;
            }

            case 4:{
                mtO = new ShufflingSegmentMutation();
                break;
            }
        }

        return mtO.execute(chromosome);
    }

    public List<Individual> naturalSelection(List<Individual> individuals){
        NaturalSelectionOperator nsO;
        switch (Factors.GA_CHOSEN_NATURAL_SELECTION_FUNCTION){
            default:{
                nsO = new NormalNaturalSelection();
                break;
            }

            case 2:{
                nsO = new RouletteWheelSelection();
                break;
            }

            case 3:{
                nsO = new MixednaturalSelection();
                break;
            }
        }

        return nsO.execute(individuals);
    }

    public List<Pair<Individual, Individual>> parentsSelection(int numOfPair, List<Individual> individuals){
        ParentsSelectionOperator psO;
        switch (Factors.GA_CHOSEN_PARENTS_SELECTION_FUNCTION){
            default:{
                psO = new TounamentSelection();
                break;
            }

            case 2:{
                psO = new RandomlyParentsSelection();
                break;
            }

            case 3:{
                psO = new MixedParentsSelection();
                break;
            }
        }

        return psO.execute(numOfPair, individuals);
    }
}
