package com.hust.msolab.newmodel.Algorithm.GAUtils.Factories;

import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Crossover.CircleCrossover;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Crossover.MixedCrossover;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Crossover.SimpleCrossover;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Fitness.*;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Mutation.CimMutation;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Mutation.MixedMutation;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.Mutation.NormalMutation;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.NaturalSelection.NormalNaturalSelection;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.NaturalSelection.RouletteWheelSelection;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.CrossoverOperator;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.FitnessFunction;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.MutationOperator;
import com.hust.msolab.newmodel.Algorithm.GAUtils.Operators.OperatorInterfaces.NaturalSelectionOperator;
import com.hust.msolab.newmodel.Algorithm.Individual;
import com.hust.msolab.newmodel.Utilities.Factors;
import org.javatuples.Pair;

import java.util.ArrayList;

public class Factory {

    public double fitness(ArrayList<Integer> chromosome){
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

    public ArrayList<Integer> mutation(ArrayList<Integer> chromosome){
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

    public ArrayList<Individual> naturalSelection(ArrayList<Individual> individuals){
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
}
