package com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Factories;

import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Crossover.CircleCrossover;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Crossover.MixedCrossover;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Crossover.SimpleCrossover;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Fitness.*;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Mutation.CimMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Mutation.MixedMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.Mutation.NormalMutation;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.NaturalSelection.NormalNaturalSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.NaturalSelection.RouletteWheelSelection;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.OperatorInterfaces.*;
import com.hust.msolab.newmodel.GA.Algorithm.GAUtils.Operators.ParentsSelection.TounamentSelection;
import com.hust.msolab.newmodel.GA.Algorithm.Individual;
import com.hust.msolab.newmodel.GA.Utilities.Factors;
import org.javatuples.Pair;

import java.util.List;

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
            }
        }

        return nsO.execute(individuals);
    }

    public List<Pair<Individual, Individual>> parentsSelection(int numOfPair, List<Individual> individuals){
        ParentsSelectionOperator psO;
        switch (Factors.GA_CHOSEN_PARENTS_SELECTION_FUNCTION){
            default:{
                psO = new TounamentSelection();
            }
        }

        return psO.execute(numOfPair, individuals);
    }
}
