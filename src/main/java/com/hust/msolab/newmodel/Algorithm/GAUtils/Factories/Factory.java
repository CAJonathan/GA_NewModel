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
            }

            case 2:{
                fn = new Fitness2();
            }

            case 3:{
                fn = new Fitness3();
            }

            case 4:{
                fn = new Fitness4();
            }

            case 5:{
                fn = new Fitness5();
            }

            case 6:{
                fn = new Fitness6();
            }
        }


        return fn.execute(chromosome);
    }

    public Pair<Individual, Individual> crossover(Individual indDad, Individual indMom){
        CrossoverOperator crO;
        switch (Factors.GA_CHOSEN_CROSSOVER_FUNCTION){
            default: {
                crO = new CircleCrossover();
            }

            case 2:{
                crO = new SimpleCrossover();
            }

            case 3:{
                crO = new MixedCrossover();
            }
        }

        return crO.execute(indDad, indMom);
    }

    public ArrayList<Integer> mutation(ArrayList<Integer> chromosome){
        MutationOperator mtO;
        switch (Factors.GA_CHOSEN_MUTATION_FUNCTION){
            default:{
                mtO = new CimMutation();
            }

            case 2:{
                mtO = new NormalMutation();
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
            }

            case 2:{
                nsO = new RouletteWheelSelection();
            }
        }

        return nsO.execute(individuals);
    }
}
